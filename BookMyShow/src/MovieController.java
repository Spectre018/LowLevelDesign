import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
    Map<CityName, List<Movie>> cityVsMovie;
    List<Movie> allMovies;

    public MovieController(){
        this.cityVsMovie = new HashMap<>();
        this.allMovies = new ArrayList<>();
    }

    public Movie getMovieByName(String movieName){
        for(Movie movie : allMovies){
            if(movie.getMovieName().equals(movieName)){
                return movie;
            }
        }
        return null;
    }

    public List<Movie> getMoviesByCity(CityName cityName){
        return cityVsMovie.get(cityName);
    }
}
