import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, User> userMap = new HashMap();
    private User currentUser = null;

    public boolean registerUser(String username, String password, String fullName, String contact){
        if(userMap.containsKey(username)){
            System.out.println("Username already exist. Please choose another");
            return false;
        }
        User user = new User(username, password, fullName, contact);
        userMap.put(username, user);
        System.out.println("Registration Successful");
        return true;
    }


}
