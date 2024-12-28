public class Movie {
    private final int movieId;
    private String movieName;
    private MovieGenere movieGenere;
    private int duration;

    public Movie(int movieId, String movieName, MovieGenere movieGenere, int duration){
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieGenere = movieGenere;
        this.duration = duration;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public MovieGenere getMovieGenere() {
        return movieGenere;
    }

    public int getDuration() {
        return duration;
    }
}
