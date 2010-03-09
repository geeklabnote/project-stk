package stk.web.gae.servlet.mail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slim3.datastore.Datastore;

import stk.web.gae.modelold.Image;

import com.google.appengine.api.datastore.Transaction;
import com.google.appengine.api.images.ImagesServiceFactory;

public class MailHandlerServlet extends HttpServlet {
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(final HttpServletRequest req, final HttpServletResponse resp)
	throws ServletException, IOException {
		try {
			final Properties prop = new Properties();
			final Session session = Session.getDefaultInstance(prop, null);
			final MimeMessage message = new MimeMessage(session, req.getInputStream());
			processPart(message);
		} catch (final MessagingException e) {
			e.printStackTrace();
		}
	}

	private void processPart(final Part part) throws MessagingException, IOException, ServletException {


		final Image image = new Image();
		processPart(part , image);
		if(image.getImageUnitKeyList() != null && !image.getImageUnitKeyList().isEmpty()){
			Transaction tx = null;
			try{
				tx = Datastore.beginTransaction();
				Datastore.put(tx , image);
				tx.commit();
			}catch(final Exception e){
				tx.rollback();
				throw new ServletException(e);
			}
		}

	}
	private void processPart(final Part part , final Image image) throws MessagingException, IOException, ServletException {
		if (part.isMimeType("multipart/*")) {
			/* マルチパートの場合 ------------------------------------------------- */

			final Multipart content = (Multipart)part.getContent();


			// 含まれるパートを再帰的に処理
			final int count = content.getCount();
			for (int i = 0; i < count; i++) {
				processPart(content.getBodyPart(i) , image);
			}

		} else if (part.isMimeType("text/*")) {
			/* テキストの場合 ----------------------------------------------------- */

			final InputStream is = part.getInputStream();
			final Reader r = new InputStreamReader(is);
			final BufferedReader buf = new BufferedReader(r);

			/* テキスト内容 */
			final StringBuilder sb = new StringBuilder();
			for (String line; (line = buf.readLine()) != null;) {
				sb.append(line + " ");
			}

			image.setTitle(sb.toString());

		} else {
			// その他の場合

			/* 添付ファイルを保存 */
			image.setImage(getAttachmentsAsImage(part));
		}
	}

	/**
	 * 添付ファイルを取得
	 *
	 * @param part
	 * @throws MessagingException
	 * @throws IOException
	 */

	private byte[] getAttachmentsAsImage(final Part part) throws MessagingException,
	IOException {

		final String disp = part.getDisposition();

		if (disp == null || disp.equalsIgnoreCase(Part.ATTACHMENT)) {
			/* ファイル内容 */
			final byte[] imageData = IOUtils.toByteArray(part.getInputStream());
			ImagesServiceFactory.makeImage(imageData);
			return imageData;
		}else{
			return "".getBytes();
		}
	}

}
