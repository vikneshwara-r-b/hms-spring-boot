/*
 *
 */
package global.coda.hms.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import global.coda.hms.constants.NumericConstants;
import global.coda.hms.constants.PatientConstants;
import global.coda.hms.constants.PatientTestConstants;
import global.coda.hms.exception.BusinessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.models.Patient;

/**
 * The Class PatientServiceTest.
 */
@SpringBootTest
public class PatientServiceTest {

	/** The patient service. */
	@Autowired
	private PatientService patientService;

	/** The mock patient. */
	@Autowired
	private PatientConstants mockPatient;

	/**
	 * Creates the valid patient.
	 *
	 * @throws SystemException   the system exception
	 * @throws BusinessException the business exception
	 */
	@Test
	public void createValidPatient() throws SystemException, BusinessException {
		Patient validMockPatient = mockPatient.createValidMockPatient();
		Patient createdPatient = patientService.createPatient(validMockPatient);
		assertTrue(validMockPatient.getFkRoleId() == createdPatient.getFkRoleId());
	}

	/**
	 * Creates the invalid patient.
	 *
	 * @throws SystemException   the system exception
	 * @throws BusinessException the business exception
	 */
	@Test
	public void createInvalidPatient() throws SystemException, BusinessException {
		Patient invalidMockPatient = mockPatient.createInvalidMockPatient();
		Assertions.assertThrows(BusinessException.class, () -> {
			patientService.createPatient(invalidMockPatient);
		});
	}

	/**
	 * Gets the valid patient.
	 *
	 * @return the valid patient
	 * @throws SystemException   the system exception
	 * @throws BusinessException the business exception
	 */
	@Test
	public void getValidPatient() throws SystemException, BusinessException {
		Patient validMockPatient = patientService.getPatientById(NumericConstants.ONE).get(NumericConstants.ZERO);
		assertTrue(PatientTestConstants.VALID_USERNAME.equals(validMockPatient.getUserUsername()));
	}

	/**
	 * Gets the invalid patient.
	 *
	 * @return the invalid patient
	 * @throws SystemException   the system exception
	 * @throws BusinessException the business exception
	 */
	@Test
	public void getInvalidPatient() throws SystemException, BusinessException {
		Patient invalidMockPatient = patientService.getPatientById(NumericConstants.ONE).get(NumericConstants.ZERO);
		assertFalse(PatientTestConstants.INVALID_USERNAME.equals(invalidMockPatient.getUserUsername()));
	}

	/**
	 * Update valid patient.
	 *
	 * @throws BusinessException the business exception
	 */
	@Test
	public void updateValidPatient() throws BusinessException {
		Patient validMockPatient = mockPatient.createValidMockPatient();
		validMockPatient.setPatientHeight(211);
		Patient updatedPatient = patientService.updatePatient(validMockPatient);
		assertFalse(updatedPatient.getPatientHeight() == validMockPatient.getPatientHeight());
	}

	/**
	 * Update inalid patient.
	 *
	 * @throws BusinessException the business exception
	 */
	@Test
	public void updateInalidPatient() throws BusinessException {
		Patient invalidMockPatient = mockPatient.createInvalidMockPatient();
		Assertions.assertThrows(SystemException.class, () -> {
			patientService.updatePatient(invalidMockPatient);
		});

	}

	/**
	 * Delete valid patient.
	 */
	@Test
	public void deleteValidPatient() {
		boolean isDeleted = patientService.deletePatient(PatientTestConstants.VALID_PATIENT_ID);
		assertTrue(isDeleted == true);
	}

	/**
	 * Delete invalid patient.
	 */
	@Test
	public void deleteInvalidPatient() {
		boolean isDeleted = patientService.deletePatient(PatientTestConstants.INVALID_PATIENT_ID);
		assertFalse(isDeleted == true);
	}

}