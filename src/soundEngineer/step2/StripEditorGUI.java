package soundEngineer.step2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StripEditorGUI extends JFrame {
    private int id;
    private JLabel idLabel = new JLabel("ID:");
    private JLabel nameLabel = new JLabel("Name:");
    private JLabel pickupLabel = new JLabel("Pickup:");
    private JLabel noteLabel = new JLabel("Note:");

    private JTextField nameText = new JTextField(10);
    private JTextField pickupText = new JTextField(10);
    private JTextField noteText = new JTextField(10);

    private JButton cancelButton = new JButton("Cancel");
    private JButton okButton = new JButton("OK");
    private Container mainContainer;
    private Container secondContainer;
    private Container thirdContainer;
    private Container fourthContainer;
    private void terminateThisWindow(){
        this.dispose();
    }
    public StripEditorGUI(int id, String name, String pickup, String note){
        super(name);
        this.id = id;
        this.setIconImage(new ImageIcon("img/logo.png").getImage());
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setBounds(dimension.width/2-280, dimension.height/2-20, 200, 200);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        //X-button
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                terminateThisWindow();
            }
        });
        idLabel.setText("ID :" + id);
        //set text fields
        nameText.setText(NormaliseListsGui.stripList.get(id).getStripName());
        pickupText.setText(NormaliseListsGui.stripList.get(id).getStripPickup());
        noteText.setText(NormaliseListsGui.stripList.get(id).getStripNote());

        //container
        mainContainer = new Container();
        mainContainer = this.getContentPane();
        mainContainer.setLayout(new GridLayout(2, 1));
        mainContainer.setBackground(Color.GRAY);
        secondContainer = new Container();
        secondContainer.setLayout(new GridLayout(1,1));
        thirdContainer = new Container();
        thirdContainer.setLayout(new GridLayout(4,2,5,5));
        fourthContainer = new Container();
        fourthContainer.setLayout(new GridLayout(1,2));
        secondContainer.add(idLabel);
        thirdContainer.add(nameLabel);
        thirdContainer.add(nameText);
        thirdContainer.add(pickupLabel);
        thirdContainer.add(pickupText);
        thirdContainer.add(noteLabel);
        thirdContainer.add(noteText);
        thirdContainer.add(cancelButton);
        thirdContainer.add(okButton);

        mainContainer.add(secondContainer);
        mainContainer.add(thirdContainer);
        cancelButton.setBackground(Color.GREEN);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                terminateThisWindow();
            }
        });
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //NormaliseListsGui.stripsToCopyList.add(NormaliseListsGui.stripList.get(id));
                NormaliseListsGui.stripList.remove(NormaliseListsGui.stripList.get(id));
                NormaliseListsGui.stripList.add(id, new ChannelStrip(id, nameText.getText(), pickupText.getText(),
                        noteText.getText()));
                NormaliseListsGui.recreateMatrix();

                terminateThisWindow();
            }
        });
    }
}
