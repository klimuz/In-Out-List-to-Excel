package soundEngineer.step1;

import soundEngineer.server.ProjectData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stringed extends GUIStamp {
    public final String IMAGE_FILE_NAME = "stringed.jpg";
    private JLabel vio1Label = new JLabel("1st violins");
    private JLabel vio2Label = new JLabel("2nd violins");
    private JLabel violasLabel = new JLabel("Violas");
    private JLabel cellosLabel = new JLabel("Cellos");
    private JLabel dBassLabel = new JLabel("Double Bass");
    private JComboBox<Integer> vio1Number = new JComboBox();
    private JComboBox<Integer> vio2Number = new JComboBox();
    private JComboBox<Integer> violasNumber = new JComboBox();
    private JComboBox<Integer> cellosNumber = new JComboBox();
    private JComboBox<Integer> dBassNumber = new JComboBox();

    public Stringed() throws HeadlessException {
        pageNameLabel.setText("Select Strings");
//elements start
        Container labelsContainer = new Container();//for labels
        labelsContainer.setLayout(new GridLayout(1,5, 70, 10));
        labelsContainer.setBounds(35, 280, 640, 20);

        Container comboBoxContainer = new Container();//for combo boxes
        comboBoxContainer.setLayout(new GridLayout(1,5, 70, 10));
        comboBoxContainer.setBounds(35, 310, 640, 20);
//1st violins
        labelsContainer.add(vio1Label);
        vio1Number.addItem(0);
        vio1Number.addItem(1);
        vio1Number.addItem(2);
        vio1Number.addItem(3);
        vio1Number.addItem(4);
        vio1Number.addItem(5);
        vio1Number.addItem(6);
        vio1Number.addItem(7);
        vio1Number.addItem(8);
        vio1Number.addItemListener(this);
        if (ProjectData.stringedStrips.contains("Vio1")){
            vio1Number.setSelectedItem(1);
        }else if (!ProjectData.stringedStrips.contains("V1-3") && ProjectData.stringedStrips.contains("V1-2")){
            vio1Number.setSelectedItem(2);
        }else if (!ProjectData.stringedStrips.contains("V1-4") && ProjectData.stringedStrips.contains("V1-3")){
            vio1Number.setSelectedItem(3);
        }else if (!ProjectData.stringedStrips.contains("V1-5") && ProjectData.stringedStrips.contains("V1-4")){
            vio1Number.setSelectedItem(4);
        }else if (!ProjectData.stringedStrips.contains("V1-6") && ProjectData.stringedStrips.contains("V1-5")){
            vio1Number.setSelectedItem(5);
        }else if (!ProjectData.stringedStrips.contains("V1-7") && ProjectData.stringedStrips.contains("V1-6")){
            vio1Number.setSelectedItem(6);
        }else if (!ProjectData.stringedStrips.contains("V1-8") && ProjectData.stringedStrips.contains("V1-7")){
            vio1Number.setSelectedItem(7);
        }else if (ProjectData.stringedStrips.contains("V1-8")){
            vio1Number.setSelectedItem(8);
        }
        comboBoxContainer.add(vio1Number);
//2nd violins
        labelsContainer.add(vio2Label);
        vio2Number.addItem(0);
        vio2Number.addItem(1);
        vio2Number.addItem(2);
        vio2Number.addItem(3);
        vio2Number.addItem(4);
        vio2Number.addItem(5);
        vio2Number.addItem(6);
        vio2Number.addItem(7);
        vio2Number.addItem(8);
        if (ProjectData.stringedStrips.contains("Vio2")){
            vio2Number.setSelectedItem(1);
        }else if (!ProjectData.stringedStrips.contains("V2-3") && ProjectData.stringedStrips.contains("V2-2")){
            vio2Number.setSelectedItem(2);
        }else if (!ProjectData.stringedStrips.contains("V2-4") && ProjectData.stringedStrips.contains("V2-3")){
            vio2Number.setSelectedItem(3);
        }else if (!ProjectData.stringedStrips.contains("V2-5") && ProjectData.stringedStrips.contains("V2-4")){
            vio2Number.setSelectedItem(4);
        }else if (!ProjectData.stringedStrips.contains("V2-6") && ProjectData.stringedStrips.contains("V2-5")){
            vio2Number.setSelectedItem(5);
        }else if (!ProjectData.stringedStrips.contains("V2-7") && ProjectData.stringedStrips.contains("V2-6")){
            vio2Number.setSelectedItem(6);
        }else if (!ProjectData.stringedStrips.contains("V2-8") && ProjectData.stringedStrips.contains("V2-7")){
            vio2Number.setSelectedItem(7);
        }else if (ProjectData.stringedStrips.contains("V2-8")){
            vio2Number.setSelectedItem(8);
        }
        vio2Number.addItemListener(this);
        comboBoxContainer.add(vio2Number);
//violas
        labelsContainer.add(violasLabel);
        violasNumber.addItem(0);
        violasNumber.addItem(1);
        violasNumber.addItem(2);
        violasNumber.addItem(3);
        violasNumber.addItem(4);
        violasNumber.addItem(5);
        violasNumber.addItem(6);
        violasNumber.addItem(7);
        violasNumber.addItem(8);
        if (ProjectData.stringedStrips.contains("Alts")){
            violasNumber.setSelectedItem(1);
        }else if (!ProjectData.stringedStrips.contains("Alt3") && ProjectData.stringedStrips.contains("Alt2")){
            violasNumber.setSelectedItem(2);
        }else if (!ProjectData.stringedStrips.contains("Alt4") && ProjectData.stringedStrips.contains("Alt3")){
            violasNumber.setSelectedItem(3);
        }else if (!ProjectData.stringedStrips.contains("Alt5") && ProjectData.stringedStrips.contains("Alt4")){
            violasNumber.setSelectedItem(4);
        }else if (!ProjectData.stringedStrips.contains("Alt6") && ProjectData.stringedStrips.contains("Alt5")){
            violasNumber.setSelectedItem(5);
        }else if (!ProjectData.stringedStrips.contains("Alt7") && ProjectData.stringedStrips.contains("Alt6")){
            violasNumber.setSelectedItem(6);
        }else if (!ProjectData.stringedStrips.contains("Alt8") && ProjectData.stringedStrips.contains("Alt7")){
            violasNumber.setSelectedItem(7);
        }else if (ProjectData.stringedStrips.contains("Alt8")){
            violasNumber.setSelectedItem(8);
        }
        violasNumber.addItemListener(this);
        comboBoxContainer.add(violasNumber);
//cellos
        cellosLabel.setOpaque(true);
        cellosLabel.setBackground(Color.yellow);
        labelsContainer.add(cellosLabel);
        cellosNumber.addItem(0);
        cellosNumber.addItem(1);
        cellosNumber.addItem(2);
        cellosNumber.addItem(3);
        cellosNumber.addItem(4);
        cellosNumber.addItem(5);
        cellosNumber.addItem(6);
        cellosNumber.addItem(7);
        cellosNumber.addItem(8);
        if (ProjectData.stringedStrips.contains("Celo")){
            cellosNumber.setSelectedItem(1);
        }else if (!ProjectData.stringedStrips.contains("Cel3") && ProjectData.stringedStrips.contains("Cel2")){
            cellosNumber.setSelectedItem(2);
        }else if (!ProjectData.stringedStrips.contains("Cel4") && ProjectData.stringedStrips.contains("Cel3")){
            cellosNumber.setSelectedItem(3);
        }else if (!ProjectData.stringedStrips.contains("Cel5") && ProjectData.stringedStrips.contains("Cel4")){
            cellosNumber.setSelectedItem(4);
        }else if (!ProjectData.stringedStrips.contains("Cel6") && ProjectData.stringedStrips.contains("Cel5")){
            cellosNumber.setSelectedItem(5);
        }else if (!ProjectData.stringedStrips.contains("Cel7") && ProjectData.stringedStrips.contains("Cel6")){
            cellosNumber.setSelectedItem(6);
        }else if (!ProjectData.stringedStrips.contains("Cel8") && ProjectData.stringedStrips.contains("Cel7")){
            cellosNumber.setSelectedItem(7);
        }else if (ProjectData.stringedStrips.contains("Cel8")){
            cellosNumber.setSelectedItem(8);
        }
        cellosNumber.addItemListener(this);
        comboBoxContainer.add(cellosNumber);
//double basses
        dBassLabel.setOpaque(true);
        dBassLabel.setBackground(Color.yellow);
        labelsContainer.add(dBassLabel);
        dBassNumber.addItem(0);
        dBassNumber.addItem(1);
        dBassNumber.addItem(2);
        dBassNumber.addItem(3);
        dBassNumber.addItem(4);
        dBassNumber.addItem(5);
        dBassNumber.addItem(6);
        dBassNumber.addItem(7);
        dBassNumber.addItem(8);
        dBassNumber.addItemListener(this);
        if (ProjectData.stringedStrips.contains("DBas")){
            dBassNumber.setSelectedItem(1);
        }else if (!ProjectData.stringedStrips.contains("DBs3") && ProjectData.stringedStrips.contains("DBs2")){
            dBassNumber.setSelectedItem(2);
        }else if (!ProjectData.stringedStrips.contains("DBs4") && ProjectData.stringedStrips.contains("DBs3")){
            dBassNumber.setSelectedItem(3);
        }else if (!ProjectData.stringedStrips.contains("DBs5") && ProjectData.stringedStrips.contains("DBs4")){
            dBassNumber.setSelectedItem(4);
        }else if (!ProjectData.stringedStrips.contains("DBs6") && ProjectData.stringedStrips.contains("DBs5")){
            dBassNumber.setSelectedItem(5);
        }else if (!ProjectData.stringedStrips.contains("DBs7") && ProjectData.stringedStrips.contains("DBs6")){
            dBassNumber.setSelectedItem(6);
        }else if (!ProjectData.stringedStrips.contains("DBs8") && ProjectData.stringedStrips.contains("DBs7")){
            dBassNumber.setSelectedItem(7);
        }else if (ProjectData.stringedStrips.contains("DBs8")){
            dBassNumber.setSelectedItem(8);
        }
        comboBoxContainer.add(dBassNumber);
        container.add(labelsContainer);
        container.add(comboBoxContainer);
//elements end

//Button apply start
        buttonApply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectData.stringedStrips.clear();
//1st violins
                switch ((int)vio1Number.getSelectedItem()) {
                    case 1:
                        ProjectData.stringedStrips.add("Vio1");
                        break;
                    case 2:
                        ProjectData.stringedStrips.add("V1-1");
                        ProjectData.stringedStrips.add("V1-2");
                        break;
                    case 3:
                        ProjectData.stringedStrips.add("V1-1");
                        ProjectData.stringedStrips.add("V1-2");
                        ProjectData.stringedStrips.add("V1-3");
                        break;
                    case 4:
                        ProjectData.stringedStrips.add("V1-1");
                        ProjectData.stringedStrips.add("V1-2");
                        ProjectData.stringedStrips.add("V1-3");
                        ProjectData.stringedStrips.add("V1-4");
                        break;
                    case 5:
                        ProjectData.stringedStrips.add("V1-1");
                        ProjectData.stringedStrips.add("V1-2");
                        ProjectData.stringedStrips.add("V1-3");
                        ProjectData.stringedStrips.add("V1-4");
                        ProjectData.stringedStrips.add("V1-5");
                        break;
                    case 6:
                        ProjectData.stringedStrips.add("V1-1");
                        ProjectData.stringedStrips.add("V1-2");
                        ProjectData.stringedStrips.add("V1-3");
                        ProjectData.stringedStrips.add("V1-4");
                        ProjectData.stringedStrips.add("V1-5");
                        ProjectData.stringedStrips.add("V1-6");
                        break;
                    case 7:
                        ProjectData.stringedStrips.add("V1-1");
                        ProjectData.stringedStrips.add("V1-2");
                        ProjectData.stringedStrips.add("V1-3");
                        ProjectData.stringedStrips.add("V1-4");
                        ProjectData.stringedStrips.add("V1-5");
                        ProjectData.stringedStrips.add("V1-6");
                        ProjectData.stringedStrips.add("V1-7");
                        break;
                    case 8:
                        ProjectData.stringedStrips.add("V1-1");
                        ProjectData.stringedStrips.add("V1-2");
                        ProjectData.stringedStrips.add("V1-3");
                        ProjectData.stringedStrips.add("V1-4");
                        ProjectData.stringedStrips.add("V1-5");
                        ProjectData.stringedStrips.add("V1-6");
                        ProjectData.stringedStrips.add("V1-7");
                        ProjectData.stringedStrips.add("V1-8");
                        break;
                }
//2nd violins
                switch ((int) vio2Number.getSelectedItem()) {
                    case 1:
                        ProjectData.stringedStrips.add("Vio2");
                        break;
                    case 2:
                        ProjectData.stringedStrips.add("V2-1");
                        ProjectData.stringedStrips.add("V2-2");
                        break;
                    case 3:
                        ProjectData.stringedStrips.add("V2-1");
                        ProjectData.stringedStrips.add("V2-2");
                        ProjectData.stringedStrips.add("V2-3");
                        break;
                    case 4:
                        ProjectData.stringedStrips.add("V2-1");
                        ProjectData.stringedStrips.add("V2-2");
                        ProjectData.stringedStrips.add("V2-3");
                        ProjectData.stringedStrips.add("V2-4");
                        break;
                    case 5:
                        ProjectData.stringedStrips.add("V2-1");
                        ProjectData.stringedStrips.add("V2-2");
                        ProjectData.stringedStrips.add("V2-3");
                        ProjectData.stringedStrips.add("V2-4");
                        ProjectData.stringedStrips.add("V2-5");
                        break;
                    case 6:
                        ProjectData.stringedStrips.add("V2-1");
                        ProjectData.stringedStrips.add("V2-2");
                        ProjectData.stringedStrips.add("V2-3");
                        ProjectData.stringedStrips.add("V2-4");
                        ProjectData.stringedStrips.add("V2-5");
                        ProjectData.stringedStrips.add("V2-6");
                        break;
                    case 7:
                        ProjectData.stringedStrips.add("V2-1");
                        ProjectData.stringedStrips.add("V2-2");
                        ProjectData.stringedStrips.add("V2-3");
                        ProjectData.stringedStrips.add("V2-4");
                        ProjectData.stringedStrips.add("V2-5");
                        ProjectData.stringedStrips.add("V2-6");
                        ProjectData.stringedStrips.add("V2-7");
                        break;
                    case 8:
                        ProjectData.stringedStrips.add("V2-1");
                        ProjectData.stringedStrips.add("V2-2");
                        ProjectData.stringedStrips.add("V2-3");
                        ProjectData.stringedStrips.add("V2-4");
                        ProjectData.stringedStrips.add("V2-5");
                        ProjectData.stringedStrips.add("V2-6");
                        ProjectData.stringedStrips.add("V2-7");
                        ProjectData.stringedStrips.add("V2-8");
                        break;
                }
//violas
                switch ((int) violasNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.stringedStrips.add("Alts");
                        break;
                    case 2:
                        ProjectData.stringedStrips.add("Alt1");
                        ProjectData.stringedStrips.add("Alt2");
                        break;
                    case 3:
                        ProjectData.stringedStrips.add("Alt1");
                        ProjectData.stringedStrips.add("Alt2");
                        ProjectData.stringedStrips.add("Alt3");
                        break;
                    case 4:
                        ProjectData.stringedStrips.add("Alt1");
                        ProjectData.stringedStrips.add("Alt2");
                        ProjectData.stringedStrips.add("Alt3");
                        ProjectData.stringedStrips.add("Alt4");
                        break;
                    case 5:
                        ProjectData.stringedStrips.add("Alt1");
                        ProjectData.stringedStrips.add("Alt2");
                        ProjectData.stringedStrips.add("Alt3");
                        ProjectData.stringedStrips.add("Alt4");
                        ProjectData.stringedStrips.add("Alt5");
                        break;
                    case 6:
                        ProjectData.stringedStrips.add("Alt1");
                        ProjectData.stringedStrips.add("Alt2");
                        ProjectData.stringedStrips.add("Alt3");
                        ProjectData.stringedStrips.add("Alt4");
                        ProjectData.stringedStrips.add("Alt5");
                        ProjectData.stringedStrips.add("Alt6");
                        break;
                    case 7:
                        ProjectData.stringedStrips.add("Alt1");
                        ProjectData.stringedStrips.add("Alt2");
                        ProjectData.stringedStrips.add("Alt3");
                        ProjectData.stringedStrips.add("Alt4");
                        ProjectData.stringedStrips.add("Alt5");
                        ProjectData.stringedStrips.add("Alt6");
                        ProjectData.stringedStrips.add("Alt7");
                        break;
                    case 8:
                        ProjectData.stringedStrips.add("Alt1");
                        ProjectData.stringedStrips.add("Alt2");
                        ProjectData.stringedStrips.add("Alt3");
                        ProjectData.stringedStrips.add("Alt4");
                        ProjectData.stringedStrips.add("Alt5");
                        ProjectData.stringedStrips.add("Alt6");
                        ProjectData.stringedStrips.add("Alt7");
                        ProjectData.stringedStrips.add("Alt8");
                        break;
                }
//cello
                String cellosSel = cellosNumber.getSelectedItem().toString();
                switch ((int) cellosNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.stringedStrips.add("Celo");
                        break;
                    case 2:
                        ProjectData.stringedStrips.add("Cel1");
                        ProjectData.stringedStrips.add("Cel2");
                        break;
                    case 3:
                        ProjectData.stringedStrips.add("Cel1");
                        ProjectData.stringedStrips.add("Cel2");
                        ProjectData.stringedStrips.add("Cel3");
                        break;
                    case 4:
                        ProjectData.stringedStrips.add("Cel1");
                        ProjectData.stringedStrips.add("Cel2");
                        ProjectData.stringedStrips.add("Cel3");
                        ProjectData.stringedStrips.add("Cel4");
                        break;
                    case 5:
                        ProjectData.stringedStrips.add("Cel1");
                        ProjectData.stringedStrips.add("Cel2");
                        ProjectData.stringedStrips.add("Cel3");
                        ProjectData.stringedStrips.add("Cel4");
                        ProjectData.stringedStrips.add("Cel5");
                        break;
                    case 6:
                        ProjectData.stringedStrips.add("Cel1");
                        ProjectData.stringedStrips.add("Cel2");
                        ProjectData.stringedStrips.add("Cel3");
                        ProjectData.stringedStrips.add("Cel4");
                        ProjectData.stringedStrips.add("Cel5");
                        ProjectData.stringedStrips.add("Cel6");
                        break;
                    case 7:
                        ProjectData.stringedStrips.add("Cel1");
                        ProjectData.stringedStrips.add("Cel2");
                        ProjectData.stringedStrips.add("Cel3");
                        ProjectData.stringedStrips.add("Cel4");
                        ProjectData.stringedStrips.add("Cel5");
                        ProjectData.stringedStrips.add("Cel6");
                        ProjectData.stringedStrips.add("Cel7");
                        break;
                    case 8:
                        ProjectData.stringedStrips.add("Cel1");
                        ProjectData.stringedStrips.add("Cel2");
                        ProjectData.stringedStrips.add("Cel3");
                        ProjectData.stringedStrips.add("Cel4");
                        ProjectData.stringedStrips.add("Cel5");
                        ProjectData.stringedStrips.add("Cel6");
                        ProjectData.stringedStrips.add("Cel7");
                        ProjectData.stringedStrips.add("Cel8");
                        break;
                }
//double basses
                switch ((int) dBassNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.stringedStrips.add("DBas");
                        break;
                    case 2:
                        ProjectData.stringedStrips.add("DBs1");
                        ProjectData.stringedStrips.add("DBs2");
                        break;
                    case 3:
                        ProjectData.stringedStrips.add("DBs1");
                        ProjectData.stringedStrips.add("DBs2");
                        ProjectData.stringedStrips.add("DBs3");
                        break;
                    case 4:
                        ProjectData.stringedStrips.add("DBs1");
                        ProjectData.stringedStrips.add("DBs2");
                        ProjectData.stringedStrips.add("DBs3");
                        ProjectData.stringedStrips.add("DBs4");
                        break;
                    case 5:
                        ProjectData.stringedStrips.add("DBs1");
                        ProjectData.stringedStrips.add("DBs2");
                        ProjectData.stringedStrips.add("DBs3");
                        ProjectData.stringedStrips.add("DBs4");
                        ProjectData.stringedStrips.add("DBs5");
                        break;
                    case 6:
                        ProjectData.stringedStrips.add("DBs1");
                        ProjectData.stringedStrips.add("DBs2");
                        ProjectData.stringedStrips.add("DBs3");
                        ProjectData.stringedStrips.add("DBs4");
                        ProjectData.stringedStrips.add("DBs5");
                        ProjectData.stringedStrips.add("DBs6");
                        break;
                    case 7:
                        ProjectData.stringedStrips.add("DBs1");
                        ProjectData.stringedStrips.add("DBs2");
                        ProjectData.stringedStrips.add("DBs3");
                        ProjectData.stringedStrips.add("DBs4");
                        ProjectData.stringedStrips.add("DBs5");
                        ProjectData.stringedStrips.add("DBs6");
                        ProjectData.stringedStrips.add("DBs7");
                        break;
                    case 8:
                        ProjectData.stringedStrips.add("DBs1");
                        ProjectData.stringedStrips.add("DBs2");
                        ProjectData.stringedStrips.add("DBs3");
                        ProjectData.stringedStrips.add("DBs4");
                        ProjectData.stringedStrips.add("DBs5");
                        ProjectData.stringedStrips.add("DBs6");
                        ProjectData.stringedStrips.add("DBs7");
                        ProjectData.stringedStrips.add("DBs8");
                        break;
                }

                theseChannelsLabel.setText("These Channels: " + ProjectData.stringedStrips.size());
                DefineInstruments.buttonStrings.setText("Strings" + ProjectData.stringedStrips.size());
            }
        });
//Button apply end
//button no one
        buttonNoOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vio1Number.setSelectedItem(0);
                vio2Number.setSelectedItem(0);
                violasNumber.setSelectedItem(0);
                cellosNumber.setSelectedItem(0);
                dBassNumber.setSelectedItem(0);
            }
        });
    }
}


