/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152_project1;
import java.util.HashMap;


/**
 *
 * @author Jason
 */
public class Directory extends SystemObject {
    
    private HashMap<String, SystemObject> currentDir;
    
    public Directory() {
        super();
        currentDir = new HashMap<>();
    }
    
    public Directory(Directory parent, String name) {
        super(parent, name);
        if (this.name.equals(""))
            this.name = "New Folder";
        currentDir = new HashMap<>();
    }
    
    public void add(SystemObject obj) {
        currentDir.put(obj.getName(), obj);
    }
 
    public void printChildren() {
        for (SystemObject obj : currentDir.values()) {
            obj.print();
        }
    }    

    public SystemObject getIfExists(String dest) {
        SystemObject obj = currentDir.get(dest);
        if (obj instanceof Directory) {
            return (Directory) obj;
        }
        else {
            //TODO print error message
            return null;
        }
    }

    public boolean remove(String key) {
        SystemObject removed = currentDir.remove(key);
        return removed.name.equals(key);
    }
}
