/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152_project1.Commands;
/**
 *
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
    
    
    public static CommandsEnum getCommandFromString(String command) {
        for (CommandsEnum c : CommandsEnum.values()) {
            if (c.commandName().equals(command))
                return c;
        }
        return null;
    }
    
    public void execute() {
        this.command.execute();
    }

    public String description() {
        return command.description();
    }
    public String commandName() {
        return command.name();
    }
}
