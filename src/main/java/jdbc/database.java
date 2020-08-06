/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class database {
    private static final String NAME="ENTER_YOUR_OWN_USERNAME";
    private static final String URL="ENTER_YOUR_OWN_DATABASE_URL";
    private static final String PASSWORD="ENTER_YOUR_OWN_PASSWORD.";
    static{
        try{
            Class.forName("ENTER_YOUR_OWN_DRIVER");//1.loading driver
	} catch (ClassNotFoundException e) {
            e.printStackTrace();
	}
    }
    public static Connection getConnection(){//get connection
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(URL,NAME,PASSWORD);
            System.out.println("Database connected!!");
            return conn;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}

