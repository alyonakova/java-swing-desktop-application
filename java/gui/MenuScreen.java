package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MenuScreen extends JFrame {
    private JButton jbut1 = null;
    private JButton jbut2 = null;
    private JLabel jlab = null;
    private GroupLayout layout = null;
    private JLabel prost = null;
    private JPanel longpan = null;
    private JPanel shortpan = null;
    private JFrame jfrm = null;

    public MenuScreen() {

        jfrm = new JFrame("Home");
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(800, 600);
        Font myFont = new Font("Segoe UI", Font.PLAIN, 22);
        Font myFont2 = new Font("Segoe UI", Font.PLAIN, 50);
        PicturePanel picPan = new PicturePanel();
        picPan.setLayout(new BorderLayout());
        try {
            picPan.setImage(ImageIO.read(getClass().getResource("/gui/menu.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        jlab = new JLabel("Menu", JLabel.CENTER);
        prost = new JLabel("", JLabel.CENTER);
        jlab.setFont(myFont2);
        jlab.setForeground(new Color(255, 153, 0));
        prost.setSize(300, 100);
        jbut1 = new JButton("Go to the commands");
        jbut2 = new JButton("Rate app");
        jbut1.setBackground(new Color(51, 153, 51));
        jbut2.setBackground(new Color(51, 153, 51));
        jbut1.setForeground(Color.WHITE);
        jbut2.setForeground(Color.WHITE);
        jbut1.setFont(myFont);
        jbut2.setFont(myFont);
        jbut1.setPreferredSize(new Dimension(274, 68));
        jbut2.setPreferredSize(new Dimension(274, 68));
        jbut1.setMinimumSize(new Dimension(274, 68));
        jbut2.setMinimumSize(new Dimension(274, 68));
        longpan = new JPanel();
        shortpan = new JPanel();
        JPanel jpan = new JPanel();
        jpan.setLayout(new GridLayout(3, 1));
        jpan.setOpaque(false);
        longpan.setLayout(new FlowLayout());
        longpan.setOpaque(false);
        jpan.add(jlab);
        jpan.add(longpan);
        jpan.add(prost);
        shortpan.setSize(300, 300);
        shortpan.setOpaque(false);
        layout = new GroupLayout(shortpan);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(
                        GroupLayout.Alignment.CENTER)
                        .addGap(5)
                        .addComponent(jbut1)
                        .addGap(30)
                        .addComponent(jbut2))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGap(5)
                .addComponent(jbut1)
                .addGap(30)
                .addComponent(jbut2));


        shortpan.setLayout(layout);
        longpan.add(shortpan);
        picPan.add(jpan, BorderLayout.CENTER);
        picPan.setPreferredSize(new Dimension(10000, 10000));
        jfrm.add(picPan);
        jfrm.pack();
        jfrm.setSize(800, 600);
        jfrm.setMinimumSize(new Dimension(350, 550));
        jfrm.setVisible(true);

        jbut1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CommandScreen com = new CommandScreen();
                jfrm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                jfrm.dispose();
            }
        });
        jbut2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RateAppScreen rta = new RateAppScreen();
                jfrm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                jfrm.dispose();
            }
        });
    }

}

