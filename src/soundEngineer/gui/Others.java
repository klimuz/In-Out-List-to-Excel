package soundEngineer.gui;

import soundEngineer.server.ProjectData;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class Others extends JFrame implements ItemListener {

    private JMenuBar jMenuBar = new JMenuBar();
    JMenu m1 = new JMenu("File");
    JMenu m2 = new JMenu("Help");
    private JButton buttonBack = new JButton("Back");
    private JButton buttonNext = new JButton("Next");
    private JButton buttonApply = new JButton("Apply");
    private JLabel chooseOthersLabel = new JLabel("Choose other channels:");

    private JLabel dJLabel = new JLabel("Stereo DJ");
    private JLabel screenLabel = new JLabel("Screen");
    private JLabel hostLabel = new JLabel("Host");
    private JLabel clickLabel = new JLabel("Click");
    private JLabel extraLabel = new JLabel("Extra");
    private JLabel roomLabel = new JLabel("Room");

    private JLabel otherCannels = new JLabel("");

    private JComboBox<String> dJNumber = new JComboBox();
    private JComboBox<String> screenNumber = new JComboBox();
    private JComboBox<String> hostNumber = new JComboBox();
    private JComboBox<String> clickNumber = new JComboBox();
    private JComboBox<String> extraNumber = new JComboBox();
    private JComboBox<String> roomNumber = new JComboBox();

    private JCheckBox djOnStage = new JCheckBox("On Stage");
    private JCheckBox screenOnStage = new JCheckBox("On Stage");

    public void terminateThisWindow() {
        this.dispose();
    }


    public Others() throws HeadlessException {
        super("In-Out List to Exel : " + ProjectData.projectName);
        Font font = new Font("", Font.BOLD, 20);
        this.setIconImage(new ImageIcon("img/logo.png").getImage());
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setBounds(dimension.width / 2 - 350, dimension.height / 2 - 250, 854, 480);
        this.setResizable(false);

        m1.add(new JMenuItem("Open", 'O'));
        m1.add(new JMenuItem("Save", 'S'));
        m1.add(new JMenuItem("Recent"));
        m1.addSeparator();
        JMenuItem exit = m1.add(new JMenuItem("Exit"));
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null,
                        "Are you really want to quit?", "Confirm", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (option == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        exit.setAccelerator(KeyStroke.getKeyStroke("ctrl E"));

        m2.add(new JMenuItem("About"));
        jMenuBar.add(m1);
        jMenuBar.add(m2);
        jMenuBar.setBackground(Color.green);
        this.setJMenuBar(jMenuBar);
        this.revalidate();

//background image start
        try {
            Image backgroundImage = ImageIO.read(new File("img/mixer.jpg"));
            setContentPane(new JPanel(new BorderLayout()) {
                @Override
                public void paintComponent(Graphics g) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//background image end

//elements start
        Container container = this.getContentPane();
        container.setLayout(null);
        Container labelContainer = new Container();
        labelContainer.setLayout(new GridLayout(6, 1, 10, 10));
        labelContainer.setBounds(300, 100, 100, 200);
        Container numContainer = new Container();
        numContainer.setLayout(new GridLayout(6, 1, 10, 10));
        numContainer.setBounds(400, 100, 40, 200);
        Container checkBoxContainer = new Container();
        checkBoxContainer.setLayout(new GridLayout(6, 1, 10, 10));
        checkBoxContainer.setBounds(440, 100, 80, 200);

        chooseOthersLabel.setFont(font);
        chooseOthersLabel.setForeground(Color.orange);
        chooseOthersLabel.setBounds(245, 5, 300, 50);
        container.add(chooseOthersLabel);

        dJLabel.setForeground(Color.orange);
        dJLabel.setOpaque(true);
        dJLabel.setBackground(Color.BLUE);
        screenLabel.setOpaque(true);
        screenLabel.setBackground(Color.BLUE);
        screenLabel.setForeground(Color.orange);
        hostLabel.setOpaque(true);
        hostLabel.setBackground(Color.BLUE);
        hostLabel.setForeground(Color.orange);
        clickLabel.setOpaque(true);
        clickLabel.setBackground(Color.BLUE);
        clickLabel.setForeground(Color.orange);
        roomLabel.setForeground(Color.orange);
        roomLabel.setOpaque(true);
        roomLabel.setBackground(Color.BLUE);
        extraLabel.setForeground(Color.orange);
        extraLabel.setOpaque(true);
        extraLabel.setBackground(Color.BLUE);
        labelContainer.add(dJLabel);
        labelContainer.add(screenLabel);
        labelContainer.add(hostLabel);
        labelContainer.add(clickLabel);
        labelContainer.add(extraLabel);
        labelContainer.add(roomLabel);
//dj
        dJNumber.addItem("0");
        dJNumber.addItem("1");
        dJNumber.addItem("2");
        dJNumber.addItem("3");
        dJNumber.addItem("4");
        dJNumber.addItem("5");
        dJNumber.addItem("6");
        dJNumber.addItemListener(this);
        if (ProjectData.omniStrips.contains("DJ L") || ProjectData.extraStrips.contains("DJ L")) {
            dJNumber.setSelectedItem("1");
        } else if ((!ProjectData.omniStrips.contains("DJ3L") && ProjectData.omniStrips.contains("DJ2L")) ||
                (!ProjectData.extraStrips.contains("DJ3L") && ProjectData.extraStrips.contains("DJ2L"))) {
            dJNumber.setSelectedItem("2");
        } else if ((!ProjectData.omniStrips.contains("DJ4L") && ProjectData.omniStrips.contains("DJ3L")) ||
                (!ProjectData.extraStrips.contains("DJ4L") && ProjectData.extraStrips.contains("DJ3L"))) {
            dJNumber.setSelectedItem("3");
        } else if ((!ProjectData.omniStrips.contains("DJ5L") && ProjectData.omniStrips.contains("DJ4L")) ||
                (!ProjectData.extraStrips.contains("DJ5L") && ProjectData.extraStrips.contains("DJ4L"))) {
            dJNumber.setSelectedItem("4");
        } else if ((!ProjectData.omniStrips.contains("DJ6L") && ProjectData.omniStrips.contains("DJ5L")) ||
                (!ProjectData.extraStrips.contains("DJ6L") && ProjectData.extraStrips.contains("DJ5L"))) {
            dJNumber.setSelectedItem("5");
        } else if (ProjectData.omniStrips.contains("DJ6L") || ProjectData.extraStrips.contains("DJ6L")) {
            dJNumber.setSelectedItem("6");
        }
        if (ProjectData.extraStrips.contains("DJ L") ||
                ProjectData.extraStrips.contains("DJ2L") ||
                ProjectData.extraStrips.contains("DJ3L") ||
                ProjectData.extraStrips.contains("DJ4L") ||
                ProjectData.extraStrips.contains("DJ5L") ||
                ProjectData.extraStrips.contains("DJ6L")) {
            djOnStage.setSelected(true);
        }
        //screen
        screenNumber.addItem("0");
        screenNumber.addItem("1");
        screenNumber.addItem("2");
        screenNumber.addItem("3");
        screenNumber.addItem("4");
        screenNumber.addItem("5");
        screenNumber.addItem("6");
        screenNumber.addItemListener(this);
        if (ProjectData.omniStrips.contains("ScrL") || ProjectData.extraStrips.contains("ScrL")) {
            screenNumber.setSelectedItem("1");
        } else if ((!ProjectData.omniStrips.contains("Sc3L") && ProjectData.omniStrips.contains("Sc2L")) ||
                (!ProjectData.extraStrips.contains("Sc3L") && ProjectData.extraStrips.contains("Sc2L"))) {
            screenNumber.setSelectedItem("2");
        } else if ((!ProjectData.omniStrips.contains("Sc4L") && ProjectData.omniStrips.contains("Sc3L")) ||
                (!ProjectData.extraStrips.contains("Sc4L") && ProjectData.extraStrips.contains("Sc3L"))) {
            screenNumber.setSelectedItem("3");
        } else if ((!ProjectData.omniStrips.contains("Sc5L") && ProjectData.omniStrips.contains("Sc4L")) ||
                (!ProjectData.extraStrips.contains("Sc5L") && ProjectData.extraStrips.contains("Sc4L"))) {
            screenNumber.setSelectedItem("4");
        } else if ((!ProjectData.omniStrips.contains("Sc6L") && ProjectData.omniStrips.contains("Sc5L")) ||
                (!ProjectData.extraStrips.contains("Sc6L") && ProjectData.extraStrips.contains("Sc5L"))) {
            screenNumber.setSelectedItem("5");
        } else if (ProjectData.omniStrips.contains("Sc6L") || ProjectData.extraStrips.contains("Sc6L")) {
            screenNumber.setSelectedItem("6");
        }
        if (ProjectData.extraStrips.contains("ScrL") ||
                ProjectData.extraStrips.contains("Sc2L") ||
                ProjectData.extraStrips.contains("Sc3L") ||
                ProjectData.extraStrips.contains("Sc4L") ||
                ProjectData.extraStrips.contains("Sc5L") ||
                ProjectData.extraStrips.contains("Sc6L")) {
            screenOnStage.setSelected(true);
        }
        //host
        hostNumber.addItem("0");
        hostNumber.addItem("1");
        hostNumber.addItem("2");
        hostNumber.addItem("3");
        hostNumber.addItem("4");
        hostNumber.addItem("5");
        hostNumber.addItem("6");
        hostNumber.addItem("7");
        hostNumber.addItem("8");
        hostNumber.addItem("9");
        hostNumber.addItem("10");
        hostNumber.addItemListener(this);
        if (ProjectData.extraStrips.contains("Host")) {
            hostNumber.setSelectedItem("1");
        } else if (!ProjectData.extraStrips.contains("Hst3") && ProjectData.extraStrips.contains("Hst2")) {
            hostNumber.setSelectedItem("2");
        } else if (!ProjectData.extraStrips.contains("Hst4") && ProjectData.extraStrips.contains("Hst3")) {
            hostNumber.setSelectedItem("3");
        } else if (!ProjectData.extraStrips.contains("Hst5") && ProjectData.extraStrips.contains("Hst4")) {
            hostNumber.setSelectedItem("4");
        } else if (!ProjectData.extraStrips.contains("Hst6") && ProjectData.extraStrips.contains("Hst5")) {
            hostNumber.setSelectedItem("5");
        } else if (!ProjectData.extraStrips.contains("Hst7") && ProjectData.extraStrips.contains("Hst6")) {
            hostNumber.setSelectedItem("6");
        } else if (!ProjectData.extraStrips.contains("Hst8") && ProjectData.extraStrips.contains("Hst7")) {
            hostNumber.setSelectedItem("7");
        } else if (!ProjectData.extraStrips.contains("Hst9") && ProjectData.extraStrips.contains("Hst8")) {
            hostNumber.setSelectedItem("8");
        } else if (!ProjectData.extraStrips.contains("Hs10") && ProjectData.extraStrips.contains("Hst9")) {
            hostNumber.setSelectedItem("9");
        } else if (ProjectData.extraStrips.contains("Hs10")) {
            hostNumber.setSelectedItem("10");
        }
        //click
        clickNumber.addItem("0");
        clickNumber.addItem("1");
        clickNumber.addItem("2");
        clickNumber.addItemListener(this);
        if (ProjectData.extraStrips.contains("Clik")) {
            clickNumber.setSelectedItem("1");
        } else if (ProjectData.extraStrips.contains("Clk2")) {
            clickNumber.setSelectedItem("2");
        }
        //extra
        extraNumber.addItem("0");
        extraNumber.addItem("1");
        extraNumber.addItem("2");
        extraNumber.addItem("3");
        extraNumber.addItem("4");
        extraNumber.addItem("5");
        extraNumber.addItem("6");
        extraNumber.addItem("7");
        extraNumber.addItem("8");
        extraNumber.addItem("9");
        extraNumber.addItem("10");
        extraNumber.addItemListener(this);
        if (ProjectData.extraStrips.contains("Extr")) {
            extraNumber.setSelectedItem("1");
        } else if (!ProjectData.extraStrips.contains("Ext3") && ProjectData.extraStrips.contains("Ext2")) {
            extraNumber.setSelectedItem("2");
        } else if (!ProjectData.extraStrips.contains("Ext4") && ProjectData.extraStrips.contains("Ext3")) {
            extraNumber.setSelectedItem("3");
        } else if (!ProjectData.extraStrips.contains("Ext5") && ProjectData.extraStrips.contains("Ext4")) {
            extraNumber.setSelectedItem("4");
        } else if (!ProjectData.extraStrips.contains("Ext6") && ProjectData.extraStrips.contains("Ext5")) {
            extraNumber.setSelectedItem("5");
        } else if (!ProjectData.extraStrips.contains("Ext7") && ProjectData.extraStrips.contains("Ext6")) {
            extraNumber.setSelectedItem("6");
        } else if (!ProjectData.extraStrips.contains("Ext8") && ProjectData.extraStrips.contains("Ext7")) {
            extraNumber.setSelectedItem("7");
        } else if (!ProjectData.extraStrips.contains("Ext9") && ProjectData.extraStrips.contains("Ext8")) {
            extraNumber.setSelectedItem("8");
        } else if (!ProjectData.extraStrips.contains("Ext10") && ProjectData.extraStrips.contains("Ext9")) {
            extraNumber.setSelectedItem("9");
        } else if (ProjectData.extraStrips.contains("Ex10")) {
            extraNumber.setSelectedItem("10");
        }
        //room
        roomNumber.addItem("0");
        roomNumber.addItem("1");
        roomNumber.addItem("2");
        roomNumber.addItem("3");
        roomNumber.addItem("4");
        roomNumber.addItem("5");
        roomNumber.addItem("6");
        roomNumber.addItem("7");
        roomNumber.addItem("8");
        roomNumber.addItem("9");
        roomNumber.addItem("10");
        roomNumber.addItemListener(this);
        if (ProjectData.extraStrips.contains("Room")) {
            roomNumber.setSelectedItem("1");
        } else if (!ProjectData.extraStrips.contains("Roo3") && ProjectData.extraStrips.contains("Roo2")) {
            roomNumber.setSelectedItem("2");
        } else if (!ProjectData.extraStrips.contains("Roo4") && ProjectData.extraStrips.contains("Roo3")) {
            roomNumber.setSelectedItem("3");
        } else if (!ProjectData.extraStrips.contains("Roo5") && ProjectData.extraStrips.contains("Roo4")) {
            roomNumber.setSelectedItem("4");
        } else if (!ProjectData.extraStrips.contains("Roo6") && ProjectData.extraStrips.contains("Roo5")) {
            roomNumber.setSelectedItem("5");
        } else if (!ProjectData.extraStrips.contains("Roo7") && ProjectData.extraStrips.contains("Roo6")) {
            roomNumber.setSelectedItem("6");
        } else if (!ProjectData.extraStrips.contains("Roo8") && ProjectData.extraStrips.contains("Roo7")) {
            roomNumber.setSelectedItem("7");
        } else if (!ProjectData.extraStrips.contains("Roo9") && ProjectData.extraStrips.contains("Roo8")) {
            roomNumber.setSelectedItem("8");
        } else if (!ProjectData.extraStrips.contains("Roo10") && ProjectData.extraStrips.contains("Roo9")) {
            roomNumber.setSelectedItem("9");
        } else if (ProjectData.extraStrips.contains("Roo10")) {
            roomNumber.setSelectedItem("10");
        }


        numContainer.add(dJNumber);
        numContainer.add(screenNumber);
        numContainer.add(hostNumber);
        numContainer.add(clickNumber);
        numContainer.add(extraNumber);
        numContainer.add(roomNumber);

        djOnStage.setBackground(Color.BLUE);
        djOnStage.setForeground(Color.orange);
        screenOnStage.setBackground(Color.BLUE);
        screenOnStage.setForeground(Color.orange);
        checkBoxContainer.add(djOnStage);
        checkBoxContainer.add(screenOnStage);

        otherCannels.setBounds(650, 20, 150, 25);//label
        otherCannels.setForeground(Color.green);
        container.add(otherCannels);
        container.add(labelContainer);
        container.add(numContainer);
        container.add(checkBoxContainer);

//elements end

//Button apply start
        buttonApply.setBounds(725, 240, 70, 30);
        buttonApply.setBorderPainted(true);
        buttonApply.setBackground(Color.green);
        container.add(buttonApply);
        buttonApply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectData.omniStrips.clear();
                ProjectData.extraStrips.clear();
//dj
                String djSel = dJNumber.getSelectedItem().toString();
                switch (djSel) {
                    case "1":
                        if (djOnStage.isSelected()) {
                            ProjectData.extraStrips.add("DJ L");
                            ProjectData.extraStrips.add("DJ R");
                        } else {
                            ProjectData.omniStrips.add("DJ L");
                            ProjectData.omniStrips.add("DJ R");
                        }
                        break;
                    case "2":
                        if (djOnStage.isSelected()) {
                            ProjectData.extraStrips.add("DJ1L");
                            ProjectData.extraStrips.add("DJ1R");
                            ProjectData.extraStrips.add("DJ2L");
                            ProjectData.extraStrips.add("DJ2R");
                        } else {
                            ProjectData.omniStrips.add("DJ1L");
                            ProjectData.omniStrips.add("DJ1R");
                            ProjectData.omniStrips.add("DJ2L");
                            ProjectData.omniStrips.add("DJ2R");
                        }
                        break;
                    case "3":
                        if (djOnStage.isSelected()) {
                            ProjectData.extraStrips.add("DJ1L");
                            ProjectData.extraStrips.add("DJ1R");
                            ProjectData.extraStrips.add("DJ2L");
                            ProjectData.extraStrips.add("DJ2R");
                            ProjectData.extraStrips.add("DJ3L");
                            ProjectData.extraStrips.add("DJ3R");
                        } else {
                            ProjectData.omniStrips.add("DJ1L");
                            ProjectData.omniStrips.add("DJ1R");
                            ProjectData.omniStrips.add("DJ2L");
                            ProjectData.omniStrips.add("DJ2R");
                            ProjectData.omniStrips.add("DJ3L");
                            ProjectData.omniStrips.add("DJ3R");
                        }
                        break;
                    case "4":
                        if (djOnStage.isSelected()) {
                            ProjectData.extraStrips.add("DJ1L");
                            ProjectData.extraStrips.add("DJ1R");
                            ProjectData.extraStrips.add("DJ2L");
                            ProjectData.extraStrips.add("DJ2R");
                            ProjectData.extraStrips.add("DJ3L");
                            ProjectData.extraStrips.add("DJ3R");
                            ProjectData.extraStrips.add("DJ4L");
                            ProjectData.extraStrips.add("DJ4R");
                        } else {
                            ProjectData.omniStrips.add("DJ1L");
                            ProjectData.omniStrips.add("DJ1R");
                            ProjectData.omniStrips.add("DJ2L");
                            ProjectData.omniStrips.add("DJ2R");
                            ProjectData.omniStrips.add("DJ3L");
                            ProjectData.omniStrips.add("DJ3R");
                            ProjectData.omniStrips.add("DJ4L");
                            ProjectData.omniStrips.add("DJ4R");
                        }
                        break;
                    case "5":
                        if (djOnStage.isSelected()) {
                            ProjectData.extraStrips.add("DJ1L");
                            ProjectData.extraStrips.add("DJ1R");
                            ProjectData.extraStrips.add("DJ2L");
                            ProjectData.extraStrips.add("DJ2R");
                            ProjectData.extraStrips.add("DJ3L");
                            ProjectData.extraStrips.add("DJ3R");
                            ProjectData.extraStrips.add("DJ4L");
                            ProjectData.extraStrips.add("DJ4R");
                            ProjectData.extraStrips.add("DJ5L");
                            ProjectData.extraStrips.add("DJ5R");
                        } else {
                            ProjectData.omniStrips.add("DJ1L");
                            ProjectData.omniStrips.add("DJ1R");
                            ProjectData.omniStrips.add("DJ2L");
                            ProjectData.omniStrips.add("DJ2R");
                            ProjectData.omniStrips.add("DJ3L");
                            ProjectData.omniStrips.add("DJ3R");
                            ProjectData.omniStrips.add("DJ4L");
                            ProjectData.omniStrips.add("DJ4R");
                            ProjectData.omniStrips.add("DJ5L");
                            ProjectData.omniStrips.add("DJ5R");
                        }
                        break;
                    case "6":
                        if (djOnStage.isSelected()) {
                            ProjectData.extraStrips.add("DJ1L");
                            ProjectData.extraStrips.add("DJ1R");
                            ProjectData.extraStrips.add("DJ2L");
                            ProjectData.extraStrips.add("DJ2R");
                            ProjectData.extraStrips.add("DJ3L");
                            ProjectData.extraStrips.add("DJ3R");
                            ProjectData.extraStrips.add("DJ4L");
                            ProjectData.extraStrips.add("DJ4R");
                            ProjectData.extraStrips.add("DJ5L");
                            ProjectData.extraStrips.add("DJ5R");
                            ProjectData.extraStrips.add("DJ6L");
                            ProjectData.extraStrips.add("DJ6R");
                        } else {
                            ProjectData.omniStrips.add("DJ1L");
                            ProjectData.omniStrips.add("DJ1R");
                            ProjectData.omniStrips.add("DJ2L");
                            ProjectData.omniStrips.add("DJ2R");
                            ProjectData.omniStrips.add("DJ3L");
                            ProjectData.omniStrips.add("DJ3R");
                            ProjectData.omniStrips.add("DJ4L");
                            ProjectData.omniStrips.add("DJ4R");
                            ProjectData.omniStrips.add("DJ5L");
                            ProjectData.omniStrips.add("DJ5R");
                            ProjectData.omniStrips.add("DJ6L");
                            ProjectData.omniStrips.add("DJ6R");
                        }
                        break;

                }
                //screen
                String scrSel = screenNumber.getSelectedItem().toString();
                switch (scrSel) {
                    case "1":
                        if (screenOnStage.isSelected()) {
                            ProjectData.extraStrips.add("ScrL");
                            ProjectData.extraStrips.add("ScrR");
                        } else {
                            ProjectData.omniStrips.add("ScrL");
                            ProjectData.omniStrips.add("ScrR");
                        }
                        break;
                    case "2":
                        if (screenOnStage.isSelected()) {
                            ProjectData.extraStrips.add("Sc1L");
                            ProjectData.extraStrips.add("Sc1R");
                            ProjectData.extraStrips.add("Sc2L");
                            ProjectData.extraStrips.add("Sc2R");
                        } else {
                            ProjectData.omniStrips.add("Sc1L");
                            ProjectData.omniStrips.add("Sc1R");
                            ProjectData.omniStrips.add("Sc2L");
                            ProjectData.omniStrips.add("Sc2R");
                        }
                        break;
                    case "3":
                        if (screenOnStage.isSelected()) {
                            ProjectData.extraStrips.add("Sc1L");
                            ProjectData.extraStrips.add("Sc1R");
                            ProjectData.extraStrips.add("Sc2L");
                            ProjectData.extraStrips.add("Sc2R");
                            ProjectData.extraStrips.add("Sc3L");
                            ProjectData.extraStrips.add("Sc3R");
                        } else {
                            ProjectData.omniStrips.add("Sc1L");
                            ProjectData.omniStrips.add("Sc1R");
                            ProjectData.omniStrips.add("Sc2L");
                            ProjectData.omniStrips.add("Sc2R");
                            ProjectData.omniStrips.add("Sc3L");
                            ProjectData.omniStrips.add("Sc3R");
                        }
                        break;
                    case "4":
                        if (screenOnStage.isSelected()) {
                            ProjectData.extraStrips.add("Sc1L");
                            ProjectData.extraStrips.add("Sc1R");
                            ProjectData.extraStrips.add("Sc2L");
                            ProjectData.extraStrips.add("Sc2R");
                            ProjectData.extraStrips.add("Sc3L");
                            ProjectData.extraStrips.add("Sc3R");
                            ProjectData.extraStrips.add("Sc4L");
                            ProjectData.extraStrips.add("Sc4R");
                        } else {
                            ProjectData.omniStrips.add("Sc1L");
                            ProjectData.omniStrips.add("Sc1R");
                            ProjectData.omniStrips.add("Sc2L");
                            ProjectData.omniStrips.add("Sc2R");
                            ProjectData.omniStrips.add("Sc3L");
                            ProjectData.omniStrips.add("Sc3R");
                            ProjectData.omniStrips.add("Sc4L");
                            ProjectData.omniStrips.add("Sc4R");
                        }
                        break;
                    case "5":
                        if (screenOnStage.isSelected()) {
                            ProjectData.extraStrips.add("Sc1L");
                            ProjectData.extraStrips.add("Sc1R");
                            ProjectData.extraStrips.add("Sc2L");
                            ProjectData.extraStrips.add("Sc2R");
                            ProjectData.extraStrips.add("Sc3L");
                            ProjectData.extraStrips.add("Sc3R");
                            ProjectData.extraStrips.add("Sc4L");
                            ProjectData.extraStrips.add("Sc4R");
                            ProjectData.extraStrips.add("Sc5L");
                            ProjectData.extraStrips.add("Sc5R");
                        } else {
                            ProjectData.omniStrips.add("Sc1L");
                            ProjectData.omniStrips.add("Sc1R");
                            ProjectData.omniStrips.add("Sc2L");
                            ProjectData.omniStrips.add("Sc2R");
                            ProjectData.omniStrips.add("Sc3L");
                            ProjectData.omniStrips.add("Sc3R");
                            ProjectData.omniStrips.add("Sc4L");
                            ProjectData.omniStrips.add("Sc4R");
                            ProjectData.omniStrips.add("Sc5L");
                            ProjectData.omniStrips.add("Sc5R");
                        }
                        break;
                    case "6":
                        if (screenOnStage.isSelected()) {
                            ProjectData.extraStrips.add("Sc1L");
                            ProjectData.extraStrips.add("Sc1R");
                            ProjectData.extraStrips.add("Sc2L");
                            ProjectData.extraStrips.add("Sc2R");
                            ProjectData.extraStrips.add("Sc3L");
                            ProjectData.extraStrips.add("Sc3R");
                            ProjectData.extraStrips.add("Sc4L");
                            ProjectData.extraStrips.add("Sc4R");
                            ProjectData.extraStrips.add("Sc5L");
                            ProjectData.extraStrips.add("Sc5R");
                            ProjectData.extraStrips.add("Sc6L");
                            ProjectData.extraStrips.add("Sc6R");
                        } else {
                            ProjectData.omniStrips.add("Sc1L");
                            ProjectData.omniStrips.add("Sc1R");
                            ProjectData.omniStrips.add("Sc2L");
                            ProjectData.omniStrips.add("Sc2R");
                            ProjectData.omniStrips.add("Sc3L");
                            ProjectData.omniStrips.add("Sc3R");
                            ProjectData.omniStrips.add("Sc4L");
                            ProjectData.omniStrips.add("Sc4R");
                            ProjectData.omniStrips.add("Sc5L");
                            ProjectData.omniStrips.add("Sc5R");
                            ProjectData.omniStrips.add("Sc6L");
                            ProjectData.omniStrips.add("Sc6R");
                        }
                        break;
                }
                //host
                String hostSel = hostNumber.getSelectedItem().toString();
                switch (hostSel) {
                    case "1":
                        ProjectData.extraStrips.add("Host");
                        break;
                    case "2":
                        ProjectData.extraStrips.add("Hst1");
                        ProjectData.extraStrips.add("Hst2");
                        break;
                    case "3":
                        ProjectData.extraStrips.add("Hst1");
                        ProjectData.extraStrips.add("Hst2");
                        ProjectData.extraStrips.add("Hst3");
                        break;
                    case "4":
                        ProjectData.extraStrips.add("Hst1");
                        ProjectData.extraStrips.add("Hst2");
                        ProjectData.extraStrips.add("Hst3");
                        ProjectData.extraStrips.add("Hst4");
                        break;
                    case "5":
                        ProjectData.extraStrips.add("Hst1");
                        ProjectData.extraStrips.add("Hst2");
                        ProjectData.extraStrips.add("Hst3");
                        ProjectData.extraStrips.add("Hst4");
                        ProjectData.extraStrips.add("Hst5");
                        break;
                    case "6":
                        ProjectData.extraStrips.add("Hst1");
                        ProjectData.extraStrips.add("Hst2");
                        ProjectData.extraStrips.add("Hst3");
                        ProjectData.extraStrips.add("Hst4");
                        ProjectData.extraStrips.add("Hst5");
                        ProjectData.extraStrips.add("Hst6");
                        break;
                    case "7":
                        ProjectData.extraStrips.add("Hst1");
                        ProjectData.extraStrips.add("Hst2");
                        ProjectData.extraStrips.add("Hst3");
                        ProjectData.extraStrips.add("Hst4");
                        ProjectData.extraStrips.add("Hst5");
                        ProjectData.extraStrips.add("Hst6");
                        ProjectData.extraStrips.add("Hst7");
                        break;
                    case "8":
                        ProjectData.extraStrips.add("Hst1");
                        ProjectData.extraStrips.add("Hst2");
                        ProjectData.extraStrips.add("Hst3");
                        ProjectData.extraStrips.add("Hst4");
                        ProjectData.extraStrips.add("Hst5");
                        ProjectData.extraStrips.add("Hst6");
                        ProjectData.extraStrips.add("Hst7");
                        ProjectData.extraStrips.add("Hst8");
                        break;

                    case "9":
                        ProjectData.extraStrips.add("Hst1");
                        ProjectData.extraStrips.add("Hst2");
                        ProjectData.extraStrips.add("Hst3");
                        ProjectData.extraStrips.add("Hst4");
                        ProjectData.extraStrips.add("Hst5");
                        ProjectData.extraStrips.add("Hst6");
                        ProjectData.extraStrips.add("Hst7");
                        ProjectData.extraStrips.add("Hst8");
                        ProjectData.extraStrips.add("Hst9");
                        break;
                    case "10":
                        ProjectData.extraStrips.add("Hst1");
                        ProjectData.extraStrips.add("Hst2");
                        ProjectData.extraStrips.add("Hst3");
                        ProjectData.extraStrips.add("Hst4");
                        ProjectData.extraStrips.add("Hst5");
                        ProjectData.extraStrips.add("Hst6");
                        ProjectData.extraStrips.add("Hst7");
                        ProjectData.extraStrips.add("Hst8");
                        ProjectData.extraStrips.add("Hst9");
                        ProjectData.extraStrips.add("Hs10");
                        break;
                }
                //click
                String clickSel = clickNumber.getSelectedItem().toString();
                switch (clickSel) {
                    case "1":
                        ProjectData.extraStrips.add("Clik");
                        break;
                    case "2":
                        ProjectData.extraStrips.add("Clk1");
                        ProjectData.extraStrips.add("Clk2");
                        break;
                }
                //extra
                String extSel = extraNumber.getSelectedItem().toString();
                switch (extSel) {
                    case "1":
                        ProjectData.extraStrips.add("Extr");
                        break;
                    case "2":
                        ProjectData.extraStrips.add("Ext1");
                        ProjectData.extraStrips.add("Ext2");
                        break;
                    case "3":
                        ProjectData.extraStrips.add("Ext1");
                        ProjectData.extraStrips.add("Ext2");
                        ProjectData.extraStrips.add("Ext3");
                        break;
                    case "4":
                        ProjectData.extraStrips.add("Ext1");
                        ProjectData.extraStrips.add("Ext2");
                        ProjectData.extraStrips.add("Ext3");
                        ProjectData.extraStrips.add("Ext4");
                        break;
                    case "5":
                        ProjectData.extraStrips.add("Ext1");
                        ProjectData.extraStrips.add("Ext2");
                        ProjectData.extraStrips.add("Ext3");
                        ProjectData.extraStrips.add("Ext4");
                        ProjectData.extraStrips.add("Ext5");
                        break;
                    case "6":
                        ProjectData.extraStrips.add("Ext1");
                        ProjectData.extraStrips.add("Ext2");
                        ProjectData.extraStrips.add("Ext3");
                        ProjectData.extraStrips.add("Ext4");
                        ProjectData.extraStrips.add("Ext5");
                        ProjectData.extraStrips.add("Ext6");
                        break;
                    case "7":
                        ProjectData.extraStrips.add("Ext1");
                        ProjectData.extraStrips.add("Ext2");
                        ProjectData.extraStrips.add("Ext3");
                        ProjectData.extraStrips.add("Ext4");
                        ProjectData.extraStrips.add("Ext5");
                        ProjectData.extraStrips.add("Ext6");
                        ProjectData.extraStrips.add("Ext7");
                        break;
                    case "8":
                        ProjectData.extraStrips.add("Ext1");
                        ProjectData.extraStrips.add("Ext2");
                        ProjectData.extraStrips.add("Ext3");
                        ProjectData.extraStrips.add("Ext4");
                        ProjectData.extraStrips.add("Ext5");
                        ProjectData.extraStrips.add("Ext6");
                        ProjectData.extraStrips.add("Ext7");
                        ProjectData.extraStrips.add("Ext8");
                        break;

                    case "9":
                        ProjectData.extraStrips.add("Ext1");
                        ProjectData.extraStrips.add("Ext2");
                        ProjectData.extraStrips.add("Ext3");
                        ProjectData.extraStrips.add("Ext4");
                        ProjectData.extraStrips.add("Ext5");
                        ProjectData.extraStrips.add("Ext6");
                        ProjectData.extraStrips.add("Ext7");
                        ProjectData.extraStrips.add("Ext8");
                        ProjectData.extraStrips.add("Ext9");
                        break;
                    case "10":
                        ProjectData.extraStrips.add("Ext1");
                        ProjectData.extraStrips.add("Ext2");
                        ProjectData.extraStrips.add("Ext3");
                        ProjectData.extraStrips.add("Ext4");
                        ProjectData.extraStrips.add("Ext5");
                        ProjectData.extraStrips.add("Ext6");
                        ProjectData.extraStrips.add("Ext7");
                        ProjectData.extraStrips.add("Ext8");
                        ProjectData.extraStrips.add("Ext9");
                        ProjectData.extraStrips.add("Ex10");
                        break;
                }
                //room
                String roomSel = roomNumber.getSelectedItem().toString();
                switch (roomSel) {
                    case "1":
                        ProjectData.extraStrips.add("Room");
                        break;
                    case "2":
                        ProjectData.extraStrips.add("Roo1");
                        ProjectData.extraStrips.add("Roo2");
                        break;
                    case "3":
                        ProjectData.extraStrips.add("Roo1");
                        ProjectData.extraStrips.add("Roo2");
                        ProjectData.extraStrips.add("Roo3");
                        break;
                    case "4":
                        ProjectData.extraStrips.add("Roo1");
                        ProjectData.extraStrips.add("Roo2");
                        ProjectData.extraStrips.add("Roo3");
                        ProjectData.extraStrips.add("Roo4");
                        break;
                    case "5":
                        ProjectData.extraStrips.add("Roo1");
                        ProjectData.extraStrips.add("Roo2");
                        ProjectData.extraStrips.add("Roo3");
                        ProjectData.extraStrips.add("Roo4");
                        ProjectData.extraStrips.add("Roo5");
                        break;
                    case "6":
                        ProjectData.extraStrips.add("Roo1");
                        ProjectData.extraStrips.add("Roo2");
                        ProjectData.extraStrips.add("Roo3");
                        ProjectData.extraStrips.add("Roo4");
                        ProjectData.extraStrips.add("Roo5");
                        ProjectData.extraStrips.add("Roo6");
                        break;
                    case "7":
                        ProjectData.extraStrips.add("Roo1");
                        ProjectData.extraStrips.add("Roo2");
                        ProjectData.extraStrips.add("Roo3");
                        ProjectData.extraStrips.add("Roo4");
                        ProjectData.extraStrips.add("Roo5");
                        ProjectData.extraStrips.add("Roo6");
                        ProjectData.extraStrips.add("Roo7");
                        break;
                    case "8":
                        ProjectData.extraStrips.add("Roo1");
                        ProjectData.extraStrips.add("Roo2");
                        ProjectData.extraStrips.add("Roo3");
                        ProjectData.extraStrips.add("Roo4");
                        ProjectData.extraStrips.add("Roo5");
                        ProjectData.extraStrips.add("Roo6");
                        ProjectData.extraStrips.add("Roo7");
                        ProjectData.extraStrips.add("Roo8");
                        break;
                    case "9":
                        ProjectData.extraStrips.add("Roo1");
                        ProjectData.extraStrips.add("Roo2");
                        ProjectData.extraStrips.add("Roo3");
                        ProjectData.extraStrips.add("Roo4");
                        ProjectData.extraStrips.add("Roo5");
                        ProjectData.extraStrips.add("Roo6");
                        ProjectData.extraStrips.add("Roo7");
                        ProjectData.extraStrips.add("Roo8");
                        ProjectData.extraStrips.add("Roo9");
                        break;
                    case "10":
                        ProjectData.extraStrips.add("Roo1");
                        ProjectData.extraStrips.add("Roo2");
                        ProjectData.extraStrips.add("Roo3");
                        ProjectData.extraStrips.add("Roo4");
                        ProjectData.extraStrips.add("Roo5");
                        ProjectData.extraStrips.add("Roo6");
                        ProjectData.extraStrips.add("Roo7");
                        ProjectData.extraStrips.add("Roo8");
                        ProjectData.extraStrips.add("Roo9");
                        ProjectData.extraStrips.add("Ro10");
                        break;
                }
                buttonNext.setEnabled(true);
                otherCannels.setText("Other Channels: " + ((ProjectData.omniStrips.size() + ProjectData.extraStrips.size())));
            }
        });

//Button apply end


//Button back start
        buttonBack.setBounds(100, 360, 100, 40);
        buttonBack.setBorderPainted(true);
        buttonBack.setBackground(Color.orange);
        container.add(buttonBack);

        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                terminateThisWindow();

            }
        });
//Button back end

//Button next start
        buttonNext.setBounds(640, 360, 100, 40);
        buttonNext.setBorderPainted(true);
        buttonNext.setBackground(Color.orange);
        container.add(buttonNext);
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefineInstruments.buttonOthers.setText("Others:" + (ProjectData.omniStrips.size() + ProjectData.extraStrips.size()));
                DefineInstruments.numChannels.setText("All Channels:" + ProjectData.commonChannels());
                terminateThisWindow();
            }

        });
//Button next end

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                int option = JOptionPane.showConfirmDialog(null,
                        "Are you really want to quit?", "Confirm", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (option == JOptionPane.YES_OPTION) {
                    System.exit(0);
                } else if (option == JOptionPane.NO_OPTION) {
                    Others percussion = new Others();
                    percussion.setVisible(true);
                }
            }
        });
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        buttonNext.setEnabled(false);
    }

}

