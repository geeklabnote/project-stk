package com.google.appengine.api.datastore;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings("deprecation")
public class Key_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.google.appengine.api.datastore.Key_CustomFieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.google.appengine.api.datastore.Key_CustomFieldSerializer.deserialize(reader, (com.google.appengine.api.datastore.Key)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.google.appengine.api.datastore.Key_CustomFieldSerializer.serialize(writer, (com.google.appengine.api.datastore.Key)object);
  }
  
}
