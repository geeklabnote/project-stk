package com.google.gwt.user.client.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class WindowImplIE_Resources_default_StaticClientBundleGenerator implements com.google.gwt.user.client.impl.WindowImplIE.Resources {
  public com.google.gwt.resources.client.TextResource initWindowCloseHandler() {
    return initWindowCloseHandler;
  }
  public com.google.gwt.resources.client.TextResource initWindowResizeHandler() {
    return initWindowResizeHandler;
  }
  public com.google.gwt.resources.client.TextResource initWindowScrollHandler() {
    return initWindowScrollHandler;
  }
  private void _init0() {
    initWindowCloseHandler = new com.google.gwt.resources.client.TextResource() {
    // jar:file:/C:/Users/ohashi%20keisuke/.m2/repository/com/google/gwt/gwt-user/2.2.0/gwt-user-2.2.0.jar!/com/google/gwt/user/client/impl/initWindowCloseHandler.js
    public String getText() {
      return "function __gwt_initWindowCloseHandler(beforeunload, unload) {\n  var wnd = window\n  , oldOnBeforeUnload = wnd.onbeforeunload\n  , oldOnUnload = wnd.onunload;\n  \n  wnd.onbeforeunload = function(evt) {\n    var ret, oldRet;\n    try {\n      ret = beforeunload();\n    } finally {\n      oldRet = oldOnBeforeUnload && oldOnBeforeUnload(evt);\n    }\n    // Avoid returning null as IE6 will coerce it into a string.\n    // Ensure that \"\" gets returned properly.\n    if (ret != null) {\n      return ret;\n    }\n    if (oldRet != null) {\n      return oldRet;\n    }\n    // returns undefined.\n  };\n  \n  wnd.onunload = function(evt) {\n    try {\n      unload();\n    } finally {\n      oldOnUnload && oldOnUnload(evt);\n      wnd.onresize = null;\n      wnd.onscroll = null;\n      wnd.onbeforeunload = null;\n      wnd.onunload = null;\n    }\n  };\n  \n  // Remove the reference once we've initialize the handler\n  wnd.__gwt_initWindowCloseHandler = undefined;\n}\n";
    }
    public String getName() {
      return "initWindowCloseHandler";
    }
  }
  ;
    initWindowResizeHandler = new com.google.gwt.resources.client.TextResource() {
    // jar:file:/C:/Users/ohashi%20keisuke/.m2/repository/com/google/gwt/gwt-user/2.2.0/gwt-user-2.2.0.jar!/com/google/gwt/user/client/impl/initWindowResizeHandler.js
    public String getText() {
      return "function __gwt_initWindowResizeHandler(resize) {\n  var wnd = window, oldOnResize = wnd.onresize;\n  \n  wnd.onresize = function(evt) {\n    try {\n      resize();\n    } finally {\n      oldOnResize && oldOnResize(evt);\n    }\n  };\n  \n  // Remove the reference once we've initialize the handler\n  wnd.__gwt_initWindowResizeHandler = undefined;\n}\n";
    }
    public String getName() {
      return "initWindowResizeHandler";
    }
  }
  ;
    initWindowScrollHandler = new com.google.gwt.resources.client.TextResource() {
    // jar:file:/C:/Users/ohashi%20keisuke/.m2/repository/com/google/gwt/gwt-user/2.2.0/gwt-user-2.2.0.jar!/com/google/gwt/user/client/impl/initWindowScrollHandler.js
    public String getText() {
      return "function __gwt_initWindowScrollHandler(scroll) {\n  var wnd = window, oldOnScroll = wnd.onscroll;\n  \n  wnd.onscroll = function(evt) {\n    try {\n      scroll();\n    } finally {\n      oldOnScroll && oldOnScroll(evt);\n    }\n  };\n  \n  // Remove the reference once we've initialize the handler\n  wnd.__gwt_initWindowScrollHandler = undefined;\n}\n";
    }
    public String getName() {
      return "initWindowScrollHandler";
    }
  }
  ;
  }
  
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.google.gwt.resources.client.TextResource initWindowCloseHandler;
  private static com.google.gwt.resources.client.TextResource initWindowResizeHandler;
  private static com.google.gwt.resources.client.TextResource initWindowScrollHandler;
  
  static {
    new WindowImplIE_Resources_default_StaticClientBundleGenerator()._init0();
  }
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      initWindowCloseHandler(), 
      initWindowResizeHandler(), 
      initWindowScrollHandler(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("initWindowCloseHandler", initWindowCloseHandler());
        resourceMap.put("initWindowResizeHandler", initWindowResizeHandler());
        resourceMap.put("initWindowScrollHandler", initWindowScrollHandler());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'initWindowCloseHandler': return this.@com.google.gwt.user.client.impl.WindowImplIE.Resources::initWindowCloseHandler()();
      case 'initWindowResizeHandler': return this.@com.google.gwt.user.client.impl.WindowImplIE.Resources::initWindowResizeHandler()();
      case 'initWindowScrollHandler': return this.@com.google.gwt.user.client.impl.WindowImplIE.Resources::initWindowScrollHandler()();
    }
    return null;
  }-*/;
}
