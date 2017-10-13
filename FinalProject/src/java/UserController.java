
import User.UserDB;
import User.User;
import Item.ItemDB;
import Item.Item;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static org.apache.tomcat.util.codec.binary.Base64.encodeBase64String;
@WebServlet(urlPatterns={"/UserController"})

public class UserController extends HttpServlet {
    
    UserDB userdb = new UserDB();
    User user = new User();
    Item item;
    ItemDB itemdb = new ItemDB();
    
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
        
        if(action.equals("signup")){
            String name = (String) request.getParameter("name");
            String email = (String) request.getParameter("email");
            String address = (String) request.getParameter("address");
            String password = (String) request.getParameter("password");
            String salt = PasswordUtil.getSalt();
            System.out.println(name);
            try {
                password = PasswordUtil.hashPassword(password+salt);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                userdb.insertDetails(name, email, address, password,salt);
                request.setAttribute("success","success");
                url = "/login.jsp";
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if(action.equals("login")){
            String email = (String) request.getParameter("email");
            String password = (String) request.getParameter("password");
            try {
                user = userdb.getUser(email);
                password = PasswordUtil.hashPassword(password+user.getSalt());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                user = userdb.getUser(email);
                if(user!=null && user.getPassword().equals(password)){
                    List<Item> itemsList=null;
                    if(user.getType().equals("user")){
                        url = "/home.jsp";
                        System.out.println("entering");
                        request.getSession().setAttribute("user",user);
                        itemsList = itemdb.getItems(user.getUser_id());
                    }
                    else{
                        url = "/admin.jsp";
                        request.getSession().setAttribute("user",user);
                        itemsList = itemdb.getAllItems();
                    }
                    if(itemsList!=null){
                        request.getSession().setAttribute("itemsList",itemsList);
                    }
                }
                else{
                    url = "/login.jsp";
                    request.setAttribute("success","invalid");
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if(action.equals("home")){
            user = (User) request.getSession().getAttribute("user");
            List<Item> itemsList=null;
            try {
                if(user!=null){
                    itemsList = itemdb.getItems(user.getUser_id());
                }
                url = "/home.jsp";
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(itemsList!=null){
            request.setAttribute("itemsList",itemsList);
            }
            
        }
        
        else if(action.equals("logout")){
            request.getSession().invalidate();
            url="/login.jsp";
        }
        
        else if(action.equals("update")){
            String password = request.getParameter("password");
            System.out.println(password);
            user = (User) request.getSession().getAttribute("user");
            String email = user.getEmail();  
            System.out.println(email);
            try {
                userdb.updatePassword(email, password);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("message","Password updated");
            if("admin".equals(user.getType())){
                url = "/admin_settings.jsp";
            }
            else{
                url = "/settings.jsp";
            }
        }
        
        else if(action.equals("cart")){
            user = (User) request.getSession().getAttribute("user");
            List<Item> cartItemsList=null;
            try {
                if(user!=null){
                    int user_id = Integer.parseInt(user.getUser_id());
                    cartItemsList = itemdb.getCartItems(user_id);
                }
                url = "/cart.jsp";
                request.setAttribute("cartItemsList",cartItemsList);
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
               
        }
        
        else if(action.equals("useritems")){
             user = (User) request.getSession().getAttribute("user");
            List<Item> itemsList=null;
            try {
                if(user!=null){
                    int user_id = Integer.parseInt(user.getUser_id());
                    itemsList = itemdb.userItems(user_id);
                }
                url = "/items.jsp";
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(itemsList!=null){
            request.setAttribute("itemsList",itemsList);
            }
            
        }
        
        else if(action.equals("adminitems")){
             user = (User) request.getSession().getAttribute("user");
            List<Item> itemsList=null;
            try {
                if(user!=null){
                    int user_id = Integer.parseInt(user.getUser_id());
                    itemsList = itemdb.userItems(user_id);
                }
                url = "/items.jsp";
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(itemsList!=null){
            request.setAttribute("itemsList",itemsList);
            }
            
        }
        
        else if(action.equals("admin")){
            user = (User) request.getSession().getAttribute("user");
            List<Item> itemsList=null;
            try {
                if(user!=null){
                    itemsList = itemdb.getAllItems();
                }
                url = "/admin.jsp";
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(itemsList!=null){
            request.setAttribute("itemsList",itemsList);
            }
            
        }
        
        else if(action.equals("sendmessage")){
            user = (User) request.getSession().getAttribute("user");
            int user_id = Integer.parseInt(user.getUser_id());
            String subject = (String) request.getParameter("subject");
            String description = (String) request.getParameter("description");
            try {
                userdb.sendMessage(user_id, subject, description);
                url="/settings.jsp";
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println(url);
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}
