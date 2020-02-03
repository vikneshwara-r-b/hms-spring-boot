/*
 *
 */
package global.coda.hms.service;

import java.util.List;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import global.coda.hms.constants.AppConstants;
import global.coda.hms.exception.BusinessException;
import global.coda.hms.exception.PatientCreationFailed;
import global.coda.hms.exception.PatientDeletionFailed;
import global.coda.hms.exception.PatientNotFound;
import global.coda.hms.exception.PatientUpdationFailed;
import global.coda.hms.exception.SystemException;
import global.coda.hms.exception.UserCreationFailed;
import global.coda.hms.exception.UserUpdationFailed;
import global.coda.hms.mapper.PatientMapper;
import global.coda.hms.mapper.UserMapper;
import global.coda.hms.models.Patient;

/**
 * The Class PatientService.
 */
@Service
public class PatientService {
	/** The logger. */
	private final Logger LOGGER = LogManager.getLogger(PatientService.class);

	@Autowired
	private MessageSource messageSource;

	/** The patient mapper. */
	@Autowired
	private PatientMapper patientMapper;

	/** The user mapper. */
	@Autowired
	private UserMapper userMapper;

	/**
	 * Gets the all patients.
	 *
	 * @return the all patients
	 */
	public List<Patient> getAllPatients() {
		LOGGER.traceEntry();
		List<Patient> allPatients = null;
		allPatients = patientMapper.getAllPatients();
		LOGGER.traceExit();
		return allPatients;
	}

	/**
	 * Gets the patient by id.
	 *
	 * @param patientId the patient id
	 * @return the patient by id
	 * @throws SystemException
	 * @throws BusinessException
	 */
	public List<Patient> getPatientById(int patientId) throws SystemException, BusinessException {
		try {
			LOGGER.traceEntry();
			List<Patient> allpatients = null;
			allpatients = patientMapper.getPatientById(patientId);
			if (allpatients.size() < 1) {
				throw new PatientNotFound(messageSource.getMessage(AppConstants.HMS3002E, null, Locale.US));
			}
			if (allpatients != null) {
				for (Patient patient : allpatients) {
					LOGGER.info(patient.toString());
				}
			}
			LOGGER.traceExit();
			return allpatients;
		} catch (PatientNotFound e) {
			throw new BusinessException(e);
		} catch (Exception e) {
			throw new SystemException(e);
		}
	}

	/**
	 * Creates the patient.
	 *
	 * @param patient the patient
	 * @return the patient
	 * @throws BusinessException
	 */
	@Transactional(rollbackFor = { PatientCreationFailed.class, UserCreationFailed.class })
	public Patient createPatient(Patient patient) throws SystemException, BusinessException {
		try {
			LOGGER.traceEntry();
			int rowsAffectedInUser = 0;
			int rowsAffectedInPatient = 0;
			Patient createdPatient = null;
			rowsAffectedInUser = userMapper.createUser(patient);
			if (rowsAffectedInUser == 1) {
				int userId = patient.getPkUserId();
				patient.setFkUserid(userId);
				rowsAffectedInPatient = patientMapper.createPatient(patient);
				if (rowsAffectedInPatient == 1) {
					createdPatient = patient;
				} else {
					throw new PatientCreationFailed(messageSource.getMessage(AppConstants.HMS3005E, null, Locale.US));
				}
			} else {
				throw new UserCreationFailed(messageSource.getMessage(AppConstants.HMS3004E, null, Locale.US));
			}
			LOGGER.traceExit();
			return createdPatient;
		} catch (PatientCreationFailed | UserCreationFailed e) {
			throw new SystemException(e);
		} catch (DuplicateKeyException e) {
			LOGGER.info(messageSource.getMessage(AppConstants.HMS3013E, null, Locale.US));
			throw new BusinessException(messageSource.getMessage(AppConstants.HMS3013E, null, Locale.US));
		} catch (DataIntegrityViolationException e) {
			LOGGER.info(messageSource.getMessage(AppConstants.HMS3012E, null, Locale.US));
			throw new SystemException(e);
		} catch (Exception e) {
			throw new SystemException(e);
		}
	}

	/**
	 * Update patient.
	 *
	 * @param patient the patient
	 * @return the patient
	 * @throws BusinessException
	 * @throws NoSuchMessageException
	 */
	@Transactional(rollbackFor = { UserUpdationFailed.class, PatientUpdationFailed.class })
	public Patient updatePatient(Patient patient) throws SystemException, BusinessException {
		try {
			LOGGER.traceEntry();
			int rowsAffectedInUser = 0;
			int rowsAffectedInPatient = 0;
			Patient updatedPatient = null;
			List<Patient> patients = null;
			rowsAffectedInPatient = patientMapper.updatePatient(patient);
			if (rowsAffectedInPatient == 1) {
				LOGGER.info(messageSource.getMessage(AppConstants.HMS1009I, null, Locale.US));
				patients = patientMapper.getPatientById(patient.getPkPatientId());
				for (Patient oldPatient : patients) {
					patient.setPkUserId(oldPatient.getFkUserid());
				}
				LOGGER.info("User Id is :" + patient.getPkUserId());
				rowsAffectedInUser = userMapper.updateUser(patient);
				if (rowsAffectedInUser == 1) {
					LOGGER.info(messageSource.getMessage(AppConstants.HMS1008I, null, Locale.US));
					updatedPatient = patient;
				} else {
					throw new UserUpdationFailed(messageSource.getMessage(AppConstants.HMS3008E, null, Locale.US));
				}
			} else {
				throw new PatientUpdationFailed(messageSource.getMessage(AppConstants.HMS3008E, null, Locale.US));
			}
			LOGGER.traceExit();
			return updatedPatient;
		} catch (PatientUpdationFailed | UserUpdationFailed e) {
			throw new SystemException(e);
		} catch (DuplicateKeyException e) {
			LOGGER.info(messageSource.getMessage(AppConstants.HMS3013E, null, Locale.US));
			throw new BusinessException(messageSource.getMessage(AppConstants.HMS3013E, null, Locale.US));
		} catch (DataIntegrityViolationException e) {
			LOGGER.info(messageSource.getMessage(AppConstants.HMS3012E, null, Locale.US));
			throw new SystemException(e);
		} catch (Exception e) {
			throw new SystemException(e);
		}

	}

	/**
	 * Delete patient.
	 *
	 * @param patientId the patient id
	 * @return true, if successful
	 */
	public boolean deletePatient(int patientId) throws SystemException {
		try {
			LOGGER.traceEntry();
			boolean result = false;
			int rowsAffected = 0;
			List<Patient> patient = null;
			patient = patientMapper.getPatientById(patientId);
			if (patient.size() == 1) {
				rowsAffected = patientMapper.deletePatient(patientId);
				if (rowsAffected == 2) {
					LOGGER.info(messageSource.getMessage(AppConstants.HMS1000I, null, Locale.US));
					result = true;
				} else {
					throw new PatientDeletionFailed(messageSource.getMessage(AppConstants.HMS1001I, null, Locale.US));
				}
			}
			LOGGER.traceExit();
			return result;
		} catch (PatientDeletionFailed e) {
			throw new SystemException(e);
		} catch (Exception e) {
			throw new SystemException(e);
		}
	}

}
