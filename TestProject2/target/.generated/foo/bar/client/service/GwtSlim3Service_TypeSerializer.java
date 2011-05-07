package foo.bar.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.user.client.rpc.impl.TypeHandler;
import java.util.HashMap;
import java.util.Map;
import com.google.gwt.core.client.GwtScriptOnly;

public class GwtSlim3Service_TypeSerializer extends com.google.gwt.user.client.rpc.impl.SerializerBase {
  private static final Map<String, String> methodMapJava;
  private static final MethodMap methodMapNative;
  private static final Map<String, String> signatureMapJava;
  private static final JsArrayString signatureMapNative;
  
  static {
    if (GWT.isScript()) {
      methodMapJava = null;
      methodMapNative = loadMethodsNative();
      signatureMapJava = null;
      signatureMapNative = loadSignaturesNative();
    } else {
      methodMapJava = loadMethodsJava();
      methodMapNative = null;
      signatureMapJava = loadSignaturesJava();
      signatureMapNative = null;
    }
  }
  
  @SuppressWarnings("deprecation")
  private static Map<String, String> loadMethodsJava() {
    Map<String, String> result = new HashMap<String, String>();
    result.put("com.google.appengine.api.datastore.AppIdNamespace/2812750239", "com.google.appengine.api.datastore.AppIdNamespace_FieldSerializer");
    result.put("com.google.appengine.api.datastore.Key/1349195865", "com.google.appengine.api.datastore.Key_FieldSerializer");
    result.put("com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533", "com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException_FieldSerializer");
    result.put("foo.bar.shared.model.Slim3Model/3432182267", "foo.bar.shared.model.Slim3Model_FieldSerializer");
    result.put("[Lfoo.bar.shared.model.Slim3Model;/31622792", "foo.bar.shared.model.Slim3Model_Array_Rank_1_FieldSerializer");
    result.put("java.lang.String/2004016611", "com.google.gwt.user.client.rpc.core.java.lang.String_FieldSerializer");
    return result;
  }
  
  @SuppressWarnings("deprecation")
  @GwtScriptOnly
  private static native MethodMap loadMethodsNative() /*-{
    var result = {};
    result["com.google.appengine.api.datastore.AppIdNamespace/2812750239"] = [
        @com.google.appengine.api.datastore.AppIdNamespace_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.appengine.api.datastore.AppIdNamespace_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/appengine/api/datastore/AppIdNamespace;),
      ];
    
    result["com.google.appengine.api.datastore.Key/1349195865"] = [
        @com.google.appengine.api.datastore.Key_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.appengine.api.datastore.Key_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/appengine/api/datastore/Key;),
      ];
    
    result["com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533"] = [
        @com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/rpc/IncompatibleRemoteServiceException;),
        @com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/user/client/rpc/IncompatibleRemoteServiceException;)
      ];
    
    result["foo.bar.shared.model.Slim3Model/3432182267"] = [
        @foo.bar.shared.model.Slim3Model_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @foo.bar.shared.model.Slim3Model_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lfoo/bar/shared/model/Slim3Model;),
      ];
    
    result["[Lfoo.bar.shared.model.Slim3Model;/31622792"] = [
        @foo.bar.shared.model.Slim3Model_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @foo.bar.shared.model.Slim3Model_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lfoo/bar/shared/model/Slim3Model;),
      ];
    
    result["java.lang.String/2004016611"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.String_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.String_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/String;),
        @com.google.gwt.user.client.rpc.core.java.lang.String_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/lang/String;)
      ];
    
    return result;
  }-*/;
  
  @SuppressWarnings("deprecation")
  private static Map<String, String> loadSignaturesJava() {
    Map<String, String> result = new HashMap<String, String>();
    result.put("com.google.appengine.api.datastore.AppIdNamespace", "com.google.appengine.api.datastore.AppIdNamespace/2812750239");
    result.put("com.google.appengine.api.datastore.Key", "com.google.appengine.api.datastore.Key/1349195865");
    result.put("com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException", "com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533");
    result.put("foo.bar.shared.model.Slim3Model", "foo.bar.shared.model.Slim3Model/3432182267");
    result.put("[Lfoo.bar.shared.model.Slim3Model;", "[Lfoo.bar.shared.model.Slim3Model;/31622792");
    result.put("java.lang.String", "java.lang.String/2004016611");
    return result;
  }
  
  @SuppressWarnings("deprecation")
  @GwtScriptOnly
  private static native JsArrayString loadSignaturesNative() /*-{
    var result = [];
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.appengine.api.datastore.AppIdNamespace::class)] = "com.google.appengine.api.datastore.AppIdNamespace/2812750239";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.appengine.api.datastore.Key::class)] = "com.google.appengine.api.datastore.Key/1349195865";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException::class)] = "com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@foo.bar.shared.model.Slim3Model::class)] = "foo.bar.shared.model.Slim3Model/3432182267";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@foo.bar.shared.model.Slim3Model[]::class)] = "[Lfoo.bar.shared.model.Slim3Model;/31622792";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.String::class)] = "java.lang.String/2004016611";
    return result;
  }-*/;
  
  public GwtSlim3Service_TypeSerializer() {
    super(methodMapJava, methodMapNative, signatureMapJava, signatureMapNative);
  }
  
}
