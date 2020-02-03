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

@SpringBootTest
public class PatientServiceTest {
	@Autowired
	private PatientService patientService;
	@Autowired
	private PatientConstants mockPatient;

	@Test
	public void createValidPatient() throws SystemException, BusinessException {
		Patient validMockPatient = mockPatient.createValidMockPatient();
		Patient createdPatient = patientService.createPatient(validMockPatient);
		assertTrue(validMockPatient.getFkRoleId() == createdPatient.getFkRoleId());
	}

	@Test
	public void createInvalidPatient() throws SystemException, BusinessException {
		Patient invalidMockPatient = mockPatient.createInvalidMockPatient();
		Assertions.assertThrows(BusinessException.class, () -> {
			patientService.createPatient(invalidMockPatient);
		});
	}

	@Test
	public void getValidPatient() throws SystemException, BusinessException {
		Patient validMockPatient = patientService.getPatientById(NumericConstants.ONE).get(NumericConstants.ZERO);
		assertTrue(PatientTestConstants.VALID_USERNAME.equals(validMockPatient.getUserUsername()));
	}

	@Test
	public void getInvalidPatient() throws SystemException, BusinessException {
		Patient invalidMockPatient = patientService.getPatientById(NumericConstants.ONE).get(NumericConstants.ZERO);
		assertFalse(PatientTestConstants.INVALID_USERNAME.equals(invalidMockPatient.getUserUsername()));
	}

	@Test
	public void updateValidPatient() throws BusinessException {
		Patient validMockPatient = mockPatient.createValidMockPatient();
		validMockPatient.setPatientHeight(211);
		Patient updatedPatient = patientService.updatePatient(validMockPatient);
		assertFalse(updatedPatient.getPatientHeight() == validMockPatient.getPatientHeight());
	}

	@Test
	public void updateInalidPatient() throws BusinessException {
		Patient invalidMockPatient = mockPatient.createInvalidMockPatient();
		Assertions.assertThrows(SystemException.class, () -> {
			patientService.updatePatient(invalidMockPatient);
		});

	}

	@Test
	public void deleteValidPatient() {
		boolean isDeleted = patientService.deletePatient(PatientTestConstants.VALID_PATIENT_ID);
		assertTrue(isDeleted == true);
	}

	@Test
	public void deleteInvalidPatient() {
		boolean isDeleted = patientService.deletePatient(PatientTestConstants.INVALID_PATIENT_ID);
		assertFalse(isDeleted == true);
	}

}