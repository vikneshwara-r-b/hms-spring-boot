/*
 *
 */
package global.coda.hms.models;

import org.springframework.stereotype.Component;

/**
 * The Class ResponseBody.
 */
@Component
public class ResponseBody {

	/** The status code. */
	private int statusCode;

	/** The data. */
	private Object data;

	private String requestId;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	/**
	 * Gets the status code.
	 *
	 * @return the status code
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * Sets the status code.
	 *
	 * @param statusCode the new status code
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseBody [statusCode=" + statusCode + ", data=" + data + ", requestId=" + requestId + "]";
	}

}
