package stk.web.gae.modelold;

import java.io.Serializable;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

/**
 * 会員
 * @author Administrator
 */
@Model
public class Member implements Serializable {
	/** serialVersionUID */
	private static final long serialVersionUID = -6103138183858054191L;

	/** key */
	@Attribute(primaryKey=true)
	private Key key;

	/** uid */
	@Attribute
	private String uid;

	/** password */
	@Attribute
	private String password;

	/** nickName */
	@Attribute
	private String nickName;

	/** admin */
	@Attribute
	private Boolean admin;

	/**
	 * keyを取得します。
	 * @return key
	 */
	public Key getKey() {
	    return key;
	}

	/**
	 * keyを設定します。
	 * @param key key
	 */
	public void setKey(Key key) {
	    this.key = key;
	}

	/**
	 * uidを取得します。
	 * @return uid
	 */
	public String getUid() {
	    return uid;
	}

	/**
	 * uidを設定します。
	 * @param uid uid
	 */
	public void setUid(String uid) {
	    this.uid = uid;
	}

	/**
	 * passwordを取得します。
	 * @return password
	 */
	public String getPassword() {
	    return password;
	}

	/**
	 * passwordを設定します。
	 * @param password password
	 */
	public void setPassword(String password) {
	    this.password = password;
	}

	/**
	 * nickNameを取得します。
	 * @return nickName
	 */
	public String getNickName() {
	    return nickName;
	}

	/**
	 * nickNameを設定します。
	 * @param nickName nickName
	 */
	public void setNickName(String nickName) {
	    this.nickName = nickName;
	}

	/**
	 * adminを取得します。
	 * @return admin
	 */
	public Boolean getAdmin() {
	    return admin;
	}

	/**
	 * adminを設定します。
	 * @param admin admin
	 */
	public void setAdmin(Boolean admin) {
	    this.admin = admin;
	}
}
