package soundEngineer.step2;

import soundEngineer.server.NamesAndPickup;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChannelStrip extends JPanel implements ItemListener {
    private JButton editButton = new JButton("E");
    private JLabel number = new JLabel("");

    public JRadioButton from = new JRadioButton("F");
    public JRadioButton to = new JRadioButton("T");

    private int idNumber;
    private String stripName;
    private String stripPickup;
    private String stripNote;
    public boolean toIsSelected = false;

    public ChannelStrip(int id, String name, String pickup, String note){
        idNumber = id;
        stripName = name;
        stripPickup = pickup;
        stripNote = note;
        this.setOpaque(true);
        setColor();
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(48, 156));
        Border border = BorderFactory.createEtchedBorder();
        this.setBorder(border);

        editButton.setBackground(Color.red);
        editButton.setFocusPainted(false);
        editButton.setPreferredSize(new Dimension(40,40));
        editButton.setBorder(BorderFactory.createBevelBorder(0));
        editButton.setToolTipText("<html><p width=\"25px\">" + stripName + "\n " + stripPickup + "\n " + stripNote + "</p></html>");
        this.add(editButton, new GridBagConstraints(0,0,1,1,1,1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2,2,2,2),0,0));
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            StripEditorGUI stripEditorGUI = new StripEditorGUI(idNumber,stripName,stripPickup,stripNote);
            stripEditorGUI.setVisible(true);
            }
        });

        RotateLabel label = new RotateLabel(stripName);
        this.add(label, new GridBagConstraints(0,1,1,2,1,1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(0,0,0,0),0,0));

        number.setText(""+idNumber);
        this.add(number, new GridBagConstraints(0,3,1,1,0,0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2,17,2,2),0,0));

        from.setOpaque(false);
        from.setFocusPainted(false);
        from.setToolTipText("From");
        from.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (from.isSelected() == true){
                    NormaliseListsGui.idToCopyList.add((Integer) idNumber);
                    NormaliseListsGui.idToCopyList.sort(null);
                    NormaliseListsGui.setMoveWhatText(String.valueOf(NormaliseListsGui.idToCopyList));
                }else {
                    NormaliseListsGui.idToCopyList.remove((Integer) idNumber);
                    NormaliseListsGui.setMoveWhatText(String.valueOf(NormaliseListsGui.idToCopyList));
                }
            }
        });
        this.add(from, new GridBagConstraints(0,4,1,1,1,0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2,10,2,2),0,0));

        to.setOpaque(false);
        to.setFocusPainted(false);
        to.setToolTipText("To");
        to.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (to.isSelected() == true){
                    NormaliseListsGui.setMoveToText("" + idNumber);
                    from.setSelected(false);
                    NormaliseListsGui.idToCopyList.remove((Integer) idNumber);
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
    public void setId(int id){
        idNumber = id;
        number.setText("" + idNumber);
    }
    public void setColor(){
        if (NamesAndPickup.isOdd(stripName) && idNumber%2 == 0) {
            this.setBackground(Color.red);
        }else {
            this.setBackground(Color.GRAY);
        }
    }
    //getters
    public String getStripName(){
        return stripName;
    }
    public String getStripPickup(){
        return stripPickup;
    }
    public String getStripNote(){
        return stripNote;
    }
}
