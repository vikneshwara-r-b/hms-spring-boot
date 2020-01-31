/*
 *
 */
package global.coda.hms.models;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * The Class Patient.
 */
public class Patient extends User {

	/** The pk patient id. */
	private int pkPatientId;

	/** The patient height. */
	private int patientHeight;

	/** The patient weight. */
	private int patientWeight;

	/** The patient isactive. */
	private int patientIsactive;

	/** The patient created on. */
	@JsonProperty(access = Access.READ_ONLY)
	private Timestamp patientCreatedOn;

	/** The patient updated on. */
	@JsonProperty(access = Access.READ_ONLY)
	private Timestamp patientUpdatedOn;

	/** The fk userid. */
	private int fkUserid;

	/** The patient blood group. */
	private String patientBloodGroup;

	/**
	 * Gets the pk patient id.
	 *
	 * @return the pk patient id
	 */
	public int getPkPatientId() {
		return pkPatientId;
	}

	/**
	 * Sets the pk patient id.
	 *
	 * @param pkPatientId the new pk patient id
	 */
	public void setPkPatientId(int pkPatientId) {
		this.pkPatientId = pkPatientId;
	}

	/**
	 * Gets the patient height.
	 *
	 * @return the patient height
	 */
	public int getPatientHeight() {
		return patientHeight;
	}

	/**
	 * Sets the patient height.
	 *
	 * @param patientHeight the new patient height
	 */
	public void setPatientHeight(int patientHeight) {
		this.patientHeight = patientHeight;
	}

	/**
	 * Gets the patient weight.
	 *
	 * @return the patient weight
	 */
	public int getPatientWeight() {
		return patientWeight;
	}

	/**
	 * Sets the patient weight.
	 *
	 * @param patientWeight the new patient weight
	 */
	public void setPatientWeight(int patientWeight) {
		this.patientWeight = patientWeight;
	}

	/**
	 * Gets the patient isactive.
	 *
	 * @return the patient isactive
	 */
	public int getPatientIsactive() {
		return patientIsactive;
	}

	/**
	 * Sets the patient isactive.
	 *
	 * @param patientIsactive the new patient isactive
	 */
	public void setPatientIsactive(int patientIsactive) {
		this.patientIsactive = patientIsactive;
	}

	/**
	 * Gets the patient created on.
	 *
	 * @return the patient created on
	 */
	public Timestamp getPatientCreatedOn() {
		return patientCreatedOn;
	}

	/**
	 * Sets the patient created on.
	 *
	 * @param patientCreatedOn the new patient created on
	 */
	public void setPatientCreatedOn(Timestamp patientCreatedOn) {
		this.patientCreatedOn = patientCreatedOn;
	}

	/**
	 * Gets the patient updated on.
	 *
	 * @return the patient updated on
	 */
	public Timestamp getPatientUpdatedOn() {
		return patientUpdatedOn;
	}

	/**
	 * Sets the patient updated on.
	 *
	 * @param patientUpdatedOn the new patient updated on
	 */
	public void setPatientUpdatedOn(Timestamp patientUpdatedOn) {
		this.patientUpdatedOn = patientUpdatedOn;
	}

	/**
	 * Gets the fk userid.
	 *
	 * @return the fk userid
	 */
	public int getFkUserid() {
		return fkUserid;
	}

	/**
	 * Sets the fk userid.
	 *
	 * @param fkUserid the new fk userid
	 */
	public void setFkUserid(int fkUserid) {
		this.fkUserid = fkUserid;
	}

	/**
	 * Gets the patient blood group.
	 *
	 * @return the patient blood group
	 */
	public String getPatientBloodGroup() {
		return patientBloodGroup;
	}

	/**
	 * Sets the patient blood group.
	 *
	 * @param patientBloodGroup the new patient blood group
	 */
	public void setPatientBloodGroup(String patientBloodGroup) {
		this.patientBloodGroup = patientBloodGroup;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Patient [pkPatientId=" + pkPatientId + ", patientHeight=" + patientHeight + ", patientWeight="
				+ patientWeight + ", patientIsactive=" + patientIsactive + ", patientCreatedOn=" + patientCreatedOn
				+ ", patientUpdatedOn=" + patientUpdatedOn + ", fkUserid=" + fkUserid + ", patientBloodGroup="
				+ patientBloodGroup + ", getPkUserId()=" + getPkUserId() + ", getUserUsername()=" + getUserUsername()
				+ ", getUserPassword()=" + getUserPassword() + ", getUserEmail()=" + getUserEmail()
				+ ", getUserPhonenumber()=" + getUserPhonenumber() + ", getUserFirstname()=" + getUserFirstname()
				+ ", getUserLastname()=" + getUserLastname() + ", getUserAge()=" + getUserAge() + ", getUserCity()="
				+ getUserCity() + ", getUserState()=" + getUserState() + ", getUserStreet()=" + getUserStreet()
				+ ", getFkRoleId()=" + getFkRoleId() + ", getUserIsactive()=" + getUserIsactive()
				+ ", getUserCreatedOn()=" + getUserCreatedOn() + ", getUserUpdatedOn()=" + getUserUpdatedOn() + "]";
	}

}
