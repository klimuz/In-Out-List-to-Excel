package soundEngineer.consolesGUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class InputStrip extends JPanel implements ItemListener {
    private JButton editButton = new JButton("E");
    private JLabel number = new JLabel("");

    public JRadioButton from = new JRadioButton("F");
    public JRadioButton to = new JRadioButton("T");

    private String stripName;
    private int id;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getStripName() {return stripName;}
    public void setStripName(String stripName) {this.stripName = stripName;}
    public boolean fromIsSelected = false;
    public boolean toIsSelected = false;

    public InputStrip (int id, String name){
        this.id = id;
        this.stripName = name;
        this.setOpaque(true);
        this.setBackground(Color.gray);
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
                    FOHConsolesStampScroll.stripsIdFrom.add(id);
                    FOHConsolesStampScroll.stripsIdFrom.sort(null);
                    FOHConsolesStampScroll.moveWhatText.setText(String.valueOf(FOHConsolesStampScroll.stripsIdFrom));
                }else {
                    FOHConsolesStampScroll.stripsIdFrom.remove((Integer) id);
                    FOHConsolesStampScroll.moveWhatText.setText(String.valueOf(FOHConsolesStampScroll.stripsIdFrom));
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
                    FOHConsolesStampScroll.moveToText.setText("" + id);
                    from.setSelected(false);
                    FOHConsolesStampScroll.stripsIdFrom.remove((Integer) id);
                    FOHConsolesStampScroll.moveWhatText.setText(String.valueOf(FOHConsolesStampScroll.stripsIdFrom));

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
}
