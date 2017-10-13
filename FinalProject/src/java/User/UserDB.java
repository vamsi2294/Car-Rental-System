package User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class UserDB {
     String name,email,address,password,id;
     
     public void insertDetails(String name,String email,String address,String password, String salt) throws ClassNotFoundException, SQLException{
         
         Connection conn = CommonUtils.getConnection();                               
         String sql = "insert into Users(name,email,password,address,salt) values(?,?,?,?,?)";
         PreparedStatement ps=conn.prepareStatement(sql);     
         ps.setString(1,name);
         ps.setString(2, email);
         ps.setString(3, password);
         ps.setString(4, address);
         ps.setString(5, salt);
         ps.executeUpdate();
         conn.close();
     }
     
     public User getUser(String email) throws ClassNotFoundException, SQLException{
     
        Connection conn = CommonUtils.getConnection();                               
        String sql = "SELECT name, password, user_id, type,salt FROM Users where email=?";
        PreparedStatement ps=conn.prepareStatement(sql);     
        ps.setString(1, email);
        ResultSet rs=ps.executeQuery();
        User user = null;
         while(rs.next()){
            user = new User();
            user.setPassword(rs.getString(2));
            user.setName(rs.getString(1));
            user.setUser_id(rs.getString(3));
            user.setEmail(email);
            user.setType(rs.getString(4));
            user.setSalt(rs.getString(5));
            }
        conn.close();
        return user;
     }
     
     public void updatePassword(String email, String password) throws ClassNotFoundException, SQLException{
         
            Connection conn = CommonUtils.getConnection();                               
            String sql = "UPDATE Users set password=? WHERE email=?";
            PreparedStatement ps=conn.prepareStatement(sql);     
            ps.setString(1, password);
            ps.setString(2,email);
            ps.executeUpdate();
            conn.close();
     }
     
     public void sendMessage(int user_id,String subject, String description) throws ClassNotFoundException, SQLException{
         
         Connection conn = CommonUtils.getConnection();                               
         String sql = "insert into message(user_id,subject,message) values(?,?,?)";
         PreparedStatement ps=conn.prepareStatement(sql);     
         ps.setInt(1,user_id);
         ps.setString(2, subject);
         ps.setString(3, description);
         ps.executeUpdate();
         conn.close();
     }
     
}
