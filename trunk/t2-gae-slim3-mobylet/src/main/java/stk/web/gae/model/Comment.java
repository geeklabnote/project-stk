package stk.web.gae.model;

import java.io.Serializable;
import java.util.Date;

import com.google.appengine.api.datastore.Key;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

/**
 * コメント
 * @author keisuke.oohashi
 */
@Model
public class Comment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Attribute(primaryKey = true)
	private Key key;

	@Attribute(version = true)
	private Long version;

	/** value */
	private String value;

	/** imageRef */
	private ModelRef<Image> imageRef = new ModelRef<Image>(Image.class);

	/** voterRef */
	private ModelRef<Member> voterRef = new ModelRef<Member>(Member.class);

	private Date updateDate;

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
		Comment other = (Comment) obj;
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
	 * valueを設定します。
	 * @param value セットするvalue
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * valueを取得します。
	 * @return value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * voterRefを取得します。
	 * @return voterRef
	 */
	public ModelRef<Member> getVoterRef() {
		return voterRef;
	}

	/**
	 * imageRefを取得します。
	 * @return imageRef
	 */
	public ModelRef<Image> getImageRef() {
		return imageRef;
	}

	/**
	 * updateDateを設定します。
	 * @param updateDate セットするupdateDate
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * updateDateを取得します。
	 * @return updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
}
