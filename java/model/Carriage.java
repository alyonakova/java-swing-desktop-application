package model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;

public class Carriage implements Serializable {
    private Bench[] benches;
    private CarriageType type;

    public Carriage(int benches) {
        this.setBenches(new Bench[benches]);
        for (int i = 0; i < benches; i++) {
            this.getBenches()[i] = new Bench();
        }
    }

    public void addShorty(Shorty shorty) {
        getBenches()[new Random().nextInt(getBenches().length)].addShorty(shorty);
    }

    public Bench[] getBenches() {
        return benches;
    }

    public void setBenches(Bench[] benches) {
        this.benches = benches;
    }

    public void setType(CarriageType type) {
        this.type = type;
    }

    public CarriageType getType() {
        return type;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Carriage)
            return this.benches.equals(((Carriage) obj).benches);
        else
            return false;
    }

    @Override
    public int hashCode() {
        return this.benches.hashCode();
    }

    @Override
    public String toString() {
        return "Carriage with " + benches.length + " benches, type: " + getType();
    }

    public void addBench() {
        this.benches = Arrays.copyOf(this.benches, this.benches.length + 1);
        this.benches[this.benches.length - 1] = new Bench();
    }
}
