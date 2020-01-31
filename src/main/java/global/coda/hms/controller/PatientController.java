/*
 *
 */
package global.coda.hms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.NoSuchMessageException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import global.coda.hms.constants.HttpStatusConstants;
import global.coda.hms.exception.BusinessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.models.Patient;
import global.coda.hms.models.ResponseBody;
import global.coda.hms.service.PatientService;

/**
 * The Class PatientController.
 */
@CrossOrigin
@RestController
@RequestMapping("/patients")
public class PatientController {

	/*
	 * @Autowired CustomerRepository repository;
	 */
	/** The logger. */
	private final Logger LOGGER = LogManager.getLogger(PatientController.class);

	/** The patient service. */
	@Autowired
	private PatientService patientService;

	/** The response body. */
	@Autowired
	private ResponseBody responseBody;

	/**
	 * Gets the all patients.
	 *
	 * @return the all patients
	 */
	@GetMapping("/all")
	public ResponseBody getAllPatients() {
		LOGGER.traceEntry();
		List<Patient> allPatients = null;
		allPatients = patientService.getAllPatients();
		responseBody.setData(allPatients);
		responseBody.setStatusCode(HttpStatusConstants.OK);
		LOGGER.traceExit();
		return responseBody;
	}

	/**
	 * Gets the by patient id.
	 *
	 * @param patientId the patient id
	 * @return the by patient id
	 * @throws BusinessException
	 * @throws SystemException
	 */
	@GetMapping("/getPatients")
	public ResponseBody getByPatientId(@RequestParam(name = "patientId", required = false) Integer patientId,
			HttpServletRequest request, HttpServletResponse response) throws SystemException, BusinessException {
		LOGGER.traceEntry();
		List<Patient> patients = null;
		if (patientId == null) {
			patientId = 0;
		}
		patients = patientService.getPatientById(patientId);
		responseBody.setData(patients);
		responseBody.setStatusCode(HttpStatusConstants.OK);
		responseBody.setRequestId(response.getHeader("key"));
		LOGGER.traceExit();
		return responseBody;
	}

	/**
	 * Creates the patient.
	 *
	 * @param patient the patient
	 * @return the response body
	 * @throws BusinessException
	 * @throws SystemException
	 */
	@PostMapping("/create")
	public ResponseBody createPatient(@RequestBody Patient patient) throws SystemException, BusinessException {
		LOGGER.traceEntry();
		Patient createdpatient = null;
		createdpatient = patientService.createPatient(patient);
		if (createdpatient == null) {
			LOGGER.info("Patient is not created successfully");
			responseBody.setData("Patient is not created successfully");
			responseBody.setStatusCode(HttpStatusConstants.CLIENT_ERROR);
		} else {
			responseBody.setStatusCode(HttpStatusConstants.OK);
			responseBody.setData(createdpatient);
		}
		LOGGER.traceExit();
		return responseBody;
	}

	/**
	 * Update patient.
	 *
	 * @param patient the patient
	 * @return the response body
	 * @throws BusinessException
	 * @throws NoSuchMessageException
	 */
	@PutMapping("/update")
	public ResponseBody updatePatient(@RequestBody Patient patient) throws NoSuchMessageException, BusinessException {
		LOGGER.traceEntry();
		Patient updatedpatient = null;
		updatedpatient = patientService.updatePatient(patient);
		if (updatedpatient == null) {
			LOGGER.info("Patient is not updated successfully");
			responseBody.setData("Patient is not updated successfully");
			responseBody.setStatusCode(HttpStatusConstants.CLIENT_ERROR);
		} else {
			responseBody.setStatusCode(HttpStatusConstants.OK);
			responseBody.setData(updatedpatient);
		}
		LOGGER.traceExit();
		return responseBody;
	}

	/**
	 * Delete patient.
	 *
	 * @param patientId the patient id
	 * @return the response body
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseBody deletePatient(@PathVariable("id") int patientId) {
		LOGGER.traceEntry();
		boolean isDeleted = false;
		isDeleted = patientService.deletePatient(patientId);
		if (isDeleted) {
			responseBody.setStatusCode(HttpStatusConstants.NO_CONTENT);
			responseBody.setData("Patient is deleted successfully");
		} else {
			responseBody.setStatusCode(HttpStatusConstants.INTERNAL_SERVER_ERROR);
			responseBody.setData("Patient is not deleted successfully");
		}
		LOGGER.traceExit();
		return responseBody;
	}

	/*
	 * @GetMapping("/customer") public ResponseBody customerActions() {
	 * repository.findAll(); Optional<Customer> customer =
	 * repository.findById((long) 8); responseBody.setData(customer); return
	 * responseBody; }
	 */
}
