package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class RateAppScreen extends JFrame {
    private JFrame jfrm = null;
    private GroupLayout layout = null;
    private JLabel jlab1 = null;
    private JLabel jlab2 = null;
    private JLabel jlab3 = null;
    private JButton jbut1 = null;
    private JButton jbut2 = null;
    private JButton jbut3 = null;
    private JTextPane jtp1 = null;
    private JTextPane jtp2 = null;
    private JComboBox jcmbx = null;
    private JPanel longpan = null;
    private JPanel shortpan = null;
    private ArrayList<String> mess = null;
    private JScrollPane jscroll1 = null;
    private JScrollPane jscroll2 = null;

    RateAppScreen() {
        jfrm = new JFrame("Rate app");
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(800, 600);
        PicturePanel picPan = new PicturePanel();
        picPan.setLayout(new BorderLayout());
        try {
            picPan.setImage(ImageIO.read(getClass().getResource("/gui/others.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        jlab1 = new JLabel("Rate this app");
        Font myFont1 = new Font("Segoe UI", Font.PLAIN, 24);
        Font myFont2 = new Font("Segoe UI", Font.PLAIN, 16);
        jlab2 = new JLabel("Select a comment");
        jlab3 = new JLabel("Selected comment");
        jlab1.setFont(myFont1);
        jlab2.setFont(myFont2);
        jlab3.setFont(myFont2);
        jlab1.setForeground(new Color(255, 102, 0));
        jlab2.setForeground(Color.BLACK);
        jlab3.setForeground(Color.BLACK);
        jbut1 = new JButton("Delete a comment");
        jbut2 = new JButton("Add a comment");
        jbut3 = new JButton("Back to menu");
        jbut1.setFont(myFont2);
        jbut2.setFont(myFont2);
        jbut3.setFont(myFont2);
        jbut1.setForeground(Color.WHITE);
        jbut2.setForeground(Color.WHITE);
        jbut3.setForeground(Color.WHITE);
        jbut1.setBackground(new Color(255, 153, 0));
        jbut2.setBackground(new Color(255, 153, 0));
        jbut3.setBackground(new Color(255, 153, 0));
        jbut1.setPreferredSize(new Dimension(242, 28));
        jbut1.setMinimumSize(new Dimension(242, 28));
        jbut2.setPreferredSize(new Dimension(242, 28));
        jbut2.setMinimumSize(new Dimension(242, 28));
        jbut3.setPreferredSize(new Dimension(242, 28));
        jbut3.setMinimumSize(new Dimension(242, 28));
        jtp1 = new JTextPane();
        jtp2 = new JTextPane();
        jtp1.setPreferredSize(new Dimension(240, 84));
        jtp1.setMinimumSize(new Dimension(240, 84));
        jtp2.setPreferredSize(new Dimension(240, 86));
        jtp2.setMinimumSize(new Dimension(240, 86));
        jtp1.setBackground(Color.WHITE);
        jtp2.setBackground(Color.WHITE);
        jtp1.setForeground(Color.BLACK);
        jtp2.setForeground(Color.BLACK);
        jtp1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        jtp2.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        jscroll1 = new JScrollPane(jtp1);
        jscroll2 = new JScrollPane(jtp2);
        jscroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jscroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        // записываем в arrayist отзывы из файла
        mess = new ArrayList<>();
        try {
            FileReader file = new FileReader(new File("items.txt"));
            BufferedReader reader = new BufferedReader(file);
            String line = reader.readLine();
            while (line != null) {
                mess.add(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //заполнение выпадающего списка
        jcmbx = new JComboBox();
        for (int w = 0; w < mess.size(); w++) {
            jcmbx.addItem("Comment" + (w + 1));
        }
        jcmbx.setPreferredSize(new Dimension(240, 24));
        jcmbx.setMinimumSize(new Dimension(240, 24));
        ///////////////////////////////
        JPanel jpan = new JPanel();
        jpan.setLayout(new GridLayout(1, 1));
        jpan.setOpaque(false);
        longpan = new JPanel();
        shortpan = new JPanel();
        longpan.setLayout(new FlowLayout());
        longpan.setOpaque(false);
        jpan.add(longpan);
        shortpan.setOpaque(false);
        layout = new GroupLayout(shortpan);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(
                        GroupLayout.Alignment.CENTER)
                        .addComponent(jlab1)
                        .addGap(30)
                        .addComponent(jlab2)
                        .addGap(8)
                        .addComponent(jcmbx)
                        .addGap(20)
                        .addComponent(jbut1)
                        .addGap(45)
                        .addComponent(jlab3)
                        .addComponent(jscroll1)
                        .addGap(28)
                        .addComponent(jscroll2)
                        .addGap(0)
                        .addComponent(jbut2)
                        .addGap(30)
                        .addComponent(jbut3))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(jlab1)
                .addGap(30)
                .addComponent(jlab2)
                .addGap(8)
                .addComponent(jcmbx)
                .addGap(20)
                .addComponent(jbut1)
                .addGap(45)
                .addComponent(jlab3)
                .addComponent(jscroll1)
                .addGap(28)
                .addComponent(jscroll2)
                .addGap(0)
                .addComponent(jbut2)
                .addGap(30)
                .addComponent(jbut3));
        shortpan.setLayout(layout);
        longpan.add(shortpan);
        picPan.add(jpan, BorderLayout.CENTER);
        picPan.setPreferredSize(new Dimension(10000, 10000));
        jfrm.add(picPan);
        jfrm.pack();
        jfrm.setSize(800, 600);
        jfrm.setMaximumSize(new Dimension(800, 600));
        jfrm.setMinimumSize(new Dimension(350, 575));
        jfrm.setVisible(true);
        jbut3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuScreen men = new MenuScreen();
                jfrm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                jfrm.dispose();
            }
        });
        jcmbx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mess.size() > 0) {
                    try {
                        jtp1.setText(mess.get(jcmbx.getSelectedIndex()));
                    } catch (Exception ex) {
                        jtp1.setText("");
                    }
                }
            }
        });
        jbut1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //////////////////////////////////////////////////////////////////////////////
                if (jcmbx.getItemCount() == 0) {
                    JOptionPane.showMessageDialog(jfrm, "There's no comments yet");
                } else if (mess.size() == 1) {
                    mess.remove(jcmbx.getSelectedIndex());
                    jcmbx.removeAllItems();
                    jtp1.setText("");
                    JOptionPane.showMessageDialog(jfrm, "The comment deleted");


                    try (PrintWriter pw = new PrintWriter("items.txt")) {
                        if (!mess.isEmpty()) {
                            pw.println(mess.get(0));
                            for (int i = 1; i < mess.size(); i++) {
                                //       pw.append("\n");
                                pw.println(mess.get(i));
                            }
                            pw.close();
                        } else {
                            jtp1.setText("");
                        }
                    } catch (FileNotFoundException q) {
                        System.err.println(q.getMessage());
                    }
                } else {

                    mess.remove(jcmbx.getSelectedIndex());
                    jcmbx.removeAllItems();
                    jtp1.setText("");
                    if (!mess.isEmpty()) {
                        for (int i = 0; i < mess.size(); i++) {
                            jcmbx.addItem("Comment" + (i + 1));
                        }
                        JOptionPane.showMessageDialog(jfrm, "The comment deleted");
                    }

                    //    jcmbx.removeItemAt(jcmbx.getSelectedIndex());


                    try (PrintWriter pw = new PrintWriter("items.txt")) {
                        if (!mess.isEmpty()) {
                            pw.println(mess.get(0));
                            for (int i = 1; i < mess.size(); i++) {
                                //       pw.append("\n");
                                pw.println(mess.get(i));
                            }
                            pw.close();
                        } else {
                            jtp1.setText("");
                        }
                    } catch (FileNotFoundException q) {
                        System.err.println(q.getMessage());
                    }
                }
            }

        });

        jbut2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(jtp2.getText().isEmpty())) {
                    mess.add(jtp2.getText().replace("\n", " ").replace("\r", " "));
                    jcmbx.addItem("Comment" + mess.size());
                    JOptionPane.showMessageDialog(jfrm, "The comment added");
                    try (PrintWriter pw = new PrintWriter("items.txt")) {
                        if (!mess.isEmpty()) {
                            pw.println(mess.get(0));
                            for (int i = 1; i < mess.size(); i++) {
                                //    pw.append("\n");
                                pw.println(mess.get(i));
                            }
                            pw.close();
                        } else {
                            jtp1.setText("");
                        }
                    } catch (FileNotFoundException q) {
                        System.err.println(q.getMessage());
                    }
                    jtp2.setText("");
                } else {
                    JOptionPane.showMessageDialog(jfrm, "Enter the comment");
                }
            }
        });
    }
}
