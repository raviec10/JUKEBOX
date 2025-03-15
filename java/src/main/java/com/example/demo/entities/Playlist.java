package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String id;
    private List<Song> songs;

    public Playlist(String id) {
        this.id = id;
        this.songs = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void removeSong(Long songId) {
        songs.removeIf(song -> song.getId().equals(songId));
    }

    @Override
    public String toString() {
        return "Playlist " + id;
        // return id;
    }
    
}