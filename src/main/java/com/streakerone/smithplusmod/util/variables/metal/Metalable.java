package com.streakerone.smithplusmod.util.variables.metal;

public interface Metalable {
    //returns integer value of temperature needed to melt metal
    int getMeltingTemperature();
    //returns ideal forging temperature of metal
    int getIdealForgingTemperature();
    //returns minimal forging temperature, under which trying to forge metal results in cracked metal bar
    int getMinForgingTemperature();
    //returns maximal forging temperature, over which truing to forge metal results in overheated metal chunk
    int getMaxForgingTemperature();
    //returns time in ticks, that metal needs to heat up 10 degrees Celsium
    int getTicksPerHeatUnit();
    //returns value of metal
    int getValue();
    //returns boolean value for if object is alloy or not
    boolean isAlloy();
}
