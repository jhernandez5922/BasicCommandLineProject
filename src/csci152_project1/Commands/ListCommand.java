/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152_project1.Commands;

import csci152_project1.Directory;
import csci152_project1.SystemFile;
import csci152_project1.SystemObject;

/**
 * Lists the current directory or the children of the given directory or the size of the file
 * depending on the input
 * @author Jason
 */
public class ListCommand implements BaseCommand {

    private static final String DESCRIPTION = "ls <dirname> | <filename> - in the case of filename, this will "
            + "print the name of the file and its size; in the case of dirname, "
            + "it will list all of the files/sizes in the named directory; it is "
            + "NOT cascading; if no parameter is given, default to current directory";
    private static final String COMMAND = "ls";
    @Override
    public Object execute(Object... params) {
        if (params[0] instanceof Directory) {
            Directory current = (Directory) params[0];
            if (params[1] instanceof Directory)
                current.printChildren();
            else {
                SystemObject obj = current.getIfExists(params[1].toString());
                if (obj instanceof SystemFile)
                    System.out.println(((SystemFile) obj).getSize());
                else if (obj instanceof Directory)
                    ((Directory) obj).printChildren();
            }
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
