package ${package}.client;

import ${package}.client.service.GwtSlim3Service;
import ${package}.client.service.GwtSlim3ServiceAsync;
import ${package}.shared.model.Slim3Model;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Index implements EntryPoint {
	GwtSlim3ServiceAsync slim3Service = GWT.create(GwtSlim3Service.class);

	TextBox textBox;
	Button addButton;
	VerticalPanel commentPanel;

	@Override
	public void onModuleLoad() {
		VerticalPanel contentPanel = new VerticalPanel();

		HorizontalPanel inputPanel = new HorizontalPanel();

		textBox = new TextBox();
		inputPanel.add(textBox);

		addButton = new Button("add", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				addComment(textBox.getValue());

				textBox.setValue("");
				addButton.setEnabled(false);
			}

		});
		inputPanel.add(addButton);

		contentPanel.add(inputPanel);

		commentPanel = new VerticalPanel();
		contentPanel.add(commentPanel);

		reloadComment();

		RootPanel.get("container").add(contentPanel);
	}

	private void reloadComment() {
		slim3Service.queryAll(new AsyncCallback<Slim3Model[]>() {

			@Override
			public void onSuccess(Slim3Model[] result) {

				for (Slim3Model model : result) {
					commentPanel.add(new Label(model.getProp1()));
				}
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("fail");
				GWT.log(caught.getMessage(), caught);
			}
		});
	}

	private void addComment(final String comment) {
		slim3Service.newAndPut(comment, new AsyncCallback<Void>() {

			@Override
			public void onSuccess(Void result) {
				addButton.setEnabled(true);
				commentPanel.add(new Label(comment));
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("fail");
				GWT.log(caught.getMessage(), caught);
				addButton.setEnabled(true);
			}
		});
	}

}
