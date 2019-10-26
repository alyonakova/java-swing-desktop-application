package gui;

import model.Railroad;
import model.Train;
import util.JButtonBuilder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class SortScreen extends JFrame {
    private JFrame jfrm = new JFrame();
    private JLabel jlab = null;
    private JButton jbtByCarriages = null;
    private JButton jbtByColor = null;
    private GroupLayout layout = null;
    private Railroad railroad = null;

    SortScreen() {
        jfrm = new JFrame("Sort");
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(800, 600);
        PicturePanel picPan = new PicturePanel();
        picPan.setLayout(new BorderLayout());
        try {
            picPan.setImage(ImageIO.read(getClass().getResource("/gui/others.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        jlab = new JLabel("Select the sort type", JLabel.CENTER);
        jlab.setFont(new Font("Segoe UI", Font.PLAIN, 28));
        jlab.setForeground(new Color(255, 102, 0));

        jbtByCarriages = new JButtonBuilder("By number of carriages").build();
        jbtByColor = new JButtonBuilder("By color").build();

        JPanel jpan = new JPanel();
        jpan.setOpaque(false);
        layout = new GroupLayout(jpan);
        jpan.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(118, 118, 118)
                                                .addComponent(jbtByCarriages, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                                //   .addGap(36, 36, 36)
                                                .addGap(140)
                                                .addComponent(jbtByColor, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(275, 275, 275)
                                                .addComponent(jlab)))
                                .addContainerGap(150, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[]{jbtByColor, jbtByCarriages});

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(jlab)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                                .addGap(90)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jbtByColor, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jbtByCarriages, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(279, 279, 279))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[]{jbtByColor, jbtByCarriages});

        pack();


        picPan.add(jpan, BorderLayout.CENTER);
        picPan.setPreferredSize(new Dimension(10000, 10000));
        jfrm.add(picPan);
        jfrm.pack();
        jfrm.setSize(800, 600);
        jfrm.setMinimumSize(new Dimension(350, 550));
        jfrm.setVisible(true);
        railroad = new Railroad();
        railroad.doImport(Constants.TRAIN_FILE_NAME);

        jbtByCarriages.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Train> artr = new ArrayList<>();
                for (Train t : railroad.trains) {
                    artr.add(t);
                }
                Collections.sort(artr, Train.myCompare);
                railroad.trains.clear();
                for (int i = 0; i < artr.size(); i++) {
                    railroad.trains.add(artr.get(i));
                }
                railroad.saveToFile(Constants.TRAIN_FILE_NAME);
                JOptionPane.showMessageDialog(getContentPane(), "Sorted");

                CommandScreen com = new CommandScreen();
                jfrm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                jfrm.dispose();
            }
        });

        jbtByColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                railroad.trains = railroad.trains.stream()
                        .sorted(Comparator.comparingInt(x -> x.getColor().getRGB()))
                        .collect(Collectors.toCollection(LinkedHashSet::new));
                railroad.saveToFile(Constants.TRAIN_FILE_NAME);
                CommandScreen com = new CommandScreen();
                jfrm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                jfrm.dispose();
            }
        });
    }

    public static int difCol(Train[] trains) {
        ArrayList<Color> mySet = new ArrayList<>();
        mySet.add(trains[0].getColor());
        int chetc;
        for (int i = 1; i < trains.length; i++) {
            chetc = 0;
            for (int j = 0; j < mySet.size(); j++) {
                if (trains[i].getColor() != mySet.get(j)) {
                    chetc++;
                }
            }
            if (chetc == mySet.size()) {
                mySet.add(trains[i].getColor());
                chetc = 0;
            } else {
                chetc = 0;
            }
        }
        return mySet.size();
    }

    public static void ColorSort(Train[] trains) {
        int posled = 0;
        int kol = difCol(trains);
        Train prom = null;
        //   System.out.println(kol);
        for (int k = 0; k < kol; k++) {
            for (int m = posled + 1; m < trains.length; m++) {
                if (trains[posled].getColor() == trains[m].getColor()) {
                    prom = trains[m];
                    trains[m] = trains[posled + 1];
                    trains[posled + 1] = prom;
                    posled++;
                }
            }
            if ((trains.length - (posled + 1)) == (kol - (k + 1))) {
                break;
            }
            posled = posled + 1;
        }
    }
}
