package soundEngineer.server;

public class NamesAndPickup {
    private static final String[][] CHANNELNAMES =

            {
//DrumStrips
//kick
                    {"Kick", "Kick", "SM52", ""},
                    {"BD1", "Kick", "SM52", ""},
                    {"BD2", "Kick condenser", "Beta91A", ""},
                    {"Trig", "Kick trigger", "XLR", ""},
//snare1
                    {"SD", "Snare", "", ""},
                    {"SD T", "Snare top", "", ""},
                    {"SD B", "Snare bottom", "", ""},
                    {"SD1", "Snare1", "", ""},
                    {"Sn1T", "Snare1 top", "", ""},
                    {"Sn1B", "Snare1 bottom", "", ""},
//snare2
                    {"SD2", "Snare2", "", ""},
                    {"Sn2T", "Snare2 top", "", ""},
                    {"Sn2B", "Snare2 bottom", "", ""},
//hat
                    {"Hat", "Hi hat", "Cond", ""},
//toms
                    {"Tom", "Tom", "", ""},
                    {"Tom1", "Tom1", "", ""},
                    {"Tom2", "Tom2", "", ""},
                    {"Tom3", "Tom3", "", ""},
                    {"Tom4", "Tom4", "", ""},
//floor toms
                    {"FTom", "Floor tom", "", ""},
                    {"FTo1", "Floor tom1", "", ""},
                    {"FTo2", "Floor tom2", "", ""},
                    {"FTo3", "Floor tom3", "", ""},
                    {"FTo4", "Floor tom4", "", ""},
//over
                    {"Over", "Over head", "Cond", ""},
                    {"OH1", "Over head1", "Cond", ""},
                    {"OH2", "Over head2", "Cond", ""},
//drum machine
                    {"ElDr", "Drum machine", "DI", ""},
                    {"EDrL", "Drum machine L", "DI", "odd"},
                    {"EDrR", "Drum machine R", "DI", ""},
                    {"EDr1", "Drum machine1", "DI", ""},
                    {"EDr2", "Drum machine2", "DI", ""},
                    {"EDr3", "Drum machine3", "DI", ""},
//Guitar strips
//bass
                    {"Bass", "Bass", "DI", ""},
                    {"BasL", "Bass L", "DI", "odd"},
                    {"BasR", "Bass R", "DI", ""},
//mono eguitars
                    {"EGtr", "Electric guitar", "DI", ""},
                    {"EGt1", "Electric guitar1", "DI", ""},
                    {"EGt2", "Electric guitar2", "DI", ""},
                    {"EGt3", "Electric guitar3", "DI", ""},
//stereo eguitars
                    {"EGtL", "Electric guitar L", "DI", "odd"},
                    {"EGtR", "Electric guitar R", "DI", ""},
                    {"EG1L", "Electric guitar1L", "DI", "odd"},
                    {"EG1R", "Electric guitar1R", "DI", ""},
                    {"EG2L", "Electric guitar2L", "DI", "odd"},
                    {"EG2R", "Electric guitar2R", "DI", ""},
                    {"EG3L", "Electric guitar3L", "DI", "odd"},
                    {"EG3R", "Electric guitar3R", "DI", ""},
//mono aguitars
                    {"AGtr", "Acoustic guitar", "DI", ""},
                    {"AGt1", "Acoustic guitar1", "DI", ""},
                    {"AGt2", "Acoustic guitar2", "DI", ""},
                    {"AGt3", "Acoustic guitar3", "DI"},
//stereo aguitars
                    {"AGtL", "Acoustic guitar L", "DI", "odd"},
                    {"AGtR", "Acoustic guitar R", "DI", ""},
                    {"AG1L", "Acoustic guitar1L", "DI", "odd"},
                    {"AG1R", "Acoustic guitar1R", "DI", ""},
                    {"AG2L", "Acoustic guitar2L", "DI", "odd"},
                    {"AG2R", "Acoustic guitar2R", "DI", ""},
                    {"AG3L", "Acoustic guitar3L", "DI", "odd"},
                    {"AG3R", "Acoustic guitar3R", "DI", ""},
//others
//dj
                    {"DJ L", "Playback L(stage)", "DI", "odd"},
                    {"DJ R", "Playback R(stage)", "DI", ""},
                    {"Dj L", "Playback L(omni)", "Mini TRS", "odd"},
                    {"Dj R", "Playback R(omni)", "Mini TRS", ""},
                    {"DJ1L", "Playback1L(stage)", "DI", "odd"},
                    {"DJ1R", "Playback1R(stage)", "DI", ""},
                    {"Dj1L", "Playback1L(omni)", "Mini TRS", "odd"},
                    {"Dj1R", "Playback1R(omni)", "Mini TRS", ""},
                    {"DJ2L", "Playback2L(stage)", "DI", "odd"},
                    {"DJ2R", "Playback2R(stage)", "DI", ""},
                    {"Dj2L", "Playback2L(omni)", "Mini TRS", "odd"},
                    {"Dj2R", "Playback2R(omni)", "Mini TRS", ""},
                    {"DJ3L", "Playback3L(stage)", "DI", "odd"},
                    {"DJ3R", "Playback3R(stage)", "DI", ""},
                    {"Dj3L", "Playback3L(omni)", "Mini TRS", "odd"},
                    {"Dj3R", "Playback3R(omni)", "Mini TRS", ""},
                    {"DJ4L", "Playback4L(stage)", "DI", "odd"},
                    {"DJ4R", "Playback4R(stage)", "DI", ""},
                    {"Dj4L", "Playback4L(omni)", "Mini TRS", "odd"},
                    {"Dj4R", "Playback4R(omni)", "Mini TRS", ""},
//Graphic
                    {"SCRL", "Graphic L(stage)", "DI", "odd"},
                    {"SCRR", "Graphic R(stage)", "DI", ""},
                    {"ScrL", "Graphic L(omni)", "Mini TRS", "odd"},
                    {"ScrR", "Graphic R(omni)", "Mini TRS", ""},
                    {"SC1L", "Graphic1L(stage)", "DI", "odd"},
                    {"SC1R", "Graphic1R(stage)", "DI", ""},
                    {"Sc1L", "Graphic1L(omni)", "Mini TRS", "odd"},
                    {"Sc1R", "Graphic1R(omni)", "Mini TRS", ""},
                    {"SC2L", "Graphic2L(stage)", "DI", "odd"},
                    {"SC2R", "Graphic2R(stage)", "DI", ""},
                    {"Sc2L", "Graphic2L(omni)", "Mini TRS", "odd"},
                    {"Sc2R", "Graphic2R(omni)", "Mini TRS", ""},
                    {"SC3L", "Graphic3L(stage)", "DI", "odd"},
                    {"SC3R", "Graphic3R(stage)", "DI", ""},
                    {"Sc3L", "Graphic3L(omni)", "Mini TRS", "odd"},
                    {"Sc3R", "Graphic3R(omni)", "Mini TRS", ""},
                    {"SC4L", "Graphic4L(stage)", "DI", "odd"},
                    {"SC4R", "Graphic4R(stage)", "DI", ""},
                    {"Sc4L", "Graphic4L(omni)", "Mini TRS", "odd"},
                    {"Sc4R", "Graphic4R(omni)", "Mini TRS", ""},
//host
                    {"Host", "Host", "Wireless", ""},
                    {"Hst1", "Host1", "Wireless", ""},
                    {"Hst2", "Host2", "Wireless", ""},
                    {"Hst3", "Host3", "Wireless", ""},
                    {"Hst4", "Host4", "Wireless", ""},
                    {"Hst5", "Host5", "Wireless", ""},
                    {"Hst6", "Host6", "Wireless", ""},
                    {"Hst7", "Host7", "Wireless", ""},
                    {"Hst8", "Host8", "Wireless", ""},
                    {"Hst9", "Host9", "Wireless", ""},
                    {"Hs10", "Host10", "Wireless", ""},
//click
                    {"Clik", "Click", "DI", ""},
                    {"Clk1", "Click1", "DI", ""},
                    {"Clk2", "Click2", "DI", ""},
//extra
                    {"Extr", "Extra", "", ""},
                    {"Ext1", "Extra1", "", ""},
                    {"Ext2", "Extra2", "", ""},
                    {"Ext3", "Extra3", "", ""},
                    {"Ext4", "Extra4", "", ""},
                    {"Ext5", "Extra5", "", ""},
                    {"Ext6", "Extra6", "", ""},
                    {"Ext7", "Extra7", "", ""},
                    {"Ext8", "Extra8", "", ""},
                    {"Ext9", "Extra9", "", ""},
                    {"Ex10", "Extra10", "", ""},
//room
                    {"Room", "Room", "Cond", ""},
                    {"Roo1", "Room1", "Cond", ""},
                    {"Roo2", "Room2", "Cond", ""},
                    {"Roo3", "Room3", "Cond", ""},
                    {"Roo4", "Room4", "Cond", ""},
                    {"Roo5", "Room5", "Cond", ""},
                    {"Roo6", "Room6", "Cond", ""},
                    {"Roo7", "Room7", "Cond", ""},
                    {"Roo8", "Room8", "Cond", ""},
                    {"Roo9", "Room9", "Cond", ""},
                    {"Ro10", "Room10", "Cond", ""},
//percussion strips
//cong
                    {"Cong", "Congas", "", ""},
                    {"Cng1", "Congas1", "", ""},
                    {"Cng2", "Congas2", "", ""},
                    {"Cng3", "Congas3", "", ""},
//bongos
                    {"Bong", "Bongos", "", ""},
                    {"Bng1", "Bongos1", "", ""},
                    {"Bng2", "Bongos2", "", ""},
//shaker
                    {"Shkr", "Shaker", "Cond", ""},
                    {"Shk1", "Shaker1", "Cond", ""},
                    {"Shk2", "Shaker2", "Cond", ""},
                    {"Shk3", "Shaker3", "Cond", ""},
//tambourine
                    {"Tmbn", "Tambourine", "Cond", ""},
                    {"Tmn1", "Tambourine1", "Cond", ""},
                    {"Tmn2", "Tambourine2", "Cond", ""},
                    {"Tmn3", "Tambourine3", "Cond", ""},
//perc. overhead
                    {"OvHd", "Per.over head", "Cond", ""},
                    {"OHd1", "Per.over head1", "Cond", ""},
                    {"OHd2", "Per.over head2", "Cond", ""},
//doyra
                    {"Doyr", "Doyra", "", ""},
                    {"Doy1", "Doyra1", "", ""},
                    {"Doy2", "Doyra2", "", ""},
                    {"Doy3", "Doyra3", "", ""},
                    {"Doy4", "Doyra4", "", ""},
                    {"Doy5", "Doyra5", "", ""},
//tabla
                    {"Tabl", "Tabla", "", ""},
                    {"Tab1", "Tabla1", "", ""},
                    {"Tab2", "Tabla2", "", ""},
                    {"Tab3", "Tabla3", "", ""},
//nagora
                    {"Nago", "Nagora", "", ""},
                    {"Nag1", "Nagora1", "", ""},
                    {"Nag2", "Nagora2", "", ""},
                    {"Nag3", "Nagora3", "", ""},
//Jambey
                    {"Jamb", "Jambey", "", ""},
                    {"Jam1", "Jambey1", "", ""},
                    {"Jam2", "Jambey2", "", ""},
//kajon
                    {"Kjon", "Kajon", "", ""},
                    {"Kjn1", "Kajon1", "", ""},
                    {"Kjn2", "Kajon2", "", ""},
//other percussion
                    {"Perc", "Percussion", "", ""},
                    {"Per1", "Percussion1", "", ""},
                    {"Per2", "Percussion2", "", ""},
                    {"Per3", "Percussion3", "", ""},
                    {"Per4", "Percussion4", "", ""},
                    {"Per5", "Percussion5", "", ""},
//stringed strips
//1-st vio
                    {"Vio1", "1-st violin", "DPA", ""},
                    {"V1-1", "1-st violin1", "DPA", ""},
                    {"V1-2", "1-st violin2", "DPA", ""},
                    {"V1-3", "1-st violin3", "DPA", ""},
                    {"V1-4", "1-st violin4", "DPA", ""},
                    {"V1-5", "1-st violin5", "DPA", ""},
                    {"V1-6", "1-st violin6", "DPA", ""},
                    {"V1-7", "1-st violin7", "DPA", ""},
                    {"V1-8", "1-st violin8", "DPA", ""},
//2-nd vio
                    {"Vio2", "2-nd violin", "DPA", ""},
                    {"V2-1", "2-nd violin1", "DPA", ""},
                    {"V2-2", "2-nd violin2", "DPA", ""},
                    {"V2-3", "2-nd violin3", "DPA", ""},
                    {"V2-4", "2-nd violin4", "DPA", ""},
                    {"V2-5", "2-nd violin5", "DPA", ""},
                    {"V2-6", "2-nd violin6", "DPA", ""},
                    {"V2-7", "2-nd violin7", "DPA", ""},
                    {"V2-8", "2-nd violin8", "DPA", ""},
//violas
                    {"Alts", "Viola", "DPA", ""},
                    {"Alt1", "Viola1", "DPA", ""},
                    {"Alt2", "Viola2", "DPA", ""},
                    {"Alt3", "Viola3", "DPA", ""},
                    {"Alt4", "Viola4", "DPA", ""},
                    {"Alt5", "Viola5", "DPA", ""},
                    {"Alt6", "Viola6", "DPA", ""},
                    {"Alt7", "Viola7", "DPA", ""},
                    {"Alt8", "Viola8", "DPA", ""},
//cello
                    {"Celo", "Cello", "DPA", ""},
                    {"Cel1", "Cello1", "DPA", ""},
                    {"Cel2", "Cello2", "DPA", ""},
                    {"Cel3", "Cello3", "DPA", ""},
                    {"Cel4", "Cello4", "DPA", ""},
                    {"Cel5", "Cello5", "DPA", ""},
                    {"Cel6", "Cello6", "DPA", ""},
                    {"Cel7", "Cello7", "DPA", ""},
                    {"Cel8", "Cello8", "DPA", ""},
//contrabass
                    {"DBas", "Contrabass", "DPA", ""},
                    {"DBs1", "Contrabass1", "DPA", ""},
                    {"DBs2", "Contrabass2", "DPA", ""},
                    {"DBs3", "Contrabass3", "DPA", ""},
                    {"DBs4", "Contrabass4", "DPA", ""},
                    {"DBs5", "Contrabass5", "DPA", ""},
                    {"DBs6", "Contrabass6", "DPA", ""},
                    {"DBs7", "Contrabass7", "DPA", ""},
                    {"DBs8", "Contrabass8", "DPA", ""},

                    {"Harp", "Harpsichord", "", ""},
//Woods-brass
//Trumpet
                    {"Trum", "Trumpet", "", ""},
                    {"Tru1", "Trumpet1", "", ""},
                    {"Tru2", "Trumpet2", "", ""},
                    {"Tru3", "Trumpet3", "", ""},
                    {"Tru4", "Trumpet4", "", ""},
//Trombone
                    {"Trom", "Trombone", "", ""},
                    {"Tro1", "Trombone1", "", ""},
                    {"Tro2", "Trombone2", "", ""},
                    {"Tro3", "Trombone3", "", ""},
                    {"Tro4", "Trombone4", "", ""},
//Sax
                    {"Sax", "Sax", "", ""},
                    {"Sax1", "Sax1", "", ""},
                    {"Sax2", "Sax2", "", ""},
                    {"Sax3", "Sax3", "", ""},
                    {"Sax4", "Sax4", "", ""},
//Tuba
                    {"Tuba", "Tuba", "", ""},
                    {"Tub1", "Tuba1", "", ""},
                    {"Tub2", "Tuba2", "", ""},
                    {"Tub3", "Tuba3", "", ""},
                    {"Tub4", "Tuba4", "", ""},
//Horn
                    {"Horn", "Horn", "DPA", ""},
                    {"Hor1", "Horn1", "DPA", ""},
                    {"Hor2", "Horn2", "DPA", ""},
                    {"Hor3", "Horn3", "DPA", ""},
                    {"Hor4", "Horn4", "DPA", ""},
//Flute
                    {"Flut", "Flute", "DPA", ""},
                    {"Flu1", "Flute1", "DPA", ""},
                    {"Flu2", "Flute2", "DPA", ""},
                    {"Flu3", "Flute3", "DPA", ""},
                    {"Flu4", "Flute4", "DPA", ""},
//Clarinet
                    {"Clar", "Clarinet", "Cond", ""},
                    {"Cla1", "Clarinet1", "Cond", ""},
                    {"Cla2", "Clarinet2", "Cond", ""},
                    {"Cla3", "Clarinet3", "Cond", ""},
                    {"Cla4", "Clarinet4", "Cond", ""},
//Oboe
                    {"Oboe", "Oboe", "DPA", ""},
                    {"Obo1", "Oboe1", "DPA", ""},
                    {"Obo2", "Oboe2", "DPA", ""},
                    {"Obo3", "Oboe3", "DPA", ""},
                    {"Obo4", "Oboe4", "DPA", ""},
//Bassoon
                    {"Bsn", "Bassoon", "DPA", ""},
                    {"Bsn1", "Bassoon1", "DPA", ""},
                    {"Bsn2", "Bassoon2", "DPA", ""},
                    {"Bsn3", "Bassoon3", "DPA", ""},
                    {"Bsn4", "Bassoon4", "DPA", ""},
//Wood or Brass
                    {"Wind", "Wood or Brass", "", ""},
                    {"Win1", "Wood or Brass1", "", ""},
                    {"Win2", "Wood or Brass2", "", ""},
                    {"Win3", "Wood or Brass3", "", ""},
                    {"Win4", "Wood or Brass4", "", ""},
                    {"Win5", "Wood or Brass5", "", ""},
//synths and pianos
//mono synth
                    {"Synt", "Synth", "DI", ""},
                    {"Syn1", "Synth1", "DI", ""},
                    {"Syn2", "Synth2", "DI", ""},
                    {"Syn3", "Synth3", "DI", ""},
//stereo synth
                    {"SynL", "Synth L", "DI", "odd"},
                    {"SynR", "Synth R", "DI", ""},
                    {"Sy1L", "Synth1L", "DI", "odd"},
                    {"Sy1R", "Synth1R", "DI", ""},
                    {"Sy2L", "Synth2L", "DI", "odd"},
                    {"Sy2R", "Synth2R", "DI", ""},
                    {"Sy3L", "Synth3L", "DI", "odd"},
                    {"Sy3R", "Synth3R", "DI", ""},
//piano
                    {"Pno", "Piano", "", ""},
                    {"PnoH", "Piano Hi", "", ""},
                    {"PnoL", "Piano Lo", "", ""},
//uzbek
//rubob
                    {"Rub", "Rubob", "DPA", ""},
                    {"Rub1", "Rubob1", "DPA", ""},
                    {"Rub2", "Rubob2", "DPA", ""},
                    {"Rub3", "Rubob3", "DPA", ""},
                    {"Rub4", "Rubob4", "DPA", ""},
//dutor
                    {"Dut", "Dutor", "DPA", ""},
                    {"Dut1", "Dutor1", "DPA", ""},
                    {"Dut2", "Dutor2", "DPA", ""},
                    {"Dut3", "Dutor3", "DPA", ""},
                    {"Dut4", "Dutor4", "DPA", ""},
                    {"Dut5", "Dutor5", "DPA", ""},
                    {"Dut6", "Dutor6", "DPA", ""},
                    {"Dut7", "Dutor7", "DPA", ""},
                    {"Dut8", "Dutor8", "DPA", ""},
                    {"Dut9", "Dutor9", "DPA", ""},
                    {"Du10", "Dutor10", "DPA", ""},
//bass dutor
                    {"BDut", "Bass Dutor", "DPA", ""},
                    {"BDu1", "Bass Dutor1", "DPA", ""},
                    {"BDu2", "Bass Dutor2", "DPA", ""},
                    {"BDu3", "Bass Dutor3", "DPA", ""},
                    {"BDu4", "Bass Dutor4", "DPA", ""},
//tambur
                    {"tam", "Tambur", "DPA", ""},
                    {"tam1", "Tambur1", "DPA", ""},
                    {"tam2", "Tambur2", "DPA", ""},
                    {"tam3", "Tambur3", "DPA", ""},
//Soz
                    {"Soz", "Soz", "", ""},
                    {"Soz1", "Soz1", "", ""},
                    {"Soz2", "Soz2", "", ""},
//aud
                    {"Aud", "Aud", "", ""},
                    {"Aud1", "Aud1", "", ""},
                    {"Aud2", "Aud2", "", ""},
                    {"Aud3", "Aud3", "", ""},
//chang
                    {"Chng", "Chang", "", ""},
                    {"Chg1", "Chang1", "", ""},
                    {"Chg2", "Chang2", "", ""},
//konun
                    {"Kon", "Konun", "", ""},
                    {"Kon1", "Konun1", "", ""},
                    {"Kon2", "Konun2", "", ""},
                    {"Kon3", "Konun3", "", ""},
//nay
                    {"Nay", "Nay", "", ""},
                    {"Nay1", "Nay1", "", ""},
                    {"Nay2", "Nay2", "", ""},
                    {"Nay3", "Nay3", "", ""},
                    {"Nay4", "Nay4", "", ""},
//kushNay
                    {"KNay", "Kush-Nay", "", ""},
                    {"KNa1", "Kush-Nay1", "", ""},
                    {"KNa2", "Kush-Nay2", "", ""},
                    {"KNa3", "Kush-Nay3", "", ""},
                    {"KNa4", "Kush-Nay4", "", ""},
//surNay
                    {"SNay", "Sur-Nay", "", ""},
                    {"SNa1", "Sur-Nay1", "", ""},
                    {"SNa2", "Sur-Nay2", "", ""},
                    {"SNa3", "Sur-Nay3", "", ""},
                    {"SNa4", "Sur-Nay4", "", ""},
//violin
                    {"vio", "Violin", "", ""},
                    {"vio1", "Violin1", "", ""},
                    {"vio2", "Violin2", "", ""},
                    {"vio3", "Violin3", "", ""},
                    {"vio4", "Violin4", "", ""},
//gijak
                    {"Gij", "Gijak", "", ""},
                    {"Gij1", "Gijak1", "", ""},
                    {"Gij2", "Gijak2", "", ""},
                    {"Gij3", "Gijak3", "", ""},
                    {"Gij4", "Gijak4", "", ""},
//cello
                    {"cel", "Cello", "", ""},
                    {"cel1", "Cello1", "", ""},
                    {"cel2", "Cello2", "", ""},

//vocals
//main vocals
                    {"MV", "Vocal", "Wireless", ""},
                    {"MV1", "Vocal1", "Wireless", ""},
                    {"MV2", "Vocal2", "Wireless", ""},
                    {"MV3", "Vocal3", "Wireless", ""},
                    {"MV4", "Vocal4", "Wireless", ""},
                    {"MV5", "Vocal5", "Wireless", ""},
                    {"MV6", "Vocal6", "Wireless", ""},
                    {"MV7", "Vocal7", "Wireless", ""},
                    {"MV8", "Vocal8", "Wireless", ""},
                    {"MV9", "Vocal9", "Wireless", ""},
                    {"MV10", "Vocal10", "Wireless", ""},
//back vocals
                    {"BV", "Back-Vocal", "", ""},
                    {"BV1", "Back-Vocal1", "", ""},
                    {"BV2", "Back-Vocal2", "", ""},
                    {"BV3", "Back-Vocal3", "", ""},
                    {"BV4", "Back-Vocal4", "", ""},
                    {"BV5", "Back-Vocal5", "", ""},
                    {"BV6", "Back-Vocal6", "", ""},
                    {"BV7", "Back-Vocal7", "", ""},
                    {"BV8", "Back-Vocal8", "", ""},
                    {"BV9", "Back-Vocal9", "", ""},
                    {"BV10", "Back-Vocal10", "", ""},
//Choir
                    {"Chor", "Choir", "Cond", ""},
                    {"Cho1", "Choir1", "Cond", ""},
                    {"Cho2", "Choir2", "Cond", ""},
                    {"Cho3", "Choir3", "Cond", ""},
                    {"Cho4", "Choir4", "Cond", ""},
                    {"Cho5", "Choir5", "Cond", ""},
                    {"Cho6", "Choir6", "Cond", ""},
                    {"Cho7", "Choir7", "Cond", ""},
                    {"Cho8", "Choir8", "Cond", ""},
                    {"Cho9", "Choir9", "Cond", ""},
                    {"Cr10", "Choir10", "Cond", ""},

//Worldwide
//Bouzouki
                    {"Bouz", "Bouzouki", "", ""},
                    {"Buz1", "Bouzouki1", "", ""},
                    {"Buz2", "Bouzouki2", "", ""},
                    {"Buz3", "Bouzouki3", "", ""},
                    {"Buz4", "Bouzouki4", "", ""},
//Banjo
                    {"Banj", "Banjo", "", ""},
                    {"Ban1", "Banjo1", "", ""},
                    {"Ban2", "Banjo2", "", ""},
                    {"Ban3", "Banjo3", "", ""},
                    {"Ban4", "Banjo4", "", ""}
            };

    public static String getChannelFullName(String shortName) {
        String channelFullName = "";
        for (int i = 0; i < CHANNELNAMES.length; i++){
          if (CHANNELNAMES [i] [0] == shortName){
              channelFullName = CHANNELNAMES [i][1];
          }
        }
        return channelFullName;
        }
    public static String getChannelPickup(String shortName) {
        String channelPickup = "";
        for (int i = 0; i < CHANNELNAMES.length; i++){
            if (CHANNELNAMES [i] [0] == shortName){
                channelPickup = CHANNELNAMES [i][2];
            }
        }
        return channelPickup;
    }
    public static boolean isOdd (String shortName) {
        boolean isReallyOdd = false;
        for (int i = 0; i < CHANNELNAMES.length; i++){
            if (CHANNELNAMES [i] [0] == shortName && CHANNELNAMES [i] [3] == "odd") {
                isReallyOdd = true;
                }
            }
        return isReallyOdd;
    }

}