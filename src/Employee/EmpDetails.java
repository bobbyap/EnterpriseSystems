/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author BobbyAP
 */
public class EmpDetails {
 
    


    
    public static void main(String[] args) throws Exception {
    
     Scanner wordScan = new Scanner(EmpDetails.class.getResourceAsStream("Values.txt"));
     
       EmpDetails histogram = new EmpDetails();
    
      List<Integer> empid = new ArrayList<Integer>();
      List<Integer> leavepending = new ArrayList<Integer>();
      
      List<Integer> empidDB = new ArrayList<Integer>();
      List<Integer> leavependingDB = new ArrayList<Integer>();
    
      int  counter1to10 []= new int[10]; 
      
   
      String[]   range  = new String[10];
              range[0] = "1  - 10  |  ";
              range[1] = "11 - 20  |  ";
              range[2] = "21 - 30  |  ";
              range[3] = "31 - 40  |  ";
              range[4] = "41 - 50  |  ";
              range[5] = "51 - 60  |  ";
              range[6] = "61 - 70  |  ";
              range[7] = "71 - 80  |  ";
              range[8] = "81 - 90  |  ";
              range[9] = "91 - 100 |  ";
              
        
        while (wordScan.hasNext())
                {
                 //wordScan.nextInt();
                  
                 empid.add(wordScan.nextInt());
                 leavepending.add(wordScan.nextInt());
                 
                 wordScan.nextLine();
                 
                }
        
         Connection conn = null;
        
        
        Statement state;
        ResultSet rs;
        try {
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://Localhost/Employee", "root", "");
        state=conn.createStatement();
        
       

PreparedStatement preparedStmt =  conn.prepareStatement(" insert into EmpDetails(EmpId,LeavePending)  values (?,?)");
      
int len1=leavepending.size();
        
        for(int i = 0 ; i < len1 ; i++){
     
      preparedStmt.setInt (1,empid.get(i));
      preparedStmt.setInt (2,leavepending.get(i));
      // execute the preparedstatement
      preparedStmt.executeUpdate();
      
      
        }
        
         rs=state.executeQuery("SELECT * from EmpDetails");
         int j =0; 
        while (rs.next()) {
           
            
        empidDB.add(rs.getInt(1));
        leavependingDB.add(rs.getInt(2));
        
        System.out.println(empidDB.get(j)+" "+ "|"+leavependingDB.get(j));
        j++;
        }
        rs.close();
        state.close();
        conn.close();
        } catch (Exception e) {
        System.err.println("Error: " + e);
        }//try
        
        int len=empidDB.size();
        
        System.out.println(leavependingDB.size());
        
        for(int i = 0 ; i < len ; i++){
        
        
        if ( leavependingDB.get(i) < 11)
       
            counter1to10[0]++;
        else if
                ( leavependingDB.get(i) < 21)
            counter1to10[1]++;
        else if
                ( leavependingDB.get(i) < 31)
            counter1to10[2]++;
        else if
                ( leavependingDB.get(i) < 41)
            counter1to10[3]++;
        else if
                ( leavependingDB.get(i) < 51)
            counter1to10[4]++;
        else if
                ( leavependingDB.get(i) < 61)
            counter1to10[5]++;
        else if
                ( leavependingDB.get(i) < 71)
            counter1to10[6]++;
        else if
                ( leavependingDB.get(i) < 81)
            counter1to10[7]++;
        else if
                ( leavependingDB.get(i) < 91)
            counter1to10[8]++;
        else if
                ( leavependingDB.get(i) < 100)
            counter1to10[9]++;
                
        
            
         }
        
        for (int k = 0; k < range.length; k++) {
        String label = range[k] + " : ";
        
        
        System.out.println(label + histogram.convertToHistogram(counter1to10[k]));
        
    }

    }

private String convertToHistogram(int num) {
    StringBuilder builder = new StringBuilder();
    for (int j = 0; j < num; j++) {
        builder.append('*');
    }
    return builder.toString();
        
           
}      
        
         
         
   }

