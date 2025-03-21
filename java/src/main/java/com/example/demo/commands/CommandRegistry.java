
// package com.example.demo.commands;

// import java.util.HashMap;
// import java.util.Map;

// public class CommandRegistry {
//     private static final Map<String, ICommand> commands = new HashMap<>();

//     public void registerCommand(String commandKeyword, ICommand command) {
//         commands.putIfAbsent(commandKeyword, command);
//     }

//     public void invokeCommand(String input) {
//         String[] tokens = input.split(" ");
//         ICommand command = commands.get(tokens[0]);
//         if (command != null) {
//             command.invoke(List.of(tokens));
//         } else {
//             System.out.println("INVALID COMMAND");
//         }
//     }
// }















package com.example.demo.commands;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CommandRegistry {
    private static final Map<String, ICommand> commands = new HashMap<>();

    public void registerCommand(String commandKeyword, ICommand command) {
        commands.putIfAbsent(commandKeyword,command);
    }

    public void unRegisterCommand(String commandKeyword) {
        commands.remove(commandKeyword);
    }

    // private ICommand get(String commandName){
    //     return commands.get(commandName);
    // }

    // private List<String> parse(String input){
    //     return Arrays.stream(input.split(" ")).collect(Collectors.toList());
    // }




    // public void invokeCommand(String input) {
    //     String[] tokens = input.split(" ");
    //     ICommand command = commands.get(tokens[0]);
    //     if (command != null) {
    //         command.invoke(List.of(tokens));
    //     } else {
    //         System.out.println("INVALID COMMAND");
    //     }


    public void invokeCommand(String input) {
        String[] tokens = input.split(" ");
        ICommand command = commands.get(tokens[0]);
        
        if (command != null) {

            try {
                command.invoke(Arrays.asList(tokens));
            } catch (Exception e) {
                System.out.println("Error executing command: " + e.getMessage());
            }
        } else {
            System.out.println("INVALID COMMAND");
        }
    }
}
    







    // public void invokeCommand(String input) {
    //     List<String> tokens = parse(input);
    //     ICommand command = get(tokens.get(0));
    //     if(command == null){
    //         // Handle Exception
    //         throw new RuntimeException("INVALID COMMAND 🛑");
    //     } 
    //     command.invoke(tokens);
    //     return;
    // }

 