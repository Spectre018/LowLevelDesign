import java.util.ArrayList;
import java.util.List;

public class Show {
    int showId;
    int showTime;
    Screen screen;
    Movie movie;
    List<Integer> listOfBookedSeats;

    public Show(int showId, int showTime, Movie movie, Screen screen){
        this.showId = showId;
        this.showTime = showTime;
        this.movie = movie;
        this.screen = screen;
    }

    public int getShowTime() {
        return showTime;
    }

    public void setShowTime(int showTime) {
        this.showTime = showTime;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<Integer> getListOfBookedSeats() {
        if(listOfBookedSeats==null){
            return new ArrayList<>();
        }
        return listOfBookedSeats;
    }

    public void setListOfBookedSeats(List<Integer> listOfBookedSeats) {
        this.listOfBookedSeats = listOfBookedSeats;
    }
}
