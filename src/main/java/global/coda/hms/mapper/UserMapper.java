/*
 *
 */
package global.coda.hms.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;

import global.coda.hms.constants.QueryConstants;
import global.coda.hms.models.User;

/**
 * The Interface UserMapper.
 */
@Mapper
public interface UserMapper {

	/**
	 * Creates the user.
	 *
	 * @param user the user
	 * @return the int
	 */
	@Insert(QueryConstants.USER_INSERT)
	@Options(useGeneratedKeys = true, keyColumn = "pk_user_id", keyProperty = "pkUserId")
	int createUser(User user);

	/**
	 * Update user.
	 *
	 * @param user the user
	 * @return the int
	 */
	@Update(QueryConstants.USER_UPDATE)
	int updateUser(User user);

}
