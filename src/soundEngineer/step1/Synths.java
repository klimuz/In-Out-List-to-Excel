package soundEngineer.step1;

import soundEngineer.server.ProjectData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Synths extends GUIStamp {

        private JLabel synth1Label = new JLabel("Synth1");
        private JLabel synth2Label = new JLabel("Synth2");
        private JLabel synth3Label = new JLabel("Synth3");
    private JComboBox<String> synt1Number = new JComboBox();
    private JComboBox<String> synt2Number = new JComboBox();
    private JComboBox<String> synt3Number = new JComboBox();

        public Synths() throws HeadlessException {
            super("img/synths.jpg");
            pageNameLabel.setText("Select Synthesizers");
//elements start
//labels
            synth1Label.setBounds(120, 50, 40, 50);
            container.add(synth1Label);
            synth2Label.setBounds(375, 50, 40, 50);
            container.add(synth2Label);
            synth3Label.setBounds(650, 50, 40, 50);
            container.add(synth3Label);
//syn1
            synt1Number.addItemListener(this);
            synt1Number.addItem("Mono");
            synt1Number.addItem("Stereo");
            synt1Number.addItem("No one");
            if (ProjectData.synthStrips.contains("Synt") || ProjectData.synthStrips.contains("Syn1")){
                synt1Number.setSelectedItem("Mono");
            }else if (ProjectData.synthStrips.contains("Sy1L")){
                synt1Number.setSelectedItem("Stereo");
            }else {synt1Number.setSelectedItem("No one");}
            synt1Number.setBounds(100, 250,80, 20);
            container.add(synt1Number);
//syn2
            synt2Number.addItemListener(this);
            synt2Number.addItem("Mono");
            synt2Number.addItem("Stereo");
            synt2Number.addItem("No one");
            if (ProjectData.synthStrips.contains("Syn2") ){
                synt2Number.setSelectedItem("Mono");
            }else if (ProjectData.synthStrips.contains("Sy2L")){
                synt2Number.setSelectedItem("Stereo");
            }else {synt2Number.setSelectedItem("No one");}
            synt2Number.setBounds(355, 250,80, 20);
            container.add(synt2Number);
//syn3
            synt3Number.addItemListener(this);
            synt3Number.addItem("Mono");
            synt3Number.addItem("Stereo");
            synt3Number.addItem("No one");
            if (ProjectData.synthStrips.contains("Syn3")){
                synt3Number.setSelectedItem("Mono");
            }else if (ProjectData.synthStrips.contains("Sy3L")){
                synt3Number.setSelectedItem("Stereo");
            }else {synt3Number.setSelectedItem("No one");}
            synt3Number.setBounds(630, 250,80, 20);
            container.add(synt3Number);
//elements end

//Button apply start
            buttonApply.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ProjectData.synthStrips.clear();
//syn1
                    String syn1Sel = synt1Number.getSelectedItem().toString();
                    switch (syn1Sel) {
                        case "Mono":
                            if (synt2Number.getSelectedItem() == "No one"){
                                ProjectData.synthStrips.add("Synt");
                            }else {
                                ProjectData.synthStrips.add("Syn1");
                            }
                            break;
                        case "Stereo":
                            if (synt2Number.getSelectedItem() == "No one"){
                                ProjectData.synthStrips.add("SynL");
                                ProjectData.synthStrips.add("SynR");
                            }else {
                                ProjectData.synthStrips.add("Sy1L");
                                ProjectData.synthStrips.add("Sy1R");
                            }
                            break;

                    }
                    String syn2Sel = synt2Number.getSelectedItem().toString();
                    switch (syn2Sel) {
                        case "Mono":
                            ProjectData.synthStrips.add("Syn2");
                            break;
                        case "Stereo":
                            ProjectData.synthStrips.add("Sy2L");
                            ProjectData.synthStrips.add("Sy2R");
                            break;
                    }
                    String syn3Sel = synt3Number.getSelectedItem().toString();
                    switch (syn3Sel) {
                        case "Mono":
                            ProjectData.synthStrips.add("Syn3");
                            break;
                        case "Stereo":
                            ProjectData.synthStrips.add("Sy3L");
                            ProjectData.synthStrips.add("Sy3R");
                            break;
                    }
                    theseChannelsLabel.setText("These Channels: " + ProjectData.synthStrips.size());
                    DefineInstruments.buttonSynths.setText("Synths" + ProjectData.synthStrips.size());
                }
            });
//Button apply end
//button no one
            buttonNoOne.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    synt1Number.setSelectedItem("No one");
                    synt2Number.setSelectedItem("No one");
                    synt3Number.setSelectedItem("No one");
                }
            });
        }
}
