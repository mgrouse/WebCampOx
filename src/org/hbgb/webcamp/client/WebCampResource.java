/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.resources.client.ClientBundle
 * com.google.gwt.resources.client.ClientBundle$Source
 * com.google.gwt.resources.client.DataResource
 * com.google.gwt.resources.client.ImageResource
 */
package org.hbgb.webcamp.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.ImageResource;

public interface WebCampResource extends ClientBundle
{
	public static final WebCampResource INSTANCE = (WebCampResource) GWT.create(WebCampResource.class);

	@Source(value = { "org/hbgb/webcamp/client/images/bean.png" })
	public ImageResource bean();

	@Source(value = { "org/hbgb/webcamp/client/images/blank.png" })
	public ImageResource blank();

	@Source(value = { "org/hbgb/webcamp/client/images/chart.png" })
	public ImageResource chart();

	@Source(value = { "org/hbgb/webcamp/client/images/close.png" })
	public ImageResource close();

	@Source(value = { "org/hbgb/webcamp/client/images/coffee.png" })
	public ImageResource coffee();

	@Source(value = { "org/hbgb/webcamp/client/images/delete.png" })
	public ImageResource delete();

	@Source(value = { "org/hbgb/webcamp/client/images/dollar.png" })
	public ImageResource dollar();

	@Source(value = { "org/hbgb/webcamp/client/images/folder-doc.png" })
	public ImageResource folderDoc();

	@Source(value = { "org/hbgb/webcamp/client/images/line.jpeg" })
	public DataResource line();

	@Source(value = { "org/hbgb/webcamp/client/images/loading.gif" })
	public ImageResource loading();

	@Source(value = { "org/hbgb/webcamp/client/images/next.png" })
	public ImageResource next();

	@Source(value = { "org/hbgb/webcamp/client/images/peers.png" })
	public ImageResource peers();

	@Source(value = { "org/hbgb/webcamp/client/images/pin.png" })
	public ImageResource pin();

	@Source(value = { "org/hbgb/webcamp/client/images/previous.png" })
	public ImageResource previous();

	@Source(value = { "org/hbgb/webcamp/client/images/puzzle.png" })
	public ImageResource puzzle();

	@Source(value = { "org/hbgb/webcamp/client/images/ratio.png" })
	public ImageResource ratio();

	@Source(value = { "org/hbgb/webcamp/client/images/shipping.png" })
	public ImageResource shipping();

	@Source(value = { "org/hbgb/webcamp/client/images/shopping-bag.png" })
	public ImageResource shoppingBag();

	@Source(value = { "org/hbgb/webcamp/client/images/shopping-cart.png" })
	public ImageResource shoppingCart();

	@Source(value = { "org/hbgb/webcamp/client/images/spanner.png" })
	public ImageResource spanner();

	@Source(value = { "org/hbgb/webcamp/client/images/table-sheet.png" })
	public ImageResource tableSheet();

	@Source(value = { "org/hbgb/webcamp/client/images/watch.png" })
	public ImageResource watch();
}
