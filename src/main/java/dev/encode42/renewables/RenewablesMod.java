package dev.encode42.renewables;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class RenewablesMod implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Renewables");
	public static final Item DIAMOND_SHARD = new Item(new QuiltItemSettings());

	@Override
	public void onInitialize(ModContainer mod) {
		Registry.register(Registries.ITEM, new Identifier(mod.metadata().id(), "diamond_shard"), DIAMOND_SHARD);

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
			entries.addItem(DIAMOND_SHARD);
		});
	}
}
