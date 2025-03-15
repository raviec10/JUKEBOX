package com.example.demo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;  

import com.example.demo.entities.Song;
import com.example.demo.entities.Playlist;
import com.example.demo.repositories.ISongRepository;

public class SongService {
    private final ISongRepository songRepository;
    private final List<Song> songs = new ArrayList<>();
    private final HashMap<String, Playlist> playlists = new HashMap<>();
    private Playlist currentPlaylist;
    private int currentSongIndex = -1;
    private boolean isPaused = false; 
    private boolean lastActionWasNavigation = false;
    // private Song currentSong = null;

    public SongService(ISongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public void addSong(String title, String artist, String album, String genre) {

        Song song = new Song(songRepository.count() + 1, title, artist, album, genre);
        songs.add(song);
        songRepository.save(song);
        System.out.println(song);

    }

    public void listSongs() {
        System.out.println(songs);
    }

    public void createPlaylist(String id, List<Long> songIds) {
        // Extract the numeric part from the id (assuming it's in the format "PLAYLIST_1", "PLAYLIST_2", etc.)
        String numericId = id.replaceAll("\\D+", ""); // Removes all non-numeric characters
    
        Playlist playlist = playlists.get(id); // Retrieve if it exists
        if (playlist == null) {
            // Create a new playlist if it does not exist
            playlist = new Playlist(id);
        } else {
            // Clear existing songs in the playlist if it already exists
            playlists.remove(id);
        }
    
        // Add the songs to the playlist
        for (Long songId : songIds) {
            songRepository.findById(songId).ifPresent(playlist::addSong);
        }
    
        // Update the playlist map with the revised/created playlist
        playlists.put(id, playlist);
    
        // Print the playlist information with the numeric id
        System.out.println("Playlist [id=" + numericId + "]");
    }

    public void loadPlaylist(String id) {
        currentPlaylist = playlists.get(id);
        currentSongIndex = -1;
        isPaused = false;  // Clear any pause state
        if (currentPlaylist != null) {

            System.out.println(playlists.get(id) + " is loaded!"); // Simplified to print Playlist [id=X]
            // System.out.println("Playlist " + id + " is loaded!");
            // playSong(currentPlaylist.getSongs().get(currentSongIndex));  // Start playing the first song
        } else {
            System.out.println(id + " does not exist!");
        }
    }

    // public void playSong() {
    //     if (currentPlaylist == null || currentPlaylist.getSongs().isEmpty()) {
    //         System.out.println("No playlist loaded or playlist is empty.");
    //         return;
    //     }
    
    //     if (currentSongIndex < 0) {
    //         currentSongIndex = 0; // Start with the first song
    //         isPaused = false;
    //         System.out.println(currentPlaylist.getSongs().get(currentSongIndex) + " is playing!");
    //     } else if (isPaused) {
    //         // If paused, display the paused state
    //         System.out.println(currentPlaylist.getSongs().get(currentSongIndex) + " is paused!");
    //     } else {
    //         // If not paused, display as playing
    //         System.out.println(currentPlaylist.getSongs().get(currentSongIndex) + " is playing!");
    //     }
    // }

    public void playSong() {
        if (currentPlaylist == null || currentPlaylist.getSongs().isEmpty()) {
            System.out.println("No playlist loaded or playlist is empty.");
            return;
        }
    
        if (currentSongIndex < 0) {
            currentSongIndex = 0; // Start with the first song
            isPaused = false;
            lastActionWasNavigation = false;
            System.out.println(currentPlaylist.getSongs().get(currentSongIndex) + " is playing!");
        } else if (isPaused && lastActionWasNavigation) {
            // If the last action was navigation, show paused state
            System.out.println(currentPlaylist.getSongs().get(currentSongIndex) + " is paused!");
            lastActionWasNavigation = false; // Reset the navigation flag
        } else if (isPaused) {
            // If simply paused, resume playback
            System.out.println(currentPlaylist.getSongs().get(currentSongIndex) + " is resumed!");
            isPaused = false;
        } else {
            // If already playing, continue playback
            System.out.println(currentPlaylist.getSongs().get(currentSongIndex) + " is playing!");
        }
    }

    // public void nextSong() {
    //     if (currentPlaylist == null || currentPlaylist.getSongs().isEmpty()) {
    //         System.out.println("No playlist loaded or playlist is empty.");
    //         return;
    //     }

    //     if (currentSongIndex < currentPlaylist.getSongs().size() - 1) {
    //         currentSongIndex++;
    //         System.out.println(currentPlaylist.getSongs().get(currentSongIndex) + " is playing!");
    //         isPaused = false;
    //     } else {
    //         System.out.println("No more songs in the playlist.");
    //     }
    // }

    public void nextSong() {
        if (currentPlaylist == null || currentPlaylist.getSongs().isEmpty()) {
            System.out.println("No playlist loaded or playlist is empty.");
            return;
        }
    
        if (currentSongIndex < currentPlaylist.getSongs().size() - 1) {
            currentSongIndex++;
            isPaused = true; // Ensure the song state is paused
            lastActionWasNavigation = true; // Track navigation action
            System.out.println(currentPlaylist.getSongs().get(currentSongIndex) + " is playing!");
        } else {
            System.out.println("No more songs in the playlist.");
        }
    }

    // public void previousSong() {
    //     if (currentPlaylist == null || currentPlaylist.getSongs().isEmpty()) {
    //         System.out.println("No playlist loaded or playlist is empty.");
    //         return;
    //     }

    //     if (currentSongIndex > 0) {
    //         currentSongIndex--;
    //         System.out.println(currentPlaylist.getSongs().get(currentSongIndex) + " is playing!");
    //         isPaused = false;
    //     } else {
    //         System.out.println("No previous song to play.");
    //     }
    // }

    public void previousSong() {
        if (currentPlaylist == null || currentPlaylist.getSongs().isEmpty()) {
            System.out.println("No playlist loaded or playlist is empty.");
            return;
        }
    
        if (currentSongIndex > 0) {
            currentSongIndex--;
            isPaused = true; // Ensure the song state is paused
            lastActionWasNavigation = true; // Track navigation action
            System.out.println(currentPlaylist.getSongs().get(currentSongIndex) + " is playing!");
        } else {
            System.out.println("No previous song to play.");
        }
    }

    public void pauseSong() {
        if (currentPlaylist == null || currentSongIndex < 0) {
            System.out.println("No song is playing to pause.");
            return;
        }

        if (!isPaused) {
            System.out.println(currentPlaylist.getSongs().get(currentSongIndex) + " is paused!");
            isPaused = true;
        } else {
            System.out.println("The song is already paused.");
        }
    }

    public void stopSong() {
        if (currentPlaylist == null || currentSongIndex < 0) {
            System.out.println("No song is playing to stop.");
            return;
        }

        System.out.println(currentPlaylist.getSongs().get(currentSongIndex) + " is stopped!");
        currentSongIndex = -1;
        isPaused = false;
    }

    public void deletePlaylist(String id) {
        playlists.remove(id);
        System.out.println("Playlist " + id + " is deleted!");
    }

    public void addSongToPlaylist(String playlistid, Long songId) {
        Playlist playlist = playlists.get(playlistid);
        if (playlist != null) {
            songRepository.findById(songId).ifPresent(playlist::addSong);
            System.out.println("Playlist " + playlistid + " is revised with " + playlist.getSongs());
        }
    }

    public void deleteSongFromPlaylist(String playlistid, Long songId) {
        Playlist playlist = playlists.get(playlistid);
        if (playlist != null) {
            playlist.removeSong(songId);
            System.out.println("Playlist " + playlistid + " is revised with " + playlist.getSongs());
        }
    }
}
