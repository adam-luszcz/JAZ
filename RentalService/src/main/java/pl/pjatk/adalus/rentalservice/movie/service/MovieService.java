package pl.pjatk.adalus.rentalservice.movie.service;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.adalus.rentalservice.movie.model.Movie;

@Service
public class MovieService {

    final String API_URL = "http://localhost:8080";
    private final RestTemplate restTemplate;

    public MovieService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Movie getMovie(Long id) {
        return restTemplate.getForObject(API_URL + "/movies/" + id, Movie.class);
    }

    public void returnMovie(Long id) {
        restTemplate.put(API_URL + "/movies/available/" + id, null, Void.class);
    }

    public void rentMovie(Long id) {
        restTemplate.put(API_URL + "/movies/unavailable/" + id, null, Void.class);
    }
}
