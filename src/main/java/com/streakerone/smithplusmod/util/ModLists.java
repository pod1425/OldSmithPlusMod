package com.streakerone.smithplusmod.util;

import com.streakerone.smithplusmod.util.variables.metal.Metal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//TODO: copy entire class from test project
public class ModLists {
    protected static final double COEFFICIENT = 4.0;

    public static class Components {
        public static class CompNode {
            String name;

            public CompNode(String name) {
                this.name = name;
            }

        }

        protected static List<CompNode> components = new ArrayList<>();

        public static void init() {
            components.add(new CompNode("Carbon"));
        }

        public static boolean contains(String name) {
            for (CompNode node : components) {
                if (node.name.equals(name)) {
                    return true;
                }
            }
            return false;
        }

        public static int findIdByName(String name) {
            for (int i = 0; i < components.size(); i++) {
                if (components.get(i).name.equals(name)) {
                    return i;
                }
            }
            return -1;
        }

    }

    public static class Gems {
        public static class Node extends Components.CompNode {
            String name;
            int value;
            boolean isCut;

            public Node(String name, int value, boolean isCut) {
                super(name);
                this.value = value;
            }

        }

        protected static List<Node> gems = new ArrayList<>();

        public static void init() {
            gems.add(new Node("Diamond", 6, false));
            gems.add(new Node("Emerald", 4, false));
            gems.add(new Node("Cut_Quartz", 5, true));
            gems.add(new Node("Cut_Diamond", 10, true));
            gems.add(new Node("Cut_Emerald", 8, true));
        }

        public static boolean contains(String name) {
            for (Node node : gems) {
                if (node.name.equals(name)) {
                    return true;
                }
            }
            return false;
        }

        public static int findIdByName(String name) {
            for (int i = 0; i < gems.size(); i++) {
                if (gems.get(i).name.equals(name)) {
                    return i;
                }
            }
            return -1;
        }

    }

    public static class Alloys {
        protected static class Node extends Components.CompNode {
            protected int meltingPoint;
            protected int heatConductivity;

            protected List<Metal> components;
            protected List<Integer> componentsAmount;
            protected int value;

            int minForgingTemperature;
            int maxForgingTemperature;
            int idealForgingTemperature;


            public Node(String alloyName, List<Metal> components, List<Integer> componentsAmount, int value) {
                super(alloyName);
                if (components.size() != componentsAmount.size()) {
                    throw new IllegalArgumentException("error: Amount of elements in components and componentsAmount list must match!");
                } else {
                    this.name = alloyName;
                    this.components = components;
                    this.componentsAmount = componentsAmount;
                    this.value = value;
                }
            }

            public Node(Node node, int heatConductivity, int minFT, int maxFT, int idealFT) {
                super(node.name);
                this.meltingPoint = node.meltingPoint;
                this.heatConductivity = heatConductivity;

                this.components = node.components;
                this.componentsAmount = node.componentsAmount;

                this.value = node.value;

                this.minForgingTemperature = minFT;
                this.idealForgingTemperature = idealFT;
                this.maxForgingTemperature = maxFT;
            }

        }

        protected static List<Node> alloys = new ArrayList<>();
        protected static List<Integer> meltingTime = new ArrayList<>();


        public static void init() {
            alloys.add(new Node("Steel", List.of(new Metal("Iron")), List.of(75), 2));
            alloys.add(new Node("Netherite", List.of(new Metal("Gold"), new Metal("Platinum")), List.of(10, 90), 6));
            alloys.add(new Node("Bronze", List.of(new Metal("Copper"), new Metal("Tin")), List.of(75, 25), 2));
            alloys.add(new Node("Electrum", List.of(new Metal("Gold"), new Metal("Silver")), List.of(50, 50), 5));
            alloys.add(new Node("Ashtadhatu", List.of(new Metal("Gold"), new Metal("Silver"), new Metal("Copper"), new Metal("Lead"), new Metal("Tin")),
                    List.of(10, 30, 10, 30, 20), 5));

            calculateMeltingPoints();
            calculateHeatConductivity();
            defineTicksPerHeatUnit();

        }

        private static void defineTicksPerHeatUnit() {
            int[] line = new int[alloys.size()];
            for (int i = 0; i < alloys.size(); i++) {
                line[i] = alloys.get(i).heatConductivity;
            }
            meltingTime = leastRegressionLine(line, 30, 7, 1);
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

        public static boolean contains(String name) {
            for (Node alloy : alloys) {
                if (alloy.name.equals(name)) {
                    return true;
                }
            }
            return false;
        }

        public static int findIdByName(String name) {
            for (int i = 0; i < alloys.size(); i++) {
                if (alloys.get(i).name.equals(name)) {
                    return i;
                }
            }
            return -1;
        }

        private static void calculateMeltingPoints() {
            int meltingPoint;
            for (Node alloy : alloys) {
                meltingPoint = 0;
                for (Metal content : alloy.components) {
                    meltingPoint += content.getMeltingTemperature();
                }
                meltingPoint /= alloy.components.size();
                alloy.meltingPoint = meltingPoint;
            }
        }

        private static void calculateHeatConductivity() {
            for (int i = 0; i < alloys.size(); i++) {
                int conductivity = 0;
                int minFT = 0, idealFT = 0, maxFT = 0;
                for (int j = 0; j < alloys.get(i).components.size(); j++) {
                    String name = alloys.get(i).components.get(j).toString();
                    double coef = (double) alloys.get(i).componentsAmount.get(j) * 0.01;

                    conductivity += Metals.metals.get(Metals.findIdByName(name)).heatConductivity * coef;
                    idealFT += Metals.calculateIdealForgingTemperature(name) * coef;
                    minFT += Metals.calculateMinForgingTemperature(name) * coef;
                    maxFT += Metals.calculateMaxForgingTemperature(name) * coef;
                }
                alloys.set(i, new Node(alloys.get(i), conductivity, minFT, maxFT, idealFT));
            }
        }

        public static int getMeltingTemperature(String metalName) {
            return alloys.get(findIdByName(metalName)).meltingPoint;
        }

        public static int getIdealForgingTemperature(String metalName) {
            return (int) (alloys.get(findIdByName(metalName)).meltingPoint * 0.7);
        }

        public static int getMinForgingTemperature(String metalName) {
            int id = findIdByName(metalName);
            Node res = alloys.get(id);
            return (int) (res.meltingPoint * 0.7 - res.meltingPoint *
                    (COEFFICIENT / (double) meltingTime.get(id)));
        }

        public static int getMaxForgingTemperature(String metalName) {
            int id = findIdByName(metalName);
            Node res = alloys.get(id);
            return (int) (res.meltingPoint * 0.7 + res.meltingPoint *
                    (COEFFICIENT / (double) meltingTime.get(id)));
        }

        public static int getTicksPerHeatUnit(String metalName) {
            return meltingTime.get(findIdByName(metalName));
        }

        public static int getValue(String name) {
            return alloys.get(findIdByName(name)).value;
        }

        public static List<Metal> getComponents(String name){
            return alloys.get(findIdByName(name)).components;
        }
        public static List<Integer> getComponentsAmount(String name){
            return alloys.get(findIdByName(name)).componentsAmount;
        }

    }

    public static class Metals {
        protected static class Node extends Components.CompNode {
            protected int meltingPoint;
            public int heatConductivity;
            protected int value;

            int ticksPerHeatUnit;
            int minForgingTemperature;
            int maxForgingTemperature;
            int idealForgingTemperature;

            public Node(String name, int meltingPoint, int heatConductivity, int value) {
                super(name);
                this.meltingPoint = meltingPoint;
                this.heatConductivity = heatConductivity;
                this.value = value;
            }

            public Node(Node node, int ticksPerHeatUnit, int minForgingTemperature, int maxForgingTemperature, int idealForgingTemperature) {
                super(node.name);
                this.meltingPoint = node.meltingPoint;
                this.heatConductivity = node.heatConductivity;
                this.value = node.value;

                this.ticksPerHeatUnit = ticksPerHeatUnit;
                this.minForgingTemperature = minForgingTemperature;
                this.maxForgingTemperature = maxForgingTemperature;
                this.idealForgingTemperature = idealForgingTemperature;
            }
        }

        protected static List<Node> metals = new ArrayList<>();
        protected static List<Integer> meltingTimes = new ArrayList<>();


        public static void init() {
            metals.add(new Node("Iron", 153, 80, 1));
            metals.add(new Node("Tin", 23, 67, 1));
            metals.add(new Node("Copper", 108, 398, 1));
            metals.add(new Node("Gold", 106, 310, 4));
            metals.add(new Node("Silver", 96, 429, 3));
            metals.add(new Node("Lead", 33, 35, 0));
            metals.add(new Node("Platinum", 176, 72, 5));
            metals.add(new Node("Titanium", 166, 17, 2));//easy to warm and easy to cool

            defineTicksPerHeatUnit();
            defineHeatProperties();
        }

        private static void defineHeatProperties() {
            for (int i = 0; i < metals.size(); i++) {
                int ticks = 0;
                int minFT = 0, idealFT = 0, maxFT = 0;

                ticks = meltingTimes.get(i);
                minFT = calculateMinForgingTemperature(metals.get(i).name);
                maxFT = calculateMaxForgingTemperature(metals.get(i).name);
                idealFT = calculateIdealForgingTemperature(metals.get(i).name);
                metals.set(i, new Node(metals.get(i), ticks, minFT, maxFT, idealFT));
            }
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

        public static boolean contains(String name) {
            for (Node metal : metals) {
                if (metal.name.equals(name)) {
                    return true;
                }
            }
            return false;
        }

        private static void defineTicksPerHeatUnit() {
            int[] line = new int[metals.size()];
            for (int i = 0; i < metals.size(); i++) {
                line[i] = metals.get(i).heatConductivity;
            }
            meltingTimes = leastRegressionLine(line, 30, 7, 1);
        }

        public static int findIdByName(String name) {
            for (int i = 0; i < metals.size(); i++) {
                if (metals.get(i).name.equals(name)) {
                    return i;
                }
            }
            return -1;
        }
        //public getters for using in code

        public static int getMeltingTemperature(String metalName) {
            return metals.get(findIdByName(metalName)).meltingPoint;
        }

        public static int getIdealForgingTemperature(String metalName) {
            return metals.get(findIdByName(metalName)).idealForgingTemperature;
        }

        public static int getMinForgingTemperature(String metalName) {
            return metals.get(findIdByName(metalName)).minForgingTemperature;
        }

        public static int getMaxForgingTemperature(String metalName) {
            return metals.get(findIdByName(metalName)).maxForgingTemperature;
        }

        private static int calculateIdealForgingTemperature(String metalName) {
            return (int) (metals.get(findIdByName(metalName)).meltingPoint * 0.7);
        }

        private static int calculateMinForgingTemperature(String metalName) {
            int id = findIdByName(metalName);
            Node res = metals.get(id);
            return (int) (res.meltingPoint * 0.7 - res.meltingPoint *
                    (COEFFICIENT / (double) meltingTimes.get(id)));
        }

        private static int calculateMaxForgingTemperature(String metalName) {
            int id = findIdByName(metalName);
            Node res = metals.get(id);
            return (int) (res.meltingPoint * 0.7 + res.meltingPoint *
                    (COEFFICIENT / (double) meltingTimes.get(id)));
        }

        public static int getTicksPerHeatUnit(String metalName) {
            return meltingTimes.get(findIdByName(metalName));
        }

        public static int getValue(String name) {
            return metals.get(findIdByName(name)).value;
        }
    }

}
