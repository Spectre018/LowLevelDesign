import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private int theatreId;
    private String theatreName;
    private List<Show> allShows;
    private List<Screen> allScreens;

    public Theatre(int theatreId, String theatreName){
        this.theatreId = theatreId;
        this.theatreName = theatreName;
        this.allShows = new ArrayList<>();
        this.allScreens = new ArrayList<>();
    }

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public List<Show> getAllShows() {
        return allShows;
    }

    public void setAllShows(List<Show> allShows) {
        this.allShows = allShows;
    }

    public List<Screen> getAllScreens() {
        return allScreens;
    }

    public void setAllScreens(List<Screen> allScreens) {
        this.allScreens = allScreens;
    }
}
