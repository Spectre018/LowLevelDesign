import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {
    Map<CityName, List<Theatre>> cityVsTheatre;
    List<Theatre> allTheatre;

    public TheatreController(){
        this.cityVsTheatre = new HashMap<>();
        this.allTheatre = new ArrayList<>();
    }

    public void addTheatre(CityName city, Theatre theatre){
        List<Theatre> allTheatreByCity = cityVsTheatre.getOrDefault(city, new ArrayList<>());
        allTheatreByCity.add(theatre);
        cityVsTheatre.put(city,allTheatreByCity);
        allTheatre.add(theatre);
    }

    public Map<Theatre, List<Show>> getAllShows(Movie movie, CityName city){
        Map<Theatre, List<Show>> allShows = new HashMap<>();
        List<Theatre> allTheatres =cityVsTheatre.getOrDefault(city, new ArrayList<>());
        for(Theatre theatre : allTheatres){
            List<Show> givenMovieShow = new ArrayList<>();
            for(Show show : theatre.getAllShows()){
                if(show.getMovie().getMovieName().equals(movie.getMovieName())){
                    givenMovieShow.add(show);
                }
            }
            if(!givenMovieShow.isEmpty()){
                allShows.put(theatre,givenMovieShow);
            }
        }
        return allShows;
    }
}
