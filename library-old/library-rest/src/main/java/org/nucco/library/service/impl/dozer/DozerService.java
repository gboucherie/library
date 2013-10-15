package org.nucco.library.service.impl.dozer;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.nucco.library.service.api.DTOService;

@Singleton
@Named("dozer")
public final class DozerService implements DTOService {

	@Override
	public <T> T map(Class<T> destinationClass, Object source) {
		return mapper.map(source, destinationClass);
	}

	@Override
	public <T> List<T> map(Class<T> destinationClass, List<?> sources) {
		List<T> result = new ArrayList<T>();

		for (Object source : sources) {
			result.add(mapper.map(source, destinationClass));
		}

		return result;
	}

	private Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();

}
