package stk.web.gae.handler;

import java.util.logging.Logger;

import org.t2framework.t2.contexts.WebContext;
import org.t2framework.t2.handler.ExceptionHandler;
import org.t2framework.t2.navigation.Forward;
import org.t2framework.t2.navigation.Redirect;
import org.t2framework.t2.spi.Navigation;

import stk.t2.gae.commons.exception.AuthException;
import stk.t2.gae.commons.exception.StkUserException;

public class StkExceptionHandler implements ExceptionHandler<StkUserException, Exception> {

	private static final Logger logger = Logger.getLogger(StkExceptionHandler.class.getName());


	@Override
	public Navigation handleException(StkUserException t, WebContext context, Navigation result)
			throws Exception {
		StkUserException sue = (StkUserException) t;
		context.getSession().setAttribute("ERROR_MESSAGE", sue.getMessage());
		logger.warning(sue.getMessage());
		if (context.getRequest().isAmfRequest() || context.getRequest().isAjaxRequest()
				|| context.getRequest().isMultipartType()) {
			context.getResponse().sendError(500);
		}
		return Redirect.to((String)context.getRequest().getAttribute("loginUrl"));
	}

	@Override
	public boolean isTargetException(Throwable t) {
		if (t == null) {
			return false;
		}
		return t instanceof StkUserException || t.getCause() instanceof StkUserException;
	}
}
