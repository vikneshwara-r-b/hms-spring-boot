/*
 *
 */
package global.coda.hms.exception.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import global.coda.hms.constants.HttpStatusConstants;
import global.coda.hms.exception.SystemException;
import global.coda.hms.models.ResponseBody;

@ControllerAdvice
public class SystemExceptionHandler {
	private final Logger LOGGER = LogManager.getLogger(SystemExceptionHandler.class);
	@Autowired
	ResponseBody response;

	@ExceptionHandler(value = SystemException.class)
	public ResponseEntity<?> handleSystemException(SystemException systemException) {
		LOGGER.error(systemException.getMessage());
		response.setData(systemException.getMessage());
		response.setStatusCode(HttpStatusConstants.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<ResponseBody>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
