package stk.web.gae.util.file;

import java.util.ArrayList;
import java.util.List;

import org.slim3.util.ByteUtil;
import org.t2framework.commons.util.Reflections.ClassUtil;

import stk.web.gae.model.GFU;


/**
 * GoogleFileUtil
 * @author keisuke.oohashi
 */
public class GFileUtil {
	/** デフォルトコンストラクタ */
	private GFileUtil(){
		//none create instance
	}

	/**
	 * GoogleFileUnitを作成します。
	 * @param <T> GFUを継承したデータ
	 * @param clazz
	 * @param data
	 * @return GFUのリスト
	 */
	public static <T extends GFU> List<T> make(Class<T> clazz ,byte[] data ){
		byte[][] splitData = ByteUtil.split(data, 500 * 1024);
		List<T> tList = new ArrayList<T>();
		int i = 0;
		for (final byte[] bs : splitData) {
			T unit = ClassUtil.newInstance(clazz);
			unit.setData(bs);
			unit.setSort(i);
			tList.add(unit);
			i++;
		}
		return tList;
	}
}
