import soundEngineer.server.ProjectData;
import soundEngineer.step1.SetProjectName;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ProjectData.populateChannels();
        SetProjectName setProjectName = new SetProjectName();
        setProjectName.setVisible(true);

    }
}
