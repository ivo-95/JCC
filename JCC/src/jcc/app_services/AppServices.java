package jcc.app_services;

/**
 *
 * @author Ivo
 */
public class AppServices {
    
    public static boolean verifyLogin(String userName, String password) {
        if (userName.equals("dev") && password.equals("dev")) {
            return true;
        }
        return false;
    }
}
