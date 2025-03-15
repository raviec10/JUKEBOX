package com.example.demo.commands;

import java.util.List;

import com.example.demo.services.SongService;

public class NextSongCommand implements ICommand {
    private final SongService songService;

    public NextSongCommand(SongService songService) {
        this.songService = songService;
    }

    @Override
    public void invoke(List<String> tokens) {
        songService.nextSong();
    }
}














// package com.example.demo.commands;

// import com.example.demo.services.songService;

// import java.util.List;

// public class NextsongCommand implements ICommand {
//     private final songService songService;

//     public NextsongCommand(songService songService) {
//         this.songService = songService;
//     }

//     @Override
//     public void invoke(List<String> tokens) {
//         songService.nextsong();
//     }
// }