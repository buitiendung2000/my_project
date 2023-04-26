/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import constance.Constance;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class ConnectData {
    private  Connection conn=null;

    public ConnectData(){
        conn = ConnectionUtil.getConnection(Constance.DB_URL, Constance.USER_NAME, Constance.PASSWORD);
          
   }
    public  int excuteInsertQuerydata(String sqlinsert){
        try {        
             Statement stmt = conn.createStatement();          
          try{
             int ketqua= stmt.executeUpdate(sqlinsert);
               if(ketqua==0){
                 return 0;
               }else{
                 return 1;
                }
          }catch(SQLException e){
              return 2;         
          }
           
         } catch (SQLException ex) {
           
             return 2;         
         }
        
    }
    public  boolean excuteDeleteQuerydata(String sqldel){
        try {
            Statement stmt = conn.createStatement();      
             int ketqua= stmt.executeUpdate(sqldel);
                  if(ketqua==0){
                 return false;
               }else{
                 return true;
                }         
         } catch (SQLException ex) {          
             return false;         
         }      
    }
    public  boolean excuteUpdateQuerydata(String sqlupdate){
        try {
           
             Statement stmt = conn.createStatement();          
          try{
             int ketqua= stmt.executeUpdate(sqlupdate);
                 return ketqua != 0;
          }catch(SQLException e){
              return false;         
          }          
         } catch (SQLException ex) {          
             return false;         
         }    
    }
    public  ResultSet excuteQuerydata(String sqlselect){
        try {
          
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlselect);
            return rs;    
        } catch (SQLException ex) {
             return null;  
           
        }
   } 
    
}
