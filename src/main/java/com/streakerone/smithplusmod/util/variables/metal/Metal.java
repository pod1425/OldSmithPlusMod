package com.streakerone.smithplusmod.util.variables.metal;

import com.streakerone.smithplusmod.util.ModLists;

public class Metal implements Metalable {
    private int id;
    protected String name;
    protected int meltingPoint;
    protected int ticksPerHeatUnit;
    protected int value;
    protected int maxForgingTemp;
    protected int minForgingTemp;
    protected int idealForgingTemp;

    public Metal(String name) {
        id = ModLists.Metals.findIdByName(name);
        if (id < 0) {
            throw new NullPointerException("metal you are trying to use isn`t listed!");
        } else {
            this.name = name;
            copyProperties();
        }
    }

    private void copyProperties() {
        meltingPoint = ModLists.Metals.getMeltingTemperature(name);
        ticksPerHeatUnit = ModLists.Metals.getTicksPerHeatUnit(name);
        value = ModLists.Metals.getValue(name);
        maxForgingTemp = ModLists.Metals.getMaxForgingTemperature(name);
        minForgingTemp = ModLists.Metals.getMinForgingTemperature(name);
        idealForgingTemp = ModLists.Metals.getIdealForgingTemperature(name);
    }

    /**
     * @return name of the metal
     */
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

    public String toString(){
        return name;
    }

    public void changeMetal(String name){
        int tempid = ModLists.Metals.findIdByName(name);
        if (id < 0) {
            throw new NullPointerException("metal you are trying to use isn`t listed!");
        } else {
            id = tempid;
            this.name = name;
            copyProperties();
        }
    }

    @Override
    public boolean isAlloy(){
        return false;
    }
}
