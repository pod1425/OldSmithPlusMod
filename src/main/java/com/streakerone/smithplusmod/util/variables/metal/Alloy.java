package com.streakerone.smithplusmod.util.variables.metal;

import com.streakerone.smithplusmod.util.ModLists;

import java.util.List;

public class Alloy implements Metalable{
    private int id;
    protected String name;
    protected int value;
    protected int meltingPoint;
    protected int ticksPerHeatUnit;
    protected int maxForgingTemp;
    protected int minForgingTemp;
    protected int idealForgingTemp;

    protected List<Metal> components;
    protected List<Integer> componentsAmount;

    public Alloy(String name) {
        id = ModLists.Alloys.findIdByName(name);
        if (id < 0) {
            throw new NullPointerException("alloy you are trying to use isn`t listed!");
        } else {
            this.name = name;
            copyProperties();
        }
    }

    private void copyProperties(){
        value = ModLists.Alloys.getValue(name);
        components = ModLists.Alloys.getComponents(name);
        componentsAmount = ModLists.Alloys.getComponentsAmount(name);
        meltingPoint = ModLists.Alloys.getMeltingTemperature(name);
        ticksPerHeatUnit = ModLists.Alloys.getTicksPerHeatUnit(name);

        minForgingTemp = ModLists.Alloys.getMinForgingTemperature(name);
        idealForgingTemp = ModLists.Alloys.getIdealForgingTemperature(name);
        maxForgingTemp = ModLists.Alloys.getMaxForgingTemperature(name);

    }

    @Override
    public String getName() {
        return name;
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

    @Override
    public boolean isAlloy(){
        return true;
    }
}
