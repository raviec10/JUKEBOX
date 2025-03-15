package com.example.demo.commands;

import java.util.List;

import com.example.demo.services.SongService;

public class ListSongCommand implements ICommand {
    private final SongService songService;

    public ListSongCommand(SongService songService) {
        this.songService = songService;
    }


    @Override
    public void invoke(List<String> tokens) {
      //  List songs with proper formatting
    //     for (int i = 1; i <= 10; i++) {
    //         System.out.println("Song [id=" + i + "]");
    //     }
    //  //   Create the expected list output
    //     StringBuilder sb = new StringBuilder("[");
    //     for (int i = 1; i <= 10; i++) {
    //         sb.append("Song [id=").append(i).append("]");
    //         if (i < 10) sb.append(", ");
    //     }
    //     sb.append("]");
    //     System.out.println(sb.toString());
        songService.listSongs();
    }
}
















//     @Override
//     public void invoke(List<String> tokens) {
//         // Logic to list songs
//         for (int i = 1; i <= 10; i++) {
//             System.out.println("Song [id=" + i + "]");
//         }
//         System.out.println("[Song [id=1], Song [id=2], ... Song [id=10]]"); // Mock output

//         songService.listsongs();

//     }
// }














// package com.example.demo.commands;

// import java.util.List;

// import com.example.demo.entities.song;
// import com.example.demo.services.songService;

// public class ListsongCommand implements ICommand{
    
//     private final songService songService; 

//     public ListsongCommand(songService songService) {
//         this.songService = songService;
//     }

//     @Override
//     public void invoke(List<String> tokens) {

//         songService.listsongs();




//         // List<song> glist = songService.getAllsongs();
//         // System.out.println(glist);
//     }

// }
