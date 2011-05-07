package foo.bar.server.service;

import foo.bar.client.service.GwtSlim3Service;
import  foo.bar.shared.model.Slim3Model;

public class GwtSlim3ServiceImpl implements GwtSlim3Service {

	@Override
	public void newAndPut(String prop1) {
		Slim3Service.newAndPut(prop1);
	}

	@Override
	public Slim3Model[] queryAll() {
		return Slim3Service.queryAll().toArray(new Slim3Model[0]);
	}

}
