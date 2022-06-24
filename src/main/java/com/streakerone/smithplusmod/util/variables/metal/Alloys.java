package com.streakerone.smithplusmod.util.variables.metal;

import java.util.ArrayList;
import java.util.List;

public class Alloys extends Metals {
    class ANode{
        protected String name;
        protected int meltingPoint;
        protected int heatConductivity;
        protected int value;


    }

    protected List<ANode> alloys = new ArrayList<>();

}
