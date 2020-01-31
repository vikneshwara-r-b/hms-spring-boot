/*
 *
 */
package global.coda.hms.models;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * The Class User.
 */
public class User {

	/** The pk user id. */
	private int pkUserId;

	/** The user username. */
	private String userUsername;

	@JsonProperty(access = Access.WRITE_ONLY)
	/** The user password. */
	private String userPassword;

	/** The user email. */
	private String userEmail;

	/** The user phonenumber. */
	private String userPhonenumber;

	/** The user firstname. */
	private String userFirstname;

	/** The user lastname. */
	private String userLastname;

	/** The user age. */
	private int userAge;

	/** The user city. */
	private String userCity;

	/** The user state. */
	private String userState;

	/** The user street. */
	private String userStreet;

	/** The fk role id. */
	private int fkRoleId;

	/** The user isactive. */
	private int userIsactive;

	/** The user created on. */
	@JsonProperty(access = Access.READ_ONLY)
	private Timestamp userCreatedOn;

	/** The user updated on. */
	@JsonProperty(access = Access.READ_ONLY)
	private Timestamp userUpdatedOn;

	/**
	 * Gets the pk user id.
	 *
	 * @return the pk user id
	 */
	public int getPkUserId() {
		return pkUserId;
	}

	/**
	 * Sets the pk user id.
	 *
	 * @param pkUserId the new pk user id
	 */
	public void setPkUserId(int pkUserId) {
		this.pkUserId = pkUserId;
	}

	/**
	 * Gets the user username.
	 *
	 * @return the user username
	 */
	public String getUserUsername() {
		return userUsername;
	}

	/**
	 * Sets the user username.
	 *
	 * @param userUsername the new user username
	 */
	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}

	/**
	 * Gets the user password.
	 *
	 * @return the user password
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * Sets the user password.
	 *
	 * @param userPassword the new user password
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * Gets the user email.
	 *
	 * @return the user email
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * Sets the user email.
	 *
	 * @param userEmail the new user email
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * Gets the user phonenumber.
	 *
	 * @return the user phonenumber
	 */
	public String getUserPhonenumber() {
		return userPhonenumber;
	}

	/**
	 * Sets the user phonenumber.
	 *
	 * @param userPhonenumber the new user phonenumber
	 */
	public void setUserPhonenumber(String userPhonenumber) {
		this.userPhonenumber = userPhonenumber;
	}

	/**
	 * Gets the user firstname.
	 *
	 * @return the user firstname
	 */
	public String getUserFirstname() {
		return userFirstname;
	}

	/**
	 * Sets the user firstname.
	 *
	 * @param userFirstname the new user firstname
	 */
	public void setUserFirstname(String userFirstname) {
		this.userFirstname = userFirstname;
	}

	/**
	 * Gets the user lastname.
	 *
	 * @return the user lastname
	 */
	public String getUserLastname() {
		return userLastname;
	}

	/**
	 * Sets the user lastname.
	 *
	 * @param userLastname the new user lastname
	 */
	public void setUserLastname(String userLastname) {
		this.userLastname = userLastname;
	}

	/**
	 * Gets the user age.
	 *
	 * @return the user age
	 */
	public int getUserAge() {
		return userAge;
	}

	/**
	 * Sets the user age.
	 *
	 * @param userAge the new user age
	 */
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	/**
	 * Gets the user city.
	 *
	 * @return the user city
	 */
	public String getUserCity() {
		return userCity;
	}

	/**
	 * Sets the user city.
	 *
	 * @param userCity the new user city
	 */
	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	/**
	 * Gets the user state.
	 *
	 * @return the user state
	 */
	public String getUserState() {
		return userState;
	}

	/**
	 * Sets the user state.
	 *
	 * @param userState the new user state
	 */
	public void setUserState(String userState) {
		this.userState = userState;
	}

	/**
	 * Gets the user street.
	 *
	 * @return the user street
	 */
	public String getUserStreet() {
		return userStreet;
	}

	/**
	 * Sets the user street.
	 *
	 * @param userStreet the new user street
	 */
	public void setUserStreet(String userStreet) {
		this.userStreet = userStreet;
	}

	/**
	 * Gets the fk role id.
	 *
	 * @return the fk role id
	 */
	public int getFkRoleId() {
		return fkRoleId;
	}

	/**
	 * Sets the fk role id.
	 *
	 * @param fkRoleId the new fk role id
	 */
	public void setFkRoleId(int fkRoleId) {
		this.fkRoleId = fkRoleId;
	}

	/**
	 * Gets the user isactive.
	 *
	 * @return the user isactive
	 */
	public int getUserIsactive() {
		return userIsactive;
	}

	/**
	 * Sets the user isactive.
	 *
	 * @param userIsactive the new user isactive
	 */
	public void setUserIsactive(int userIsactive) {
		this.userIsactive = userIsactive;
	}

	/**
	 * Gets the user created on.
	 *
	 * @return the user created on
	 */
	public Timestamp getUserCreatedOn() {
		return userCreatedOn;
	}

	/**
	 * Sets the user created on.
	 *
	 * @param userCreatedOn the new user created on
	 */
	public void setUserCreatedOn(Timestamp userCreatedOn) {
		this.userCreatedOn = userCreatedOn;
	}

	/**
	 * Gets the user updated on.
	 *
	 * @return the user updated on
	 */
	public Timestamp getUserUpdatedOn() {
		return userUpdatedOn;
	}

	/**
	 * Sets the user updated on.
	 *
	 * @param userUpdatedOn the new user updated on
	 */
	public void setUserUpdatedOn(Timestamp userUpdatedOn) {
		this.userUpdatedOn = userUpdatedOn;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "User [pkUserId=" + pkUserId + ", userUsername=" + userUsername + ", userPassword=" + userPassword
				+ ", userEmail=" + userEmail + ", userPhonenumber=" + userPhonenumber + ", userFirstname="
				+ userFirstname + ", userLastname=" + userLastname + ", userAge=" + userAge + ", userCity=" + userCity
				+ ", userState=" + userState + ", userStreet=" + userStreet + ", fkRoleId=" + fkRoleId
				+ ", userIsactive=" + userIsactive + ", userCreatedOn=" + userCreatedOn + ", userUpdatedOn="
				+ userUpdatedOn + "]";
	}

}
