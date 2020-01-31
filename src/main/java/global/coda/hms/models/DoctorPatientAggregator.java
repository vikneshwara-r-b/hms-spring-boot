/*
 *
 */
package global.coda.hms.models;

import java.util.List;

/**
 * The Class DoctorPatientAggregator.
 */
public class DoctorPatientAggregator {
	private Doctor doctor;

	/** The allpatients. */
	private List<Patient> allpatients;

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	/**
	 * Gets the allpatients.
	 *
	 * @return the allpatients
	 */
	public List<Patient> getAllpatients() {
		return allpatients;
	}

	/**
	 * Sets the allpatients.
	 *
	 * @param allpatients the new allpatients
	 */
	public void setAllpatients(List<Patient> allpatients) {
		this.allpatients = allpatients;
	}

	@Override
	public String toString() {
		return "DoctorPatientAggregator [doctor=" + doctor + ", allpatients=" + allpatients + "]";
	}

}
