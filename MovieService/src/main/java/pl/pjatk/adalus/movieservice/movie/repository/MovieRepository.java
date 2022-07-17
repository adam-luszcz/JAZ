package pl.pjatk.adalus.movieservice.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.adalus.movieservice.movie.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
