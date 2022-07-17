package pl.pjatk.adalus.movieservice.movie.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@ApiModel(value="movie", description = "Model containing some general information about given movie")
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Id of a movie", required = true)
    private Integer id;
    @ApiModelProperty(value = "Name of a movie", required = true)
    private String name;

    @Enumerated(EnumType.STRING)
    @ApiModelProperty(value = "Genre of a movie", required = true)
    private Genre genre;
    @ApiModelProperty(value = "Director of a movie", required = true)
    private String director;
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    @ApiModelProperty(value = "Is movie available to rent", required = true)
    private Boolean isAvailable;

    public Movie(Integer id, String name, Genre genre, String director, Boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.director = director;
        this.isAvailable = isAvailable;
    }

    public Movie() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        this.isAvailable = available;
    }
}
