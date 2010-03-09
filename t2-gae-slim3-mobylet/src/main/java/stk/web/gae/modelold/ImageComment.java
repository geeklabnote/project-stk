/**
 *
 */
package stk.web.gae.modelold;

import java.io.Serializable;
import java.util.Date;

import com.google.appengine.api.datastore.Key;

/**
 * イメージに対するコメント
 * @author soundTrick <keisuke.oohashi@gmail.com>
 */
public class ImageComment implements Serializable{
	/** serialVersionUID */
	private static final long serialVersionUID = -211956313198656045L;

	/** 投稿者キー */
	private Key postMemberKey;

	/** 投稿日 */
	private Date postDate;

	/** コメント */
	private String text;

	/**
	 * 投稿者キーを取得します。
	 * @return 投稿者キー
	 */
	public Key getPostMemberKey() {
	    return postMemberKey;
	}

	/**
	 * 投稿者キーを設定します。
	 * @param postMemberKey 投稿者キー
	 */
	public void setPostMemberKey(Key postMemberKey) {
	    this.postMemberKey = postMemberKey;
	}

	/**
	 * 投稿日を取得します。
	 * @return 投稿日
	 */
	public Date getPostDate() {
	    return postDate;
	}

	/**
	 * 投稿日を設定します。
	 * @param postDate 投稿日
	 */
	public void setPostDate(Date postDate) {
	    this.postDate = postDate;
	}

	/**
	 * コメントを取得します。
	 * @return コメント
	 */
	public String getText() {
	    return text;
	}

	/**
	 * コメントを設定します。
	 * @param text コメント
	 */
	public void setText(String text) {
	    this.text = text;
	}
}