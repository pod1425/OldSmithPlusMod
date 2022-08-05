package com.streakerone.smithplusmod.util;

import com.streakerone.smithplusmod.util.variables.metal.Metalable;

public class Contents {
    protected Metalable contents;
    protected int amount;
    protected int maxCapacity;

    public Contents(int maxCapacity){
        this.maxCapacity = maxCapacity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Metalable getContents() {
        return contents;
    }

    public void setContents(Metalable contents) {
        this.contents = contents;
    }
}
