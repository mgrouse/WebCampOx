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
	@UiTemplate(value = "MessagesWidget.ui.xml")
	static interface MessagesWidgetBinder extends UiBinder<Widget, MessagesWidget>
	{}

	private static UiBinder<Widget, MessagesWidget> binder = GWT.create(MessagesWidgetBinder.class);

	@UiField
	HTML msgSpace;

	ArrayList<String> messages = new ArrayList<>();

	public MessagesWidget()
	{
		initWidget(binder.createAndBindUi(this));
	}

	@Override
	public void setText(String text)
	{
		msgSpace.setText(text);
	}

	@Override
	public String getText()
	{
		return msgSpace.getText();
	}

	@Override
	public void addMessage(String text)
	{
		messages.add(text);
	}

	@Override
	public void addMessageAndFlush(String text)
	{
		messages.add(text);
		flush();
	}

	@Override
	public void removeMessage(String text)
	{
		for (String msg : messages)
		{
			if (msg.contentEquals(text))
			{
				messages.remove(msg);
				break;
			}
		}
		clear();
		flush();
	}

	@Override
	public void clear()
	{
		messages.clear();
		msgSpace.setText("");
	}

	private void flush()
	{
		msgSpace.setText("");
		StringBuilder sb = new StringBuilder();
		for (String message : messages)
		{
			sb.append("<p>");
			sb.append(message);
			sb.append("</p>");
		}
		msgSpace.setText(sb.toString());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.hbgb.webcamp.client.widget.IMessages#addMessageIfUnique(java.lang.
	 * String)
	 */
	@Override
	public void addMessageIfUnique(String var1)
	{
		if (!messageExists(var1))
		{
			addMessageAndFlush(var1);
		}
	}

	/**
	 * @param var1
	 * @return
	 */
	private Boolean messageExists(String text)
	{
		Boolean retVal = false;

		for (String msg : messages)
		{
			if (msg.contentEquals(text))
			{
				retVal = true;
				break;
			}
		}

		return retVal;
	}

}
