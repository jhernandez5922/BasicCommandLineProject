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
public class ManualCommand implements BaseCommand {

    private static final String DESCRIPTION = "man <command> - prints the description of <command>";
    
    private static final String COMMAND = "man";
    
    @Override
    public Object execute(Object... params) {
        String value;
        if (params[1] instanceof String) {
            value = String.valueOf(params[1]);
        } else { return false; }
        if (value.equals("help"))
            for (CommandsEnum c : CommandsEnum.values())
                System.out.println(c.command.description());
        BaseCommand command = CommandsEnum.getCommandFromString(value);
        if (command != null) {
            System.out.println(command.description());
        }
        return true;
    }

    @Override
    public String description() {
        return DESCRIPTION;
    }

    @Override
    public String name() {
        return COMMAND;
    }
    
    
    
}
