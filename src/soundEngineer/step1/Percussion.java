package soundEngineer.step1;

import soundEngineer.server.ProjectData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Percussion extends GUIStamp {
    public final String IMAGE_FILE_NAME = "blueBgnd.jpg";
    private JLabel congasLabel = new JLabel("Congas");
    private JLabel bongosLabel = new JLabel("Bongos");
    private JLabel shakerLabel = new JLabel("Shaker");
    private JLabel tambourineLabel = new JLabel("Tambourine");
    private JLabel overLabel = new JLabel("Overhead");
    private JLabel doyraLabel = new JLabel("Doyra");
    private JLabel tablaLabel = new JLabel("Tabla");
    private JLabel nagoraLabel = new JLabel("Nagora");
    private JLabel jambeyLabel = new JLabel("Jambey");
    private JLabel kajonLabel = new JLabel("Kajon");
    private JLabel kushNagLabel = new JLabel("KushNagora");
    private JLabel othersLabel = new JLabel("Others");
    private JLabel genericsLabel = new JLabel("Generic:");
    private JLabel nationalLabel = new JLabel("National:");

    private JComboBox<Integer> congasNumber = new JComboBox();
    private JComboBox<Integer> bongosNumber = new JComboBox();
    private JComboBox<Integer> shakerNumber = new JComboBox();
    private JComboBox<Integer> tambourineNumber = new JComboBox();
    private JComboBox<Integer> overNumber = new JComboBox();
    private JComboBox<Integer> doyraNumber = new JComboBox();
    private JComboBox<Integer> tablaNumber = new JComboBox();
    private JComboBox<Integer> nagoraNumber = new JComboBox();
    private JComboBox<Integer> jambeyNumber = new JComboBox();
    private JComboBox<Integer> kajonNumber = new JComboBox();
    private JComboBox<Integer> othersNumber = new JComboBox();

    public Percussion() throws HeadlessException {
        pageNameLabel.setText("Select Percussion");
//gui elements start
//labels
        genericsLabel.setBounds(180, 55, 100, 50);
        container.add(genericsLabel);
        nationalLabel.setBounds(450, 55, 100, 50);
        container.add(nationalLabel);
//label containers
        Container labelContainerLeft = new Container();
        labelContainerLeft.setLayout(new GridLayout(6,1, 5, 10));
        labelContainerLeft.setBounds(170, 120, 100, 200);

        Container labelContainerRight = new Container();
        labelContainerRight.setLayout(new GridLayout(6,1, 5, 10));
        labelContainerRight.setBounds(440, 120, 50, 200);
//combo boxes containers
        Container numbersContainerLeft = new Container();
        numbersContainerLeft.setLayout(new GridLayout(6,1, 5, 10));
        numbersContainerLeft.setBounds(270, 120, 40, 200);

        Container numbersContainerRight = new Container();//for combo boxes
        numbersContainerRight.setLayout(new GridLayout(6,1, 5, 10));
        numbersContainerRight.setBounds(540, 120, 40, 200);
//congas
        labelContainerLeft.add(congasLabel);
        congasNumber.addItem(0);
        congasNumber.addItem(1);
        congasNumber.addItem(2);
        congasNumber.addItem(3);
        congasNumber.addItemListener(this);
        if (ProjectData.percussionStrips.contains("Cong")){
            congasNumber.setSelectedItem(1);
        }else if (!ProjectData.percussionStrips.contains("Cng3") && ProjectData.percussionStrips.contains("Cng2")){
            congasNumber.setSelectedItem(2);
        }else if (ProjectData.percussionStrips.contains("Cng3")){
            congasNumber.setSelectedItem(3);
        }
        numbersContainerLeft.add(congasNumber);
//bongos
        labelContainerLeft.add(bongosLabel);
        bongosNumber.addItem(0);
        bongosNumber.addItem(1);
        bongosNumber.addItem(2);
        if (ProjectData.percussionStrips.contains("Bong")){
            bongosNumber.setSelectedItem(1);
        }else if (ProjectData.percussionStrips.contains("Bng1")){
            bongosNumber.setSelectedItem(2);
        }
        bongosNumber.addItemListener(this);
        numbersContainerLeft.add(bongosNumber);
//shaker
        labelContainerLeft.add(shakerLabel);
        shakerNumber.addItem(0);
        shakerNumber.addItem(1);
        shakerNumber.addItem(2);
        shakerNumber.addItem(3);
        if (ProjectData.percussionStrips.contains("Shkr")){
            shakerNumber.setSelectedItem(1);
        }else if (!ProjectData.percussionStrips.contains("Shk3") && ProjectData.percussionStrips.contains("Shk2")){
            shakerNumber.setSelectedItem(2);
        }else if (ProjectData.percussionStrips.contains("Shk3")){
            shakerNumber.setSelectedItem(3);
        }
        shakerNumber.addItemListener(this);
        numbersContainerLeft.add(shakerNumber);
//tambourine
        labelContainerLeft.add(tambourineLabel);
        tambourineNumber.addItem(0);
        tambourineNumber.addItem(1);
        tambourineNumber.addItem(2);
        tambourineNumber.addItem(3);
        if (ProjectData.percussionStrips.contains("Tmbn")){
            tambourineNumber.setSelectedItem(1);
        }else if (!ProjectData.percussionStrips.contains("Tmn3") && ProjectData.percussionStrips.contains("Tmn2")){
            tambourineNumber.setSelectedItem(2);
        }else if (ProjectData.percussionStrips.contains("Tmn3")){
            tambourineNumber.setSelectedItem(3);
        }
        tambourineNumber.addItemListener(this);
        numbersContainerLeft.add(tambourineNumber);
//perc. overhead
        labelContainerLeft.add(overLabel);
        overNumber.addItem(0);
        overNumber.addItem(1);
        overNumber.addItem(2);
        overNumber.addItemListener(this);
        if (ProjectData.percussionStrips.contains("OvHd")){
            overNumber.setSelectedItem(1);
        }else if (ProjectData.percussionStrips.contains("OHd2")){
            overNumber.setSelectedItem(2);
        }
        numbersContainerLeft.add(overNumber);

        container.add(labelContainerLeft);
        container.add(numbersContainerLeft);
//doyra
        labelContainerRight.add(doyraLabel);
        doyraNumber.addItem(0);
        doyraNumber.addItem(1);
        doyraNumber.addItem(2);
        doyraNumber.addItem(3);
        doyraNumber.addItem(4);
        doyraNumber.addItem(5);
        if (ProjectData.percussionStrips.contains("Doyr")){
            doyraNumber.setSelectedItem(1);
        }else if (!ProjectData.percussionStrips.contains("Doy3") && ProjectData.percussionStrips.contains("Doy2")){
            doyraNumber.setSelectedItem(2);
        }else if (!ProjectData.percussionStrips.contains("Doy4") && ProjectData.percussionStrips.contains("Doy3")){
            doyraNumber.setSelectedItem(3);
        }else if (!ProjectData.percussionStrips.contains("Doy5") && ProjectData.percussionStrips.contains("Doy4")){
            doyraNumber.setSelectedItem(4);
        }else if (ProjectData.percussionStrips.contains("Doy5")){
            doyraNumber.setSelectedItem(5);
        }
        doyraNumber.addItemListener(this);
        numbersContainerRight.add(doyraNumber);
//tabla
        labelContainerRight.add(tablaLabel);
        tablaNumber.addItem(0);
        tablaNumber.addItem(1);
        tablaNumber.addItem(2);
        tablaNumber.addItem(3);
        if (ProjectData.percussionStrips.contains("Tabl")){
            tablaNumber.setSelectedItem(1);
        }else if (!ProjectData.percussionStrips.contains("Tab3") && ProjectData.percussionStrips.contains("Tab2")){
            tablaNumber.setSelectedItem(2);
        }else if (ProjectData.percussionStrips.contains("Tab3")){
            tablaNumber.setSelectedItem(3);
        }
        tablaNumber.addItemListener(this);
        numbersContainerRight.add(tablaNumber);
//nagora
        labelContainerRight.add(nagoraLabel);
        nagoraNumber.addItem(0);
        nagoraNumber.addItem(1);
        nagoraNumber.addItem(2);
        nagoraNumber.addItem(3);
        if (ProjectData.percussionStrips.contains("Nago")){
            nagoraNumber.setSelectedItem(1);
        }else if (!ProjectData.percussionStrips.contains("Nag3") && ProjectData.percussionStrips.contains("Nag2")){
            nagoraNumber.setSelectedItem(2);
        }else if (ProjectData.percussionStrips.contains("Nag3")){
            nagoraNumber.setSelectedItem(3);
        }
        nagoraNumber.addItemListener(this);
        numbersContainerRight.add(nagoraNumber);
//Jambey
        labelContainerRight.add(jambeyLabel);
        jambeyNumber.addItem(0);
        jambeyNumber.addItem(1);
        jambeyNumber.addItem(2);
        if (ProjectData.percussionStrips.contains("Jamb")){
            jambeyNumber.setSelectedItem(1);
        }else if (ProjectData.percussionStrips.contains("Jam2")){
            jambeyNumber.setSelectedItem(2);
        }
        jambeyNumber.addItemListener(this);
        numbersContainerRight.add(jambeyNumber);
//kajon
        labelContainerRight.add(kajonLabel);
        kajonNumber.addItem(0);
        kajonNumber.addItem(1);
        kajonNumber.addItem(2);
        if (ProjectData.percussionStrips.contains("Kjon")){
            kajonNumber.setSelectedItem(1);
        }else if (ProjectData.percussionStrips.contains("Kjn2")){
            kajonNumber.setSelectedItem(2);
        }
        jambeyNumber.addItemListener(this);
        numbersContainerRight.add(kajonNumber);
//other percussion
        labelContainerRight.add(othersLabel);
        othersNumber.addItem(0);
        othersNumber.addItem(1);
        othersNumber.addItem(2);
        othersNumber.addItem(3);
        othersNumber.addItem(4);
        othersNumber.addItem(5);
        if (ProjectData.percussionStrips.contains("Perc")){
            othersNumber.setSelectedItem(1);
        }else if (!ProjectData.percussionStrips.contains("Per3") && ProjectData.percussionStrips.contains("Per2")){
            othersNumber.setSelectedItem(2);
        }else if (!ProjectData.percussionStrips.contains("Per4") && ProjectData.percussionStrips.contains("Per3")){
            othersNumber.setSelectedItem(3);
        }else if (!ProjectData.percussionStrips.contains("Per5") && ProjectData.percussionStrips.contains("Per4")){
            othersNumber.setSelectedItem(4);
        }else if (ProjectData.percussionStrips.contains("Per5")){
            othersNumber.setSelectedItem(5);
        }
        othersNumber.addItemListener(this);
        numbersContainerRight.add(othersNumber);

        container.add(labelContainerRight);
        container.add(numbersContainerRight);
//gui elements end

//Button apply start
        buttonApply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectData.percussionStrips.clear();
//congas
                switch ((int) congasNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.percussionStrips.add("Cong");
                        break;
                    case 2:
                        ProjectData.percussionStrips.add("Cng1");
                        ProjectData.percussionStrips.add("Cng2");
                        break;
                    case 3:
                        ProjectData.percussionStrips.add("Cng1");
                        ProjectData.percussionStrips.add("Cng2");
                        ProjectData.percussionStrips.add("Cng3");
                        break;
                }
//bongos
                switch ((int) bongosNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.percussionStrips.add("Bong");
                        break;
                    case 2:
                        ProjectData.percussionStrips.add("Bng1");
                        ProjectData.percussionStrips.add("Bng2");
                        break;
                }
//shaker
                switch ((int) shakerNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.percussionStrips.add("Shkr");
                        break;
                    case 2:
                        ProjectData.percussionStrips.add("Shk1");
                        ProjectData.percussionStrips.add("Shk2");
                        break;
                    case 3:
                        ProjectData.percussionStrips.add("Shk1");
                        ProjectData.percussionStrips.add("Shk2");
                        ProjectData.percussionStrips.add("Shk3");
                        break;
                }
//tambourine
                switch ((int) tambourineNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.percussionStrips.add("Tmbn");
                        break;
                    case 2:
                        ProjectData.percussionStrips.add("Tmn1");
                        ProjectData.percussionStrips.add("Tmn2");
                        break;
                    case 3:
                        ProjectData.percussionStrips.add("Tmn1");
                        ProjectData.percussionStrips.add("Tmn2");
                        ProjectData.percussionStrips.add("Tmn3");
                        break;
                }
//perc. overhead
                switch ((int) overNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.percussionStrips.add("OvHd");
                        break;
                    case 2:
                        ProjectData.percussionStrips.add("OHd1");
                        ProjectData.percussionStrips.add("OHd2");
                        break;
                }
//doyra
                switch ((int) doyraNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.percussionStrips.add("Doyr");
                        break;
                    case 2:
                        ProjectData.percussionStrips.add("Doy1");
                        ProjectData.percussionStrips.add("Doy2");
                        break;
                    case 3:
                        ProjectData.percussionStrips.add("Doy1");
                        ProjectData.percussionStrips.add("Doy2");
                        ProjectData.percussionStrips.add("Doy3");
                        break;
                    case 4:
                        ProjectData.percussionStrips.add("Doy1");
                        ProjectData.percussionStrips.add("Doy2");
                        ProjectData.percussionStrips.add("Doy3");
                        ProjectData.percussionStrips.add("Doy4");
                        break;
                    case 5:
                        ProjectData.percussionStrips.add("Doy1");
                        ProjectData.percussionStrips.add("Doy2");
                        ProjectData.percussionStrips.add("Doy3");
                        ProjectData.percussionStrips.add("Doy4");
                        ProjectData.percussionStrips.add("Doy5");
                        break;
                }
//tabla
                switch ((int) tablaNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.percussionStrips.add("Tabl");
                        break;
                    case 2:
                        ProjectData.percussionStrips.add("Tab1");
                        ProjectData.percussionStrips.add("Tab2");
                        break;
                    case 3:
                        ProjectData.percussionStrips.add("Tab1");
                        ProjectData.percussionStrips.add("Tab2");
                        ProjectData.percussionStrips.add("Tab3");
                        break;
                }
//nagora
                switch ((int) nagoraNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.percussionStrips.add("Nago");
                        break;
                    case 2:
                        ProjectData.percussionStrips.add("Nag1");
                        ProjectData.percussionStrips.add("Nag2");
                        break;
                    case 3:
                        ProjectData.percussionStrips.add("Nag1");
                        ProjectData.percussionStrips.add("Nag2");
                        ProjectData.percussionStrips.add("Nag3");
                        break;
                }
//Jambey
                switch ((int) jambeyNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.percussionStrips.add("Jamb");
                        break;
                    case 2:
                        ProjectData.percussionStrips.add("Jam1");
                        ProjectData.percussionStrips.add("Jam2");
                        break;
                }
//kajon
                switch ((int) kajonNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.percussionStrips.add("Kjon");
                        break;
                    case 2:
                        ProjectData.percussionStrips.add("Kjn1");
                        ProjectData.percussionStrips.add("Kjn2");
                        break;
                }
//other percussion
                switch ((int) othersNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.percussionStrips.add("Perc");
                        break;
                    case 2:
                        ProjectData.percussionStrips.add("Per1");
                        ProjectData.percussionStrips.add("Per2");
                        break;
                    case 3:
                        ProjectData.percussionStrips.add("Per1");
                        ProjectData.percussionStrips.add("Per2");
                        ProjectData.percussionStrips.add("Per3");
                        break;
                    case 4:
                        ProjectData.percussionStrips.add("Per1");
                        ProjectData.percussionStrips.add("Per2");
                        ProjectData.percussionStrips.add("Per3");
                        ProjectData.percussionStrips.add("Per4");
                        break;
                    case 5:
                        ProjectData.percussionStrips.add("Per1");
                        ProjectData.percussionStrips.add("Per2");
                        ProjectData.percussionStrips.add("Per3");
                        ProjectData.percussionStrips.add("Per4");
                        ProjectData.percussionStrips.add("Per5");
                        break;
                }

                theseChannelsLabel.setText("These Channels: " + ProjectData.percussionStrips.size());
                DefineInstruments.buttonPercuss.setText("Percussion" + ProjectData.percussionStrips.size());
            }
        });
//Button apply end
//button no one
        buttonNoOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                congasNumber.setSelectedItem(0);
                bongosNumber.setSelectedItem(0);
                shakerNumber.setSelectedItem(0);
                tambourineNumber.setSelectedItem(0);
                overNumber.setSelectedItem(0);
                doyraNumber.setSelectedItem(0);
                tablaNumber.setSelectedItem(0);
                nagoraNumber.setSelectedItem(0);
                jambeyNumber.setSelectedItem(0);
                othersNumber.setSelectedItem(0);
                }
        });
    }
}

