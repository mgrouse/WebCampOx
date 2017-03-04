/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: javax.jdo.JDOHelper
 * javax.jdo.PersistenceManagerFactory
 */
package org.hbgb.webcamp.server;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

public final class PMF
{
	private static final PersistenceManagerFactory pmfInstance = JDOHelper.getPersistenceManagerFactory((String) "transactions-optional");

	private PMF()
	{}

	public static PersistenceManagerFactory get()
	{
		return pmfInstance;
	}
}
