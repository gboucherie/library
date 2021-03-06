package org.nucco.library.rest.resource;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.nucco.library.bean.Group;
import org.nucco.library.bean.User;
import org.nucco.library.dao.api.UserDao;
import org.nucco.library.rest.bean.ResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/auth")
@ManagedBean
public class UserManagementResource {

	@GET
	@Path("/current_user")
	@Produces(MediaType.APPLICATION_JSON)
	public Response currentUser(@Context HttpServletRequest request) {
		ResponseWrapper<User> response = new ResponseWrapper<User>();

		Principal principal = request.getUserPrincipal();
		if (principal != null) {
			response.setData(userDao.find(principal.getName()));
			response.setStatus(true);
		} else {
			response.setStatus(false);
		}

		return Response.ok().entity(response).build();
	}

	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(@FormParam("credentials") String credentials, @Context HttpServletRequest request) {
		ResponseWrapper<User> response = new ResponseWrapper<User>();

		String[] tmp = (new String(Base64.decodeBase64(credentials))).split(":");
		String login = tmp[0];
		String password = tmp[1];

		// only login if not already logged in...
		if (request.getUserPrincipal() == null) {
			try {
				request.login(login, password);
			} catch (ServletException e) {
				LOG.warn(e.getMessage(), e);
				response.setStatus(false);
				response.setMessage("Authentication failed !");
				return Response.status(Status.UNAUTHORIZED).entity(response).build();
			}
		} else {
			LOG.info("Skip login because already logged in: {}", login);
		}

		User user = userDao.find(login);
		user.setPassword(null);

		response.setStatus(true);
		response.setData(user);
		response.setCount(1);

		return Response.ok().entity(response).build();
	}

	@GET
	@Path("/register")
	@Produces(MediaType.APPLICATION_JSON)
	public Response register() {
		List<Group> groups = new ArrayList<Group>();
		groups.add(Group.USER);
		groups.add(Group.ADMIN);

		User newUser = new User();
		newUser.setEmail("test2");
		newUser.setPassword(DigestUtils.sha512Hex("test2"));
		newUser.setFirstName("test2");
		newUser.setLastName("test2");
		newUser.setRegisteredOn(new Date());
		newUser.setActivated(true);
		newUser.setGroups(groups);

		userDao.add(newUser);

		return null;
	}

	@EJB
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	private UserDao userDao;

	private static final Logger LOG = LoggerFactory.getLogger(UserManagementResource.class);

}
