package foo.bar.shared.model;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class Slim3Model_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native com.google.appengine.api.datastore.Key getKey(foo.bar.shared.model.Slim3Model instance) /*-{
    return instance.@foo.bar.shared.model.Slim3Model::key;
  }-*/;
  
  private static native void  setKey(foo.bar.shared.model.Slim3Model instance, com.google.appengine.api.datastore.Key value) /*-{
    instance.@foo.bar.shared.model.Slim3Model::key = value;
  }-*/;
  
  private static native java.lang.String getProp1(foo.bar.shared.model.Slim3Model instance) /*-{
    return instance.@foo.bar.shared.model.Slim3Model::prop1;
  }-*/;
  
  private static native void  setProp1(foo.bar.shared.model.Slim3Model instance, java.lang.String value) /*-{
    instance.@foo.bar.shared.model.Slim3Model::prop1 = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, foo.bar.shared.model.Slim3Model instance) throws SerializationException {
    setKey(instance, (com.google.appengine.api.datastore.Key) streamReader.readObject());
    setProp1(instance, streamReader.readString());
    
  }
  
  public static foo.bar.shared.model.Slim3Model instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new foo.bar.shared.model.Slim3Model();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, foo.bar.shared.model.Slim3Model instance) throws SerializationException {
    streamWriter.writeObject(getKey(instance));
    streamWriter.writeString(getProp1(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return foo.bar.shared.model.Slim3Model_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    foo.bar.shared.model.Slim3Model_FieldSerializer.deserialize(reader, (foo.bar.shared.model.Slim3Model)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    foo.bar.shared.model.Slim3Model_FieldSerializer.serialize(writer, (foo.bar.shared.model.Slim3Model)object);
  }
  
}
