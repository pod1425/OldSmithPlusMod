package com.streakerone.smithplusmod.item;

import com.streakerone.smithplusmod.SmithPlusMod;
import com.streakerone.smithplusmod.item.custom.*;
import com.streakerone.smithplusmod.item.custom.smithing.CrucibleGripItem;
import com.streakerone.smithplusmod.item.custom.smithing.HammerItem;
import net.minecraft.world.item.*;
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
    //TODO: add refining flux?
    //TODO: add platinum and titanium
    //TODO: add all kinds of wires
    //TODO: add junk metal alloy, cracked metal bar, overheated metal chunk

    //barks
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
    //tin
    public static final RegistryObject<Item> RAW_TIN = ITEMS.register("raw_tin",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    public static final RegistryObject<Item> TIN_NUGGET = ITEMS.register("tin_nugget",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    //lead
    public static final RegistryObject<Item> RAW_LEAD = ITEMS.register("raw_lead",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    public static final RegistryObject<Item> LEAD_NUGGET = ITEMS.register("lead_nugget",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    //silver
    //TODO: add silver nugget
    public static final RegistryObject<Item> RAW_SILVER = ITEMS.register("raw_silver",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    //random materials
    public static final RegistryObject<Item> ROPE = ITEMS.register("rope",
            () -> new FuelItem(200, new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    public static final RegistryObject<Item> FIBER = ITEMS.register("fiber",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS).food(ModFoods.FIBER)));
    public static final RegistryObject<Item> COKE_COAL = ITEMS.register("coke_coal",
            () -> new FuelItem(3200, new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    //parts
    //wooden
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
    //cobble
    public static final RegistryObject<Item> LONG_BOULDER = ITEMS.register("long_boulder",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> MASSIVE_BOULDER = ITEMS.register("massive_boulder",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> FLAT_BOULDER = ITEMS.register("flat_boulder",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> SMALL_BOULDER = ITEMS.register("small_boulder",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> SHARPEN_FLAT_BOULDER = ITEMS.register("sharpen_flat_boulder",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));
    public static final RegistryObject<Item> SHARPEN_SMALL_BOULDER = ITEMS.register("sharpen_small_boulder",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_PARTS)));


    //iron
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
    //bronze
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
    //gold
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
    //steel
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
    //netherite
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

    //weapons
    public static final RegistryObject<Item> STEEL_KATANA = ITEMS.register("steel_katana",
            () -> new SwordItem(ModTiers.KATANA_TIER, 0, -1.0f, new Item.Properties().tab(ModItemGroup.SMITH_TOOLS_AND_WEAPONS).stacksTo(1)));
    public static final RegistryObject<Item> NETHERITE_KATANA = ITEMS.register("netherite_katana",
            () -> new SwordItem(ModTiers.KATANA_TIER, 1, -1.0f, new Item.Properties().tab(ModItemGroup.SMITH_TOOLS_AND_WEAPONS).stacksTo(1)));

    //tools
    //flint
    public static final RegistryObject<Item> FLINT_PICKAXE = ITEMS.register("flint_pickaxe",
            () -> new PickaxeItem(ModTiers.FLINT, 1, -2.7f, new Item.Properties().tab(ModItemGroup.SMITH_TOOLS_AND_WEAPONS).stacksTo(1)));
    public static final RegistryObject<Item> FLINT_AXE = ITEMS.register("flint_axe",
            () -> new AxeItem(ModTiers.FLINT, 5.0f, -3.0f, new Item.Properties().tab(ModItemGroup.SMITH_TOOLS_AND_WEAPONS).stacksTo(1)));
    public static final RegistryObject<Item> FLINT_SHOVEL = ITEMS.register("flint_shovel",
            () -> new ShovelItem(ModTiers.FLINT, 0.0f, -3.0f, new Item.Properties().tab(ModItemGroup.SMITH_TOOLS_AND_WEAPONS).stacksTo(1)));
    public static final RegistryObject<Item> FLINT_HOE = ITEMS.register("flint_hoe",
            () -> new HoeItem(ModTiers.FLINT, -1, 0.0f, new Item.Properties().tab(ModItemGroup.SMITH_TOOLS_AND_WEAPONS).stacksTo(1)));
    //bronze
    public static final RegistryObject<Item> BRONZE_SWORD = ITEMS.register("bronze_sword",
            () -> new SwordItem(ModTiers.BRONZE, 3, -2.4f, new Item.Properties().tab(ModItemGroup.SMITH_TOOLS_AND_WEAPONS).stacksTo(1)));
    public static final RegistryObject<Item> BRONZE_PICKAXE = ITEMS.register("bronze_pickaxe",
            () -> new PickaxeItem(ModTiers.BRONZE, 1, -2.7f, new Item.Properties().tab(ModItemGroup.SMITH_TOOLS_AND_WEAPONS).stacksTo(1)));
    public static final RegistryObject<Item> BRONZE_AXE = ITEMS.register("bronze_axe",
            () -> new AxeItem(ModTiers.BRONZE, 5.0f, -3.0f, new Item.Properties().tab(ModItemGroup.SMITH_TOOLS_AND_WEAPONS).stacksTo(1)));
    public static final RegistryObject<Item> BRONZE_SHOVEL = ITEMS.register("bronze_shovel",
            () -> new ShovelItem(ModTiers.BRONZE, 0.0f, -3.0f, new Item.Properties().tab(ModItemGroup.SMITH_TOOLS_AND_WEAPONS).stacksTo(1)));
    public static final RegistryObject<Item> BRONZE_HOE = ITEMS.register("bronze_hoe",
            () -> new HoeItem(ModTiers.BRONZE, -1, 0.0f, new Item.Properties().tab(ModItemGroup.SMITH_TOOLS_AND_WEAPONS).stacksTo(1)));
    //steel
    public static final RegistryObject<Item> STEEL_SWORD = ITEMS.register("steel_sword",
            () -> new SwordItem(ModTiers.STEEL, 3, -2.4f, new Item.Properties().tab(ModItemGroup.SMITH_TOOLS_AND_WEAPONS).stacksTo(1)));
    public static final RegistryObject<Item> STEEL_PICKAXE = ITEMS.register("steel_pickaxe",
            () -> new PickaxeItem(ModTiers.STEEL, 1, -2.7f, new Item.Properties().tab(ModItemGroup.SMITH_TOOLS_AND_WEAPONS).stacksTo(1)));
    public static final RegistryObject<Item> STEEL_AXE = ITEMS.register("steel_axe",
            () -> new AxeItem(ModTiers.STEEL, 5.0f, -3.0f, new Item.Properties().tab(ModItemGroup.SMITH_TOOLS_AND_WEAPONS).stacksTo(1)));
    public static final RegistryObject<Item> STEEL_SHOVEL = ITEMS.register("steel_shovel",
            () -> new ShovelItem(ModTiers.STEEL, 0.0f, -3.0f, new Item.Properties().tab(ModItemGroup.SMITH_TOOLS_AND_WEAPONS).stacksTo(1)));
    public static final RegistryObject<Item> STEEL_HOE = ITEMS.register("steel_hoe",
            () -> new HoeItem(ModTiers.STEEL, -1, 0.0f, new Item.Properties().tab(ModItemGroup.SMITH_TOOLS_AND_WEAPONS).stacksTo(1)));
    //smithing stuff
    public static final RegistryObject<Item> IRON_HAMMER = ITEMS.register("iron_hammer",
            () -> new HammerItem(new Item.Properties().tab(ModItemGroup.SMITH_TOOLS_AND_WEAPONS)));
    public static final RegistryObject<Item> STEEL_HAMMER = ITEMS.register("steel_hammer",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_TOOLS_AND_WEAPONS)));
    public static final RegistryObject<Item> TITANIUM_HAMMER = ITEMS.register("titanium_hammer",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));

    public static final RegistryObject<Item> IRON_TONGS = ITEMS.register("iron_tongs",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    public static final RegistryObject<Item> STEEL_TONGS = ITEMS.register("steel_tongs",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    public static final RegistryObject<Item> TITANIUM_TONGS = ITEMS.register("titanium_tongs",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));

    public static final RegistryObject<Item> CRUCIBLE_GRIP = ITEMS.register("crucible_grip",
            () -> new CrucibleGripItem(new Item.Properties().tab(ModItemGroup.SMITH_TOOLS_AND_WEAPONS)));

    //gems stuff
    public static final RegistryObject<Item> DIAMOND_DUST = ITEMS.register("diamond_dust",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    public static final RegistryObject<Item> AMETHYST_DUST = ITEMS.register("amethyst_dust",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    public static final RegistryObject<Item> EMERALD_DUST = ITEMS.register("emerald_dust",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    public static final RegistryObject<Item> LAPIS_DUST = ITEMS.register("lapis_dust",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    public static final RegistryObject<Item> QUARTZ_DUST = ITEMS.register("quartz_dust",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    public static final RegistryObject<Item> AMBER_DUST = ITEMS.register("amber_dust",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    public static final RegistryObject<Item> CRYSTAL_QUARTZ = ITEMS.register("crystal_quartz",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    public static final RegistryObject<Item> REDSTONE_STONE = ITEMS.register("redstone_stone",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    public static final RegistryObject<Item> RPOLISHED_LAPIS = ITEMS.register("polished_lapis",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    public static final RegistryObject<Item> AMBER = ITEMS.register("amber",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));

    public static final RegistryObject<Item> CUT_DIAMOND = ITEMS.register("cut_diamond",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    public static final RegistryObject<Item> CUT_AMETHYST = ITEMS.register("cut_amethyst",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    public static final RegistryObject<Item> UNCUT_EMERALD = ITEMS.register("uncut_emerald",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    public static final RegistryObject<Item> CUT_LAPIS = ITEMS.register("cut_lapis",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    public static final RegistryObject<Item> CUT_CRYSTAL_QUARTZ = ITEMS.register("cut_crystal_quartz",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    public static final RegistryObject<Item> CUT_REDSTONE_STONE = ITEMS.register("cut_redstone_stone",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));
    public static final RegistryObject<Item> CUT_AMBER = ITEMS.register("cut_amber",
            () -> new Item(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));

    public static final RegistryObject<Item> RICK = ITEMS.register("rick",
            () -> new RickItem(new Item.Properties().tab(ModItemGroup.SMITH_MATERIALS)));

}
