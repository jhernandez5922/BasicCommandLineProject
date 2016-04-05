/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152_project1.Commands;

import csci152_project1.Directory;
import csci152_project1.SystemFile;

/**
 *
 * @author Jason
 */
public class CreateCommand implements BaseCommand {
    private static final String DESCRIPTION = "create <filename> <size> - create a new file in the current"
            + " directory. Its name will be filename, and the size attribute of "
            + "the file will be the 2nd command line arg ";
    private String COMMAND = "create";

    @Override
    public Object execute(Object... params) {
       if (params.length > 2 && params[0] instanceof Directory) {
            Directory current = (Directory) params[0];
            current.add(new SystemFile(current, String.valueOf(params[1]), Integer.valueOf((String) params[2])));
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
