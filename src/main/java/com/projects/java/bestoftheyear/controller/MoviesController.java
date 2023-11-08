package com.projects.java.bestoftheyear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MoviesController {
    @GetMapping
    public String movies(Model model){
        List<String> movies = getBestMovies();
        String movieList = String.join(", ", movies);
        model.addAttribute("movieList", movieList);
        return "movies";
    }


    // METODI PRIVATE
    private List<String> getBestMovies(){
        return List.of("Matrix", "Terminator", "Lo Hobbit");
    }

}
