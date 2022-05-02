package soundEngineer;
import soundEngineer.step1.SetProjectName;
import soundEngineer.server.ProjectData;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ProjectData.populateChannels();
//        InputChannels inputChannels = new InputChannels();
//        inputChannels.setVisible(true);

        SetProjectName setProjectName = new SetProjectName();
        setProjectName.setVisible(true);

    }
}
