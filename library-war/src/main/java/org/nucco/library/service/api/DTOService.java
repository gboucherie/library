package org.nucco.library.service.api;

import java.util.List;

public interface DTOService {

	public <T> T map(Class<T> destinationClass, Object source);
	public <T> List<T> map(Class<T> destinationClass, List<?> sources);

}
