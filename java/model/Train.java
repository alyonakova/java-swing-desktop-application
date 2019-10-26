package model;

import exception.CarriageException;
import exception.WrongLengthException;

import java.awt.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Train implements Comparable<Train>, Serializable {
    private Color color;
    private Carriage[] carriages;

    public Train(int carriages, Color color) {
        if (carriages <= 0 || carriages > 10) {
            throw new WrongLengthException("Length must be bigger than 0 or less than 10, current: " + carriages);
        }
        this.setCarriages(new Carriage[carriages]);
        this.color = color;
        try {
            new FillCarriage().fillCarriage(carriages);
        } catch (CarriageException ce) {
            System.out.println(ce.getMessage());
        }
        for (int i = 0; i < carriages; i++) {
            if (i == 0) {
                this.getCarriages()[i].setType(CarriageType.FORDRIVERS);
            } else if (i == 1) {
                this.getCarriages()[i].setType(CarriageType.RESTAURANT);
            } else
                this.getCarriages()[i].setType(CarriageType.USUAL);
        }
    }

    public void come() {
        System.out.println("The train arrived");
    }

    public void addShorty(Shorty shorty) {

        getCarriages()[new Random().nextInt(getCarriages().length)].addShorty(shorty);
    }

    public Carriage[] getCarriages() {
        return carriages;
    }

    public void setCarriages(Carriage[] carriages) {
        this.carriages = carriages;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Train)
            return this.carriages.equals(((Train) obj).carriages) && this.color.equals(((Train) obj).color);
        else
            return false;
    }

    @Override
    public int hashCode() {
        return this.carriages.hashCode() + this.color.hashCode();
    }

    private class FillCarriage {
        public void fillCarriage(int carriages) throws CarriageException {
            for (int i = 0; i < carriages; i++) {
                getCarriages()[i] = new Carriage(3);
            }

        }
    }

    @Override
    public String toString() {
        return "Train{" +
                "color=" + color +
                ", carriages=" + Arrays.toString(carriages) +
                '}';
    }


    @Override
    public int compareTo(Train o) {
        if (this.carriages == null || o.carriages == null) {
            return 0;
        }

        return Integer.compare(this.carriages.length, o.carriages.length);
    }

    public Color getColor() {
        return this.color;
    }

    public static final Comparator<Train> myCompare = new Comparator<Train>() {
        public int compare(Train first, Train second) {
            return first.getCarriages().length - second.getCarriages().length;
        }
    };

    public void setColor(Color col) {
        this.color = col;
    }

    public void addCarriage() {
        if (this.carriages.length == 10) {
            System.out.println("Length can't be more than 10");
        } else {
            this.carriages = Arrays.copyOf(this.carriages, carriages.length + 1);
            this.carriages[this.carriages.length - 1] = new Carriage(3);
        }
    }


}
