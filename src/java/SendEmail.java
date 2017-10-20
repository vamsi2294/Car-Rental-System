
import User.User;
import User.UserDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns={"/SendEmail"})
public class SendEmail extends HttpServlet {
    private String host;
    private String port;
    private String user;
    private String pass;
 
    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }
 
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        // reads form fields
        String recipient = request.getParameter("email");
        String subject = "Your password";
        String content = "Password is:";
        UserDB userdb = new UserDB();
        User usero = new User();
 
        String resultMessage = "";
 
        try {
            usero = userdb.getUser(recipient);
            if(usero!=null){
                content = content+usero.getPassword();
                EmailUtility.sendEmail(host, port, user, pass, recipient, subject,  content);
                resultMessage = "Password was sent to your mail";
            }
            else{
                resultMessage = "Email was not registered";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
        } finally {
            request.setAttribute("Message", resultMessage);
            getServletContext().getRequestDispatcher("/forgotpassword.jsp").forward(
                    request, response);
        }
    }
}

