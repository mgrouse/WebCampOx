/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.uibinder.client.UiBinder
 * com.google.gwt.uibinder.client.UiField
 * com.google.gwt.uibinder.client.UiTemplate
 * com.google.gwt.user.client.ui.Composite com.google.gwt.user.client.ui.HTML
 * com.google.gwt.user.client.ui.HasText com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.widget;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class MessagesWidget extends Composite implements HasText, IMessages
{
	private static UiBinder<Widget, MessagesWidget> binder =  GWT
			.create( MessagesWidgetBinder.class);
	@UiField
	HTML msgSpace;
	ArrayList<String> messages;

	public MessagesWidget()
	{
		this.initWidget(binder.createAndBindUi(this));
	}

	@Override
	public void setText(String text)
	{
		this.msgSpace.setText(text);
	}

	@Override
	public String getText()
	{
		return this.msgSpace.getText();
	}

	@Override
	public void addMessage(String text)
	{
		this.messages.add(text);
	}

	@Override
	public void addMessageAndFlush(String text)
	{
		this.messages.add(text);
		this.flush();
	}

	@Override
	public void removeMessage(String text)
	{
		for (String msg : this.messages)
		{
			if (!msg.contentEquals(text))
				continue;
			this.messages.remove(msg);
			break;
		}
		this.clear();
		this.flush();
	}

	@Override
	public void clear()
	{
		this.messages.clear();
		this.msgSpace.setText("");
	}

	private void flush()
	{
		this.msgSpace.setText("");
		StringBuilder sb = new StringBuilder();
		for (String message : this.messages)
		{
			sb.append(message);
		}
		this.msgSpace.setText(sb.toString());
	}

	@UiTemplate(value = "MessagesWidget.ui.xml")
	static interface MessagesWidgetBinder extends UiBinder<Widget, MessagesWidget>
	{
	}

}
