/*
 * This is an unpublished work protected by the United States copyright laws and
 * is proprietary to Michael A. Grouse. Disclosure, copying, reproduction,
 * merger translation, modification, enhancement or use by anyone other than
 * authorized employees or licensees of Michael A. Grouse without prior written
 * consent of Michael A. Grouse is prohibited.
 *
 * Copyright (C) 1992 - 2018 Michael A. Grouse, All Rights Reserved.
 *
 * This copyright notice should not be construed as evidence of publication.
 */
package org.hbgb.webcamp.shared;

import java.io.Serializable;

import org.hbgb.webcamp.shared.enums.FindApp;

/**
 * @author Michael
 *
 */
@SuppressWarnings("serial")

public class FindAppResult implements Serializable
{
	private String key;
	private FindApp find;

	public FindAppResult()
	{

	}

	public String getKey()
	{
		return key;
	}

	public void setKey(String key)
	{
		this.key = key;
	}

	public FindApp getFind()
	{
		return find;
	}

	public void setFind(FindApp find)
	{
		this.find = find;
	}

}
