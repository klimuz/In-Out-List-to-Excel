package soundEngineer.gui;

import soundEngineer.server.ProjectData;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class WoodsBrass extends JFrame implements ItemListener {

    private JMenuBar jMenuBar = new JMenuBar();
    JMenu m1 = new JMenu("File");
    JMenu m2 = new JMenu("Help");
    private JButton buttonBack = new JButton("Back");
    private JButton buttonNext = new JButton("Next");
    private JButton buttonApply = new JButton("Apply");
    private JLabel chooseOutputsLabel = new JLabel("Choose among winds:");
    private JLabel trumpetLabel = new JLabel("Trumpets");
    private JLabel trombLabel = new JLabel("Trombones");
    private JLabel saxLabel = new JLabel("Saxophones");
    private JLabel tubaLabel = new JLabel("Tubas");
    private JLabel hornsLabel = new JLabel("Horns");
    private JLabel fluteLabel = new JLabel("Flutes");
    private JLabel clarinetsLabel = new JLabel("Clarinets");
    private JLabel oboeLabel = new JLabel("Oboes");
    private JLabel bassoonsLabel = new JLabel("Bassoons");
    private JLabel othersLabel = new JLabel("Others");
    private JLabel genericsLabel = new JLabel("Cooper:");
    private JLabel nationalLabel = new JLabel("Woods:");
    private JComboBox<String> trumpetsNumber = new JComboBox();
    private JComboBox<String> trombNumber = new JComboBox();
    private JComboBox<String> saxNumber = new JComboBox();
    private JComboBox<String> tubaNumber = new JComboBox();
    private JComboBox<String> hornsNumber = new JComboBox();
    private JComboBox<String> fluteNumber = new JComboBox();
    private JComboBox<String> clarinetsNumber = new JComboBox();
    private JComboBox<String> oboeNumber = new JComboBox();
    private JComboBox<String> bassoonsNumber = new JComboBox();
    private JComboBox<String> othersNumber = new JComboBox();
    private JLabel numChannels = new JLabel("");
    public void terminateThisWindow(){
        this.dispose();
    }



    public WoodsBrass() throws HeadlessException {
        super("In-Out List to Exel : " + ProjectData.projectName);
        Font font = new Font("",Font.BOLD,20);
        this.setIconImage(new ImageIcon("img/logo.png").getImage());
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setBounds(dimension.width/2-350, dimension.height/2-250, 854, 480);
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
            Image backgroundImage = ImageIO.read(new File("img/brass.jpg"));
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
        chooseOutputsLabel.setFont(font);
        chooseOutputsLabel.setBounds(245, 5, 300, 50);
        container.add(chooseOutputsLabel);
        genericsLabel.setFont(font);
        genericsLabel.setBounds(180, 55, 100, 50);
        container.add(genericsLabel);
        nationalLabel.setFont(font);
        nationalLabel.setBounds(450, 55, 100, 50);
        container.add(nationalLabel);

        Container gridContainerL= new Container();//for labels
        gridContainerL.setLayout(new GridLayout(6,1, 5, 10));
        gridContainerL.setBounds(170, 120, 100, 200);

        Container gridContainerN= new Container();//for combo boxes
        gridContainerN.setLayout(new GridLayout(6,1, 5, 10));
        gridContainerN.setBounds(270, 120, 40, 200);

        Container gridContainerWL= new Container();//for labels
        gridContainerWL.setLayout(new GridLayout(6,1, 5, 10));
        gridContainerWL.setBounds(440, 120, 60, 200);

        Container gridContainerWN= new Container();//for combo boxes
        gridContainerWN.setLayout(new GridLayout(6,1, 5, 10));
        gridContainerWN.setBounds(550, 120, 40, 200);

        gridContainerL.add(trumpetLabel);
        trumpetsNumber.addItem("0");
        trumpetsNumber.addItem("1");
        trumpetsNumber.addItem("2");
        trumpetsNumber.addItem("3");
        trumpetsNumber.addItem("4");
        trumpetsNumber.addItemListener(this);
        if (ProjectData.windStrips.contains("Trum")){
            trumpetsNumber.setSelectedItem("1");
        }else if (!ProjectData.windStrips.contains("Tru3") && ProjectData.windStrips.contains("Tru2")){
            trumpetsNumber.setSelectedItem("2");
        }else if (!ProjectData.windStrips.contains("Tru4") && ProjectData.windStrips.contains("Tru3")){
            trumpetsNumber.setSelectedItem("3");
        }else if (ProjectData.windStrips.contains("Tru4")){
            trumpetsNumber.setSelectedItem("4");
        }
        gridContainerN.add(trumpetsNumber);
        gridContainerL.add(trombLabel);
        trombNumber.addItem("0");
        trombNumber.addItem("1");
        trombNumber.addItem("2");
        trombNumber.addItem("3");
        trombNumber.addItem("4");
        if (ProjectData.windStrips.contains("Trom")){
            trombNumber.setSelectedItem("1");
        }else if (!ProjectData.windStrips.contains("Tro3") && ProjectData.windStrips.contains("Tro2")){
            trombNumber.setSelectedItem("2");
        }else if (!ProjectData.windStrips.contains("Tro4") && ProjectData.windStrips.contains("Tro3")){
            trombNumber.setSelectedItem("3");
        }else if (ProjectData.windStrips.contains("Tro4")){
            trombNumber.setSelectedItem("4");
        }
        trombNumber.addItemListener(this);
        gridContainerN.add(trombNumber);
        gridContainerL.add(saxLabel);
        saxNumber.addItem("0");
        saxNumber.addItem("1");
        saxNumber.addItem("2");
        saxNumber.addItem("3");
        saxNumber.addItem("4");
        if (ProjectData.windStrips.contains("Sax")){
            saxNumber.setSelectedItem("1");
        }else if (!ProjectData.windStrips.contains("Sax3") && ProjectData.windStrips.contains("Sax2")){
            saxNumber.setSelectedItem("2");
        }else if (!ProjectData.windStrips.contains("Sax4") && ProjectData.windStrips.contains("Sax3")){
            saxNumber.setSelectedItem("3");
        }else if (ProjectData.windStrips.contains("Sax4")){
            saxNumber.setSelectedItem("4");
        }
        saxNumber.addItemListener(this);
        gridContainerN.add(saxNumber);
        gridContainerL.add(tubaLabel);
        tubaNumber.addItem("0");
        tubaNumber.addItem("1");
        tubaNumber.addItem("2");
        tubaNumber.addItem("3");
        tubaNumber.addItem("4");
        if (ProjectData.windStrips.contains("Tuba")){
            tubaNumber.setSelectedItem("1");
        }else if (!ProjectData.windStrips.contains("Tub3") && ProjectData.windStrips.contains("Tub2")){
            tubaNumber.setSelectedItem("2");
        }else if (!ProjectData.windStrips.contains("Tub4") && ProjectData.windStrips.contains("Tub3")){
            tubaNumber.setSelectedItem("3");
        }else if (ProjectData.windStrips.contains("Tub4")){
            tubaNumber.setSelectedItem("4");
        }
        tubaNumber.addItemListener(this);
        gridContainerN.add(tubaNumber);
        gridContainerL.add(hornsLabel);
        hornsNumber.addItem("0");
        hornsNumber.addItem("1");
        hornsNumber.addItem("2");
        hornsNumber.addItem("3");
        hornsNumber.addItem("4");
        hornsNumber.addItemListener(this);
        if (ProjectData.windStrips.contains("Horn")){
            hornsNumber.setSelectedItem("1");
        }else if (!ProjectData.windStrips.contains("Hor3") && ProjectData.windStrips.contains("Hor2")){
            hornsNumber.setSelectedItem("2");
        }else if (!ProjectData.windStrips.contains("Hor4") && ProjectData.windStrips.contains("Hor3")){
            hornsNumber.setSelectedItem("3");
        }else if (ProjectData.windStrips.contains("Hor4")){
            hornsNumber.setSelectedItem("4");
        }
        gridContainerN.add(hornsNumber);

        container.add(gridContainerL);
        container.add(gridContainerN);

        gridContainerWL.add(fluteLabel);
        fluteNumber.addItem("0");
        fluteNumber.addItem("1");
        fluteNumber.addItem("2");
        fluteNumber.addItem("3");
        fluteNumber.addItem("4");
        fluteNumber.addItem("5");
        if (ProjectData.windStrips.contains("Flut")){
            fluteNumber.setSelectedItem("1");
        }else if (!ProjectData.windStrips.contains("Flu3") && ProjectData.windStrips.contains("Flu2")){
            fluteNumber.setSelectedItem("2");
        }else if (!ProjectData.windStrips.contains("Flu4") && ProjectData.windStrips.contains("Flu3")){
            fluteNumber.setSelectedItem("3");
        }else if (!ProjectData.windStrips.contains("Flu5") && ProjectData.windStrips.contains("Flu4")){
            fluteNumber.setSelectedItem("4");
        }else if (ProjectData.windStrips.contains("Flu5")){
            fluteNumber.setSelectedItem("5");
        }
        fluteNumber.addItemListener(this);
        gridContainerWN.add(fluteNumber);
        gridContainerWL.add(clarinetsLabel);
        clarinetsNumber.addItem("0");
        clarinetsNumber.addItem("1");
        clarinetsNumber.addItem("2");
        clarinetsNumber.addItem("3");
        clarinetsNumber.addItem("4");
        if (ProjectData.windStrips.contains("Clar")){
            clarinetsNumber.setSelectedItem("1");
        }else if (!ProjectData.windStrips.contains("Cla3") && ProjectData.windStrips.contains("Cla2")){
            clarinetsNumber.setSelectedItem("2");
        }else if (!ProjectData.windStrips.contains("Cla4") && ProjectData.windStrips.contains("Cla3")){
            clarinetsNumber.setSelectedItem("3");
        }else if (ProjectData.windStrips.contains("Cla4")){
            clarinetsNumber.setSelectedItem("4");
        }
        clarinetsNumber.addItemListener(this);
        gridContainerWN.add(clarinetsNumber);
        gridContainerWL.add(oboeLabel);
        oboeNumber.addItem("0");
        oboeNumber.addItem("1");
        oboeNumber.addItem("2");
        oboeNumber.addItem("3");
        oboeNumber.addItem("4");
        if (ProjectData.windStrips.contains("Oboe")){
            oboeNumber.setSelectedItem("1");
        }else if (!ProjectData.windStrips.contains("Obo3") && ProjectData.windStrips.contains("Obo2")){
            oboeNumber.setSelectedItem("2");
        }else if (!ProjectData.windStrips.contains("Obo4") && ProjectData.windStrips.contains("Obo3")){
            oboeNumber.setSelectedItem("3");
        }else if (ProjectData.windStrips.contains("Obo4")){
            oboeNumber.setSelectedItem("4");
        }
        oboeNumber.addItemListener(this);
        gridContainerWN.add(oboeNumber);
        gridContainerWL.add(bassoonsLabel);
        bassoonsNumber.addItem("0");
        bassoonsNumber.addItem("1");
        bassoonsNumber.addItem("2");
        bassoonsNumber.addItem("3");
        bassoonsNumber.addItem("4");
        if (ProjectData.windStrips.contains("Bsn")){
            bassoonsNumber.setSelectedItem("1");
        }else if (!ProjectData.windStrips.contains("Bsn3") && ProjectData.windStrips.contains("Bsn2")){
            bassoonsNumber.setSelectedItem("2");
        }else if (!ProjectData.windStrips.contains("Bsn4") && ProjectData.windStrips.contains("Bsn3")){
            bassoonsNumber.setSelectedItem("3");
        }else if (ProjectData.windStrips.contains("Bsn4")){
            bassoonsNumber.setSelectedItem("4");
        }
        bassoonsNumber.addItemListener(this);
        gridContainerWN.add(bassoonsNumber);
        gridContainerWL.add(othersLabel);
        othersNumber.addItem("0");
        othersNumber.addItem("1");
        othersNumber.addItem("2");
        othersNumber.addItem("3");
        othersNumber.addItem("4");
        othersNumber.addItem("5");
        if (ProjectData.windStrips.contains("Wind")){
            othersNumber.setSelectedItem("1");
        }else if (!ProjectData.windStrips.contains("Win3") && ProjectData.windStrips.contains("Win2")){
            othersNumber.setSelectedItem("2");
        }else if (!ProjectData.windStrips.contains("Win4") && ProjectData.windStrips.contains("Win3")){
            othersNumber.setSelectedItem("3");
        }else if (!ProjectData.windStrips.contains("Win5") && ProjectData.windStrips.contains("Win4")){
            othersNumber.setSelectedItem("4");
        }else if (ProjectData.windStrips.contains("Win5")){
            othersNumber.setSelectedItem("5");
        }
        othersNumber.addItemListener(this);
        gridContainerWN.add(othersNumber);

        container.add(gridContainerWL);
        container.add(gridContainerWN);
        numChannels.setBounds(650, 5, 150, 25);//label
        container.add(numChannels);


//elements end

//Button apply start
        buttonApply.setBounds(725, 240, 70, 60);
        buttonApply.setBorderPainted(true);
        buttonApply.setBackground(Color.green);
        container.add(buttonApply);
        buttonApply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectData.windStrips.clear();

                String trumpSel = trumpetsNumber.getSelectedItem().toString();
                switch (trumpSel) {
                    case "1":
                        ProjectData.windStrips.add("Trum");
                        break;
                    case "2":
                        ProjectData.windStrips.add("Tru1");
                        ProjectData.windStrips.add("Tru2");
                        break;
                    case "3":
                        ProjectData.windStrips.add("Tru1");
                        ProjectData.windStrips.add("Tru2");
                        ProjectData.windStrips.add("Tru3");
                        break;
                    case "4":
                        ProjectData.windStrips.add("Tru1");
                        ProjectData.windStrips.add("Tru2");
                        ProjectData.windStrips.add("Tru3");
                        ProjectData.windStrips.add("Tru4");
                        break;
                }
                String tromSel = trombNumber.getSelectedItem().toString();
                switch (tromSel) {
                    case "1":
                        ProjectData.windStrips.add("Trom");
                        break;
                    case "2":
                        ProjectData.windStrips.add("Tro1");
                        ProjectData.windStrips.add("Tro2");
                        break;
                    case "3":
                        ProjectData.windStrips.add("Tro1");
                        ProjectData.windStrips.add("Tro2");
                        ProjectData.windStrips.add("Tro3");
                        break;
                    case "4":
                        ProjectData.windStrips.add("Tro1");
                        ProjectData.windStrips.add("Tro2");
                        ProjectData.windStrips.add("Tro3");
                        ProjectData.windStrips.add("Tro4");
                        break;
                }
                String saxSel = saxNumber.getSelectedItem().toString();
                switch (saxSel) {
                    case "1":
                        ProjectData.windStrips.add("Sax");
                        break;
                    case "2":
                        ProjectData.windStrips.add("Sax1");
                        ProjectData.windStrips.add("Sax2");
                        break;
                    case "3":
                        ProjectData.windStrips.add("Sax1");
                        ProjectData.windStrips.add("Sax2");
                        ProjectData.windStrips.add("Sax3");
                        break;
                    case "4":
                        ProjectData.windStrips.add("Sax1");
                        ProjectData.windStrips.add("Sax2");
                        ProjectData.windStrips.add("Sax3");
                        ProjectData.windStrips.add("Sax4");
                        break;
                }
                String tubaSel = tubaNumber.getSelectedItem().toString();
                switch (tubaSel) {
                    case "1":
                        ProjectData.windStrips.add("Tuba");
                        break;
                    case "2":
                        ProjectData.windStrips.add("Tub1");
                        ProjectData.windStrips.add("Tub2");
                        break;
                    case "3":
                        ProjectData.windStrips.add("Tub1");
                        ProjectData.windStrips.add("Tub2");
                        ProjectData.windStrips.add("Tub3");
                        break;
                    case "4":
                        ProjectData.windStrips.add("Tub1");
                        ProjectData.windStrips.add("Tub2");
                        ProjectData.windStrips.add("Tub3");
                        ProjectData.windStrips.add("Tub4");
                        break;
                }
                String hornSel = hornsNumber.getSelectedItem().toString();
                switch (hornSel) {
                    case "1":
                        ProjectData.windStrips.add("Horn");
                        break;
                    case "2":
                        ProjectData.windStrips.add("Hor1");
                        ProjectData.windStrips.add("Hor2");
                        break;
                    case "3":
                        ProjectData.windStrips.add("Hor1");
                        ProjectData.windStrips.add("Hor2");
                        ProjectData.windStrips.add("Hor3");
                        break;
                    case "4":
                        ProjectData.windStrips.add("Hor1");
                        ProjectData.windStrips.add("Hor2");
                        ProjectData.windStrips.add("Hor3");
                        ProjectData.windStrips.add("Hor4");
                        break;
                }
                String fluteSel = fluteNumber.getSelectedItem().toString();
                switch (fluteSel) {
                    case "1":
                        ProjectData.windStrips.add("Flut");
                        break;
                    case "2":
                        ProjectData.windStrips.add("Flu1");
                        ProjectData.windStrips.add("Flu2");
                        break;
                    case "3":
                        ProjectData.windStrips.add("Flu1");
                        ProjectData.windStrips.add("Flu2");
                        ProjectData.windStrips.add("Flu3");
                        break;
                    case "4":
                        ProjectData.windStrips.add("Flu1");
                        ProjectData.windStrips.add("Flu2");
                        ProjectData.windStrips.add("Flu3");
                        ProjectData.windStrips.add("Flu4");
                        break;
                }
                String clarSel = clarinetsNumber.getSelectedItem().toString();
                switch (clarSel) {
                    case "1":
                        ProjectData.windStrips.add("Clar");
                        break;
                    case "2":
                        ProjectData.windStrips.add("Cla1");
                        ProjectData.windStrips.add("Cla2");
                        break;
                    case "3":
                        ProjectData.windStrips.add("Cla1");
                        ProjectData.windStrips.add("Cla2");
                        ProjectData.windStrips.add("Cla3");
                        break;
                    case "4":
                        ProjectData.windStrips.add("Cla1");
                        ProjectData.windStrips.add("Cla2");
                        ProjectData.windStrips.add("Cla3");
                        ProjectData.windStrips.add("Cla4");
                        break;
                }
                String oboeSel = oboeNumber.getSelectedItem().toString();
                switch (oboeSel) {
                    case "1":
                        ProjectData.windStrips.add("Oboe");
                        break;
                    case "2":
                        ProjectData.windStrips.add("Obo1");
                        ProjectData.windStrips.add("Obo2");
                        break;
                    case "3":
                        ProjectData.windStrips.add("Obo1");
                        ProjectData.windStrips.add("Obo2");
                        ProjectData.windStrips.add("Obo3");
                        break;
                    case "4":
                        ProjectData.windStrips.add("Obo1");
                        ProjectData.windStrips.add("Obo2");
                        ProjectData.windStrips.add("Obo3");
                        ProjectData.windStrips.add("Obo4");
                        break;
                }
                String bsnSel = bassoonsNumber.getSelectedItem().toString();
                switch (bsnSel) {
                    case "1":
                        ProjectData.windStrips.add("Bsn");
                        break;
                    case "2":
                        ProjectData.windStrips.add("Bsn1");
                        ProjectData.windStrips.add("Bsn2");
                        break;
                    case "3":
                        ProjectData.windStrips.add("Bsn1");
                        ProjectData.windStrips.add("Bsn2");
                        ProjectData.windStrips.add("Bsn3");
                        break;
                    case "4":
                        ProjectData.windStrips.add("Bsn1");
                        ProjectData.windStrips.add("Bsn2");
                        ProjectData.windStrips.add("Bsn3");
                        ProjectData.windStrips.add("Bsn4");
                        break;
                }
                String otherSel = othersNumber.getSelectedItem().toString();
                switch (otherSel) {
                    case "1":
                        ProjectData.windStrips.add("Wind");
                        break;
                    case "2":
                        ProjectData.windStrips.add("Win1");
                        ProjectData.windStrips.add("Win2");
                        break;
                    case "3":
                        ProjectData.windStrips.add("Win1");
                        ProjectData.windStrips.add("Win2");
                        ProjectData.windStrips.add("Win3");
                        break;
                    case "4":
                        ProjectData.windStrips.add("Win1");
                        ProjectData.windStrips.add("Win2");
                        ProjectData.windStrips.add("Win3");
                        ProjectData.windStrips.add("Win4");
                        break;
                    case "5":
                        ProjectData.windStrips.add("Win1");
                        ProjectData.windStrips.add("Win2");
                        ProjectData.windStrips.add("Win3");
                        ProjectData.windStrips.add("Win4");
                        ProjectData.windStrips.add("Win5");
                        break;
                }

                buttonNext.setEnabled(true);
                numChannels.setText("Wind Channels: " + ProjectData.windStrips.size());
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
                DefineInstruments.buttonBrass.setText("Winds:" + ProjectData.windStrips.size());
                DefineInstruments.numChannels.setText("All Channels:" + ProjectData.CommonChannels());
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
                    WoodsBrass percussion = new WoodsBrass();
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

