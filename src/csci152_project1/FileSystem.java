/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152_project1;

import csci152_project1.Commands.CommandsEnum;
import csci152_project1.Commands.CurrentPathCommand;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Jason
 */
public class FileSystem {
    
    Directory root;
    Directory current;
    FileSystem() {
        root = new Directory(null, "root");
        current = root;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        FileSystem system = new FileSystem();
        while (true) {
            System.out.print(CurrentPathCommand.directoryBuilder(system.current, new StringBuilder("Jason@jsonOS J:"))+":");
            String input = in.nextLine();
            String[] values = input.split(" ");
            CommandsEnum command = CommandsEnum.getCommandFromString(values[0]);
            ArrayList<Object> params = new ArrayList<>();
            params.add(system.current);
            for (String v : values) {
                if (v.equals(values[0]))
                    continue;
                params.add(v);
            }
            params.add(system.root);
            if (command != null) {
                Object result = command.command.execute(params.toArray());
                if (result instanceof Directory) {
                    system.current = (Directory) result;
                }
            } else {
                System.out.println(values[0] + " is not recognized. If lost, please use the command 'man man' for help");
            }
        }
    }
    
}
