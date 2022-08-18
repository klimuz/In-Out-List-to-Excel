package soundEngineer.step1;

import soundEngineer.server.ProjectData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AcousticDrumsGUI extends GUIStamp{
    public final String IMAGE_FILE_NAME = "acousticDrums.jpg";

    private JLabel overLabel = new JLabel("OverHead");
    private JLabel kicksLabel = new JLabel("Kicks:");
    private JLabel trigLabel = new JLabel("Trigger");
    private JLabel snaresLabel = new JLabel("Snares:");
    private JLabel hatLabel = new JLabel("Hat:");
    private JLabel rackTomsLabel = new JLabel("Rack Toms:");
    private JLabel floorTomsLabel = new JLabel("Floor Toms:");
    private JLabel snare2Label = new JLabel("Snare2:");
    private JLabel drumMachineLabel = new JLabel("Drum Machine:");

    private JComboBox<String> kicksNumber = new JComboBox();
    private JComboBox<String> snaresNumber = new JComboBox();
    private JComboBox<String> hatsNumber = new JComboBox();
    private JComboBox<String> rackTomsNumber = new JComboBox();
    private JComboBox<String> floorTomsNumber = new JComboBox();
    private JComboBox<String> overNumber = new JComboBox();
    private JComboBox<String> snare2Number = new JComboBox();
    private JComboBox<String> drumMachNumber = new JComboBox();
    private JCheckBox anyTrigger = new JCheckBox();
//constructor
    public AcousticDrumsGUI() throws HeadlessException {
        pageNameLabel.setBounds(100, 5, 300, 50);
        pageNameLabel.setText("Select Drums");
//logic
//kick
        kicksNumber.addItemListener(this);
        kicksNumber.addItem("0");
        kicksNumber.addItem("1");
        kicksNumber.addItem("2");
        if (ProjectData.drumStrips.contains("Kick")) {
            kicksNumber.setSelectedItem("1");
        } else if (ProjectData.drumStrips.contains("BD2")) {
            kicksNumber.setSelectedItem("2");
        }
        kicksLabel.setBounds(330, 240, 38, 20);
        kicksLabel.setBackground(Color.cyan);
        kicksLabel.setOpaque(true);
        container.add(kicksLabel);
        kicksNumber.setBounds(375, 240, 40, 20);
        container.add(kicksNumber);
//trig
        trigLabel.setBounds(330, 300, 45, 20);
        trigLabel.setBackground(Color.cyan);
        trigLabel.setOpaque(true);
        container.add(trigLabel);
        anyTrigger.setBounds(375, 300, 20, 20);
        if (ProjectData.drumStrips.contains("Trig")) {
            anyTrigger.setSelected(true);
        } else anyTrigger.setSelected(false);
        container.add(anyTrigger);
//snare1
        snaresNumber.addItemListener(this);
        snaresNumber.addItem("no one");
        snaresNumber.addItem("just top");
        snaresNumber.addItem("top+bottom");
        if (ProjectData.drumStrips.contains("Sn1B") || ProjectData.drumStrips.contains("SD B")) {
            snaresNumber.setSelectedItem("top+bottom");
        } else if (ProjectData.drumStrips.contains("SD") || ProjectData.drumStrips.contains("SD1")) {
            snaresNumber.setSelectedItem("just top");
        } else snaresNumber.setSelectedItem("no one");
        snaresLabel.setOpaque(true);
        snaresLabel.setBackground(Color.cyan);
        snaresLabel.setBounds(395, 165, 48, 20);
        container.add(snaresLabel);
        snaresNumber.setBounds(445, 165, 90, 20);
        container.add(snaresNumber);
//snare2
        snare2Number.addItemListener(this);
        snare2Number.addItem("no one");
        snare2Number.addItem("just top");
        snare2Number.addItem("top+bottom");
        if (snaresNumber.getSelectedItem() != "no one") {
            snare2Number.setEnabled(true);
        }
        if (ProjectData.drumStrips.contains("Sn2B")) {
            snare2Number.setSelectedItem("top+bottom");
        } else if (ProjectData.drumStrips.contains("SD2")) {
            snare2Number.setSelectedItem("just top");
        } else snare2Number.setSelectedItem("no one");
        snare2Label.setOpaque(true);
        snare2Label.setBackground(Color.cyan);
        snare2Label.setBounds(645, 95, 48, 20);
        container.add(snare2Label);
        snare2Number.setBounds(625, 120, 90, 20);
        container.add(snare2Number);
//hat
        hatsNumber.addItemListener(this);
        hatsNumber.addItem("0");
        hatsNumber.addItem("1");
        if (ProjectData.drumStrips.contains("Hat")) {
            hatsNumber.setSelectedItem("1");
        } else hatsNumber.setSelectedItem("0");
        hatLabel.setOpaque(true);
        hatLabel.setBackground(Color.cyan);
        hatLabel.setBounds(517, 90, 25, 20);
        container.add(hatLabel);
        hatsNumber.setBounds(545, 90, 40, 20);
        container.add(hatsNumber);
//toms
        rackTomsNumber.addItemListener(this);
        rackTomsNumber.addItem("0");
        rackTomsNumber.addItem("1");
        rackTomsNumber.addItem("2");
        rackTomsNumber.addItem("3");
        rackTomsNumber.addItem("4");
        if (!ProjectData.drumStrips.contains("Tom") && !ProjectData.drumStrips.contains("Tom1")) {
            rackTomsNumber.setSelectedItem("0");
        } else if (ProjectData.drumStrips.contains("Tom")) {
            rackTomsNumber.setSelectedItem("1");
        } else if (ProjectData.drumStrips.contains("Tom2") && !ProjectData.drumStrips.contains("Tom3")) {
            rackTomsNumber.setSelectedItem("2");
        } else if (ProjectData.drumStrips.contains("Tom3") && !ProjectData.drumStrips.contains("Tom4")) {
            rackTomsNumber.setSelectedItem("3");
        } else if (ProjectData.drumStrips.contains("Tom4")) {
            rackTomsNumber.setSelectedItem("4");
        }
        rackTomsLabel.setOpaque(true);
        rackTomsLabel.setBackground(Color.cyan);
        rackTomsLabel.setBounds(310, 110, 70, 20);
        container.add(rackTomsLabel);
        rackTomsNumber.setBounds(390, 110, 40, 20);
        container.add(rackTomsNumber);
//floor toms
        floorTomsNumber.addItemListener(this);
        floorTomsNumber.addItem("0");
        floorTomsNumber.addItem("1");
        floorTomsNumber.addItem("2");
        floorTomsNumber.addItem("3");
        floorTomsNumber.addItem("4");
        if (!ProjectData.drumStrips.contains("FTom") && !ProjectData.drumStrips.contains("FTo1")) {
            floorTomsNumber.setSelectedItem("0");
        } else if (ProjectData.drumStrips.contains("FTom")) {
            floorTomsNumber.setSelectedItem("1");
        } else if (ProjectData.drumStrips.contains("FTo2") && !ProjectData.drumStrips.contains("FTo3")) {
            floorTomsNumber.setSelectedItem("2");
        } else if (ProjectData.drumStrips.contains("FTo3") && !ProjectData.drumStrips.contains("FTo4")) {
            floorTomsNumber.setSelectedItem("3");
        } else if (ProjectData.drumStrips.contains("FTo4")) {
            floorTomsNumber.setSelectedItem("4");
        }
            floorTomsLabel.setOpaque(true);
            floorTomsLabel.setBackground(Color.cyan);
            floorTomsLabel.setBounds(205, 180, 70, 20);
            container.add(floorTomsLabel);
            floorTomsNumber.setBounds(280, 180, 40, 20);
            container.add(floorTomsNumber);

//overhead
            overNumber.addItemListener(this);
            overNumber.addItem("0");
            overNumber.addItem("1");
            overNumber.addItem("2");
            if (ProjectData.drumStrips.contains("Over")) {
                overNumber.setSelectedItem("1");
            } else if (ProjectData.drumStrips.contains("OH2")) overNumber.setSelectedItem("2");
            else overNumber.setSelectedItem("0");
            overLabel.setOpaque(true);
            overLabel.setBackground(Color.cyan);
            overLabel.setBounds(350, 10, 60, 20);
            container.add(overLabel);
            overNumber.setBounds(360, 35, 40, 20);
            container.add(overNumber);
//drum machine
        drumMachNumber.addItemListener(this);
        drumMachNumber.addItem("0");
        drumMachNumber.addItem("1");
        drumMachNumber.addItem("2");
        drumMachNumber.addItem("3");
        drumMachNumber.addItem("stereo");
        if (!ProjectData.drumStrips.contains("ElDr") && !ProjectData.drumStrips.contains("EDr1") && !ProjectData.drumStrips.contains("EDrL")) {
            drumMachNumber.setSelectedItem("0");
        } else if (ProjectData.drumStrips.contains("ElDr")) {
            drumMachNumber.setSelectedItem("1");
        } else if (ProjectData.drumStrips.contains("EDr2") && !ProjectData.drumStrips.contains("EDr3")) {
            drumMachNumber.setSelectedItem("2");
        } else if (ProjectData.drumStrips.contains("EDr3")) {
            drumMachNumber.setSelectedItem("3");
        } else if (ProjectData.drumStrips.contains("EDrL")) {
            drumMachNumber.setSelectedItem("stereo");
        }
        drumMachineLabel.setOpaque(true);
        drumMachineLabel.setBackground(Color.cyan);
        drumMachineLabel.setBounds(70, 185, 90, 20);
        container.add(drumMachineLabel);
        drumMachNumber.setBounds(80, 210, 70, 20);
        container.add(drumMachNumber);
//Button apply start
            buttonApply.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonNext.setEnabled(true);
                    ProjectData.drumStrips.clear();
//kick
                    if (kicksNumber.getSelectedItem() == "1") {
                        ProjectData.drumStrips.add("Kick");
                    } else if (kicksNumber.getSelectedItem() == "2") {
                        ProjectData.drumStrips.add("BD1");
                        ProjectData.drumStrips.add("BD2");
                    }
//trigger
                    if (anyTrigger.isSelected()) {
                        ProjectData.drumStrips.add("Trig");
                    }
                    //snare1
                    if (snaresNumber.getSelectedItem() == "just top" && snare2Number.getSelectedItem() == "no one") {
                        ProjectData.drumStrips.add("SD");
                    } else if (snaresNumber.getSelectedItem() == "just top" && snare2Number.getSelectedItem() != "no one") {
                        ProjectData.drumStrips.add("SD1");
                    } else if (snaresNumber.getSelectedItem() == "top+bottom" && snare2Number.getSelectedItem() == "no one") {
                        ProjectData.drumStrips.add("SD T");
                        ProjectData.drumStrips.add("SD B");
                    } else if (snaresNumber.getSelectedItem() == "top+bottom" && snare2Number.getSelectedItem() != "no one") {
                        ProjectData.drumStrips.add("Sn1T");
                        ProjectData.drumStrips.add("Sn1B");
                    }
//snare2
                    if (snare2Number.getSelectedItem() == "just top") {
                        ProjectData.drumStrips.add("SD2");
                    } else if (snare2Number.getSelectedItem() == "top+bottom") {
                        ProjectData.drumStrips.add("Sn2T");
                        ProjectData.drumStrips.add("Sn2B");
                    }
//hat
                    if (hatsNumber.getSelectedItem() == "1") ProjectData.drumStrips.add("Hat");
//toms
                    if (rackTomsNumber.getSelectedItem() == "1") {
                        ProjectData.drumStrips.add("Tom");
                    } else if (rackTomsNumber.getSelectedItem() == "2") {
                        ProjectData.drumStrips.add("Tom1");
                        ProjectData.drumStrips.add("Tom2");
                    } else if (rackTomsNumber.getSelectedItem() == "3") {
                        ProjectData.drumStrips.add("Tom1");
                        ProjectData.drumStrips.add("Tom2");
                        ProjectData.drumStrips.add("Tom3");
                    } else if (rackTomsNumber.getSelectedItem() == "4") {
                        ProjectData.drumStrips.add("Tom1");
                        ProjectData.drumStrips.add("Tom2");
                        ProjectData.drumStrips.add("Tom3");
                        ProjectData.drumStrips.add("Tom4");
                    }
//floor toms
                    if (floorTomsNumber.getSelectedItem() == "1") {
                        ProjectData.drumStrips.add("FTom");
                    } else if (floorTomsNumber.getSelectedItem() == "2") {
                        ProjectData.drumStrips.add("FTo1");
                        ProjectData.drumStrips.add("FTo2");
                    } else if (floorTomsNumber.getSelectedItem() == "3") {
                        ProjectData.drumStrips.add("FTo1");
                        ProjectData.drumStrips.add("FTo2");
                        ProjectData.drumStrips.add("FTo3");
                    } else if (floorTomsNumber.getSelectedItem() == "4") {
                        ProjectData.drumStrips.add("FTo1");
                        ProjectData.drumStrips.add("FTo2");
                        ProjectData.drumStrips.add("FTo3");
                        ProjectData.drumStrips.add("FTo4");
                    }
                    if (overNumber.getSelectedItem() == "1") {
                        ProjectData.drumStrips.add("Over");
                    } else if (overNumber.getSelectedItem() == "2") {
                        ProjectData.drumStrips.add("OH1");
                        ProjectData.drumStrips.add("OH2");
                    }
//drum machine
                    if (drumMachNumber.getSelectedItem() == "1"){
                        ProjectData.drumStrips.add("ElDr");
                    }else if (drumMachNumber.getSelectedItem() == "2"){
                        ProjectData.drumStrips.add("EDr1");
                        ProjectData.drumStrips.add("EDr2");
                    }else if (drumMachNumber.getSelectedItem() == "3"){
                        ProjectData.drumStrips.add("EDr1");
                        ProjectData.drumStrips.add("EDr2");
                        ProjectData.drumStrips.add("EDr3");
                    }else if (drumMachNumber.getSelectedItem() == "stereo"){
                        ProjectData.drumStrips.add("EDrL");
                        ProjectData.drumStrips.add("EDrR");
                    }
                    theseChannelsLabel.setText("These Channels: " + ProjectData.drumStrips.size());
                    DefineInstruments.buttonDrums.setText("Drums" + ProjectData.drumStrips.size());
                }
            });
//Button apply end
//button no one
        buttonNoOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kicksNumber.setSelectedItem("0");
                anyTrigger.setSelected(false);
                snaresNumber.setSelectedItem("no one");
                snare2Number.setSelectedItem("no one");
                hatsNumber.setSelectedItem("0");
                rackTomsNumber.setSelectedItem("0");
                floorTomsNumber.setSelectedItem("0");
                overNumber.setSelectedItem("0");
            }
        });

    }
}


