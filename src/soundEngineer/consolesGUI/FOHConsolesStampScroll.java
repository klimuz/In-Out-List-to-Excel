package soundEngineer.consolesGUI;

import soundEngineer.server.ProjectData;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FOHConsolesStampScroll extends JFrame implements ItemListener {
//memory
    private ArrayList<InputStrip> strips = new ArrayList<>();
    private ArrayList<String> channelNamesMemory;
    private ArrayList<String> stripNamesFrom = new ArrayList<>();
    public static ArrayList<Integer> stripsIdFrom = new ArrayList<>();
//menu
    private JMenu m1 = new JMenu("File");
    private JMenu m2 = new JMenu("Edit");
    private JMenu m3 = new JMenu("Help");
//containers
    private Container mainContainer;
    private Container stripsContainer = new Container();
    private JScrollPane jScrollPane;
//buttons
    private JButton buttonBack = new JButton("Back");
    private JButton buttonNext = new JButton("Next");
    private JButton buttonPrint = new JButton("Print");
    private JButton buttonMove = new JButton("Move");
//common Labels
    private JLabel fromLabel = new JLabel("From");
    private JLabel toLabel = new JLabel("To");
    private JLabel editLabel = new JLabel("Edit");
    private JLabel moveWhatLabel = new JLabel("Move ch :");
    private JLabel moveToLabel = new JLabel("to :");
//text field
    public static JTextField moveWhatText = new JTextField(15);
    public static JTextField moveToText = new JTextField(2);
    public static String moveWhatString = "";
//info area
    private JTextPane infoTextArea = new JTextPane();
//close window
    private void terminateThisWindow(){
        this.dispose();
    }
    private int firstStripId = 1;
//button groups
    private ButtonGroup groupFrom = new ButtonGroup();
    private ButtonGroup groupTo = new ButtonGroup();
//constructor start
    public FOHConsolesStampScroll(String imageFilePath) throws HeadlessException{
        super("In-Out List to Exel : " + ProjectData.projectName);
        this.setIconImage(new ImageIcon("img/logo.png").getImage());
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setBounds(dimension.width/2-350, dimension.height/2-250, 854, 480);
        this.setResizable(false);
//menu start
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
//menu end
//background image start
        try {
            Image backgroundImage = ImageIO.read(new File(imageFilePath));
            setContentPane(new JPanel(new BorderLayout()) {
                @Override public void paintComponent(Graphics g) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(),getHeight(), this);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//background image end
//ram
        channelNamesMemory = new ArrayList<>();
        channelNamesMemory.addAll(ProjectData.inputStrips);


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
//control buttons
        buttonMove.setBounds(600,230,60,40);
        buttonMove.setBackground(Color.RED);
        buttonMove.setBorder(BorderFactory.createBevelBorder(0));
        buttonMove.setFocusPainted(false);
        moveToText.setText("0");
        buttonMove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Integer.parseInt(moveToText.getText()) > 0) {
                   // if (stripsIdFrom.get(0) > Integer.parseInt(moveToText.getText())) {
                        for (int i = 0; i < stripsIdFrom.size(); i++){
                            stripNamesFrom.add(channelNamesMemory.get(stripsIdFrom.get(i)));
                        }
                        channelNamesMemory.removeAll(stripNamesFrom);
                        channelNamesMemory.addAll(Integer.parseInt(moveToText.getText()), stripNamesFrom);
                        System.out.println(channelNamesMemory);
                        stripNamesFrom.clear();
                        stripsIdFrom.clear();
                        moveWhatText.setText("");
                        moveToText.setText("0");
                    createNewMatrix();
                }
                setInfo();
            }
        });
        mainContainer.add(buttonMove);
//text fields
        Container textFieldsContainer = new Container();
        textFieldsContainer.setLayout(new FlowLayout());
        textFieldsContainer.add(moveWhatLabel);
        textFieldsContainer.add(moveWhatText);
        textFieldsContainer.add(moveToLabel);
        textFieldsContainer.add(moveToText);
        textFieldsContainer.setBounds(285,240, 300,30);
        mainContainer.add(textFieldsContainer);
//info area
        infoTextArea.setLayout(new GridLayout(1,2));
        infoTextArea.setBackground(Color.DARK_GRAY);
        infoTextArea.setForeground(Color.yellow);
        infoTextArea.setOpaque(true);
        infoTextArea.setBounds(340, 280, 200,120);
        infoTextArea.setBorder(BorderFactory.createTitledBorder("Info"));
        mainContainer.add(infoTextArea);
//Button next start
        buttonNext.setBounds(640, 360, 100, 40);
        buttonNext.setBorderPainted(true);
        buttonNext.setBackground(Color.orange);
        mainContainer.add(buttonNext);
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setInfo();
            }

        });

        createMatrix();
        setInfo();
    }
//constructor end

    protected void createMatrix() {
        stripsContainer = new Container();
        stripsContainer.setLayout(new FlowLayout());

        strips.clear();
        for (int i = 0; i < channelNamesMemory.size(); i++ ){
            strips.add(i, new InputStrip(i, channelNamesMemory.get(i)));
        }
        for (int i = 1; i < strips.size(); i++){
            stripsContainer.add(strips.get(i));
            groupTo.add(strips.get(i).to);
        }
    jScrollPane = new JScrollPane(stripsContainer);
    jScrollPane.setBounds(40,5,770, 190);
    mainContainer.add(jScrollPane);
    }
    protected void createNewMatrix() {
        stripsContainer = new Container();
        stripsContainer.setLayout(new FlowLayout());

        strips.clear();
        for (int i = 0; i < channelNamesMemory.size(); i++ ){
            strips.add(i, new InputStrip(i, channelNamesMemory.get(i)));
        }
        for (int i = 1; i < strips.size(); i++){
            stripsContainer.add(strips.get(i));
            groupTo.add(strips.get(i).to);
        }
        mainContainer.remove(jScrollPane);
        jScrollPane = new JScrollPane(stripsContainer);
        jScrollPane.setBounds(40,5,770, 190);
        mainContainer.add(jScrollPane);
    }

protected void setInfo(){
    String project = "Project : " + ProjectData.projectName + "\n";
    String function = "Function : FOH\n";
    String console = "Console : " + ProjectData.fohConsoleName + "\n";
    String inputs = "Inputs : " + (ProjectData.inputStrips.size()-1) + "\n";
    String outputs = "Outputs : " + ProjectData.outStrips.size() + "\n";
    String omni = "Omni : " + ProjectData.omniStrips.size();
    infoTextArea.setText(project + function + console +
            inputs + outputs + omni);

}

//if settings changed
    @Override
    public void itemStateChanged(ItemEvent e) {
buttonNext.setEnabled(false);
    }
}

