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
public class FileSizeCommand implements BaseCommand {

    private static final String DESCRIPTION = "size <dirname> | <filename> - this returns the size attribute"
            + " of a filename; in the case of a directory, it returns the size "
            + "of ALL files and subdirectories";
    private static final String COMMAND = "size";
    
    @Override
    public Object execute(Object... params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
