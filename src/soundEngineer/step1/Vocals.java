package soundEngineer.step1;

import soundEngineer.server.ProjectData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Vocals extends GUIStamp {
    public final String IMAGE_FILE_NAME = "vocs.jpg";
    private JLabel leadVocLabel = new JLabel("Lead vocal");
    private JLabel backVocLabel = new JLabel("Back vocal");
    private JLabel choirLabel = new JLabel("Choir");

    private JComboBox<Integer> leadVocNumber = new JComboBox();
    private JComboBox<Integer> backVocNumber = new JComboBox();
    private JComboBox<Integer> choirNumber = new JComboBox();

    public Vocals() throws HeadlessException {
        pageNameLabel.setForeground(Color.orange);
        pageNameLabel.setText(" Select Vocals");
//gui elements start
//labels
        leadVocLabel.setBounds(100, 150, 70, 20);
        leadVocLabel.setBackground(Color.BLUE);
        leadVocLabel.setForeground(Color.orange);
        leadVocLabel.setOpaque(true);
        container.add(leadVocLabel);
        backVocLabel.setBounds(400, 150, 70, 20);
        backVocLabel.setBackground(Color.BLUE);
        backVocLabel.setForeground(Color.orange);
        backVocLabel.setOpaque(true);
        container.add(backVocLabel);
        choirLabel.setBounds(700, 150, 70, 20);
        choirLabel.setBackground(Color.BLUE);
        choirLabel.setForeground(Color.orange);
        choirLabel.setOpaque(true);
        container.add(choirLabel);
        allChannelsLabel.setForeground(Color.orange);
        theseChannelsLabel.setForeground(Color.orange);

//main vocals
        leadVocNumber.addItem(0);
        leadVocNumber.addItem(1);
        leadVocNumber.addItem(2);
        leadVocNumber.addItem(3);
        leadVocNumber.addItem(4);
        leadVocNumber.addItem(5);
        leadVocNumber.addItem(6);
        leadVocNumber.addItem(7);
        leadVocNumber.addItem(8);
        leadVocNumber.addItem(9);
        leadVocNumber.addItem(10);
        leadVocNumber.addItemListener(this);
        if (ProjectData.vocalStrips.contains("MV")){
            leadVocNumber.setSelectedItem(1);
        }else if (!ProjectData.vocalStrips.contains("MV3") && ProjectData.vocalStrips.contains("MV2")){
            leadVocNumber.setSelectedItem(2);
        }else if (!ProjectData.vocalStrips.contains("MV4") && ProjectData.vocalStrips.contains("MV3")){
            leadVocNumber.setSelectedItem(3);
        }else if (!ProjectData.vocalStrips.contains("MV5") && ProjectData.vocalStrips.contains("MV4")){
            leadVocNumber.setSelectedItem(4);
        }else if (!ProjectData.vocalStrips.contains("MV6") && ProjectData.vocalStrips.contains("MV5")){
            leadVocNumber.setSelectedItem(5);
        }else if (!ProjectData.vocalStrips.contains("MV7") && ProjectData.vocalStrips.contains("MV6")){
            leadVocNumber.setSelectedItem(6);
        }else if (!ProjectData.vocalStrips.contains("MV8") && ProjectData.vocalStrips.contains("MV7")){
            leadVocNumber.setSelectedItem(7);
        }else if (!ProjectData.vocalStrips.contains("MV9") && ProjectData.vocalStrips.contains("MV8")){
            leadVocNumber.setSelectedItem(8);
        }else if (!ProjectData.vocalStrips.contains("MV10") && ProjectData.vocalStrips.contains("MV9")){
            leadVocNumber.setSelectedItem(9);
        }else if (ProjectData.vocalStrips.contains("MV10")){
            leadVocNumber.setSelectedItem(10);
        }
        leadVocNumber.setBounds(110, 170, 40, 20);
        container.add(leadVocNumber);
//back vocals
        backVocNumber.addItem(0);
        backVocNumber.addItem(1);
        backVocNumber.addItem(2);
        backVocNumber.addItem(3);
        backVocNumber.addItem(4);
        backVocNumber.addItem(5);
        backVocNumber.addItem(6);
        backVocNumber.addItem(7);
        backVocNumber.addItem(8);
        backVocNumber.addItem(9);
        backVocNumber.addItem(10);
        backVocNumber.addItemListener(this);
        if (ProjectData.vocalStrips.contains("BV")){
            backVocNumber.setSelectedItem(1);
        }else if (!ProjectData.vocalStrips.contains("BV3") && ProjectData.vocalStrips.contains("BV2")){
            backVocNumber.setSelectedItem(2);
        }else if (!ProjectData.vocalStrips.contains("BV4") && ProjectData.vocalStrips.contains("BV3")){
            backVocNumber.setSelectedItem(3);
        }else if (!ProjectData.vocalStrips.contains("BV5") && ProjectData.vocalStrips.contains("BV4")){
            backVocNumber.setSelectedItem(4);
        }else if (!ProjectData.vocalStrips.contains("BV6") && ProjectData.vocalStrips.contains("BV5")){
            backVocNumber.setSelectedItem(5);
        }else if (!ProjectData.vocalStrips.contains("BV7") && ProjectData.vocalStrips.contains("BV6")){
            backVocNumber.setSelectedItem(6);
        }else if (!ProjectData.vocalStrips.contains("BV8") && ProjectData.vocalStrips.contains("BV7")){
            backVocNumber.setSelectedItem(7);
        }else if (!ProjectData.vocalStrips.contains("BV9") && ProjectData.vocalStrips.contains("BV8")){
            backVocNumber.setSelectedItem(8);
        }else if (!ProjectData.vocalStrips.contains("BV10") && ProjectData.vocalStrips.contains("BV9")){
            backVocNumber.setSelectedItem(9);
        }else if (ProjectData.vocalStrips.contains("BV10")){
            backVocNumber.setSelectedItem(10);
        }
        backVocNumber.setBounds(410, 170, 40, 20);
        container.add(backVocNumber);
//Choir
        choirNumber.addItem(0);
        choirNumber.addItem(1);
        choirNumber.addItem(2);
        choirNumber.addItem(3);
        choirNumber.addItem(4);
        choirNumber.addItem(5);
        choirNumber.addItem(6);
        choirNumber.addItem(7);
        choirNumber.addItem(8);
        choirNumber.addItem(9);
        choirNumber.addItem(10);
        choirNumber.addItemListener(this);
        if (ProjectData.vocalStrips.contains("Chor")){
            choirNumber.setSelectedItem(1);
        }else if (!ProjectData.vocalStrips.contains("Cho3") && ProjectData.vocalStrips.contains("Cho2")){
            choirNumber.setSelectedItem(2);
        }else if (!ProjectData.vocalStrips.contains("Cho4") && ProjectData.vocalStrips.contains("Cho3")){
            choirNumber.setSelectedItem(3);
        }else if (!ProjectData.vocalStrips.contains("Cho5") && ProjectData.vocalStrips.contains("Cho4")){
            choirNumber.setSelectedItem(4);
        }else if (!ProjectData.vocalStrips.contains("Cho6") && ProjectData.vocalStrips.contains("Cho5")){
            choirNumber.setSelectedItem(5);
        }else if (!ProjectData.vocalStrips.contains("Cho7") && ProjectData.vocalStrips.contains("Cho6")){
            choirNumber.setSelectedItem(6);
        }else if (!ProjectData.vocalStrips.contains("Cho8") && ProjectData.vocalStrips.contains("Cho7")){
            choirNumber.setSelectedItem(7);
        }else if (!ProjectData.vocalStrips.contains("Cho9") && ProjectData.vocalStrips.contains("Cho8")){
            choirNumber.setSelectedItem(8);
        }else if (!ProjectData.vocalStrips.contains("Cho10") && ProjectData.vocalStrips.contains("Cho9")){
            choirNumber.setSelectedItem(9);
        }else if (ProjectData.vocalStrips.contains("Cr10")){
            choirNumber.setSelectedItem(10);
        }
        choirNumber.setBounds(710, 170, 40, 20);
        container.add(choirNumber);
//elements end

//Button apply start
        buttonApply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectData.vocalStrips.clear();
//main vocals
                switch ((int) leadVocNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.vocalStrips.add("MV");
                        break;
                    case 2:
                        ProjectData.vocalStrips.add("MV1");
                        ProjectData.vocalStrips.add("MV2");
                        break;
                    case 3:
                        ProjectData.vocalStrips.add("MV1");
                        ProjectData.vocalStrips.add("MV2");
                        ProjectData.vocalStrips.add("MV3");
                        break;
                    case 4:
                        ProjectData.vocalStrips.add("MV1");
                        ProjectData.vocalStrips.add("MV2");
                        ProjectData.vocalStrips.add("MV3");
                        ProjectData.vocalStrips.add("MV4");
                        break;
                    case 5:
                        ProjectData.vocalStrips.add("MV1");
                        ProjectData.vocalStrips.add("MV2");
                        ProjectData.vocalStrips.add("MV3");
                        ProjectData.vocalStrips.add("MV4");
                        ProjectData.vocalStrips.add("MV5");
                        break;
                    case 6:
                        ProjectData.vocalStrips.add("MV1");
                        ProjectData.vocalStrips.add("MV2");
                        ProjectData.vocalStrips.add("MV3");
                        ProjectData.vocalStrips.add("MV4");
                        ProjectData.vocalStrips.add("MV5");
                        ProjectData.vocalStrips.add("MV6");
                        break;
                    case 7:
                        ProjectData.vocalStrips.add("MV1");
                        ProjectData.vocalStrips.add("MV2");
                        ProjectData.vocalStrips.add("MV3");
                        ProjectData.vocalStrips.add("MV4");
                        ProjectData.vocalStrips.add("MV5");
                        ProjectData.vocalStrips.add("MV6");
                        ProjectData.vocalStrips.add("MV7");
                        break;
                    case 8:
                        ProjectData.vocalStrips.add("MV1");
                        ProjectData.vocalStrips.add("MV2");
                        ProjectData.vocalStrips.add("MV3");
                        ProjectData.vocalStrips.add("MV4");
                        ProjectData.vocalStrips.add("MV5");
                        ProjectData.vocalStrips.add("MV6");
                        ProjectData.vocalStrips.add("MV7");
                        ProjectData.vocalStrips.add("MV8");
                        break;
                    case 9:
                        ProjectData.vocalStrips.add("MV1");
                        ProjectData.vocalStrips.add("MV2");
                        ProjectData.vocalStrips.add("MV3");
                        ProjectData.vocalStrips.add("MV4");
                        ProjectData.vocalStrips.add("MV5");
                        ProjectData.vocalStrips.add("MV6");
                        ProjectData.vocalStrips.add("MV7");
                        ProjectData.vocalStrips.add("MV8");
                        ProjectData.vocalStrips.add("MV9");
                        break;
                    case 10:
                        ProjectData.vocalStrips.add("MV1");
                        ProjectData.vocalStrips.add("MV2");
                        ProjectData.vocalStrips.add("MV3");
                        ProjectData.vocalStrips.add("MV4");
                        ProjectData.vocalStrips.add("MV5");
                        ProjectData.vocalStrips.add("MV6");
                        ProjectData.vocalStrips.add("MV7");
                        ProjectData.vocalStrips.add("MV8");
                        ProjectData.vocalStrips.add("MV9");
                        ProjectData.vocalStrips.add("MV10");
                        break;
                }
//back vocals
                switch ((int) backVocNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.vocalStrips.add("BV");
                        break;
                    case 2:
                        ProjectData.vocalStrips.add("BV1");
                        ProjectData.vocalStrips.add("BV2");
                        break;
                    case 3:
                        ProjectData.vocalStrips.add("BV1");
                        ProjectData.vocalStrips.add("BV2");
                        ProjectData.vocalStrips.add("BV3");
                        break;
                    case 4:
                        ProjectData.vocalStrips.add("BV1");
                        ProjectData.vocalStrips.add("BV2");
                        ProjectData.vocalStrips.add("BV3");
                        ProjectData.vocalStrips.add("BV4");
                        break;
                    case 5:
                        ProjectData.vocalStrips.add("BV1");
                        ProjectData.vocalStrips.add("BV2");
                        ProjectData.vocalStrips.add("BV3");
                        ProjectData.vocalStrips.add("BV4");
                        ProjectData.vocalStrips.add("BV5");
                        break;
                    case 6:
                        ProjectData.vocalStrips.add("BV1");
                        ProjectData.vocalStrips.add("BV2");
                        ProjectData.vocalStrips.add("BV3");
                        ProjectData.vocalStrips.add("BV4");
                        ProjectData.vocalStrips.add("BV5");
                        ProjectData.vocalStrips.add("BV6");
                        break;
                    case 7:
                        ProjectData.vocalStrips.add("BV1");
                        ProjectData.vocalStrips.add("BV2");
                        ProjectData.vocalStrips.add("BV3");
                        ProjectData.vocalStrips.add("BV4");
                        ProjectData.vocalStrips.add("BV5");
                        ProjectData.vocalStrips.add("BV6");
                        ProjectData.vocalStrips.add("BV7");
                        break;
                    case 8:
                        ProjectData.vocalStrips.add("BV1");
                        ProjectData.vocalStrips.add("BV2");
                        ProjectData.vocalStrips.add("BV3");
                        ProjectData.vocalStrips.add("BV4");
                        ProjectData.vocalStrips.add("BV5");
                        ProjectData.vocalStrips.add("BV6");
                        ProjectData.vocalStrips.add("BV7");
                        ProjectData.vocalStrips.add("BV8");
                        break;
                    case 9:
                        ProjectData.vocalStrips.add("BV1");
                        ProjectData.vocalStrips.add("BV2");
                        ProjectData.vocalStrips.add("BV3");
                        ProjectData.vocalStrips.add("BV4");
                        ProjectData.vocalStrips.add("BV5");
                        ProjectData.vocalStrips.add("BV6");
                        ProjectData.vocalStrips.add("BV7");
                        ProjectData.vocalStrips.add("BV8");
                        ProjectData.vocalStrips.add("BV9");
                        break;
                    case 10:
                        ProjectData.vocalStrips.add("BV1");
                        ProjectData.vocalStrips.add("BV2");
                        ProjectData.vocalStrips.add("BV3");
                        ProjectData.vocalStrips.add("BV4");
                        ProjectData.vocalStrips.add("BV5");
                        ProjectData.vocalStrips.add("BV6");
                        ProjectData.vocalStrips.add("BV7");
                        ProjectData.vocalStrips.add("BV8");
                        ProjectData.vocalStrips.add("BV9");
                        ProjectData.vocalStrips.add("BV10");
                        break;
                }
//Choir
                switch ((int) choirNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.vocalStrips.add("Chor");
                        break;
                    case 2:
                        ProjectData.vocalStrips.add("Cho1");
                        ProjectData.vocalStrips.add("Cho2");
                        break;
                    case 3:
                        ProjectData.vocalStrips.add("Cho1");
                        ProjectData.vocalStrips.add("Cho2");
                        ProjectData.vocalStrips.add("Cho3");
                        break;
                    case 4:
                        ProjectData.vocalStrips.add("Cho1");
                        ProjectData.vocalStrips.add("Cho2");
                        ProjectData.vocalStrips.add("Cho3");
                        ProjectData.vocalStrips.add("Cho4");
                        break;
                    case 5:
                        ProjectData.vocalStrips.add("Cho1");
                        ProjectData.vocalStrips.add("Cho2");
                        ProjectData.vocalStrips.add("Cho3");
                        ProjectData.vocalStrips.add("Cho4");
                        ProjectData.vocalStrips.add("Cho5");
                        break;
                    case 6:
                        ProjectData.vocalStrips.add("Cho1");
                        ProjectData.vocalStrips.add("Cho2");
                        ProjectData.vocalStrips.add("Cho3");
                        ProjectData.vocalStrips.add("Cho4");
                        ProjectData.vocalStrips.add("Cho5");
                        ProjectData.vocalStrips.add("Cho6");
                        break;
                    case 7:
                        ProjectData.vocalStrips.add("Cho1");
                        ProjectData.vocalStrips.add("Cho2");
                        ProjectData.vocalStrips.add("Cho3");
                        ProjectData.vocalStrips.add("Cho4");
                        ProjectData.vocalStrips.add("Cho5");
                        ProjectData.vocalStrips.add("Cho6");
                        ProjectData.vocalStrips.add("Cho7");
                        break;
                    case 8:
                        ProjectData.vocalStrips.add("Cho1");
                        ProjectData.vocalStrips.add("Cho2");
                        ProjectData.vocalStrips.add("Cho3");
                        ProjectData.vocalStrips.add("Cho4");
                        ProjectData.vocalStrips.add("Cho5");
                        ProjectData.vocalStrips.add("Cho6");
                        ProjectData.vocalStrips.add("Cho7");
                        ProjectData.vocalStrips.add("Cho8");
                        break;
                    case 9:
                        ProjectData.vocalStrips.add("Cho1");
                        ProjectData.vocalStrips.add("Cho2");
                        ProjectData.vocalStrips.add("Cho3");
                        ProjectData.vocalStrips.add("Cho4");
                        ProjectData.vocalStrips.add("Cho5");
                        ProjectData.vocalStrips.add("Cho6");
                        ProjectData.vocalStrips.add("Cho7");
                        ProjectData.vocalStrips.add("Cho8");
                        ProjectData.vocalStrips.add("Cho9");
                        break;
                    case 10:
                        ProjectData.vocalStrips.add("Cho1");
                        ProjectData.vocalStrips.add("Cho2");
                        ProjectData.vocalStrips.add("Cho3");
                        ProjectData.vocalStrips.add("Cho4");
                        ProjectData.vocalStrips.add("Cho5");
                        ProjectData.vocalStrips.add("Cho6");
                        ProjectData.vocalStrips.add("Cho7");
                        ProjectData.vocalStrips.add("Cho8");
                        ProjectData.vocalStrips.add("Cho9");
                        ProjectData.vocalStrips.add("Cr10");
                        break;
                }
                theseChannelsLabel.setText("These Channels: " + ProjectData.vocalStrips.size());
                DefineInstruments.buttonVocals.setText("Vocals" + ProjectData.vocalStrips.size());
            }
        });
//Button apply end
//button no one
        buttonNoOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leadVocNumber.setSelectedItem(0);
                backVocNumber.setSelectedItem(0);
                choirNumber.setSelectedItem(0);
            }
        });
    }
}

