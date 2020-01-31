/*
 *
 */
package global.coda.hms.exception;

/**
 * The Class BusinessException.
 */
public class BusinessException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3533174906521636141L;

	/**
	 * Instantiates a new business exception.
	 *
	 * @param e the e
	 */
	public BusinessException(Exception e) {
		super(e);
	}

	public BusinessException(String args) {
		super(args);
	}
}
