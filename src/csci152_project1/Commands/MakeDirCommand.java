/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152_project1.Commands;

import csci152_project1.Directory;

/**
 * Makes a new directory at the given directory
 * @author Jason
 */
public class MakeDirCommand implements BaseCommand {

    private static final String DESCRIPTION = "mkdir <dirname> - add a new sub-directory, called dirname,"
            + " to the current directory";
    
    private static final String COMMAND = "mkdir";
    
    /**
     *  
     * 
     * 
     * @param params [0]: current directory
     *        params [1]: new directory name
     * @return 
     */
    @Override
    public Object execute(Object... params) {
        if (params.length > 1 && params[0] instanceof Directory
                && params[1] instanceof String) {
            Directory current = (Directory) params[0];
            current.add(new Directory(current, String.valueOf(params[1])));
            return true;
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
