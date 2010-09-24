package com.google.code.stk.client;

import com.google.code.stk.client.event.DeleteTweetClickEvent;
import com.google.code.stk.client.event.DeleteTweetClickHandler;
import com.google.code.stk.client.event.EditTweetClickEvent;
import com.google.code.stk.client.event.EditTweetClickHandler;
import com.google.code.stk.client.event.NewTweetClickEvent;
import com.google.code.stk.client.event.NewTweetClickHandler;
import com.google.code.stk.client.ui.display.ListDisplay;
import com.google.code.stk.client.ui.display.ListView;
import com.google.code.stk.client.ui.presenter.AbstractPresenter;
import com.google.code.stk.client.ui.presenter.ListPresenter;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

public class AppController implements ValueChangeHandler<String> {

	private final HandlerManager eventBus;

	private HasWidgets container;

	public AppController(HandlerManager eventBus) {
		super();
		this.eventBus = eventBus;
		bind();
	}

	public void go(HasWidgets container){
		this.container = container;

		History.newItem("list");
	}

	private void bind() {
		History.addValueChangeHandler(this);

		eventBus.addHandler(NewTweetClickEvent.TYPE, new NewTweetClickHandler() {
			@Override
			public void onClick(NewTweetClickEvent e) {
				History.newItem("new");
			}
		});

		eventBus.addHandler(EditTweetClickEvent.TYPE, new EditTweetClickHandler() {

			@Override
			public void onClick(EditTweetClickEvent e) {
				History.newItem("edit/" + String.valueOf(e.getKey()));
			}
		});

		eventBus.addHandler(DeleteTweetClickEvent.TYPE, new DeleteTweetClickHandler() {

			@Override
			public void onClick(DeleteTweetClickEvent e) {
				History.newItem("delete/" + String.valueOf(e.getKey()));
			}
		});

	}

	@Override
	public void onValueChange(ValueChangeEvent<String> arg0) {
		String token = History.getToken();

		if(token == null || token.equals("list") || token.equals("")){
			ListDisplay display = new ListView();

			AbstractPresenter<ListDisplay> presenter = new ListPresenter(display , eventBus);

			presenter.go(container);
			return;
		}

	}

}
