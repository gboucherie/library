package org.nucco.library.service.impl.dozer.converters;

import org.dozer.CustomConverter;
import org.dozer.MappingException;
import org.nucco.library.bean.Author;

public final class AuthorConverter implements CustomConverter {

	@Override
	public Object convert(Object existingDestinationFieldValue,
			Object sourceFieldValue, Class<?> destinationClass,
			Class<?> sourceClass) {

		Object result = null;

		if (sourceFieldValue != null) {
			if (sourceFieldValue instanceof Author) {
				Author author = (Author) sourceFieldValue;
				result = author.getFirstname() + SEPARATOR + author.getLastname();
			} else if (sourceFieldValue instanceof String) {
				String source = (String) sourceFieldValue;
				String tmp[] = source.split(SEPARATOR);
				Author author = new Author();
				author.setFirstname(tmp[0]);
				author.setLastname(tmp[1]);
				result = author;

			} else {
				throw new MappingException("Converter AuthorConverter used incorrectly. Arguments passed in were: " + existingDestinationFieldValue + " and " + sourceFieldValue);
			}
		}

		return result;
	}

	private static final String SEPARATOR = ", ";

}
