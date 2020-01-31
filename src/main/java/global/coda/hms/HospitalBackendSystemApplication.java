/*
 *
 */
package global.coda.hms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

import global.coda.hms.constants.AppConstants;

/**
 * The Class HospitalBackendSystemApplication.
 */
@MapperScan("global.coda.hms")
@SpringBootApplication
public class HospitalBackendSystemApplication {
	/**
	 * HMS Backend.
	 */
	public HospitalBackendSystemApplication() {
		// HMS Backend
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(HospitalBackendSystemApplication.class, args);
	}

	@Bean
	public ResourceBundleMessageSource messageSource() {

		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasenames(AppConstants.MESSAGES_BUNDLE);
		source.setUseCodeAsDefaultMessage(true);
		return source;
	}

}
