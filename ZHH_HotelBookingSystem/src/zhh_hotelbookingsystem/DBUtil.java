/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zhh_hotelbookingsystem;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Honghui Zhang
 */
public class DBUtil {
    
    public static Connection conn;
//    public static String url = "jdbc:derby://localhost:1527/HotelDB;create=true";
    public static String url = "jdbc:derby:HotelDB;create=true";
    public static String username = "pdc";
    public static String password = "pdc";
    
    //get connection
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //create table
    public static void createTable(){
        Connection conn = null;
        Statement statement = null;
        String createUserTableSQLString;
        String createRoomTableSQLString;
        String createAdminTableSQLString;
        
        conn = getConnection();
        try {
            statement = conn.createStatement();
            if (!checkTableExisting("UserT")) {
                createUserTableSQLString = "CREATE TABLE UserT (Username VARCHAR(50),Password VARCHAR(50),IDNumber VARCHAR(50),HotelIdentity INT,RoomID VARCHAR(50))";
                statement.executeUpdate(createUserTableSQLString);
            }
            if (!checkTableExisting("RoomT")) {
                createRoomTableSQLString = "CREATE TABLE RoomT (RoomID VARCHAR(50),Floor INT,RoomType VARCHAR(50),Price INT,Wifi INT,HotelWindow INT,Breakfast INT,Capacity INT,Valid INT)";
                statement.executeUpdate(createRoomTableSQLString);
            }
            if (!checkTableExisting("AdminTB")) {
                createAdminTableSQLString = "CREATE TABLE AdminTB (AdminName VARCHAR(50),Gender INT,Department VARCHAR(50),Contact VARCHAR(50))";
                statement.executeUpdate(createAdminTableSQLString);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    //Rgister
    //(Username VARCHAR(50),Password VARCHAR(50),IDNumber VARCHAR(50),HotelIdentity INT,RoomID VARCHAR(50))
    public static void registerUser(String username, String password, String IDnumber, int Hotelidentity, String roomID){
        Connection conn = null;
        Statement statement = null;
        String sqlString;
        
        conn = DBUtil.getConnection();
        try {
            statement = conn.createStatement();
            sqlString = "INSERT INTO UserT VALUES('"+ username +"','"+ password +"','"+ IDnumber +"',"+ Hotelidentity +",'"+ roomID +"')";
            statement.executeUpdate(sqlString);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    //User
    //judge if the room has guest
    public static boolean checkRoomHaveGuest(String roomString){
        Connection conn = null;
        Statement statement = null;
        String sqlString;
        
        conn = DBUtil.getConnection();
        ResultSet rs = null;
        try {
            statement = conn.createStatement();
            sqlString = "SELECT * FROM UserT WHERE RoomID='"+ roomString +"'";
            rs = statement.executeQuery(sqlString);
            Vector<Vector> vector = new Vector<>();
            while (rs.next()) {       
                Vector<String> v = new Vector<>();
                String IdString = rs.getString("IDNumber");
                v.add(IdString);
                vector.add(v);
            }
            if (vector.size() > 0) {
                return true;
            }else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
    
    //User
    //checkOut
    public static void checkOutUser(String roomString){
        Connection conn = null;
        Statement statement = null;
        String editCheckOutSqlString;
        
        conn = DBUtil.getConnection();
        try {
            statement = conn.createStatement();
            editCheckOutSqlString = "UPDATE UserT SET RoomID='null' WHERE RoomID='"+ roomString +"'";
            statement.executeUpdate(editCheckOutSqlString);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    //User
    //checkIn
    public static void checkInUser(String idNumberString, String roomIdString){
        Connection conn = null;
        Statement statement = null;
        String editCheckInSqlString;
        
        conn = DBUtil.getConnection();
        try {
            statement = conn.createStatement();
            editCheckInSqlString = "UPDATE UserT SET RoomID='"+ roomIdString +"' WHERE IDNumber='"+ idNumberString +"'";
            statement.executeUpdate(editCheckInSqlString);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    //User
    //judge if the user exist
    //UserT (Username VARCHAR(50),Password VARCHAR(50),IDNumber VARCHAR(50),HotelIdentity INT,RoomID VARCHAR(50))
    public static boolean  checkUserExist(String idNumberString){
        Connection conn = null;
        Statement statement = null;
        String sqlString;
        
        conn = DBUtil.getConnection();
        ResultSet rs = null;
        try {
            statement = conn.createStatement();
            sqlString = "SELECT * FROM UserT WHERE IDNumber='"+ idNumberString +"'";
            rs = statement.executeQuery(sqlString);
            Vector<Vector> vector = new Vector<>();
            while (rs.next()) {       
                Vector<String> v = new Vector<>();
                String IdString = rs.getString("IDNumber");
                v.add(IdString);
                vector.add(v);
            }
            if (vector.size() > 0) {
                return true;
            }else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
    
    //Room
    //(RoomID VARCHAR(50),Floor INT,RoomType VARCHAR(50),Price INT,Wifi INT,HotelWindow INT,Breakfast INT,Capacity INT,Valid INT)
    public static void addRoom(String roomIDString, int floor, String roomTyString, int price, int wifi, int HotelWindow, int breakfast, int capacity){
        Connection conn = null;
        Statement statement = null;
        String sqlString;
        
        conn = DBUtil.getConnection();
        try {
            statement = conn.createStatement();
            sqlString = "INSERT INTO RoomT VALUES('"+ roomIDString +"',"+ floor +",'"+ roomTyString +"',"+ price +","+ wifi +","+ HotelWindow +","+ breakfast +","+ capacity +",1)";
            statement.executeUpdate(sqlString);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) { 
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    //Room
    //Find out the number of specific rooms available
    public static int searchNumberOfSpecificRooms(String roomtypeString){
        Connection conn = null;
        Statement statement = null;
        String sqlString;
        
        conn = DBUtil.getConnection();
        ResultSet rs = null;
        try {
            statement = conn.createStatement();
            sqlString = "SELECT * FROM RoomT WHERE RoomType='"+ roomtypeString +"' AND Valid=1";
            rs = statement.executeQuery(sqlString);
            Vector<Vector> vector = new Vector<>();
            while (rs.next()) {       
                Vector<String> v = new Vector<>();
                String roomIdString = rs.getString("RoomID");
                v.add(roomIdString);
                vector.add(v);
            }
            return vector.size();
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 0;
    }
    
    //Room
    //Search all room
    //(RoomID VARCHAR(50),Floor INT,RoomType VARCHAR(50),Price INT,Wifi INT,HotelWindow INT,Breakfast INT,Capacity INT,Valid INT)
    public static Vector searchAllRoom(){
        Connection conn = null;
        Statement statement = null;
        String sqlString;
        
        conn = DBUtil.getConnection();
        ResultSet rs = null;
        try {
            statement = conn.createStatement();
            sqlString = "SELECT * FROM RoomT";
            rs = statement.executeQuery(sqlString);
            Vector<Vector> vector = new Vector<>();
            while (rs.next()) {       
                Vector<String> v = new Vector<>();
                String roomIdString = rs.getString("RoomID");
                String floorString = String.valueOf(rs.getInt("Floor"));
                String roomTypeString = rs.getString("RoomType");
                String roomPriceString = String.valueOf(rs.getInt("Price"));
                String roomWifiString = (rs.getInt("Wifi") == 0) ? "×" : "√";
                String roomWindowStrin = (rs.getInt("HotelWindow") == 0) ? "×" : "√";
                String roomBreakfastString = (rs.getInt("Breakfast") == 0) ? "×" : "√";
                String roomCapacity = String.valueOf(rs.getInt("Capacity"));
                String roomValidString = (rs.getInt("Valid") == 0) ? "×" : "√";
                v.add(roomIdString);
                v.add(floorString);
                v.add(roomTypeString);
                v.add(roomPriceString);
                v.add(roomWifiString);
                v.add(roomWindowStrin);
                v.add(roomBreakfastString);
                v.add(roomCapacity);
                v.add(roomValidString);
                vector.add(v);
            }
            return vector;
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }
    
    //Room
    //Judge the room if exist
    public static boolean checkRoomExist(String roomNumberString){
        Connection conn = null;
        Statement statement = null;
        String sqlString;
        
        conn = DBUtil.getConnection();
        ResultSet rs = null;
        try {
            statement = conn.createStatement();
            sqlString = "SELECT * FROM RoomT WHERE RoomID='"+ roomNumberString +"'";
            rs = statement.executeQuery(sqlString);
            Vector<Vector> vector = new Vector<>();
            while (rs.next()) {       
                Vector<String> v = new Vector<>();
                String roomIdString = rs.getString("RoomID");
                String floorString = String.valueOf(rs.getInt("Floor"));
                String roomTypeString = rs.getString("RoomType");
                String roomPriceString = String.valueOf(rs.getInt("Price"));
                String roomWifiString = (rs.getInt("Wifi") == 0) ? "×" : "√";
                String roomWindowStrin = (rs.getInt("HotelWindow") == 0) ? "×" : "√";
                String roomBreakfastString = (rs.getInt("Breakfast") == 0) ? "×" : "√";
                String roomCapacity = String.valueOf(rs.getInt("Capacity"));
                String roomValidString = (rs.getInt("Valid") == 0) ? "×" : "√";
                v.add(roomIdString);
                v.add(floorString);
                v.add(roomTypeString);
                v.add(roomPriceString);
                v.add(roomWifiString);
                v.add(roomWindowStrin);
                v.add(roomBreakfastString);
                v.add(roomCapacity);
                v.add(roomValidString);
                vector.add(v);
            }
            if (vector.size() > 0) {
                return true;
            }else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
    
    //Room
    //Search one room
    public static Vector searchOneRoom(String roomString){
        Connection conn = null;
        Statement statement = null;
        String sqlString;
        
        conn = DBUtil.getConnection();
        ResultSet rs = null;
        try {
            statement = conn.createStatement();
            sqlString = "SELECT * FROM RoomT WHERE RoomID='"+ roomString +"'";
            rs = statement.executeQuery(sqlString);
            Vector<Vector> vector = new Vector<>();
            while (rs.next()) {       
                Vector<String> v = new Vector<>();
                String roomIdString = rs.getString("RoomID");
                String floorString = String.valueOf(rs.getInt("Floor"));
                String roomTypeString = rs.getString("RoomType");
                String roomPriceString = String.valueOf(rs.getInt("Price"));
                String roomWifiString = (rs.getInt("Wifi") == 0) ? "×" : "√";
                String roomWindowStrin = (rs.getInt("HotelWindow") == 0) ? "×" : "√";
                String roomBreakfastString = (rs.getInt("Breakfast") == 0) ? "×" : "√";
                String roomCapacity = String.valueOf(rs.getInt("Capacity"));
                String roomValidString = (rs.getInt("Valid") == 0) ? "×" : "√";
                v.add(roomIdString);
                v.add(floorString);
                v.add(roomTypeString);
                v.add(roomPriceString);
                v.add(roomWifiString);
                v.add(roomWindowStrin);
                v.add(roomBreakfastString);
                v.add(roomCapacity);
                v.add(roomValidString);
                vector.add(v);
            }
            return vector;
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }
    
    //Room
    //Delete one room
    public static void deleteOneRoom(String nameString){
        Connection conn = null;
        Statement statement = null;
        String sqlString;
        
        conn = DBUtil.getConnection();
        try {
            statement = conn.createStatement();
            sqlString = "DELETE FROM RoomT WHERE RoomID='"+ nameString +"'";
            statement.executeUpdate(sqlString);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    //Room
    //Edit room information
    //(RoomID VARCHAR(50),Floor INT,RoomType VARCHAR(50),Price INT,Wifi INT,HotelWindow INT,Breakfast INT,Capacity INT,Valid INT)
    public static void editRoomInformation(String roomNumberString, int roomPriceInt, String roomTypeString, int roomCapacity, int roomWifi, int roomWindow, int roomBreakfast, int roomValid){
        Connection conn = null;
        Statement statement = null;
        String editPriceSqlString;
        String editTypeSqlString;
        String editCapacitySqlString;
        String editWifiSqlString;
        String editWindowSqlString;
        String editBreakfastSqlString;
        String editValidSqlString;
        
        conn = DBUtil.getConnection();
        try {
            statement = conn.createStatement();
            editPriceSqlString = "UPDATE RoomT SET Price="+ roomPriceInt +" WHERE RoomID='"+ roomNumberString +"'";
            editTypeSqlString = "UPDATE RoomT SET RoomType='"+ roomTypeString +"' WHERE RoomID='"+ roomNumberString +"'";
            editCapacitySqlString = "UPDATE RoomT SET Capacity="+ roomCapacity +" WHERE RoomID='"+ roomNumberString +"'";
            editWifiSqlString = "UPDATE RoomT SET Wifi="+ roomWifi +" WHERE RoomID='"+ roomNumberString +"'";
            editWindowSqlString = "UPDATE RoomT SET HotelWindow="+ roomWindow +" WHERE RoomID='"+ roomNumberString +"'";
            editBreakfastSqlString = "UPDATE RoomT SET Breakfast="+ roomBreakfast +" WHERE RoomID='"+ roomNumberString +"'";
            editValidSqlString = "UPDATE RoomT SET Valid="+ roomValid +" WHERE RoomID='"+ roomNumberString +"'";
            
            statement.executeUpdate(editPriceSqlString);
            statement.execute(editTypeSqlString);
            statement.execute(editCapacitySqlString);
            statement.execute(editWifiSqlString);
            statement.execute(editWindowSqlString);
            statement.execute(editBreakfastSqlString);
            statement.execute(editValidSqlString);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    //Login
    //LoginAuthentication
    public static boolean loginAuthentication(String usernameString, String passwordString, int HotelIdentity){
        Connection conn = null;
        Statement statement = null;
        String sqlString;
        
        conn = DBUtil.getConnection();
        ResultSet rs = null;
        try {
            statement = conn.createStatement();
            sqlString = "SELECT Password,HotelIdentity FROM UserT WHERE Username='"+ usernameString +"'";
            rs = statement.executeQuery(sqlString);
            
            while (rs.next()) {                
                String password = rs.getString("Password");
                int idt = rs.getInt("HotelIdentity");
                if (password.equals(passwordString) && idt == HotelIdentity) {
                    return true;
                }else {
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
    
    //Personnel
    //CREATE TABLE AdminTB (AdminName VARCHAR(50),Gender INT,Department VARCHAR(50),Contact VARCHAR(50))
    public static void addPersonnel(String nameString, int genderInt, String departmentString, String contactString){
        Connection conn = null;
        Statement statement = null;
        String sqlString;
        
        conn = DBUtil.getConnection();
        try {
            statement = conn.createStatement();
            sqlString = "INSERT INTO AdminTB VALUES('"+ nameString +"',"+ genderInt +",'"+ departmentString +"','"+ contactString +"')";
            statement.executeUpdate(sqlString);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    //Personnel
    //CREATE TABLE AdminTB (AdminName VARCHAR(50),Gender INT,Department VARCHAR(50),Contact VARCHAR(50))
    public static Vector searchAllPersonnel(){
        Connection conn = null;
        Statement statement = null;
        String sqlString;
        
        conn = DBUtil.getConnection();
        ResultSet rs = null;
        try {
            statement = conn.createStatement();
            sqlString = "SELECT * FROM AdminTB";
            rs = statement.executeQuery(sqlString);
            Vector<Vector> vector = new Vector<>();
            while (rs.next()) {       
                Vector<String> v = new Vector<>();
                String personnelNameString = rs.getString("AdminName");
                String personnelGender = (rs.getInt("Gender") == 0) ? "male" : "female";
                String personnelDepartment = rs.getString("Department");
                String personnelContact = rs.getString("Contact");
                v.add(personnelNameString);
                v.add(personnelGender);
                v.add(personnelDepartment);
                v.add(personnelContact);
                vector.add(v);
            }
            return vector;
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }
    
    //Personnel
    //update the information of internel staff
    //AdminTB (AdminName VARCHAR(50),Gender INT,Department VARCHAR(50),Contact VARCHAR(50))
    public static void editStaffInformation(String oldNameString, String newNameString, int genderInt, String departmentString, String contactString){
        Connection conn = null;
        Statement statement = null;
        String editNameSqlString;
        String editGenderSqlString;
        String editDepartmentSqlString;
        String editContactSqlString;
        
        conn = DBUtil.getConnection();
        try {
            statement = conn.createStatement();
            editNameSqlString = "UPDATE AdminTB SET AdminName='"+ newNameString +"' WHERE AdminName='"+ oldNameString +"'";
            editGenderSqlString = "UPDATE AdminTB SET Gender="+ genderInt +" WHERE AdminName='"+ newNameString +"'";
            editDepartmentSqlString = "UPDATE AdminTB SET Department='"+ departmentString +"' WHERE AdminName='"+ newNameString +"'";
            editContactSqlString = "UPDATE AdminTB SET Contact='"+ contactString +"' WHERE AdminName='"+ newNameString +"'";
            statement.executeUpdate(editNameSqlString);
            statement.execute(editGenderSqlString);
            statement.execute(editDepartmentSqlString);
            statement.execute(editContactSqlString);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    //Personnel
    public static Vector searchOnePersonnel(String nameString){
        Connection conn = null;
        Statement statement = null;
        String sqlString;
        
        conn = DBUtil.getConnection();
        ResultSet rs = null;
        try {
            statement = conn.createStatement();
            sqlString = "SELECT * FROM AdminTB WHERE AdminName='"+ nameString +"'";
            rs = statement.executeQuery(sqlString);
            Vector<Vector> vector = new Vector<>();
            while (rs.next()) {       
                Vector<String> v = new Vector<>();
                String personnelNameString = rs.getString("AdminName");
                String personnelGender = (rs.getInt("Gender") == 0) ? "male" : "female";
                String personnelDepartment = rs.getString("Department");
                String personnelContact = rs.getString("Contact");
                v.add(personnelNameString);
                v.add(personnelGender);
                v.add(personnelDepartment);
                v.add(personnelContact);
                vector.add(v);
            }
            return vector;
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }
    
    //Personnel
    //Delete a internel staff
    public static void deleteOnePersonnel(String nameString){
        Connection conn = null;
        Statement statement = null;
        String sqlString;
        
        conn = DBUtil.getConnection();
        try {
            statement = conn.createStatement();
            sqlString = "DELETE FROM AdminTB WHERE AdminName='"+ nameString +"'";
            statement.executeUpdate(sqlString);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    //Personnel
    //judge the someone if exist
    public static boolean checkOneStuffExist(String nameString){
        Connection conn = null;
        Statement statement = null;
        String sqlString;
        
        conn = DBUtil.getConnection();
        ResultSet rs = null;
        try {
            statement = conn.createStatement();
            sqlString = "SELECT * FROM AdminTB WHERE AdminName='"+ nameString +"'";
            rs = statement.executeQuery(sqlString);
            Vector<Vector> vector = new Vector<>();
            while (rs.next()) {       
                Vector<String> v = new Vector<>();
                String personnelNameString = rs.getString("AdminName");
                String personnelGender = (rs.getInt("Gender") == 0) ? "male" : "female";
                String personnelDepartment = rs.getString("Department");
                String personnelContact = rs.getString("Contact");
                v.add(personnelNameString);
                v.add(personnelGender);
                v.add(personnelDepartment);
                v.add(personnelContact);
                vector.add(v);
            }
            if (vector.size() > 0) {
                return true;
            }else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
    
    //check table existing
    private static boolean checkTableExisting(String tablenameString){
        boolean flag = false;
        try {
            String[] types = {"TABLE"};
            conn = DBUtil.getConnection();
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet resultSet = dbmd.getTables(null, null, null, types);
            
            while (resultSet.next()) {                
                String tableNameString = resultSet.getString("TABLE_NAME");
                if (tableNameString.compareToIgnoreCase(tablenameString) == 0) {
                    System.out.println(tableNameString + " is there");
                    flag = true;
                }
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
        }
        return flag;
    }
}
