package soundEngineer.step2;

import soundEngineer.server.GenericToExcel;
import soundEngineer.server.IDRtoExcel;
import soundEngineer.server.ProjectData;
import soundEngineer.server.RIOtoExcel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class NormaliseListsGui extends JFrame {
//memory
    private ArrayList<InputStrip> stripList = new ArrayList<>();
    public static ArrayList<String> inputNamesList;
    public static ArrayList<String> omniNamesList;
    public static ArrayList<String> outNamesList;
    private ArrayList<String> namesToCopyList = new ArrayList<>();
    public static ArrayList<Integer> idToCopyList = new ArrayList<>();
//mode switch
    private JRadioButton inputModeRadButton = new JRadioButton("Inputs");
    private JRadioButton omniModeRadButton = new JRadioButton("Omni");
    private JRadioButton outModeRadButton = new JRadioButton("Outputs");
    private ButtonGroup modeGroup = new ButtonGroup();
//buttons
    private JButton buttonBack = new JButton("Back");
    private JButton buttonNext = new JButton("Next");
    private JButton buttonDelete = new JButton("Delete");
    private JButton buttonReset = new JButton("Reset");
    private JButton buttonAdd = new JButton("Add...");
    private JButton buttonMove = new JButton("Move");
    private JButton buttonSetZero = new JButton("Set 0");
//common Labels
    private JLabel fromLabel = new JLabel("From");
    private JLabel toLabel = new JLabel("To");
    private JLabel editLabel = new JLabel("Edit");
    private JLabel moveWhatLabel = new JLabel("Move ch :");
    private JLabel moveToLabel = new JLabel("to :");
    private JLabel stripsTypeLabel = new JLabel("Input channels");
//containers
    private Container mainContainer;
    private Container stripsContainer = new Container();
    private JScrollPane jScrollPane;
    private Container buttonsContainer;
    private Container modeButtonsContainer;
    private Container checkContainer;

//text field
    private static JTextField moveWhatText = new JTextField(10);
    private static JTextField moveToText = new JTextField(2);
//getters and setters
    public String getMoveWhatText() {
    return moveWhatText.getText();
    }
    public static void setMoveWhatText(String moveWhat) {
        moveWhatText.setText(moveWhat);
    }
    public String getMoveToText() {
        return moveToText.getText();
    }
    public static void setMoveToText(String moveTo) {
        moveToText.setText(moveTo);
    }

    private JCheckBox genericCheck = new JCheckBox("Generic");
    private JCheckBox idrCheck = new JCheckBox("IDR");
    private JCheckBox rioCheck = new JCheckBox("RIO");

    private ButtonGroup groupTo = new ButtonGroup();
//menu
    private JMenu m1 = new JMenu("File");
    private JMenu m2 = new JMenu("Edit");
    private JMenu m3 = new JMenu("Help");
//info area
    private JTextPane infoTextArea = new JTextPane();
//close window
    protected void terminateThisWindow(){
        this.dispose();
    }
//constructor start
    public NormaliseListsGui(String mode) throws HeadlessException{
        super("In-Out List to Exel : " + ProjectData.projectName);
        this.setIconImage(new ImageIcon("img/logo.png").getImage());
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setBounds(dimension.width/2-350, dimension.height/2-250, 854, 480);
        this.setResizable(false);
//X-button
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure?","Really quit?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });
//menu file
        m1.add(new JMenuItem("Open", 'O'));
        m1.add(new JMenuItem("Save", 'S'));
        m1.add(new JMenuItem("Recent"));
        m1.addSeparator();
        JMenuItem exit =  m1.add(new JMenuItem("Exit"));
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
//menu edit
        m2.add(new JMenuItem("Undo"));
        m2.add(new JMenuItem("Redo"));
//menu help
        m3.add(new JMenuItem("About"));
        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.add(m1);
        jMenuBar.add(m2);
        jMenuBar.add(m3);
        jMenuBar.setBackground(Color.green);
        this.setJMenuBar(jMenuBar);
        this.revalidate();
//background image start
        try {
            Image backgroundImage = ImageIO.read(new File("img/blueBgnd.jpg"));
            setContentPane(new JPanel(new BorderLayout()) {
                @Override public void paintComponent(Graphics g) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(),getHeight(), this);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//memory fill
        inputNamesList = new ArrayList<>();
        inputNamesList.addAll(ProjectData.inputStrips);
        omniNamesList = new ArrayList<>();
        omniNamesList.add(0, inputNamesList.get(0));
        omniNamesList.addAll(ProjectData.omniStrips);
        outNamesList = new ArrayList<>();
        outNamesList.add(0, inputNamesList.get(0));
        outNamesList.addAll(ProjectData.outStrips);
//buttons&labels start
//container
        mainContainer = this.getContentPane();
        mainContainer.setLayout(null);

//labels
        editLabel.setBounds(5,18,30,15);
        mainContainer.add(editLabel);
        fromLabel.setBounds(5,115,30,15);
        mainContainer.add(fromLabel);
        toLabel.setBounds(5,140,30,15);
        mainContainer.add(toLabel);
        stripsTypeLabel.setBounds(350,200,200,30);
        stripsTypeLabel.setFont(new Font("", Font.BOLD,20));
        mainContainer.add(stripsTypeLabel);
//text fields
        Container textFieldsContainer = new Container();
        textFieldsContainer.setLayout(new FlowLayout());
        textFieldsContainer.add(moveWhatLabel);
        textFieldsContainer.add(moveWhatText);
        textFieldsContainer.add(moveToLabel);
        textFieldsContainer.add(moveToText);
        textFieldsContainer.add(buttonSetZero);
        textFieldsContainer.setBounds(280,230, 300,30);
        mainContainer.add(textFieldsContainer);
//info area
        infoTextArea.setLayout(new GridLayout(1,2));
        infoTextArea.setBackground(Color.DARK_GRAY);
        infoTextArea.setForeground(Color.yellow);
        infoTextArea.setOpaque(true);
        infoTextArea.setBounds(595,210, 200,120);
        infoTextArea.setBorder(BorderFactory.createTitledBorder("Info"));
        mainContainer.add(infoTextArea);
//buttons
        buttonsContainer = new Container();
        buttonsContainer.setLayout(new GridLayout(2, 2));

        buttonMove.setBackground(Color.RED);
        buttonMove.setBorder(BorderFactory.createBevelBorder(0));
        buttonMove.setFocusPainted(false);
        moveToText.setText("0");
        buttonsContainer.add(buttonMove);
        buttonMove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Integer.parseInt(getMoveToText()) > 0) {
                    switch (modeGroup.getSelection().getActionCommand()){
                        case "in":
                            for (int i = 0; i < idToCopyList.size(); i++){
                                namesToCopyList.add(inputNamesList.get(idToCopyList.get(i)));
                            }
                            inputNamesList.removeAll(namesToCopyList);
                            inputNamesList.addAll(Integer.parseInt(getMoveToText()), namesToCopyList);
                            break;
                        case "omni":
                            for (int i = 0; i < idToCopyList.size(); i++){
                                namesToCopyList.add(omniNamesList.get(idToCopyList.get(i)));
                            }
                            omniNamesList.removeAll(namesToCopyList);
                            omniNamesList.addAll(Integer.parseInt(getMoveToText()), namesToCopyList);
                            break;
                        case "out":
                            for (int i = 0; i < idToCopyList.size(); i++){
                                namesToCopyList.add(outNamesList.get(idToCopyList.get(i)));
                            }
                            outNamesList.removeAll(namesToCopyList);
                            outNamesList.addAll(Integer.parseInt(getMoveToText()), namesToCopyList);
                            break;
                    }
                    namesToCopyList.clear();
                    idToCopyList.clear();
                    setMoveWhatText("");
                    setMoveToText("0");
                    createNewMatrix();
                }
                setInfo();
            }
        });

        buttonAdd.setBackground(Color.RED);
        buttonAdd.setBorder(BorderFactory.createBevelBorder(0));
        buttonAdd.setFocusPainted(false);
        buttonsContainer.add(buttonAdd);
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Integer.parseInt(getMoveToText()) > 0){
                    switch (modeGroup.getSelection().getActionCommand()){
                        case "in": inputNamesList.add((Integer.parseInt(getMoveToText())), "");break;
                        case "omni": omniNamesList.add((Integer.parseInt(getMoveToText())), "");break;
                        case "out": outNamesList.add((Integer.parseInt(getMoveToText())), "");break;
                    }
                    createNewMatrix();
                }
                setInfo();
            }
        });

        buttonDelete.setBackground(Color.RED);
        buttonDelete.setBorder(BorderFactory.createBevelBorder(0));
        buttonDelete.setFocusPainted(false);
        buttonsContainer.add(buttonDelete);
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Integer.parseInt(getMoveToText()) == 0){
                    switch (modeGroup.getSelection().getActionCommand()){
                        case "in":
                            for (int i = 0; i < idToCopyList.size(); i++){
                                namesToCopyList.add(inputNamesList.get(idToCopyList.get(i)));
                            }
                            inputNamesList.removeAll(namesToCopyList);
                            break;
                        case "omni":
                            for (int i = 0; i < idToCopyList.size(); i++){
                                namesToCopyList.add(omniNamesList.get(idToCopyList.get(i)));
                            }
                            omniNamesList.removeAll(namesToCopyList);
                            break;
                        case "out":
                            for (int i = 0; i < idToCopyList.size(); i++){
                                namesToCopyList.add(outNamesList.get(idToCopyList.get(i)));
                            }
                            outNamesList.removeAll(namesToCopyList);
                            break;
                    }
                    namesToCopyList.clear();
                    idToCopyList.clear();
                    setMoveWhatText("");
                    setMoveToText("");
                    createNewMatrix();
                }
            }
        });

        buttonReset.setBackground(Color.RED);
        buttonReset.setBorder(BorderFactory.createBevelBorder(0));
        buttonReset.setFocusPainted(false);
        buttonsContainer.add(buttonReset);
        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (modeGroup.getSelection().getActionCommand()){
                    case "in":
                    inputNamesList.clear();
                    inputNamesList.addAll(ProjectData.inputStrips);
                    break;
                    case "omni":
                        omniNamesList.clear();
                        omniNamesList.addAll(ProjectData.omniStrips);
                        break;
                    case "out":
                        outNamesList.clear();
                        outNamesList.addAll(ProjectData.outStrips);
                        break;
                }
                setMoveWhatText("");
                setMoveToText("");
                createNewMatrix();
            }
        });
        buttonsContainer.setBounds(60,200,200,120);
        mainContainer.add(buttonsContainer);

        buttonSetZero.setBackground(Color.BLUE);
        buttonSetZero.setForeground(Color.YELLOW);
        buttonSetZero.setBorder(BorderFactory.createBevelBorder(0));
        buttonSetZero.setFocusPainted(false);
        buttonSetZero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveToText.setText("0");
                createNewMatrix();
            }
        });

        modeButtonsContainer = new Container();
        modeButtonsContainer.setLayout(new GridLayout(1, 3));
        modeButtonsContainer.setBounds(50,330,220,20);
        modeButtonsContainer.add(inputModeRadButton);
        modeButtonsContainer.add(omniModeRadButton);
        modeButtonsContainer.add(outModeRadButton);
        modeGroup.add(inputModeRadButton);
        modeGroup.add(omniModeRadButton);
        modeGroup.add(outModeRadButton);
        inputModeRadButton.setActionCommand("in");
        omniModeRadButton.setActionCommand("omni");
        outModeRadButton.setActionCommand("out");
        inputModeRadButton.setBackground(Color.green);
        omniModeRadButton.setBackground(Color.yellow);
        outModeRadButton.setBackground(Color.red);
        inputModeRadButton.setSelected(true);
        mainContainer.add(modeButtonsContainer);

        inputModeRadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewMatrix();
            }
        });
        omniModeRadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewMatrix();
            }
        });
        outModeRadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewMatrix();
            }
        });
//check boxes
        checkContainer = new Container();
        checkContainer.setLayout(new GridLayout(3,1));
        checkContainer.setBounds(370,270,200,80);
        checkContainer.add(genericCheck);
        checkContainer.add(idrCheck);
        checkContainer.add(rioCheck);
        genericCheck.setOpaque(false);
        genericCheck.setFocusPainted(false);
        genericCheck.setSelected(true);
        idrCheck.setOpaque(false);
        idrCheck.setFocusPainted(false);
        rioCheck.setOpaque(false);
        rioCheck.setFocusPainted(false);
        mainContainer.add(checkContainer);
//Button next start
        buttonNext.setBounds(640, 360, 100, 40);
        buttonNext.setBorderPainted(true);
        buttonNext.setBackground(Color.orange);
        mainContainer.add(buttonNext);
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OutDirectoryChooser outDirectoryChooser = new OutDirectoryChooser();
                outDirectoryChooser.setVisible(true);
                if (genericCheck.isSelected()) {
                    GenericToExcel genericToExcel = new GenericToExcel();
                try {
                    genericToExcel.inputListGenericToExel(inputNamesList);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                }
                if (idrCheck.isSelected()){
                    IDRtoExcel idRtoExcel = new IDRtoExcel();
                    try{
                        idRtoExcel.inputListIDRtoExel(inputNamesList);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                if (rioCheck.isSelected()){
                    RIOtoExcel riOtoExcel = new RIOtoExcel();
                    try{
                        riOtoExcel.inputListRIOtoExel(inputNamesList);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }

        });
//Button back start
        buttonBack.setBounds(100, 360, 100, 40);
        buttonBack.setBorderPainted(true);
        buttonBack.setBackground(Color.orange);
        mainContainer.add(buttonBack);

        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectData.defineInstruments.setVisible(true);
                terminateThisWindow();

            }
        });
        createMatrix();
    }

//matrix creators
    private void createMatrix() {
    stripsContainer = new Container();
    stripsContainer.setLayout(new FlowLayout());
    stripList.clear();

    switch (modeGroup.getSelection().getActionCommand()){
        case "in":
            stripsTypeLabel.setText("Input channels");
            for (int i = 0; i < inputNamesList.size(); i++ ){
                stripList.add(i, new InputStrip(i, inputNamesList.get(i)));
            }
            for (int i = 1; i < stripList.size(); i++){
                stripsContainer.add(stripList.get(i));
                groupTo.add(stripList.get(i).to);
            }
            break;
        case "omni":
            stripsTypeLabel.setText("Omni channels");
            for (int i = 0; i < omniNamesList.size(); i++ ){
                stripList.add(i, new InputStrip(i, omniNamesList.get(i)));
            }
            for (int i = 1; i < stripList.size(); i++){
                stripsContainer.add(stripList.get(i));
                groupTo.add(stripList.get(i).to);
            }
            break;
        case "out":
            stripsTypeLabel.setText("Out channels");
            for (int i = 0; i < outNamesList.size(); i++ ){
                stripList.add(i, new InputStrip(i, outNamesList.get(i)));
            }
            for (int i = 1; i < stripList.size(); i++){
                stripsContainer.add(stripList.get(i));
                groupTo.add(stripList.get(i).to);
            }
            break;
    }
    jScrollPane = new JScrollPane(stripsContainer);
    jScrollPane.setBounds(40,5,770, 190);
    mainContainer.add(jScrollPane);
    setInfo();
}
    private void createNewMatrix() {
        stripsContainer = new Container();
        stripsContainer.setLayout(new FlowLayout());
        stripList.clear();
        switch (modeGroup.getSelection().getActionCommand()){
            case "in":
                stripsTypeLabel.setText("Input channels");
                for (int i = 0; i < inputNamesList.size(); i++ ){
                    stripList.add(i, new InputStrip(i, inputNamesList.get(i)));
                }
                for (int i = 1; i < stripList.size(); i++){
                    stripsContainer.add(stripList.get(i));
                    groupTo.add(stripList.get(i).to);
                }
                break;
            case "omni":
                stripsTypeLabel.setText("Omni channels");
                for (int i = 0; i < omniNamesList.size(); i++ ){
                    stripList.add(i, new InputStrip(i, omniNamesList.get(i)));
                }
                for (int i = 1; i < stripList.size(); i++){
                    stripsContainer.add(stripList.get(i));
                    groupTo.add(stripList.get(i).to);
                }
                break;
            case "out":
                stripsTypeLabel.setText("Out channels");
                for (int i = 0; i < outNamesList.size(); i++ ){
                    stripList.add(i, new InputStrip(i, outNamesList.get(i)));
                }
                for (int i = 1; i < stripList.size(); i++){
                    stripsContainer.add(stripList.get(i));
                    groupTo.add(stripList.get(i).to);
                }
                break;
        }
        mainContainer.remove(jScrollPane);
        jScrollPane = new JScrollPane(stripsContainer);
        jScrollPane.setBounds(40,5,770, 190);
        mainContainer.add(jScrollPane);
        setInfo();
    }
    private void setInfo(){
        String project = "Project : " + ProjectData.projectName + "\n";
        String function = "Function : FOH\n";
        String console = "Console : " + inputNamesList.get(0) + "\n";
        String inputs = "InputChannels : " + (inputNamesList.size()-1) + "\n";
        String outputs = "Outputs : " + (outNamesList.size()-1) + "\n";
        String omni = "Omni : " + (omniNamesList.size()-1);
        infoTextArea.setText(project + function + console +
                inputs + outputs + omni);

    }
}
