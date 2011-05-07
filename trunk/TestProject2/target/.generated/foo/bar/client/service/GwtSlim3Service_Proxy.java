package foo.bar.client.service;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.RpcToken;
import com.google.gwt.user.client.rpc.RpcTokenException;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.impl.RpcStatsContext;

public class GwtSlim3Service_Proxy extends RemoteServiceProxy implements foo.bar.client.service.GwtSlim3ServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "foo.bar.client.service.GwtSlim3Service";
  private static final String SERIALIZATION_POLICY ="2FBCDD4E55D6E3EDC79753CBCECFF2F4";
  private static final foo.bar.client.service.GwtSlim3Service_TypeSerializer SERIALIZER = new foo.bar.client.service.GwtSlim3Service_TypeSerializer();
  
  public GwtSlim3Service_Proxy() {
    super(GWT.getModuleBaseURL(),
      "service.s3gwt", 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void newAndPut(java.lang.String prop1, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("GwtSlim3Service_Proxy.newAndPut", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      if (getRpcToken() != null) {
        streamWriter.writeObject(getRpcToken());
      }
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("newAndPut");
      streamWriter.writeInt(1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(prop1);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("GwtSlim3Service_Proxy.newAndPut",  "requestSerialized"));
      doInvoke(ResponseReader.VOID, "GwtSlim3Service_Proxy.newAndPut", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void queryAll(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("GwtSlim3Service_Proxy.queryAll", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      if (getRpcToken() != null) {
        streamWriter.writeObject(getRpcToken());
      }
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("queryAll");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("GwtSlim3Service_Proxy.queryAll",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "GwtSlim3Service_Proxy.queryAll", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  @Override
  public SerializationStreamWriter createStreamWriter() {
    ClientSerializationStreamWriter toReturn =
      (ClientSerializationStreamWriter) super.createStreamWriter();
    if (getRpcToken() != null) {
      toReturn.addFlags(ClientSerializationStreamWriter.FLAG_RPC_TOKEN_INCLUDED);
    }
    return toReturn;
  }
}
