package User;




import java.io.Serializable;

public class User  implements Serializable{
    private String name, email, user_id, password, type,salt;

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public User(String name, String email, String user_id, String type) {
        this.name = name;
        this.email = email;
        this.user_id = user_id;
        this.password = password;
        this.type = type;
    }
    
    public User() {
        name = "";
        email = ""; 
        user_id = "";
    }
}
