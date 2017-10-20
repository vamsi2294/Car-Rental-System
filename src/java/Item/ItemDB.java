package Item;


import Item.Item;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDB {
    public int item_id, price;
    public String name, description, type;
    public InputStream inputstream;
    
    public void insertItem(String name, String description, int price, String type , InputStream input, int user_id) throws SQLException, ClassNotFoundException{
    
        Connection conn = CommonUtils.getConnection();                               
         String sql = "insert into items(name,price,description,item_type,user_id,image) values(?,?,?,?,?,?)";
         PreparedStatement ps=conn.prepareStatement(sql);     
         ps.setString(1, name);
         ps.setInt(2, price);
         ps.setString(3, description);
         ps.setString(4, type);
         ps.setInt(5, user_id);
         ps.setBlob(6, input);
         ps.executeUpdate();
         conn.close();
    }
    
    public List<Item> getItems(String user_id) throws SQLException, ClassNotFoundException{
        Connection conn = CommonUtils.getConnection();                               
         String sql = "select item_id, name, price, description, item_type from items where user_id!=(?) and buyer=0 and status=1";
         PreparedStatement ps=conn.prepareStatement(sql);     
         ps.setString(1, user_id);
         ResultSet rs=ps.executeQuery();
         List<Item> itemList=new ArrayList<Item>();
         Item item = null;
         while(rs.next()){
                item = new Item();
                item.setItem_id(rs.getInt(1));
                item.setName(rs.getString(2));
                item.setPrice(rs.getInt(3));
                item.setDescription(rs.getString(4));
                item.setItem_type(rs.getString(5));
                itemList.add(item);
            }
        conn.close();
        return itemList;
    }
     public List<Item> getAllItems() throws SQLException, ClassNotFoundException{
        Connection conn = CommonUtils.getConnection();                               
         String sql = "select item_id, name, price, description, item_type from items where status=0";
         PreparedStatement ps=conn.prepareStatement(sql);     
         ResultSet rs=ps.executeQuery();
         List<Item> itemList=new ArrayList<Item>();
         Item item = null;
         while(rs.next()){
                item = new Item();
                item.setItem_id(rs.getInt(1));
                item.setName(rs.getString(2));
                item.setPrice(rs.getInt(3));
                item.setDescription(rs.getString(4));
                item.setItem_type(rs.getString(5));
                itemList.add(item);
            }
        conn.close();
        return itemList;
    }
    public void updateItemStatus(int id,int user_id) throws SQLException, ClassNotFoundException{
        Connection conn = CommonUtils.getConnection();                               
         String sql = "UPDATE items SET buyer=(?) WHERE item_id=(?)";
         PreparedStatement ps=conn.prepareStatement(sql);     
         ps.setInt(1, user_id);
         ps.setInt(2, id);
         ps.executeUpdate();
         conn.close();
    }
    
    public List<Item> getCartItems(int user_id) throws SQLException, ClassNotFoundException{
        Connection conn = CommonUtils.getConnection();
         String sql1 = "select item_id, name, price, description, item_type, image from items where buyer=(?)";
         PreparedStatement ps1=conn.prepareStatement(sql1);     
         ps1.setInt(1, user_id);
         ResultSet rs=ps1.executeQuery();
       
         List<Item> cartItemsList=new ArrayList<Item>();
         Item item = null;
         while(rs.next()){
              item = new Item();
                item.setItem_id(rs.getInt(1));
                item.setName(rs.getString(2));
                item.setPrice(rs.getInt(3));
                item.setDescription(rs.getString(4));
                item.setItem_type(rs.getString(5));
                Blob blob = rs.getBlob("image");
                item.setBlob(blob);
                int blobLength = (int) blob.length();  
                byte[] imageData = blob.getBytes(1, blobLength);
                item.setImageData(imageData);
                cartItemsList.add(item);
         }
        conn.close();
        return cartItemsList;
    }
    
    public void removeItemFromCart(int item_id) throws SQLException, ClassNotFoundException{
        Connection conn = CommonUtils.getConnection();
         String sql1 = "UPDATE items SET buyer=0 WHERE item_id=(?)";
         PreparedStatement ps1=conn.prepareStatement(sql1);     
         ps1.setInt(1, item_id);
         ps1.executeUpdate();
         conn.close();
    }
    
    public List<Item> userItems(int user_id) throws ClassNotFoundException, SQLException{
        Connection conn = CommonUtils.getConnection();                               
         String sql = "select item_id, name, price, description, item_type,status from items where user_id=(?)";
         PreparedStatement ps=conn.prepareStatement(sql);     
         ps.setInt(1, user_id);
         ResultSet rs=ps.executeQuery();
         List<Item> itemList=new ArrayList<Item>();
         Item item = null;
         while(rs.next()){
                item = new Item();
                item.setItem_id(rs.getInt(1));
                item.setName(rs.getString(2));
                item.setPrice(rs.getInt(3));
                item.setDescription(rs.getString(4));
                item.setItem_type(rs.getString(5));
                item.setStatus(rs.getInt(6));
                itemList.add(item);
            }
        conn.close();
        return itemList;
    }
    
     public void deleteItem(int item_id) throws SQLException, ClassNotFoundException{
        Connection conn = CommonUtils.getConnection();
          String sql1 = "DELETE FROM items WHERE item_id=(?)";
         PreparedStatement ps1=conn.prepareStatement(sql1);     
         ps1.setInt(1, item_id);
         ps1.executeUpdate();
         conn.close();
    }
     
     public void approveItem(int item_id) throws SQLException, ClassNotFoundException{
        Connection conn = CommonUtils.getConnection();
          String sql1 = "UPDATE items SET status=1 WHERE item_id=(?)";
         PreparedStatement ps1=conn.prepareStatement(sql1);     
         ps1.setInt(1, item_id);
         ps1.executeUpdate();
         conn.close();
    }
}
