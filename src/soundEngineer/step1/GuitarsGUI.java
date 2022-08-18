package soundEngineer.step1;

import soundEngineer.server.ProjectData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuitarsGUI extends GUIStamp{
    public final String IMAGE_FILE_NAME = "guitars.jpg";
    private JLabel bassGuitarLabel = new JLabel("Bass Guitar:");
    private JLabel elGuitarLabel = new JLabel("Electro Guitar:");
    private JLabel accGuitarsLabel = new JLabel("Accoustic Guitar:");
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

    public GuitarsGUI() throws HeadlessException {
        pageNameLabel.setText("Select Guitars");
//gui elements start
//labels
        bassGuitarLabel.setBounds(100,50,100,20);
        container.add(bassGuitarLabel);
        elGuitarLabel.setBounds(350,50,150,20);
        container.add(elGuitarLabel);
        accGuitarsLabel.setBounds(600,50,150,20);
        container.add(accGuitarsLabel);
//bass control start
        ButtonGroup bassGroup = new ButtonGroup();

        monoBassRadioButton.setActionCommand("1");
        monoBassRadioButton.setBackground(Color.green);
        monoBassRadioButton.setBounds(100,75,80,20);
        monoBassRadioButton.setSelected(true);
        container.add(monoBassRadioButton);
        bassGroup.add(monoBassRadioButton);

        stereoBassRadioButton.setActionCommand("2");
        stereoBassRadioButton.setBackground(Color.green);
        stereoBassRadioButton.setBounds(100,100,80,20);
        container.add(stereoBassRadioButton);
        bassGroup.add(stereoBassRadioButton);

        noBassRadioButton.setActionCommand("3");
        noBassRadioButton.setBackground(Color.green);
        noBassRadioButton.setBounds(100,125,80,20);
        container.add(noBassRadioButton);
        bassGroup.add(noBassRadioButton);

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
        }else if (ProjectData.guitarStrips.contains("EGt2") && !ProjectData.guitarStrips.contains("EGt3")){
            monoEGuitarsNumber.setSelectedItem(2);
        }else if (ProjectData.guitarStrips.contains("EGt3")){
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
        }else if (ProjectData.guitarStrips.contains("EG2L") && !ProjectData.guitarStrips.contains("EG3L")){
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
        }else if (ProjectData.guitarStrips.contains("AGt3")){
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
//gui elements end

//Button apply start
            buttonApply.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                ProjectData.guitarStrips.clear();
//bass to arraylist setup
                    String selectedBass = bassGroup.getSelection().getActionCommand();
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
                    switch ((int)monoEGuitarsNumber.getSelectedItem()){
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
                    switch ((int) stereoEGuitarsNumber.getSelectedItem()){
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
                    switch ((int) monoAGuitarsNumber.getSelectedItem()){
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
//stereo aguitars to arraylist setup
                    switch ((int)stereoAGuitarsNumber.getSelectedItem()){
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
                    theseChannelsLabel.setText("These Channels: " + ProjectData.guitarStrips.size());
                    DefineInstruments.buttonGuitars.setText("Guitars" + ProjectData.guitarStrips.size());
                }
            });
//Button apply end
//button no one
        buttonNoOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                noBassRadioButton.setSelected(true);
                monoEGuitarsNumber.setSelectedItem(0);
                stereoEGuitarsNumber.setSelectedItem(0);
                monoAGuitarsNumber.setSelectedItem(0);
                stereoAGuitarsNumber.setSelectedItem(0);
            }
        });
        }
}
