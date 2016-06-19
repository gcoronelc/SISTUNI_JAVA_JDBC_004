package pe.egcc.eurekaapp.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import pe.egcc.eurekaapp.db.AccesoDB;

/**
 *
 * @author Gustavo Coronel
 */
public class CuentaService {

  public double conSaldo(String cuenta){
    Connection cn = null;
    Double saldo = null;
    try {
      // Conexión con la BD
      cn = AccesoDB.getConnection();
      // Realiza consulta
      String sql = "{call usp_egcc_saldo_cuenta(?,?)}";
      CallableStatement cstm = cn.prepareCall(sql);
      cstm.setString(1, cuenta);
      cstm.registerOutParameter(2, Types.VARCHAR);
      cstm.executeUpdate();
      String n = cstm.getString(2);
      if( n != null){
        saldo = Double.parseDouble(n);
      }
      cstm.close();
    } catch (Exception e) {
      System.err.println(e.getMessage());
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    if(saldo == null){
      throw new RuntimeException("Cuenta no existe.");
    }
    return saldo;
  }
}
