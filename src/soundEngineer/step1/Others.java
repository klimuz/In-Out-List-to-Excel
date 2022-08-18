package soundEngineer.step1;

import soundEngineer.server.ProjectData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Others extends GUIStamp{
    public final String IMAGE_FILE_NAME = "mixer.jpg";
    private JLabel dJLabel = new JLabel("Stereo DJ");
    private JLabel screenLabel = new JLabel("Screen");
    private JLabel hostLabel = new JLabel("Host");
    private JLabel clickLabel = new JLabel("Click");
    private JLabel extraLabel = new JLabel("Extra");
    private JLabel roomLabel = new JLabel("Room");
    private JLabel omniLabel = new JLabel("Omini Channels:");

    private JComboBox<Integer> dJNumber = new JComboBox();
    private JComboBox<Integer> screenNumber = new JComboBox();
    private JComboBox<Integer> hostNumber = new JComboBox();
    private JComboBox<Integer> clickNumber = new JComboBox();
    private JComboBox<Integer> extraNumber = new JComboBox();
    private JComboBox<Integer> roomNumber = new JComboBox();

    private JCheckBox djOnStage = new JCheckBox("On Stage");
    private JCheckBox screenOnStage = new JCheckBox("On Stage");

    public Others() throws HeadlessException {
        pageNameLabel.setText("Select Others");
        pageNameLabel.setForeground(Color.orange);
//gui elements start
        Container labelContainer = new Container();
        labelContainer.setLayout(new GridLayout(6, 1, 10, 10));
        labelContainer.setBounds(300, 100, 100, 200);
        Container numContainer = new Container();
        numContainer.setLayout(new GridLayout(6, 1, 10, 10));
        numContainer.setBounds(400, 100, 40, 200);
        Container checkBoxContainer = new Container();
        checkBoxContainer.setLayout(new GridLayout(6, 1, 10, 10));
        checkBoxContainer.setBounds(440, 100, 80, 200);
//parent labels
        allChannelsLabel.setForeground(Color.orange);
        allChannelsLabel.setBackground(Color.BLUE);
        allChannelsLabel.setOpaque(true);
        theseChannelsLabel.setForeground(Color.orange);
        theseChannelsLabel.setBackground(Color.BLUE);
        theseChannelsLabel.setOpaque(true);
        theseChannelsLabel.setText("Stage Channels: " + ProjectData.extraStrips.size());
//these labels
        omniLabel.setBounds(650, 45, 120, 25);
        omniLabel.setOpaque(true);
        omniLabel.setBackground(Color.BLUE);
        omniLabel.setForeground(Color.orange);
        omniLabel.setText("Omni Channels: " + ProjectData.omniStrips.size());
        container.add(omniLabel);
        dJLabel.setForeground(Color.orange);
        dJLabel.setOpaque(true);
        dJLabel.setBackground(Color.BLUE);
        screenLabel.setOpaque(true);
        screenLabel.setBackground(Color.BLUE);
        screenLabel.setForeground(Color.orange);
        hostLabel.setOpaque(true);
        hostLabel.setBackground(Color.BLUE);
        hostLabel.setForeground(Color.orange);
        clickLabel.setOpaque(true);
        clickLabel.setBackground(Color.BLUE);
        clickLabel.setForeground(Color.orange);
        roomLabel.setForeground(Color.orange);
        roomLabel.setOpaque(true);
        roomLabel.setBackground(Color.BLUE);
        extraLabel.setForeground(Color.orange);
        extraLabel.setOpaque(true);
        extraLabel.setBackground(Color.BLUE);
        labelContainer.add(dJLabel);
        labelContainer.add(screenLabel);
        labelContainer.add(hostLabel);
        labelContainer.add(clickLabel);
        labelContainer.add(extraLabel);
        labelContainer.add(roomLabel);
//dj
        dJNumber.addItem(0);
        dJNumber.addItem(1);
        dJNumber.addItem(2);
        dJNumber.addItem(3);
        dJNumber.addItem(4);
        dJNumber.addItemListener(this);
        if (ProjectData.omniStrips.contains("Dj L") || ProjectData.extraStrips.contains("Dj L")) {
            dJNumber.setSelectedItem(1);
        } else if ((!ProjectData.omniStrips.contains("Dj3L") && ProjectData.omniStrips.contains("Dj2L")) ||
                (!ProjectData.extraStrips.contains("DJ3L") && ProjectData.extraStrips.contains("DJ2L"))) {
            dJNumber.setSelectedItem(2);
        } else if ((!ProjectData.omniStrips.contains("Dj4L") && ProjectData.omniStrips.contains("Dj3L")) ||
                (!ProjectData.extraStrips.contains("DJ4L") && ProjectData.extraStrips.contains("DJ3L"))) {
            dJNumber.setSelectedItem(3);
        } else if (ProjectData.omniStrips.contains("Dj4L") || ProjectData.extraStrips.contains("DJ4L")) {
            dJNumber.setSelectedItem(4);
        }
        if (ProjectData.extraStrips.contains("DJ L") ||
                ProjectData.extraStrips.contains("DJ2L") ||
                ProjectData.extraStrips.contains("DJ3L") ||
                ProjectData.extraStrips.contains("DJ4L")) {
            djOnStage.setSelected(true);
        }
        djOnStage.addItemListener(this);
//screen
        screenNumber.addItem(0);
        screenNumber.addItem(1);
        screenNumber.addItem(2);
        screenNumber.addItem(3);
        screenNumber.addItem(4);
        screenNumber.addItemListener(this);
        if (ProjectData.omniStrips.contains("ScrL") || ProjectData.extraStrips.contains("SCRL")) {
            screenNumber.setSelectedItem(1);
        } else if ((!ProjectData.omniStrips.contains("Sc3L") && ProjectData.omniStrips.contains("Sc2L")) ||
                (!ProjectData.extraStrips.contains("SC3L") && ProjectData.extraStrips.contains("SC2L"))) {
            screenNumber.setSelectedItem(2);
        } else if ((!ProjectData.omniStrips.contains("Sc4L") && ProjectData.omniStrips.contains("Sc3L")) ||
                (!ProjectData.extraStrips.contains("SC4L") && ProjectData.extraStrips.contains("SC3L"))) {
            screenNumber.setSelectedItem(3);
        } else if (ProjectData.omniStrips.contains("Sc4L") || ProjectData.extraStrips.contains("SC4L")) {
            screenNumber.setSelectedItem(4);
        }
        if (ProjectData.extraStrips.contains("SCRL") ||
                ProjectData.extraStrips.contains("SC2L") ||
                ProjectData.extraStrips.contains("SC3L") ||
                ProjectData.extraStrips.contains("SC4L")){
            screenOnStage.setSelected(true);
        }
        screenOnStage.addItemListener(this);
//host
        hostNumber.addItem(0);
        hostNumber.addItem(1);
        hostNumber.addItem(2);
        hostNumber.addItem(3);
        hostNumber.addItem(4);
        hostNumber.addItem(5);
        hostNumber.addItem(6);
        hostNumber.addItem(7);
        hostNumber.addItem(8);
        hostNumber.addItem(9);
        hostNumber.addItem(10);
        hostNumber.addItemListener(this);
        if (ProjectData.extraStrips.contains("Host")) {
            hostNumber.setSelectedItem(1);
        } else if (!ProjectData.extraStrips.contains("Hst3") && ProjectData.extraStrips.contains("Hst2")) {
            hostNumber.setSelectedItem(2);
        } else if (!ProjectData.extraStrips.contains("Hst4") && ProjectData.extraStrips.contains("Hst3")) {
            hostNumber.setSelectedItem(3);
        } else if (!ProjectData.extraStrips.contains("Hst5") && ProjectData.extraStrips.contains("Hst4")) {
            hostNumber.setSelectedItem(4);
        } else if (!ProjectData.extraStrips.contains("Hst6") && ProjectData.extraStrips.contains("Hst5")) {
            hostNumber.setSelectedItem(5);
        } else if (!ProjectData.extraStrips.contains("Hst7") && ProjectData.extraStrips.contains("Hst6")) {
            hostNumber.setSelectedItem(6);
        } else if (!ProjectData.extraStrips.contains("Hst8") && ProjectData.extraStrips.contains("Hst7")) {
            hostNumber.setSelectedItem(7);
        } else if (!ProjectData.extraStrips.contains("Hst9") && ProjectData.extraStrips.contains("Hst8")) {
            hostNumber.setSelectedItem(8);
        } else if (!ProjectData.extraStrips.contains("Hs10") && ProjectData.extraStrips.contains("Hst9")) {
            hostNumber.setSelectedItem(9);
        } else if (ProjectData.extraStrips.contains("Hs10")) {
            hostNumber.setSelectedItem(10);
        }
//click
        clickNumber.addItem(0);
        clickNumber.addItem(1);
        clickNumber.addItem(2);
        clickNumber.addItemListener(this);
        if (ProjectData.extraStrips.contains("Clik")) {
            clickNumber.setSelectedItem(1);
        } else if (ProjectData.extraStrips.contains("Clk2")) {
            clickNumber.setSelectedItem(2);
        }
//extra
        extraNumber.addItem(0);
        extraNumber.addItem(1);
        extraNumber.addItem(2);
        extraNumber.addItem(3);
        extraNumber.addItem(4);
        extraNumber.addItem(5);
        extraNumber.addItem(6);
        extraNumber.addItem(7);
        extraNumber.addItem(8);
        extraNumber.addItem(9);
        extraNumber.addItem(10);
        extraNumber.addItemListener(this);
        if (ProjectData.extraStrips.contains("Extr")) {
            extraNumber.setSelectedItem(1);
        } else if (!ProjectData.extraStrips.contains("Ext3") && ProjectData.extraStrips.contains("Ext2")) {
            extraNumber.setSelectedItem(2);
        } else if (!ProjectData.extraStrips.contains("Ext4") && ProjectData.extraStrips.contains("Ext3")) {
            extraNumber.setSelectedItem(3);
        } else if (!ProjectData.extraStrips.contains("Ext5") && ProjectData.extraStrips.contains("Ext4")) {
            extraNumber.setSelectedItem(4);
        } else if (!ProjectData.extraStrips.contains("Ext6") && ProjectData.extraStrips.contains("Ext5")) {
            extraNumber.setSelectedItem(5);
        } else if (!ProjectData.extraStrips.contains("Ext7") && ProjectData.extraStrips.contains("Ext6")) {
            extraNumber.setSelectedItem(6);
        } else if (!ProjectData.extraStrips.contains("Ext8") && ProjectData.extraStrips.contains("Ext7")) {
            extraNumber.setSelectedItem(7);
        } else if (!ProjectData.extraStrips.contains("Ext9") && ProjectData.extraStrips.contains("Ext8")) {
            extraNumber.setSelectedItem(8);
        } else if (!ProjectData.extraStrips.contains("Ext10") && ProjectData.extraStrips.contains("Ext9")) {
            extraNumber.setSelectedItem(9);
        } else if (ProjectData.extraStrips.contains("Ex10")) {
            extraNumber.setSelectedItem(10);
        }
//room
        roomNumber.addItem(0);
        roomNumber.addItem(1);
        roomNumber.addItem(2);
        roomNumber.addItem(3);
        roomNumber.addItem(4);
        roomNumber.addItem(5);
        roomNumber.addItem(6);
        roomNumber.addItem(7);
        roomNumber.addItem(8);
        roomNumber.addItem(9);
        roomNumber.addItem(10);
        roomNumber.addItemListener(this);
        if (ProjectData.extraStrips.contains("Room")) {
            roomNumber.setSelectedItem(1);
        } else if (!ProjectData.extraStrips.contains("Roo3") && ProjectData.extraStrips.contains("Roo2")) {
            roomNumber.setSelectedItem(2);
        } else if (!ProjectData.extraStrips.contains("Roo4") && ProjectData.extraStrips.contains("Roo3")) {
            roomNumber.setSelectedItem(3);
        } else if (!ProjectData.extraStrips.contains("Roo5") && ProjectData.extraStrips.contains("Roo4")) {
            roomNumber.setSelectedItem(4);
        } else if (!ProjectData.extraStrips.contains("Roo6") && ProjectData.extraStrips.contains("Roo5")) {
            roomNumber.setSelectedItem(5);
        } else if (!ProjectData.extraStrips.contains("Roo7") && ProjectData.extraStrips.contains("Roo6")) {
            roomNumber.setSelectedItem(6);
        } else if (!ProjectData.extraStrips.contains("Roo8") && ProjectData.extraStrips.contains("Roo7")) {
            roomNumber.setSelectedItem(7);
        } else if (!ProjectData.extraStrips.contains("Roo9") && ProjectData.extraStrips.contains("Roo8")) {
            roomNumber.setSelectedItem(8);
        } else if (!ProjectData.extraStrips.contains("Roo10") && ProjectData.extraStrips.contains("Roo9")) {
            roomNumber.setSelectedItem(9);
        } else if (ProjectData.extraStrips.contains("Roo10")) {
            roomNumber.setSelectedItem(10);
        }


        numContainer.add(dJNumber);
        numContainer.add(screenNumber);
        numContainer.add(hostNumber);
        numContainer.add(clickNumber);
        numContainer.add(extraNumber);
        numContainer.add(roomNumber);

        djOnStage.setBackground(Color.BLUE);
        djOnStage.setForeground(Color.orange);
        screenOnStage.setBackground(Color.BLUE);
        screenOnStage.setForeground(Color.orange);
        checkBoxContainer.add(djOnStage);
        checkBoxContainer.add(screenOnStage);

        container.add(labelContainer);
        container.add(numContainer);
        container.add(checkBoxContainer);

//elements end

//Button apply start
        buttonApply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectData.omniStrips.clear();
                ProjectData.extraStrips.clear();
//dj
                switch ((int)dJNumber.getSelectedItem()) {
                    case 1:
                        if (djOnStage.isSelected()) {
                            ProjectData.extraStrips.add("DJ L");
                            ProjectData.extraStrips.add("DJ R");
                        } else {
                            ProjectData.omniStrips.add("Dj L");
                            ProjectData.omniStrips.add("Dj R");
                        }
                        break;
                    case 2:
                        if (djOnStage.isSelected()) {
                            ProjectData.extraStrips.add("DJ1L");
                            ProjectData.extraStrips.add("DJ1R");
                            ProjectData.extraStrips.add("DJ2L");
                            ProjectData.extraStrips.add("DJ2R");
                        } else {
                            ProjectData.omniStrips.add("Dj1L");
                            ProjectData.omniStrips.add("Dj1R");
                            ProjectData.omniStrips.add("Dj2L");
                            ProjectData.omniStrips.add("Dj2R");
                        }
                        break;
                    case 3:
                        if (djOnStage.isSelected()) {
                            ProjectData.extraStrips.add("DJ1L");
                            ProjectData.extraStrips.add("DJ1R");
                            ProjectData.extraStrips.add("DJ2L");
                            ProjectData.extraStrips.add("DJ2R");
                            ProjectData.extraStrips.add("DJ3L");
                            ProjectData.extraStrips.add("DJ3R");
                        } else {
                            ProjectData.omniStrips.add("Dj1L");
                            ProjectData.omniStrips.add("Dj1R");
                            ProjectData.omniStrips.add("Dj2L");
                            ProjectData.omniStrips.add("Dj2R");
                            ProjectData.omniStrips.add("Dj3L");
                            ProjectData.omniStrips.add("Dj3R");
                        }
                        break;
                    case 4:
                        if (djOnStage.isSelected()) {
                            ProjectData.extraStrips.add("DJ1L");
                            ProjectData.extraStrips.add("DJ1R");
                            ProjectData.extraStrips.add("DJ2L");
                            ProjectData.extraStrips.add("DJ2R");
                            ProjectData.extraStrips.add("DJ3L");
                            ProjectData.extraStrips.add("DJ3R");
                            ProjectData.extraStrips.add("DJ4L");
                            ProjectData.extraStrips.add("DJ4R");
                        } else {
                            ProjectData.omniStrips.add("Dj1L");
                            ProjectData.omniStrips.add("Dj1R");
                            ProjectData.omniStrips.add("Dj2L");
                            ProjectData.omniStrips.add("Dj2R");
                            ProjectData.omniStrips.add("Dj3L");
                            ProjectData.omniStrips.add("Dj3R");
                            ProjectData.omniStrips.add("Dj4L");
                            ProjectData.omniStrips.add("Dj4R");
                        }
                        break;

                }
//screen
                switch ((int)screenNumber.getSelectedItem()) {
                    case 1:
                        if (screenOnStage.isSelected()) {
                            ProjectData.extraStrips.add("SCRL");
                            ProjectData.extraStrips.add("SCRR");
                        } else {
                            ProjectData.omniStrips.add("ScrL");
                            ProjectData.omniStrips.add("ScrR");
                        }
                        break;
                    case 2:
                        if (screenOnStage.isSelected()) {
                            ProjectData.extraStrips.add("SC1L");
                            ProjectData.extraStrips.add("SC1R");
                            ProjectData.extraStrips.add("SC2L");
                            ProjectData.extraStrips.add("SC2R");
                        } else {
                            ProjectData.omniStrips.add("Sc1L");
                            ProjectData.omniStrips.add("Sc1R");
                            ProjectData.omniStrips.add("Sc2L");
                            ProjectData.omniStrips.add("Sc2R");
                        }
                        break;
                    case 3:
                        if (screenOnStage.isSelected()) {
                            ProjectData.extraStrips.add("SC1L");
                            ProjectData.extraStrips.add("SC1R");
                            ProjectData.extraStrips.add("SC2L");
                            ProjectData.extraStrips.add("SC2R");
                            ProjectData.extraStrips.add("SC3L");
                            ProjectData.extraStrips.add("SC3R");
                        } else {
                            ProjectData.omniStrips.add("Sc1L");
                            ProjectData.omniStrips.add("Sc1R");
                            ProjectData.omniStrips.add("Sc2L");
                            ProjectData.omniStrips.add("Sc2R");
                            ProjectData.omniStrips.add("Sc3L");
                            ProjectData.omniStrips.add("Sc3R");
                        }
                        break;
                    case 4:
                        if (screenOnStage.isSelected()) {
                            ProjectData.extraStrips.add("SC1L");
                            ProjectData.extraStrips.add("SC1R");
                            ProjectData.extraStrips.add("SC2L");
                            ProjectData.extraStrips.add("SC2R");
                            ProjectData.extraStrips.add("SC3L");
                            ProjectData.extraStrips.add("SC3R");
                            ProjectData.extraStrips.add("SC4L");
                            ProjectData.extraStrips.add("SC4R");
                        } else {
                            ProjectData.omniStrips.add("Sc1L");
                            ProjectData.omniStrips.add("Sc1R");
                            ProjectData.omniStrips.add("Sc2L");
                            ProjectData.omniStrips.add("Sc2R");
                            ProjectData.omniStrips.add("Sc3L");
                            ProjectData.omniStrips.add("Sc3R");
                            ProjectData.omniStrips.add("Sc4L");
                            ProjectData.omniStrips.add("Sc4R");
                        }
                        break;
                }
//host
                switch ((int)hostNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.extraStrips.add("Host");
                        break;
                    case 2:
                        ProjectData.extraStrips.add("Hst1");
                        ProjectData.extraStrips.add("Hst2");
                        break;
                    case 3:
                        ProjectData.extraStrips.add("Hst1");
                        ProjectData.extraStrips.add("Hst2");
                        ProjectData.extraStrips.add("Hst3");
                        break;
                    case 4:
                        ProjectData.extraStrips.add("Hst1");
                        ProjectData.extraStrips.add("Hst2");
                        ProjectData.extraStrips.add("Hst3");
                        ProjectData.extraStrips.add("Hst4");
                        break;
                    case 5:
                        ProjectData.extraStrips.add("Hst1");
                        ProjectData.extraStrips.add("Hst2");
                        ProjectData.extraStrips.add("Hst3");
                        ProjectData.extraStrips.add("Hst4");
                        ProjectData.extraStrips.add("Hst5");
                        break;
                    case 6:
                        ProjectData.extraStrips.add("Hst1");
                        ProjectData.extraStrips.add("Hst2");
                        ProjectData.extraStrips.add("Hst3");
                        ProjectData.extraStrips.add("Hst4");
                        ProjectData.extraStrips.add("Hst5");
                        ProjectData.extraStrips.add("Hst6");
                        break;
                    case 7:
                        ProjectData.extraStrips.add("Hst1");
                        ProjectData.extraStrips.add("Hst2");
                        ProjectData.extraStrips.add("Hst3");
                        ProjectData.extraStrips.add("Hst4");
                        ProjectData.extraStrips.add("Hst5");
                        ProjectData.extraStrips.add("Hst6");
                        ProjectData.extraStrips.add("Hst7");
                        break;
                    case 8:
                        ProjectData.extraStrips.add("Hst1");
                        ProjectData.extraStrips.add("Hst2");
                        ProjectData.extraStrips.add("Hst3");
                        ProjectData.extraStrips.add("Hst4");
                        ProjectData.extraStrips.add("Hst5");
                        ProjectData.extraStrips.add("Hst6");
                        ProjectData.extraStrips.add("Hst7");
                        ProjectData.extraStrips.add("Hst8");
                        break;

                    case 9:
                        ProjectData.extraStrips.add("Hst1");
                        ProjectData.extraStrips.add("Hst2");
                        ProjectData.extraStrips.add("Hst3");
                        ProjectData.extraStrips.add("Hst4");
                        ProjectData.extraStrips.add("Hst5");
                        ProjectData.extraStrips.add("Hst6");
                        ProjectData.extraStrips.add("Hst7");
                        ProjectData.extraStrips.add("Hst8");
                        ProjectData.extraStrips.add("Hst9");
                        break;
                    case 10:
                        ProjectData.extraStrips.add("Hst1");
                        ProjectData.extraStrips.add("Hst2");
                        ProjectData.extraStrips.add("Hst3");
                        ProjectData.extraStrips.add("Hst4");
                        ProjectData.extraStrips.add("Hst5");
                        ProjectData.extraStrips.add("Hst6");
                        ProjectData.extraStrips.add("Hst7");
                        ProjectData.extraStrips.add("Hst8");
                        ProjectData.extraStrips.add("Hst9");
                        ProjectData.extraStrips.add("Hs10");
                        break;
                }
//click
                switch ((int)clickNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.extraStrips.add("Clik");
                        break;
                    case 2:
                        ProjectData.extraStrips.add("Clk1");
                        ProjectData.extraStrips.add("Clk2");
                        break;
                }
//extra
                switch ((int) extraNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.extraStrips.add("Extr");
                        break;
                    case 2:
                        ProjectData.extraStrips.add("Ext1");
                        ProjectData.extraStrips.add("Ext2");
                        break;
                    case 3:
                        ProjectData.extraStrips.add("Ext1");
                        ProjectData.extraStrips.add("Ext2");
                        ProjectData.extraStrips.add("Ext3");
                        break;
                    case 4:
                        ProjectData.extraStrips.add("Ext1");
                        ProjectData.extraStrips.add("Ext2");
                        ProjectData.extraStrips.add("Ext3");
                        ProjectData.extraStrips.add("Ext4");
                        break;
                    case 5:
                        ProjectData.extraStrips.add("Ext1");
                        ProjectData.extraStrips.add("Ext2");
                        ProjectData.extraStrips.add("Ext3");
                        ProjectData.extraStrips.add("Ext4");
                        ProjectData.extraStrips.add("Ext5");
                        break;
                    case 6:
                        ProjectData.extraStrips.add("Ext1");
                        ProjectData.extraStrips.add("Ext2");
                        ProjectData.extraStrips.add("Ext3");
                        ProjectData.extraStrips.add("Ext4");
                        ProjectData.extraStrips.add("Ext5");
                        ProjectData.extraStrips.add("Ext6");
                        break;
                    case 7:
                        ProjectData.extraStrips.add("Ext1");
                        ProjectData.extraStrips.add("Ext2");
                        ProjectData.extraStrips.add("Ext3");
                        ProjectData.extraStrips.add("Ext4");
                        ProjectData.extraStrips.add("Ext5");
                        ProjectData.extraStrips.add("Ext6");
                        ProjectData.extraStrips.add("Ext7");
                        break;
                    case 8:
                        ProjectData.extraStrips.add("Ext1");
                        ProjectData.extraStrips.add("Ext2");
                        ProjectData.extraStrips.add("Ext3");
                        ProjectData.extraStrips.add("Ext4");
                        ProjectData.extraStrips.add("Ext5");
                        ProjectData.extraStrips.add("Ext6");
                        ProjectData.extraStrips.add("Ext7");
                        ProjectData.extraStrips.add("Ext8");
                        break;

                    case 9:
                        ProjectData.extraStrips.add("Ext1");
                        ProjectData.extraStrips.add("Ext2");
                        ProjectData.extraStrips.add("Ext3");
                        ProjectData.extraStrips.add("Ext4");
                        ProjectData.extraStrips.add("Ext5");
                        ProjectData.extraStrips.add("Ext6");
                        ProjectData.extraStrips.add("Ext7");
                        ProjectData.extraStrips.add("Ext8");
                        ProjectData.extraStrips.add("Ext9");
                        break;
                    case 10:
                        ProjectData.extraStrips.add("Ext1");
                        ProjectData.extraStrips.add("Ext2");
                        ProjectData.extraStrips.add("Ext3");
                        ProjectData.extraStrips.add("Ext4");
                        ProjectData.extraStrips.add("Ext5");
                        ProjectData.extraStrips.add("Ext6");
                        ProjectData.extraStrips.add("Ext7");
                        ProjectData.extraStrips.add("Ext8");
                        ProjectData.extraStrips.add("Ext9");
                        ProjectData.extraStrips.add("Ex10");
                        break;
                }
//room
                switch ((int)roomNumber.getSelectedItem()) {
                    case 1:
                        ProjectData.extraStrips.add("Room");
                        break;
                    case 2:
                        ProjectData.extraStrips.add("Roo1");
                        ProjectData.extraStrips.add("Roo2");
                        break;
                    case 3:
                        ProjectData.extraStrips.add("Roo1");
                        ProjectData.extraStrips.add("Roo2");
                        ProjectData.extraStrips.add("Roo3");
                        break;
                    case 4:
                        ProjectData.extraStrips.add("Roo1");
                        ProjectData.extraStrips.add("Roo2");
                        ProjectData.extraStrips.add("Roo3");
                        ProjectData.extraStrips.add("Roo4");
                        break;
                    case 5:
                        ProjectData.extraStrips.add("Roo1");
                        ProjectData.extraStrips.add("Roo2");
                        ProjectData.extraStrips.add("Roo3");
                        ProjectData.extraStrips.add("Roo4");
                        ProjectData.extraStrips.add("Roo5");
                        break;
                    case 6:
                        ProjectData.extraStrips.add("Roo1");
                        ProjectData.extraStrips.add("Roo2");
                        ProjectData.extraStrips.add("Roo3");
                        ProjectData.extraStrips.add("Roo4");
                        ProjectData.extraStrips.add("Roo5");
                        ProjectData.extraStrips.add("Roo6");
                        break;
                    case 7:
                        ProjectData.extraStrips.add("Roo1");
                        ProjectData.extraStrips.add("Roo2");
                        ProjectData.extraStrips.add("Roo3");
                        ProjectData.extraStrips.add("Roo4");
                        ProjectData.extraStrips.add("Roo5");
                        ProjectData.extraStrips.add("Roo6");
                        ProjectData.extraStrips.add("Roo7");
                        break;
                    case 8:
                        ProjectData.extraStrips.add("Roo1");
                        ProjectData.extraStrips.add("Roo2");
                        ProjectData.extraStrips.add("Roo3");
                        ProjectData.extraStrips.add("Roo4");
                        ProjectData.extraStrips.add("Roo5");
                        ProjectData.extraStrips.add("Roo6");
                        ProjectData.extraStrips.add("Roo7");
                        ProjectData.extraStrips.add("Roo8");
                        break;
                    case 9:
                        ProjectData.extraStrips.add("Roo1");
                        ProjectData.extraStrips.add("Roo2");
                        ProjectData.extraStrips.add("Roo3");
                        ProjectData.extraStrips.add("Roo4");
                        ProjectData.extraStrips.add("Roo5");
                        ProjectData.extraStrips.add("Roo6");
                        ProjectData.extraStrips.add("Roo7");
                        ProjectData.extraStrips.add("Roo8");
                        ProjectData.extraStrips.add("Roo9");
                        break;
                    case 10:
                        ProjectData.extraStrips.add("Roo1");
                        ProjectData.extraStrips.add("Roo2");
                        ProjectData.extraStrips.add("Roo3");
                        ProjectData.extraStrips.add("Roo4");
                        ProjectData.extraStrips.add("Roo5");
                        ProjectData.extraStrips.add("Roo6");
                        ProjectData.extraStrips.add("Roo7");
                        ProjectData.extraStrips.add("Roo8");
                        ProjectData.extraStrips.add("Roo9");
                        ProjectData.extraStrips.add("Ro10");
                        break;
                }
                theseChannelsLabel.setText("Stage Channels: " + ProjectData.extraStrips.size());
                omniLabel.setText("Omni Channels: " + ProjectData.omniStrips.size());
                DefineInstruments.buttonOthers.setText("Others" + (ProjectData.extraStrips.size() + ProjectData.omniStrips.size()));
            }
        });

//Button apply end
//button no one
        buttonNoOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dJNumber.setSelectedItem(0);
                djOnStage.setSelected(false);
                screenNumber.setSelectedItem(0);
                screenOnStage.setSelected(false);
                hostNumber.setSelectedItem(0);
                clickNumber.setSelectedItem(0);
                extraNumber.setSelectedItem(0);
                roomNumber.setSelectedItem(0);
            }
        });
    }
}