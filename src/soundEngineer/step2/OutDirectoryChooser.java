package soundEngineer.step2;

import soundEngineer.server.ProjectData;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

public class OutDirectoryChooser extends JFrame {
    private JFileChooser fileChooser = null;


    public OutDirectoryChooser() {
        super("Choose directory");
        fileChooser = new JFileChooser("G:\test", FileSystemView.getFileSystemView());
        fileChooser.setDialogTitle("Choose folder");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = fileChooser.showOpenDialog(OutDirectoryChooser.this);
        if (result == JFileChooser.APPROVE_OPTION ) {
            ProjectData.filePath = fileChooser.getSelectedFile().getPath();
            JOptionPane.showMessageDialog(OutDirectoryChooser.this,
                    fileChooser.getSelectedFile());
        }
    }
}