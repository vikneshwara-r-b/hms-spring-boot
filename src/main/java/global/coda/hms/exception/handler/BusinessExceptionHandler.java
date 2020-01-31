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
import global.coda.hms.exception.BusinessException;
import global.coda.hms.models.ResponseBody;

@ControllerAdvice
public class BusinessExceptionHandler {
	private final Logger LOGGER = LogManager.getLogger(BusinessExceptionHandler.class);
	@Autowired
	ResponseBody response;

	@ExceptionHandler(value = BusinessException.class)
	public ResponseEntity<ResponseBody> handleBusinessException(BusinessException businessException) {
		LOGGER.error(businessException.getMessage());
		response.setData(businessException.getMessage());
		response.setStatusCode(HttpStatusConstants.CLIENT_ERROR);
		return new ResponseEntity<ResponseBody>(response, HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<ResponseBody> handleBusinessErrorMessages(String message) {
		LOGGER.error(message);
		response.setData(message);
		response.setStatusCode(HttpStatusConstants.CLIENT_ERROR);
		return new ResponseEntity<ResponseBody>(response, HttpStatus.BAD_REQUEST);
	}
}
