package gui;

import model.Railroad;
import model.Train;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Iterator;

public class FilterScreen extends JFrame {
    public JFrame jfrm = null;
    private JButton jbt1 = null;
    private JButton jbt2 = null;
    private JLabel jlab1 = null;
    private JLabel jlab2 = null;
    private JLabel jlab3 = null;
    private JLabel jlab4 = null;
    private JLabel jlab5 = null;
    private JPanel jpan = null;
    private JTextPane jtp1 = null;
    private JComboBox jtp2 = null;
    private JButton jbt3 = null;
    private JPanel jpancol = null;
    private JList jlist = null;
    private JPanel jpanlow = null;
    private Railroad railroad = null;
    private int indexList;


    FilterScreen() {
        indexList = 10;
        jfrm = new JFrame("Filtr");
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(800, 600);
        PicturePanel picPan = new PicturePanel();
        picPan.setLayout(new BorderLayout());
        try {
            picPan.setImage(ImageIO.read(getClass().getResource("/gui/others.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        jpan = new JPanel();
        jpan.setLayout(new GridLayout());
        jpan.setOpaque(false);


        jbt1 = new JButton("OK");
        jbt1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        jbt1.setBackground(new Color(255, 153, 0));
        jbt1.setForeground(Color.WHITE);
        jbt1.setPreferredSize(new Dimension(121, 38));
        jbt1.setMinimumSize(new Dimension(121, 38));
        jbt1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbt1.setBorder(null);
        jbt1.setBorderPainted(false);
        // jbt1.setEnabled(false);

        jbt2 = new JButton("Back to commands");
        jbt2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jbt2.setBackground(new Color(255, 153, 0));
        jbt2.setForeground(Color.WHITE);
        jbt2.setPreferredSize(new Dimension(126, 38));
        jbt1.setMinimumSize(new Dimension(126, 38));
        jbt2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbt2.setBorder(null);
        jbt2.setBorderPainted(false);

        jlab1 = new JLabel("Choose a field");
        jlab1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jlab1.setForeground(Color.BLACK);

        jlab2 = new JLabel("Enter a value");
        jlab2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jlab2.setForeground(Color.BLACK);

        jlab3 = new JLabel("Number");
        jlab3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        jlab3.setForeground(Color.BLACK);

        jlab4 = new JLabel("Type");
        jlab4.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        jlab4.setForeground(Color.BLACK);

        jlab5 = new JLabel("Color");
        jlab5.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        jlab5.setForeground(Color.BLACK);

        jpanlow = new JPanel();
        jpanlow.setBackground(new Color(255, 153, 0));
        jpanlow.setPreferredSize(new Dimension(336, 162));
        jpan.setMinimumSize(new Dimension(336, 162));

        jtp1 = new JTextPane();
        jtp1.setPreferredSize(new Dimension(160, 32));
        jtp1.setMinimumSize(new Dimension(160, 32));
        jtp1.setEnabled(false);


        jtp2 = new JComboBox();
        jtp2.addItem("FORDRIVERS");
        jtp2.addItem("RESTAURANT");
        jtp2.addItem("USUAL");
        jtp2.setPreferredSize(new Dimension(160, 32));
        jtp2.setMinimumSize(new Dimension(160, 32));
        jtp2.setEnabled(false);


        jbt3 = new JButton("Choose color");
        jbt3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        jbt3.setBackground(Color.WHITE);
        jbt3.setForeground(Color.BLACK);
        jbt3.setPreferredSize(new Dimension(106, 28));
        jbt1.setMinimumSize(new Dimension(106, 28));
        jbt3.setEnabled(false);


        String[] elements = {"Number of carriages", "Color", "Number of benches", "Type of carriage"};
        jlist = new JList(elements);
        jlist.setPreferredSize(new Dimension(336, 162));
        jlist.setMinimumSize(new Dimension(336, 162));
        jlist.setFont(new Font("Segoe UI", Font.PLAIN, 16));


        jpancol = new JPanel();
        jpancol.setPreferredSize(new Dimension(26, 28));
        jpancol.setMinimumSize(new Dimension(24, 25));
        jpancol.setEnabled(false);
        jpancol.setVisible(false);

        railroad = new Railroad();
        railroad.doImport(Constants.TRAIN_FILE_NAME);


        GroupLayout panel_colorLayout = new GroupLayout(jpancol);
        jpancol.setLayout(panel_colorLayout);
        panel_colorLayout.setHorizontalGroup(
                panel_colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 31, Short.MAX_VALUE)
        );
        panel_colorLayout.setVerticalGroup(
                panel_colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 20, Short.MAX_VALUE)
        );


        GroupLayout jPanel1Layout = new GroupLayout(jpanlow);
        jpanlow.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jlab3)
                                                .addGap(28, 28, 28)
                                                .addComponent(jtp1))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jlab4)
                                                        .addComponent(jlab5))
                                                .addGap(45, 45, 45)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jpancol, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jbt3, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
                                                        .addComponent(jtp2)))
                                        .addComponent(jlab2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jlab2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlab3)
                                        .addComponent(jtp1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlab4)
                                        .addComponent(jtp2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(jlab5)
                                                .addComponent(jpancol, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jbt3))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(SwingConstants.VERTICAL, new java.awt.Component[]{jpancol, jtp2});

        GroupLayout layout = new GroupLayout(jpan);
        jpan.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(202, 202, 202)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jpanlow, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jlist)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(320, 320, 320)
                                                .addComponent(jlab1)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(167, 167, 167)
                                .addComponent(jbt1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
                                .addComponent(jbt2, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
                                .addGap(184, 184, 184))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jlab1)
                                .addGap(18, 18, 18)
                                .addComponent(jlist, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jpanlow, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jbt1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jbt2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                .addGap(80, 80, 80))
        );


        picPan.add(jpan, BorderLayout.NORTH);
        picPan.setPreferredSize(new Dimension(10000, 10000));


        jfrm.add(picPan);
        jfrm.pack();
        jfrm.setSize(800, 600);
        jfrm.setVisible(true);

        jbt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color c = JColorChooser.showDialog(null, "Choose color", jpancol.getBackground());
                if (c != null)
                    jpancol.setVisible(true);
                jpancol.setBackground(c);
            }
        });
        jbt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CommandScreen com = new CommandScreen();
                jfrm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                jfrm.dispose();
            }
        });


        jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jlist.addListSelectionListener(new listSelectionListener());

        jbt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Iterator<Train> iter = railroad.trains.iterator();
                if (indexList == 0) {
                    try {
                        if (jtp1.getText() == "") {
                            JOptionPane.showMessageDialog(jfrm, "Enter the value");
                        } else if ((Integer.parseInt(jtp1.getText()) < 1) || (Integer.parseInt(jtp1.getText()) > 10)) {
                            JOptionPane.showMessageDialog(jfrm, "The length of the train mustn't be less than 1 and more than 10");
                            jtp1.setText("");
                        } else {
                            int zn = Integer.parseInt(jtp1.getText());
                            while (iter.hasNext()) {
                                Train tr = iter.next();
                                if (tr.getCarriages().length != zn) {
                                    iter.remove();
                                    railroad.saveToFile(Constants.TRAIN_FILE_NAME);
                                }
                            }
                            JOptionPane.showMessageDialog(jfrm, "The operation complited successfully");
                            jtp1.setText("");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(jfrm, "Please, enter the number");
                        jtp1.setText("");
                    }
                } else if (indexList == 1) {
                    if (!jpancol.isVisible()) {
                        JOptionPane.showMessageDialog(jfrm, "Please, choose the color");
                    } else {
                        while (iter.hasNext()) {
                            Train tra = iter.next();
                            if (!tra.getColor().equals(jpancol.getBackground())) {
                                System.out.println(tra.getColor());
                                System.out.println(jpancol.getBackground());
                                iter.remove();
                                railroad.saveToFile(Constants.TRAIN_FILE_NAME);
                            }
                        }
                        JOptionPane.showMessageDialog(jfrm, "The operation complited successfully");
                    }
                } else if (indexList == 2) {
                    try {
                        if (jtp1.getText() == "") {
                            JOptionPane.showMessageDialog(jfrm, "Enter the value");
                        } else if ((Integer.parseInt(jtp1.getText()) < 1)) {
                            JOptionPane.showMessageDialog(jfrm, "Number of benches can't be less than 1");
                            jtp1.setText("");
                        } else {
                            int znc = Integer.parseInt(jtp1.getText());
                            int countBen = 0;
                            while (iter.hasNext()) {
                                Train tr = iter.next();
                                for (int i = 0; i < tr.getCarriages().length; i++) {
                                    if (tr.getCarriages()[i].getBenches().length == znc) {
                                        countBen++;
                                    }
                                }
                                if (countBen == 0) {
                                    iter.remove();
                                    railroad.saveToFile(Constants.TRAIN_FILE_NAME);
                                }
                                countBen = 0;
                            }
                            JOptionPane.showMessageDialog(jfrm, "The operation complited successfully");
                        }
                        jtp1.setText("");

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(jfrm, "Please, enter the number");
                    }
                } else if (indexList == 3) {
                    int countBenc = 0;
                    while (iter.hasNext()) {
                        Train trn = iter.next();
                        for (int i = 0; i < trn.getCarriages().length; i++) {
                            if (String.valueOf(trn.getCarriages()[i].getType()).equals(jtp2.getSelectedItem())) {
                                countBenc++;
                            }
                        }
                        if (countBenc == 0) {
                            iter.remove();
                            railroad.saveToFile(Constants.TRAIN_FILE_NAME);
                        }
                        countBenc = 0;

                    }
                    JOptionPane.showMessageDialog(jfrm, "The operation complited successfully");

                }
            }

        });
    }

    class listSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            // Выделенная строка
            int selected = ((JList<?>) e.getSource()).
                    getSelectedIndex();
            //    System.out.println(selected);
            if (selected == 0) {
                jtp1.setEnabled(true);
                jtp2.setEnabled(false);
                jbt3.setEnabled(false);
                jpancol.setEnabled(false);
                jpancol.setBackground(null);
                indexList = selected;
                jpancol.setVisible(false);
            } else if (selected == 1) {
                jbt3.setEnabled(true);
                jpancol.setEnabled(true);
                jtp1.setEnabled(false);
                jtp2.setEnabled(false);
                indexList = selected;
                jpancol.setVisible(false);
            } else if (selected == 2) {
                jtp1.setEnabled(true);
                jtp2.setEnabled(false);
                jbt3.setEnabled(false);
                jpancol.setEnabled(false);
                jpancol.setBackground(null);
                indexList = selected;
                jpancol.setVisible(false);
            } else if (selected == 3) {
                jtp2.setEnabled(true);
                jtp1.setEnabled(false);
                jbt3.setEnabled(false);
                jpancol.setEnabled(false);
                jpancol.setBackground(null);
                indexList = selected;
                jpancol.setVisible(false);
            }

        }
    }

}
