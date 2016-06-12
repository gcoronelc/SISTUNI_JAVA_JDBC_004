package pe.egcc.app.prueba;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import pe.egcc.app.db.AccesoDB;

/**
 *
 * @author Gustavo Coronel
 */
public class Prueba03 {

  public static void main(String[] args) {
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      Statement stm = cn.createStatement();
      String sql = "select chr_cliecodigo, vch_cliepaterno, "
              + "vch_cliematerno, vch_clienombre, "
              + "chr_cliedni, vch_clieciudad, "
              + "vch_cliedireccion, vch_clietelefono, "
              + "vch_clieemail from cliente "
              + "where chr_cliecodigo = '00014'";
      ResultSet rs = stm.executeQuery(sql);
      
      if(rs.next()){
        System.out.println("Codigo: " + rs.getString("chr_cliecodigo"));
        System.out.println("Paterno: " + rs.getString("vch_cliepaterno"));
        System.out.println("Materno: " + rs.getString("vch_cliematerno"));
        System.out.println("Nombre: " + rs.getString("vch_clienombre"));
      }
      
      rs.close();
      stm.close();
      System.out.println("Proceso ok.");
    } catch (Exception e) {
      System.err.println(e.getMessage());
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
  }
}
