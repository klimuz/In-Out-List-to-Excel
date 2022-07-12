package soundEngineer.step2;

import soundEngineer.server.NamesAndPickup;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class channelStrip extends JPanel implements ItemListener {
    private JButton editButton = new JButton("E");
    private JLabel number = new JLabel("");

    public JRadioButton from = new JRadioButton("F");
    public JRadioButton to = new JRadioButton("T");

    private String stripName;
    private String stripPickup;
    private String stripNote;
    public boolean toIsSelected = false;

    public channelStrip(int id, String name, String pickup, String note){
        stripName = name;
        stripPickup = pickup;
        stripNote = note;
        this.setOpaque(true);
        this.setBackground(Color.gray);
        if (NamesAndPickup.isOdd(name) && NormaliseListsGui.inputNamesList.indexOf(name)%2 == 0) {// && ListsStamp.channelNamesMemory.indexOf(name)%2 == 0
            this.setBackground(Color.red);
        }
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(48, 156));
        Border border = BorderFactory.createEtchedBorder();
        this.setBorder(border);

        editButton.setBackground(Color.red);
        editButton.setFocusPainted(false);
        editButton.setPreferredSize(new Dimension(40,40));
        editButton.setBorder(BorderFactory.createBevelBorder(0));
        this.add(editButton, new GridBagConstraints(0,0,1,1,1,1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2,2,2,2),0,0));
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            StripEditorGUI stripEditorGUI = new StripEditorGUI(id,stripName,stripPickup,stripNote);
            stripEditorGUI.setVisible(true);
            }
        });

        RotateLabel label = new RotateLabel(stripName);
        this.add(label, new GridBagConstraints(0,1,1,2,1,1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(0,0,0,0),0,0));

        number.setText(""+id);
        this.add(number, new GridBagConstraints(0,3,1,1,0,0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2,17,2,2),0,0));

        from.setOpaque(false);
        from.setFocusPainted(false);
        from.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (from.isSelected() == true){
                    NormaliseListsGui.idToCopyList.add(id);
                    NormaliseListsGui.idToCopyList.sort(null);
                    NormaliseListsGui.setMoveWhatText(String.valueOf(NormaliseListsGui.idToCopyList));
                }else {
                    NormaliseListsGui.idToCopyList.remove((Integer) id);
                    NormaliseListsGui.setMoveWhatText(String.valueOf(NormaliseListsGui.idToCopyList));
                }
            }
        });
        this.add(from, new GridBagConstraints(0,4,1,1,1,0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2,10,2,2),0,0));

        to.setOpaque(false);
        to.setFocusPainted(false);
        to.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (to.isSelected() == true){
                    NormaliseListsGui.setMoveToText("" + id);
                    from.setSelected(false);
                    NormaliseListsGui.idToCopyList.remove((Integer) id);
                    NormaliseListsGui.setMoveWhatText(String.valueOf(NormaliseListsGui.idToCopyList));

                }
            }
        });
        this.add(to, new GridBagConstraints(0,5,1,1,1,0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2,10,2,2),0,0));
        this.revalidate();
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
       if (to.isSelected() == true){
            toIsSelected = true;
       }
    }
    private void editStrip(){

    }
}
