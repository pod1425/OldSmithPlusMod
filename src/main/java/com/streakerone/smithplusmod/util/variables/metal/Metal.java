package com.streakerone.smithplusmod.util.variables.metal;

import net.minecraft.network.chat.TranslatableComponent;

import java.util.Locale;

import static com.streakerone.smithplusmod.util.ModTags.METALS_LIST;

public class Metal implements Metalable {
    private int id;
    protected String metalName;
    protected int meltingPoint;
    protected int ticksPerHeatUnit;
    protected int value;
    protected int maxForgingTemp;
    protected int minForgingTemp;
    protected int idealForgingTemp;

    Metal(String name) {
        id = METALS_LIST.findIdByName(name);
        if (id < 0) {
            throw new NullPointerException("Error: metal you are trying to use isn`t listed!");
        } else {
            metalName = name;
            copyProperties();
        }
    }

    private void copyProperties() {
        meltingPoint = METALS_LIST.getMeltingTemperature(metalName);
        ticksPerHeatUnit = METALS_LIST.getTicksPerHeatUnit(metalName);
        value = METALS_LIST.getValue(metalName);
        maxForgingTemp = METALS_LIST.getMaxForgingTemperature(metalName);
        minForgingTemp = METALS_LIST.getMinForgingTemperature(metalName);
        idealForgingTemp = METALS_LIST.getIdealForgingTemperature(metalName);
    }

    @Override
    public int getMeltingTemperature() {
        return meltingPoint;
    }

    @Override
    public int getIdealForgingTemperature() {
        return idealForgingTemp;
    }

    @Override
    public int getMinForgingTemperature() {
        return minForgingTemp;
    }

    @Override
    public int getMaxForgingTemperature() {
        return maxForgingTemp;
    }

    @Override
    public int getTicksPerHeatUnit() {
        return ticksPerHeatUnit;
    }

    @Override
    public int getValue() {
        return value;
    }

    public String toString(){
        return metalName;
    }

    public TranslatableComponent getName(){
        return new TranslatableComponent("variable.smithplusmod.metal." + metalName.toLowerCase(Locale.ROOT));
    }
}
