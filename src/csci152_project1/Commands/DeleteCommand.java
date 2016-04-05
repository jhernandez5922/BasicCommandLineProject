/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152_project1.Commands;

import csci152_project1.Directory;
/**
 *
 * @author Jason
 */
public class DeleteCommand implements BaseCommand {

    private static final String DESCRIPTION = "del <dirname> | <filename> - this will delete the file named"
            + " filename, or it will do a cascading delete in the case of dirname";
    private static final String COMMAND = "del";
    
    /**
     * 
     * @param params [0]: current directory
     *        params [1]: SystemObject to delete
     * @return 
     */
    @Override
    public Object execute(Object... params) {
        if (params.length > 1 && params[0] instanceof Directory 
                && params[1] instanceof String) {
            Directory current = (Directory) params[0];
            return current.remove(String.valueOf(params[1]));
        }
        return false;
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
