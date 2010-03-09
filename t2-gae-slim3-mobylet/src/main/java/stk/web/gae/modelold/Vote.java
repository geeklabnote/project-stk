package stk.web.gae.modelold;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

import stk.t2.gae.commons.enums.CodeEnum;

import com.google.appengine.api.datastore.Key;

@Model
public class Vote {

	/** key */
	@Attribute(primaryKey = true)
	private Key key;

	/** type */
	private VoteType type;

	/** voterKey */
	private Key voterKey;


	public enum VoteType implements CodeEnum {
		OMOSHIRO("0", "おもしろい"), KANDOU("1", "感動した"), BIKKURI("2", "ビックリした");

		private String code;

		private String display;


		private VoteType(String code, String display) {
			this.code = code;
			this.display = display;
		}

		@Override
		public String getCode() {
			return this.code;
		}

		@Override
		public String getDisplay() {
			return this.display;
		}
	}


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
	 * typeを取得します。
	 * @return type
	 */
	public VoteType getType() {
		return type;
	}

	/**
	 * typeを設定します。
	 * @param type type
	 */
	public void setType(VoteType type) {
		this.type = type;
	}

	/**
	 * voterKeyを取得します。
	 * @return voterKey
	 */
	public Key getVoterKey() {
		return voterKey;
	}

	/**
	 * voterKeyを設定します。
	 * @param voterKey voterKey
	 */
	public void setVoterKey(Key voterKey) {
		this.voterKey = voterKey;
	}

}
