package pl.pjatk.adalus.movieservice.movie.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.adalus.movieservice.movie.model.Movie;
import pl.pjatk.adalus.movieservice.movie.service.MovieService;

import java.util.List;


@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @ApiOperation(value="Get list of all movies")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @GetMapping("")
    public ResponseEntity<List<Movie>> getMovies() {
        return ResponseEntity.ok(movieService.getMovies());
    }

    @ApiOperation(value="Get movie by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Movie not found"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @GetMapping("{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Integer id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @ApiOperation(value="Add new movie")
    @PostMapping("")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return ResponseEntity.ok(movie);
    }

    @ApiOperation(value="Update existing movie")
    @PutMapping("{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Integer id, @RequestBody Movie movie) {
        movieService.updateMovie(id, movie);
        return ResponseEntity.ok(movie);
    }

    @ApiOperation(value="Delete movie by id")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Integer id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value="Make movie available")
    @PutMapping("/available/{id}")
    public ResponseEntity<Void> makeAvailable(@PathVariable Integer id) {
        movieService.makeAvailable(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value="Make movie unavailable")
    @PutMapping("/unavailable/{id}")
    public ResponseEntity<Void> makeUnavailable(@PathVariable Integer id) {
        movieService.makeUnavailable(id);
        return ResponseEntity.ok().build();
    }

}
