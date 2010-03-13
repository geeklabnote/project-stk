package stk.web.gae.model;

import java.io.Serializable;

import com.google.appengine.api.datastore.Key;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

/**
 * Memberを表す
 * @author keisuke.oohashi
 */
@Model
public class Member implements Serializable {

	private static final long serialVersionUID = 1L;

	@Attribute(primaryKey = true)
	private Key key;

	/** nickName */
	private String nickName;

	/** passward */
	private String password;

	/** admin */
	private boolean admin;

	@Attribute(version = true)
	private Long version;

	private Integer schemaVersion = 1;


	/**
	 * Returns the key.
	 *
	 * @return the key
	 */
	public Key getKey() {
		return key;
	}

	/**
	 * Sets the key.
	 *
	 * @param key
	 *            the key
	 */
	public void setKey(Key key) {
		this.key = key;
	}

	/**
	 * Returns the version.
	 *
	 * @return the version
	 */
	public Long getVersion() {
		return version;
	}

	/**
	 * Sets the version.
	 *
	 * @param version
	 *            the version
	 */
	public void setVersion(Long version) {
		this.version = version;
	}

	/**
	 * Returns the schema version.
	 *
	 * @return the schema version
	 */
	public Integer getSchemaVersion() {
		return schemaVersion;
	}

	/**
	 * Sets the schema version.
	 *
	 * @param schemaVersion
	 *            the schema version
	 */
	public void setSchemaVersion(Integer schemaVersion) {
		this.schemaVersion = schemaVersion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Member other = (Member) obj;
		if (key == null) {
			if (other.key != null) {
				return false;
			}
		} else if (!key.equals(other.key)) {
			return false;
		}
		return true;
	}

	/**
	 * nickNameを設定します。
	 * @param nickName セットするnickName
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * nickNameを取得します。
	 * @return nickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * adminを設定します。
	 * @param admin セットするadmin
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	/**
	 * adminを取得します。
	 * @return admin
	 */
	public boolean getAdmin() {
		return admin;
	}

	@Override
	public String toString() {
		return "Member [admin=" + admin + ", key=" + key + ", nickName=" + nickName + ", password="
				+ password + "]";
	}

	/**
	 * passwordを設定します。
	 * @param password セットするpassword
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * passwordを取得します。
	 * @return password
	 */
	public String getPassword() {
		return password;
	}


}
