package nosql.rest.mongo.nosql.controller;

import nosql.rest.mongo.nosql.model.Film;
import nosql.rest.mongo.nosql.repository.FilmRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FilmController {

    @Autowired
    private FilmRepository filmRepository;

    @PostMapping("/addFilm")
    public String saveFilm(@RequestBody Film film) {
        filmRepository.save(film);

        return "Added film with id: " + film.getId();
    }

    @GetMapping("/findAllFilms")
    public List<Film> getFilms() {
        return filmRepository.findAll();
    }

    @GetMapping("/findAllBooks/{id}")
    public Optional<Film> getFilm(@PathVariable ObjectId id) {
        return filmRepository.findById(id);
    }

    @DeleteMapping("/deleteFilm/{id}")
    public  String deleteBook(@PathVariable ObjectId id) {
        filmRepository.deleteById(id);
        return "Film deleted with id: " + id;
    }
}
