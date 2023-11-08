package com.projects.java.bestoftheyear.controller;

import com.projects.java.bestoftheyear.model.Movie;
import com.projects.java.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongsController {

    @GetMapping
    public String songs(Model model){
        List<Song> songList = getBestSongs();
        model.addAttribute("songList", songList);
        return "songs";
    }

    @GetMapping("/{id}")
    public String SongDetails(@PathVariable("id") int movieId, Model model) {
        Song song = getSongById(movieId);
        model.addAttribute("song", song);
        return "song-details";
    }

    // METODI PRIVATE
    private List<Song> getBestSongs(){
        Song[] songsArray = {
            new Song(
                    1,
                    "Without You",
                    "Avicii",
                    "Without You è un singolo del DJ svedese Avicii, pubblicato l'11 agosto 2017 " +
                              "come primo estratto dal terzo EP Avīci (01)."
            ),
            new Song(
                    2,
                    "The End",
                    "Linkin Park",
                    "In the End è un singolo del gruppo musicale statunitense Linkin Park, " +
                              "pubblicato l'11 settembre 2001 come quarto estratto dal primo " +
                              "album in studio Hybrid Theory"
            ),
            new Song(
                    3,
                    "The Resistance",
                    "Skillet",
                    "singolo degli Skillet del 2016 dell'album Unleashed"
            )
        };
        return Arrays.asList(songsArray);
    }

    private Song getSongById(int id) {
        for (Song song : getBestSongs()) {
            if (song.getId() == id) {
                return song;
            }
        }
        return null;
    }
}
