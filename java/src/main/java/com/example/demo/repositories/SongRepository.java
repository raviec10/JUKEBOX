package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.demo.entities.Song;

public class SongRepository implements ISongRepository {
    private final Map<Long, Song> songMap;
    private long autoIncrement = 1;

    public SongRepository() {
        songMap = new HashMap<>();
    }
       


    @Override
    public Song save(Song song) {
        // Ensure that the song is not null and has valid data
    if (song == null) {
        throw new IllegalArgumentException("song fields cannot be null");
    }
        
        // Assign an auto-incremented ID to the song
    // Song newsong = new Song(song.getId(), autoIncrement);
    // songMap.put(autoIncrement, newsong);
    // autoIncrement++;
    Song newSong = new Song(autoIncrement++, song.getTitle(), song.getArtist(), song.getAlbum(), song.getGenre());
        songMap.put(newSong.getId(), newSong);  // Add the new song to the map
        return newSong;

    }
        

    @Override
    public boolean existsById(Long id) {
        return songMap.containsKey(id);
    }

    @Override
    public Optional<Song> findById(Long id) {
        return Optional.ofNullable(songMap.get(id));
    }

    @Override
    public void deleteById(Long id) {
        songMap.remove(id);
    }

    @Override
    public long count() {
        return songMap.size();
    }
}


























// package com.example.demo.repositories;

// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
// import java.util.Optional;
// import java.util.stream.Collectors;

// import com.example.demo.entities.song;

// public class songRepository implements IsongRepository {

//     private final Map<Long,song> songMap;
//     private long autoIncrement = 1;

//     public songRepository(){
//         songMap = new HashMap<>();
//     }

//     // @Override
//     // public song save(song song) {
//     //     // Ensure that the song is not null and has valid data
//     //     if (song == null) {
//     //         throw new IllegalArgumentException("song fields cannot be null");
//     //     }
        
//     //     // Assign an auto-incremented ID to the song
//     //     song newsong = new song(song.getId(), autoIncrement);
//     //     songMap.put(autoIncrement, newsong);
//     //     autoIncrement++;
//     //     return newsong;
//     // }









//     @Override
//     public song save(song song) {

//         // Ensure that the song is not null and has valid data
//         if (song == null) {
//             throw new IllegalArgumentException("song fields cannot be null");
//         }


//         // Create a new song instance with an auto-incremented ID
//         song g = new song(autoIncrement);
//         songMap.put(autoIncrement,g);
//         ++autoIncrement;
//         return g;
//     }

//     @Override
//     public boolean existsById(Long id) {
//         return songMap.containsKey(id);
//     }

//     @Override
//     public Optional<song> findById(Long id) {
//         return Optional.ofNullable(songMap.get(id));
//     }

//     @Override
//     public List<song> findAll() {
//         return songMap.values().stream().collect(Collectors.toList());
//     }

//     @Override
//     public void deleteById(Long id) {
//         songMap.remove(id);
//     }

//     @Override
//     public long count() {
//         return songMap.size();
//     }
    
// }
