package net.nogntem.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.nogntem.Planta;
import net.nogntem.block.ModBlocks;

public class ModItemGroup {


    public static final RegistryKey<ItemGroup> POT_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Planta.MOD_ID, "item_group"));

    public static final ItemGroup POT_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModBlocks.PLASTIC_POT))
            .displayName(Text.translatable("Planta"))
            .build();

    // Register the group.

    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, POT_GROUP_KEY, POT_GROUP);

// Register items to the custom item group.
        ItemGroupEvents.modifyEntriesEvent(POT_GROUP_KEY).register(itemGroup -> {
                    itemGroup.add(ModBlocks.PLASTIC_POT.asItem());
                    itemGroup.add(ModBlocks.BIG_PLASTIC_POT.asItem());
                    itemGroup.add(ModItems.PLASTIC.asItem());
                }

        );

    }
}
