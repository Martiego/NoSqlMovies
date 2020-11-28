package nosql.rest.mongo.nosql.controller;

import nosql.rest.mongo.nosql.model.Movie;
import nosql.rest.mongo.nosql.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @PostMapping("/addMovie")
    public String saveMovie(@RequestBody Movie movie) {
        movieRepository.save(movie);

        return "Added movie with id: " + movie.getId();
    }

    @GetMapping("/findAllMovies")
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/findMovie/{id}")
    public Optional<Movie> getMovie(@PathVariable int id) {
        List<Movie> movies = movieRepository.findAll();
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                return Optional.of(movie);
            }
        }
        return Optional.empty();
    }

    @DeleteMapping("/deleteMovie/{id}")
    public  String deleteBook(@PathVariable int id) {
        List<Movie> movies = movieRepository.findAll();
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                movieRepository.delete(movie);
                return "Movie deleted with id: " + id;
            }
        }
        return "Movie with id " + id + " not found";
    }
}
