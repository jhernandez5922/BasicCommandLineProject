/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152_project1;

import csci152_project1.Commands.BaseCommand;
import csci152_project1.Commands.CommandsEnum;
import csci152_project1.Commands.CurrentPathCommand;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Jason
 */
public class CommandLine {
    
    Directory root;
    Directory current;
    CommandLine() {
        root = new Directory(null, "root");
        current = root;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        CommandLine system = new CommandLine();
        while (true) {
            //Print out directory and fake host
            System.out.print(CurrentPathCommand.directoryBuilder(system.current, new StringBuilder("Jason@jsonOS J:"))+":");
            //read in input
            String input = in.nextLine();
            //split values
            String[] values = input.split(" ");
            //extract command
            BaseCommand command = CommandsEnum.getCommandFromString(values[0]);
            ArrayList<Object> params = new ArrayList<>();
            //Build parameters
            params.add(system.current);
            for (int i = 0; i < values.length; i++) {
                if (i == 0)
                    continue;
                params.add(values[i]);
            }
            params.add(system.root);
            //execute if not null
            if (command != null) {
                Object result = command.execute(params.toArray());
                if (result instanceof Directory) {
                    system.current = (Directory) result;
                }
            //print error if null
            } else {
                System.out.println(values[0] + " is not recognized. If lost, please use the command 'man help' for help");
            }
        }
    }
    
}
