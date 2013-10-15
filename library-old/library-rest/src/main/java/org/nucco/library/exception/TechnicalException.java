package org.nucco.library.exception;

/**
 * This exception must be raised only for technical problem.
 * 
 * @author Guillaume.Boucherie
 *
 */
public class TechnicalException extends Exception {

	public TechnicalException() {
		super();
	}

	public TechnicalException(String message, Throwable cause) {
		super(message, cause);
	}

	public TechnicalException(String message) {
		super(message);
	}

	public TechnicalException(Throwable cause) {
		super(cause);
	}

	private static final long serialVersionUID = 1L;

}
