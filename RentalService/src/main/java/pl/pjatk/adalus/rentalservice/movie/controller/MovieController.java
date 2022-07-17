package pl.pjatk.adalus.rentalservice.movie.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.adalus.rentalservice.movie.model.Movie;
import pl.pjatk.adalus.rentalservice.movie.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.getMovie(id));
    }

    @GetMapping("available/{id}")
    public ResponseEntity<Void> returnMovie(@PathVariable Long id) {
        movieService.returnMovie(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("unavailable/{id}")
    public ResponseEntity<Void> rentMovie(@PathVariable Long id) {
        movieService.rentMovie(id);
        return ResponseEntity.ok().build();
    }


}
