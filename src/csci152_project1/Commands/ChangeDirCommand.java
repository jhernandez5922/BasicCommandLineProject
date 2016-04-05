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
public class ChangeDirCommand implements BaseCommand {
    private static final String DESCRIPTION = "cd <dirname> | .. - this will change to a subdirectory named"
            + " dirname, or change to the parent directory (in the case of “..”);"
            + " path expressions do not need to be supported";
    private static final String COMMAND = "cd";

    /**
     *  
     * 
     * @param params[0]: current directory
     *        params[1]: user input
     *        params[2]: home directory
     * @return the new directory
     */
    @Override
    public Object execute(Object... params) {
        Directory current;
        if (params.length > 0 && params[0] instanceof Directory)
            current = (Directory) params[0];
        else {
            //TODO print error message
            return null;
        }
        if (params.length > 1) {
            if (params[1] instanceof Directory)
                return (Directory) params[1];
            String dest = String.valueOf(params[1]);
            if (dest.equals(".."))
                return current.getParent();
            return current.getIfExists(dest);
        }
        else {
            //TODO print error message
        }      
        return null;
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
