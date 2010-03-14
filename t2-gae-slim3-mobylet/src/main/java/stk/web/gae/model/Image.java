package stk.web.gae.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.slim3.datastore.Attribute;
import org.slim3.datastore.InverseModelListRef;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;
import org.slim3.datastore.Sort;
import org.t2framework.commons.exception.IORuntimeException;
import org.t2framework.commons.util.CloseableUtil;

import stk.web.gae.meta.CommentMeta;
import stk.web.gae.meta.ImgUnitMeta;
import stk.web.gae.util.file.GFileUtil;

import com.google.appengine.api.datastore.Key;

/**
 * イメージモデル
 * @author keisuke.oohashi
 */
@Model
public class Image implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** key */
	@Attribute(primaryKey = true)
	private Key key;

	/** version */
	@Attribute(version = true)
	private Long version;

	/** schemaVersion */
	private Integer schemaVersion = 1;

	/** {@link ImgUnit}へのリレーション */
	@Attribute(persistent = false)
	private InverseModelListRef<ImgUnit, Image> imgUnitListRef =
			new InverseModelListRef<ImgUnit, Image>(ImgUnit.class, ImgUnitMeta.get().imageRef,
					this, new Sort(ImgUnitMeta.get().sort));

	/** commentListRef */
	@Attribute(persistent=false)
	private InverseModelListRef<Comment , Image> commentListRef =
			new InverseModelListRef<Comment, Image>(Comment.class, CommentMeta.get().imageRef,
					this, new Sort(CommentMeta.get().updateDate));

	/** 投稿者へのリレーション */
	private ModelRef<Member> updaterRef = new ModelRef<Member>(Member.class);

	/** title */
	private String title;

	/** 投稿者のコメント */
	private String updaterComment;

	/** 作成日 */
	private Date createDate;

	/** size */
	private Integer size;

	/** fileName */
	private String fileName;

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
		Image other = (Image) obj;
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
	 * imgUnitListRefを取得します。
	 * @return imgUnitListRef
	 */
	public InverseModelListRef<ImgUnit, Image> getImgUnitListRef() {
		return imgUnitListRef;
	}

	/**
	 * titleを設定します。
	 * @param title セットするtitle
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * titleを取得します。
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * createDateを設定します。
	 * @param createDate セットするcreateDate
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * createDateを取得します。
	 * @return createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/** イメージデータを返します。
	 * @return イメージデータ
	 */
	public byte[] getImage() {
		ByteArrayOutputStream baos = null;
		try{
			baos = (ByteArrayOutputStream)getImageOutputStream();
			return baos.toByteArray();
		}finally{
			CloseableUtil.close(baos);
		}
	}

	/**
	 * イメージデータのストリームを取得します。
	 * @return イメージデータのストリーム
	 */
	public OutputStream getImageOutputStream(){
		ByteArrayOutputStream baos = null;
		try{
			baos = new ByteArrayOutputStream();
			for (ImgUnit iu : this.getImgUnitListRef().getModelList()) {
				baos.write(iu.getData());
			}
			baos.flush();
			return baos;
		}catch(Exception e){
			CloseableUtil.close(baos);
			throw new IORuntimeException(e);
		}
	}

	/**
	 * イメージデータをセットします。
	 * @param data イメージデータ
	 * @return イメージデータユニット
	 */
	public List<ImgUnit> setImage(byte[] data){
		List<ImgUnit> imgUnitList =  GFileUtil.make(ImgUnit.class, data);
		for (ImgUnit imgUnit : imgUnitList) {
			imgUnit.getImageRef().setModel(this);
		}
		return imgUnitList;
	}

	/**
	 * イメージデータをセットします。
	 * @param is イメージのストリーム
	 * @return イメージを保存します。
	 * @throws IOException
	 */
	public List<ImgUnit> setImage(InputStream is) throws IOException{
		return setImage(IOUtils.toByteArray(is));
	}

	/**
	 * sizeを設定します。
	 * @param size セットするsize
	 */
	public void setSize(Integer size) {
		this.size = size;
	}

	/**
	 * sizeを取得します。
	 * @return size
	 */
	public Integer getSize() {
		return size;
	}

	/**
	 * fileNameを設定します。
	 * @param fileName セットするfileName
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * fileNameを取得します。
	 * @return fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * updaterCommentを設定します。
	 * @param updaterComment セットするupdaterComment
	 */
	public void setUpdaterComment(String updaterComment) {
		this.updaterComment = updaterComment;
	}

	/**
	 * updaterCommentを取得します。
	 * @return updaterComment
	 */
	public String getUpdaterComment() {
		return updaterComment;
	}

	/**
	 * updataRefを取得します。
	 * @return updataRef
	 */
	public ModelRef<Member> getUpdaterRef() {
		return updaterRef;
	}

	/**
	 * 投稿者を取得します
	 * @return 投稿者
	 */
	public Member getUpdater(){
		return this.getUpdaterRef().getModel();
	}

	/**
	 * commentListRefを取得します。
	 * @return commentListRef
	 */
	public InverseModelListRef<Comment , Image> getCommentListRef() {
		return commentListRef;
	}
}
