package com.projects.java.bestoftheyear.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping
public class IndexController {


    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("name", "Paolo");
        return "homepage";
    }

    private List<String> getBestMovies(){
        return List.of("Matrix", "Terminator", "Lo Hobbit");
    }

    private List<String> getBestSongs(){
        return List.of("Without You", "The End", "The Resistance");
    }

    @GetMapping("/movies")
    public String movies(Model model){
        List<String> movies = getBestMovies();
        String movieList = String.join(", ", movies);
        model.addAttribute("movieList", movieList);
        return "movies";
    }

    @GetMapping("/songs")
    public String songs(Model model){
        List<String> songs = getBestSongs();
        String songList = String.join(", ", songs);
        model.addAttribute("songList", songList);
        return "songs";
    }


}
