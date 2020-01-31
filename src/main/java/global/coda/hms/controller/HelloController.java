/*
 *
 */
package global.coda.hms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class HelloController.
 */
@RestController
public class HelloController {

	/**
	 * Index.
	 *
	 * @return the string
	 */
	@GetMapping("/boot")
	public String index() {
		return "Greetings from Spring Boot!";
	}
}
