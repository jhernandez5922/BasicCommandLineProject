/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152_project1;
/**
 *
 * @author Jason
 */
public class SystemFile extends SystemObject {

    private int size;
    public SystemFile(Directory parent, String name, int size) {
        super(parent, name);
        this.size = size;
    }
    
    public int getSize() {
        return size;
    }

    @Override
    public void print() {
        System.out.println(name + "\t" + size);
    }
    
    
}
