package model;

public abstract class Shorty implements Passenger, Friend {

    private String name;

    public Shorty(String name) {
        this.name = name;
    }

    public void goToCarriage(Carriage carriage) {
        System.out.println("Come to the carriage");
    }

    public Bench searchPlaceInCarriage(Carriage carriage) {
        for (Bench bench : carriage.getBenches()) {
            System.out.println(bench);
            if (bench.hasPlace())
                return bench;
        }
        return null;
    }

    public Talk getTalk() {
        return new Talk();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Shorty)
            return this.name.equals(((Shorty) obj).name);
        else
            return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void tellGoodbye() {
        System.out.println("Goodbye, my friend!");
    }

    public Shorty() {
    }
}
