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
    
    //add to directory
    public void add(SystemObject obj) {
        currentDir.put(obj.getName(), obj);
    }
 
    //prints all system objects tied to this directory
    public void printChildren() {
        for (SystemObject obj : currentDir.values()) {
            obj.print();
        }
    }    

    //grabs a children if it exists
    public SystemObject getIfExists(String dest) {
        return currentDir.get(dest);
    }

    //removes from list
    public boolean remove(String key) {
        SystemObject removed = currentDir.remove(key);
        return removed.name.equals(key);
    }

    //prints cumlative size of folder
    public void printSize() {
        int sum = 0;
        for (SystemObject child : currentDir.values()) {
           if (child instanceof SystemFile)
               sum += ((SystemFile) child).getSize();
       }
       System.out.println("Size of Folder: " + sum);
    }
}
