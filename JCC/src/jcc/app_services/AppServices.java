package jcc.app_services;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public static String readFile() throws FileNotFoundException {
        FileInputStream stream = new FileInputStream("app.dat");
        BufferedInputStream buffer = new BufferedInputStream(stream);
        DataInputStream in = new DataInputStream(buffer);
        
        try {
            String credentials = in.readUTF();
            return credentials;
        } catch (IOException ex) {
            Logger.getLogger(AppServices.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {           
                in.close();
                buffer.close();
                stream.close();
            } catch (IOException ex) {
                Logger.getLogger(AppServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void resetFile() throws FileNotFoundException {
        FileOutputStream stream = new FileOutputStream("app.dat");
        BufferedOutputStream buffer = new BufferedOutputStream(stream);
        DataOutputStream out = new DataOutputStream(buffer);
        
        try {
            out.writeUTF("null");
        } catch (IOException ex) {
            Logger.getLogger(AppServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
                buffer.close();
                stream.close();
            } catch (IOException ex) {
                Logger.getLogger(AppServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void writeCredentials(String userName, String password) throws FileNotFoundException {
        FileOutputStream stream = new FileOutputStream("app.dat");
        BufferedOutputStream buffer = new BufferedOutputStream(stream);
        DataOutputStream out = new DataOutputStream(buffer);
        
        StringBuilder strb = new StringBuilder(userName);
        strb.append("-");
        strb.append(password);
        
        try {
            out.writeUTF(strb.toString());
        } catch (IOException ex) {
            Logger.getLogger(AppServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
                buffer.close();
                stream.close();
            } catch (IOException ex) {
                Logger.getLogger(AppServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static boolean isUserRemembered(String credentials) {
        if (credentials != null) {
            String[] data = credentials.split("-");
            if (data.length != 2) {
                return false;
            }
            String userName = data[0];
            String password = data[1];
            if (userName != null && password != null &&
                    !userName.equals("null") && !password.equals("null")) {
                return true;
            }
        }
        return false;
    }
}
