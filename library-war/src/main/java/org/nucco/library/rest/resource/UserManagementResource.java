package org.nucco.library.rest.resource;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.nucco.library.bean.User;
import org.nucco.library.dao.api.UserDao;
import org.nucco.library.rest.bean.ExtJsResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Path("/auth")
@ManagedBean
public class UserManagementResource {

	@GET
	@Path("/current_user")
	public Response currentUser(@Context HttpServletRequest request) {
		request.getUserPrincipal().getClass();
		return null;
	}

	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(@FormParam("email") String email, @FormParam("password") String password, @Context HttpServletRequest request) {
		ExtJsResponseWrapper<User> response = new ExtJsResponseWrapper<User>();

		// only login if not already logged in...
		if (request.getUserPrincipal() == null) {
			try {
				request.login(email, password);
			} catch (ServletException e) {
				LOG.warn(e.getMessage(), e);
				response.setStatus(false);
				response.setMessage("Authentication failed !");
				return Response.ok().entity(response).build();
			}
		} else {
			LOG.info("Skip login because already logged in: {}", email);
		}

		User user = userDao.find(email);
		user.setPassword(null);

		response.setStatus(true);
		response.setData(user);
		response.setCount(1);

		return Response.ok().entity(response).build();
	}

	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response register(User user) {
		return null;
	}

	@Inject
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	private UserDao userDao;

	private static final Logger LOG = LoggerFactory.getLogger(UserManagementResource.class);

}
