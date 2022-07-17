package pl.pjatk.adalus.movieservice.movie.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.pjatk.adalus.movieservice.movie.exception.BadInputException;
import pl.pjatk.adalus.movieservice.movie.exception.MovieNotFoundException;
import pl.pjatk.adalus.movieservice.movie.model.Movie;

@RestControllerAdvice
public class MovieControllerAdvice {

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<Movie> handleMovieNotFoundException(MovieNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @ExceptionHandler(BadInputException.class)
    public ResponseEntity<Movie> handleBadInputException(BadInputException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
