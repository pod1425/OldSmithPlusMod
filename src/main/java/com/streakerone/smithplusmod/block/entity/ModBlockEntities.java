package com.streakerone.smithplusmod.block.entity;

import com.streakerone.smithplusmod.SmithPlusMod;
import com.streakerone.smithplusmod.block.ModBlocks;
import com.streakerone.smithplusmod.block.entity.custom.CrucibleWithMetalBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, SmithPlusMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<CrucibleWithMetalBlockEntity>> CRUCIBLE_WITH_METAL_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("crucible_with_metal_block_entity", () ->
                    BlockEntityType.Builder.of(CrucibleWithMetalBlockEntity::new,
                            ModBlocks.CERAMIC_CRUCIBLE_WITH_METAL.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
