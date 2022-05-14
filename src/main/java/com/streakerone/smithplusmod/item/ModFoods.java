package com.streakerone.smithplusmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties FIBER = (new FoodProperties.Builder()).fast().nutrition(1).saturationMod(0.1F).effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 0), 0.2F).build();
}
