package com.example.demo.commands;

import java.util.List;

import com.example.demo.services.SongService;

// public class AddsongCommand implements ICommand {
//     private final songService songService;

//     public AddsongCommand(songService songService) {
//         this.songService = songService;
//     }

//     @Override
//     public void invoke(List<String> tokens) {
//         songService.addsong();
//     }
// }



import com.example.demo.entities.Song;


public class AddSongCommand implements ICommand{

    private final SongService songService; 

    public AddSongCommand(SongService songService) {
        this.songService = songService;
    }


    @Override
    public void invoke(List<String> tokens) {

        String title = tokens.get(1);
        String artist = tokens.get(2);
        String album = tokens.get(3);
        String genre = tokens.get(4);
        songService.addSong(title, artist, album, genre);
    }

}









    // @Override
    // public void invoke(List<String> tokens) {



    //      // Validate the number of tokens
    //      if (tokens.size() < 5) {
    //         System.out.println("Invalid command syntax. Usage: CREATE_song <message>");
    //         return;
    //     }



    //     String message = tokens.get(1);

    //     // List<Integer> songIds = new ArrayList<>();
    //     // for (int i = 2; i < tokens.size(); i++) {
    //     //     songIds.add(Integer.parseInt(tokens.get(i)));
    //     // }
    //     // songService.createPlaylist(message, songIds);



    //     try {
    //         song createGreet = songService.create(message);
    //         System.out.println(createGreet);
    //     } catch (Exception e) {
    //         System.out.println("Error creating song: " + e.getMessage());
    //     }

        

    //     // song createGreet = songService.create(message);
    //     // System.out.println(createGreet);
    // }
    

