/*
 *
 */
package global.coda.hms.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import global.coda.hms.mapper.DoctorMapper;
import global.coda.hms.mapper.UserMapper;
import global.coda.hms.models.Doctor;
import global.coda.hms.models.DoctorPatientAggregator;
import global.coda.hms.models.DoctorPatientMapper;
import global.coda.hms.models.Patient;

/**
 * The Class DoctorService.
 */
@Service
public class DoctorService {

	/** The logger. */
	private final Logger LOGGER = LogManager.getLogger(DoctorService.class);

	/** The doctor mapper. */
	@Autowired
	private DoctorMapper doctorMapper;

	/** The user mapper. */
	@Autowired
	private UserMapper userMapper;

	/**
	 * Gets the all doctors.
	 *
	 * @return the all doctors
	 */
	public List<Doctor> getAllDoctors() {
		LOGGER.traceEntry();
		List<Doctor> allDoctors = null;
		allDoctors = doctorMapper.getAllDoctors();
		LOGGER.traceExit();
		return allDoctors;
	}

	/**
	 * Gets the doctor by id.
	 *
	 * @param doctorId the doctor id
	 * @return the doctor by id
	 */
	public Doctor getDoctorById(int doctorId) {
		LOGGER.traceEntry();
		Doctor doctor = null;
		doctor = doctorMapper.getDoctorById(doctorId);
		if (doctor != null) {
			LOGGER.info(doctor.toString());
		}
		LOGGER.traceExit();
		return doctor;
	}

	/**
	 * Creates the doctor.
	 *
	 * @param doctor the doctor
	 * @return the doctor
	 */
	public Doctor createDoctor(Doctor doctor) {
		LOGGER.traceEntry();
		int rowsAffectedInUser = 0;
		int rowsAffectedInDoctor = 0;
		Doctor createdDoctor = null;
		rowsAffectedInUser = userMapper.createUser(doctor);
		if (rowsAffectedInUser == 1) {
			int userId = doctor.getPkUserId();
			doctor.setFkUserId(userId);
			rowsAffectedInDoctor = doctorMapper.createDoctor(doctor);
			if (rowsAffectedInDoctor == 1) {
				createdDoctor = doctor;
			}
		}
		LOGGER.traceExit();
		return createdDoctor;
	}

	/**
	 * Update doctor.
	 *
	 * @param doctor the doctor
	 * @return the doctor
	 */
	public Doctor updateDoctor(Doctor doctor) {
		LOGGER.traceEntry();
		int rowsAffectedInUser = 0;
		int rowsAffectedInDoctor = 0;
		Doctor updatedDoctor = null;
		Doctor oldDoctor = null;
		rowsAffectedInDoctor = doctorMapper.updateDoctor(doctor);
		if (rowsAffectedInDoctor == 1) {
			LOGGER.info("Doctor table updated successfully");
			oldDoctor = doctorMapper.getDoctorById(doctor.getPkDoctorId());
			LOGGER.info(oldDoctor.toString());
			doctor.setPkUserId(oldDoctor.getFkUserId());
			LOGGER.info("User Id is :" + doctor.getPkUserId());
			rowsAffectedInUser = userMapper.updateUser(doctor);
			if (rowsAffectedInUser == 1) {
				LOGGER.info("User table updated successfully");
				updatedDoctor = doctor;
			}
		}
		LOGGER.traceExit();
		return updatedDoctor;
	}

	/**
	 * Delete doctor.
	 *
	 * @param doctorId the doctor id
	 * @return true, if successful
	 */
	public boolean deleteDoctor(int doctorId) {
		LOGGER.traceEntry();
		boolean result = false;
		int rowsAffected = 0;
		getDoctorById(doctorId);
		rowsAffected = doctorMapper.deleteDoctor(doctorId);
		if (rowsAffected == 2) {
			LOGGER.info("Doctor is deleted successfully");
			result = true;
		}
		LOGGER.traceExit();
		return result;
	}

	/**
	 * Map patient.
	 *
	 * @param doctorId  the doctor id
	 * @param patientId the patient id
	 * @return the doctor patient mapper
	 */
	public DoctorPatientMapper mapPatient(int doctorId, int patientId) {
		DoctorPatientMapper patientMapper = new DoctorPatientMapper();
		patientMapper.setDoctorId(doctorId);
		patientMapper.setPatientId(patientId);
		return patientMapper;
	}

	/**
	 * Find patients of doctor.
	 *
	 * @param doctorId the doctor id
	 * @return the list
	 */
	public List<DoctorPatientAggregator> findPatientsOfDoctor(int doctorId) {
		LOGGER.traceEntry();
		List<DoctorPatientAggregator> doctorPatientAggregator = null;
		doctorPatientAggregator = doctorMapper.findPatientsOfAllDoctors(doctorId);
		LOGGER.traceExit();
		return doctorPatientAggregator;
	}

	/**
	 * Find all patients of doctors.
	 *
	 * @return the map
	 */
	public Map<Integer, List<Patient>> findAllPatientsOfDoctors() {
		LOGGER.traceEntry();
		Map<Integer, List<Patient>> patientAggregator = new HashMap<Integer, List<Patient>>();
		List<Doctor> alldoctors = new ArrayList<Doctor>();
		alldoctors = doctorMapper.getAllDoctors();
		for (Doctor doctor : alldoctors) {
			int doctorId = doctor.getPkDoctorId();
			List<Patient> allpatients = null;
			allpatients = doctorMapper.findPatientsOfDoctor(doctorId);
			patientAggregator.put(doctorId, allpatients);
		}
		LOGGER.traceExit();
		return patientAggregator;
	}

}
