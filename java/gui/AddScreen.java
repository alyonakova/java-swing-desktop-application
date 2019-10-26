package gui;

import model.Carriage;
import model.Railroad;
import model.Train;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AddScreen extends JFrame {

    private JButton btn_add;
    private JButton btn_add_if_min;
    private JButton btn_back;
    private JButton btn_carriages;
    private JButton btn_color;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JSpinner jSpinner1;
    private JSpinner jSpinner2;
    private JTextField jTextField1;
    private JPanel panel_color;
    private Railroad railroad = null;
    private JButton jbtnext = null;
    private int[] carben = null;

    public AddScreen() {
        try {
            final Image backgroundImage = ImageIO.read(getClass().getResource("/gui/others.jpg"));
            setContentPane(new JPanel(new BorderLayout()) {
                @Override
                public void paintComponent(Graphics g) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {

        btn_color = new JButton();
        btn_add = new JButton();
        btn_add_if_min = new JButton();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jSpinner1 = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        jLabel3 = new JLabel();
        jSpinner2 = new JSpinner(new SpinnerNumberModel(1, 1, (int) jSpinner1.getValue(), 1));
        jLabel4 = new JLabel();
        panel_color = new JPanel();
        btn_carriages = new JButton();
        jLabel5 = new JLabel();
        jTextField1 = new JTextField();
        btn_back = new JButton();
        jbtnext = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add");

        btn_color.setBackground(new java.awt.Color(255, 153, 0));
        btn_color.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_color.setForeground(new java.awt.Color(255, 255, 255));
        btn_color.setText("Choose color");
        btn_color.setBorder(null);
        btn_color.setBorderPainted(false);
        btn_color.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_color.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_colorActionPerformed(evt);
            }
        });

        btn_add.setBackground(new java.awt.Color(255, 153, 0));
        btn_add.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_add.setForeground(new java.awt.Color(255, 255, 255));
        btn_add.setText("Add");
        btn_add.setBorder(null);
        btn_add.setBorderPainted(false);
        btn_add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btn_add_if_min.setBackground(new java.awt.Color(255, 153, 0));
        btn_add_if_min.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_add_if_min.setForeground(new java.awt.Color(255, 255, 255));
        btn_add_if_min.setText("Add_if_min");
        btn_add_if_min.setBorder(null);
        btn_add_if_min.setBorderPainted(false);
        btn_add_if_min.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jbtnext.setBackground(new java.awt.Color(255, 153, 0));
        jbtnext.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jbtnext.setForeground(new java.awt.Color(255, 255, 255));
        jbtnext.setText("next");
        jbtnext.setBorder(null);
        jbtnext.setBorderPainted(false);
        jbtnext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnext.setVisible(false);


        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel1.setForeground(new Color(255, 102, 0));
        jLabel1.setText("Enter information about train");

        jLabel2.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Number of carriages");

        jSpinner1.setFont(new Font("Segoe UI", 0, 12)); // NOI18N

        jLabel3.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Choose number of carriage");

        jSpinner2.setFont(new Font("Segoe UI", 0, 12)); // NOI18N

        jLabel4.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Color");

        panel_color.setBorder(BorderFactory.createEtchedBorder());
        panel_color.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_color.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_colorMouseClicked(evt);
            }
        });

        GroupLayout panel_colorLayout = new GroupLayout(panel_color);
        panel_color.setLayout(panel_colorLayout);
        panel_colorLayout.setHorizontalGroup(
                panel_colorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 32, Short.MAX_VALUE)
        );
        panel_colorLayout.setVerticalGroup(
                panel_colorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        btn_carriages.setBackground(new java.awt.Color(255, 153, 0));
        btn_carriages.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_carriages.setForeground(new java.awt.Color(255, 255, 255));
        btn_carriages.setText("Go to carriages");
        btn_carriages.setBorder(null);
        btn_carriages.setBorderPainted(false);
        btn_carriages.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_carriages.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jSpinner2.setVisible(true);
                jTextField1.setVisible(true);
                jLabel3.setVisible(true);
                jLabel5.setVisible(true);
                jbtnext.setVisible(true);
                jLabel2.setVisible(false);
                jLabel4.setVisible(false);
                jSpinner1.setVisible(false);
                btn_color.setVisible(false);
                panel_color.setVisible(false);
                carben = new int[(int) jSpinner1.getValue()];
                for (int q = 0; q < (int) jSpinner1.getValue(); q++) {
                    carben[q] = 3;
                }
            }
        });

        btn_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Train newTrain = null;
                newTrain = new Train((int) jSpinner1.getValue(), panel_color.getBackground());
                if (jSpinner2.isVisible()) {
                    for (int y = 0; y < (int) jSpinner1.getValue(); y++) {
                        newTrain.getCarriages()[y] = new Carriage(carben[y]);
                    }
                }

                railroad.Add(newTrain);
                railroad.saveToFile(Constants.TRAIN_FILE_NAME);
                JOptionPane.showMessageDialog(getContentPane(), "New element added");
            }
        });

        btn_add_if_min.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Train newTrain = null;
                newTrain = new Train((int) jSpinner1.getValue(), panel_color.getBackground());
                if (jSpinner2.isVisible()) {
                    for (int y = 0; y < (int) jSpinner1.getValue(); y++) {
                        newTrain.getCarriages()[y] = new Carriage(carben[y]);
                    }
                }
                try {
                    boolean a = railroad.Add_if_min(newTrain, Train.myCompare);
                    if (a) {
                        railroad.Add(newTrain);
                        railroad.saveToFile(Constants.TRAIN_FILE_NAME);
                        JOptionPane.showMessageDialog(getContentPane(), "New element added");
                    } else JOptionPane.showMessageDialog(getContentPane(), "Element isn't min");
                } catch (Exception ea) {
                    JOptionPane.showMessageDialog(getContentPane(), "Something is wrong");
                }
            }
        });

        jbtnext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    carben[(int) jSpinner2.getValue() - 1] = Integer.parseInt(jTextField1.getText());
                    //    jTextField1.setText("");
                    if ((int) jSpinner2.getValue() < (int) jSpinner1.getValue()) {
                        jSpinner2.setValue((int) jSpinner2.getValue() + 1);
                    }
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(getContentPane(), "Now you can add a train");
                }
            }
        });

        jLabel5.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Number of benches");

        btn_back.setBackground(new Color(255, 153, 0));
        btn_back.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        btn_back.setForeground(new Color(255, 255, 255));
        btn_back.setText("Back to commands");
        btn_back.setBorder(null);
        btn_back.setBorderPainted(false);
        btn_back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CommandScreen com = new CommandScreen();
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                dispose();
            }
        });

        jSpinner2.setVisible(false);
        jTextField1.setVisible(false);
        jLabel3.setVisible(false);
        jLabel5.setVisible(false);

        railroad = new Railroad();
        railroad.doImport(Constants.TRAIN_FILE_NAME);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btn_add, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                                                .addGap(55, 55, 55)
                                                .addComponent(btn_add_if_min, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30)
                                                .addComponent(btn_back, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(111, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(btn_color, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jSpinner1, GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btn_carriages, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addComponent(jLabel4))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jSpinner2)
                                                        .addComponent(jTextField1))
                                                .addComponent(jbtnext)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(238, 238, 238)
                                                .addComponent(jLabel1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(93, 93, 93)
                                                .addComponent(panel_color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel1)
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSpinner1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSpinner2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_color, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                                        .addComponent(panel_color, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(31, 31, 31)
                                .addComponent(jbtnext)
                                .addComponent(btn_carriages, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btn_add, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_add_if_min, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_back, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29))
        );

        layout.linkSize(SwingConstants.VERTICAL, new java.awt.Component[]{jSpinner2, jTextField1});

        pack();
    }

    private void btn_colorActionPerformed(java.awt.event.ActionEvent evt) {
        Color colorChooser = JColorChooser.showDialog(null, "Choose color", Color.WHITE);
        panel_color.setBackground(colorChooser);
    }

    private void panel_colorMouseClicked(java.awt.event.MouseEvent evt) {
        Color colorChooser = JColorChooser.showDialog(null, "Choose color", Color.WHITE);
        panel_color.setBackground(colorChooser);


    }
}