package com.feed_the_beast.ftbu.gui;

import com.feed_the_beast.ftbl.lib.client.ClientUtils;
import com.feed_the_beast.ftbl.lib.gui.GuiHelper;
import com.feed_the_beast.ftbl.lib.gui.Panel;
import com.feed_the_beast.ftbl.lib.gui.SimpleTextButton;
import com.feed_the_beast.ftbl.lib.gui.misc.GuiButtonListBase;
import com.feed_the_beast.ftbl.lib.icon.Icon;
import com.feed_the_beast.ftbl.lib.util.misc.MouseButton;
import com.feed_the_beast.ftbu.api.FTBULang;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

import java.util.Map;

/**
 * @author LatvianModder
 */
public class GuiLeaderboardList extends GuiButtonListBase
{
	private final Map<ResourceLocation, ITextComponent> leaderboards;

	public GuiLeaderboardList(Map<ResourceLocation, ITextComponent> l)
	{
		leaderboards = l;
		setTitle(FTBULang.LEADERBOARDS.translate());
	}

	@Override
	public void addButtons(Panel panel)
	{
		for (Map.Entry<ResourceLocation, ITextComponent> entry : leaderboards.entrySet())
		{
			panel.add(new SimpleTextButton(this, 0, 0, entry.getValue().getFormattedText(), Icon.EMPTY)
			{
				@Override
				public void onClicked(MouseButton button)
				{
					GuiHelper.playClickSound();
					ClientUtils.execClientCommand("/ftb leaderboards gui " + entry.getKey());
				}
			});
		}
	}
}