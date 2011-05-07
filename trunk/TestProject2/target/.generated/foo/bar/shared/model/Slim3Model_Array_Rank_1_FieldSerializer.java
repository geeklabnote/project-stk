package foo.bar.shared.model;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class Slim3Model_Array_Rank_1_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, foo.bar.shared.model.Slim3Model[] instance) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.deserialize(streamReader, instance);
  }
  
  public static foo.bar.shared.model.Slim3Model[] instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int size = streamReader.readInt();
    return new foo.bar.shared.model.Slim3Model[size];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, foo.bar.shared.model.Slim3Model[] instance) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return foo.bar.shared.model.Slim3Model_Array_Rank_1_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    foo.bar.shared.model.Slim3Model_Array_Rank_1_FieldSerializer.deserialize(reader, (foo.bar.shared.model.Slim3Model[])object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    foo.bar.shared.model.Slim3Model_Array_Rank_1_FieldSerializer.serialize(writer, (foo.bar.shared.model.Slim3Model[])object);
  }
  
}
