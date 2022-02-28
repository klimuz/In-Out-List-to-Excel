package soundEngineer.consolesGUI;

import soundEngineer.server.ProjectData;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;

public class FOHConsolesStamp extends JFrame implements ItemListener {
//menu
    protected JMenu m1 = new JMenu("File");
    protected JMenu m2 = new JMenu("Edit");
    protected JMenu m3 = new JMenu("Help");
//main container
    protected Container mainContainer;
//buttons
    protected JButton buttonBack = new JButton("Back");
    protected JButton buttonNext = new JButton("Next");
    protected JButton buttonPrint = new JButton("Print");
    protected JButton buttonMove = new JButton("Move");
//common Labels
    protected JLabel consoleNameLabel = new JLabel("PM5D");
    protected JLabel allChannelsLabel = new JLabel("All Channels:");
    protected JLabel fromLabel = new JLabel("From");
    protected JLabel toLabel = new JLabel("To");
    protected JLabel fromToLabel = new JLabel("From: " + "to:");
//fonts
    protected Font headerFont = new Font("",Font.BOLD,20);
    protected Font labelsFont = new Font("",Font.BOLD,20);
    protected Font channelFont = new Font("",Font.ITALIC,15);
//close window
    private void terminateThisWindow(){
        this.dispose();
    }
//constructor start
    public FOHConsolesStamp(String imageFilePath) throws HeadlessException{
        super("In-Out List to Exel : " + ProjectData.projectName);
        this.setIconImage(new ImageIcon("img/logo.png").getImage());
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setBounds(dimension.width/2-350, dimension.height/2-250, 854, 480);
        this.setResizable(false);
//menu start
//menu file
        m1.add(new JMenuItem("Open", 'O'));
        m1.add(new JMenuItem("Save", 'S'));
        m1.add(new JMenuItem("Recent"));
        m1.addSeparator();
        JMenuItem exit =  m1.add(new JMenuItem("Exit"));
        exit.addActionListener(new ActionListener() {
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
        exit.setAccelerator(KeyStroke.getKeyStroke("ctrl E"));
//menu edit
        m2.add(new JMenuItem("Undo"));
        m2.add(new JMenuItem("Redo"));
//menu help
        m3.add(new JMenuItem("About"));
        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.add(m1);
        jMenuBar.add(m2);
        jMenuBar.add(m3);
        jMenuBar.setBackground(Color.green);
        this.setJMenuBar(jMenuBar);
        this.revalidate();
//menu end
//background image start
        try {
            Image backgroundImage = ImageIO.read(new File(imageFilePath));
            setContentPane(new JPanel(new BorderLayout()) {
                @Override public void paintComponent(Graphics g) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(),getHeight(), this);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//background image end
//buttons&labels start
//container
        mainContainer = this.getContentPane();
        mainContainer.setLayout(null);
//labels

    }
//constructor end
//class input strip
    private class InputStrip{
        private JButton editButton = new JButton("E");
        private JLabel nameLabel = new JLabel("");
}
//if settings changed
    @Override
    public void itemStateChanged(ItemEvent e) {

    }
}
