
import User.User;
import Item.ItemDB;
import Item.Item;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet(urlPatterns={"/ItemController"})
public class ItemController extends HttpServlet {
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doPost(request,response);
           
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        String url = "";
        String action = request.getParameter("action");
        Item item;
        User user;
        ItemDB itemdb = new ItemDB();
       System.out.println(action);
        
        if("additem".equals(action)){
            
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String type = request.getParameter("type");
            int price = Integer.parseInt(request.getParameter("price"));
            InputStream inputStream = null;
             Part filePart = request.getPart("picture");
             System.out.println(111);
             System.out.println(filePart);
             if (filePart != null) {
                 System.out.println("aaa");
                String partname = filePart.getName();
                long partsize = filePart.getSize();
                String contenttype = filePart.getContentType();
                inputStream = filePart.getInputStream();
                    if(partsize<5000000 && ("image/jpeg".equals(contenttype) || contenttype=="image/png")){
                            user = (User) request.getSession().getAttribute("user");
                            int user_id = Integer.parseInt(user.getUser_id());
                            try {
                                itemdb.insertItem(name, description, price, type, inputStream, user_id);
                                url = "/add_item.jsp";
                            } catch (SQLException ex) {
                                Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            url = "/home.jsp";
                    }
                    else{
                        url = "/add_item.jsp";
                        request.setAttribute("message","Item not added");
                    }
            }
             url="/settings.jsp";
                
        }
        
       else if("updateItemStatus".equals(action)){
            int id = Integer.parseInt(request.getParameter("id"));
            try {
                user =(User) request.getSession().getAttribute("user");
                int user_id = Integer.parseInt(user.getUser_id());
                itemdb.updateItemStatus(id,user_id);
                url="/home.jsp";
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    }
        
        
        getServletContext().getRequestDispatcher(url).forward(request,response);
    }
}
