package com.streakerone.smithplusmod.item.custom;

import com.streakerone.smithplusmod.block.ModBlocks;
import com.streakerone.smithplusmod.util.Contents;
import com.streakerone.smithplusmod.util.InventoryUtil;
import com.streakerone.smithplusmod.util.variables.temperature.Temperature;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class CrucibleWithMetalBlockItem extends BlockItem {
    Temperature temperature;
    Contents contents;

    public CrucibleWithMetalBlockItem(Block p_40565_, Properties p_40566_) {
        super(p_40565_, p_40566_);
        temperature = new Temperature(130);
        contents = new Contents(9);
        Player player = Minecraft.getInstance().player;
        if(player != null){
            addNbtData(player);
        }
    }

    private void addNbtData(Player player){
        ItemStack crucible =
                player.getInventory().getItem(InventoryUtil.getFirstInventoryIndex(player, ModBlocks.CERAMIC_CRUCIBLE_WITH_METAL.get().asItem()));

        CompoundTag nbtData = new CompoundTag();

        nbtData.putInt("smithplusmod.temperature", temperature.getValue());
        crucible.setTag(nbtData);
    }

    @Override
    public void inventoryTick(ItemStack item, Level level, Entity entity, int p_41407_, boolean p_41408_) {
        if (entity.tickCount % 40 == 0) {
            if (level.isClientSide) {
                temperature.coolDown();
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> pTooltipComponents, TooltipFlag tooltipFlag) {
        pTooltipComponents.add(new TranslatableComponent("tooltip.smithplusmod.crucible.temperature" + temperature));
        pTooltipComponents.add(new TranslatableComponent("tooltip.smithplusmod.crucible.contents"));
    }

}
