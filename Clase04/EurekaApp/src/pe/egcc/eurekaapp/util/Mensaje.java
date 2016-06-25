package pe.egcc.eurekaapp.util;

import java.awt.Component;
import java.awt.TrayIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo Coronel
 */
public final class Mensaje {

  private Mensaje() {
  }
  
  public static void errorMsg(Component parent, String message){
    JOptionPane.showMessageDialog(parent, message, 
            "EUREKA ERROR", JOptionPane.ERROR_MESSAGE);
  }
  
  public static void infoMsg(Component parent, String message){
    JOptionPane.showMessageDialog(parent, message, 
            "EUREKA INFO", JOptionPane.INFORMATION_MESSAGE);
  }
  
}
