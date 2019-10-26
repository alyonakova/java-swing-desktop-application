package gui;

import model.Railroad;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class InfoScreen extends JFrame {
    private JLabel jlab = null;
    private JButton jbut = null;
    private JTextPane jtp = null;
    private GroupLayout layout = null;
    private JPanel longpan = null;
    private JPanel longpan2 = null;
    private JPanel shortpan = null;
    private JPanel shortpan2 = null;
    private GroupLayout layout2 = null;

    InfoScreen() {
        JFrame jfrm = new JFrame("Info");
        Font myFont = new Font("Segoe UI", Font.PLAIN, 28);
        Font myFont1 = new Font("Segoe UI", Font.PLAIN, 16);
        Font myFont2 = new Font("Segoe UI", Font.ITALIC, 18);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(800, 600);
        PicturePanel picPan = new PicturePanel();
        picPan.setLayout(new BorderLayout());
        try {
            picPan.setImage(ImageIO.read(getClass().getResource("/gui/others.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JPanel jpan = new JPanel();
        longpan = new JPanel();
        longpan2 = new JPanel();
        shortpan = new JPanel();
        shortpan2 = new JPanel();
        layout = new GroupLayout(jpan);
        layout2 = new GroupLayout(jpan);
        jpan.setLayout(new GridLayout(3, 1));
        longpan.setLayout(new FlowLayout());
        longpan.setOpaque(false);
        longpan2.setLayout(new FlowLayout());
        longpan2.setOpaque(false);
        shortpan.setSize(355, 156);
        shortpan.setOpaque(false);
        shortpan2.setSize(100, 100);
        shortpan2.setOpaque(false);
        layout = new GroupLayout(shortpan);
        layout2 = new GroupLayout(shortpan2);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout2.setAutoCreateGaps(true);
        layout2.setAutoCreateContainerGaps(true);
        jlab = new JLabel("Information about train", JLabel.CENTER);
        jlab.setFont(myFont);
        jlab.setForeground(new Color(255, 102, 0));
        jbut = new JButton("Back to commands");
        jbut.setFont(myFont1);
        jpan.setOpaque(false);
        jbut.setBackground(new Color(255, 153, 0));
        jbut.setForeground(Color.WHITE);
        jbut.setPreferredSize(new Dimension(159, 28));
        jbut.setMinimumSize(new Dimension(159, 28));
        jtp = new JTextPane();
        jtp.setPreferredSize(new Dimension(355, 156));
        jtp.setMinimumSize(new Dimension(355, 156));
        jtp.setBackground(new Color(255, 153, 0));
        jtp.setFont(myFont2);
        jtp.setForeground(new Color(0, 0, 102));
        Railroad railroad = new Railroad();
        railroad.doImport(Constants.TRAIN_FILE_NAME);
        jtp.setText(railroad.info());
        jpan.add(jlab);
        jpan.add(longpan);
        jpan.add(longpan2);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(
                        GroupLayout.Alignment.CENTER)
                        .addComponent(jtp)
                )
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(jtp)
        );

        layout2.setHorizontalGroup(layout2.createSequentialGroup()
                .addGroup(layout2.createParallelGroup(
                        GroupLayout.Alignment.CENTER)
                        .addGap(60)
                        .addComponent(jbut)
                )
        );
        layout2.setVerticalGroup(layout2.createSequentialGroup()
                .addGap(60)
                .addComponent(jbut)
        );

        shortpan.setLayout(layout);
        shortpan2.setLayout(layout2);
        longpan.add(shortpan);
        longpan2.add(shortpan2);
        picPan.add(jpan, BorderLayout.CENTER);
        picPan.setPreferredSize(new Dimension(10000, 10000));
        jfrm.add(picPan);
        jfrm.pack();
        jfrm.setSize(800, 600);
        jfrm.setMinimumSize(new Dimension(380, 520));
        jfrm.setVisible(true);

        jbut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CommandScreen com = new CommandScreen();
                jfrm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                jfrm.dispose();
            }
        });
    }
}
