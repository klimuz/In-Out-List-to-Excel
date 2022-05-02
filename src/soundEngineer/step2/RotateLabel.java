package soundEngineer.step2;

import javax.swing.*;
import java.awt.*;

public class RotateLabel extends JPanel {
    private String name = "";

    private JLabel nameLabel;


    public RotateLabel(String name) {
        this.name = name;
        this.setOpaque(false);
        nameLabel = new JLabel(name);

        nameLabel.setPreferredSize(new Dimension(40, 30));

        nameLabel.setBackground(Color.green);
        nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        nameLabel.setVerticalAlignment(SwingConstants.CENTER);
        this.add(nameLabel);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int w2 = getWidth() / 2;
        int h2 = getHeight() / 2;
        g2d.rotate(-Math.PI / 2, w2, h2);
        super.paintComponent(g);
    }

}
