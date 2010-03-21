package com.google.code.stk.t2gae.commons.plugin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slim3.controller.ControllerConstants;
import org.slim3.controller.validator.Errors;
import org.slim3.util.ApplicationMessage;
import org.slim3.util.RequestLocator;
import org.slim3.util.ResponseLocator;
import org.t2framework.t2.plugin.AbstractPlugin;

/**
 * slim3の各種機能を利用するためのPlugin
 * @author keisuke.oohashi
 *
 */
public class Slim3Plugin extends AbstractPlugin {

	/** previousRequest */
	private HttpServletRequest previousRequest;

	/** previousResponse */
	private HttpServletResponse previousResponse;

	/**
	 * slim3のコントローラクラスの代わりにRequest、Response、Errorsの設定を行います。
	 *
	 * @param request Request
	 * @param response Response
	 *
	 * @see org.slim3.controller.FrontController
	 * @see org.t2framework.t2.plugin.AbstractPlugin#beginRequestProcessing(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 *
	 */
	@Override
	public void beginRequestProcessing(HttpServletRequest request, HttpServletResponse response) {

		previousRequest = RequestLocator.get();

		RequestLocator.set(request);

		previousResponse = ResponseLocator.get();

		ResponseLocator.set(response);

		ApplicationMessage.setBundle(ControllerConstants.DEFAULT_LOCALIZATION_CONTEXT, request.getLocale());

		Errors errors = (Errors) request.getAttribute(ControllerConstants.ERRORS_KEY);

		if (errors == null) {

			errors = new Errors();

			request.setAttribute(ControllerConstants.ERRORS_KEY, errors);
		}

		super.beginRequestProcessing(request, response);
	}

	/**
	 * slim3のコントローラクラスの代わりにRequest、Response、Errorsのクリアを行います。
	 *
	 * @param request Request
	 * @param response Response
	 *
	 * @see org.slim3.controller.FrontController
	 * @see org.t2framework.t2.plugin.AbstractPlugin#endRequestProcessing(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void endRequestProcessing(HttpServletRequest request, HttpServletResponse response) {

		ApplicationMessage.clearBundle();

		ResponseLocator.set(previousResponse);

		RequestLocator.set(previousRequest);

		super.endRequestProcessing(request, response);
	}
}
