package soundEngineer.server;

import soundEngineer.step2.NormaliseListsGui;
import soundEngineer.step1.*;


import java.util.ArrayList;
import java.util.Arrays;

public class ProjectData {
    public static String projectName = "No name";
    public static ArrayList<String> drumStrips = new ArrayList<>(Arrays.asList("Kick", "SD T", "SD B",
            "Hat", "Tom1", "Tom2", "FTom", "OH1", "OH2"));
    public static ArrayList<String> guitarStrips = new ArrayList<>(Arrays.asList("Bass", "EGtr", "AGtr"));
    public static ArrayList<String> keyboardStrips = new ArrayList<>(Arrays.asList("Sy1L", "Sy1R"));
    public static ArrayList<String> percussionStrips = new ArrayList();
    public static ArrayList<String> stringedStrips = new ArrayList();
    public static ArrayList<String> windStrips = new ArrayList();
    public static ArrayList<String> vocalStrips = new ArrayList();
    public static ArrayList<String> omniStrips = new ArrayList<>(Arrays.asList("DJ L", "DJ R", "SCRL", "SCRR" ));
    public static ArrayList<String> extraStrips = new ArrayList<>(Arrays.asList("Hst1", "Hst2", "Hst3", "Hst4"));
    public static ArrayList<String> uzbekStrips = new ArrayList();
    public static ArrayList<String> worldWideStrips = new ArrayList();

    public static ArrayList<String> inputStrips = new ArrayList();
    public static ArrayList<String> outStrips = new ArrayList<>(Arrays.asList("Ramp", "SF",
            "Dr", "Keys", "Gtr", "Per", "FF", "Sub", "FohL", "FohR"));
    public static String fohConsoleName = "PM5D";
    public static String monConsoleName;

    public static AcousticDrumsGUI acousticDrumsGUI;
    public static DefineInstruments defineInstruments;
    public static GuitarsGUI guitarsGUI;
    public static Others others;
    public static Percussion percussion;
    public static Stringed stringed;
    public static Synths synths;
    public static Uzbek uzbek;
    public static Vocals vocals;
    public static WoodsBrass woodsBrass;
    public static WorldWideGui worldWideGui;
    public static NormaliseListsGui normaliseListsGui;

    public static String filePath = "D:";

    public static Integer commonChannels() {
        int sumChan = (drumStrips.size() + guitarStrips.size() + keyboardStrips.size() + percussionStrips.size()
                + stringedStrips.size() + windStrips.size() + vocalStrips.size() + extraStrips.size()
                + uzbekStrips.size() + worldWideStrips.size());
        return sumChan;
    }
public static void createObjects() {
    acousticDrumsGUI = new AcousticDrumsGUI();
    defineInstruments = new DefineInstruments();
    guitarsGUI = new GuitarsGUI();
    others = new Others();
    percussion = new Percussion();
    stringed = new Stringed();
    synths = new Synths();
    uzbek = new Uzbek();
    vocals = new Vocals();
    woodsBrass = new WoodsBrass();
    worldWideGui = new WorldWideGui();
}
    public static void populateChannels(){
        inputStrips.clear();
        inputStrips.addAll(drumStrips);
        inputStrips.addAll(guitarStrips);
        inputStrips.addAll(keyboardStrips);
        inputStrips.addAll(stringedStrips);
        inputStrips.addAll(windStrips);
        inputStrips.addAll(percussionStrips);
        inputStrips.addAll(uzbekStrips);
        inputStrips.addAll(worldWideStrips);
        inputStrips.addAll(vocalStrips);
        inputStrips.addAll(extraStrips);
//solve odd-even for stereo
//bass
        if (inputStrips.contains("BasL") && (inputStrips.indexOf("BasL")%2 == 0)){
            if (inputStrips.size() < 32){
                inputStrips.add(inputStrips.indexOf("BasL"), "Extr");
            }else if (worldWideStrips.size()%2 != 0){
                inputStrips.removeAll(worldWideStrips);
                inputStrips.addAll(inputStrips.indexOf("BasL"), worldWideStrips);
            }else if (percussionStrips.size()%2 != 0){
                inputStrips.removeAll(percussionStrips);
                inputStrips.addAll(inputStrips.indexOf("BasL"), percussionStrips);
            }else if (uzbekStrips.size()%2 != 0){
                inputStrips.removeAll(uzbekStrips);
                inputStrips.addAll(inputStrips.indexOf("BasL"), uzbekStrips);
            }else if (inputStrips.contains("EGtr")){
                inputStrips.remove("EGtr");
                inputStrips.add(inputStrips.indexOf("BasL"), "EGtr");
            }else if (inputStrips.contains("EGt1")){
                inputStrips.remove("EGt1");
                inputStrips.add(inputStrips.indexOf("BasL"), "EGt1");
            }else if (inputStrips.contains("EGt2")){
                inputStrips.remove("EGt2");
                inputStrips.add(inputStrips.indexOf("BasL"), "EGt2");
            }else if (inputStrips.contains("EGt3")){
                inputStrips.remove("EGt3");
                inputStrips.add(inputStrips.indexOf("BasL"), "EGt3");
            }else if (inputStrips.contains("Synt")){
                inputStrips.remove("Synt");
                inputStrips.add(inputStrips.indexOf("BasL"), "Synt");
            }else if (inputStrips.contains("Syn1")){
                inputStrips.remove("Syn1");
                inputStrips.add(inputStrips.indexOf("BasL"), "Syn1");
            }else if (inputStrips.contains("Syn2")){
                inputStrips.remove("Syn2");
                inputStrips.add(inputStrips.indexOf("BasL"), "Syn2");
            }else if (inputStrips.contains("Syn3")){
                inputStrips.remove("Syn3");
                inputStrips.add(inputStrips.indexOf("BasL"), "Syn3");
            }
        }
//EGtL
        if (inputStrips.contains("EGtL") && (inputStrips.indexOf("EGtL")%2 == 0)) {
            if (inputStrips.size() < 32) {
                inputStrips.add(inputStrips.indexOf("EGtL"), "Extr");
            } else if (worldWideStrips.size() % 2 != 0) {
                inputStrips.removeAll(worldWideStrips);
                inputStrips.addAll(inputStrips.indexOf("EGtL"), worldWideStrips);
            } else if (percussionStrips.size() % 2 != 0) {
                inputStrips.removeAll(percussionStrips);
                inputStrips.addAll(inputStrips.indexOf("EGtL"), percussionStrips);
            } else if (uzbekStrips.size() % 2 != 0) {
                inputStrips.removeAll(uzbekStrips);
                inputStrips.addAll(inputStrips.indexOf("EGtL"), uzbekStrips);
            } else if (inputStrips.contains("EGtr")) {
                inputStrips.remove("EGtr");
                inputStrips.add(inputStrips.indexOf("EGtR") + 1, "EGtr");
            } else if (inputStrips.contains("EGt1")) {
                inputStrips.remove("EGt1");
                inputStrips.add(inputStrips.indexOf("EGtL"), "EGt1");
            } else if (inputStrips.contains("EGt2")) {
                inputStrips.remove("EGt2");
                inputStrips.add(inputStrips.indexOf("EGtL"), "EGt2");
            } else if (inputStrips.contains("EGt3")) {
                inputStrips.remove("EGt3");
                inputStrips.add(inputStrips.indexOf("EGtL"), "EGt3");
            } else if (inputStrips.contains("Synt")) {
                inputStrips.remove("Synt");
                inputStrips.add(inputStrips.indexOf("EGtL"), "Synt");
            } else if (inputStrips.contains("Syn1")) {
                inputStrips.remove("Syn1");
                inputStrips.add(inputStrips.indexOf("EGtL"), "Syn1");
            } else if (inputStrips.contains("Syn2")) {
                inputStrips.remove("Syn2");
                inputStrips.add(inputStrips.indexOf("EGtL"), "Syn2");
            } else if (inputStrips.contains("Syn3")) {
                inputStrips.remove("Syn3");
                inputStrips.add(inputStrips.indexOf("EGtL"), "Syn3");
            }
        }
//preferred console
        if (inputStrips.size() - 1 <= 32) {
            fohConsoleName = "X32";
        }else  if (inputStrips.size() - 1 <= 64) {
            fohConsoleName = "iLive";
        }else fohConsoleName = "Rivage";
        inputStrips.add(0, fohConsoleName);
    }
}
