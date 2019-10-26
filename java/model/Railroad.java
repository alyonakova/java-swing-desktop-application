package model;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * A collection of trains.
 */
public class Railroad {
    public LinkedHashSet<Train> trains;
    Date myDate = new Date();
    SimpleDateFormat sdf;
    String t;

    public Railroad() {
        trains = new LinkedHashSet<Train>();
        Calendar cal = Calendar.getInstance();
        sdf = new SimpleDateFormat("HH:mm:ss");
        t = sdf.format(cal.getTime());
    }

    /**
     * This method outputs to the standard output stream the information about collection (type, initialization time, count of elements)
     */
    public String info() {
        int size = trains.size();
        String typeCol = trains.getClass().getName();
        return "Type of collection - " + typeCol + "\n" + "Count of elements - " + size + "\n" + "Initialization time - " + t;
    }

    /**
     * This method removes an element of collection by it's value
     */
    public void Remove(Train tra) {
        boolean mybool = true;
        Scanner in = new Scanner(System.in);
        while (mybool) {
            if (tra.getColor() != null && tra.getCarriages() == null) {
                int count = 0;
                ArrayList<Train> mas = new ArrayList<Train>();
                for (Train tr : trains) {
                    if (tr.getColor() == tra.getColor()) {
                        mas.add(tr);
                        count++;
                        tra = tr;
                    }
                }   // ищем кол-во объектов, у которых введенное значение совпало
                if (count > 1) {
                    int b = 0;
                    System.out.println(mas.size() + " elements found");
                    for (Train o1 : mas) {
                        System.out.println(o1 + " (Number:" + b + ")");
                        b++;
                    }
                    System.out.println("Choose a number of element you want to delete");
                    int input = in.nextInt();
                    Train lc = mas.get(input);
                    boolean a = trains.remove(lc);
                    if (a) {
                        System.out.println("Element deleted");
                        mas.clear();
                        break;
                    }
                } else {
                    if (count == 1) {
                        boolean a = trains.remove(tra);
                        if (a) {
                            System.out.println("Element deleted");
                            break;
                        }
                    } else {
                        System.out.println("No such element in collection");
                        break;
                    }
                }
            }
            if (tra.getColor() == null && tra.getCarriages() != null) {
                int count = 0;
                int countcar;
                ArrayList<Train> mas = new ArrayList<Train>();
                for (Train tr : trains) {
                    countcar = 0;
                    if ((tr.getCarriages().length == tra.getCarriages().length)) {
                        for (int c = 0; c < tr.getCarriages().length; c++) {
                            if ((tra.getCarriages()[c].getType() != null) && (tra.getCarriages()[c].getBenches() == null) && (tr.getCarriages()[c].getType() == tra.getCarriages()[c].getType())) {
                                countcar++;
                            }
                            if ((tra.getCarriages()[c].getType() == null) && (tra.getCarriages()[c].getBenches() != null) && (tr.getCarriages()[c].getBenches().length == tra.getCarriages()[c].getBenches().length)) {
                                countcar++;
                            }
                            if ((tra.getCarriages()[c].getType() == null) && (tra.getCarriages()[c].getBenches() == null)) {
                                countcar++;
                            }
                            if ((tra.getCarriages()[c].getType() != null) && (tra.getCarriages()[c].getBenches() != null) && (tr.getCarriages()[c].getType() == tra.getCarriages()[c].getType()) && (tr.getCarriages()[c].getBenches().length == tra.getCarriages()[c].getBenches().length)) {
                                countcar++;
                            }
                        }
                        if (countcar == tr.getCarriages().length) {
                            mas.add(tr);
                            count++;
                            System.out.println(count);
                            tra = tr;
                        }
                    }
                }  // ищем кол-во объектов, у которых введенное значение совпало
                if (count > 1) {
                    int b = 0;
                    System.out.println(mas.size() + " elements found");
                    for (Train o1 : mas) {
                        System.out.println(o1 + " (Number:" + b + ")");
                        b++;
                    }
                    System.out.println("Choose a number of element you want to delete");
                    int input = in.nextInt();
                    Train lc = mas.get(input);
                    boolean a = trains.remove(lc);
                    if (a) {
                        System.out.println("Element deleted");
                        mas.clear();
                        break;
                    }
                }
                if (count == 1) {
                    boolean a = trains.remove(tra);
                    if (a) {
                        System.out.println("Element deleted");
                        break;
                    }
                } else if (count == 0) {
                    System.out.println("No such element in collection");
                    break;
                }
            }
            if (tra.getColor() != null && tra.getCarriages() != null) {
                int count = 0;
                int countcar;
                ArrayList<Train> mas = new ArrayList<Train>();
                for (Train tr : trains) {
                    countcar = 0;
                    if ((tr.getCarriages().length == tra.getCarriages().length) && (tr.getColor() == tra.getColor())) {
                        for (int c = 0; c < tr.getCarriages().length; c++) {
                            if ((tra.getCarriages()[c].getType() != null) && (tra.getCarriages()[c].getBenches() == null) && (tr.getCarriages()[c].getType() == tra.getCarriages()[c].getType())) {
                                countcar++;
                            }
                            if ((tra.getCarriages()[c].getType() == null) && (tra.getCarriages()[c].getBenches() != null) && (tr.getCarriages()[c].getBenches().length == tra.getCarriages()[c].getBenches().length)) {
                                countcar++;
                            }
                            if ((tra.getCarriages()[c].getType() == null) && (tra.getCarriages()[c].getBenches() == null)) {
                                countcar++;
                            }
                            if ((tra.getCarriages()[c].getType() != null) && (tra.getCarriages()[c].getBenches() != null) && (tr.getCarriages()[c].getType() == tra.getCarriages()[c].getType()) && (tr.getCarriages()[c].getBenches().length == tra.getCarriages()[c].getBenches().length)) {
                                countcar++;
                            }
                        }
                        if (countcar == tr.getCarriages().length) {
                            mas.add(tr);
                            count++;
                            System.out.println(count);
                            tra = tr;
                        }
                    }
                }
                if (count > 1) {
                    int b = 0;
                    System.out.println(mas.size() + " elements found");
                    for (Train o1 : mas) {
                        System.out.println(o1 + " (Number:" + b + ")");
                        b++;
                    }
                    System.out.println("Choose a number of element you want to delete");
                    int input = in.nextInt();
                    Train lc = mas.get(input);
                    boolean a = trains.remove(lc);
                    if (a) {
                        System.out.println("Element deleted");
                        mas.clear();
                        break;
                    }
                } else {
                    if (count == 1) {
                        boolean a = trains.remove(tra);
                        if (a) {
                            System.out.println("Element deleted");
                            break;
                        }
                    } else {
                        System.out.println("No such element in collection");
                        break;
                    }
                }
            }
            if (tra.getColor() == null && tra.getCarriages() == null) {
                System.out.println("Please add color or carriages to delete an element");
                mybool = false;
            }
        }
    }

    /**
     * This method adds a new element to collection, if it's value less than the least element has
     *
     * @param lc        - element, which will be added, if it's value less than the least element has
     * @param myCompare - comparator, for comparison elements
     * @return returns true or false, depends on value of an element
     */
    public boolean Add_if_min(Train lc, Comparator<Train> myCompare) {
        boolean max = false;
        if (trains.size() == 0) {
            max = true;
        } else {
            Train lc1 = Collections.min(trains, myCompare);
            if (myCompare.compare(lc1, lc) > 0) {
                max = true;
            }
        }
        return max;
    }

    /**
     * Using this method, you can read the collection from a file
     *
     * @param fileName - the name of file with collection
     */
    public void load(String fileName) {
        trains.clear();
        try {
            String JsonString = readJsonFromFile(fileName);
            if (!(jsonToTrainLHS(JsonString).isEmpty())) {
                trains.addAll(jsonToTrainLHS(JsonString));
            } else
                System.out.println("Nothing is added, the imported collection may be empty, or the items are set incorrectly");
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SecurityException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Unexpected input error. ");
        } catch (JsonSyntaxException ex) {
            System.out.println("The contents of the file are in the wrong format");
        }
    }


    /**
     * This method writes the collection to a file
     *
     * @param fileName - The name of the file in which the collection will be saved
     */
    public void saveToFile(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Can't create file: " + fileName);
            }
        }
        Writer fileWriter = null;
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            fileWriter = new OutputStreamWriter(bos);

            String trainsInJson = new Gson().toJson(trains);
            System.out.println("Json: " + trainsInJson);
            fileWriter.write(trainsInJson);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }


    public LinkedHashSet<Train> jsonToTrainLHS(String jsonTrainLHS) throws JsonSyntaxException {
        try {
            Gson gson = new Gson();
            LinkedHashSet<Train> trainLHS = new LinkedHashSet<Train>();
            if (jsonTrainLHS.length() != 0) {
                Train[] trainArray = gson.fromJson(jsonTrainLHS, Train[].class);
                for (Train i : trainArray) {
                    if (i == null) {
                        i = new Train(3, Color.RED);
                        System.out.println("Train filled by default");
                    }
                    if (i.getColor() == null) {
                        i.setColor(Color.RED);
                        System.out.println("Color added by default: " + i.getColor());
                    }
                    if (i.getCarriages() == null) {
                        i = new Train(3, i.getColor());
                        System.out.println("3 carriages with 3 benches added by default");
                    }
                    for (int a = 0; a < i.getCarriages().length; a++) {
                        if ((i.getCarriages()[a].getBenches() == null) || (i.getCarriages()[a] == null)) {
                            i.getCarriages()[a] = new Carriage(3);
                            System.out.println("3 benches added to the carriage by default");
                        }
                        if (i.getCarriages()[a].getType() == null) {
                            i.getCarriages()[a].setType(CarriageType.USUAL);
                            System.out.println("Type added by default: " + i.getCarriages()[a].getType());
                        }
                        for (int b = 0; b < i.getCarriages()[a].getBenches().length; b++) {
                            if (i.getCarriages()[a].getBenches()[b] == null) {
                                i.getCarriages()[a].getBenches()[b] = new Bench();
                                System.out.println("Benches added by default");
                            }
                        }

                    }
                    trainLHS.add(i);
                }
            }
            return trainLHS;
        } catch (JsonSyntaxException ex) {
            throw new JsonSyntaxException("Json syntax exception");
        }
    }


    public String readJsonFromFile(String fileName) throws IOException {
        try (
                FileInputStream fileInpStream = new FileInputStream(fileName);
                BufferedInputStream buffInpStream = new BufferedInputStream(fileInpStream);
        ) {
            LinkedList<Byte> collectionBytesList = new LinkedList<>();
            while (buffInpStream.available() > 0) {
                collectionBytesList.add((byte) buffInpStream.read());
            }
            char[] collectionChars = new char[collectionBytesList.size()];
            for (int i = 0; i < collectionChars.length; i++) {
                collectionChars[i] = (char) (byte) collectionBytesList.get(i);
            }
            return new String(collectionChars);
        } catch (IOException ioe) {
            throw new IOException("Can not read from file / invalid file name");
        }
    }

    /**
     * This method adds elements to collection from the file
     *
     * @param fileName - the name of file with collection
     */

    public void doImport(String fileName) {
        try {
            String JsonString = readJsonFromFile(fileName);
            if (!(jsonToTrainLHS(JsonString).isEmpty())) {
                trains.addAll(jsonToTrainLHS(JsonString));
                System.out.println("The elements from the file is added to the collection");
            } else
                System.out.println("Nothing is added, the imported collection may be empty, or the items are set incorrectly");
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println(ex.getMessage());
        } catch (SecurityException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, " Unexpected input error. " + ex);
            System.out.println("Unexpected input error. " + ex);
        } catch (JsonSyntaxException ex) {
            JOptionPane.showMessageDialog(null, "The contents of the file are in the wrong format");
            System.out.println("The contents of the file are in the wrong format");
        }
    }

    public void Add(Train tr1) {
        boolean myB = trains.contains(tr1);
        if (!myB) {
            trains.add(tr1);
            System.out.println("New element added");
        } else System.out.println("Element already exists");
    }

}
