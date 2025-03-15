package com.example.demo.commands;

import java.util.List;

import com.example.demo.services.SongService;

public class PlaySongCommand implements ICommand {
    private final SongService songService;

    public PlaySongCommand(SongService songService) {
        this.songService = songService;
    }

    @Override
    public void invoke(List<String> tokens) {
        songService.playSong();
    }
}


















// package com.example.demo.commands;

// import com.example.demo.services.songService;

// import java.util.List;

// public class PlaysongCommand implements ICommand {
//     private final songService songService;

//     public PlaysongCommand(songService songService) {
//         this.songService = songService;
//     }

//     @Override
//     public void invoke(List<String> tokens) {
//         songService.playsong();
//     }
// }