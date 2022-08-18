package soundEngineer.step1;

import soundEngineer.server.ProjectData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WoodsBrass extends GUIStamp {
    public final String IMAGE_FILE_NAME = "brass.jpg";
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
    private JLabel cooperLabel = new JLabel("Cooper:");
    private JLabel woodsLabel = new JLabel("Woods:");

    private JComboBox<Integer> trumpetsNumber = new JComboBox();
    private JComboBox<Integer> trombNumber = new JComboBox();
    private JComboBox<Integer> saxNumber = new JComboBox();
    private JComboBox<Integer> tubaNumber = new JComboBox();
    private JComboBox<Integer> hornsNumber = new JComboBox();
    private JComboBox<Integer> fluteNumber = new JComboBox();
    private JComboBox<Integer> clarinetsNumber = new JComboBox();
    private JComboBox<Integer> oboeNumber = new JComboBox();
    private JComboBox<Integer> bassoonsNumber = new JComboBox();
    private JComboBox<Integer> othersNumber = new JComboBox();

    public WoodsBrass() throws HeadlessException {
        pageNameLabel.setText("Select Brass&woodwinds");
//gui elements start
//labels
        cooperLabel.setBounds(180, 55, 100, 50);
        container.add(cooperLabel);
        woodsLabel.setBounds(450, 55, 100, 50);
        container.add(woodsLabel);
//label containers
        Container labelContainerLeft= new Container();//for labels
        labelContainerLeft.setLayout(new GridLayout(6,1, 5, 10));
        labelContainerLeft.setBounds(170, 120, 100, 200);

        Container labelContainerRight= new Container();//for labels
        labelContainerRight.setLayout(new GridLayout(6,1, 5, 10));
        labelContainerRight.setBounds(440, 120, 60, 200);
//combo boxes containers
        Container numberContainerLeft= new Container();//for combo boxes
        numberContainerLeft.setLayout(new GridLayout(6,1, 5, 10));
        numberContainerLeft.setBounds(270, 120, 40, 200);

        Container numberContainerRight= new Container();//for combo boxes
        numberContainerRight.setLayout(new GridLayout(6,1, 5, 10));
        numberContainerRight.setBounds(550, 120, 40, 200);
//trumpets
        labelContainerLeft.add(trumpetLabel);
        trumpetsNumber.addItem(0);
        trumpetsNumber.addItem(1);
        trumpetsNumber.addItem(2);
        trumpetsNumber.addItem(3);
        trumpetsNumber.addItem(4);
        if (ProjectData.windStrips.contains("Trum")){
            trumpetsNumber.setSelectedItem(1);
        }else if (!ProjectData.windStrips.contains("Tru3") && ProjectData.windStrips.contains("Tru2")){
            trumpetsNumber.setSelectedItem(2);
        }else if (!ProjectData.windStrips.contains("Tru4") && ProjectData.windStrips.contains("Tru3")){
            trumpetsNumber.setSelectedItem(3);
        }else if (ProjectData.windStrips.contains("Tru4")){
            trumpetsNumber.setSelectedItem(4);
        }
        trumpetsNumber.addItemListener(this);
        numberContainerLeft.add(trumpetsNumber);
//Trombone
        labelContainerLeft.add(trombLabel);
        trombNumber.addItem(0);
        trombNumber.addItem(1);
        trombNumber.addItem(2);
        trombNumber.addItem(3);
        trombNumber.addItem(4);
        if (ProjectData.windStrips.contains("Trom")){
            trombNumber.setSelectedItem(1);
        }else if (!ProjectData.windStrips.contains("Tro3") && ProjectData.windStrips.contains("Tro2")){
            trombNumber.setSelectedItem(2);
        }else if (!ProjectData.windStrips.contains("Tro4") && ProjectData.windStrips.contains("Tro3")){
            trombNumber.setSelectedItem(3);
        }else if (ProjectData.windStrips.contains("Tro4")){
            trombNumber.setSelectedItem(4);
        }
        trombNumber.addItemListener(this);
        numberContainerLeft.add(trombNumber);
//Sax
        labelContainerLeft.add(saxLabel);
        saxNumber.addItem(0);
        saxNumber.addItem(1);
        saxNumber.addItem(2);
        saxNumber.addItem(3);
        saxNumber.addItem(4);
        if (ProjectData.windStrips.contains("Sax")){
            saxNumber.setSelectedItem(1);
        }else if (!ProjectData.windStrips.contains("Sax3") && ProjectData.windStrips.contains("Sax2")){
            saxNumber.setSelectedItem(2);
        }else if (!ProjectData.windStrips.contains("Sax4") && ProjectData.windStrips.contains("Sax3")){
            saxNumber.setSelectedItem(3);
        }else if (ProjectData.windStrips.contains("Sax4")){
            saxNumber.setSelectedItem(4);
        }
        saxNumber.addItemListener(this);
        numberContainerLeft.add(saxNumber);
//Tuba
        labelContainerLeft.add(tubaLabel);
        tubaNumber.addItem(0);
        tubaNumber.addItem(1);
        tubaNumber.addItem(2);
        tubaNumber.addItem(3);
        tubaNumber.addItem(4);
        if (ProjectData.windStrips.contains("Tuba")){
            tubaNumber.setSelectedItem(1);
        }else if (!ProjectData.windStrips.contains("Tub3") && ProjectData.windStrips.contains("Tub2")){
            tubaNumber.setSelectedItem(2);
        }else if (!ProjectData.windStrips.contains("Tub4") && ProjectData.windStrips.contains("Tub3")){
            tubaNumber.setSelectedItem(3);
        }else if (ProjectData.windStrips.contains("Tub4")){
            tubaNumber.setSelectedItem(4);
        }
        tubaNumber.addItemListener(this);
        numberContainerLeft.add(tubaNumber);
//Horn
        labelContainerLeft.add(hornsLabel);
        hornsNumber.addItem(0);
        hornsNumber.addItem(1);
        hornsNumber.addItem(2);
        hornsNumber.addItem(3);
        hornsNumber.addItem(4);
        if (ProjectData.windStrips.contains("Horn")){
            hornsNumber.setSelectedItem(1);
        }else if (!ProjectData.windStrips.contains("Hor3") && ProjectData.windStrips.contains("Hor2")){
            hornsNumber.setSelectedItem(2);
        }else if (!ProjectData.windStrips.contains("Hor4") && ProjectData.windStrips.contains("Hor3")){
            hornsNumber.setSelectedItem(3);
        }else if (ProjectData.windStrips.contains("Hor4")){
            hornsNumber.setSelectedItem(4);
        }
        hornsNumber.addItemListener(this);
        numberContainerLeft.add(hornsNumber);
//Flute
        labelContainerRight.add(fluteLabel);
        fluteNumber.addItem(0);
        fluteNumber.addItem(1);
        fluteNumber.addItem(2);
        fluteNumber.addItem(3);
        fluteNumber.addItem(4);
        fluteNumber.addItem(5);
        if (ProjectData.windStrips.contains("Flut")){
            fluteNumber.setSelectedItem(1);
        }else if (!ProjectData.windStrips.contains("Flu3") && ProjectData.windStrips.contains("Flu2")){
            fluteNumber.setSelectedItem(2);
        }else if (!ProjectData.windStrips.contains("Flu4") && ProjectData.windStrips.contains("Flu3")){
            fluteNumber.setSelectedItem(3);
        }else if (!ProjectData.windStrips.contains("Flu5") && ProjectData.windStrips.contains("Flu4")){
            fluteNumber.setSelectedItem(4);
        }else if (ProjectData.windStrips.contains("Flu5")){
            fluteNumber.setSelectedItem(5);
        }
        fluteNumber.addItemListener(this);
        numberContainerRight.add(fluteNumber);
//Clarinet
        labelContainerRight.add(clarinetsLabel);
        clarinetsNumber.addItem(0);
        clarinetsNumber.addItem(1);
        clarinetsNumber.addItem(2);
        clarinetsNumber.addItem(3);
        clarinetsNumber.addItem(4);
        if (ProjectData.windStrips.contains("Clar")){
            clarinetsNumber.setSelectedItem(1);
        }else if (!ProjectData.windStrips.contains("Cla3") && ProjectData.windStrips.contains("Cla2")){
            clarinetsNumber.setSelectedItem(2);
        }else if (!ProjectData.windStrips.contains("Cla4") && ProjectData.windStrips.contains("Cla3")){
            clarinetsNumber.setSelectedItem(3);
        }else if (ProjectData.windStrips.contains("Cla4")){
            clarinetsNumber.setSelectedItem(4);
        }
        clarinetsNumber.addItemListener(this);
        numberContainerRight.add(clarinetsNumber);
//Oboe
        labelContainerRight.add(oboeLabel);
        oboeNumber.addItem(0);
        oboeNumber.addItem(1);
        oboeNumber.addItem(2);
        oboeNumber.addItem(3);
        oboeNumber.addItem(4);
        if (ProjectData.windStrips.contains("Oboe")){
            oboeNumber.setSelectedItem(1);
        }else if (!ProjectData.windStrips.contains("Obo3") && ProjectData.windStrips.contains("Obo2")){
            oboeNumber.setSelectedItem(2);
        }else if (!ProjectData.windStrips.contains("Obo4") && ProjectData.windStrips.contains("Obo3")){
            oboeNumber.setSelectedItem(3);
        }else if (ProjectData.windStrips.contains("Obo4")){
            oboeNumber.setSelectedItem(4);
        }
        oboeNumber.addItemListener(this);
        numberContainerRight.add(oboeNumber);
//Bassoon
        labelContainerRight.add(bassoonsLabel);
        bassoonsNumber.addItem(0);
        bassoonsNumber.addItem(1);
        bassoonsNumber.addItem(2);
        bassoonsNumber.addItem(3);
        bassoonsNumber.addItem(4);
        if (ProjectData.windStrips.contains("Bsn")){
            bassoonsNumber.setSelectedItem(1);
        }else if (!ProjectData.windStrips.contains("Bsn3") && ProjectData.windStrips.contains("Bsn2")){
            bassoonsNumber.setSelectedItem(2);
        }else if (!ProjectData.windStrips.contains("Bsn4") && ProjectData.windStrips.contains("Bsn3")){
            bassoonsNumber.setSelectedItem(3);
        }else if (ProjectData.windStrips.contains("Bsn4")){
            bassoonsNumber.setSelectedItem(4);
        }
        bassoonsNumber.addItemListener(this);
        numberContainerRight.add(bassoonsNumber);
//other winds
        labelContainerRight.add(othersLabel);
        othersNumber.addItem(0);
        othersNumber.addItem(1);
        othersNumber.addItem(2);
        othersNumber.addItem(3);
        othersNumber.addItem(4);
        othersNumber.addItem(5);
        if (ProjectData.windStrips.contains("Wind")){
            othersNumber.setSelectedItem(1);
        }else if (!ProjectData.windStrips.contains("Win3") && ProjectData.windStrips.contains("Win2")){
            othersNumber.setSelectedItem(2);
        }else if (!ProjectData.windStrips.contains("Win4") && ProjectData.windStrips.contains("Win3")){
            othersNumber.setSelectedItem(3);
        }else if (!ProjectData.windStrips.contains("Win5") && ProjectData.windStrips.contains("Win4")){
            othersNumber.setSelectedItem(4);
        }else if (ProjectData.windStrips.contains("Win5")){
            othersNumber.setSelectedItem(5);
        }
        othersNumber.addItemListener(this);
        numberContainerRight.add(othersNumber);

        container.add(labelContainerLeft);
        container.add(numberContainerLeft);
        container.add(labelContainerRight);
        container.add(numberContainerRight);
//gui elements end

//Button apply start
        buttonApply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectData.windStrips.clear();
//trumpets
                switch ((int) trumpetsNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.windStrips.add("Trum");
                        break;
                    case 2:
                        ProjectData.windStrips.add("Tru1");
                        ProjectData.windStrips.add("Tru2");
                        break;
                    case 3:
                        ProjectData.windStrips.add("Tru1");
                        ProjectData.windStrips.add("Tru2");
                        ProjectData.windStrips.add("Tru3");
                        break;
                    case 4:
                        ProjectData.windStrips.add("Tru1");
                        ProjectData.windStrips.add("Tru2");
                        ProjectData.windStrips.add("Tru3");
                        ProjectData.windStrips.add("Tru4");
                        break;
                }
//trombones
                switch ((int) trombNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.windStrips.add("Trom");
                        break;
                    case 2:
                        ProjectData.windStrips.add("Tro1");
                        ProjectData.windStrips.add("Tro2");
                        break;
                    case 3:
                        ProjectData.windStrips.add("Tro1");
                        ProjectData.windStrips.add("Tro2");
                        ProjectData.windStrips.add("Tro3");
                        break;
                    case 4:
                        ProjectData.windStrips.add("Tro1");
                        ProjectData.windStrips.add("Tro2");
                        ProjectData.windStrips.add("Tro3");
                        ProjectData.windStrips.add("Tro4");
                        break;
                }
//Sax
                switch ((int) saxNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.windStrips.add("Sax");
                        break;
                    case 2:
                        ProjectData.windStrips.add("Sax1");
                        ProjectData.windStrips.add("Sax2");
                        break;
                    case 3:
                        ProjectData.windStrips.add("Sax1");
                        ProjectData.windStrips.add("Sax2");
                        ProjectData.windStrips.add("Sax3");
                        break;
                    case 4:
                        ProjectData.windStrips.add("Sax1");
                        ProjectData.windStrips.add("Sax2");
                        ProjectData.windStrips.add("Sax3");
                        ProjectData.windStrips.add("Sax4");
                        break;
                }
//Tuba
                switch ((int) tubaNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.windStrips.add("Tuba");
                        break;
                    case 2:
                        ProjectData.windStrips.add("Tub1");
                        ProjectData.windStrips.add("Tub2");
                        break;
                    case 3:
                        ProjectData.windStrips.add("Tub1");
                        ProjectData.windStrips.add("Tub2");
                        ProjectData.windStrips.add("Tub3");
                        break;
                    case 4:
                        ProjectData.windStrips.add("Tub1");
                        ProjectData.windStrips.add("Tub2");
                        ProjectData.windStrips.add("Tub3");
                        ProjectData.windStrips.add("Tub4");
                        break;
                }
//Horn
                switch ((int) hornsNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.windStrips.add("Horn");
                        break;
                    case 2:
                        ProjectData.windStrips.add("Hor1");
                        ProjectData.windStrips.add("Hor2");
                        break;
                    case 3:
                        ProjectData.windStrips.add("Hor1");
                        ProjectData.windStrips.add("Hor2");
                        ProjectData.windStrips.add("Hor3");
                        break;
                    case 4:
                        ProjectData.windStrips.add("Hor1");
                        ProjectData.windStrips.add("Hor2");
                        ProjectData.windStrips.add("Hor3");
                        ProjectData.windStrips.add("Hor4");
                        break;
                }
//Flute
                switch ((int) fluteNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.windStrips.add("Flut");
                        break;
                    case 2:
                        ProjectData.windStrips.add("Flu1");
                        ProjectData.windStrips.add("Flu2");
                        break;
                    case 3:
                        ProjectData.windStrips.add("Flu1");
                        ProjectData.windStrips.add("Flu2");
                        ProjectData.windStrips.add("Flu3");
                        break;
                    case 4:
                        ProjectData.windStrips.add("Flu1");
                        ProjectData.windStrips.add("Flu2");
                        ProjectData.windStrips.add("Flu3");
                        ProjectData.windStrips.add("Flu4");
                        break;
                }
//Clarinet
                switch ((int) clarinetsNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.windStrips.add("Clar");
                        break;
                    case 2:
                        ProjectData.windStrips.add("Cla1");
                        ProjectData.windStrips.add("Cla2");
                        break;
                    case 3:
                        ProjectData.windStrips.add("Cla1");
                        ProjectData.windStrips.add("Cla2");
                        ProjectData.windStrips.add("Cla3");
                        break;
                    case 4:
                        ProjectData.windStrips.add("Cla1");
                        ProjectData.windStrips.add("Cla2");
                        ProjectData.windStrips.add("Cla3");
                        ProjectData.windStrips.add("Cla4");
                        break;
                }
//Oboe
                switch ((int) oboeNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.windStrips.add("Oboe");
                        break;
                    case 2:
                        ProjectData.windStrips.add("Obo1");
                        ProjectData.windStrips.add("Obo2");
                        break;
                    case 3:
                        ProjectData.windStrips.add("Obo1");
                        ProjectData.windStrips.add("Obo2");
                        ProjectData.windStrips.add("Obo3");
                        break;
                    case 4:
                        ProjectData.windStrips.add("Obo1");
                        ProjectData.windStrips.add("Obo2");
                        ProjectData.windStrips.add("Obo3");
                        ProjectData.windStrips.add("Obo4");
                        break;
                }
//Bassoon
                switch ((int) bassoonsNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.windStrips.add("Bsn");
                        break;
                    case 2:
                        ProjectData.windStrips.add("Bsn1");
                        ProjectData.windStrips.add("Bsn2");
                        break;
                    case 3:
                        ProjectData.windStrips.add("Bsn1");
                        ProjectData.windStrips.add("Bsn2");
                        ProjectData.windStrips.add("Bsn3");
                        break;
                    case 4:
                        ProjectData.windStrips.add("Bsn1");
                        ProjectData.windStrips.add("Bsn2");
                        ProjectData.windStrips.add("Bsn3");
                        ProjectData.windStrips.add("Bsn4");
                        break;
                }
//other winds
                switch ((int) othersNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.windStrips.add("Wind");
                        break;
                    case 2:
                        ProjectData.windStrips.add("Win1");
                        ProjectData.windStrips.add("Win2");
                        break;
                    case 3:
                        ProjectData.windStrips.add("Win1");
                        ProjectData.windStrips.add("Win2");
                        ProjectData.windStrips.add("Win3");
                        break;
                    case 4:
                        ProjectData.windStrips.add("Win1");
                        ProjectData.windStrips.add("Win2");
                        ProjectData.windStrips.add("Win3");
                        ProjectData.windStrips.add("Win4");
                        break;
                    case 5:
                        ProjectData.windStrips.add("Win1");
                        ProjectData.windStrips.add("Win2");
                        ProjectData.windStrips.add("Win3");
                        ProjectData.windStrips.add("Win4");
                        ProjectData.windStrips.add("Win5");
                        break;
                }

                theseChannelsLabel.setText("These Channels: " + ProjectData.windStrips.size());
                DefineInstruments.buttonWinds.setText("Winds" + ProjectData.windStrips.size());
            }
        });
//Button apply end
//button no one
        buttonNoOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trumpetsNumber.setSelectedItem(0);
                trombNumber.setSelectedItem(0);
                saxNumber.setSelectedItem(0);
                tubaNumber.setSelectedItem(0);
                hornsNumber.setSelectedItem(0);
                fluteNumber.setSelectedItem(0);
                clarinetsNumber.setSelectedItem(0);
                oboeNumber.setSelectedItem(0);
                bassoonsNumber.setSelectedItem(0);
                othersNumber.setSelectedItem(0);
            }
        });
    }
}

