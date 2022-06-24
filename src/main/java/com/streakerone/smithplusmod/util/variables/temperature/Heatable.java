package com.streakerone.smithplusmod.util.variables.temperature;
//TODO: finish heat interface
public interface Heatable {
    void setTemperature(int argTemperature);
    int getTemperature();

    void changeTemperature(int increment);

}
