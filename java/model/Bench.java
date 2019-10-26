package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Bench implements Serializable {
    private final int capacity = 4;
    private transient ArrayList<Shorty> shortys = new ArrayList<Shorty>();

    public boolean addShorty(Shorty shorty) {
        if (getShortys().size() < capacity) {
            getShortys().add(shorty);
            return true;
        } else
            return false;
    }

    public boolean hasPlace() {
        if (getShortys().size() < capacity)
            return true;
        else
            return false;
    }

    public ArrayList<Shorty> getShortys() {
        return shortys;
    }

    public void setShortys(ArrayList<Shorty> shortys) {
        this.shortys = shortys;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Bench)
            return this.shortys.equals(((Bench) obj).shortys);
        else
            return false;
    }

    @Override
    public int hashCode() {
        return this.shortys.hashCode();
    }

    @Override
    public String toString() {
        return "Bench with capacity 4";
    }
}
