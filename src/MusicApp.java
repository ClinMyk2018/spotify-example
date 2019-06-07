import java.util.List;


public class MusicApp {

    protected double version;
    protected List<Song> playlist;

    public MusicApp(double version, List<Song> playlist) {
        this.version = version;
        this.playlist = playlist;
    }

    public double getVersion() {
        return version;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    public List<Song> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List<Song> playlist) {
        this.playlist = playlist;
    }

    protected String normalize(String name){
        return name.replace(" ", "_");
    }
}
