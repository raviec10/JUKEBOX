package com.example.demo;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.example.demo.commands.CommandRegistry;

public class App {

    public static void main(String[] args) {
        if (args.length != 1){
            throw new RuntimeException("Expected one argument: INPUT_FILE=<file_path>");
        }
        List<String> commandLineArgs = new LinkedList<>(List.of(args));
        run(commandLineArgs);
    }

    public static void run(List<String> commandLineArgs) {
        String inputFile = commandLineArgs.get(0).split("=")[1];
        Configuration conf = Configuration.getInstance();
        CommandRegistry commandRegistry = conf.getCommandRegistry();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                commandRegistry.invokeCommand(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




















/*
 * This Java source file was generated by the Gradle 'init' task.
 */
// package com.example.demo;

// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.util.Arrays;
// import java.util.LinkedList;
// import java.util.List;
// import java.nio.file.Files;
// import java.nio.file.Paths;
// import java.io.IOException;

// import com.example.demo.commands.CommandRegistry;
// import com.example.demo.services.GreetingService;


// public class App {

//     public static void main(String[] args) {

//         if (args.length != 1){
//             throw new RuntimeException("Expected one argument: INPUT_FILE=<file_path>");
//         }
//         List<String> commandLineArgs = new LinkedList<>(Arrays.asList(args));
//         run(commandLineArgs);
//     }

//     public static void run(List<String> commandLineArgs){


//         String inputFile = commandLineArgs.get(0).split("=")[1];
//         Configuration conf = Configuration.getInstance();
//         CommandRegistry commandRegistry = conf.getCommandRegistry();

//         try (BufferedReader br = Files.newBufferedReader(Paths.get(inputFile))) {
//             String line;
//             while ((line = br.readLine()) != null) {
//                 commandRegistry.invokeCommand(line);
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }





        












//         // Configuration conf = Configuration.getInstance();

//         // CommandRegistry commandRegistry = conf.getCommandRegistry();
        
//         // String inputFile = commandLineArgs.get(0).split("=")[1];

//         // try(BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {

//         //     while (true) {
//         //         String line = reader.readLine();
//         //         if (line == null){
//         //             break;
//         //         }
//         //         commandRegistry.invokeCommand(line);
//         //     }

//         // } catch (Exception e) {
//         //     e.printStackTrace();
//         // }
//     }
// }
