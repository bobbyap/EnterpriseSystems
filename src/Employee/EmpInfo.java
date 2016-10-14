/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;



import java.sql.*;



/**
 *
 * @author BobbyAP
 */
public class EmpInfo {

    
    public static void main(String[] args) {
        Connection conn = null;
        
        
        Statement state;
        ResultSet rs;
        try {
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://Localhost/Employee", "root", "");
        state=conn.createStatement();
        
       
int test = 5;
PreparedStatement preparedStmt =  conn.prepareStatement(" insert into EmpDetails(LeavePending)  values (?)");
      
      preparedStmt.setInt (1,test);
      // execute the preparedstatement
      preparedStmt.executeUpdate();
      
      
      
        
         rs=state.executeQuery("SELECT * from EmpDetails");
        while (rs.next()) {
        System.out.println(rs.getString(1)+" "+ "|"+rs.getString(2));
        }
        rs.close();
        state.close();
        conn.close();
        } catch (Exception e) {
        System.err.println("Error: " + e);
        }//try
        } // main
        } //class

        
    
    

