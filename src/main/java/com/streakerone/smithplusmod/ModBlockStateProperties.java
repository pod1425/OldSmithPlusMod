package com.streakerone.smithplusmod;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class ModBlockStateProperties {
    public static final IntegerProperty TEMPERATURE = IntegerProperty.create("temperature", 2, 250);
    public static final BooleanProperty IS_EMPTY = BooleanProperty.create("is_empty");
}
