/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.gwt.user.client.rpc.RemoteService
 * com.google.gwt.user.client.rpc.RemoteServiceRelativePath
 */
package org.hbgb.webcamp.client.async;

import java.util.List;

import org.hbgb.webcamp.shared.HealerSheetDetails;
import org.hbgb.webcamp.shared.HealerSheetInfoBlock;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath(value = "healerSheetService")
public interface HealerSheetService extends RemoteService
{
	public HealerSheetInfoBlock getHealerSheetInfoBlock(String var1);

	public HealerSheetInfoBlock getHealerSheetInfoBlockByEmail(String var1, Boolean var2);

	public HealerSheetInfoBlock addHealerSheetInfoBlock(HealerSheetInfoBlock var1);

	public Boolean updateHealerSheetInfoBlock(HealerSheetInfoBlock var1);

	public Boolean deleteHealerSheetInfoBlock(String var1);

	public List<HealerSheetInfoBlock> getAllHealerSheetInfoBlocks();

	public List<HealerSheetDetails> getAllHealerSheetDetails();
}
