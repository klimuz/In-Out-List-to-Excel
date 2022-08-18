package soundEngineer.step1;

import soundEngineer.server.ProjectData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorldWideGui extends GUIStamp{
    public final String IMAGE_FILE_NAME = "blueBgnd.jpg";
    private JLabel banjoLabel = new JLabel("Banjo");
    private JLabel bouzoukiLabel = new JLabel("Bouzouki");

    private JComboBox<Integer> banjoNumber = new JComboBox<>();
    private JComboBox<Integer> bouzoukiNumber = new JComboBox<>();

    public WorldWideGui(){
        pageNameLabel.setText("WorldWide");

        Container labelsContainer = new Container();
        Container numbersContainer = new Container();
        labelsContainer.setLayout(new GridLayout(7,1, 5, 5));
        numbersContainer.setLayout(new GridLayout(7,1, 5, 5));
        labelsContainer.setBounds(300, 100, 70, 200);
        numbersContainer.setBounds(370, 100, 40, 200);

        labelsContainer.add(banjoLabel);
        labelsContainer.add(bouzoukiLabel);

        numbersContainer.add(banjoNumber);
        numbersContainer.add(bouzoukiNumber);

        container.add(labelsContainer);
        container.add(numbersContainer);

        //banjo logic
        banjoNumber.addItem(0);
        banjoNumber.addItem(1);
        banjoNumber.addItem(2);
        banjoNumber.addItem(3);
        banjoNumber.addItem(4);
        if (ProjectData.worldWideStrips.contains("Banj")){
            banjoNumber.setSelectedItem(1);
        }else if (ProjectData.worldWideStrips.contains("Ban2") && !ProjectData.worldWideStrips.contains("Ban3")){
            banjoNumber.setSelectedItem(2);
        }else if (ProjectData.worldWideStrips.contains("Ban3") && !ProjectData.worldWideStrips.contains("Ban4")){
            banjoNumber.setSelectedItem(3);
        }else if (ProjectData.worldWideStrips.contains("Ban4")){
            banjoNumber.setSelectedItem(4);
        }
        banjoNumber.addItemListener(this);

        //bouzouki logic
        bouzoukiNumber.addItem(0);
        bouzoukiNumber.addItem(1);
        bouzoukiNumber.addItem(2);
        bouzoukiNumber.addItem(3);
        bouzoukiNumber.addItem(4);
        if (ProjectData.worldWideStrips.contains("Bouz")){
            bouzoukiNumber.setSelectedItem(1);
        }else if (ProjectData.worldWideStrips.contains("Buz2") && !ProjectData.worldWideStrips.contains("Buz3")){
            bouzoukiNumber.setSelectedItem(2);
        }else if (ProjectData.worldWideStrips.contains("Buz3") && !ProjectData.worldWideStrips.contains("Buz4")){
            bouzoukiNumber.setSelectedItem(3);
        }else if (ProjectData.worldWideStrips.contains("Buz4")){
            bouzoukiNumber.setSelectedItem(4);
        }
        bouzoukiNumber.addItemListener(this);

        //button apply
        buttonApply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectData.worldWideStrips.clear();
                //banjo
                switch ((int)banjoNumber.getSelectedItem()){
                    case 1:
                        ProjectData.worldWideStrips.add("Banj");
                        break;
                    case 2:
                        ProjectData.worldWideStrips.add("Ban1");
                        ProjectData.worldWideStrips.add("Ban2");
                        break;
                    case 3:
                        ProjectData.worldWideStrips.add("Ban1");
                        ProjectData.worldWideStrips.add("Ban2");
                        ProjectData.worldWideStrips.add("Ban3");
                        break;
                    case 4:
                        ProjectData.worldWideStrips.add("Ban1");
                        ProjectData.worldWideStrips.add("Ban2");
                        ProjectData.worldWideStrips.add("Ban3");
                        ProjectData.worldWideStrips.add("Ban4");
                        break;
                }
                //bouzouki
                switch ((int)bouzoukiNumber.getSelectedItem()){
                    case 1:
                        ProjectData.worldWideStrips.add("Bouz");
                        break;
                    case 2:
                        ProjectData.worldWideStrips.add("Buz1");
                        ProjectData.worldWideStrips.add("Buz2");
                        break;
                    case 3:
                        ProjectData.worldWideStrips.add("Buz1");
                        ProjectData.worldWideStrips.add("Buz2");
                        ProjectData.worldWideStrips.add("Buz3");
                        break;
                    case 4:
                        ProjectData.worldWideStrips.add("Buz1");
                        ProjectData.worldWideStrips.add("Buz2");
                        ProjectData.worldWideStrips.add("Buz3");
                        ProjectData.worldWideStrips.add("Buz4");
                        break;
                }
                theseChannelsLabel.setText("These Channels: " + ProjectData.worldWideStrips.size());
                DefineInstruments.buttonWorld.setText("WorldWide" + ProjectData.worldWideStrips.size());
            }
        });
buttonNoOne.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        banjoNumber.setSelectedItem(0);
        bouzoukiNumber.setSelectedItem(0);
    }
});
    }

}
