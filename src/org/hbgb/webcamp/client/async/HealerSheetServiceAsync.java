/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.gwt.user.client.rpc.AsyncCallback
 */
package org.hbgb.webcamp.client.async;

import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.List;
import org.hbgb.webcamp.shared.HealerSheetDetails;
import org.hbgb.webcamp.shared.HealerSheetInfoBlock;

public interface HealerSheetServiceAsync
{
	public void getHealerSheetInfoBlock(String var1, AsyncCallback<HealerSheetInfoBlock> var2);

	public void getHealerSheetInfoBlockByEmail(String var1, Boolean var2, AsyncCallback<HealerSheetInfoBlock> var3);

	public void addHealerSheetInfoBlock(HealerSheetInfoBlock var1, AsyncCallback<HealerSheetInfoBlock> var2);

	public void updateHealerSheetInfoBlock(HealerSheetInfoBlock var1, AsyncCallback<Boolean> var2);

	public void deleteHealerSheetInfoBlock(String var1, AsyncCallback<Boolean> var2);

	public void getAllHealerSheetInfoBlocks(AsyncCallback<List<HealerSheetInfoBlock>> var1);

	public void getAllHealerSheetDetails(AsyncCallback<List<HealerSheetDetails>> var1);
}
