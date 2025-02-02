
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class DesktopMusicApp extends MusicApp implements Playable {

    private HashMap<Date, Integer> log;
    private Date today = new Date(System.currentTimeMillis());

    public DesktopMusicApp(double version, List<Song> playlist) {
        super(version, playlist);
        // Initializes the HashMap
        this.log = new HashMap<>();
        this.log.put(today, 0);
    }

    // OOP implemented
    @Override
    public String play(Song song) {
        // 1. display the song info
        this.log.put(today, this.log.get(today)+1);

//        this.sing(song);

        // 2. Updating the song info UI
        System.out.println("Title = " + song.getName());

        // 3. return url to stream
        return "//streamer/songs/" + super.normalize(song.getName()) + ".mp3";
    }

    // Exposure to Duration class and time handling
    @Override
    public void pause(Song song) {
        // pauses the song
        System.out.println(song.getName() +" was paused at = " + song.getLength().toMinutesPart()+":"+ song.getLength().toSecondsPart());
    }


    @Override
    public void stop() {
        // stops the song
        System.out.println("stops the song");
        this.printLog();
    }

    // Just for fun, sings the lyrics
    public void sing(Song song){
        try {
            Process process = Runtime.getRuntime().exec(
                    "say -r 150  "+ song.getLyrics());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // How to loop through a HashMap
    public void printLog(){
        for (Date entry: this.log.keySet()) {
            System.out.println(entry + " " + this.log.get(entry));
        }
    }
}
