package com.projects.java.bestoftheyear.controller;

import com.projects.java.bestoftheyear.model.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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


    // METODI PRIVATE
    private List<Movie> getBestMovies(){
        Movie[] moviesArray = {
            new Movie(1, "Matrix"),
            new Movie(2, "Terminator"),
            new Movie(3, "Lo Hobbit")};
        return Arrays.asList(moviesArray);
    }

}
