import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import exception.NoBenchException;
import gui.Constants;
import gui.MenuScreen;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please select one filename and try again");
            System.exit(0);
        }
        String fileName = args[0];
        Railroad railroad = new Railroad();
        railroad.doImport(fileName);
        railroad.saveToFile(Constants.PLUS_FILE_NAME);
        JFrame.setDefaultLookAndFeelDecorated(true);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MenuScreen();

            }
        });
    }

    /**
     * Execute all the program logic.
     *
     * @param args is array with args
     */
    private static void doWork(String[] args) {

        if (args.length != 1) {
            System.out.println("Please select one filename and try again");
            System.exit(0);
        }
        String fileName = args[0];

        Railroad railroad = new Railroad();
        railroad.doImport(fileName);
        railroad.saveToFile(Constants.PLUS_FILE_NAME);

        for (Train train : railroad.trains) {
            System.out.println(train);
        }
        railroad.trains.stream().forEach((train) -> {
            train.come();
        });
        Train train = railroad.trains.stream().findFirst().orElseThrow(RuntimeException::new);


        Ponchik ponchik = new Ponchik();
        ponchik.setFriends(new Friend[]{new Citizen() {
            @Override
            public void tellGoodbye() {
                System.out.println("Goodbye, Znayka!");
            }
        }, new Citizen() {
            @Override
            public void tellGoodbye() {
                System.out.println("Goodbye, my friend Neznayka!");
            }
        }, new Citizen()});
        ponchik.tellGoodbyeToFriends();
        Bench bench = null;
        Carriage carriage;
        for (int i = 0; i < 10; i++) {
            carriage = train.getCarriages()[new Random().nextInt(train.getCarriages().length)];
            ponchik.goToCarriage(carriage);
            bench = ponchik.searchPlaceInCarriage(carriage);
            try {
                ponchik.sitBack(bench);
                break;
            } catch (NoBenchException b) {
                System.out.println("Benches in the carriage are busy");
                continue;
            }
        }
        ponchik.lookPassengers(bench.getShortys());
        ponchik.listenTalks(new Talk());


        boolean needExit = false;
        Train forAction = null;
        while (!needExit) {
            Scanner keyboardScanner = new Scanner(System.in);
            System.out.println("Enter the command: // to exit, enter exit");
            String inputString = "";
            try {
                inputString = keyboardScanner.nextLine();
            } catch (NoSuchElementException ex) {
                break;
            }
            inputString = inputString.trim();
            String[] fullCom = inputString.split("(?:\\b\\s)");
            // fullCom[0] - command, fullCom[1] - argument
            if ((fullCom[0].equals("import") ||
                    fullCom[0].equals("add_if_min") ||
                    fullCom[0].equals("remove"))) {
                if (fullCom.length == 1) {
                    System.out.println("Error, " + fullCom[0] + " must have an argument.");
                    continue;
                }
                if ((fullCom.length == 2) && !(fullCom[0].equals("import"))) {
                    try {
                        Gson gson = new Gson();
                        forAction = gson.fromJson(fullCom[1], Train.class);
                        if (fullCom[0].equals("add_if_min")) {
                            if (forAction == null) {
                                forAction = new Train(3, Color.RED);
                                System.out.println("Train filled by default");
                            }
                            if (forAction.getColor() == null) {
                                forAction.setColor(Color.RED);
                                System.out.println("Color added by default: " + forAction.getColor());
                            }
                            if ((forAction.getCarriages() == null) || (forAction.getCarriages().length == 0)) {
                                forAction = new Train(3, forAction.getColor());
                                System.out.println("3 carriages with 3 benches added by default");
                            }
                            for (int a = 0; a < forAction.getCarriages().length; a++) {
                                if (forAction.getCarriages()[a].getType() == null) {
                                    forAction.getCarriages()[a].setType(CarriageType.USUAL);
                                    System.out.println("Type added by default: " + forAction.getCarriages()[a].getType());
                                }
                                if ((forAction.getCarriages()[a].getBenches() == null) || (forAction.getCarriages()[a] == null)
                                        || (forAction.getCarriages()[a].getBenches().length == 0)) {
                                    CarriageType ty = forAction.getCarriages()[a].getType();
                                    forAction.getCarriages()[a] = new Carriage(3);
                                    forAction.getCarriages()[a].setType(ty);
                                    System.out.println("3 benches added to the carriage by default");
                                }
                                for (int b = 0; b < forAction.getCarriages()[a].getBenches().length; b++) {
                                    forAction.getCarriages()[a].getBenches()[b] = new Bench();
                                }
                            }
                            System.out.println(forAction);
                        }
                    } catch (JsonSyntaxException ex) {
                        System.out.println("Error, element is invalid");
                        continue;

                    }
                }
            }
            if ((fullCom.length > 1) && !(fullCom[0].equals("import")) && !(fullCom[0].equals("add_if_min")) && !(fullCom[0].equals("remove"))) {
                System.out.println("The command is not set correctly");
                continue;
            }


            switch (fullCom[0]) {
                case "info":
                    railroad.info();
                    break;
                case "load":
                    railroad.load(Constants.PLUS_FILE_NAME);
                    System.out.println("The collection is loaded");
                    railroad.saveToFile(fileName);
                    break;
                case "exit":
                    railroad.saveToFile(fileName);
                    needExit = true;
                    break;
                case "remove":
                    try {
                        railroad.Remove(forAction);
                        railroad.saveToFile(fileName);
                    } catch (Exception e) {
                        System.out.println("Something is wrong");
                    }
                    break;
                case "add_if_min":
                    try {
                        boolean a = railroad.Add_if_min(forAction, Train.myCompare);
                        if (a) {
                            railroad.Add(forAction);
                            railroad.saveToFile(fileName);
                        } else System.out.println("Element is not the min");
                    } catch (Exception e) {
                        System.out.println("Something is wrong");
                    }
                    break;
                case "import":
                    railroad.doImport(fullCom[1]);
                    break;
                default:
                    System.out.println("Unfortunately, there is no such command");
                    break;
            }


        }
    }
}