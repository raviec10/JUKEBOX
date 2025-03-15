package com.example.demo.commands;

import java.util.List;

import com.example.demo.services.SongService;

public class PreviousSongCommand implements ICommand {
    private final SongService songService;

    public PreviousSongCommand(SongService songService) {
        this.songService = songService;
    }

    @Override
    public void invoke(List<String> tokens) {
        songService.previousSong();
    }
}















// package com.example.demo.commands;

// import com.example.demo.services.songService;

// import java.util.List;

// public class PrevioussongCommand implements ICommand {
//     private final songService songService;

//     public PrevioussongCommand(songService songService) {
//         this.songService = songService;
//     }

//     @Override
//     public void invoke(List<String> tokens) {
//         songService.previoussong();
//     }
// }