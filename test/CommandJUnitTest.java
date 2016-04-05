/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import csci152_project1.Commands.*;
import csci152_project1.Directory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jason
 */
public class CommandJUnitTest {
    
    ListCommand list;
    MakeDirCommand dir;
    ManualCommand man;
    ChangeDirCommand cd;
    CreateCommand create;
    DeleteCommand delete;
    CurrentPathCommand path;
    public CommandJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        dir = (MakeDirCommand) CommandsEnum.makeDir.command;
        list = (ListCommand) CommandsEnum.list.command;
        man = (ManualCommand) CommandsEnum.manual.command;
        cd = (ChangeDirCommand) CommandsEnum.changeDir.command;
        create = (CreateCommand) CommandsEnum.create.command;
        delete = (DeleteCommand) CommandsEnum.deleteFile.command;
        path = (CurrentPathCommand) CommandsEnum.currentPath.command;
    }
    
    
    @Test
    public void testCommandsExist() {
        System.out.print("Testing Size...");
        int size = CommandsEnum.values().length;
        assertTrue("Expected Size of: 8, Recieved: " + size, size == 8);
        System.out.println("PASSED");
    }   
    
    @Test
    public void testCommandInput() {
        System.out.print("Testing command input...");
        for (CommandsEnum c : CommandsEnum.values()) {
            BaseCommand temp = CommandsEnum.getCommandFromString(c.command.name());
            assertEquals(temp, c);
        }
        System.out.println("PASSED");
        System.out.println("---------------------------------");
    }
    
    @Test
    public void testManualCommand() {
        System.out.println("Testing Manual command...");
        for (CommandsEnum c : CommandsEnum.values()) {
            man.execute(c.command.name());            
        }
        System.out.println("PASSED");
        System.out.println("---------------------------------");
    }
    
    @Test
    public void testListCommand() {
        System.out.println("Testing List command...");
        Directory test = new Directory(null, "Root Folder");
        list.execute(test);
        test.add(new Directory(test, "Sub Folder1"));
        test.add(new Directory(test, "Sub Folder2"));
        System.out.println("Second List Command test...");
        list.execute(test);
        System.out.println("PASSED");
        System.out.println("---------------------------------");
    }
    
    @Test
    public void testChangeDirCommand() {
        System.out.println("Testing Change Directory command...");
        Directory test = new Directory(null, "Root Folder");
        test.add(new Directory(test, "Sub Folder1"));
        test.add(new Directory(test, "Sub Folder2"));
        list.execute(test);
        Directory test2 = (Directory) cd.execute(test, "Sub Folder1");
        System.out.println("Sub Folder1 Directory:");
        list.execute(test2);
        Directory test3 = (Directory) cd.execute(test2, "..");
        System.out.println("Sub Folder1's Parent's Directory:");
        list.execute(test3);
        assertEquals(test3, test);
        System.out.println("PASSED");
        System.out.println("---------------------------------");
    }
    
    
    @Test
    public void testMakeDirCommand() {
        System.out.println("Testing Make Directory command...");
        Directory test = new Directory(null, "Root Folder");
        test.add(new Directory(test, "Sub Folder1"));
        test.add(new Directory(test, "Sub Folder2"));
        dir.execute(test, "Sub Folder3");
        list.execute(test);
        Directory test2 = (Directory) cd.execute(test, "Sub Folder3");
        Directory test3 = (Directory) cd.execute(test2, "..");
        assertEquals(test, test3);
        System.out.println("PASSED");
        System.out.println("---------------------------------");
        
    }
    
    @Test
    public void testCreateCommand() {
        System.out.println("Testing Create File command...");
        Directory test = new Directory(null, "Root Folder");
        test.add(new Directory(test, "Sub Folder1"));
        test.add(new Directory(test, "Sub Folder2"));
        create.execute(test, "testFile", 1024);
        list.execute(test);
        System.out.println("PASSED");
        System.out.println("---------------------------------");
                
    }
    
    @Test
    public void testDeleteCommand() {
        System.out.println("Testing Delete command...");
        Directory test = new Directory(null, "Root Folder");
        test.add(new Directory(test, "Sub Folder1"));
        test.add(new Directory(test, "Sub Folder2"));
        test.add(new Directory(test, "Delete me!"));
        list.execute(test);
        delete.execute(test, "Delete me!");
        System.out.println("Deleted File: New List");
        list.execute(test);
        System.out.println("PASSED");
        System.out.println("---------------------------------");
    }
    
    @Test
    public void testPathCommand() {
        System.out.println("Testing Path command...");
        Directory test = new Directory(null, "Root Folder");
        Directory subTest1 = new Directory(test, "Sub Folder1");
        Directory subTest2 = new Directory(subTest1, "Sub Sub Folder1");
        test.add(subTest1);
        subTest1.add(subTest2);
        test.add(new Directory(test, "Sub Folder2"));
        path.execute(subTest2);
        System.out.println("PASSED");
        System.out.println("---------------------------------");
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
