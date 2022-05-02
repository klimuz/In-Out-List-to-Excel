package soundEngineer.step1;

import soundEngineer.server.ProjectData;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Consoles extends JFrame {
    private JMenuBar jMenuBar = new JMenuBar();
    JMenu m1 = new JMenu("File");
    JMenu m2 = new JMenu("Help");

    private JButton buttonBack = new JButton ("Back");
    private JButton buttonNext = new JButton("Next");
    private JButton buttonCut32 = new JButton("Cut to 32");
    private JButton buttonCut48 = new JButton("Cut to 48");
    private JButton buttonCut64 = new JButton("Cut to 64");
    private JLabel fohLabel = new JLabel("FOH");
    private JLabel monLabel = new JLabel("Mon");
    private JLabel selConsLabel = new JLabel("Select console:");
    private JLabel totalLabel = new JLabel("Total");
    private JLabel inputsLabel = new JLabel("InputChannels:");
    private JLabel omniInLabel = new JLabel("Omni In:");
    private JLabel outputsLabel = new JLabel("Outputs:");
    private JLabel omniOutLabel = new JLabel("Omni Out:");
    private JLabel inputsFieldLabel = new JLabel("00");
    private JLabel omniInFieldLabel = new JLabel("00");
    private JLabel outFieldLabel = new JLabel("00");
    private JLabel omniOutFieldLabel = new JLabel("00");

    private JRadioButton noFoh = new JRadioButton("No One");
    private JRadioButton pm5d = new JRadioButton("PM5D");
    private JRadioButton cl = new JRadioButton("CL5");
    private JRadioButton iLive = new JRadioButton("iLive");
    private JRadioButton rivage = new JRadioButton("Rivage");
    private JRadioButton digico = new JRadioButton("Digico");
    private JRadioButton x32 = new JRadioButton("X32");

    private JRadioButton noMon = new JRadioButton("No One");
    private JRadioButton pm5dMon = new JRadioButton("PM5D");
    private JRadioButton clMon = new JRadioButton("CL5");
    private JRadioButton iLiveMon = new JRadioButton("iLive");
    private JRadioButton rivageMon = new JRadioButton("Rivage");
    private JRadioButton digicoMon = new JRadioButton("Digico");
    private JRadioButton x32Mon = new JRadioButton("X32");

    private void setFohName(){
        switch (selectedFohConsole){
            case "2":
                ProjectData.fohConsoleName = "PM5D";
                break;
            case "3":
                ProjectData.fohConsoleName = "iLive";
                break;
            case "4":
                ProjectData.fohConsoleName = "CL5";
                break;
            case "5":
                ProjectData.fohConsoleName = "Rivage";
                break;
            case "6":
                ProjectData.fohConsoleName = "X32";
                break;
            case "7":
                ProjectData.fohConsoleName = "Digico";
                break;
        }
    }
    private void setMonName(){
        //mon
        switch (selectedMonConsole){
            case "2":
                ProjectData.monConsoleName = "PM5D";
                break;
            case "3":
                ProjectData.monConsoleName = "iLive";
                break;
            case "4":
                ProjectData.monConsoleName = "CL5";
                break;
            case "5":
                ProjectData.monConsoleName = "Rivage";
                break;
            case "6":
                ProjectData.monConsoleName = "X32";
                break;
            case "7":
                ProjectData.monConsoleName = "Digico";
                break;
        }
    }

    public void terminateThisWindow(){
        this.dispose();
    }

    private String selectedFohConsole;
    private String selectedMonConsole;
    public Consoles() throws HeadlessException {
        super("In-Out List to Exel : " + ProjectData.projectName);
        this.setBounds(854, 480, 500, 300);
        Font font = new Font("", Font.BOLD, 30);
        Font infoFont = new Font("", Font.BOLD, 80);

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
            Image backgroundImage = ImageIO.read(new File("img/blueBgnd.jpg"));
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

        Container fohContainer = new Container();
        fohContainer.setLayout(new GridLayout(8, 1, 3, 10));
        fohContainer.setBounds(220, 70, 100, 250);

        Container monContainer = new Container();
        monContainer.setLayout(new GridLayout(8, 1, 3, 10));
        monContainer.setBounds(420, 70, 100, 250);

        selConsLabel.setBounds(220, 20, 300, 40);
        selConsLabel.setFont(font);
        container.add(selConsLabel);

        totalLabel.setBounds(650, 20, 150, 40);
        totalLabel.setFont(font);
        container.add(totalLabel);

        inputsLabel.setBounds(560, 80, 100, 40);
        inputsLabel.setFont(font);
        container.add(inputsLabel);

        outputsLabel.setBounds(680, 80, 150, 40);
        outputsLabel.setFont(font);
        container.add(outputsLabel);

        inputsFieldLabel.setBounds(560, 150, 95, 100);
        inputsFieldLabel.setFont(infoFont);
        inputsFieldLabel.setBackground(Color.black);
        inputsFieldLabel.setForeground(Color.yellow);
        inputsFieldLabel.setOpaque(true);
        inputsFieldLabel.setText(ProjectData.commonChannels().toString());
        container.add(inputsFieldLabel);

        outFieldLabel.setBounds(680, 150,95, 100);
        outFieldLabel.setFont(infoFont);
        outFieldLabel.setBackground(Color.black);
        outFieldLabel.setForeground(Color.yellow);
        outFieldLabel.setOpaque(true);
        if (ProjectData.outStrips.size() < 10){
            outFieldLabel.setText("0"+ProjectData.outStrips.size());
        }else {
            outFieldLabel.setText(""+ProjectData.outStrips.size());
        }
        container.add(outFieldLabel);

        ButtonGroup fohGroup = new ButtonGroup();
        noFoh.setActionCommand("1");
        fohGroup.add(noFoh);
        pm5d.setActionCommand("2");
        fohGroup.add(pm5d);
        iLive.setActionCommand("3");
        fohGroup.add(iLive);
        cl.setActionCommand("4");
        fohGroup.add(cl);
        rivage.setActionCommand("5");
        fohGroup.add(rivage);
        x32.setActionCommand("6");
        fohGroup.add(x32);
        digico.setActionCommand("7");
        fohGroup.add(digico);
        switch (ProjectData.inputStrips.get(0)){
            case "PM5D":
                pm5d.setSelected(true);
                break;
            case "iLive":
                iLive.setSelected(true);
                break;
            case "CL5":
                cl.setSelected(true);
                break;
            case "Rivage":
                rivage.setSelected(true);
                break;
            case  "X32":
                x32.setSelected(true);
                break;
            case "Digico":
                digico.setSelected(true);
                break;
        }
        selectedFohConsole = fohGroup.getSelection().toString();

        ButtonGroup monGroup = new ButtonGroup();
        noMon.setActionCommand("1");
        monGroup.add(noMon);
        pm5dMon.setActionCommand("2");
        monGroup.add(pm5dMon);
        iLiveMon.setActionCommand("3");
        monGroup.add(iLiveMon);
        clMon.setActionCommand("4");
        monGroup.add(clMon);
        rivageMon.setActionCommand("5");
        monGroup.add(rivageMon);
        x32Mon.setActionCommand("6");
        monGroup.add(x32Mon);
        digicoMon.setActionCommand("7");
        monGroup.add(digicoMon);
        noMon.setSelected(true);
        selectedMonConsole = monGroup.getSelection().toString();

//cutting logic start
        if (ProjectData.inputStrips.size() > 32){  //38
          x32.setEnabled(false);
          x32Mon.setEnabled(false);
          buttonCut32.setBackground(Color.red);
          buttonCut32.setBounds(320, 263, 100, 25);
          container.add(buttonCut32);
          buttonCut32.setText("Cut to 32");
          buttonCut32.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {

              }
          });

        }
        if (ProjectData.inputStrips.size() > 48){ //56
            pm5d.setEnabled(false);
            pm5dMon.setEnabled(false);
            buttonCut48.setBackground(Color.red);
            buttonCut48.setBounds(320, 135, 100, 25);
            container.add(buttonCut48);
            buttonCut48.setText("Cut to 48");
        }
//cutting logic end

        fohContainer.add(fohLabel);
        fohContainer.add(noFoh);
        fohContainer.add(pm5d);

        fohContainer.add(iLive);
        fohContainer.add(cl);
        fohContainer.add(rivage);
        fohContainer.add(x32);
        fohContainer.add(digico);

        monContainer.add(monLabel);
        monContainer.add(noMon);
        noMon.setSelected(true);
        monContainer.add(pm5dMon);
        monContainer.add(iLiveMon);
        monContainer.add(clMon);
        monContainer.add(rivageMon);
        monContainer.add(x32Mon);
        monContainer.add(digicoMon);

        container.add(fohContainer);
        container.add(monContainer);
//elements end

//button next start
        buttonNext.setBounds(540, 360, 100, 40);
        buttonNext.setBorderPainted(true);
        buttonNext.setBackground(Color.orange);
        container.add(buttonNext);
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                ProjectData.normaliseListsGui.setVisible(true);
/*               if (fohGroup.getSelection().getActionCommand() == "4" || fohGroup.getSelection().getActionCommand() == "5") {
                    RIOtoExcel rioToExcel = new RIOtoExcel();
                    try {
                        rioToExcel.inputlistRIOtoExel();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }else if (fohGroup.getSelection().getActionCommand() == "3"){
                    IDRtoExcel idrToExcel = new IDRtoExcel();
                    try {
                        idrToExcel.inputlistIDRtoExel();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }*/
            }
        });
//button next end


//Button back start
        buttonBack.setBounds(100, 360, 100, 40);
        buttonBack.setBorderPainted(true);
        buttonBack.setBackground(Color.orange);
        container.add(buttonBack);

        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectData.defineInstruments.setVisible(true);
                terminateThisWindow();
            }
        });
//Button back end
         }
}
