package soundEngineer.step1;

import soundEngineer.server.ProjectData;
import soundEngineer.server.ResourceLoader;
import soundEngineer.step2.NormaliseListsGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DefineInstruments extends JFrame{
    private JMenuBar jMenuBar = new JMenuBar();
    JMenu m1 = new JMenu("File");
    JMenu m2 = new JMenu("Help");
    public static JButton buttonDrums =new JButton("Drums" + ProjectData.drumStrips.size());
    public static JButton buttonGuitars =new JButton("Guitars" + ProjectData.guitarStrips.size());
    public static JButton buttonSynths =new JButton("Keys" + ProjectData.keyboardStrips.size());
    public static JButton buttonPercuss =new JButton("Percussion" + ProjectData.percussionStrips.size());
    public static JButton buttonStrings =new JButton("Strings" + ProjectData.stringedStrips.size());
    public static JButton buttonWinds =new JButton("Winds" + ProjectData.windStrips.size());
    public static JButton buttonVocals =new JButton("Vocals" + ProjectData.vocalStrips.size());
    public static JButton buttonOthers =new JButton("Others" + ProjectData.extraStrips.size());
    public static JButton buttonUzbek =new JButton("Uzbek" + ProjectData.uzbekStrips.size());
    public static JButton buttonMain =new JButton("Mains");
    public static JButton buttonAux =new JButton("Aux");
    public static JButton buttonWorld =new JButton("WorldWide" + ProjectData.worldWideStrips.size());
    private JButton buttonBack =new JButton("Back");
    private JButton buttonNext =new JButton("Next");
    private JButton buttonReset = new JButton("Reset");
    private JLabel define = new JLabel("Define instruments:");
    public static JLabel numChannels = new JLabel("All Channels:" + ProjectData.commonChannels());
    public static JLabel omniChannels = new JLabel("Omni Channels:" + ProjectData.omniStrips.size());
    public static NormaliseListsGui normaliseListsGui = new NormaliseListsGui("in");
    public void terminateThisWindow(){
        this.dispose();
    }

    public DefineInstruments() throws HeadlessException {
        super("In-Out List to Exel : " + ProjectData.projectName);
        Font font = new Font("", Font.BOLD, 30);

        this.setIconImage(ResourceLoader.getImage("logo.png"));
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setBounds(dimension.width / 2 - 350, dimension.height / 2 - 250, 854, 480);
        this.setResizable(false);
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

        m2.add(new JMenuItem("About"));
        jMenuBar.add(m1);
        jMenuBar.add(m2);
        jMenuBar.setBackground(Color.green);
        this.setJMenuBar(jMenuBar);
        this.revalidate();
//background image start
        setContentPane(new JPanel(new BorderLayout()) {
            @Override public void paintComponent(Graphics g) {
                g.drawImage(ResourceLoader.getImage("lineArray.jpg"), 0, 0, getWidth(),getHeight(), this);
            }
        });
//background image end

//elements start
        Container container = this.getContentPane();
        container.setLayout(null);
        define.setFont(font);
        define.setOpaque(false);
        define.setBackground(Color.cyan);
        define.setBounds(250, 20, 300, 40);
        define.setForeground(Color.orange);
        container.add(define);
        numChannels.setBounds(720, 5, 150, 25);
        numChannels.setForeground(Color.yellow);
        container.add(numChannels);
        omniChannels.setBounds(720, 25, 150, 25);
        omniChannels.setForeground(Color.yellow);
        container.add(omniChannels);
        Container gridContainer = new Container();
        gridContainer.setLayout(new GridLayout(3, 4, 10, 10));
        gridContainer.setBounds(150, 100, 500, 220);
        buttonDrums.setBackground(Color.green);
        gridContainer.add(buttonDrums);

        buttonGuitars.setBackground(Color.green);
        gridContainer.add(buttonGuitars);
        buttonSynths.setBackground(Color.green);
        gridContainer.add(buttonSynths);
        buttonPercuss.setBackground(Color.green);
        gridContainer.add(buttonPercuss);
        buttonStrings.setBackground(Color.green);
        gridContainer.add(buttonStrings);
        buttonWinds.setBackground(Color.green);
        gridContainer.add(buttonWinds);
        buttonVocals.setBackground(Color.green);
        gridContainer.add(buttonVocals);
        buttonOthers.setBackground(Color.green);
        gridContainer.add(buttonOthers);
        buttonUzbek.setBackground(Color.green);
        gridContainer.add(buttonUzbek);
        buttonWorld.setBackground(Color.green);
        gridContainer.add(buttonWorld);
        buttonAux.setBackground(Color.green);
        gridContainer.add(buttonAux);
        buttonMain.setBackground(Color.green);
        gridContainer.add(buttonMain);
        container.add(gridContainer);

        buttonDrums.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectData.acousticDrumsGUI = new AcousticDrumsGUI();
                ProjectData.acousticDrumsGUI.i = ResourceLoader.getImage(ProjectData.acousticDrumsGUI.IMAGE_FILE_NAME);
                ProjectData.acousticDrumsGUI.setVisible(true);
            }
        });
        buttonGuitars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectData.guitarsGUI = new GuitarsGUI();
                ProjectData.guitarsGUI.i = ResourceLoader.getImage(ProjectData.guitarsGUI.IMAGE_FILE_NAME);
                ProjectData.guitarsGUI.setVisible(true);
            }
        });
        buttonSynths.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectData.synths = new Synths();
                ProjectData.synths.i = ResourceLoader.getImage(ProjectData.synths.IMAGE_FILE_NAME);
                ProjectData.synths.setVisible(true);
            }

        });
        buttonPercuss.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectData.percussion = new Percussion();
                ProjectData.percussion.i = ResourceLoader.getImage(ProjectData.percussion.IMAGE_FILE_NAME);
                ProjectData.percussion.setVisible(true);
            }
        });
        buttonStrings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectData.stringed = new Stringed();
                ProjectData.stringed.i = ResourceLoader.getImage(ProjectData.stringed.IMAGE_FILE_NAME);
                ProjectData.stringed.setVisible(true);
            }
        });
        buttonWinds.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectData.woodsBrass = new WoodsBrass();
                ProjectData.woodsBrass.i = ResourceLoader.getImage(ProjectData.woodsBrass.IMAGE_FILE_NAME);
                ProjectData.woodsBrass.setVisible(true);
            }
        });
        buttonVocals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectData.vocals = new Vocals();
                ProjectData.vocals.i = ResourceLoader.getImage(ProjectData.vocals.IMAGE_FILE_NAME);
                ProjectData.vocals.setVisible(true);
            }
        });
        buttonOthers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectData.others = new Others();
                ProjectData.others.i = ResourceLoader.getImage(ProjectData.others.IMAGE_FILE_NAME);
                ProjectData.others.setVisible(true);
            }
        });
        buttonUzbek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectData.uzbek = new Uzbek();
                ProjectData.uzbek.i = ResourceLoader.getImage(ProjectData.uzbek.IMAGE_FILE_NAME);
                ProjectData.uzbek.setVisible(true);
            }
        });
        buttonWorld.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectData.worldWideGui = new WorldWideGui();
                ProjectData.worldWideGui.i = ResourceLoader.getImage(ProjectData.worldWideGui.IMAGE_FILE_NAME);
                ProjectData.worldWideGui.setVisible(true);
            }
        });
//elements end
//button reset start
        buttonReset.setBackground(Color.red);
        buttonReset.setBounds(375, 360, 100, 40);
        container.add(buttonReset);
        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectData.drumStrips.clear();
                buttonDrums.setText("Drums" + ProjectData.drumStrips.size());
                ProjectData.guitarStrips.clear();
                buttonGuitars.setText("Guitars" + ProjectData.guitarStrips.size());
                ProjectData.keyboardStrips.clear();
                buttonSynths.setText("Synths" + ProjectData.keyboardStrips.size());
                ProjectData.percussionStrips.clear();
                buttonPercuss.setText("Percussion" + ProjectData.percussionStrips.size());
                ProjectData.stringedStrips.clear();
                buttonStrings.setText("Strings" + ProjectData.stringedStrips.size());
                ProjectData.windStrips.clear();
                buttonWinds.setText("Winds" + ProjectData.windStrips.size());
                ProjectData.vocalStrips.clear();
                buttonVocals.setText("Vocals" + ProjectData.vocalStrips.size());
                ProjectData.extraStrips.clear();
                buttonOthers.setText("Others" + ProjectData.extraStrips.size());
                ProjectData.uzbekStrips.clear();
                buttonUzbek.setText("Uzbek" + ProjectData.uzbekStrips.size());
                ProjectData.worldWideStrips.clear();
                buttonWorld.setText("WorldWide" + ProjectData.worldWideStrips.size());
                numChannels.setText("All Channels:" + ProjectData.commonChannels());

            }
        });
//button reset end

//Button back start
        buttonBack.setBounds(200, 360, 100, 40);
        buttonBack.setBorderPainted(true);
        buttonBack.setBackground(Color.orange);
        container.add(buttonBack);
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SetProjectName setProjectName = new SetProjectName();
                setProjectName.setVisible(true);
                terminateThisWindow();
            }
        });
//Button back end

//Button next start
        buttonNext.setBounds(540, 360, 100, 40);
        buttonNext.setBorderPainted(true);
        buttonNext.setBackground(Color.orange);
        container.add(buttonNext);
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ProjectData.populateChannels();
                NormaliseListsGui normaliseListsGui = new NormaliseListsGui("in");
                normaliseListsGui.setVisible(true);
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
                }
            }
        });
    }
}
