package stk.web.gae.modelold;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

/**
 * ImageのUnitデータ
 * @author 大橋
 *
 */
@Model
public class ImageUnit {
	/** key */
	@Attribute(primaryKey=true)
	private Key key;

	/** Imgageの分割データ */
	@Attribute(lob=true)
	private byte[] data;

	/** 番号 */
	private Integer number;

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
	 * Imgageの分割データを取得します。
	 * @return Imgageの分割データ
	 */
	public byte[] getData() {
	    return data;
	}

	/**
	 * Imgageの分割データを設定します。
	 * @param data Imgageの分割データ
	 */
	public void setData(byte[] data) {
	    this.data = data;
	}

	/**
	 * 番号を取得します。
	 * @return 番号
	 */
	public Integer getNumber() {
	    return number;
	}

	/**
	 * 番号を設定します。
	 * @param number 番号
	 */
	public void setNumber(Integer number) {
	    this.number = number;
	}

}
