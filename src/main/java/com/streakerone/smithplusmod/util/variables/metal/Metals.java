package com.streakerone.smithplusmod.util.variables.metal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Metals {
    protected class Node{
        protected String name;
        protected int meltingPoint;
        protected int heatConductivity;
        protected int value;


        public Node(String name, int meltingPoint, int heatConductivity, int value){
            this.name = name;
            this.meltingPoint = meltingPoint;
            this.heatConductivity = heatConductivity;
            this.value = value;
        }
    }

    protected List<Node> metals = new ArrayList<>();
    protected List<Integer> meltingTime = new ArrayList<>();
    public int amountOfMetals;
    protected final double COEFFICIENT = 4.0;

    public Metals(){
        metals.add(new Node("Iron", 153, 80, 1));
        metals.add(new Node("Tin", 23, 67, 1));
        metals.add(new Node("Copper", 108, 398, 1));
        metals.add(new Node("Gold", 106, 310, 4));
        metals.add(new Node("Silver", 96, 429, 3));
        metals.add(new Node("Lead", 33, 35, 0));
        metals.add(new Node("Platinum", 176, 72, 5));
        metals.add(new Node("Titanium", 166, 17, 2));//easy to warm and easy to cool

        defineTicksPerHeatUnit();
        updateMetalsAmount();
    }

    private static double calculateB(int[] xArray, int[] yArray) {
        int xArrayLength = xArray.length;
        int sumArrX = Arrays.stream(xArray).sum();
        int sumArrY = Arrays.stream(yArray).sum();

        int sumOfXY = 0, sumOfSquaredX = 0;
        for (int i = 0; i < xArrayLength; i++) {
            sumOfXY += xArray[i] * yArray[i];
            sumOfSquaredX += xArray[i] * xArray[i];
        }
        return (double) (xArrayLength * sumOfXY - sumArrX * sumArrY)
                / (xArrayLength * sumOfSquaredX - sumArrX * sumArrX);
    }
    private static List<Integer> leastRegressionLine(int[] xArray, int start, int increment, double smoothLineCoefficient) {
        int[] yArray = new int[xArray.length];
        for (int i = 0, j = start; i < xArray.length; i++, j = j + increment) {
            yArray[i] = j;
        }

        double b = calculateB(xArray, yArray);
        int arrayLength = xArray.length;
        int meanX = Arrays.stream(xArray).sum() / arrayLength;
        int meanY = Arrays.stream(yArray).sum() / arrayLength;

        double a = meanY - b * meanX;
        List<Integer> result = new ArrayList<>();
        for (int j : xArray) {
            result.add((int) (a + b * j * smoothLineCoefficient));
        }
        return result;
    }

    public boolean contains(String name){
        for(Node metal : metals){
            if(metal.name.equals(name)){
                return true;
            }
        }
        return false;
    }

    private void defineTicksPerHeatUnit(){
        int[] line = new int [metals.size()];
        for(int i = 0; i < metals.size(); i++){
            line[i] = metals.get(i).heatConductivity;
        }
        meltingTime = leastRegressionLine(line, 30, 7, 1);
    }

    private void updateMetalsAmount(){
        amountOfMetals = metals.size();
    }

    public int findIdByName(String name){
        for(int i = 0; i < metals.size(); i++){
            if(metals.get(i).name.equals(name)){
                return i;
            }
        }
        return -1;
    }
    //public getters for using in code

    public int getMeltingTemperature(String metalName){
        return metals.get(findIdByName(metalName)).meltingPoint;
    }
    public int getIdealForgingTemperature(String metalName){
        return (int)(metals.get(findIdByName(metalName)).meltingPoint * 0.7);
    }

    //TODO: change "* res.heatConductivity" so it uses ticksPerHeatUnit

    public int getMinForgingTemperature(String metalName){
        int id = findIdByName(metalName);
        Node res = metals.get(id);
        return (int)(res.meltingPoint * 0.7 - res.meltingPoint *
                (COEFFICIENT / (double) meltingTime.get(id)));
    }

    public int getMaxForgingTemperature(String metalName){
        int id = findIdByName(metalName);
        Node res = metals.get(id);
        return (int)(res.meltingPoint * 0.7 + res.meltingPoint *
                (COEFFICIENT / (double) meltingTime.get(id)));
    }

    public int getTicksPerHeatUnit(String metalName){
        return meltingTime.get(findIdByName(metalName));
    }

    public int getValue(String name){
        return metals.get(findIdByName(name)).value;
    }
}
