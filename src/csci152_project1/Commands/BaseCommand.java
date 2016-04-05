/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152_project1.Commands;

/**
 * The interface for every command so that polymorphism can be used
 * @author Jason
 */
public interface BaseCommand {
    
    public Object execute(Object... params);

    public String description();
    
    public String name();
   
}
