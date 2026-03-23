package com.vas.study.block;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

import static com.vas.study.Study.LOGGER;
import static com.vas.study.Study.MOD_ID;

public class ModBlocks {

    public static final Block STUDY_BLOCK = registerModBlock(
            "study_block",
            BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
    );

    private static Block registerModBlock(final String name, final BlockBehaviour.Properties properties, boolean needRegisterItem) {
        final ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MOD_ID, name));
        Block block = (Block) ((Function<Block.Properties, Block>) (Block::new)).
                apply(properties.setId((key)));
        if (needRegisterItem) {
            registerBlockItem(name, block);
        }
        return Registry.register(BuiltInRegistries.BLOCK, key, block);
    }

    private static Block registerModBlock(final String name, final BlockBehaviour.Properties properties) {
        return registerModBlock(name, properties, true);
    }

    private static void registerBlockItem(String name, Block block) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID, name));
        BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(key).useBlockDescriptionPrefix());
        Registry.register(BuiltInRegistries.ITEM, key, blockItem);
    }

    public static void initialize() {
        LOGGER.info("Resister Mod Blocks for " + MOD_ID);
    }
}
