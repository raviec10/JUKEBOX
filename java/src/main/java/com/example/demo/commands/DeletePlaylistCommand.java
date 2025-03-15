package com.example.demo.commands;

import java.util.List;

import com.example.demo.services.SongService;

public class DeletePlaylistCommand implements ICommand {
    private final SongService songService;

    public DeletePlaylistCommand(SongService songService) {
        this.songService = songService;
    }

    @Override
    public void invoke(List<String> tokens) {
        String name = tokens.get(1);
        songService.deletePlaylist(name);
    }
}




















// package com.example.demo.commands;

// import com.example.demo.services.songService;

// import java.util.List;

// public class DeletePlaylistCommand implements ICommand {
//     private final songService songService;

//     public DeletePlaylistCommand(songService songService) {
//         this.songService = songService;
//     }

//     @Override
//     public void invoke(List<String> tokens) {
//         String playlistName = tokens.get(1);
//         songService.deletePlaylist(playlistName);
//     }
// }