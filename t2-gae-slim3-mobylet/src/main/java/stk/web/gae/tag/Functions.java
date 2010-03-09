package stk.web.gae.tag;

import java.util.Collection;
import java.util.Map;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

/**
 * タグライブラリ
 * @author soundTrick <keisuke.oohashi@gmail.com>
 *
 */
public class Functions {

	/**
	 * 要素が空かを判定します。
	 * @param o 判定対象の要素
	 * @return 空ならばtrue
	 */
	@SuppressWarnings("unchecked")
	public static Boolean isEmpty(Object o){
		if(o == null){
			return true;
		}
		if(o instanceof Collection){
			return ((Collection)o).isEmpty();
		}
		return o.toString().equals("");
	}


	/**
	 * {@link Key}を文字列にします。
	 * @param key キー
	 * @return 文字列化キー
	 */
	public static String keyString(Key key){
		if(key == null){
			return "";
		}
		return KeyFactory.keyToString(key);
	}

	/**
	 * @see Collection#contains(Object)
	 * @return true:要素が含まれる。
	 */
	public static Boolean contains(Collection<?> c, Object o ){
		if(c == null || o == null){
			return false;
		}
		return c.contains(o);
	}

	public static Boolean containsKey(Map<? , ?> m , Object o ){
		if(m == null || o == null){
			return false;
		}
		return m.containsKey(o);
	}

	public static Boolean containsValue(Map<? , ?> m, Object o){
		if(m == null || o == null){
			return false;
		}
		return m.containsValue(o);
	}

}
