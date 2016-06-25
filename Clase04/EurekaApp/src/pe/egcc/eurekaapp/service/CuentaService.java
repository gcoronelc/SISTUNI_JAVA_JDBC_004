package pe.egcc.eurekaapp.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;
import pe.egcc.eurekaapp.db.AccesoDB;
import pe.egcc.eurekaapp.domain.Cuenta;

/**
 *
 * @author Gustavo Coronel
 */
public class CuentaService {

  public double conSaldo(String cuenta) {
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
      if (n != null) {
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
    if (saldo == null) {
      throw new RuntimeException("Cuenta no existe.");
    }
    return saldo;
  }

  public Map<String, Object> getDatosCuenta(String codigo) {
    Map<String, Object> datos = null;
    Connection cn = null;
    try {
      // Conexión con la BD
      cn = AccesoDB.getConnection();
      // Realiza consulta
      String sql = "select c.dec_cuensaldo saldo, "
              + "m.vch_monedescripcion moneda "
              + "from moneda m "
              + "join cuenta c on m.chr_monecodigo = c.chr_monecodigo "
              + "where  chr_cuencodigo = ?";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, codigo);
      ResultSet rs = pstm.executeQuery();
      if(rs.next()){
        datos = new HashMap<>();
        datos.put("moneda",rs.getString("moneda"));
        datos.put("saldo",rs.getString("saldo"));
      }
      rs.close();
      pstm.close();
    } catch (Exception e) {
      String texto = "ERROR: No se tiene acceso al servidor.";
      if(e != null && ! e.getMessage().isEmpty()){
        texto += "\n" + e.getMessage();
      }
      throw new RuntimeException(texto);
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return datos;
  }
}
