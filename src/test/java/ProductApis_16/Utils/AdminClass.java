package ProductApis_16.Utils;

import org.json.JSONObject;

public class AdminClass {
    public String Username, Password;

    public AdminClass(String username, String password) {
        this.Username = username;
        this.Password = password;
    }

    public JSONObject getJsonForAdminLogin(){
        JSONObject object=new JSONObject();
        object.put("Username",this.Username);
        object.put("Password",this.Password);
        return object;
    }
    @Override
    public String toString() {
        return "userClass{" +
                "Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
