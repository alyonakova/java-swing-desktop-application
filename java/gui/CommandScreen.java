package gui;

import model.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;

public class CommandScreen extends JFrame {
    private JButton jbtInfo = null;
    private JButton jbtLoad = null;
    private JButton jbtImport = null;
    private JButton jbtRemove = null;
    private JButton jbtAdd = null;
    private JButton jbtSort = null;
    private JButton jbtFilter = null;
    private JButton jbtUpdate = null;
    private JButton jbtBackToMenu = null;
    private JLabel jlblEnterValue = null;
    private JLabel jlblNumber = null;
    private JLabel jlblType = null;
    private JLabel jlblColor = null;
    private JButton jbtnChooseColor = null;
    private JTextPane jtp1 = null;
    private JComboBox jComboBoxCarriageType = null;
    private JPanel jpan = null;
    private JTree jtree = null;
    private JPanel jpancol = null;
    private JPanel jpanorange = null;
    private Railroad railroad = new Railroad();
    private JFrame jfrm = null;
    private GroupLayout groupLayout = null;
    private int trIndex = -1;
    private int carIndex = -1;
    private JScrollPane jscroll = null;

    CommandScreen() {

        jfrm = new JFrame("Commands");
        Font myFont = new Font("Segoe UI", Font.PLAIN, 18);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        jbtInfo = new JButton("info");
        jbtInfo.setFont(myFont);
        jbtInfo.setBackground(new Color(255, 153, 0));
        jbtInfo.setForeground(Color.WHITE);
        jbtInfo.setPreferredSize(new Dimension(104, 40));
        jbtInfo.setMinimumSize(new Dimension(104, 40));
        jbtInfo.setBorder(null);
        jbtInfo.setBorderPainted(false);
        jbtInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jbtLoad = new JButton("load");
        jbtLoad.setFont(myFont);
        jbtLoad.setBackground(new Color(255, 153, 0));
        jbtLoad.setForeground(Color.WHITE);
        jbtLoad.setPreferredSize(new Dimension(104, 40));
        jbtLoad.setMinimumSize(new Dimension(104, 40));
        jbtLoad.setBorder(null);
        jbtLoad.setBorderPainted(false);
        jbtLoad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jbtImport = new JButton("import");
        jbtImport.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        jbtImport.setBackground(new Color(255, 153, 0));
        jbtImport.setForeground(Color.WHITE);
        jbtImport.setPreferredSize(new Dimension(104, 40));
        jbtImport.setMinimumSize(new Dimension(104, 40));
        jbtImport.setBorder(null);
        jbtImport.setBorderPainted(false);
        jbtImport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_importActionPerformed(evt);
            }
        });

        jbtRemove = new JButton("remove");
        jbtRemove.setFont(myFont);
        jbtRemove.setBackground(new Color(255, 153, 0));
        jbtRemove.setForeground(Color.WHITE);
        jbtRemove.setPreferredSize(new Dimension(104, 40));
        jbtRemove.setMinimumSize(new Dimension(104, 40));
        jbtRemove.setBorder(null);
        jbtRemove.setBorderPainted(false);
        jbtRemove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtRemove.setEnabled(false);

        jbtAdd = new JButton("add / add_if_min");
        jbtAdd.setFont(myFont);
        jbtAdd.setBackground(new Color(255, 153, 0));
        jbtAdd.setForeground(Color.WHITE);
        jbtAdd.setPreferredSize(new Dimension(238, 40));
        jbtAdd.setMinimumSize(new Dimension(238, 40));
        jbtAdd.setBorder(null);
        jbtAdd.setBorderPainted(false);
        jbtAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jbtSort = new JButton("sort");
        jbtSort.setFont(myFont);
        jbtSort.setBackground(new Color(255, 153, 0));
        jbtSort.setForeground(Color.WHITE);
        jbtSort.setPreferredSize(new Dimension(104, 40));
        jbtSort.setMinimumSize(new Dimension(104, 40));
        jbtSort.setBorder(null);
        jbtSort.setBorderPainted(false);
        jbtSort.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jbtFilter = new JButton("filtr");
        jbtFilter.setFont(myFont);
        jbtFilter.setBackground(new Color(255, 153, 0));
        jbtFilter.setForeground(Color.WHITE);
        jbtFilter.setPreferredSize(new Dimension(104, 40));
        jbtFilter.setMinimumSize(new Dimension(104, 40));
        jbtFilter.setBorder(null);
        jbtFilter.setBorderPainted(false);
        jbtFilter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jbtUpdate = new JButton("update");
        jbtUpdate.setFont(myFont);
        jbtUpdate.setBackground(new Color(255, 153, 0));
        jbtUpdate.setForeground(Color.WHITE);
        jbtUpdate.setPreferredSize(new Dimension(104, 40));
        jbtUpdate.setMinimumSize(new Dimension(104, 40));
        jbtUpdate.setBorder(null);
        jbtUpdate.setBorderPainted(false);
        jbtUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtUpdate.setEnabled(false);

        jbtBackToMenu = new JButton("Back to menu");
        jbtBackToMenu.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        jbtBackToMenu.setBackground(new Color(255, 153, 0));
        jbtBackToMenu.setForeground(Color.WHITE);
        jbtBackToMenu.setPreferredSize(new Dimension(104, 40));
        jbtInfo.setMinimumSize(new Dimension(104, 40));
        jbtBackToMenu.setBorder(null);
        jbtBackToMenu.setBorderPainted(false);
        jbtBackToMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jlblEnterValue = new JLabel("Enter a value");
        jlblEnterValue.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        jlblEnterValue.setForeground(Color.BLACK);
        jlblEnterValue.setHorizontalAlignment(SwingConstants.CENTER);
        jlblNumber = new JLabel("Number");
        jlblNumber.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        jlblNumber.setForeground(Color.WHITE);
        jlblType = new JLabel("Type");
        jlblType.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        jlblType.setForeground(Color.WHITE);
        jlblColor = new JLabel("Color");
        jlblColor.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        jlblColor.setForeground(Color.WHITE);
        jbtnChooseColor = new JButton("Choose color");
        jbtnChooseColor.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        jbtnChooseColor.setForeground(Color.BLACK);
        jbtnChooseColor.setBackground(Color.WHITE);
        jbtnChooseColor.setPreferredSize(new Dimension(126, 25));
        jbtnChooseColor.setMinimumSize(new Dimension(106, 25));
        jbtnChooseColor.setEnabled(false);

        jtp1 = new JTextPane();
        jComboBoxCarriageType = new JComboBox<>();
        jComboBoxCarriageType.addItem("FORDRIVERS");
        jComboBoxCarriageType.addItem("RESTAURANT");
        jComboBoxCarriageType.addItem("USUAL");
        jtp1.setPreferredSize(new Dimension(155, 25));
        jtp1.setMinimumSize(new Dimension(125, 25));
        jtp1.setEnabled(false);

        jComboBoxCarriageType.setPreferredSize(new Dimension(155, 25));
        jComboBoxCarriageType.setMinimumSize(new Dimension(125, 25));
        jComboBoxCarriageType.setEnabled(false);

        jpanorange = new JPanel();
        jpanorange.setBackground(new Color(255, 153, 0));

        jpancol = new JPanel();
        jpancol.setPreferredSize(new Dimension(24, 25));
        jpancol.setMinimumSize(new Dimension(24, 25));
        jpancol.setVisible(false);

        railroad.doImport(Constants.TRAIN_FILE_NAME);

        jtree = new JTree();
        //jtree.setPreferredSize(new Dimension(426, 564));
        jtree.setMinimumSize(new Dimension(426, 564));
        jtree.setFont(new Font("Segoe UI", Font.ITALIC, 16));

        fillJTree();

        jscroll = new JScrollPane();
        jscroll.getViewport().add(jtree);
        jscroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jscroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(jscroll);

        GroupLayout panel_colorLayout = new GroupLayout(jpancol);
        jpancol.setLayout(panel_colorLayout);
        panel_colorLayout.setHorizontalGroup(
                panel_colorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 31, Short.MAX_VALUE)
        );
        panel_colorLayout.setVerticalGroup(
                panel_colorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 20, Short.MAX_VALUE)
        );

        groupLayout = new GroupLayout(jpan);
        jpan.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jscroll, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(66, 66, 66)
                                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jbtAdd, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(GroupLayout.Alignment.LEADING, groupLayout.createSequentialGroup()
                                                                .addComponent(jbtSort, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jbtFilter, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(groupLayout.createSequentialGroup()
                                                                .addComponent(jbtImport, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jbtRemove, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(groupLayout.createSequentialGroup()
                                                                .addComponent(jbtInfo, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jbtLoad, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(60, 60, 60))
                                        .addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup()
                                                                .addComponent(jpanorange, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(35)
                                                                .addContainerGap())
                                                        .addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup()
                                                                .addComponent(jbtUpdate, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jbtBackToMenu, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(58, 58, 58))))))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jscroll, GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(groupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jbtInfo, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jbtLoad, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jbtImport, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jbtRemove, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addComponent(jbtAdd, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jbtSort, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jbtFilter, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addComponent(jpanorange, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jbtUpdate, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jbtBackToMenu, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25))
        );


        GroupLayout jPanel1Layout = new GroupLayout(jpanorange);
        jpanorange.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jlblNumber)
                                                .addGap(28, 28, 28)
                                                .addComponent(jtp1))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jlblType)
                                                        .addComponent(jlblColor))
                                                .addGap(45, 45, 45)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jpancol, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jbtnChooseColor, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jComboBoxCarriageType)))
                                        .addComponent(jlblEnterValue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jlblEnterValue)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlblNumber)
                                        .addComponent(jtp1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlblType)
                                        .addComponent(jComboBoxCarriageType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(jlblColor)
                                                .addComponent(jpancol, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jbtnChooseColor))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );


        picPan.add(jpan, BorderLayout.NORTH);
        picPan.setPreferredSize(new Dimension(10000, 10000));
        jfrm.add(picPan);
        jfrm.pack();
        jfrm.setSize(800, 630);
        jfrm.setVisible(true);

        jbtBackToMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuScreen men = new MenuScreen();
                jfrm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                jfrm.dispose();
            }
        });

        jbtnChooseColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color c = JColorChooser.showDialog(null, "Choose color", jpancol.getBackground());
                if (c != null)
                    jpancol.setBackground(c);
            }
        });

        jbtFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FilterScreen f = new FilterScreen();
                jfrm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                jfrm.dispose();
            }
        });
        jbtSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SortScreen s = new SortScreen();
                jfrm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                jfrm.dispose();
            }
        });
        jbtAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddScreen a = new AddScreen();
                jfrm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                jfrm.dispose();
            }
        });
        jbtInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InfoScreen in = new InfoScreen();
                jfrm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                jfrm.dispose();
            }
        });
        jbtLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                railroad.load(Constants.PLUS_FILE_NAME);
                JOptionPane.showMessageDialog(jfrm, "The collection is loaded");
                railroad.saveToFile(Constants.TRAIN_FILE_NAME);
                CommandScreen com = new CommandScreen(); // DO NOT REMOVE FOR THE GOD'S SAKE!!! KITTENS WILLs DROWN IF YOU DELETE THIS!!!
                jfrm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                jfrm.dispose();
            }
        });

        jbtRemove.addActionListener(e -> this.RemoveTreeNode());

        jtree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                TreePath path = jtree.getSelectionPath();
                if (path == null) return;
                Object obj = path.getLastPathComponent();
                if (obj == null) return;
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) obj;
                String str = node.getUserObject().toString();
                if (str.startsWith("Carriages")) {
                    jtp1.setEnabled(true);
                    jComboBoxCarriageType.setEnabled(false);
                    jbtnChooseColor.setEnabled(false);
                    jpancol.setVisible(false);
                    DefaultMutableTreeNode tr = (DefaultMutableTreeNode) node.getParent();
                    trIndex = Integer.parseInt(tr.getUserObject().toString().replaceAll("Train ", "")) - 1;
                    jbtUpdate.setEnabled(true);
                    jbtRemove.setEnabled(false);
                } else if (str.startsWith("Carriage ")) {
                    jtp1.setEnabled(true);
                    jComboBoxCarriageType.setEnabled(false);
                    jbtnChooseColor.setEnabled(false);
                    jpancol.setVisible(false);
                    DefaultMutableTreeNode tr = (DefaultMutableTreeNode) node.getParent().getParent();
                    trIndex = Integer.parseInt(tr.getUserObject().toString().replaceAll("Train ", "")) - 1;
                    jbtUpdate.setEnabled(true);
                    jbtRemove.setEnabled(true);
                } else if (str.startsWith("Type")) {
                    jtp1.setEnabled(false);
                    jComboBoxCarriageType.setEnabled(true);
                    jbtnChooseColor.setEnabled(false);
                    jpancol.setVisible(false);
                    DefaultMutableTreeNode tr = (DefaultMutableTreeNode) node.getParent().getParent().getParent();
                    DefaultMutableTreeNode cr = (DefaultMutableTreeNode) node.getParent();
                    trIndex = Integer.parseInt(tr.getUserObject().toString().replaceAll("Train ", "")) - 1;
                    carIndex = Integer.parseInt(cr.getUserObject().toString().replaceAll("Carriage ", "")) - 1;
                    jbtUpdate.setEnabled(true);
                    jbtRemove.setEnabled(false);
                } else if ((str.startsWith("FORDRIVERS")) || (str.startsWith("USUAL")) || (str.startsWith("RESTAURANT"))) {
                    jtp1.setEnabled(false);
                    jComboBoxCarriageType.setEnabled(true);
                    jbtnChooseColor.setEnabled(false);
                    jpancol.setVisible(false);
                    DefaultMutableTreeNode tr = (DefaultMutableTreeNode) node.getParent().getParent().getParent().getParent();
                    DefaultMutableTreeNode cr = (DefaultMutableTreeNode) node.getParent().getParent();
                    trIndex = Integer.parseInt(tr.getUserObject().toString().replaceAll("Train ", "")) - 1;
                    carIndex = Integer.parseInt(cr.getUserObject().toString().replaceAll("Carriage ", "")) - 1;
                    jbtUpdate.setEnabled(true);
                    jbtRemove.setEnabled(false);
                } else if (str.startsWith("Color")) {
                    jtp1.setEnabled(false);
                    jComboBoxCarriageType.setEnabled(false);
                    jbtnChooseColor.setEnabled(true);
                    jpancol.setVisible(true);
                    DefaultMutableTreeNode tr = (DefaultMutableTreeNode) node.getParent();
                    trIndex = Integer.parseInt(tr.getUserObject().toString().replaceAll("Train ", "")) - 1;
                    Train[] trToknowCol = railroad.trains.toArray(new Train[]{});
                    jpancol.setBackground(trToknowCol[trIndex].getColor());
                    jbtUpdate.setEnabled(true);
                    jbtRemove.setEnabled(false);
                } else if (str.startsWith("java")) {
                    jtp1.setEnabled(false);
                    jComboBoxCarriageType.setEnabled(false);
                    jbtnChooseColor.setEnabled(true);
                    jpancol.setVisible(true);
                    DefaultMutableTreeNode tr = (DefaultMutableTreeNode) node.getParent().getParent();
                    trIndex = Integer.parseInt(tr.getUserObject().toString().replaceAll("Train ", "")) - 1;
                    Train[] trToknowCol = railroad.trains.toArray(new Train[]{});
                    jpancol.setBackground(trToknowCol[trIndex].getColor());
                    jbtUpdate.setEnabled(true);
                    jbtRemove.setEnabled(false);
                } else if (str.startsWith("Benches")) {
                    jtp1.setEnabled(true);
                    jComboBoxCarriageType.setEnabled(false);
                    jbtnChooseColor.setEnabled(false);
                    jpancol.setVisible(false);
                    DefaultMutableTreeNode tr = (DefaultMutableTreeNode) node.getParent().getParent().getParent();
                    trIndex = Integer.parseInt(tr.getUserObject().toString().replaceAll("Train ", "")) - 1;
                    DefaultMutableTreeNode cr = (DefaultMutableTreeNode) node.getParent();
                    carIndex = Integer.parseInt(cr.getUserObject().toString().replaceAll("Carriage ", "")) - 1;
                    jbtUpdate.setEnabled(true);
                    jbtRemove.setEnabled(false);
                } else if (str.startsWith("Bench ")) {
                    jtp1.setEnabled(true);
                    jComboBoxCarriageType.setEnabled(false);
                    jbtnChooseColor.setEnabled(false);
                    jpancol.setVisible(false);
                    DefaultMutableTreeNode tr = (DefaultMutableTreeNode) node.getParent().getParent().getParent().getParent();
                    trIndex = Integer.parseInt(tr.getUserObject().toString().replaceAll("Train ", "")) - 1;
                    DefaultMutableTreeNode cr = (DefaultMutableTreeNode) node.getParent().getParent();
                    carIndex = Integer.parseInt(cr.getUserObject().toString().replaceAll("Carriage ", "")) - 1;
                    jbtUpdate.setEnabled(true);
                    jbtRemove.setEnabled(true);
                } else if (str.startsWith("Train ")) {
                    jbtUpdate.setEnabled(false);
                    jbtRemove.setEnabled(true);
                } else if (str.startsWith("Trains")) {
                    jbtUpdate.setEnabled(false);
                    jbtRemove.setEnabled(false);
                }
            }
        });

        jbtUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Train[] trToknow = railroad.trains.toArray(new Train[]{});
                TreePath path = jtree.getSelectionPath();
                if (path == null) return;
                Object obj = path.getLastPathComponent();
                if (obj == null) return;
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) obj;
                String str = node.getUserObject().toString();
                if (jtp1.isEnabled()) {
                    try {

                        if (jtp1.getText() == "") {
                            JOptionPane.showMessageDialog(jfrm, "Enter the value");
                            jtp1.setText("");
                        } else if ((Integer.parseInt(jtp1.getText()) < 1)) {
                            JOptionPane.showMessageDialog(jfrm, "The number can't be less than 1");
                            jtp1.setText("");
                        } else if (str.startsWith("Carriage")) {
                            if ((Integer.parseInt(jtp1.getText()) > 10)) {
                                JOptionPane.showMessageDialog(jfrm, "The number of carriages can't be more than 10");
                                jtp1.setText("");
                            } else {
                                if ((Integer.parseInt(jtp1.getText()) > trToknow[trIndex].getCarriages().length)) {
                                    Carriage[] carmas = new Carriage[(Integer.parseInt(jtp1.getText()))];
                                    for (int i = 0; i < trToknow[trIndex].getCarriages().length; i++) {
                                        carmas[i] = trToknow[trIndex].getCarriages()[i];
                                    }
                                    for (int i = 0; i < Integer.parseInt(jtp1.getText()) - trToknow[trIndex].getCarriages().length; i++) {
                                        carmas[i + trToknow[trIndex].getCarriages().length] = new Carriage(3);
                                    }
                                    trToknow[trIndex].setCarriages(carmas);
                                    railroad.trains.clear();
                                    for (int r = 0; r < trToknow.length; r++) {
                                        railroad.trains.add(trToknow[r]);
                                    }
                                    DefaultMutableTreeNode parent;
                                    if (str.startsWith("Carriages")) {
                                        parent = node;
                                    } else {
                                        parent = (DefaultMutableTreeNode) node.getParent();
                                    }
                                    parent.removeAllChildren();
                                    int j = 1;
                                    for (Carriage c : carmas) {
                                        DefaultMutableTreeNode carN = new DefaultMutableTreeNode("Carriage " + j++);
                                        DefaultMutableTreeNode typeN = new DefaultMutableTreeNode("Type");
                                        DefaultMutableTreeNode typeVN = new DefaultMutableTreeNode(c.getType());
                                        DefaultMutableTreeNode benchesN = new DefaultMutableTreeNode("Benches");
                                        typeN.add(typeVN);
                                        carN.add(typeN);
                                        carN.add(benchesN);
                                        parent.add(carN);
                                        int k = 1;
                                        for (Bench b : c.getBenches()) {
                                            DefaultMutableTreeNode benchN = new DefaultMutableTreeNode("Bench " + k++);
                                            benchesN.add(benchN);
                                        }
                                    }

                                    //fillJTree();
                                    railroad.saveToFile(Constants.TRAIN_FILE_NAME);
                                    JOptionPane.showMessageDialog(jfrm, "The collection successfully updated");
                                    jtp1.setText("");
                                    jtp1.setEnabled(false);

                                } else if ((Integer.parseInt(jtp1.getText()) < trToknow[trIndex].getCarriages().length)) {
                                    Carriage[] carmas = new Carriage[(Integer.parseInt(jtp1.getText()))];
                                    for (int r = 0; r < Integer.parseInt(jtp1.getText()); r++) {
                                        carmas[r] = trToknow[trIndex].getCarriages()[r];
                                    }
                                    trToknow[trIndex].setCarriages(carmas);
                                    railroad.trains.clear();
                                    for (int r = 0; r < trToknow.length; r++) {
                                        railroad.trains.add(trToknow[r]);
                                    }
                                    DefaultMutableTreeNode parent;
                                    if (str.startsWith("Carriages")) {
                                        parent = node;
                                    } else {
                                        parent = (DefaultMutableTreeNode) node.getParent();
                                    }
                                    parent.removeAllChildren();
                                    int j = 1;
                                    for (Carriage c : carmas) {
                                        DefaultMutableTreeNode carN = new DefaultMutableTreeNode("Carriage " + j++);
                                        DefaultMutableTreeNode typeN = new DefaultMutableTreeNode("Type");
                                        DefaultMutableTreeNode typeVN = new DefaultMutableTreeNode(c.getType());
                                        DefaultMutableTreeNode benchesN = new DefaultMutableTreeNode("Benches");
                                        typeN.add(typeVN);
                                        carN.add(typeN);
                                        carN.add(benchesN);
                                        parent.add(carN);
                                        int k = 1;
                                        for (Bench b : c.getBenches()) {
                                            DefaultMutableTreeNode benchN = new DefaultMutableTreeNode("Bench " + k++);
                                            benchesN.add(benchN);
                                        }
                                    }
                                    railroad.saveToFile(Constants.TRAIN_FILE_NAME);
                                    JOptionPane.showMessageDialog(jfrm, "The collection successfully updated");
                                    jtp1.setText("");
                                    jtp1.setEnabled(false);
                                } else if ((Integer.parseInt(jtp1.getText()) == trToknow[trIndex].getCarriages().length)) {
                                    JOptionPane.showMessageDialog(jfrm, "The collection successfully updated");
                                }
                            }
                        } else if (str.startsWith("Bench")) {
                            if ((Integer.parseInt(jtp1.getText()) > trToknow[trIndex].getCarriages()[carIndex].getBenches().length)) {
                                Bench[] benmas = new Bench[(Integer.parseInt(jtp1.getText()))];
                                for (int i = 0; i < trToknow[trIndex].getCarriages()[carIndex].getBenches().length; i++) {
                                    benmas[i] = trToknow[trIndex].getCarriages()[carIndex].getBenches()[i];
                                }
                                for (int i = 0; i < Integer.parseInt(jtp1.getText()) - trToknow[trIndex].getCarriages()[carIndex].getBenches().length; i++) {
                                    benmas[i + trToknow[trIndex].getCarriages()[carIndex].getBenches().length] = new Bench();
                                }
                                trToknow[trIndex].getCarriages()[carIndex].setBenches(benmas);
                                railroad.trains.clear();
                                for (int r = 0; r < trToknow.length; r++) {
                                    railroad.trains.add(trToknow[r]);
                                }
                                DefaultMutableTreeNode parent;
                                if (str.startsWith("Benches")) {
                                    parent = node;
                                } else {
                                    parent = (DefaultMutableTreeNode) node.getParent();
                                }
                                parent.removeAllChildren();
                                int k = 1;
                                for (Bench b : benmas) {
                                    DefaultMutableTreeNode benchN = new DefaultMutableTreeNode("Bench " + k++);
                                    parent.add(benchN);
                                }
                                railroad.saveToFile(Constants.TRAIN_FILE_NAME);
                                JOptionPane.showMessageDialog(jfrm, "The collection successfully updated");
                                jtp1.setText("");
                                jtp1.setEnabled(false);
                            } else if ((Integer.parseInt(jtp1.getText()) < trToknow[trIndex].getCarriages()[carIndex].getBenches().length)) {
                                Bench[] benmas = new Bench[(Integer.parseInt(jtp1.getText()))];
                                for (int r = 0; r < Integer.parseInt(jtp1.getText()); r++) {
                                    benmas[r] = trToknow[trIndex].getCarriages()[carIndex].getBenches()[r];
                                }
                                trToknow[trIndex].getCarriages()[carIndex].setBenches(benmas);
                                railroad.trains.clear();
                                for (int r = 0; r < trToknow.length; r++) {
                                    railroad.trains.add(trToknow[r]);
                                }
                                DefaultMutableTreeNode parent;
                                if (str.startsWith("Benches")) {
                                    parent = node;
                                } else {
                                    parent = (DefaultMutableTreeNode) node.getParent();
                                }
                                parent.removeAllChildren();
                                int k = 1;
                                for (Bench b : benmas) {
                                    DefaultMutableTreeNode benchN = new DefaultMutableTreeNode("Bench " + k++);
                                    parent.add(benchN);
                                }
                                //fillJTree();
                                railroad.saveToFile(Constants.TRAIN_FILE_NAME);
                                JOptionPane.showMessageDialog(jfrm, "The collection successfully updated");
                                jtp1.setText("");
                                jtp1.setEnabled(false);
                            } else if ((Integer.parseInt(jtp1.getText()) == trToknow[trIndex].getCarriages()[carIndex].getBenches().length)) {
                                JOptionPane.showMessageDialog(jfrm, "The collection successfully updated");
                            }

                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(jfrm, "Please, enter the number");
                        jtp1.setText("");
                        jtp1.setEnabled(false);
                    }
                } else if (jComboBoxCarriageType.isEnabled()) {
                    if (String.valueOf(jComboBoxCarriageType.getSelectedItem()) == "FORDRIVERS") {
                        trToknow[trIndex].getCarriages()[carIndex].setType(CarriageType.FORDRIVERS);
                        railroad.trains.clear();
                        for (int r = 0; r < trToknow.length; r++) {
                            railroad.trains.add(trToknow[r]);
                        }
                        DefaultMutableTreeNode parent;
                        if (node.getUserObject().toString().equals("Type")) {
                            parent = node;
                        } else {
                            parent = (DefaultMutableTreeNode) node.getParent();
                        }
                        parent.removeAllChildren();
                        DefaultMutableTreeNode newN = new DefaultMutableTreeNode(CarriageType.FORDRIVERS);
                        parent.add(newN);
                        //fillJTree();
                        railroad.saveToFile(Constants.TRAIN_FILE_NAME);
                        JOptionPane.showMessageDialog(jfrm, "The collection successfully updated");
                        jComboBoxCarriageType.setEnabled(false);
                    } else if (String.valueOf(jComboBoxCarriageType.getSelectedItem()) == "RESTAURANT") {
                        trToknow[trIndex].getCarriages()[carIndex].setType(CarriageType.RESTAURANT);
                        railroad.trains.clear();
                        for (int r = 0; r < trToknow.length; r++) {
                            railroad.trains.add(trToknow[r]);
                        }
                        DefaultMutableTreeNode parent;
                        if (node.getUserObject().toString().equals("Type")) {
                            parent = node;
                        } else {
                            parent = (DefaultMutableTreeNode) node.getParent();
                        }
                        parent.removeAllChildren();
                        DefaultMutableTreeNode newN = new DefaultMutableTreeNode(CarriageType.RESTAURANT);
                        parent.add(newN);
//                        fillJTree();
                        railroad.saveToFile(Constants.TRAIN_FILE_NAME);
                        JOptionPane.showMessageDialog(jfrm, "The collection successfully updated");
                        jComboBoxCarriageType.setEnabled(false);
                    }

                } else if (jbtnChooseColor.isEnabled()) {
                    if (jpancol.isVisible()) {
                        trToknow[trIndex].setColor(jpancol.getBackground());
                        railroad.trains.clear();
                        for (int r = 0; r < trToknow.length; r++) {
                            railroad.trains.add(trToknow[r]);
                        }
                        DefaultMutableTreeNode parent;
                        if (node.getUserObject().toString().equals("Color")) {
                            parent = node;
                        } else {
                            parent = (DefaultMutableTreeNode) node.getParent();
                        }
                        parent.removeAllChildren();
                        DefaultMutableTreeNode newN = new DefaultMutableTreeNode(jpancol.getBackground());
                        parent.add(newN);
                        //fillJTree();
                        railroad.saveToFile(Constants.TRAIN_FILE_NAME);
                        JOptionPane.showMessageDialog(jfrm, "The collection successfully updated");
                        jbtnChooseColor.setEnabled(false);
                        jpancol.setVisible(false);
                    } else JOptionPane.showMessageDialog(jfrm, "Please, choose the color");
                }
                jtree.updateUI();
            }
        });


    }

    private void RemoveTreeNode() {
        TreePath path = jtree.getSelectionPath();
        if (path == null) return;
        Object obj = path.getLastPathComponent();
        if (obj == null) return;
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) obj;
        String str = node.getUserObject().toString();
        if (str.startsWith("Train ")) {
            int trN = node.getParent().getIndex(node);
            Train[] oldTr = railroad.trains.toArray(new Train[]{});
            int len = oldTr.length;
            LinkedHashSet<Train> newTr = new LinkedHashSet<>();
            for (int i = 0; i < len; i++) {
                if (i != trN) newTr.add(oldTr[i]);
            }
            railroad.trains = newTr;
            //fillJTree();
        } else if (str.startsWith("Carriage ")) {
            DefaultMutableTreeNode tr = (DefaultMutableTreeNode) node.getParent().getParent();
            int crN = node.getParent().getIndex(node);
            int trN = tr.getParent().getIndex(tr);
            Carriage[] oldCar = ((Train) railroad.trains.toArray()[trN]).getCarriages();
            int len = oldCar.length;
            Carriage[] newCar = new Carriage[len - 1];
            for (int i = 0; i < len; i++) {
                if (i < crN) newCar[i] = oldCar[i];
                else if (i > crN) newCar[i - 1] = oldCar[i];
            }
            ((Train) railroad.trains.toArray()[trN]).setCarriages(newCar);
            //fillJTree();
        } else if (str.startsWith("Bench ")) {
            DefaultMutableTreeNode cr = (DefaultMutableTreeNode) node.getParent().getParent();
            DefaultMutableTreeNode tr = (DefaultMutableTreeNode) cr.getParent().getParent();
            int brN = node.getParent().getIndex(node);
            int crN = cr.getParent().getIndex(cr);
            int trN = tr.getParent().getIndex(tr);
            Bench[] oldBench = ((Train) railroad.trains.toArray()[trN]).getCarriages()[crN].getBenches();
            int len = oldBench.length;
            Bench[] newBench = new Bench[len - 1];
            for (int i = 0; i < len; i++) {
                if (i < brN) newBench[i] = oldBench[i];
                else if (i > brN) newBench[i - 1] = oldBench[i];
            }
            ((Train) railroad.trains.toArray()[trN]).getCarriages()[crN].setBenches(newBench);
            //fillJTree();
        } else return;
        node.removeFromParent();
        jtree.updateUI();
        railroad.saveToFile(Constants.TRAIN_FILE_NAME);
    }

    private void fillJTree() {
        //Заполняем дерево
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Trains");
        int i = 1;
        for (Train t : railroad.trains.toArray(new Train[]{})) {
            DefaultMutableTreeNode trainN = new DefaultMutableTreeNode("Train " + i++);
            DefaultMutableTreeNode colorN = new DefaultMutableTreeNode("Color");
            DefaultMutableTreeNode colorVN = new DefaultMutableTreeNode(t.getColor());
            DefaultMutableTreeNode carsN = new DefaultMutableTreeNode("Carriages");
            colorN.add(colorVN);
            trainN.add(colorN);
            trainN.add(carsN);
            root.add(trainN);
            int j = 1;
            for (Carriage c : t.getCarriages()) {
                DefaultMutableTreeNode carN = new DefaultMutableTreeNode("Carriage " + j++);
                DefaultMutableTreeNode typeN = new DefaultMutableTreeNode("Type");
                DefaultMutableTreeNode typeVN = new DefaultMutableTreeNode(c.getType());
                DefaultMutableTreeNode benchesN = new DefaultMutableTreeNode("Benches");
                typeN.add(typeVN);
                carN.add(typeN);
                carN.add(benchesN);
                carsN.add(carN);
                int k = 1;
                for (Bench b : c.getBenches()) {
                    DefaultMutableTreeNode benchN = new DefaultMutableTreeNode("Bench " + k++);
                    benchesN.add(benchN);
                }
            }
        }
        jtree.setModel(new DefaultTreeModel(root, true));
        TreeSelectionModel smodel = new DefaultTreeSelectionModel();
        smodel.setSelectionMode(1);
        jtree.setSelectionModel(smodel);
    }

    private void btn_importActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser fileopen = new JFileChooser();
        File file = null;
        int ret = fileopen.showDialog(null, "Open file");
        if (ret == JFileChooser.APPROVE_OPTION) {
            file = fileopen.getSelectedFile();
            try {
                if (file.getName() == Constants.TRAIN_FILE_NAME) {
                    railroad.doImport(Constants.PLUS_FILE_NAME);
                } else {
                    railroad.doImport(file.getName());
                }
            } catch (Exception a) {
                JOptionPane.showMessageDialog(null, "Problems with the file");
            }
            fillJTree();
            railroad.saveToFile(Constants.TRAIN_FILE_NAME);
        } else {
            JOptionPane.showMessageDialog(null, "File wasn't chosen");
        }
    }


}


