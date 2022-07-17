package pl.pjatk.adalus.rentalservice.movie.model;

public class Movie {

    private Integer id;
    private String name;


    private Genre genre;
    private String director;

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
