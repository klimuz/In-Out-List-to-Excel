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

public class FOHConsolesStamp extends JFrame implements ItemListener {
//memory
    public static ArrayList<InputStrip> strips;
//menu
    private JMenu m1 = new JMenu("File");
    private JMenu m2 = new JMenu("Edit");
    private JMenu m3 = new JMenu("Help");
//containers
    private Container mainContainer;
    private Container stripsContainer = new Container();
//buttons
    private JButton buttonBack = new JButton("Back");
    private JButton buttonNext = new JButton("Next");
    private JButton buttonPrint = new JButton("Print");
    private JButton buttonMove = new JButton("Move");
    private JButton forwardButton = new JButton(">");
    private JButton backwardButton = new JButton("<");
    private JButton farForwardButton = new JButton(">>");
    private JButton farBackwardButton = new JButton("<<");
//common Labels
    private JLabel consoleNameLabel = new JLabel("PM5D");
    private JLabel allChannelsLabel = new JLabel("All Channels:");
    private JLabel fromLabel = new JLabel("From");
    private JLabel toLabel = new JLabel("To");
    private JLabel editLabel = new JLabel("Edit");
    private JLabel moveWhatLabel = new JLabel("Move ch :");
    private JLabel moveToLabel = new JLabel("to :");
//text field
    private JTextField moveWhatText = new JTextField(15);
    private JTextField moveToText = new JTextField(2);
//info area
    private JTextPane infoTextArea = new JTextPane();
//fonts
    private Font headerFont = new Font("",Font.BOLD,20);
    private Font labelsFont = new Font("",Font.BOLD,20);
    private Font channelFont = new Font("",Font.ITALIC,15);
//close window
    private void terminateThisWindow(){
        this.dispose();
    }
    private int firstStripId = 1;
//constructor start
    public FOHConsolesStamp(String imageFilePath) throws HeadlessException{
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
        strips = new ArrayList<>();
        for (int i = 0; i < ProjectData.inputStrips.size(); i++ ){
            strips.add(i, new InputStrip(i, ProjectData.inputStrips.get(i)));
        }
//buttons&labels start
//container
        mainContainer = this.getContentPane();
        mainContainer.setLayout(null);
//labels
        editLabel.setBounds(5,20,30,15);
        mainContainer.add(editLabel);
        fromLabel.setBounds(5,160,30,15);
        mainContainer.add(fromLabel);
        toLabel.setBounds(5,185,30,15);
        mainContainer.add(toLabel);
//control buttons
        farBackwardButton.setBounds(300,210,60,20);
        farBackwardButton.setBackground(Color.GRAY);
        farBackwardButton.setBorder(BorderFactory.createBevelBorder(0));
        farBackwardButton.setFocusPainted(false);
        if (firstStripId == 1){
            farBackwardButton.setEnabled(false);
        }
        mainContainer.add(farBackwardButton);

        backwardButton.setBounds(365,210,60,20);
        backwardButton.setBackground(Color.GRAY);
        backwardButton.setBorder(BorderFactory.createBevelBorder(0));
        backwardButton.setFocusPainted(false);
        backwardButton.setEnabled(false);
        backwardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (firstStripId > 1){
                    firstStripId--;
                    createMatrix(firstStripId);
                }
                if (firstStripId+12 < strips.size()){forwardButton.setEnabled(true);}
                if (firstStripId==1){backwardButton.setEnabled(false);}
            }
        });
        mainContainer.add(backwardButton);

        forwardButton.setBounds(425,210,60,20);
        forwardButton.setBackground(Color.GRAY);
        forwardButton.setBorder(BorderFactory.createBevelBorder(0));
        forwardButton.setFocusPainted(false);
        if (firstStripId + 12 >= strips.size()){forwardButton.setEnabled(false);}
        forwardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (firstStripId + 12 < strips.size()) {
                    firstStripId++;
                    createMatrix(firstStripId);
                }
                if (firstStripId > 1){backwardButton.setEnabled(true);}
                if (firstStripId + 12 >= strips.size()){forwardButton.setEnabled(false);}
            }
        });
        mainContainer.add(forwardButton);

        farForwardButton.setBounds(490,210,60,20);
        farForwardButton.setBackground(Color.GRAY);
        farForwardButton.setBorder(BorderFactory.createBevelBorder(0));
        farForwardButton.setFocusPainted(false);
        mainContainer.add(farForwardButton);

        buttonMove.setBounds(600,210,60,60);
        buttonMove.setBackground(Color.RED);
        buttonMove.setBorder(BorderFactory.createBevelBorder(0));
        buttonMove.setFocusPainted(false);
        buttonMove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setInfo();
            }
        });
        mainContainer.add(buttonMove);
//hand dial move
        Container dialMoveContainer = new Container();
        dialMoveContainer.setLayout(new FlowLayout());
        dialMoveContainer.add(moveWhatLabel);
        dialMoveContainer.add(moveWhatText);
        dialMoveContainer.add(moveToLabel);
        dialMoveContainer.add(moveToText);
        dialMoveContainer.setBounds(285,240, 300,30);
        mainContainer.add(dialMoveContainer);
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

        createMatrix(firstStripId);
        setInfo();

    }
//constructor end
//create 1st page


    protected void createMatrix(int firstStrip) {
//containers for strips rows (8 strips in each row)


        stripsContainer.setLayout(new GridLayout(1, 12));
        stripsContainer.setBounds(40,5,770, 200);
        stripsContainer.removeAll();
        stripsContainer.revalidate();


            InputStrip inputStrip1 = strips.get(firstStrip);
            InputStrip inputStrip2 = strips.get(firstStrip+1);
            InputStrip inputStrip3 = strips.get(firstStrip+2);
            InputStrip inputStrip4 = strips.get(firstStrip+3);
            InputStrip inputStrip5 = strips.get(firstStrip+4);
            InputStrip inputStrip6 = strips.get(firstStrip+5);
            InputStrip inputStrip7 = strips.get(firstStrip+6);
            InputStrip inputStrip8 = strips.get(firstStrip+7);
            InputStrip inputStrip9 = strips.get(firstStrip+8);
            InputStrip inputStrip10 = strips.get(firstStrip+9);
            InputStrip inputStrip11 = strips.get(firstStrip+10);
            InputStrip inputStrip12 = strips.get(firstStrip+11);

            stripsContainer.add(inputStrip1);
            stripsContainer.add(inputStrip2);
            stripsContainer.add(inputStrip3);
            stripsContainer.add(inputStrip4);
            stripsContainer.add(inputStrip5);
            stripsContainer.add(inputStrip6);
            stripsContainer.add(inputStrip7);
            stripsContainer.add(inputStrip8);
            stripsContainer.add(inputStrip9);
            stripsContainer.add(inputStrip10);
            stripsContainer.add(inputStrip11);
            stripsContainer.add(inputStrip12);
            stripsContainer.revalidate();
            //stripsContainer.repaint();


    mainContainer.add(stripsContainer);
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

