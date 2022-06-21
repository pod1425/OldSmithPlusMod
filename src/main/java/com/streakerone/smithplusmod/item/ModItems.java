package com.streakerone.smithplusmod.item;

import com.streakerone.smithplusmod.SmithPlusMod;
import com.streakerone.smithplusmod.item.custom.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SmithPlusMod.MOD_ID);
    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }

    //item creations
    //TODO: add mangrove bark
    public static final RegistryObject<Item> OAK_BARK = ITEMS.register("oak_bark",
            () -> new BarkItem(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    public static final RegistryObject<Item> BIRCH_BARK = ITEMS.register("birch_bark",
            () -> new BarkItem(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    public static final RegistryObject<Item> SPRUCE_BARK = ITEMS.register("spruce_bark",
            () -> new BarkItem(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    public static final RegistryObject<Item> DARK_OAK_BARK = ITEMS.register("dark_oak_bark",
            () -> new BarkItem(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    public static final RegistryObject<Item> JUNGLE_BARK = ITEMS.register("jungle_bark",
            () -> new BarkItem(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    public static final RegistryObject<Item> ACACIA_BARK = ITEMS.register("acacia_bark",
            () -> new BarkItem(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    public static final RegistryObject<Item> WARPED_STEM_BARK = ITEMS.register("warped_stem_bark",
            () -> new NetherBarkItem(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    public static final RegistryObject<Item> CRIMSON_STEM_BARK = ITEMS.register("crimson_stem_bark",
            () -> new NetherBarkItem(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));

    public static final RegistryObject<Item> RAW_TIN = ITEMS.register("raw_tin",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    public static final RegistryObject<Item> TIN_NUGGET = ITEMS.register("tin_nugget",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));

    public static final RegistryObject<Item> RAW_LEAD = ITEMS.register("raw_lead",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    public static final RegistryObject<Item> LEAD_NUGGET = ITEMS.register("lead_nugget",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    //TODO: add silver nugget
    public static final RegistryObject<Item> RAW_SILVER = ITEMS.register("raw_silver",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));

    public static final RegistryObject<Item> ROPE = ITEMS.register("rope",
            () -> new FuelItem(200, new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    public static final RegistryObject<Item> FIBER = ITEMS.register("fiber",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS).food(ModFoods.FIBER)));

    public static final RegistryObject<Item> COKE_COAL = ITEMS.register("coke_coal",
            () -> new FuelItem(3200, new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));

    //TODO: make tags for different parts
    public static final RegistryObject<Item> WOODEN_AXE_HEAD = ITEMS.register("wooden_axe_head",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> WOODEN_HOE_HEAD = ITEMS.register("wooden_hoe_head",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> WOODEN_PICKAXE_HEAD = ITEMS.register("wooden_pickaxe_head",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> WOODEN_SHOVEL_HEAD = ITEMS.register("wooden_shovel_head",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> WOODEN_SWORD_PARTS = ITEMS.register("wooden_sword_parts",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));

    public static final RegistryObject<Item> LONG_BOULDER = ITEMS.register("long_boulder",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> MASSIVE_BOULDER = ITEMS.register("massive_boulder",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> FLAT_BOULDER = ITEMS.register("flat_boulder",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> SHARPEN_FLAT_BOULDER = ITEMS.register("sharpen_flat_boulder",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> SHARPEN_SMALL_BOULDER = ITEMS.register("sharpen_small_boulder",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> SMALL_BOULDER = ITEMS.register("small_boulder",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));


    public static final RegistryObject<Item> IRON_AXE_HEAD = ITEMS.register("iron_axe_head",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> IRON_BLADE = ITEMS.register("iron_blade",
            () -> new BladeItem(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> IRON_COUNTERWEIGHT = ITEMS.register("iron_counterweight",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> IRON_GUARD = ITEMS.register("iron_guard",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> IRON_HOE_HEAD = ITEMS.register("iron_hoe_head",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> IRON_PICKAXE_HEAD = ITEMS.register("iron_pickaxe_head",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> IRON_SHOVEL_HEAD = ITEMS.register("iron_shovel_head",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));

    public static final RegistryObject<Item> BRONZE_AXE_HEAD = ITEMS.register("bronze_axe_head",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> BRONZE_BLADE = ITEMS.register("bronze_blade",
            () -> new BladeItem(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> BRONZE_COUNTERWEIGHT = ITEMS.register("bronze_counterweight",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> BRONZE_GUARD = ITEMS.register("bronze_guard",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> BRONZE_HOE_HEAD = ITEMS.register("bronze_hoe_head",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> BRONZE_PICKAXE_HEAD = ITEMS.register("bronze_pickaxe_head",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> BRONZE_SHOVEL_HEAD = ITEMS.register("bronze_shovel_head",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));

    public static final RegistryObject<Item> GOLDEN_AXE_HEAD = ITEMS.register("golden_axe_head",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> GOLDEN_BLADE = ITEMS.register("golden_blade",
            () -> new BladeItem(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> GOLDEN_COUNTERWEIGHT = ITEMS.register("golden_counterweight",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> GOLDEN_GUARD = ITEMS.register("golden_guard",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> GOLDEN_HOE_HEAD = ITEMS.register("golden_hoe_head",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> GOLDEN_PICKAXE_HEAD = ITEMS.register("golden_pickaxe_head",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> GOLDEN_SHOVEL_HEAD = ITEMS.register("golden_shovel_head",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));

    public static final RegistryObject<Item> STEEL_AXE_HEAD = ITEMS.register("steel_axe_head",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> STEEL_BLADE = ITEMS.register("steel_blade",
            () -> new BladeItem(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> STEEL_COUNTERWEIGHT = ITEMS.register("steel_counterweight",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> STEEL_GUARD = ITEMS.register("steel_guard",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> STEEL_HOE_HEAD = ITEMS.register("steel_hoe_head",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> STEEL_PICKAXE_HEAD = ITEMS.register("steel_pickaxe_head",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> STEEL_SHOVEL_HEAD = ITEMS.register("steel_shovel_head",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));

    public static final RegistryObject<Item> NETHERITE_AXE_HEAD = ITEMS.register("netherite_axe_head",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> NETHERITE_BLADE = ITEMS.register("netherite_blade",
            () -> new BladeItem(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> NETHERITE_COUNTERWEIGHT = ITEMS.register("netherite_counterweight",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> NETHERITE_GUARD = ITEMS.register("netherite_guard",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> NETHERITE_HOE_HEAD = ITEMS.register("netherite_hoe_head",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> NETHERITE_PICKAXE_HEAD = ITEMS.register("netherite_pickaxe_head",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> NETHERITE_SHOVEL_HEAD = ITEMS.register("netherite_shovel_head",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));



}
