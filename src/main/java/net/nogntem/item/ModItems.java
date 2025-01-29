package net.nogntem.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.nogntem.Planta;

public class ModItems {

    public static Item register(Item item, RegistryKey<Item> registryKey) {
        // Register the item.
        Item registeredItem = Registry.register(Registries.ITEM, registryKey.getValue(), item);

        // Return the registered item!
        return registeredItem;
    }
    public static final RegistryKey<Item> PLASTIC_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Planta.MOD_ID, "plastic"));




    public static final Item PLASTIC = register(
            new Item(new Item.Settings().registryKey(PLASTIC_KEY)),
            PLASTIC_KEY
    );

    public static void initialize() {

    }



}
