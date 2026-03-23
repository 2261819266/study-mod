package com.vas.study.item;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import static com.vas.study.Study.LOGGER;
import static com.vas.study.Study.MOD_ID;
import static com.vas.study.item.ModItems.STUDY_ITEM;

public class ModCreativeModeTabs {
    public static final ResourceKey<CreativeModeTab> STUDY_TAB =
            ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(),
                    Identifier.fromNamespaceAndPath(MOD_ID, "study_tab"));

    public static final CreativeModeTab STUDY = FabricCreativeModeTab.builder()
            .title(Component.translatable("itemGroup.study"))
            .icon(() -> new ItemStack(ModItems.STUDY_ITEM))
            .displayItems((parameters, output) -> {
                output.accept(STUDY_ITEM);
            }).build();

    public static void initialize() {
        LOGGER.info("Resister Creative Mode Tabs for " + MOD_ID);
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, STUDY_TAB, STUDY);
    }
}
