
package travel.manegment.system;

import java.sql.*;


public class Conn {
    
    Statement s;
    Conn()
    {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travel_managment_system" , "root" ,"Gre@tmind112002");
            s = c.createStatement();
            
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
