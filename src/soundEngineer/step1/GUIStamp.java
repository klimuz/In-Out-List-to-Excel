package soundEngineer.step1;

import soundEngineer.server.ProjectData;
import soundEngineer.server.ResourceLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIStamp extends JFrame implements ItemListener{
    public Image i = null;

    protected JMenu m1 = new JMenu("File");
    protected JMenu m2 = new JMenu("Help");
    protected JButton buttonBack = new JButton("Back");
    protected JButton buttonNext = new JButton("Next");
    protected JButton buttonApply = new JButton("Apply");
    protected JButton buttonNoOne = new JButton("No One");
    protected JLabel allChannelsLabel = new JLabel("All Channels:");
    protected JLabel theseChannelsLabel = new JLabel("These Channels:");
    protected JLabel pageNameLabel = new JLabel("");
    protected Container container;
    protected Font headerFont = new Font("",Font.BOLD,20);
    private void terminateThisWindow(){
        this.dispose();
    }
//constructor
    public GUIStamp() throws HeadlessException {
        super("In-Out List to Exel : " + ProjectData.projectName);
        this.setIconImage(ResourceLoader.getImage("logo.png"));
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setBounds(dimension.width/2-350, dimension.height/2-250, 854, 480);
        this.setResizable(false);
//X-button
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure?","Really quit?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });
//menu start
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

        m2.add(new JMenuItem("About"));
        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.add(m1);
        jMenuBar.add(m2);
        jMenuBar.setBackground(Color.green);
        this.setJMenuBar(jMenuBar);
        this.revalidate();
//menu end
//background image start
            setContentPane(new JPanel(new BorderLayout()) {
                @Override public void paintComponent(Graphics g) {
                    g.drawImage(i, 0, 0, getWidth(),getHeight(), this);
                }
            });
//background image end
//buttons&labels start
//container
        container = this.getContentPane();
        container.setLayout(null);
//labels
        allChannelsLabel.setBounds(650, 5, 120, 25);
        allChannelsLabel.setText("All Channels: " + ProjectData.commonChannels());
        theseChannelsLabel.setBounds(650, 25, 120, 25);
        pageNameLabel.setFont(headerFont);
        pageNameLabel.setBounds(330, 5, 300, 50);
        container.add(allChannelsLabel);
        container.add(theseChannelsLabel);
        container.add(pageNameLabel);
// button apply
        buttonApply.setBounds(725, 240, 70, 60);
        buttonApply.setBorderPainted(true);
        buttonApply.setBackground(Color.green);
        container.add(buttonApply);
        buttonApply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allChannelsLabel.setText("All Channels: " + ProjectData.commonChannels());
                buttonNext.setEnabled(true);
            }
        });
//button no one
        buttonNoOne.setBounds(370, 360, 100, 40);
        buttonNoOne.setBorderPainted(true);
        buttonNoOne.setBackground(Color.red);
        container.add(buttonNoOne);

//Button next start
        buttonNext.setBounds(640, 360, 100, 40);
        buttonNext.setBorderPainted(true);
        buttonNext.setBackground(Color.orange);
        container.add(buttonNext);
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefineInstruments.numChannels.setText("All Channels:" + ProjectData.commonChannels());
                DefineInstruments.omniChannels.setText("Omni Channels:" + ProjectData.omniStrips.size());
                terminateThisWindow();
            }

        });
//Button next end
//Button back start
        buttonBack.setBounds(100, 360, 100, 40);
        buttonBack.setBorderPainted(true);
        buttonBack.setBackground(Color.orange);
        container.add(buttonBack);

        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                terminateThisWindow();

            }
        });
//Button back end
//buttons&labels end
    }

//if settings changed
    @Override
    public void itemStateChanged(ItemEvent e) {
        buttonNext.setEnabled(false);
    }
}
