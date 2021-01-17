/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zhh_hotelbookingsystem;

import java.sql.Connection;
import java.util.Vector;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Honghui Zhang
 */
public class DBUtilTest {
    
    public DBUtilTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkRoomHaveGuest method, of class DBUtil.
     */
    @Test
    public void testCheckRoomHaveGuest() {
        System.out.println("checkRoomHaveGuest");
        String roomString = "1001";
        boolean expResult = false;
        boolean result = DBUtil.checkRoomHaveGuest(roomString);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of checkUserExist method, of class DBUtil.
     */
    @Test
    public void testCheckUserExist() {
        System.out.println("checkUserExist");
        String idNumberString = "123456";
        boolean expResult = true;
        boolean result = DBUtil.checkUserExist(idNumberString);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of searchNumberOfSpecificRooms method, of class DBUtil.
     */
    @Test
    public void testSearchNumberOfSpecificRooms() {
        System.out.println("searchNumberOfSpecificRooms");
        String roomtypeString = "Standerd Room";
        int expResult = 2;
        int result = DBUtil.searchNumberOfSpecificRooms(roomtypeString);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of checkRoomExist method, of class DBUtil.
     */
    @Test
    public void testCheckRoomExist() {
        System.out.println("checkRoomExist");
        String roomNumberString = "1001";
        boolean expResult = true;
        boolean result = DBUtil.checkRoomExist(roomNumberString);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of checkOneStuffExist method, of class DBUtil.
     */
    @Test
    public void testCheckOneStuffExist() {
        System.out.println("checkOneStuffExist");
        String nameString = "Tom";
        boolean expResult = true;
        boolean result = DBUtil.checkOneStuffExist(nameString);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
