/*
 * This is an unpublished work protected by the United States copyright laws and
 * is proprietary to Michael A. Grouse. Disclosure, copying, reproduction,
 * merger translation, modification, enhancement or use by anyone other than
 * authorized employees or licensees of Michael A. Grouse without prior written
 * consent of Michael A. Grouse is prohibited.
 *
 * Copyright (C) 1992 - 2017 Michael A. Grouse, All Rights Reserved.
 *
 * This copyright notice should not be construed as evidence of publication.
 */
package org.hbgb.webcamp.client.model;

import org.hbgb.webcamp.client.presenter.IModelPresenter;

/**
 * @author Michael
 *
 */
public interface IModel<T>
{

	public void setPresenter(IModelPresenter mp);

	public void fetch();

	public void put();

	public T getData();

	public void setData(T data);

}
