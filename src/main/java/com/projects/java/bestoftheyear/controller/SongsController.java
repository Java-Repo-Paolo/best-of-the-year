package com.projects.java.bestoftheyear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongsController {

    @GetMapping
    public String songs(Model model){
        List<String> songs = getBestSongs();
        String songList = String.join(", ", songs);
        model.addAttribute("songList", songList);
        return "songs";
    }

    private List<String> getBestSongs(){
        return List.of("Without You", "The End", "The Resistance");
    }
}
