package stk.web.gae.model;

import java.io.Serializable;

import com.google.appengine.api.datastore.Key;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

/**
 * Google File Unit
 * @author keisuke.oohashi
 *
 */
@Model
public class GFU implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** key */
	@Attribute(primaryKey = true)
	private Key key;

	/** data */
	@Attribute(lob=true)
	private byte[] data;

	/** sort */
	private Integer sort;

	/** version */
	@Attribute(version = true)
	private Long version;

	/** schemaVersion */
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
		GFU other = (GFU) obj;
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
	 * dataを設定します。
	 * @param data セットするdata
	 */
	public void setData(byte[] data) {
		this.data = data;
	}

	/**
	 * dataを取得します。
	 * @return data
	 */
	public byte[] getData() {
		return data;
	}

	/**
	 * sortを設定します。
	 * @param sort セットするsort
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	/**
	 * sortを取得します。
	 * @return sort
	 */
	public Integer getSort() {
		return sort;
	}
}
