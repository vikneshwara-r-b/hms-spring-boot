/*
 *
 */
package global.coda.hms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import global.coda.hms.constants.QueryConstants;
import global.coda.hms.models.Patient;

/**
 * The Interface PatientMapper.
 */
@Mapper
public interface PatientMapper {

	/**
	 * Gets the patient by id.
	 *
	 * @param id the id
	 * @return the patient by id
	 */
	@Select(QueryConstants.PATIENT_READ_ALL)
	List<Patient> getPatientById(int id);

	/**
	 * Gets the all patients.
	 *
	 * @return the all patients
	 */
	@Select(QueryConstants.PATIENT_READ_ALL)
	List<Patient> getAllPatients();

	/**
	 * Creates the patient.
	 *
	 * @param patient the patient
	 * @return the int
	 */
	@Insert(QueryConstants.PATIENT_INSERT)
	@Options(useGeneratedKeys = true, keyProperty = "pkPatientId", keyColumn = "pk_patient_id")
	int createPatient(Patient patient);

	/**
	 * Update patient.
	 *
	 * @param patient the patient
	 * @return the int
	 */
	@Update(QueryConstants.PATIENT_UPDATE)
	int updatePatient(Patient patient);

	/**
	 * Delete patient.
	 *
	 * @param patientId the patient id
	 * @return the int
	 */
	@Delete(QueryConstants.PATIENT_DELETE)
	int deletePatient(int patientId);
}
