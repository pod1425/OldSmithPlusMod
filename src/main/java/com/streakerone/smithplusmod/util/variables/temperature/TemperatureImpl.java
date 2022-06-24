package com.streakerone.smithplusmod.util.variables.temperature;

//TODO: migrate methods to Temperature.java and delete this

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class TemperatureImpl extends BlockEntity implements Heatable {
    //multiply by 10 to get actual temp in celsius
    protected int temperature;
    public static final int MIN_TEMP = 2;
    public static final int MAX_TEMP = 250;

    public TemperatureImpl(BlockEntityType<?> p_155228_, BlockPos p_155229_, BlockState p_155230_) {
        super(p_155228_, p_155229_, p_155230_);
    }

    @Override
    public void setTemperature(int argTemperature) {
        temperature = checkForValidTemp(argTemperature);
    }
    @Override
    public int getTemperature() {
        return temperature;
    }

    @Override
    public void changeTemperature(int increment) {
        temperature = checkForValidTemp(temperature + increment);
    }

    private int checkForValidTemp(int temp){
        if(temp < MIN_TEMP){
            return MIN_TEMP;
        } else {
            return Math.min(temp, MAX_TEMP);
        }
    }
}
