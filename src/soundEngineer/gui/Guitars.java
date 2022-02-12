package soundEngineer.gui;

import soundEngineer.server.ProjectData;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class Guitars extends JFrame implements ItemListener {
    private JMenuBar jMenuBar = new JMenuBar();
    JMenu m1 = new JMenu("File");
    JMenu m2 = new JMenu("Help");
    private JButton buttonBack = new JButton("Back");
    private JButton buttonApply = new JButton("Apply");
    private JButton buttonNext = new JButton("Next");
    private JLabel defineGuitarsLabel = new JLabel("Define Guitar channels quantity:");
    private JLabel bassGuitarLabel = new JLabel("Bass Guitar:");
    private JLabel elGuitarLabel = new JLabel("Electro Guitar:");
    private JLabel accGuitarsLabel = new JLabel("Accoustic Guitar:");
    private JLabel guitarChannels = new JLabel("Guitar Channels: " + ProjectData.guitarStrips.size());
    //private JLabel monoBassLabel = new JLabel("Mono");
    //private JLabel stereoBassLabel = new JLabel("Stereo");
    //private JLabel noBassLabel = new JLabel("No one");
    private JLabel monoEGuitarLabel = new JLabel("Mono:");
    private JLabel stereoEGuitarLabel = new JLabel("Stereo:");
    private JLabel monoAGuitarLabel = new JLabel("Mono:");
    private JLabel stereoAGuitarLabel = new JLabel("Stereo:");

    private JRadioButton monoBassRadioButton = new JRadioButton("Mono");
    private JRadioButton stereoBassRadioButton = new JRadioButton("Stereo");
    private JRadioButton noBassRadioButton = new JRadioButton("No one");

    private JComboBox<Integer> monoEGuitarsNumber = new JComboBox();
    private JComboBox<Integer> stereoEGuitarsNumber = new JComboBox();
    private JComboBox<Integer> monoAGuitarsNumber = new JComboBox();
    private JComboBox<Integer> stereoAGuitarsNumber = new JComboBox();

    public void terminateThisWindow() {
        this.dispose();
    }

    public Guitars() throws HeadlessException {
        super("In-Out List to Exel : " + ProjectData.projectName);
        Font font = new Font("", Font.BOLD, 18);
        Font font1 = new Font("", Font.BOLD, 15);
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
            Image backgroundImage = ImageIO.read(new File("img/guitars.jpg"));
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

//gui elements start
        Container container = this.getContentPane();
        container.setLayout(null);
        defineGuitarsLabel.setFont(font);
        defineGuitarsLabel.setBounds(10, 1, 300, 30);
        container.add(defineGuitarsLabel);

        bassGuitarLabel.setFont(font1);
        bassGuitarLabel.setBounds(100,50,100,20);
        container.add(bassGuitarLabel);
        elGuitarLabel.setFont(font1);
        elGuitarLabel.setBounds(350,50,150,20);
        container.add(elGuitarLabel);
        accGuitarsLabel.setFont(font1);
        accGuitarsLabel.setBounds(600,50,150,20);
        container.add(accGuitarsLabel);
//bass control start
        ButtonGroup group1 = new ButtonGroup();

        monoBassRadioButton.setActionCommand("1");
        monoBassRadioButton.setBackground(Color.green);
        monoBassRadioButton.setBounds(100,75,80,20);
        monoBassRadioButton.setSelected(true);
        container.add(monoBassRadioButton);
        group1.add(monoBassRadioButton);

        stereoBassRadioButton.setActionCommand("2");
        stereoBassRadioButton.setBackground(Color.green);
        stereoBassRadioButton.setBounds(100,100,80,20);
        container.add(stereoBassRadioButton);
        group1.add(stereoBassRadioButton);

        noBassRadioButton.setActionCommand("3");
        noBassRadioButton.setBackground(Color.green);
        noBassRadioButton.setBounds(100,125,80,20);
        container.add(noBassRadioButton);
        group1.add(noBassRadioButton);

        if (ProjectData.guitarStrips.contains("Bass")){
            monoBassRadioButton.setSelected(true);
        }else if (ProjectData.guitarStrips.contains("BasL")){
            stereoBassRadioButton.setSelected(true);
        }else noBassRadioButton.setSelected(true);
//bass control end
        //mono eguitar control start
        monoEGuitarLabel.setOpaque(true);
        monoEGuitarLabel.setBackground(Color.green);
        monoEGuitarLabel.setBounds(350, 75, 80, 20);
        container.add(monoEGuitarLabel);

        monoEGuitarsNumber.addItemListener(this);
        monoEGuitarsNumber.addItem(0);
        monoEGuitarsNumber.addItem(1);
        monoEGuitarsNumber.addItem(2);
        monoEGuitarsNumber.addItem(3);
        monoEGuitarsNumber.setBounds(430, 75, 40, 20);
        container.add(monoEGuitarsNumber);

        if (ProjectData.guitarStrips.contains("EGtr")){
            monoEGuitarsNumber.setSelectedItem(1);
        }else if (ProjectData.guitarStrips.contains("EGt1") && ProjectData.guitarStrips.contains("EGt2") &&
                !ProjectData.guitarStrips.contains("EGt3")){
            monoEGuitarsNumber.setSelectedItem(2);
        }else if (ProjectData.guitarStrips.contains("EGt2") && ProjectData.guitarStrips.contains("EGt3")){
            monoEGuitarsNumber.setSelectedItem(3);
        }else {
            monoEGuitarsNumber.setSelectedItem(0);
        }
        //mono eguitar control end
        //stereo eguitars control start
        stereoEGuitarLabel.setOpaque(true);
        stereoEGuitarLabel.setBackground(Color.green);
        stereoEGuitarLabel.setBounds(350, 100, 80, 20);
        container.add(stereoEGuitarLabel);

        stereoEGuitarsNumber.addItemListener(this);
        stereoEGuitarsNumber.addItem(0);
        stereoEGuitarsNumber.addItem(1);
        stereoEGuitarsNumber.addItem(2);
        stereoEGuitarsNumber.addItem(3);
        stereoEGuitarsNumber.setBounds(430, 100, 40, 20);
        container.add(stereoEGuitarsNumber);

        if (ProjectData.guitarStrips.contains("EGtL")){
            stereoEGuitarsNumber.setSelectedItem(1);
        }else if (ProjectData.guitarStrips.contains("EG1L") && !ProjectData.guitarStrips.contains("EG3L")){
            stereoEGuitarsNumber.setSelectedItem(2);
        }else if (ProjectData.guitarStrips.contains("EG3L")){
            stereoEGuitarsNumber.setSelectedItem(3);
        }else {
            stereoEGuitarsNumber.setSelectedItem(0);
        }
//stereo eguitars control end
        //mono aguitars control start
        monoAGuitarLabel.setOpaque(true);
        monoAGuitarLabel.setBackground(Color.green);
        monoAGuitarLabel.setBounds(600, 75, 80, 20);
        container.add(monoAGuitarLabel);

        monoAGuitarsNumber.addItemListener(this);
        monoAGuitarsNumber.addItem(0);
        monoAGuitarsNumber.addItem(1);
        monoAGuitarsNumber.addItem(2);
        monoAGuitarsNumber.addItem(3);
        monoAGuitarsNumber.setBounds(680, 75, 40, 20);
        container.add(monoAGuitarsNumber);

        if (ProjectData.guitarStrips.contains("AGtr")){
            monoAGuitarsNumber.setSelectedItem(1);
        }else if (ProjectData.guitarStrips.contains("AGt2") && !ProjectData.guitarStrips.contains("AGt3")){
            monoAGuitarsNumber.setSelectedItem(2);
        }else if (ProjectData.guitarStrips.contains("AGt2") && ProjectData.guitarStrips.contains("AGt3")){
            monoAGuitarsNumber.setSelectedItem(3);
        }else {
            monoAGuitarsNumber.setSelectedItem(0);
        }
        //mono aguitars control end

        //stereo aguitars control stsrt
        stereoAGuitarLabel.setOpaque(true);
        stereoAGuitarLabel.setBackground(Color.green);
        stereoAGuitarLabel.setBounds(600, 100, 80, 20);
        container.add(stereoAGuitarLabel);

        stereoAGuitarsNumber.addItemListener(this);
        stereoAGuitarsNumber.addItem(0);
        stereoAGuitarsNumber.addItem(1);
        stereoAGuitarsNumber.addItem(2);
        stereoAGuitarsNumber.addItem(3);
        stereoAGuitarsNumber.setBounds(680, 100, 40, 20);
        container.add(stereoAGuitarsNumber);

        if (ProjectData.guitarStrips.contains("AGtL")){
            stereoAGuitarsNumber.setSelectedItem(1);
        }else if (ProjectData.guitarStrips.contains("AG1L") && !ProjectData.guitarStrips.contains("AG3L")){
            stereoAGuitarsNumber.setSelectedItem(2);
        }else if (ProjectData.guitarStrips.contains("AG3L")){
            stereoAGuitarsNumber.setSelectedItem(3);
        }else {
            stereoAGuitarsNumber.setSelectedItem(0);
        }
        //stereo aguitars control end

        //guitars channels lable setup start
        guitarChannels.setBounds(650, 5, 150, 25);//label
        container.add(guitarChannels);
        //guitars channels lable setup end
//gui elements end
        /*
        bassNumber.addItemListener(this);
        bassNumber.addItem("Mono");
        bassNumber.addItem("Stereo");
        bassNumber.addItem("No One");
        bassNumber.setBounds(100, 130, 100, 20);
        if (ProjectData.guitarStrips.contains("Bass")){
            bassNumber.setSelectedItem("Mono");
        }else if (ProjectData.guitarStrips.contains("BasL"))
        {bassNumber.setSelectedItem("Stereo");}
        container.add(bassNumber);
        elGtrNumber.addItemListener(this);
        elGtrNumber.addItem("1 Mono");//"EGtr"
        elGtrNumber.addItem("2 Mono");//"EGt1"&&"EGt2"&&!"EG3L"
        elGtrNumber.addItem("1 Stereo");//"EGtL"
        elGtrNumber.addItem("2 Stereo");//"EG1L"&&"EG2L"
        elGtrNumber.addItem("1M 1S");//"EGt1"&&"EG2L"&&!"EG3L"
        elGtrNumber.addItem("1M 2S");//"EGt1"&&"EG3L"&&!"EGt2"
        elGtrNumber.addItem("2M 1S");//"EGt2"&&"EG3L"
        elGtrNumber.addItem("No One");
        elGtrNumber.setBounds(350, 130, 120, 20);
        if (ProjectData.guitarStrips.contains("EGtr")){
            elGtrNumber.setSelectedItem("1 Mono");
        }else if (ProjectData.guitarStrips.contains("EGt1") && ProjectData.guitarStrips.contains("EGt2") &&
                !ProjectData.guitarStrips.contains("EG3L")){
        elGtrNumber.setSelectedItem("2 Mono");
        }else if (ProjectData.guitarStrips.contains("EGtL")){
            elGtrNumber.setSelectedItem("1 Stereo");
        }else if (ProjectData.guitarStrips.contains("EG1L") && ProjectData.guitarStrips.contains("EG2L")){
            elGtrNumber.setSelectedItem("2 Stereo");
        }else if (ProjectData.guitarStrips.contains("EGt1") && ProjectData.guitarStrips.contains("EG2L") &&
        !ProjectData.guitarStrips.contains("EG3L")){
            elGtrNumber.setSelectedItem("1M 1S");
        }else if (ProjectData.guitarStrips.contains("EGt1") && ProjectData.guitarStrips.contains("EG3L") &&
                !ProjectData.guitarStrips.contains("EGt2")){
            elGtrNumber.setSelectedItem("1M 2S");
        }else if (ProjectData.guitarStrips.contains("EGt2") && ProjectData.guitarStrips.contains("EG3L")){
            elGtrNumber.setSelectedItem("2M 1S");
        }
        else {
            elGtrNumber.setSelectedItem("No One");
        }
        container.add(elGtrNumber);
        acGtrNumber.addItemListener(this);
        acGtrNumber.addItem("1 Mono");//"AGtr"
        acGtrNumber.addItem("2 Mono");//"AGt1"&&"AGt2"&&!"AG3L"
        acGtrNumber.addItem("1 Stereo");//"AGtL"
        acGtrNumber.addItem("2 Stereo");//"AG1L"&&"AG2L"
        acGtrNumber.addItem("1M 1S");//"AGt1"&&"AG2L"&&!"AG3L"
        acGtrNumber.addItem("1M 2S");//"AGt1"&&"AG3L"&&!"AGt2"
        acGtrNumber.addItem("2M 1S");//"AGt2"&&"AG3L"
        acGtrNumber.addItem("No One");
        acGtrNumber.setBounds(600, 130, 120, 20);
        container.add(acGtrNumber);

        guitarChannels.setBounds(650, 5, 150, 25);//label
        if (ProjectData.guitarStrips.contains("AGtr")){
            acGtrNumber.setSelectedItem("1 Mono");
        }else if (ProjectData.guitarStrips.contains("AGt1") && ProjectData.guitarStrips.contains("AGt2") &&
                !ProjectData.guitarStrips.contains("AG3L")){
            acGtrNumber.setSelectedItem("2 Mono");
        }else if (ProjectData.guitarStrips.contains("AGtL")){
            acGtrNumber.setSelectedItem("1 Stereo");
        }else if (ProjectData.guitarStrips.contains("AG1L") && ProjectData.guitarStrips.contains("AG2L")){
            acGtrNumber.setSelectedItem("2 Stereo");
        }else if (ProjectData.guitarStrips.contains("AGt1") && ProjectData.guitarStrips.contains("AG2L") &&
                !ProjectData.guitarStrips.contains("AG3L")){
            acGtrNumber.setSelectedItem("1M 1S");
        }else if (ProjectData.guitarStrips.contains("AGt1") && ProjectData.guitarStrips.contains("AG3L") &&
                !ProjectData.guitarStrips.contains("AGt2")){
            acGtrNumber.setSelectedItem("1M 2S");
        }else if (ProjectData.guitarStrips.contains("AGt2") && ProjectData.guitarStrips.contains("AG3L")){
            acGtrNumber.setSelectedItem("2M 1S");
        }else {
            acGtrNumber.setSelectedItem("No One");
        }
            container.add(guitarChannels);


//Elements end
*/
//Button apply start
            buttonApply.setBounds(725, 240, 70, 60);
            buttonApply.setBorderPainted(true);
            buttonApply.setBackground(Color.green);
            container.add(buttonApply);
            buttonApply.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    ProjectData.guitarStrips.clear();
                    //bass to arraylist setup
                    String selectedBass = group1.getSelection().getActionCommand();
                    switch (selectedBass){
                        case "1":
                            ProjectData.guitarStrips.add(0, "Bass");
                            break;
                        case "2":
                            ProjectData.guitarStrips.add(0, "BasL");
                            ProjectData.guitarStrips.add(1, "BasR");
                            break;
                    }
//mono eguitars to arraylist setup
                    int selectedMonoEGuitars = (int) monoEGuitarsNumber.getSelectedItem();
                    switch (selectedMonoEGuitars){
                        case 1:
                            ProjectData.guitarStrips.add("EGtr");
                            break;
                        case 2:
                            ProjectData.guitarStrips.add("EGt1");
                            ProjectData.guitarStrips.add("EGt2");
                            break;
                        case 3:
                            ProjectData.guitarStrips.add("EGt1");
                            ProjectData.guitarStrips.add("EGt2");
                            ProjectData.guitarStrips.add("EGt3");
                            break;
                    }
//stereo eguitars to arraylist setup
                    int selectedStereoEGuitars = (int) stereoEGuitarsNumber.getSelectedItem();
                    switch (selectedStereoEGuitars){
                        case 1:
                            ProjectData.guitarStrips.add("EGtL");
                            ProjectData.guitarStrips.add("EGtR");
                            break;
                        case 2:
                            ProjectData.guitarStrips.add("EG1L");
                            ProjectData.guitarStrips.add("EG1R");
                            ProjectData.guitarStrips.add("EG2L");
                            ProjectData.guitarStrips.add("EG2R");
                            break;
                        case 3:
                            ProjectData.guitarStrips.add("EG1L");
                            ProjectData.guitarStrips.add("EG1R");
                            ProjectData.guitarStrips.add("EG2L");
                            ProjectData.guitarStrips.add("EG2R");
                            ProjectData.guitarStrips.add("EG3L");
                            ProjectData.guitarStrips.add("EG3R");
                            break;
                    }
                    //mono aguitars to arraylist setup
                    int selectedMonoAGuitars = (int) monoAGuitarsNumber.getSelectedItem();
                    switch (selectedMonoAGuitars){
                        case 1:
                            ProjectData.guitarStrips.add("AGtr");
                            break;
                        case 2:
                            ProjectData.guitarStrips.add("AGt1");
                            ProjectData.guitarStrips.add("AGt2");
                            break;
                        case 3:
                            ProjectData.guitarStrips.add("AGt1");
                            ProjectData.guitarStrips.add("AGt2");
                            ProjectData.guitarStrips.add("AGt3");
                            break;
                    }
//mono eguitars to arraylist setup
                    int selectedStereoAGuitars = (int) stereoAGuitarsNumber.getSelectedItem();
                    switch (selectedStereoAGuitars){
                        case 1:
                            ProjectData.guitarStrips.add("AGtL");
                            ProjectData.guitarStrips.add("AGtR");
                            break;
                        case 2:
                            ProjectData.guitarStrips.add("AG1L");
                            ProjectData.guitarStrips.add("AG1R");
                            ProjectData.guitarStrips.add("AG2L");
                            ProjectData.guitarStrips.add("AG2R");
                            break;
                        case 3:
                            ProjectData.guitarStrips.add("AG1L");
                            ProjectData.guitarStrips.add("AG1R");
                            ProjectData.guitarStrips.add("AG2L");
                            ProjectData.guitarStrips.add("AG2R");
                            ProjectData.guitarStrips.add("AG3L");
                            ProjectData.guitarStrips.add("AG3R");
                            break;
                    }
                    buttonNext.setEnabled(true);
                    guitarChannels.setText("Guitar Channels: " + ProjectData.guitarStrips.size());
                    //System.out.println(ProjectData.guitarStrips);
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
            buttonNext.setEnabled(false);
            buttonNext.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DefineInstruments.buttonGuitars.setText("Guitars:" + ProjectData.guitarStrips.size());
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
                    }else if (option == JOptionPane.NO_OPTION){
                        Guitars guitars = new Guitars();
                        guitars.setVisible(true);
                    }
                }
            });
        }
    @Override
    public void itemStateChanged(ItemEvent e) {
        buttonNext.setEnabled(false);
    }
}
