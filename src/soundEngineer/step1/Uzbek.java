package soundEngineer.step1;

import soundEngineer.server.ProjectData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Uzbek extends GUIStamp {
    public final String IMAGE_FILE_NAME = "uzbek.jpg";
    private JLabel rubobLabel = new JLabel("Rubob");
    private JLabel dutorLabel = new JLabel("Dutor");
    private JLabel bassDutorLabel = new JLabel("Bass-dutor");
    private JLabel tamburLabel = new JLabel("Tambur");
    private JLabel sozLabel = new JLabel("Soz");
    private JLabel audLabel = new JLabel("Aud");
    private JLabel changLabel = new JLabel("Chang");
    private JLabel konunLabel = new JLabel("Konun");
    private JLabel nayLabel = new JLabel("Nay");
    private JLabel kushNayLabel = new JLabel("Kushnay");
    private JLabel surNayLabel = new JLabel("Surnay");
    private JLabel vioLabel = new JLabel("Violin");
    private JLabel gijakLabel = new JLabel("Gijak");
    private JLabel celloLabel = new JLabel("Cello");

    private JComboBox<Integer> rubobNumber = new JComboBox();
    private JComboBox<Integer> dutorNumber = new JComboBox();
    private JComboBox<Integer> bassDutorNumber = new JComboBox();
    private JComboBox<Integer> tamburNumber = new JComboBox();
    private JComboBox<Integer> sozNumber = new JComboBox();
    private JComboBox<Integer> audNumber = new JComboBox();
    private JComboBox<Integer> changNumber = new JComboBox();
    private JComboBox<Integer> konunNumber = new JComboBox();
    private JComboBox<Integer> nayNumber = new JComboBox();
    private JComboBox<Integer> kushNayNumber = new JComboBox();
    private JComboBox<Integer> surNayNumber = new JComboBox();
    private JComboBox<Integer> vioNumber = new JComboBox();
    private JComboBox<Integer> gijakNumber = new JComboBox();
    private JComboBox<Integer> celloNumber = new JComboBox();

    public Uzbek() throws HeadlessException {
        pageNameLabel.setText(" Select Uzbek");
//gui elements start
//labels
        pageNameLabel.setBounds(330, 5, 140, 50);
        pageNameLabel.setBackground(Color.BLUE);
        pageNameLabel.setForeground(Color.orange);
        pageNameLabel.setOpaque(true);
        allChannelsLabel.setBackground(Color.BLUE);
        allChannelsLabel.setForeground(Color.orange);
        allChannelsLabel.setOpaque(true);
        theseChannelsLabel.setBackground(Color.BLUE);
        theseChannelsLabel.setForeground(Color.orange);
        theseChannelsLabel.setOpaque(true);
//label containers
        Container labelContainerLeft = new Container();
        labelContainerLeft.setLayout(new GridLayout(7,1, 5, 5));
        labelContainerLeft.setBounds(250, 100, 70, 200);

        Container labelContainerRight = new Container();
        labelContainerRight.setLayout(new GridLayout(7,1, 5, 5));
        labelContainerRight.setBounds(450, 100, 70, 200);
//combo boxes containers
        Container numbersContainerLeft = new Container();//for combo boxes
        numbersContainerLeft.setLayout(new GridLayout(7,1, 5, 5));
        numbersContainerLeft.setBounds(320, 100, 40, 200);

        Container numbersContainerRight = new Container();//for combo boxes
        numbersContainerRight.setLayout(new GridLayout(7,1, 5, 5));
        numbersContainerRight.setBounds(520, 100, 40, 200);

//rubob
        rubobLabel.setBackground(Color.BLUE);
        rubobLabel.setForeground(Color.orange);
        rubobLabel.setOpaque(true);
        labelContainerLeft.add(rubobLabel);
        rubobNumber.addItem(0);
        rubobNumber.addItem(1);
        rubobNumber.addItem(2);
        rubobNumber.addItem(3);
        rubobNumber.addItem(4);
        if (ProjectData.uzbekStrips.contains("Rub")){
            rubobNumber.setSelectedItem(1);
        }else if (!ProjectData.uzbekStrips.contains("Rub3") && ProjectData.uzbekStrips.contains("Rub2")){
            rubobNumber.setSelectedItem(2);
        }else if (!ProjectData.uzbekStrips.contains("Rub4") && ProjectData.uzbekStrips.contains("Rub3")){
            rubobNumber.setSelectedItem(3);
        }else if (ProjectData.uzbekStrips.contains("Rub4")) {
            rubobNumber.setSelectedItem(4);
        }
        rubobNumber.addItemListener(this);
        numbersContainerLeft.add(rubobNumber);
//dutor
        dutorLabel.setBackground(Color.BLUE);
        dutorLabel.setForeground(Color.orange);
        dutorLabel.setOpaque(true);
        labelContainerLeft.add(dutorLabel);
        dutorNumber.addItem(0);
        dutorNumber.addItem(1);
        dutorNumber.addItem(2);
        dutorNumber.addItem(3);
        dutorNumber.addItem(4);
        dutorNumber.addItem(5);
        dutorNumber.addItem(6);
        dutorNumber.addItem(7);
        dutorNumber.addItem(8);
        dutorNumber.addItem(9);
        dutorNumber.addItem(10);
        if (ProjectData.uzbekStrips.contains("Dut")){
            dutorNumber.setSelectedItem(1);
        }else if (!ProjectData.uzbekStrips.contains("Dut3") && ProjectData.uzbekStrips.contains("Dut2")){
            dutorNumber.setSelectedItem(2);
        }else if (!ProjectData.uzbekStrips.contains("Dut4") && ProjectData.uzbekStrips.contains("Dut3")){
            dutorNumber.setSelectedItem(3);
        }else if (!ProjectData.uzbekStrips.contains("Dut5") && ProjectData.uzbekStrips.contains("Dut4")){
            dutorNumber.setSelectedItem(4);
        }else if (!ProjectData.uzbekStrips.contains("Dut6") && ProjectData.uzbekStrips.contains("Dut5")){
            dutorNumber.setSelectedItem(5);
        }else if (!ProjectData.uzbekStrips.contains("Dut7") && ProjectData.uzbekStrips.contains("Dut6")){
            dutorNumber.setSelectedItem(6);
        }else if (!ProjectData.uzbekStrips.contains("Dut8") && ProjectData.uzbekStrips.contains("Dut7")){
            dutorNumber.setSelectedItem(7);
        }else if (!ProjectData.uzbekStrips.contains("Dut9") && ProjectData.uzbekStrips.contains("Dut8")){
            dutorNumber.setSelectedItem(8);
        }else if (!ProjectData.uzbekStrips.contains("Du10") && ProjectData.uzbekStrips.contains("Dut9")){
            dutorNumber.setSelectedItem(9);
        }else if (ProjectData.uzbekStrips.contains("Du10")){
            dutorNumber.setSelectedItem(10);
        }
        dutorNumber.addItemListener(this);
        numbersContainerLeft.add(dutorNumber);
//bass dutor
        bassDutorLabel.setBackground(Color.BLUE);
        bassDutorLabel.setForeground(Color.orange);
        bassDutorLabel.setOpaque(true);
        labelContainerLeft.add(bassDutorLabel);
        bassDutorNumber.addItem(0);
        bassDutorNumber.addItem(1);
        bassDutorNumber.addItem(2);
        bassDutorNumber.addItem(3);
        bassDutorNumber.addItem(4);
        if (ProjectData.uzbekStrips.contains("BDut")){
            bassDutorNumber.setSelectedItem(1);
        }else if (!ProjectData.uzbekStrips.contains("BDu3") && ProjectData.uzbekStrips.contains("BDu2")){
            bassDutorNumber.setSelectedItem(2);
        }else if (!ProjectData.uzbekStrips.contains("BDu4") && ProjectData.uzbekStrips.contains("BDu3")){
            bassDutorNumber.setSelectedItem(3);
        }else if (ProjectData.uzbekStrips.contains("BDu4")) {
            bassDutorNumber.setSelectedItem(4);
        }
        bassDutorNumber.addItemListener(this);
        numbersContainerLeft.add(bassDutorNumber);
//tambur
        tamburLabel.setBackground(Color.BLUE);
        tamburLabel.setForeground(Color.orange);
        tamburLabel.setOpaque(true);
        labelContainerLeft.add(tamburLabel);
        tamburNumber.addItem(0);
        tamburNumber.addItem(1);
        tamburNumber.addItem(2);
        tamburNumber.addItem(3);
        if (ProjectData.uzbekStrips.contains("tam")){
            tamburNumber.setSelectedItem(1);
        }else if (!ProjectData.uzbekStrips.contains("tam3") && ProjectData.uzbekStrips.contains("tam2")){
            tamburNumber.setSelectedItem(2);
        }else if (ProjectData.uzbekStrips.contains("tam3")){
            tamburNumber.setSelectedItem(3);
        }
        tamburNumber.addItemListener(this);
        numbersContainerLeft.add(tamburNumber);
//soz
        sozLabel.setBackground(Color.BLUE);
        sozLabel.setForeground(Color.orange);
        sozLabel.setOpaque(true);
        labelContainerLeft.add(sozLabel);
        sozNumber.addItem(0);
        sozNumber.addItem(1);
        sozNumber.addItem(2);
        sozNumber.addItemListener(this);
        if (ProjectData.uzbekStrips.contains("Soz")){
            sozNumber.setSelectedItem(1);
        }else if (ProjectData.uzbekStrips.contains("Soz2")){
            sozNumber.setSelectedItem(2);
        }
        sozNumber.addItemListener(this);
        numbersContainerLeft.add(sozNumber);
//aud
        audLabel.setBackground(Color.BLUE);
        audLabel.setForeground(Color.orange);
        audLabel.setOpaque(true);
        labelContainerLeft.add(audLabel);
        audNumber.addItem(0);
        audNumber.addItem(1);
        audNumber.addItem(2);
        audNumber.addItem(3);
        if (ProjectData.uzbekStrips.contains("Aud")){
            audNumber.setSelectedItem(1);
        }else if (!ProjectData.uzbekStrips.contains("Aud3") && ProjectData.uzbekStrips.contains("Aud2")){
            audNumber.setSelectedItem(2);
        }else if (ProjectData.uzbekStrips.contains("Aud3")){
            audNumber.setSelectedItem(3);
        }
        audNumber.addItemListener(this);
        numbersContainerLeft.add(audNumber);
//chang
        changLabel.setBackground(Color.BLUE);
        changLabel.setForeground(Color.orange);
        changLabel.setOpaque(true);
        labelContainerLeft.add(changLabel);
        changNumber.addItem(0);
        changNumber.addItem(1);
        changNumber.addItem(2);
        if (ProjectData.uzbekStrips.contains("Chng")){
            changNumber.setSelectedItem(1);
        }else if (ProjectData.uzbekStrips.contains("Chg2")){
            changNumber.setSelectedItem(2);
        }
        changNumber.addItemListener(this);
        numbersContainerLeft.add(changNumber);
//konun
        konunLabel.setBackground(Color.BLUE);
        konunLabel.setForeground(Color.orange);
        konunLabel.setOpaque(true);
        labelContainerRight.add(konunLabel);
        konunNumber.addItem(0);
        konunNumber.addItem(1);
        konunNumber.addItem(2);
        konunNumber.addItem(3);
        if (ProjectData.uzbekStrips.contains("Kon")){
            konunNumber.setSelectedItem(1);
        }else if (!ProjectData.uzbekStrips.contains("Kon3") && ProjectData.uzbekStrips.contains("Kon2")){
            konunNumber.setSelectedItem(2);
        }else if (ProjectData.uzbekStrips.contains("Kon3")){
            konunNumber.setSelectedItem(3);
        }
        konunNumber.addItemListener(this);
        numbersContainerRight.add(konunNumber);
//nay
        nayLabel.setBackground(Color.BLUE);
        nayLabel.setForeground(Color.orange);
        nayLabel.setOpaque(true);
        labelContainerRight.add(nayLabel);
        nayNumber.addItem(0);
        nayNumber.addItem(1);
        nayNumber.addItem(2);
        nayNumber.addItem(3);
        nayNumber.addItem(4);
        if (ProjectData.uzbekStrips.contains("Nay")){
            nayNumber.setSelectedItem(1);
        }else if (!ProjectData.uzbekStrips.contains("Nay3") && ProjectData.uzbekStrips.contains("Nay2")){
            nayNumber.setSelectedItem(2);
        }else if (!ProjectData.uzbekStrips.contains("Nay4") && ProjectData.uzbekStrips.contains("Nay3")){
            nayNumber.setSelectedItem(3);
        }else if (ProjectData.uzbekStrips.contains("Nay4")) {
            nayNumber.setSelectedItem(4);
        }
        nayNumber.addItemListener(this);
        numbersContainerRight.add(nayNumber);
//kushnay
        kushNayLabel.setBackground(Color.BLUE);
        kushNayLabel.setForeground(Color.orange);
        kushNayLabel.setOpaque(true);
        labelContainerRight.add(kushNayLabel);
        kushNayNumber.addItem(0);
        kushNayNumber.addItem(1);
        kushNayNumber.addItem(2);
        kushNayNumber.addItem(3);
        kushNayNumber.addItem(4);
        if (ProjectData.uzbekStrips.contains("KNay")){
            kushNayNumber.setSelectedItem(1);
        }else if (!ProjectData.uzbekStrips.contains("KNa3") && ProjectData.uzbekStrips.contains("KNa2")){
            kushNayNumber.setSelectedItem(2);
        }else if (!ProjectData.uzbekStrips.contains("KNa4") && ProjectData.uzbekStrips.contains("KNa3")){
            kushNayNumber.setSelectedItem(3);
        }else if (ProjectData.uzbekStrips.contains("KNa4")) {
            kushNayNumber.setSelectedItem(4);
        }
        kushNayNumber.addItemListener(this);
        numbersContainerRight.add(kushNayNumber);
//surnay
        surNayLabel.setBackground(Color.BLUE);
        surNayLabel.setForeground(Color.orange);
        surNayLabel.setOpaque(true);
        labelContainerRight.add(surNayLabel);
        surNayNumber.addItem(0);
        surNayNumber.addItem(1);
        surNayNumber.addItem(2);
        surNayNumber.addItem(3);
        surNayNumber.addItem(4);
        if (ProjectData.uzbekStrips.contains("SNay")){
            surNayNumber.setSelectedItem(1);
        }else if (!ProjectData.uzbekStrips.contains("SNa3") && ProjectData.uzbekStrips.contains("SNa2")){
            surNayNumber.setSelectedItem(2);
        }else if (!ProjectData.uzbekStrips.contains("SNa4") && ProjectData.uzbekStrips.contains("SNa3")){
            surNayNumber.setSelectedItem(3);
        }else if (ProjectData.uzbekStrips.contains("SNa4")) {
            surNayNumber.setSelectedItem(4);
        }
        surNayNumber.addItemListener(this);
        numbersContainerRight.add(surNayNumber);
//violin
        vioLabel.setBackground(Color.BLUE);
        vioLabel.setForeground(Color.orange);
        vioLabel.setOpaque(true);
        labelContainerRight.add(vioLabel);
        vioNumber.addItem(0);
        vioNumber.addItem(1);
        vioNumber.addItem(2);
        vioNumber.addItem(3);
        vioNumber.addItem(4);
        if (ProjectData.uzbekStrips.contains("vio")){
            vioNumber.setSelectedItem(1);
        }else if (!ProjectData.uzbekStrips.contains("vio3") && ProjectData.uzbekStrips.contains("vio2")){
            vioNumber.setSelectedItem(2);
        }else if (!ProjectData.uzbekStrips.contains("vio4") && ProjectData.uzbekStrips.contains("vio3")){
            vioNumber.setSelectedItem(3);
        }else if (ProjectData.uzbekStrips.contains("vio4")) {
            vioNumber.setSelectedItem(4);
        }
        vioNumber.addItemListener(this);
        numbersContainerRight.add(vioNumber);
//gijak
        gijakLabel.setBackground(Color.BLUE);
        gijakLabel.setForeground(Color.orange);
        gijakLabel.setOpaque(true);
        labelContainerRight.add(gijakLabel);
        gijakNumber.addItem(0);
        gijakNumber.addItem(1);
        gijakNumber.addItem(2);
        gijakNumber.addItem(3);
        gijakNumber.addItem(4);
        if (ProjectData.uzbekStrips.contains("Gij")){
            gijakNumber.setSelectedItem(1);
        }else if (!ProjectData.uzbekStrips.contains("Gij3") && ProjectData.uzbekStrips.contains("Gij2")){
            gijakNumber.setSelectedItem(2);
        }else if (!ProjectData.uzbekStrips.contains("Gij4") && ProjectData.uzbekStrips.contains("Gij3")){
            gijakNumber.setSelectedItem(3);
        }else if (ProjectData.uzbekStrips.contains("Gij4")) {
            gijakNumber.setSelectedItem(4);
        }
        gijakNumber.addItemListener(this);
        numbersContainerRight.add(gijakNumber);
//cello
        celloLabel.setBackground(Color.BLUE);
        celloLabel.setForeground(Color.orange);
        celloLabel.setOpaque(true);
        labelContainerRight.add(celloLabel);
        celloNumber.addItem(0);
        celloNumber.addItem(1);
        celloNumber.addItem(2);
        if (ProjectData.uzbekStrips.contains("cel")){
            celloNumber.setSelectedItem(1);
        }else if (ProjectData.uzbekStrips.contains("cel2")){
            celloNumber.setSelectedItem(2);
        }
        celloNumber.addItemListener(this);
        numbersContainerRight.add(celloNumber);

        container.add(labelContainerLeft);
        container.add(numbersContainerLeft);
        container.add(labelContainerRight);
        container.add(numbersContainerRight);
//elements end

//Button apply start
        buttonApply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectData.uzbekStrips.clear();

//rubob
                switch ((int) rubobNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.uzbekStrips.add("Rub");
                        break;
                    case 2:
                        ProjectData.uzbekStrips.add("Rub1");
                        ProjectData.uzbekStrips.add("Rub2");
                        break;
                    case 3:
                        ProjectData.uzbekStrips.add("Rub1");
                        ProjectData.uzbekStrips.add("Rub2");
                        ProjectData.uzbekStrips.add("Rub3");
                        break;
                    case 4:
                        ProjectData.uzbekStrips.add("Rub1");
                        ProjectData.uzbekStrips.add("Rub2");
                        ProjectData.uzbekStrips.add("Rub3");
                        ProjectData.uzbekStrips.add("Rub4");
                        break;
                }
//dutor
                switch ((int) dutorNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.uzbekStrips.add("Dut");
                        break;
                    case 2:
                        ProjectData.uzbekStrips.add("Dut1");
                        ProjectData.uzbekStrips.add("Dut2");
                        break;
                    case 3:
                        ProjectData.uzbekStrips.add("Dut1");
                        ProjectData.uzbekStrips.add("Dut2");
                        ProjectData.uzbekStrips.add("Dut3");
                        break;
                    case 4:
                        ProjectData.uzbekStrips.add("Dut1");
                        ProjectData.uzbekStrips.add("Dut2");
                        ProjectData.uzbekStrips.add("Dut3");
                        ProjectData.uzbekStrips.add("Dut4");
                        break;
                    case 5:
                        ProjectData.uzbekStrips.add("Dut1");
                        ProjectData.uzbekStrips.add("Dut2");
                        ProjectData.uzbekStrips.add("Dut3");
                        ProjectData.uzbekStrips.add("Dut4");
                        ProjectData.uzbekStrips.add("Dut5");
                        break;
                    case 6:
                        ProjectData.uzbekStrips.add("Dut1");
                        ProjectData.uzbekStrips.add("Dut2");
                        ProjectData.uzbekStrips.add("Dut3");
                        ProjectData.uzbekStrips.add("Dut4");
                        ProjectData.uzbekStrips.add("Dut5");
                        ProjectData.uzbekStrips.add("Dut6");
                        break;
                    case 7:
                        ProjectData.uzbekStrips.add("Dut1");
                        ProjectData.uzbekStrips.add("Dut2");
                        ProjectData.uzbekStrips.add("Dut3");
                        ProjectData.uzbekStrips.add("Dut4");
                        ProjectData.uzbekStrips.add("Dut5");
                        ProjectData.uzbekStrips.add("Dut6");
                        ProjectData.uzbekStrips.add("Dut7");
                        break;
                    case 8:
                        ProjectData.uzbekStrips.add("Dut1");
                        ProjectData.uzbekStrips.add("Dut2");
                        ProjectData.uzbekStrips.add("Dut3");
                        ProjectData.uzbekStrips.add("Dut4");
                        ProjectData.uzbekStrips.add("Dut5");
                        ProjectData.uzbekStrips.add("Dut6");
                        ProjectData.uzbekStrips.add("Dut7");
                        ProjectData.uzbekStrips.add("Dut8");
                        break;
                    case 9:
                        ProjectData.uzbekStrips.add("Dut1");
                        ProjectData.uzbekStrips.add("Dut2");
                        ProjectData.uzbekStrips.add("Dut3");
                        ProjectData.uzbekStrips.add("Dut4");
                        ProjectData.uzbekStrips.add("Dut5");
                        ProjectData.uzbekStrips.add("Dut6");
                        ProjectData.uzbekStrips.add("Dut7");
                        ProjectData.uzbekStrips.add("Dut8");
                        ProjectData.uzbekStrips.add("Dut9");
                        break;
                    case 10:
                        ProjectData.uzbekStrips.add("Dut1");
                        ProjectData.uzbekStrips.add("Dut2");
                        ProjectData.uzbekStrips.add("Dut3");
                        ProjectData.uzbekStrips.add("Dut4");
                        ProjectData.uzbekStrips.add("Dut5");
                        ProjectData.uzbekStrips.add("Dut6");
                        ProjectData.uzbekStrips.add("Dut7");
                        ProjectData.uzbekStrips.add("Dut8");
                        ProjectData.uzbekStrips.add("Dut9");
                        ProjectData.uzbekStrips.add("Du10");
                        break;
                }
//bass dutor
                switch ((int) bassDutorNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.uzbekStrips.add("BDut");
                        break;
                    case 2:
                        ProjectData.uzbekStrips.add("BDu1");
                        ProjectData.uzbekStrips.add("BDu2");
                        break;
                    case 3:
                        ProjectData.uzbekStrips.add("BDu1");
                        ProjectData.uzbekStrips.add("BDu2");
                        ProjectData.uzbekStrips.add("BDu3");
                        break;
                    case 4:
                        ProjectData.uzbekStrips.add("BDu1");
                        ProjectData.uzbekStrips.add("BDu2");
                        ProjectData.uzbekStrips.add("BDu3");
                        ProjectData.uzbekStrips.add("BDu4");
                        break;
                }
//tambur
                switch ((int) tamburNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.uzbekStrips.add("tam");
                        break;
                    case 2:
                        ProjectData.uzbekStrips.add("tam1");
                        ProjectData.uzbekStrips.add("tam2");
                        break;
                    case 3:
                        ProjectData.uzbekStrips.add("tam1");
                        ProjectData.uzbekStrips.add("tam2");
                        ProjectData.uzbekStrips.add("tam3");
                        break;
                }
//soz
                switch ((int) sozNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.uzbekStrips.add("Soz");
                        break;
                    case 2:
                        ProjectData.uzbekStrips.add("Soz1");
                        ProjectData.uzbekStrips.add("Soz2");
                        break;
                }
//aud
                switch ((int) audNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.uzbekStrips.add("Aud");
                        break;
                    case 2:
                        ProjectData.uzbekStrips.add("Aud1");
                        ProjectData.uzbekStrips.add("Aud2");
                        break;
                    case 3:
                        ProjectData.uzbekStrips.add("Aud1");
                        ProjectData.uzbekStrips.add("Aud2");
                        ProjectData.uzbekStrips.add("Aud3");
                        break;
                }
//chang
                switch ((int) changNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.uzbekStrips.add("Chng");
                        break;
                    case 2:
                        ProjectData.uzbekStrips.add("Chg1");
                        ProjectData.uzbekStrips.add("Chg2");
                        break;
                }
//konun
                switch ((int) konunNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.uzbekStrips.add("Kon");
                        break;
                    case 2:
                        ProjectData.uzbekStrips.add("Kon1");
                        ProjectData.uzbekStrips.add("Kon2");
                        break;
                    case 3:
                        ProjectData.uzbekStrips.add("Kon1");
                        ProjectData.uzbekStrips.add("Kon2");
                        ProjectData.uzbekStrips.add("Kon3");
                        break;
                }
//nay
                switch ((int) nayNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.uzbekStrips.add("Nay");
                        break;
                    case 2:
                        ProjectData.uzbekStrips.add("Nay1");
                        ProjectData.uzbekStrips.add("Nay2");
                        break;
                    case 3:
                        ProjectData.uzbekStrips.add("Nay1");
                        ProjectData.uzbekStrips.add("Nay2");
                        ProjectData.uzbekStrips.add("Nay3");
                        break;
                    case 4:
                        ProjectData.uzbekStrips.add("Nay1");
                        ProjectData.uzbekStrips.add("Nay2");
                        ProjectData.uzbekStrips.add("Nay3");
                        ProjectData.uzbekStrips.add("Nay4");
                        break;
                }
//kushNay
                switch ((int) kushNayNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.uzbekStrips.add("KNay");
                        break;
                    case 2:
                        ProjectData.uzbekStrips.add("KNa1");
                        ProjectData.uzbekStrips.add("KNa2");
                        break;
                    case 3:
                        ProjectData.uzbekStrips.add("KNa1");
                        ProjectData.uzbekStrips.add("KNa2");
                        ProjectData.uzbekStrips.add("KNa3");
                        break;
                    case 4:
                        ProjectData.uzbekStrips.add("KNa1");
                        ProjectData.uzbekStrips.add("KNa2");
                        ProjectData.uzbekStrips.add("KNa3");
                        ProjectData.uzbekStrips.add("KNa4");
                        break;
                }
//surNay
                switch ((int) surNayNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.uzbekStrips.add("SNay");
                        break;
                    case 2:
                        ProjectData.uzbekStrips.add("SNa1");
                        ProjectData.uzbekStrips.add("SNa2");
                        break;
                    case 3:
                        ProjectData.uzbekStrips.add("SNa1");
                        ProjectData.uzbekStrips.add("SNa2");
                        ProjectData.uzbekStrips.add("SNa3");
                        break;
                    case 4:
                        ProjectData.uzbekStrips.add("SNa1");
                        ProjectData.uzbekStrips.add("SNa2");
                        ProjectData.uzbekStrips.add("SNa3");
                        ProjectData.uzbekStrips.add("SNa4");
                        break;
                }
//violin
                switch ((int) vioNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.uzbekStrips.add("vio");
                        break;
                    case 2:
                        ProjectData.uzbekStrips.add("vio1");
                        ProjectData.uzbekStrips.add("vio2");
                        break;
                    case 3:
                        ProjectData.uzbekStrips.add("vio1");
                        ProjectData.uzbekStrips.add("vio2");
                        ProjectData.uzbekStrips.add("vio3");
                        break;
                    case 4:
                        ProjectData.uzbekStrips.add("vio1");
                        ProjectData.uzbekStrips.add("vio2");
                        ProjectData.uzbekStrips.add("vio3");
                        ProjectData.uzbekStrips.add("vio4");
                        break;
                }
//gijak
                String gijakSel = gijakNumber.getSelectedItem().toString();
                switch ((int) gijakNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.uzbekStrips.add("Gij");
                        break;
                    case 2:
                        ProjectData.uzbekStrips.add("Gij1");
                        ProjectData.uzbekStrips.add("Gij2");
                        break;
                    case 3:
                        ProjectData.uzbekStrips.add("Gij1");
                        ProjectData.uzbekStrips.add("Gij2");
                        ProjectData.uzbekStrips.add("Gij3");
                        break;
                    case 4:
                        ProjectData.uzbekStrips.add("Gij1");
                        ProjectData.uzbekStrips.add("Gij2");
                        ProjectData.uzbekStrips.add("Gij3");
                        ProjectData.uzbekStrips.add("Gij4");
                        break;
                }
//cello
                switch ((int) celloNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.uzbekStrips.add("cel");
                        break;
                    case 2:
                        ProjectData.uzbekStrips.add("cel1");
                        ProjectData.uzbekStrips.add("cel2");
                        break;
                }
                theseChannelsLabel.setText("These Channels: " + ProjectData.uzbekStrips.size());
                DefineInstruments.buttonUzbek.setText("Uzbek" + ProjectData.uzbekStrips.size());
            }
        });
//Button apply end
//button no one
        buttonNoOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rubobNumber.setSelectedItem(0);
                dutorNumber.setSelectedItem(0);
                bassDutorNumber.setSelectedItem(0);
                tamburNumber.setSelectedItem(0);
                sozNumber.setSelectedItem(0);
                audNumber.setSelectedItem(0);
                changNumber.setSelectedItem(0);
                konunNumber.setSelectedItem(0);
                nayNumber.setSelectedItem(0);
                kushNayNumber.setSelectedItem(0);
                surNayNumber.setSelectedItem(0);
                vioNumber.setSelectedItem(0);
                gijakNumber.setSelectedItem(0);
                celloNumber.setSelectedItem(0);
            }
        });
    }
}

