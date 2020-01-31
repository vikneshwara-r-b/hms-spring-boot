/*
 *
 */
package global.coda.hms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import global.coda.hms.constants.QueryConstants;
import global.coda.hms.models.Doctor;
import global.coda.hms.models.DoctorPatientAggregator;
import global.coda.hms.models.Patient;

/**
 * The Interface DoctorMapper.
 */
@Mapper
public interface DoctorMapper {

	/**
	 * Gets the all doctors.
	 *
	 * @return the all doctors
	 */
	@Select(QueryConstants.DOCTOR_READ_ALL)
	List<Doctor> getAllDoctors();

	/**
	 * Gets the doctor by id.
	 *
	 * @param doctorId the doctor id
	 * @return the doctor by id
	 */
	@Select(QueryConstants.DOCTOR_READ)
	Doctor getDoctorById(int doctorId);

	/**
	 * Creates the doctor.
	 *
	 * @param doctor the doctor
	 * @return the int
	 */
	@Insert(QueryConstants.DOCTOR_INSERT)
	@Options(useGeneratedKeys = true, keyProperty = "pkDoctorId", keyColumn = "pk_doctor_id")
	int createDoctor(Doctor doctor);

	/**
	 * Update doctor.
	 *
	 * @param doctor the doctor
	 * @return the int
	 */
	@Update(QueryConstants.DOCTOR_UPDATE)
	int updateDoctor(Doctor doctor);

	/**
	 * Delete doctor.
	 *
	 * @param doctorId the doctor id
	 * @return the int
	 */
	@Delete(QueryConstants.DOCTOR_DELETE)
	int deleteDoctor(int doctorId);

	/**
	 * Find patients of doctor.
	 *
	 * @param doctorId the doctor id
	 * @return the list
	 */
	@Select(QueryConstants.FIND_PATIENTS_BY_DOCTOR_ID)
	List<Patient> findPatientsOfDoctor(int doctorId);

	@Select(QueryConstants.FIND_PATIENTS_FOR_EVERY_DOCTOR)
	@Results(value = { @Result(column = "pk_doctor_id", property = "doctor", one = @One(select = "getDoctorById")),
			@Result(column = "pk_doctor_id", property = "allpatients", many = @Many(select = "findPatientsOfDoctor")) })
	List<DoctorPatientAggregator> findPatientsOfAllDoctors(int doctorId);
}
