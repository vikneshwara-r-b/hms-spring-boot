/*
 *
 */
package global.coda.hms.exception;

/**
 * The Class SystemException.
 */
public class SystemException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -9097527545052815122L;

	/**
	 * Instantiates a new system exception.
	 *
	 * @param e the e
	 */
	public SystemException(Exception e) {
		super(e);
	}

	public SystemException(String args) {
		super(args);
	}
}
