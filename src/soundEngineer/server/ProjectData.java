package soundEngineer.server;

import soundEngineer.gui.*;

import java.util.ArrayList;
import java.util.Arrays;

public class ProjectData {
    public static String projectName;
    public static ArrayList<String> drumStrips = new ArrayList<>(Arrays.asList("Kick", "Sn1T", "Sn1B", "Sn2",
            "Hat", "Tom1", "Tom2", "FTom", "OH1", "OH2"));
    public static ArrayList<String> guitarStrips = new ArrayList<>(Arrays.asList("Bass", "EGtr", "AGtr"));
    public static ArrayList<String> synthStrips = new ArrayList<>(Arrays.asList("Sy1L", "Sy1R"));
    public static ArrayList<String> percussionStrips = new ArrayList();
    public static ArrayList<String> stringedStrips = new ArrayList();
    public static ArrayList<String> windStrips = new ArrayList();
    public static ArrayList<String> leadVocStrips = new ArrayList();
    public static ArrayList<String> backVocStrips = new ArrayList();
    public static ArrayList<String> omniStrips = new ArrayList();
    public static ArrayList<String> extraStrips = new ArrayList();
    public static ArrayList<String> uzbekStrips = new ArrayList();
    public static ArrayList<String> inputStrips = new ArrayList();
    public static ArrayList<String> outStrips = new ArrayList<>(Arrays.asList("Ramp", "SF",
            "Dr", "Keys", "Gtr", "Per", "FF", "Sub", "FohL", "FohR"));
    public static String fohConsoleName;
    public static String monConsoleName;

    public static Integer commonChannels() {
        int sumChan = (drumStrips.size() + guitarStrips.size() + synthStrips.size() + percussionStrips.size()
                + stringedStrips.size() + windStrips.size() + leadVocStrips.size() + backVocStrips.size() +
                omniStrips.size() + extraStrips.size() + uzbekStrips.size());
        return sumChan;
    }

    public static AcousticDrums acousticDrums =new AcousticDrums();
   // public static Consoles consoles = new Consoles();
    public static DefineInstruments defineInstruments = new DefineInstruments();
    public static Guitars guitars = new Guitars();
    public static Others others = new Others();
    public static Percussion percussion = new Percussion();
    public static Stringed stringed = new Stringed();
    public static Synths synths = new Synths();
    public static Uzbek uzbek = new Uzbek();
    public static Vocals vocals = new Vocals();
    public static WoodsBrass woodsBrass = new WoodsBrass();

    public static void populateInputs(){
        inputStrips.clear();
        inputStrips.addAll(drumStrips);
        inputStrips.addAll(guitarStrips);
        inputStrips.addAll(synthStrips);
        inputStrips.addAll(stringedStrips);
        inputStrips.addAll(windStrips);
        inputStrips.addAll(percussionStrips);
        inputStrips.addAll(uzbekStrips);
        inputStrips.addAll(leadVocStrips);
        inputStrips.addAll(backVocStrips);
        inputStrips.addAll(extraStrips);
        //inputStrips.addAll(omniStrips);
        if (inputStrips.size() - 1 <= 32) {
            fohConsoleName = "X32";
        }else  if (inputStrips.size() - 1 <= 64) {
            fohConsoleName = "iLive";
        }else fohConsoleName = "Rivage";
        inputStrips.add(0, fohConsoleName);
    }
}
