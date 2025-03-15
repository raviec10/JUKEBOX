package com.example.demo.commands;

import java.util.List;

import com.example.demo.services.SongService;

public class LoadPlaylistCommand implements ICommand {
    private final SongService songService;

    public LoadPlaylistCommand(SongService songService) {
        this.songService = songService;
    }

    @Override
    public void invoke(List<String> tokens) {
        String name = tokens.get(1);
        songService.loadPlaylist(name);
    }
}











// package com.example.demo.commands;

// import com.example.demo.services.songService;

// import java.util.List;

// public class LoadPlaylistCommand implements ICommand {
//     private final songService songService;

//     public LoadPlaylistCommand(songService songService) {
//         this.songService = songService;
//     }

//     @Override
//     public void invoke(List<String> tokens) {
//         String playlistName = tokens.get(1);
//         songService.loadPlaylist(playlistName);
//     }
// }