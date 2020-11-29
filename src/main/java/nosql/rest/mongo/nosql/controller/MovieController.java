package nosql.rest.mongo.nosql.controller;

import nosql.rest.mongo.nosql.model.Movie;
import nosql.rest.mongo.nosql.model.fields.ProductionCompany;
import nosql.rest.mongo.nosql.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
        return movieRepository.findById(id);
    }

    @GetMapping("/findMoviesBetterThan/{rate}")
    public List<Movie> getMoviesBetterThen(@PathVariable double rate) {
        List<Movie> movies = movieRepository.findAll();
        List<Movie> moviesBetterThan = new ArrayList<>();
        for (Movie m : movies) {
            if (m.getVote_average() > rate) {
                moviesBetterThan.add(m);
            }
        }

        return moviesBetterThan;
    }

    @GetMapping("/getAllProductionCompanies")
    public Set<ProductionCompany> getAllProductionCompanies() {
        List<Movie> movies = movieRepository.findAll();
        Set<ProductionCompany> productionCompanies = new HashSet<>();
        for (Movie m : movies) {
            productionCompanies.addAll(m.getProduction_companies());
        }

        return productionCompanies;
    }

    @PutMapping("/updateMovieById/{id}")
    public String updateMovieById(@PathVariable int id, @RequestBody Movie movie) {
        try {
            Movie actualMovie = movieRepository.findById(id).orElseThrow();
            movieRepository.delete(actualMovie);
            movieRepository.save(movie);

            return "Update movie with id " + id;
        } catch (Exception ex) {
            return "Movie with id " + id + " not found";
        }
    }

    @DeleteMapping("/deleteMovie/{id}")
    public String deleteBook(@PathVariable int id) {
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
