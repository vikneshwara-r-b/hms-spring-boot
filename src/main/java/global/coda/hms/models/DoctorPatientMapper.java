/*
 *
 */
package global.coda.hms.models;

/**
 * The Class DoctorPatientMapper.
 */
public class DoctorPatientMapper {

	/** The doctor id. */
	private int doctorId;

	/** The patient id. */
	private int patientId;

	/** The disease. */
	private String disease;

	/**
	 * Gets the doctor id.
	 *
	 * @return the doctor id
	 */
	public int getDoctorId() {
		return doctorId;
	}

	/**
	 * Sets the doctor id.
	 *
	 * @param doctorId the new doctor id
	 */
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	/**
	 * Gets the patient id.
	 *
	 * @return the patient id
	 */
	public int getPatientId() {
		return patientId;
	}

	/**
	 * Sets the patient id.
	 *
	 * @param patientId the new patient id
	 */
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	/**
	 * Gets the disease.
	 *
	 * @return the disease
	 */
	public String getDisease() {
		return disease;
	}

	/**
	 * Sets the disease.
	 *
	 * @param disease the new disease
	 */
	public void setDisease(String disease) {
		this.disease = disease;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "DoctorPatientMapper [doctorId=" + doctorId + ", patientId=" + patientId + ", disease=" + disease + "]";
	}

}
