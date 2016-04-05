/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152_project1.Commands;
/**
 * This file is used to grab a command from the list and execute it without 
 * the file system knowing which one
 * 
 * The current list is the following:
 *  mkDir
 *  create
 *  changeDir
 *  delete
 *  size
 *  list
 *  pwd
 *  man
 * @author Jason
 */
public enum CommandsEnum {
    makeDir(new MakeDirCommand()),
    create(new CreateCommand()), 
    changeDir(new ChangeDirCommand()),
    deleteFile(new DeleteCommand()),
    fileSize(new FileSizeCommand()),
    list(new ListCommand()),
    currentPath(new CurrentPathCommand()),
    manual(new ManualCommand()),;
    
    
    CommandsEnum(BaseCommand command) {
        this.command = command;
    }
    
    public final BaseCommand command;
    
    //interprets the string and returns the command if value, null otherwise
    public static BaseCommand getCommandFromString(String command) {
        for (CommandsEnum c : CommandsEnum.values()) {
            if (c.command.name().equals(command))
                return c.command;
        }
        return null;
    }
}
