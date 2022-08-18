package soundEngineer.step1;

import soundEngineer.server.ProjectData;
import soundEngineer.server.ResourceLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SetProjectName extends JFrame {

    private JButton buttonCancel = new JButton ("Cancel");
    private JButton buttonNext = new JButton("Next");
    private JTextField textField = new JTextField();
    private JLabel typeName = new JLabel("Type Show Name:");
    private void terminateThisWindow(){
        this.dispose();
    }

    public SetProjectName() throws HeadlessException {
        super("In-Out List to Exel");
        Font font = new Font("",Font.BOLD,15);

        this.setIconImage(ResourceLoader.getImage("logo.png"));
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setBounds(dimension.width/2-350, dimension.height/2-250, 854, 480);
        this.setResizable(false);

//background image start
        setContentPane(new JPanel(new BorderLayout()) {
            @Override public void paintComponent(Graphics g) {
                g.drawImage(ResourceLoader.getImage("lineArray.jpg"), 0, 0, getWidth(),getHeight(), this);
            }
        });
//background image end

        Container container = this.getContentPane();
        container.setLayout(null);

        typeName.setFont(font);
        typeName.setBounds(350,120,150,30);
        container.add(typeName);
        textField.setBounds(350,180,150,30);
        textField.setText("No Name");
        container.add(textField);

        //Button next start
        buttonNext.setBounds(540, 360, 100, 40);
        buttonNext.setBorderPainted(true);
        buttonNext.setBackground(Color.orange);
        container.add(buttonNext);
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectData.projectName = textField.getText();
                ProjectData.populateChannels();
                ProjectData.createObjects();
                ProjectData.defineInstruments.setVisible(true);
                terminateThisWindow();
            }
        });
        //Button next end

        //Button cancel start
        buttonCancel.setBounds(200, 360, 100, 40);
        buttonCancel.setBorderPainted(true);
        buttonCancel.setBackground(Color.orange);
        container.add(buttonCancel);
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null,
                        "Are you really want to quit?", "Confirm", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (option == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
//Button cancel end

        //frame closer start
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                int option = JOptionPane.showConfirmDialog(null,
                        "Are you really want to quit?", "Confirm", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (option == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }else if (option == JOptionPane.NO_OPTION){

                }
            }
        });
        //frame closer end

    }
}
