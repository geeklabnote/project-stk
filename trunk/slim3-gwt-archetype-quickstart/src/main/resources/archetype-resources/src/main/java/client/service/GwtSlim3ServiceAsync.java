package ${package}.client.service;

import ${package}.shared.model.Slim3Model;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GwtSlim3ServiceAsync {

	void newAndPut(String prop1, AsyncCallback<Void> callback);

	void queryAll(AsyncCallback<Slim3Model[]> callback);

}
