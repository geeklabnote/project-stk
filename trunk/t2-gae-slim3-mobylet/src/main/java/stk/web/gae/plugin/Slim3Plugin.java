package stk.web.gae.plugin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slim3.controller.ControllerConstants;
import org.slim3.controller.validator.Errors;
import org.slim3.util.ApplicationMessage;
import org.slim3.util.RequestLocator;
import org.t2framework.t2.plugin.AbstractPlugin;


/**
 * slim3の各種機能を利用するためのPlugin
 * @author keisuke.oohashi
 *
 */
public class Slim3Plugin extends AbstractPlugin {

	@Override
	public void beginRequestProcessing(HttpServletRequest request, HttpServletResponse response) {
		RequestLocator.set(request);

		ApplicationMessage.setBundle(ControllerConstants.DEFAULT_LOCALIZATION_CONTEXT, request.getLocale());

		request.setAttribute(ControllerConstants.ERRORS_KEY, new Errors());

		super.beginRequestProcessing(request, response);
	}
}
