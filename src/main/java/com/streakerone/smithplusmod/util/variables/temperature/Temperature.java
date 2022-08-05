package com.streakerone.smithplusmod.util.variables.temperature;

import net.minecraft.nbt.StreamTagVisitor;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.TagType;
import net.minecraft.nbt.TagVisitor;

import java.io.DataOutput;
import java.io.IOException;

//TODO: develop class to handle temperature mechanic
public class Temperature {
    protected int temperature;
    public static final int MIN_TEMP = 2;
    public static final int MAX_TEMP = 250;

    public Temperature(int temperature) {
        setTemperature(temperature);
    }

    public void setTemperature(int argTemperature) {
        temperature = checkForValidTemp(argTemperature);
    }

    public int getValue() {
        return temperature;
    }

    protected void changeTemperature(int increment) {
        temperature = checkForValidTemp(temperature + increment);
    }

    public void coolDown(){
        changeTemperature(-1);
    }

    public void heatUp(){
        changeTemperature(1);
    }

    public String toString(){
        return temperature + "0";
    }

    private int checkForValidTemp(int temp) {
        if (temp < MIN_TEMP) {
            return MIN_TEMP;
        } else {
            return Math.min(temp, MAX_TEMP);
        }
    }
}
