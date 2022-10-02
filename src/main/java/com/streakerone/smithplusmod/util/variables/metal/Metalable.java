package com.streakerone.smithplusmod.util.variables.metal;

public interface Metalable {
    /**
     * @return name of the metal
     */
    String getName();
    /**
     * @return integer value of temperature needed to melt metal
     */
    int getMeltingTemperature();

    /**
     * @return ideal forging temperature of metal
     */
    int getIdealForgingTemperature();

    /**
     * @return minimal forging temperature, under which trying to forge metal results in cracked metal bar
     */
    int getMinForgingTemperature();

    /**
     * @return maximal forging temperature, over which trying to forge metal results in overheated metal chunk
     */
    int getMaxForgingTemperature();

    /**
     * @return time in ticks, that metal needs to heat up 10 degrees Celsium
     */
    int getTicksPerHeatUnit();

    /**
     * @return value of metal
     */
    int getValue();

    /**
     * @return if object is alloy or not
     */
    boolean isAlloy();
}
