package stk.web.gae.modelold;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.slim3.datastore.Attribute;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.Model;
import org.slim3.util.ByteUtil;

import com.google.appengine.api.datastore.Key;

/**
 * イメージデータ
 * @author soundTrick <keisuke.oohashi@gmail.com>
 */
@Model
public class Image {
	/** key */
	@Attribute(primaryKey=true)
	private Key key;

	/** imageのバイトデータキーリスト */
	private List<Key> imageUnitKeyList;

	/** 投稿者 */
	private Key updaterKey;

	/** title */
	private String title;

	/** コメントリスト */
	@Attribute(lob=true)
	private List<ImageComment> commentList;

	/** 投票者Keyリスト */
	private List<Key> voterKeyList;

	/** 投票内容 */
	private List<Key> voteKeyList;

	/** 作成日 */
	private Date createDate;

	private String fileName;

	/**
	 * keyを取得します。
	 * @return key
	 */
	public Key getKey() {
		return this.key;
	}

	/**
	 * keyを設定します。
	 * @param key key
	 */
	public void setKey(final Key key) {
		this.key = key;
	}

	/**
	 * 投稿者を取得します。
	 * @return 投稿者
	 */
	public Key getUpdaterKey() {
		return this.updaterKey;
	}

	/**
	 * 投稿者を設定します。
	 * @param updaterKey 投稿者
	 */
	public void setUpdaterKey(final Key updaterKey) {
		this.updaterKey = updaterKey;
	}

	/**
	 * titleを取得します。
	 * @return title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * titleを設定します。
	 * @param title title
	 */
	public void setTitle(final String title) {
		this.title = title;
	}

	/**
	 * コメントリストを取得します。
	 * @return コメントリスト
	 */
	public List<ImageComment> getCommentList() {
		return this.commentList;
	}

	/**
	 * コメントリストを設定します。
	 * @param commentList コメントリスト
	 */
	public void setCommentList(final List<ImageComment> commentList) {
		this.commentList = commentList;
	}

	/**
	 * 投票者Keyリストを取得します。
	 * @return 投票者Keyリスト
	 */
	public List<Key> getVoterKeyList() {
		return this.voterKeyList;
	}

	/**
	 * 投票者Keyリストを設定します。
	 * @param voterKeyList 投票者Keyリスト
	 */
	public void setVoterKeyList(final List<Key> voterKeyList) {
		this.voterKeyList = voterKeyList;
	}

	/**
	 * 投票内容を取得します。
	 * @return 投票内容
	 */
	public List<Key> getVoteKeyList() {
		return this.voteKeyList;
	}

	/**
	 * 投票内容を設定します。
	 * @param voteKeyList 投票内容
	 */
	public void setVoteKeyList(final List<Key> voteKeyList) {
		this.voteKeyList = voteKeyList;
	}

	/**
	 * 作成日を取得します。
	 * @return 作成日
	 */
	public Date getCreateDate() {
		return this.createDate;
	}

	/**
	 * 作成日を設定します。
	 * @param createDate 作成日
	 */
	public void setCreateDate(final Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @param imageUnitKeyList セットする imageUnitKeyList
	 */
	public void setImageUnitKeyList(final List<Key> imageUnitKeyList) {
		this.imageUnitKeyList = imageUnitKeyList;
	}

	/**
	 * @return imageUnitKeyList
	 */
	public List<Key> getImageUnitKeyList() {
		return this.imageUnitKeyList;
	}

	/**
	 * イメージデータをDatastoreから取得します。
	 * @return イメージデータ
	 */
	public byte[] getImage(){
		if(getImageUnitKeyList() == null || getImageUnitKeyList().isEmpty()){
			return "".getBytes();
		}

		final List<ImageUnit> imageUnitList = Datastore.get(ImageUnit.class , getImageUnitKeyList());
		Collections.sort(imageUnitList, new Comparator<ImageUnit>() {
			@Override
			public int compare(final ImageUnit o1, final ImageUnit o2) {
				return o1.getNumber() - o2.getNumber();
			}
		});
		final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try{
			for (final ImageUnit imageUnit : imageUnitList) {
				baos.write(imageUnit.getData());
			}
			baos.flush();
			return baos.toByteArray();
		}catch(final Exception e){
			return "".getBytes();
		}finally{
			IOUtils.closeQuietly(baos);
		}
	}

	/**
	 * 渡されたデータをDatastoreへ登録します。
	 * @param data イメージデータ
	 */
	public void setImage(final byte[] data){
		final byte[][] splitData = ByteUtil.split(data, 50000);
		final List<Key> keys = new ArrayList<Key>();
		int i = 0;
		for (final byte[] bs : splitData) {
			final ImageUnit unit = new ImageUnit();
			unit.setData(bs);
			unit.setNumber(i);
			unit.setKey(Datastore.allocateId(getKey(), ImageUnit.class));
			keys.add(Datastore.put(unit));
			i++;
		}
		setImageUnitKeyList(keys);
	}

	/**
	 * @param fileName セットする fileName
	 */
	public void setFileName(final String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return fileName
	 */
	public String getFileName() {
		return this.fileName;
	}

}
