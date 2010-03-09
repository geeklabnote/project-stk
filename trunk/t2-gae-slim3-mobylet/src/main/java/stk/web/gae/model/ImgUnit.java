package stk.web.gae.model;

import java.io.Serializable;

import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

/**
 * Image Unit
 * @author keisuke.oohashi
 */
@Model
public class ImgUnit extends GFU implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** {@link Image}とのリレーション */
	private ModelRef<Image> imageRef = new ModelRef<Image>(Image.class);

	/**
	 *{@inheritDoc}
	 */
	@Override
	public void setData(byte[] data){
		super.setData(data);
	}

	/**
	 * imageRefを取得します。
	 * @return imageRef
	 */
	public ModelRef<Image> getImageRef() {
		return imageRef;
	}
}
