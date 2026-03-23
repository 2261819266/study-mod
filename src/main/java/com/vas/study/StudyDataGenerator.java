package com.vas.study;

import com.vas.study.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class StudyDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(ModEnUsLangProvider::new);
        pack.addProvider(ModModelsProvider::new);
        pack.addProvider(ModBlocksLootProvider::new);
        pack.addProvider(ModItemTagsProvider::new);
        pack.addProvider(ModBlockTagsProvider::new);
        pack.addProvider(ModRecipesProvider::new);
    }
}
