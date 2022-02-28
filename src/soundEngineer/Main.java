package soundEngineer;
import soundEngineer.consolesGUI.Pm5d;
import soundEngineer.gui.SetProjectName;
import soundEngineer.server.ProjectData;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ProjectData.populateInputs();
        Pm5d pm5d = new Pm5d();
        pm5d.setVisible(true);

//        SetProjectName setProjectName = new SetProjectName();
//        setProjectName.setVisible(true);

    }
}
