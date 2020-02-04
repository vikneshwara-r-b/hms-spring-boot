/*
 *
 */
package global.coda.hms.constants;

/**
 * Used in SQL Queries.
 *
 * @author Vc
 */
public final class QueryConstants {
	private QueryConstants() {
		// Query Constants
	}

	/** The Constant IS_ACTIVE. */
	public static final int ACTIVE = 1;

	/** The Constant NOT_ACTIVE. */
	public static final int NOT_ACTIVE = 0;

	/** The Constant PATIENT_ROLE_ID. */
	public static final int PATIENT_ROLE_ID = 2;

	/** The Constant DOCTOR_ROLE_ID. */
	public static final int DOCTOR_ROLE_ID = 3;
	/** The Constant DOCTOR_INSERT. */
	// Doctor Queries
	public static final String DOCTOR_INSERT = "INSERT INTO " + "t_doctor_details "
			+ "(doctor_experience,doctor_speciality,fk_user_id)"
			+ " VALUES (#{doctorExperience},#{doctorSpeciality},#{fkUserId})";

	/** The Constant DOCTOR_READ_ALL. */
	public static final String DOCTOR_READ_ALL = "select user.pk_user_id,user.user_username"
			+ ",user.user_password,user.user_email,user.user_phonenumber,"
			+ "user.user_firstname,user.user_lastname,user.user_age," + "user.user_street,user.user_city,"
			+ "user.user_state,user.fk_role_id," + "doctor.doctor_experience,doctor.doctor_speciality,"
			+ "user.user_isactive,doctor.doctor_isactive,doctor.fk_user_id,"
			+ "doctor.pk_doctor_id,user.user_created_on,user.user_updated_on,doctor.doctor_created_on,doctor.doctor_updated_on "
			+ "from t_user_details as user INNER JOIN t_doctor_details as doctor"
			+ " on user.pk_user_id = doctor.fk_user_id where user.user_isactive=" + ACTIVE
			+ " and doctor.doctor_isactive=" + ACTIVE + " and user.fk_role_id=" + DOCTOR_ROLE_ID;

	/** The Constant DOCTOR_READ. */
	public static final String DOCTOR_READ = "<script>select user.pk_user_id,user.user_username,"
			+ "user.user_password,user.user_email,user.user_phonenumber,"
			+ "user.user_firstname,user.user_lastname,user.user_age,user.user_street,"
			+ "user.user_city,user.user_state,user.fk_role_id,doctor.doctor_experience,doctor.fk_user_id,"
			+ "doctor.doctor_speciality,user.user_isactive,doctor.doctor_isactive,"
			+ "doctor.pk_doctor_id,user.user_created_on,user.user_updated_on,doctor.doctor_created_on,doctor.doctor_updated_on from"
			+ " t_user_details as user INNER JOIN t_doctor_details as doctor on user.pk_user_id = doctor.fk_user_id"
			+ " where user.user_isactive=" + ACTIVE + " and doctor.doctor_isactive=" + ACTIVE + " and user.fk_role_id="
			+ DOCTOR_ROLE_ID + " and <if test='doctorId!=0'>doctor.pk_doctor_id=#{doctorId}</if></script>";

	/** The Constant DOCTOR_DELETE. */
	public static final String DOCTOR_DELETE = "update t_user_details as user,t_doctor_details as doctor "
			+ "set user.user_isactive=" + NOT_ACTIVE + ",doctor.doctor_isactive=" + NOT_ACTIVE
			+ " where doctor.pk_doctor_id=#{doctorId} and "
			+ "user.pk_user_id=doctor.fk_user_id and user.user_isactive=" + ACTIVE + " and doctor.doctor_isactive="
			+ ACTIVE + " and user.fk_role_id =" + DOCTOR_ROLE_ID;

	/** The Constant DOCTOR_UPDATE. */
	public static final String DOCTOR_UPDATE = "update t_doctor_details set doctor_experience=#{doctorExperience},"
			+ "doctor_speciality=#{doctorSpeciality} where pk_doctor_id=#{pkDoctorId}";

	/** The Constant PATIENT_INSERT. */
	// Patient Queries
	public static final String PATIENT_INSERT = "INSERT INTO  t_patient_details ( patient_height,patient_blood_group,"
			+ "patient_weight,fk_userid) VALUES (#{patientHeight},#{patientBloodGroup},#{patientHeight},#{fkUserid})";

	/** The Constant PATIENT_READ_ALL. */
	public static final String PATIENT_READ_ALL = "<script>select user.pk_user_id,"
			+ "user.user_username,user.user_password,user.user_email,"
			+ "user.user_phonenumber,user.user_firstname,user.user_lastname"
			+ ",user.user_age,user.user_street,user.user_city,user.user_state,"
			+ "user.fk_role_id,patient.patient_height,patient.patient_blood_group,"
			+ "patient.patient_created_on,patient.patient_updated_on,"
			+ "patient.fk_userid,patient.patient_weight,user.user_isactive,"
			+ "user.user_created_on,user.user_updated_on,patient.patient_isactive,"
			+ "patient.pk_patient_id from t_user_details" + " as user INNER JOIN t_patient_details as patient"
			+ " on user.pk_user_id = patient.fk_userid " + "where user.user_isactive=1 and patient.patient_isactive=1 "
			+ "and user.fk_role_id=2 " + "<if test='id!=0'>and patient.pk_patient_id=#{id}</if></script>";

	/** The Constant PATIENT_READ. */
	public static final String PATIENT_READ = "select user.pk_user_id,"
			+ "user.user_username,user.user_password,user.user_email,"
			+ "user.user_phonenumber,user.user_firstname,user.user_lastname"
			+ ",user.user_age,user.user_street,user.user_city,user.user_state,"
			+ "user.fk_role_id,patient.patient_height,patient.patient_blood_group,"
			+ "patient.patient_created_on,patient.patient_updated_on,"
			+ "patient.fk_userid,patient.patient_weight,user.user_isactive,"
			+ "user.user_created_on,user.user_updated_on,patient.patient_isactive,"
			+ "patient.pk_patient_id from t_user_details" + " as user INNER JOIN t_patient_details as patient"
			+ " on user.pk_user_id = patient.fk_userid " + "where user.user_isactive=1 and patient.patient_isactive=1 "
			+ "and user.fk_role_id=2 and " + "patient.pk_patient_id=#{id}";

	/** The Constant PATIENT_DELETE. */
	public static final String PATIENT_DELETE = "update t_user_details as user,t_patient_details as"
			+ " patient set user.user_isactive=0,patient.patient_isactive=0 where patient.pk_patient_id=#{patientId} "
			+ "and user.pk_user_id=patient.fk_userid and patient.patient_isactive=1 and user.user_isactive=1 and  "
			+ "user.fk_role_id =2";

	/** The Constant PATIENT_UPDATE. */
	public static final String PATIENT_UPDATE = "update t_patient_details set "
			+ " patient_height=#{patientHeight},patient_blood_group=#{patientBloodGroup},patient_weight=#{patientWeight} "
			+ "where pk_patient_id=#{pkPatientId} and patient_isactive=" + ACTIVE;

	/** The Constant USER_SELECT_WITH_ID. */
	// User Queries
	public static final String USER_SELECT_WITH_ID = "select * from t_user_details where "
			+ "user_username=? and user_password=?";

	/** The Constant USER_INSERT. */
	public static final String USER_INSERT = "INSERT INTO `hospital_management_system`."
			+ "`t_user_details` (`user_username`, `user_password`, `user_email`,"
			+ " `user_phonenumber`, `user_firstname`, `user_lastname`," + " `user_age`, `user_city`,"
			+ " `user_state`, `user_street`, `fk_role_id`) VALUES"
			+ " (#{userUsername},#{userPassword},#{userEmail},#{userPhonenumber},#{userFirstname},#{userLastname},"
			+ " #{userAge},#{userCity},#{userState},#{userStreet},#{fkRoleId})";

	/** The Constant USER_UPDATE. */
	public static final String USER_UPDATE = "update t_user_details set user_username=#{userUsername},"
			+ "user_password=#{userPassword},user_email=#{userEmail},user_phonenumber=#{userPhonenumber},user_firstname=#{userFirstname},"
			+ "user_lastname=#{userLastname},user_age=#{userAge},user_city=#{userCity},user_state=#{userState},user_street=#{userStreet}"
			+ " where pk_user_id=#{pkUserId} and user_isactive=1 ";

	/** The Constant FIND_PATIENTS_BY_DOCTOR_ID. */
	public static final String FIND_PATIENTS_BY_DOCTOR_ID = "select user.*,patient.patient_height,"
			+ "patient.patient_blood_group,\r\n" + "patient.patient_weight,record.patient_disease,\r\n"
			+ "patient.pk_patient_id,\r\n" + "patient.patient_isactive,record.fk_doctor_id from \r\n"
			+ "t_user_details user INNER JOIN t_patient_details patient \r\n"
			+ "ON user.pk_user_id=patient.fk_userid \r\n"
			+ "INNER JOIN t_record record ON record.fk_patient_id=patient.pk_patient_id\r\n"
			+ "WHERE user.user_isactive=1 and patient.patient_isactive=1 \r\n"
			+ "and record.doctor_patient_mapping_isactive=1  and record.fk_doctor_id=#{doctorId}\r\n"
			+ "group by patient.pk_patient_id \r\n" + "order by patient.pk_patient_id asc";

	/** The Constant SELECT_ALL_DOCTOR_ID. */
	public static final String SELECT_ALL_DOCTOR_ID = "select pk_user_id from t_user_details " + "where fk_role_id=3";

	public static final String FIND_PATIENTS_FOR_EVERY_DOCTOR = "<script> Select pk_doctor_id from t_doctor_details "
			+ "<if test='doctorId!=0'>where pk_doctor_id=#{doctorId} </if>"
			+ "<if test='doctorId==0'>order by pk_doctor_id</if></script>";
}
