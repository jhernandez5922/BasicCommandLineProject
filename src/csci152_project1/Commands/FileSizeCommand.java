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
 *
 * @author Jason
 */
public class FileSizeCommand implements BaseCommand {

    private static final String DESCRIPTION = "size <dirname> | <filename> - this returns the size attribute"
            + " of a filename; in the case of a directory, it returns the size "
            + "of ALL files and subdirectories";
    private static final String COMMAND = "size";
    
    @Override
    public Object execute(Object... params) {
        if (params.length > 2) {
            if (params[0] instanceof Directory) {
                Directory current = (Directory) params[0];
                SystemObject obj = current.getIfExists(params[1].toString());
                if (obj instanceof SystemFile) {
                    SystemFile file = (SystemFile) obj;
                    System.out.println("Size of " + file.getName() + " is: "+ file.getSize());
                }
                else if (obj instanceof Directory) {
                    Directory sizeCheck = (Directory) obj;
                    sizeCheck.printSize();
                }
            }
            
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
