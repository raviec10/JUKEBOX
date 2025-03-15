package com.example.demo.commands;

import java.util.List;
import java.util.stream.Collectors;


import com.example.demo.services.SongService;

public class CreatePlaylistCommand implements ICommand {
    private final SongService songService;

    public CreatePlaylistCommand(SongService songService) {
        this.songService = songService;
    }



    @Override
    public void invoke(List<String> tokens) {
        String name = tokens.get(1);
        List<Long> songIds = tokens.subList(2, tokens.size()).stream()
                .map(Long::parseLong)
                .collect(Collectors.toList());
        songService.createPlaylist(name, songIds);
    }
}


    // @Override
    // public void invoke(List<String> tokens) {
    //     String name = tokens[1];
    //     List<Long> songIds = List.of(tokens).subList(2, tokens.size()).stream()
    //             .map(Long::parseLong)
    //             .toList();
    //     songService.createPlaylist(name, songIds);
    // }
