package model;

import exception.NoBenchException;

import java.util.List;
import java.util.Random;

public class Ponchik extends Shorty {
    private Friend[] friends;

    public Ponchik() {
        super("Ponchik");
    }

    public void tellGoodbyeToFriends() {
        for (Friend cur : getFriends()) {
            cur.tellGoodbye();
        }
    }

    public void sitBack(Bench bench) throws NoBenchException {
        if (bench != null)
            System.out.println("Sit on the bench");
        else {
            throw new NoBenchException();
        }
    }

    public void lookPassengers(List<? extends Passenger> passenger) {
        for (int i = 0; i < passenger.size(); i++) {
            System.out.println(PassengerView.getView());
        }
    }

    public void listenTalks(Talk talk) {
        System.out.println("Overhear conversation");
    }

    public Friend[] getFriends() {
        return friends;
    }

    public void setFriends(Friend[] friends) {
        this.friends = friends;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public int hashCode() {
        return this.friends.hashCode();
    }

    @Override
    public String toString() {
        return "Ponchik";
    }

    private static class PassengerView {
        public static String getView() {
            switch (new Random().nextInt(4)) {
                case 1:
                    return "I'm looking at the sleeping passenger";
                case 2:
                    return "I'm looking at the reading passenger";
                case 3:
                    return "I'm looking at the thinking passenger";
                default:
                    return "I'm looking at the passenger...";
            }
        }
    }
}