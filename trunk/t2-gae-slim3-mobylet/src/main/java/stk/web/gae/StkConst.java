package stk.web.gae;

/**
 * 定数クラス.
 * @author soundTrick <keisuke.oohashi@gmail.com>
 */
public class StkConst {
	/** サポートしている拡張子 */
	private static final String[] SUPPORTED_EXTENSIONS
					= {"jpeg" , "jpg" , "png" , "gif"
						};

	/**
	 * サポートしている拡張子を返却
	 * @return サポートしている拡張子の配列
	 */
	public static String[] getSupportedExtensions(){
		return SUPPORTED_EXTENSIONS;
	}

	/** jspフォルダのルート */
	public static final String JSP_PREFIX = "/";

	/** MAX_IMAGE_BYTES */
	public static final int MAX_IMAGE_BYTES = 1024 * 1000;
}
