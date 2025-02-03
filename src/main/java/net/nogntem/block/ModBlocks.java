package net.nogntem.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.nogntem.Planta;
import net.nogntem.block.custom.BigPotPlastic;
import net.nogntem.block.custom.PotPlastic;


public class ModBlocks {
    public static Block register(Block block, RegistryKey<Block> blockKey, boolean shouldRegisterItem) {
        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:air` or `minecraft:end_gateway`
        if (shouldRegisterItem) {
            // Items need to be registered with a different type of registry key, but the ID
            // can be the same.
            RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, blockKey.getValue());

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    public static final RegistryKey<Block> BIG_PLASTIC_POT_KEY = RegistryKey.of(
            RegistryKeys.BLOCK,
            Identifier.of(Planta.MOD_ID, "big_plastic_pot")
    );
    public static final RegistryKey<Block> PLASTIC_POT_KEY = RegistryKey.of(
            RegistryKeys.BLOCK,
            Identifier.of(Planta.MOD_ID, "plastic_pot")
    );

    public static final Block BIG_PLASTIC_POT = register(
            new BigPotPlastic(AbstractBlock.Settings.create().registryKey(BIG_PLASTIC_POT_KEY).sounds(BlockSoundGroup.DECORATED_POT)),
            BIG_PLASTIC_POT_KEY,
            true
    );
    public static final Block PLASTIC_POT = register(
            new PotPlastic(AbstractBlock.Settings.create().registryKey(PLASTIC_POT_KEY).sounds(BlockSoundGroup.DECORATED_POT)),
            PLASTIC_POT_KEY,
            true
    );

    public static void initialize() {
    }
}

