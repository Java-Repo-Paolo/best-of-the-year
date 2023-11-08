package com.projects.java.bestoftheyear.controller;

import com.projects.java.bestoftheyear.model.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/movies")
public class MoviesController {
    @GetMapping
    public String bestMovies(Model model){
        List<Movie> movieList = getBestMovies();
        model.addAttribute("movieList", movieList);
        return "movies";
    }

    @GetMapping("/{id}")
    public String MovieDetails(@PathVariable("id") int movieId, Model model) {
        Movie movie = getMovieById(movieId);
        model.addAttribute("movie", movie);
        return "movie-details";
    }


    // METODI PRIVATE
    private List<Movie> getBestMovies(){
        Movie[] moviesArray = {
            new Movie(
                      1,
                      "Matrix",
                      "Lana Wachowski, Lilly Wachowski",
                      "Matrix (The Matrix) è un film di fantascienza del 1999 in stile cyberpunk " +
                                "scritto e diretto dai fratelli Andy e Larry Wachowski."),
            new Movie(
                      2,
                      "Terminator",
                      "James Cameron",
                      "La trama fantascientifica, scritta da Cameron con Gale Anne Hurd, è incentrata " +
                                "sul personaggio del titolo, un cyborg assassino (Arnold Schwarzenegger) " +
                                "inviato indietro nel tempo dal 2029 al 1984 per uccidere Sarah Connor " +
                                "(Linda Hamilton), il cui figlio un giorno diventerà un salvatore contro le macchine " +
                                "in un futuro postapocalittico. Michael Biehn interpreta Kyle Reese, un soldato del " +
                                "futuro inviato anch'egli indietro nel tempo per proteggere Sarah."),
            new Movie(
                      3,
                      "Lo Hobbit",
                      "Peter Jackson",
                      "Lo Hobbit (The Hobbit) è una trilogia cinematografica fantasy co-prodotta, " +
                                "co-scritta e diretta dal regista neozelandese Peter Jackson, basata sull'omonimo " +
                                "romanzo scritto da J. R. R. Tolkien nel 1937, con diverse parti tratte dalle " +
                                "Appendici de Il ritorno del re, ultimo libro della saga del Il Signore degli  " +
                                "Anelli e da altri scritti. La trilogia è un prequel della trilogia del " +
                                "Il Signore degli Anelli di Jackson, ed è formata da Un viaggio inaspettato (2012), " +
                                "La desolazione di Smaug (2013) e La battaglia delle cinque armate (2014).")};
        return Arrays.asList(moviesArray);
    }

    private Movie getMovieById(int id) {
        for (Movie movie : getBestMovies()) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

}
