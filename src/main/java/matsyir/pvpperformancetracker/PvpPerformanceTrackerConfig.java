/*
 * Copyright (c) 2021, Matsyir <https://github.com/Matsyir>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package matsyir.pvpperformancetracker;

import matsyir.pvpperformancetracker.models.RangeAmmoData;
import matsyir.pvpperformancetracker.models.RingData;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Range;

@ConfigGroup("pvpperformancetracker")
public interface PvpPerformanceTrackerConfig extends Config
{
	int LEVEL_MIN = 1;
	int LEVEL_MAX = 120;

	// ================================= Sections =================================

	@ConfigSection(name = "Overlay (5 lines max)",
		description = "Contains overlay settings (MAX of 5 lines allowed)",
		position = 20,
		closedByDefault = true
	)
	String overlay = "overlay";

	@ConfigSection(name = "Gear/Ammo",
		description = "Contains gear/ammo settings for fights outside LMS",
		position = 110,
		closedByDefault = false
	)
	String gearAmmo = "gearAmmo";

	@ConfigSection(name = "Levels",
		description = "Contains level settings for fights outside of LMS (including boosts)",
		position = 150,
		closedByDefault = false
	)
	String levels = "levels";

	// ================================= General =================================

	@ConfigItem(
		keyName = "pluginVersion",
		name = "Plugin Version",
		description = "Hidden plugin version in order to potentially 'gracefully migrate' data in the future.",
		hidden = true
	)
	default String pluginVersion()
	{
		return PvpPerformanceTrackerPlugin.PLUGIN_VERSION;
	}

	@ConfigItem(
		keyName = "settingsConfigured",
		name = "I have verified my settings",
		description = "Some settings affect damage calculations, and every player should set them based on how they're pking." +
			"<br>Please confirm them and tick this box in order to hide the config warning.",
		position = -1
	)
	default boolean settingsConfigured()
	{
		return false;
	}

	@ConfigItem(
		keyName = "restrictToLms",
		name = "Restrict to LMS",
		description = "Restricts functionality and visibility to the LMS areas & its lobby (Ferox Enclave)." +
			"<br>WARNING: can be inaccurate outside LMS, as every attack animation's combat style must be manually mapped.",
		position = 0
	)
	default boolean restrictToLms()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showFightHistoryPanel",
		name = "Show Fight History Panel",
		description = "Enables the side-panel which displays previous fight's statistics.",
		position = 10
	)
	default boolean showFightHistoryPanel()
	{
		return true;
	}

	// ================================= Overlay =================================

	@ConfigItem(
		keyName = "showFightOverlay",
		name = "Show Fight Overlay",
		description = "Display an overlay of statistics while fighting.",
		position = 20,
		section = overlay
	)
	default boolean showFightOverlay()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showOverlayTitle",
		name = "Overlay: Show Title",
		description = "The overlay will have a title to display that it is PvP Performance.",
		position = 40,
		section = overlay
	)
	default boolean showOverlayTitle()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showOverlayNames",
		name = "Overlay: Show Names",
		description = "The overlay will display names.<br>Max. of 5 lines on the overlay",
		position = 50,
		section = overlay
	)
	default boolean showOverlayNames()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showOverlayOffPray",
		name = "Overlay: Show Off-Pray",
		description = "The overlay will display off-pray stats as a fraction & percentage.<br>Max. of 5 lines on the overlay",
		position = 60,
		section = overlay
	)
	default boolean showOverlayOffPray()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showOverlayDeservedDmg",
		name = "Overlay: Show Deserved Dmg",
		description = "The overlay will display deserved damage & difference.<br>Max. of 5 lines on the overlay",
		position = 70,
		section = overlay
	)
	default boolean showOverlayDeservedDmg()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showOverlayDmgDealt",
		name = "Overlay: Show Dmg Dealt",
		description = "The overlay will display damage dealt.<br>Max. of 5 lines on the overlay",
		position = 80,
		section = overlay
	)
	default boolean showOverlayDmgDealt()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showOverlayMagicHits",
		name = "Overlay: Show Magic Hits",
		description = "The overlay will display successful magic hits & deserved magic hits.<br>Max. of 5 lines on the overlay",
		position = 90,
		section = overlay
	)
	default boolean showOverlayMagicHits()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showOverlayOffensivePray",
		name = "Overlay: Show Offensive Pray",
		description = "The overlay will display offensive pray stats.<br>Max. of 5 lines on the overlay",
		position = 100,
		section = overlay
	)
	default boolean showOverlayOffensivePray()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showOverlayHpHealed",
		name = "Overlay: Show HP Healed",
		description = "The overlay will display hitpoints healed.<br>Max. of 5 lines on the overlay",
		position = 105,
		section = overlay
	)
	default boolean showOverlayHpHealed()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showOverlayGhostBarrage",
		name = "Overlay: Show Ghost Barrage",
		description = "(Advanced): The overlay will display ghost barrage stats.<br>Max. of 5 lines on the overlay",
		position = 106,
		section = overlay
	)
	default boolean showOverlayGhostBarrage()
	{
		return false;
	}

	// ================================= Gear/Ammo =================================

	@ConfigItem(
		keyName = "ringChoice",
		name = "Ring Used",
		description = "Rings used for the deserved damage calculations outside of LMS.",
		position = 110,
		section = gearAmmo
	)
	default RingData ringChoice()
	{
		return RingData.BERSERKER_RING;
	}

	@ConfigItem(
		keyName = "boltChoice",
		name = "RCB Ammo",
		description = "Bolts used for rune crossbow's deserved damage calculation." +
			"<br>LMS fights always use diamond (e). Dragonfire protection not accounted for.",
		position = 120,
		section = gearAmmo
	)
	default RangeAmmoData.BoltAmmo boltChoice()
	{
		return RangeAmmoData.BoltAmmo.DIAMOND_BOLTS_E;
	}

	@ConfigItem(
		keyName = "strongBoltChoice",
		name = "ACB/DCB/DHCB Ammo",
		description = "Bolts used for ACB/DCB/DHCB's deserved damage calculation." +
			"<br>LMS fights always use regular diamond (e). Dragonfire protection not accounted for.",
		position = 130,
		section = gearAmmo
	)
	default RangeAmmoData.StrongBoltAmmo strongBoltChoice()
	{
		return RangeAmmoData.StrongBoltAmmo.DIAMOND_BOLTS_E;
	}

	@ConfigItem(
		keyName = "bpDartChoice",
		name = "Blowpipe Ammo",
		description = "Darts used for blowpipe deserved damage calculation.",
		position = 140,
		section = gearAmmo
	)
	default RangeAmmoData.DartAmmo bpDartChoice()
	{
		return RangeAmmoData.DartAmmo.DRAGON_DARTS;
	}

	// ================================= Levels =================================

	@Range(
		min = LEVEL_MIN,
		max = LEVEL_MAX
	)
	@ConfigItem(
		keyName = "attackLevel",
		name = "Attack Level",
		description = "Attack level used for the deserved damage calculations outside of LMS (includes potion boost).",
		position = 160,
		section = levels
	)
	default int attackLevel()
	{
		return 118;
	}

	@Range(
		min = LEVEL_MIN,
		max = LEVEL_MAX
	)
	@ConfigItem(
		keyName = "strengthLevel",
		name = "Strength Level",
		description = "Strength level used for the deserved damage calculations outside of LMS (includes potion boost).",
		position = 170,
		section = levels
	)
	default int strengthLevel()
	{
		return 118;
	}

	@Range(
		min = LEVEL_MIN,
		max = LEVEL_MAX
	)
	@ConfigItem(
		keyName = "defenceLevel",
		name = "Defence Level",
		description = "Defence level used for the deserved damage calculations outside of LMS (includes potion boost).",
		position = 180,
		section = levels
	)
	default int defenceLevel()
	{
		return 120;
	}

	@Range(
		min = LEVEL_MIN,
		max = LEVEL_MAX
	)
	@ConfigItem(
		keyName = "rangedLevel",
		name = "Ranged Level",
		description = "Ranged level used for the deserved damage calculations outside of LMS (includes potion boost).",
		position = 190,
		section = levels
	)
	default int rangedLevel()
	{
		return 112;
	}

	@Range(
		min = LEVEL_MIN,
		max = LEVEL_MAX
	)
	@ConfigItem(
		keyName = "magicLevel",
		name = "Magic Level",
		description = "Magic level used for the deserved damage calculations outside of LMS (includes potion boost).",
		position = 200,
		section = levels
	)
	default int magicLevel()
	{
		return 99;
	}

	// ================================= Misc/Less-Used-General =================================

	@Range(
		min = 1,
		max = 1000
	)
	@ConfigItem(
		keyName = "fightHistoryRenderLimit",
		name = "Max Rendered Fights",
		description = "Maximum number of previous fights to be displayed in the fight history side-panel." +
			"<br>WILL cause lag spikes at very high numbers. This should be small if you have low RAM",
		position = 205
	)
	default int fightHistoryRenderLimit()
	{
		return 200;
	}

	@Range(
		max = 1000000
	)
	@ConfigItem(
		keyName = "fightHistoryLimit",
		name = "Max Saved Fights",
		description = "Maximum number of previous fights to be saved to a local file and used for total/avg stats." +
			"<br>0 means unlimited. May cause lag spikes at extreme numbers on low-end PCs",
		position = 210
	)
	default int fightHistoryLimit()
	{
		return 10000;
	}

	@ConfigItem(
		keyName = "exactNameFilter",
		name = "Exact Name Filter",
		description = "Makes the username filter look for an exact match (case-insensitive), rather than any name starting with the filter.",
		position = 220
	)
	default boolean exactNameFilter()
	{
		return false;
	}

	@ConfigItem(
		keyName = "dlongIsVls",
		name = "Dlong = VLS",
		description = "Track Dragon Longsword & its spec as a Vesta's Longsword for deserved damage." +
			"<br>Requested/used for for DMM practice purposes.",
		position = 230
	)
	default boolean dlongIsVls()
	{
		return true;
	}

	@ConfigItem(
		keyName = "fightLogInChat",
		name = "Fight Log In Chat",
		description = "Display basic fight logs in trade chat during a fight." +
			"<br><strong>This is very excessive, mostly for testing/verification.<strong>",
		position = 500
	)
	default boolean fightLogInChat()
	{
		return false;
	}

	@ConfigItem(
		keyName = "nameFilter",
		name = "Name Filter",
		description = "Hidden config used to save user's selected name/RSN filter for the panel views.",
		position = 1000,
		hidden = true
	)
	default String nameFilter()
	{
		return "";
	}
}
