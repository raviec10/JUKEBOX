package com.example.demo.commands;

import java.util.List;

import com.example.demo.services.SongService;

public class DeleteSongFromPlaylistCommand implements ICommand {
    private final SongService songService;

    public DeleteSongFromPlaylistCommand(SongService songService) {
        this.songService = songService;
    }

    @Override
    public void invoke(List<String> tokens) {
        String playlistName = tokens.get(1);
        Long songId = Long.parseLong(tokens.get(2));
        songService.deleteSongFromPlaylist(playlistName, songId);
    }
}













// package com.example.demo.commands;

// import com.example.demo.services.songService;

// import java.util.List;

// public class DeletesongFromPlaylistCommand implements ICommand {
//     private final songService songService;

//     public DeletesongFromPlaylistCommand(songService songService) {
//         this.songService = songService;
//     }

//     @Override
//     public void invoke(List<String> tokens) {
//         String playlistName = tokens.get(1);
//         int songId = Integer.parseInt(tokens.get(2));
//         songService.deletesongFromPlaylist(playlistName, songId);
//     }
// }