package pe.egcc.app.prueba;

import java.sql.Connection;
import java.sql.Statement;
import pe.egcc.app.db.AccesoDB;

/**
 *
 * @author Gustavo Coronel
 */
public class Prueba02 {
  
  public static void main(String[] args) {
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      Statement stm = cn.createStatement();
      String sql = "insert into parametro(chr_paracodigo,"
              + "vch_paradescripcion,vch_paravalor,"
              + "vch_paraestado) values('004','Profesor',"
              + "'Gustavo Coronel','ACTIVO')";
      stm.executeUpdate(sql);
      System.out.println("Proceso ok.");
    } catch (Exception e) {
      System.err.println(e.getMessage());
    } finally{
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
  }
}
