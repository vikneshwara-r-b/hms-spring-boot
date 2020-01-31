/*
 *
 */
package global.coda.hms.controller;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
import global.coda.hms.models.Doctor;
import global.coda.hms.models.DoctorPatientAggregator;
import global.coda.hms.models.DoctorPatientMapper;
import global.coda.hms.models.Patient;
import global.coda.hms.models.ResponseBody;
import global.coda.hms.service.DoctorService;

/**
 * The Class DoctorController.
 */
@CrossOrigin
@RestController
@RequestMapping("/doctors")
public class DoctorController {

	/** The logger. */
	private final Logger LOGGER = LogManager.getLogger(DoctorController.class);

	/** The doctor service. */
	@Autowired
	private DoctorService doctorService;

	/** The response body. */
	@Autowired
	private ResponseBody responseBody;

	/**
	 * Gets the all doctors.
	 *
	 * @return the all doctors
	 */
	@GetMapping("/all")
	public ResponseBody getAllDoctors() {
		LOGGER.traceEntry();
		List<Doctor> allDoctors = null;
		allDoctors = doctorService.getAllDoctors();
		responseBody.setData(allDoctors);
		responseBody.setStatusCode(HttpStatusConstants.OK);
		LOGGER.traceExit();
		return responseBody;
	}

	/**
	 * Gets the doctor by id.
	 *
	 * @param doctorId the doctor id
	 * @return the doctor by id
	 */
	@GetMapping("getDoctors/{id}")
	public ResponseBody getDoctorById(@RequestParam("id") Integer doctorId) {
		LOGGER.traceEntry();
		if (doctorId == null) {
			doctorId = 0;
		}
		Doctor doctor = null;
		doctor = doctorService.getDoctorById(doctorId);
		responseBody.setData(doctor);
		responseBody.setStatusCode(HttpStatusConstants.OK);
		LOGGER.traceExit();
		return responseBody;
	}

	/**
	 * Creates the doctor.
	 *
	 * @param doctor the doctor
	 * @return the response body
	 */
	@PostMapping("/create")
	public ResponseBody createDoctor(@RequestBody Doctor doctor) {
		LOGGER.traceEntry();
		Doctor createdDoctor = null;
		createdDoctor = doctorService.createDoctor(doctor);
		responseBody.setData(createdDoctor);
		responseBody.setStatusCode(HttpStatusConstants.OK);
		LOGGER.traceExit();
		return responseBody;
	}

	/**
	 * Update doctor.
	 *
	 * @param doctor the doctor
	 * @return the response body
	 */
	@PutMapping("/update")
	public ResponseBody updateDoctor(@RequestBody Doctor doctor) {
		LOGGER.traceEntry();
		Doctor updatedDoctor = null;
		updatedDoctor = doctorService.updateDoctor(doctor);
		if (updatedDoctor == null) {
			LOGGER.info("Doctor is not updated successfully");
			responseBody.setData("Doctor is not updated successfully");
			responseBody.setStatusCode(HttpStatusConstants.CLIENT_ERROR);
		} else {
			responseBody.setStatusCode(HttpStatusConstants.OK);
			responseBody.setData(updatedDoctor);
		}
		LOGGER.traceExit();
		return responseBody;
	}

	/**
	 * Delete doctor.
	 *
	 * @param doctorId the doctor id
	 * @return the response body
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseBody deleteDoctor(@PathVariable("id") int doctorId) {
		LOGGER.traceEntry();
		boolean isDeleted = false;
		isDeleted = doctorService.deleteDoctor(doctorId);
		if (isDeleted) {
			responseBody.setStatusCode(HttpStatusConstants.NO_CONTENT);
			responseBody.setData("Doctor is deleted successfully");
		} else {
			responseBody.setStatusCode(HttpStatusConstants.INTERNAL_SERVER_ERROR);
			responseBody.setData("Doctor is not deleted successfully");
		}
		LOGGER.traceExit();
		return responseBody;
	}

	/**
	 * Find patients of doctor.
	 *
	 * @param doctorId the doctor id
	 * @return the response body
	 */
	@GetMapping("/getPatients")
	public ResponseBody findPatientsOfDoctor(@RequestParam(name = "doctorId", required = false) Integer doctorId) {
		LOGGER.traceEntry();
		if (doctorId == null) {
			doctorId = 0;
		}
		List<DoctorPatientAggregator> doctorPatientAggregator = null;
		doctorPatientAggregator = doctorService.findPatientsOfDoctor(doctorId);
		responseBody.setData(doctorPatientAggregator);
		responseBody.setStatusCode(HttpStatusConstants.OK);
		LOGGER.traceExit();
		return responseBody;
	}

	/**
	 * Find all patients of doctors.
	 *
	 * @return the response body
	 */
	@GetMapping("/allpatients")
	public ResponseBody findAllPatientsOfDoctors() {
		LOGGER.traceEntry();
		Map<Integer, List<Patient>> patientAggregator = null;
		patientAggregator = doctorService.findAllPatientsOfDoctors();
		responseBody.setData(patientAggregator);
		responseBody.setStatusCode(HttpStatusConstants.OK);
		LOGGER.traceExit();
		return responseBody;
	}

	/**
	 * Map patient.
	 *
	 * @param doctorId  the doctor id
	 * @param patientId the patient id
	 * @return the response body
	 */
	@PutMapping("/{doctorid}/patient/{patientid}")
	public ResponseBody mapPatient(@PathVariable("doctorid") int doctorId, @PathVariable("patientid") int patientId) {
		LOGGER.traceEntry();
		DoctorPatientMapper patientMapper = null;
		patientMapper = doctorService.mapPatient(doctorId, patientId);
		responseBody.setData(patientMapper);
		responseBody.setStatusCode(HttpStatusConstants.OK);
		LOGGER.traceExit();
		return responseBody;
	}

}
