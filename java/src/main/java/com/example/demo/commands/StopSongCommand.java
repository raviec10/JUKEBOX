package com.example.demo.commands;

import java.util.List;

import com.example.demo.services.SongService;

public class StopSongCommand implements ICommand {
    private final SongService songService;

    public StopSongCommand(SongService songService) {
        this.songService = songService;
    }

    @Override
    public void invoke(List<String> tokens) {
        songService.stopSong();
    }
}













// package com.example.demo.commands;

// import com.example.demo.services.songService;

// import java.util.List;

// public class StopsongngCommand implements ICommand {
//     private final songService songService;

//     public StopsongngCommand(songService songService) {
//         this.songService = songService;
//     }

//     @Override
//     public void invoke(List<String> tokens) {
//         songService.stopsong();
//     }
// }