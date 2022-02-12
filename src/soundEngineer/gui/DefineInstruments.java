package soundEngineer.gui;

import soundEngineer.server.ProjectData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

public class DefineInstruments extends JFrame{
    private JMenuBar jMenuBar = new JMenuBar();
    JMenu m1 = new JMenu("File");
    JMenu m2 = new JMenu("Help");
    public static JButton buttonDrums =new JButton("Drums");
    public static JButton buttonGuitars =new JButton("Guitars");
    public static JButton buttonSynths =new JButton("Synths");
    public static JButton buttonPercuss =new JButton("Percussion");
    public static JButton buttonStrings =new JButton("Strings");
    public static JButton buttonBrass =new JButton("Brass&Woods");
    public static JButton buttonVocals =new JButton("Vocals");
    public static JButton buttonOthers =new JButton("Others");
    public static JButton buttonUzbek =new JButton("Uzbek");
    public static JButton buttonGreek =new JButton("Greek");
    public static JButton buttonAmer =new JButton("American");
    public static JButton buttonWorld =new JButton("WorldWide");
    private JButton buttonBack =new JButton("Back");
    private JButton buttonCancel =new JButton("Cancel");
    private JButton buttonNext =new JButton("Next");
    private JLabel define = new JLabel("Define instruments:");
    public static JLabel numChannels = new JLabel("");
    public void terminateThisWindow(){
        this.dispose();
    }

    public DefineInstruments() throws HeadlessException {
        super("In-Out List to Exel : " + ProjectData.projectName);
        Font font = new Font("", Font.BOLD, 30);

        this.setIconImage(new ImageIcon("img/logo.png").getImage());
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
        try {
            Image backgroundImage = javax.imageio.ImageIO.read(new File("img/lineArray.jpg"));
            setContentPane(new JPanel(new BorderLayout()) {
                @Override public void paintComponent(Graphics g) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(),getHeight(), this);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
        numChannels.setBounds(650, 5, 150, 25);
        numChannels.setForeground(Color.yellow);
        container.add(numChannels);
        Container gridContainer = new Container();
        gridContainer.setLayout(new GridLayout(3, 4, 10, 10));
        gridContainer.setBounds(150, 100, 500, 220);
        buttonDrums.setBackground(Color.green);
        gridContainer.add(buttonDrums);
        buttonDrums.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //
                ProjectData.acousticDrums.setVisible(true);
            }
        });
        buttonGuitars.setBackground(Color.green);
        gridContainer.add(buttonGuitars);
        buttonSynths.setBackground(Color.green);
        gridContainer.add(buttonSynths);
        buttonPercuss.setBackground(Color.green);
        gridContainer.add(buttonPercuss);
        buttonStrings.setBackground(Color.green);
        gridContainer.add(buttonStrings);
        buttonBrass.setBackground(Color.green);
        gridContainer.add(buttonBrass);
        buttonVocals.setBackground(Color.green);
        gridContainer.add(buttonVocals);
        buttonOthers.setBackground(Color.green);
        gridContainer.add(buttonOthers);
        buttonUzbek.setBackground(Color.green);
        gridContainer.add(buttonUzbek);
        buttonGreek.setBackground(Color.green);
        gridContainer.add(buttonGreek);
        buttonAmer.setBackground(Color.green);
        gridContainer.add(buttonAmer);
        buttonWorld.setBackground(Color.green);
        gridContainer.add(buttonWorld);
        container.add(gridContainer);

        buttonGuitars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectData.guitars.setVisible(true);
            }
        });
        buttonSynths.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectData.synths.setVisible(true);
            }

        });
        buttonPercuss.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectData.percussion.setVisible(true);
            }
        });
        buttonStrings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectData.stringed.setVisible(true);
            }
        });
        buttonBrass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectData.woodsBrass.setVisible(true);
            }
        });
        buttonVocals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectData.vocals.setVisible(true);
            }
        });
        buttonOthers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectData.others.setVisible(true);
            }
        });
        buttonUzbek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectData.uzbek.setVisible(true);
            }
        });
//elements end

//Button cancel start
        buttonCancel.setBounds(200, 360, 100, 40);
        buttonCancel.setBorderPainted(true);
        buttonCancel.setBackground(Color.orange);
        container.add(buttonCancel);
        buttonCancel.addActionListener(new ActionListener() {
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
//Button cancel end

//Button next start
        buttonNext.setBounds(540, 360, 100, 40);
        buttonNext.setBorderPainted(true);
        buttonNext.setBackground(Color.orange);
        container.add(buttonNext);
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ProjectData.populateInputs();
                Consoles consoles = new Consoles();
                consoles.setVisible(true);
                System.out.println(ProjectData.inputStrips);
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
                    DefineInstruments defineInstruments = new DefineInstruments();
                    defineInstruments.setVisible(true);
                }
            }
        });
    }
}
