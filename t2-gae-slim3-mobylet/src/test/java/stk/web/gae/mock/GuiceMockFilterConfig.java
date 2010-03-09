package stk.web.gae.mock;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.slim3.tester.MockServletContext;
import org.t2framework.commons.mock.MockServletConfigImpl;
import org.t2framework.commons.util.Assertion;
import org.t2framework.commons.util.CollectionsUtil.IteratorEnumeration;


public class GuiceMockFilterConfig implements org.t2framework.commons.mock.MockFilterConfig {

	Map<String , String> initParameter = new HashMap<String, String>();

	public GuiceMockFilterConfig(){
		initParameter.put("t2.rootpackage", "stk.web.gae.page");
		initParameter.put("t2.container.adapter" , "stk.t2.gae.commons.adapter.StkGuiceAdapter");
	}

	String filterName;

	@Override
	public void addInitParameter(String key, String value) {
		initParameter.put(key, value);

	}

	@Override
	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

	@Override
	public String getFilterName() {
		return filterName;
	}

	@Override
	public String getInitParameter(String name) {
		Assertion.isNotNull(name);
		return initParameter.get(name);
	}

	@Override
	public Enumeration<String> getInitParameterNames() {
		return new IteratorEnumeration<String>(initParameter.keySet().iterator());
	}

	@Override
	public ServletContext getServletContext() {
		return new MockServletContext();
	}

}
