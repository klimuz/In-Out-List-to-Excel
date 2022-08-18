package soundEngineer.step2;

import soundEngineer.server.ProjectData;

import javax.swing.*;

public class OutDirectoryChooser extends JFrame {
    private JFileChooser fileChooser;


    public OutDirectoryChooser() {
        super("Choose directory");
        fileChooser = new JFileChooser(javax.swing.filechooser.FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setDialogTitle("Choose folder");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        int result = fileChooser.showOpenDialog(OutDirectoryChooser.this);
        if (result == JFileChooser.APPROVE_OPTION) {
            ProjectData.filePath = fileChooser.getSelectedFile().getPath();
            JOptionPane.showMessageDialog(OutDirectoryChooser.this,
                    "Saved in " + fileChooser.getSelectedFile().getPath());
            this.setVisible(false);
        }else {
            this.setVisible(false);
        }
    }
}