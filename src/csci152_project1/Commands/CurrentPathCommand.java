/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152_project1.Commands;

import csci152_project1.Directory;
import csci152_project1.SystemObject;

/**
 *
 * @author Jason
 */
public class CurrentPathCommand implements BaseCommand {

    private static final String DESCRIPTION = "pwd - prints out the path of the current directory";
    private static final String COMMAND = "pwd";
    
    @Override
    public Object execute(Object... params) {
        if (params[0] instanceof SystemObject) {
            SystemObject obj = (SystemObject) params[0];
            String value = directoryBuilder(obj, new StringBuilder());
            System.out.println(value);
            return value;
        }
        return null;
    }
    
    public static String directoryBuilder(SystemObject current, StringBuilder builder) {
        if (current == null)
            return "/";
        Directory parent = current.getParent();
        if (parent != null) 
           directoryBuilder(parent, builder);
        builder.append("/").append(current.getName());
        return builder.toString();
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
