import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookMyShow {
    MovieController movieController;
    TheatreController theatreController;

    public BookMyShow(){
        this.movieController = new MovieController();
        this.theatreController = new TheatreController();
    }
    public static void main(String[] args) {
        BookMyShow bms = new BookMyShow();
        bms.initialize();

        bms.createBooking(CityName.Delhi, "Bahubali");
        bms.createBooking(CityName.Mumbai, "Don");
    }

    private void initialize(){
        // add movie
        // add theatres
        // add screens
        // add seats
        // add shows
        addMovies();
        addTheatres();
    }


    public void createBooking(CityName city, String movieName){
        //get all movies by city
        List<Movie>  listOfMovies = movieController.cityVsMovie.get(city);
        Movie selectedMovie = null;
        for(Movie movie : listOfMovies){
            if(movie.getMovieName().equals(movieName)){
                selectedMovie = movie;
                break;
            }
        }

        // get loist of theatres and shows for selected movie
        Map<Theatre,List<Show>> listOfTheatresAndShows = theatreController.getAllShows(selectedMovie, city);

        //4. select the particular show user is interested in
        Map.Entry<Theatre,List<Show>> entry = listOfTheatresAndShows.entrySet().iterator().next();
        List<Show> runningShows = entry.getValue();
        Show interestedShow = runningShows.get(0);


        // select seat
        int seatNumber = 30;
        List<Integer> selectedSeats = new ArrayList<>();
//        interestedShow.setListOfBookedSeats(new ArrayList<>());
        selectedSeats = interestedShow.getListOfBookedSeats();
        int totalPrice = 0;
        if(!selectedSeats.contains(seatNumber)){
            selectedSeats.add(seatNumber);
            Booking booking = new Booking();

            List<Seat> bookedSeats = new ArrayList<>();

            for(Seat screenSeat : interestedShow.getScreen().allSeats){
                if(screenSeat.getSeatId() == seatNumber){
                    bookedSeats.add(screenSeat);
                    totalPrice = totalPrice + screenSeat.getPrice();
                }
            }

            booking.setShow(interestedShow);
            booking.setBookedSeat(bookedSeats);

        }else{
            System.out.println("Booking Unsuccessful");
        }
        Payment payment = new Payment(1,totalPrice, PaymentMode.CARD);
        payment.completePayment();
        System.out.println("Booking Successful");
    }

    private void addMovies(){
//        MovieController movieController = new MovieController();

        Movie movie1 = new Movie(1, "Bahubali", MovieGenere.PERIOD, 130);
        List<Movie> listOfMoviesInDelhi = movieController.cityVsMovie.getOrDefault(CityName.Delhi,new ArrayList<>());
        listOfMoviesInDelhi.add(movie1);
        movieController.cityVsMovie.put(CityName.Delhi,listOfMoviesInDelhi);
        movieController.allMovies.add(movie1);

        Movie movie2 = new Movie(2, "Don", MovieGenere.THRILL, 120);
        List<Movie> listOfMoviesInMumbai = movieController.cityVsMovie.getOrDefault(CityName.Mumbai,new ArrayList<>());
        listOfMoviesInMumbai.add(movie2);
        movieController.cityVsMovie.put(CityName.Mumbai,listOfMoviesInMumbai);
        movieController.allMovies.add(movie2);
    }

    private void addTheatres(){
//        TheatreController theatreController = new TheatreController();
        Movie bahubali = movieController.getMovieByName("Bahubali");
        Movie don = movieController.getMovieByName("Don");


        Theatre pvr = new Theatre(1, "PVR");
        pvr.setAllScreens(addScreens());
        List<Show> pvrShows = new ArrayList<>();
        Show pvrMorningShow = addShows(1, 8, bahubali,pvr.getAllScreens().get(0));
        Show pvrAfternoonShow = addShows(2, 12, bahubali,pvr.getAllScreens().get(0));
        Show pvrEveningShow = addShows(3, 16, bahubali,pvr.getAllScreens().get(0));
        pvrShows.add(pvrMorningShow);
        pvrShows.add(pvrAfternoonShow);
        pvrShows.add(pvrEveningShow);
        pvr.setAllShows(pvrShows);

        Theatre cinepolis = new Theatre(1, "CINEPOLIS");
        cinepolis.setAllScreens(addScreens());
        Show cinepolisMorningShow = addShows(4, 9, don,cinepolis.getAllScreens().get(0));
        Show cinepolisAfternoonShow = addShows(5, 13, don,cinepolis.getAllScreens().get(0));
        Show cinepolisEveningShow = addShows(6, 17, don,cinepolis.getAllScreens().get(0));
        List<Show> cinepolisShows = new ArrayList<>();
        cinepolisShows.add(cinepolisMorningShow);
        cinepolisShows.add(cinepolisAfternoonShow);
        cinepolisShows.add(cinepolisEveningShow);
        cinepolis.setAllShows(cinepolisShows);


        theatreController.addTheatre(CityName.Delhi, pvr);
        theatreController.addTheatre(CityName.Mumbai, pvr);
        theatreController.addTheatre(CityName.Hyderabad, pvr);
        theatreController.addTheatre(CityName.Delhi, cinepolis);
        theatreController.addTheatre(CityName.Mumbai, cinepolis);
        theatreController.addTheatre(CityName.Hyderabad, cinepolis);


    }

    private Show addShows(int showId, int startTime, Movie movie, Screen screen){

        return new Show(showId, startTime, movie, screen);
    }

    private List<Screen> addScreens(){
        List<Screen> allScreens = new ArrayList<>();
        Screen screen1 = new Screen(1, "Audi_1");
        screen1.setAllSeats(addSeats());
        Screen screen2 = new Screen(2, "Audi_2");
        screen2.setAllSeats(addSeats());
        Screen screen3 = new Screen(3,"Audi_3");
        screen3.setAllSeats(addSeats());
        allScreens.add(screen1);
        allScreens.add(screen2);
        allScreens.add(screen3);
        return allScreens;
    }

    private List<Seat> addSeats(){
        List<Seat> allSeats = new ArrayList<>();
        for(int i=1;i<=40;i++){
            Seat seat = new Seat(i,SeatType.SILVER,100);
            allSeats.add(seat);
        }

        for(int i=41;i<=70;i++){
            Seat seat = new Seat(i,SeatType.SILVER,200);
            allSeats.add(seat);
        }

        for(int i=71;i<=100;i++){
            Seat seat = new Seat(i,SeatType.SILVER,300);
            allSeats.add(seat);
        }
        return allSeats;
    }
}