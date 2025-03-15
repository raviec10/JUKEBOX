package com.example.demo.commands;

import java.util.List;

import com.example.demo.services.SongService;

public class AddSongToPlaylistCommand implements ICommand {
    private final SongService songService;

    public AddSongToPlaylistCommand(SongService songService) {
        this.songService = songService;
    }

    @Override
    public void invoke(List<String> tokens) {
        String playlistName = tokens.get(1);
        Long songId = Long.parseLong(tokens.get(2));
        songService.addSongToPlaylist(playlistName, songId);
    }
}





















// package com.example.demo.commands;

// import com.example.demo.services.songService;
// import com.example.demo.entities.song;

// import java.util.List;

// public class AddsongToPlaylistCommand implements ICommand {
//     private final songService songService;

//     public AddsongToPlaylistCommand(songService songService) {
//         this.songService = songService;
//     }

//     @Override
//     public void invoke(List<String> tokens) {
//         String playlistName = tokens.get(1);
//         int songId = Integer.parseInt(tokens.get(2));
//         songService.addsongToPlaylist(playlistName, songId);
//     }
// }