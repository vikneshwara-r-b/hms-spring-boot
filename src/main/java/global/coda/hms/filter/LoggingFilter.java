/*
 *
 */
package global.coda.hms.filter;

import java.io.IOException;
import java.util.Random;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class LoggingFilter extends OncePerRequestFilter {

	// ResponseBody responseBody;
	/** The logger. */
	private final Logger LOGGER = LogManager.getLogger(LoggingFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		LOGGER.traceEntry();
		Random random = new Random();
		random.setSeed(20);
		LOGGER.info("Inside a filter");
		random.nextLong();
		response.addHeader("key", Integer.toString(new Random().nextInt(1000)));
		LOGGER.info("Set request Id");
		filterChain.doFilter(request, response);
		LOGGER.traceExit();
	}

}
