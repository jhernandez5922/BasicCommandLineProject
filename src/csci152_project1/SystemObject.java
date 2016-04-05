/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152_project1;

/**
 * Base System Object for navigating the file system.
 * @author Jason
 */
public abstract class SystemObject {

    protected Directory parent;
    protected String name;
    
    public SystemObject() {
        this(null, null);
    }
    
    public SystemObject(Directory parent, String name) {
        this.parent = parent;
        //if invalid folder name, it will revert to default
        if (name == null || name.length() < 1)
            name = "";
        this.name = name;
    }
    
    public void print() {
        System.out.println(name + "\t");
    }
    
    
    public Directory getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }
}
