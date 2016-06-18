package pe.egcc.app.prueba;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import oracle.jdbc.oracore.OracleType;
import pe.egcc.app.db.AccesoDB;

/**
 * 
 * @author Gustavo Coronel
 */
public class Prueba06 {

  public static void main(String[] args) {
    Connection cn = null;
    Double saldo = null;
    try {
      cn = AccesoDB.getConnection();
      
      // Validar que la cuenta exista
      
      String sql = "{call usp_egcc_saldo_cuenta(?,?)}";
      CallableStatement cstm = cn.prepareCall(sql);
      cstm.setString(1, "00200011");
      cstm.registerOutParameter(2, Types.VARCHAR);
      cstm.executeUpdate();
      String n = cstm.getString(2);
      if( n != null){
        saldo = Double.parseDouble(n);
      }
      cstm.close();
      System.out.println("Saldo: " + saldo);
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
