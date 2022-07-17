package pl.pjatk.adalus.movieservice.movie.service;

import org.springframework.stereotype.Service;
import pl.pjatk.adalus.movieservice.movie.exception.BadInputException;
import pl.pjatk.adalus.movieservice.movie.exception.MovieNotFoundException;
// import pl.pjatk.adalus.movieservice.movie.model.Genre;
import pl.pjatk.adalus.movieservice.movie.model.Movie;
import pl.pjatk.adalus.movieservice.movie.repository.MovieRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
//    private Integer idCounter = 0;

//    private final List<Movie> movies = new ArrayList<>();
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
//        movies.addAll(List.of(new Movie(getIdCounter(), "Avatar", Genre.ACTION, "James Cameron"),
//                new Movie(getIdCounter(), "Lord of the rings 1", Genre.FANTASY, "Peter Jackson")));
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

//    public Integer getIdCounter() {
//        return idCounter++;
//    }

    public Movie getMovieById(Integer id) {
//        for (Movie movie : getMovies()) {
//            if (movie.getId().equals(id)) {
//                return movie;
//            }
//        }
        return movieRepository.findById(id)
                .orElseThrow(MovieNotFoundException::new);
    }

    public void addMovie(Movie movie) {
//        if (movie.getId() != null) {
//            throw new BadInputException();
//        }
//        movie.setId(getIdCounter());
//        movies.add(movie);

        movieRepository.save(movie);
    }

    public void updateMovie(Integer id, Movie movie) {
//        if (getMovieById(id) != null) {
//            movie.setId(id);
//            movies.set(id, movie);
//        }
        if (movieRepository.existsById(id)) {
            movie.setId(id);
            movieRepository.save(movie);
        } else {
            throw new BadInputException();
        }
    }

    public void deleteMovie(Integer id) {
//        movies.remove(getMovieById(id));
        movieRepository.deleteById(id);
    }

    public void makeAvailable(Integer id) {
        Movie movie = movieRepository.getById(id);
        movie.setAvailable(true);
        movieRepository.save(movie);
    }

    public void makeUnavailable(Integer id) {
        Movie movie = movieRepository.getById(id);
        movie.setAvailable(false);
        movieRepository.save(movie);
    }

}
