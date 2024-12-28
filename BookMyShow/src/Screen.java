import java.util.List;

public class Screen {
    int screenId;
    String screenName;
    List<Seat> allSeats;

    public Screen(int screenId, String screenName){
        this.screenId = screenId;
        this.screenName = screenName;
    }

    public List<Seat> getAllSeats() {
        return allSeats;
    }

    public void setAllSeats(List<Seat> allSeats) {
        this.allSeats = allSeats;
    }
}
