package com.google.code.stk.client.ui.display;

public interface DataDisplay<T> extends Display {

	public T getData();

	public void setData(T data);
}
