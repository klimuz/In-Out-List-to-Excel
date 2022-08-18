package soundEngineer.step1;

import soundEngineer.server.ProjectData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Synths extends GUIStamp {
    public final String IMAGE_FILE_NAME = "synths.jpg";
        private JLabel synth1Label = new JLabel("Synth1");
        private JLabel synth2Label = new JLabel("Synth2");
        private JLabel synth3Label = new JLabel("Synth3");
        private JLabel pianoLabel = new JLabel("Piano");
    private JComboBox<String> synt1Number = new JComboBox();
    private JComboBox<String> synt2Number = new JComboBox();
    private JComboBox<String> synt3Number = new JComboBox();
    private JComboBox<String> pianoNumber = new JComboBox();

        public Synths() throws HeadlessException {
            pageNameLabel.setText("Select Synthesizers");
//elements start
//labels
            synth1Label.setBounds(85, 20, 40, 50);
            container.add(synth1Label);
            synth2Label.setBounds(265, 75, 40, 50);
            container.add(synth2Label);
            synth3Label.setBounds(460, 150, 40, 50);
            container.add(synth3Label);
            pianoLabel.setBounds(650, 60, 40, 50);
            container.add(pianoLabel);
//syn1
            synt1Number.addItemListener(this);
            synt1Number.addItem("Mono");
            synt1Number.addItem("Stereo");
            synt1Number.addItem("No one");
            if (ProjectData.keyboardStrips.contains("Synt") || ProjectData.keyboardStrips.contains("Syn1")){
                synt1Number.setSelectedItem("Mono");
            }else if (ProjectData.keyboardStrips.contains("Sy1L")){
                synt1Number.setSelectedItem("Stereo");
            }else {synt1Number.setSelectedItem("No one");}
            synt1Number.setBounds(65, 125,80, 20);
            container.add(synt1Number);
//syn2
            synt2Number.addItemListener(this);
            synt2Number.addItem("Mono");
            synt2Number.addItem("Stereo");
            synt2Number.addItem("No one");
            if (ProjectData.keyboardStrips.contains("Syn2") ){
                synt2Number.setSelectedItem("Mono");
            }else if (ProjectData.keyboardStrips.contains("Sy2L")){
                synt2Number.setSelectedItem("Stereo");
            }else {synt2Number.setSelectedItem("No one");}
            synt2Number.setBounds(245, 195,80, 20);
            container.add(synt2Number);
//syn3
            synt3Number.addItemListener(this);
            synt3Number.addItem("Mono");
            synt3Number.addItem("Stereo");
            synt3Number.addItem("No one");
            if (ProjectData.keyboardStrips.contains("Syn3")){
                synt3Number.setSelectedItem("Mono");
            }else if (ProjectData.keyboardStrips.contains("Sy3L")){
                synt3Number.setSelectedItem("Stereo");
            }else {synt3Number.setSelectedItem("No one");}
            synt3Number.setBounds(440, 258,80, 20);
            container.add(synt3Number);
//piano
            pianoNumber.addItemListener(this);
            pianoNumber.addItem("1");
            pianoNumber.addItem("2");
            pianoNumber.addItem("No one");
            if (ProjectData.keyboardStrips.contains("Pno")){
                pianoNumber.setSelectedItem("1");
            }else if (ProjectData.keyboardStrips.contains("PnoH")){
                pianoNumber.setSelectedItem("2");
            }else {pianoNumber.setSelectedItem("No one");}
            pianoNumber.setBounds(640, 210,80, 20);
            container.add(pianoNumber);
//elements end

//Button apply start
            buttonApply.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ProjectData.keyboardStrips.clear();
//syn1
                    String syn1Sel = synt1Number.getSelectedItem().toString();
                    switch (syn1Sel) {
                        case "Mono":
                            if (synt2Number.getSelectedItem() == "No one"){
                                ProjectData.keyboardStrips.add("Synt");
                            }else {
                                ProjectData.keyboardStrips.add("Syn1");
                            }
                            break;
                        case "Stereo":
                            if (synt2Number.getSelectedItem() == "No one"){
                                ProjectData.keyboardStrips.add("SynL");
                                ProjectData.keyboardStrips.add("SynR");
                            }else {
                                ProjectData.keyboardStrips.add("Sy1L");
                                ProjectData.keyboardStrips.add("Sy1R");
                            }
                            break;

                    }
                    String syn2Sel = synt2Number.getSelectedItem().toString();
                    switch (syn2Sel) {
                        case "Mono":
                            ProjectData.keyboardStrips.add("Syn2");
                            break;
                        case "Stereo":
                            ProjectData.keyboardStrips.add("Sy2L");
                            ProjectData.keyboardStrips.add("Sy2R");
                            break;
                    }
                    String syn3Sel = synt3Number.getSelectedItem().toString();
                    switch (syn3Sel) {
                        case "Mono":
                            ProjectData.keyboardStrips.add("Syn3");
                            break;
                        case "Stereo":
                            ProjectData.keyboardStrips.add("Sy3L");
                            ProjectData.keyboardStrips.add("Sy3R");
                            break;
                    }
                    switch (synt3Number.getSelectedItem().toString()) {
                        case "1":
                            ProjectData.keyboardStrips.add("Pno");
                            break;
                        case "2":
                            ProjectData.keyboardStrips.add("PnoH");
                            ProjectData.keyboardStrips.add("PnoL");
                            break;
                    }
                    theseChannelsLabel.setText("These Channels: " + ProjectData.keyboardStrips.size());
                    DefineInstruments.buttonSynths.setText("Keys" + ProjectData.keyboardStrips.size());
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
