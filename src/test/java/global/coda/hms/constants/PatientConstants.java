/*
 *
 */
package global.coda.hms.constants;

import global.coda.hms.models.Patient;

public class PatientConstants {

	public Patient createValidMockPatient() {
		Patient validMockPatient = new Patient();
		validMockPatient.setUserUsername(PatientTestConstants.VALID_USERNAME);
		validMockPatient.setUserPassword(PatientTestConstants.VALID_PASSWORD);
		validMockPatient.setUserAge(PatientTestConstants.VALID_AGE);
		validMockPatient.setPatientBloodGroup(PatientTestConstants.VALID_BLOODGROUP);
		validMockPatient.setPatientHeight(PatientTestConstants.VALID_HEIGHT);
		validMockPatient.setPatientWeight(PatientTestConstants.VALID_WEIGHT);
		validMockPatient.setUserEmail(PatientTestConstants.VALID_MAIL);
		validMockPatient.setUserFirstname(PatientTestConstants.VALID_FIRSTNAME);
		validMockPatient.setUserLastname(PatientTestConstants.VALID_LASTNAME);
		validMockPatient.setUserPhonenumber(PatientTestConstants.VALID_PHONE_NUMBER);
		validMockPatient.setUserState(PatientTestConstants.VALID_USER_STATE);
		validMockPatient.setUserStreet(PatientTestConstants.VALID_USER_STREET);
		validMockPatient.setFkRoleId(QueryConstants.PATIENT_ROLE_ID);
		return validMockPatient;
	}

	public Patient createInvalidMockPatient() {
		Patient invalidMockPatient = new Patient();
		invalidMockPatient.setUserUsername(PatientTestConstants.VALID_USERNAME);
		invalidMockPatient.setUserPassword(PatientTestConstants.VALID_PASSWORD);
		invalidMockPatient.setUserAge(PatientTestConstants.VALID_AGE);
		invalidMockPatient.setPatientBloodGroup(PatientTestConstants.VALID_BLOODGROUP);
		invalidMockPatient.setPatientHeight(PatientTestConstants.VALID_HEIGHT);
		invalidMockPatient.setPatientWeight(PatientTestConstants.VALID_WEIGHT);
		invalidMockPatient.setUserEmail(PatientTestConstants.VALID_MAIL);
		invalidMockPatient.setUserFirstname(PatientTestConstants.VALID_FIRSTNAME);
		invalidMockPatient.setUserLastname(PatientTestConstants.VALID_LASTNAME);
		invalidMockPatient.setUserPhonenumber(PatientTestConstants.VALID_PHONE_NUMBER);
		invalidMockPatient.setUserState(PatientTestConstants.VALID_USER_STATE);
		invalidMockPatient.setUserStreet(PatientTestConstants.VALID_USER_STREET);
		return invalidMockPatient;
	}
}
