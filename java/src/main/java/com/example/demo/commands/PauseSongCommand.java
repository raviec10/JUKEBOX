package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.SongService;

public class PauseSongCommand implements ICommand {
    private final SongService songService;

    public PauseSongCommand(SongService songService) {
        this.songService = songService;
    }

    @Override
    public void invoke(List<String> tokens) {
        songService.pauseSong();
    }
}