package org.nucco.library.exception;

/**
 * This exception must be used only for functional problem.
 * 
 * @author Guillaume.Boucherie
 *
 */
public class FunctionalException extends Exception {

	public FunctionalException() {
		super();
	}

	public FunctionalException(String message, Throwable cause) {
		super(message, cause);
	}

	public FunctionalException(String message) {
		super(message);
	}

	public FunctionalException(Throwable cause) {
		super(cause);
	}

	private static final long serialVersionUID = 1L;

}
