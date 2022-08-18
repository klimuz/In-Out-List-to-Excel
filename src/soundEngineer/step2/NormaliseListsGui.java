package soundEngineer.step2;

import soundEngineer.server.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;

public class NormaliseListsGui extends JFrame {
//memory
    public static ArrayList<ChannelStrip> stripList = new ArrayList<>();
    public static ArrayList<ChannelStrip> stripsToCopyList = new ArrayList<>();
    public static ArrayList<String> inputNamesList;
    public static ArrayList<String> omniNamesList;
    public static ArrayList<String> outNamesList;
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
    private static Container stripsContainer;
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
    private ButtonGroup chkBoxGroup = new ButtonGroup();

    private static ButtonGroup groupTo = new ButtonGroup();
//menu
    private JMenu m1 = new JMenu("File");
    private JMenu m2 = new JMenu("Edit");
    private JMenu m3 = new JMenu("Help");
//info area
    private static JTextPane infoTextArea = new JTextPane();
//close window
    protected void terminateThisWindow(){
        this.dispose();
    }
//constructor start
    public NormaliseListsGui(String mode) throws HeadlessException{
        super("In-Out List to Exel : " + ProjectData.projectName);
        this.setIconImage(ResourceLoader.getImage("logo.png"));
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setBounds(dimension.width/2-350, dimension.height/2-250, 854, 480);
        this.setResizable(false);
//X-button
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure?","Really quit?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    System.exit(0);
                }else {}
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
                setContentPane(new JPanel(new BorderLayout()) {
                @Override public void paintComponent(Graphics g) {
                    g.drawImage(ResourceLoader.getImage("blueBgnd.jpg"), 0, 0, getWidth(),getHeight(), this);
                }
            });
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
        buttonMove.setToolTipText("Select \"From\" and \"To\"");
        moveToText.setText("0");
        buttonsContainer.add(buttonMove);
        buttonMove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Integer.parseInt(getMoveToText()) > 0) {
                    for (int i = 0; i < idToCopyList.size(); i++){
                        stripsToCopyList.add(stripList.get(idToCopyList.get(i)));
                    }
                    stripList.removeAll(stripsToCopyList);
                    if (Integer.parseInt(getMoveToText()) < idToCopyList.get(0)) {
                        stripList.addAll(Integer.parseInt(getMoveToText()), stripsToCopyList);
                    }else {
                        stripList.addAll(Integer.parseInt(getMoveToText()) - stripsToCopyList.size(), stripsToCopyList);
                    }
                    recreateMatrix();
                    stripsToCopyList.clear();
                    idToCopyList.clear();
                    setMoveWhatText("");
                    setMoveToText("");
                }
                setInfo();
            }
        });

        buttonAdd.setBackground(Color.RED);
        buttonAdd.setBorder(BorderFactory.createBevelBorder(0));
        buttonAdd.setFocusPainted(false);
        buttonAdd.setToolTipText("Select \"To\"");
        buttonsContainer.add(buttonAdd);
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Integer.parseInt(getMoveToText()) > 0){
                    stripList.add(Integer.parseInt(getMoveToText()), new ChannelStrip(Integer.parseInt(getMoveToText()), "", "", ""));
                    recreateMatrix();
                }
                setInfo();
            }
        });

        buttonDelete.setBackground(Color.RED);
        buttonDelete.setBorder(BorderFactory.createBevelBorder(0));
        buttonDelete.setFocusPainted(false);
        buttonDelete.setToolTipText("Select \"From\"");
        buttonsContainer.add(buttonDelete);
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < idToCopyList.size(); i++){
                    stripsToCopyList.add(stripList.get(idToCopyList.get(i)));
                }
                stripList.removeAll(stripsToCopyList);
                stripsToCopyList.clear();
                idToCopyList.clear();
                setMoveWhatText("");
                setMoveToText("");
                recreateMatrix();
            }
        });

        buttonReset.setBackground(Color.RED);
        buttonReset.setBorder(BorderFactory.createBevelBorder(0));
        buttonReset.setFocusPainted(false);
        buttonsContainer.add(buttonReset);
        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                terminateThisWindow();
                NormaliseListsGui normaliseListsGui = new NormaliseListsGui("in");
                normaliseListsGui.setVisible(true);
                setMoveToText("");
                createMatrix();

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
                recreateMatrix();
            }
        });
//mode buttons
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
        omniModeRadButton.setToolTipText("For future use");
        outModeRadButton.setToolTipText("For future use");
        mainContainer.add(modeButtonsContainer);

        omniModeRadButton.setEnabled(false);
        outModeRadButton.setEnabled(false);

        inputModeRadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recreateMatrix();
            }
        });
        omniModeRadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recreateMatrix();
            }
        });
        outModeRadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recreateMatrix();
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
        chkBoxGroup.add(genericCheck);
        chkBoxGroup.add(idrCheck);
        chkBoxGroup.add(rioCheck);


//Button next start
        buttonNext.setBounds(640, 360, 100, 40);
        buttonNext.setBorderPainted(true);
        buttonNext.setBackground(Color.orange);
        mainContainer.add(buttonNext);
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new OutDirectoryChooser();
                if (genericCheck.isSelected()) {
                    GenericToExcel genericToExcel = new GenericToExcel();
                try {
                    genericToExcel.inputListGenericToExel(stripList);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                }
                if (idrCheck.isSelected()){
                    IDRtoExcel idRtoExcel = new IDRtoExcel();
                    try{
                        idRtoExcel.inputListIDRtoExel(stripList);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                if (rioCheck.isSelected()){
                    RIOtoExcel riOtoExcel = new RIOtoExcel();
                    try{
                        riOtoExcel.inputListRIOtoExel(stripList);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                //terminateThisWindow();
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
        fillMatrix();
        jScrollPane = new JScrollPane(stripsContainer);
        jScrollPane.setBounds(40,5,770, 190);
        mainContainer.add(jScrollPane);
        setInfo();
    }
    public static void recreateMatrix() {
        inputNamesList.clear();
        inputNamesList.add(0, ProjectData.projectName);
        stripsContainer.removeAll();
        for (int i = 1; i < stripList.size(); i++){
            stripList.get(i).setId(i);
            stripList.get(i).from.setSelected(false);
            stripList.get(i).to.setSelected(false);
            stripList.get(i).setColor();
            stripsContainer.add(stripList.get(i));
            inputNamesList.add(i, stripList.get(i).getStripName());
            groupTo.add(stripList.get(i).to);
        }
        setInfo();
    }
    private void fillMatrix(){
        switch (modeGroup.getSelection().getActionCommand()){
            case "in":
                stripsTypeLabel.setText("Input channels");
                for (int i = 0; i < inputNamesList.size(); i++ ){
                    stripList.add(i, new ChannelStrip(i, inputNamesList.get(i),
                            NamesAndPickup.getChannelPickup(inputNamesList.get(i)), ""));
                    stripList.get(i).from.setSelected(false);
                    stripList.get(i).to.setSelected(false);
                }
                break;
            case "omni":
                stripsTypeLabel.setText("Omni channels");
                for (int i = 1; i < ProjectData.omniStrips.size(); i++ ){
                    stripList.add(i, new ChannelStrip(i, ProjectData.omniStrips.get(i),
                            NamesAndPickup.getChannelPickup(ProjectData.omniStrips.get(i)), ""));
                }
                break;
            case "out":
                stripsTypeLabel.setText("Out channels");
                for (int i = 1; i < ProjectData.outStrips.size(); i++ ){
                    stripList.add(i, new ChannelStrip(i, ProjectData.outStrips.get(i),
                            NamesAndPickup.getChannelPickup(ProjectData.outStrips.get(i)), ""));
                }
                break;
        }
        for (int i = 1; i < stripList.size(); i++){
            stripsContainer.add(stripList.get(i));
            groupTo.add(stripList.get(i).to);
        }
    }
    private static void setInfo(){
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
