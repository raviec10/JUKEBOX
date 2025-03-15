package com.example.demo;

import com.example.demo.commands.CommandRegistry;
import com.example.demo.commands.AddSongCommand;
import com.example.demo.commands.PauseSongCommand;
import com.example.demo.commands.ListSongCommand;
import com.example.demo.commands.CreatePlaylistCommand;
import com.example.demo.commands.LoadPlaylistCommand;
import com.example.demo.commands.PlaySongCommand;
import com.example.demo.commands.NextSongCommand;
import com.example.demo.commands.PreviousSongCommand;
import com.example.demo.commands.StopSongCommand;
import com.example.demo.commands.DeletePlaylistCommand;
import com.example.demo.commands.AddSongToPlaylistCommand;
import com.example.demo.commands.DeleteSongFromPlaylistCommand;
import com.example.demo.repositories.SongRepository;
import com.example.demo.repositories.ISongRepository;
import com.example.demo.services.SongService;

public class Configuration {
    private static Configuration instance = new Configuration();
    private final ISongRepository songRepository = new SongRepository();
    private final SongService songService = new SongService(songRepository);
    private final CommandRegistry commandRegistry = new CommandRegistry();

    private Configuration() {
        registerCommands();
    }

    public static Configuration getInstance() {
        return instance;
    }

    private void registerCommands() {
        commandRegistry.registerCommand("ADD_SONG", new AddSongCommand(songService));
        commandRegistry.registerCommand("LIST_SONGS", new ListSongCommand(songService));
        commandRegistry.registerCommand("CREATE_PLAYLIST", new CreatePlaylistCommand(songService));
        commandRegistry.registerCommand("LOAD_PLAYLIST", new LoadPlaylistCommand(songService));
        commandRegistry.registerCommand("PLAY_SONG", new PlaySongCommand(songService));
        commandRegistry.registerCommand("NEXT_SONG", new NextSongCommand(songService));
        commandRegistry.registerCommand("PREVIOUS_SONG", new PreviousSongCommand(songService));
        commandRegistry.registerCommand("PAUSE_SONG", new PauseSongCommand(songService));
        commandRegistry.registerCommand("STOP_SONG", new StopSongCommand(songService));
        commandRegistry.registerCommand("DELETE_PLAYLIST", new DeletePlaylistCommand(songService));
        commandRegistry.registerCommand("ADD_SONG_TO_PLAYLIST", new AddSongToPlaylistCommand(songService));
        commandRegistry.registerCommand("DELETE_SONG_FROM_PLAYLIST", new DeleteSongFromPlaylistCommand(songService));
    }

    public CommandRegistry getCommandRegistry() {
        return commandRegistry;
    }
}















// package com.example.demo;

// import com.example.demo.commands.CommandKeyword;
// import com.example.demo.commands.CommandRegistry;
// import com.example.demo.commands.AddGreetingCommand;
// import com.example.demo.commands.GetGreetingCommand;
// import com.example.demo.commands.ListGreetingCommand;
// import com.example.demo.repositories.GreetingRepository;
// import com.example.demo.repositories.IGreetingRepository;
// import com.example.demo.services.songService;
// import com.example.demo.commands.*;

// public class Configuration {



//     private static Configuration instance = new Configuration();
//     private final IGreetingRepository greetingRepository = new GreetingRepository();
//     private final songService songService = new songService(greetingRepository);
//     private final CommandRegistry commandRegistry = new CommandRegistry();

//     private Configuration() {
//         registerCommands();
//     }

//     public static Configuration getInstance() {
//         return instance;
//     }

//     private void registerCommands() {
//         commandRegistry.registerCommand("ADD_SONG", new AddGreetingCommand(songService));
//         commandRegistry.registerCommand("LIST_SONGS", new ListGreetingCommand(songService));
//         commandRegistry.registerCommand("CREATE_PLAYLIST", new GetGreetingCommand(songService));
//         commandRegistry.registerCommand("LOAD_PLAYLIST", new LoadPlaylistCommand(songService));
//         commandRegistry.registerCommand("PLAY_SONG", new PlayGreetingCommand(songService));
//         commandRegistry.registerCommand("NEXT_SONG", new NextGreetingCommand(songService));
//         commandRegistry.registerCommand("PREVIOUS_SONG", new PreviousGreetingCommand(songService));
//         commandRegistry.registerCommand("STOP_SONG", new StopGreetingngCommand(songService));
//         commandRegistry.registerCommand("DELETE_PLAYLIST", new DeletePlaylistCommand(songService));
//         commandRegistry.registerCommand("ADD_SONG_TO_PLAYLIST", new AddGreetingToPlaylistCommand(songService));
//         commandRegistry.registerCommand("DELETE_SONG_FROM_PLAYLIST", new DeleteGreetingFromPlaylistCommand(songService));
//     }

//     public CommandRegistry getCommandRegistry() {
//         return commandRegistry;
//     }





//             // Singleton Pattern
//             //create an object of Single Configuration Object
//             // private static Configuration instance = new Configuration();

//             // //make the constructor private so that this class cannot be
//             // //instantiated
//             // private Configuration(){}

//             // //Get the only object available
//             // public static Configuration getInstance(){
//             //     return instance;
//             // }

//     		// // Initialize repositories
//             // private final IGreetingRepository greetingRepository = new GreetingRepository();
    
//             // // Initialize services
//             // private final songService songService = new songService(greetingRepository);

//             // // Initialize commands
//             // private final CreateGreetingCommand createGreetingCommand = new CreateGreetingCommand(songService);
//             // private final ListGreetingCommand listGreetingCommand = new ListGreetingCommand(songService);
//             // private final GetGreetingCommand  getGreetingCommand = new GetGreetingCommand(songService);

//             // // Initialize commandRegistery
//             // private final CommandRegistry commandRegistry = new CommandRegistry();

//             // // Register commands 
//             // private void registerCommands(){
//             //     commandRegistry.registerCommand(CommandKeyword.CREATE_GREETING_COMMAND.getName(),createGreetingCommand);
//             //     commandRegistry.registerCommand(CommandKeyword.LIST_GREETING_COMMAND.getName(),listGreetingCommand);
//             //     commandRegistry.registerCommand(CommandKeyword.GET_GREETING_COMMAND.getName(),getGreetingCommand);
//             // }
            
//             // public CommandRegistry getCommandRegistry(){
//             //     registerCommands();
//             //     return commandRegistry;
//             // }
// }
