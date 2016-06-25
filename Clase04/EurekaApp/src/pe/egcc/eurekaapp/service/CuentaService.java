package pe.egcc.eurekaapp.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;
import pe.egcc.eurekaapp.db.AccesoDB;

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
      if (rs.next()) {
        datos = new HashMap<>();
        datos.put("moneda", rs.getString("moneda"));
        datos.put("saldo", rs.getString("saldo"));
      }
      rs.close();
      pstm.close();
    } catch (Exception e) {
      String texto = "ERROR: No se tiene acceso al servidor.";
      if (e != null && !e.getMessage().isEmpty()) {
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

  public void procDeposito(String cuenta, double importe, String codEmp) {
    Connection cn = null;
    try {
      // Conexión
      cn = AccesoDB.getConnection();
      // Inicio de la Tx
      cn.setAutoCommit(false);
      // Leer datos de la cuenta
      String sql = "select dec_cuensaldo, int_cuencontmov "
              + "from cuenta where chr_cuencodigo = ? "
              + "for update ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, cuenta);
      ResultSet rs = pstm.executeQuery();
      if (!rs.next()) {
        throw new RuntimeException("Cuenta " + cuenta + " no existe.");
      }
      double saldo = rs.getDouble("dec_cuensaldo");
      int conta = rs.getInt("int_cuencontmov");
      // Actualizar datos de la cuenta
      
      // Forzando la lectura repetida
      Thread.currentThread().sleep(1000);
      
      saldo += importe;
      conta++;
      sql = "update cuenta set dec_cuensaldo = ?, "
              + "int_cuencontmov = ? "
              + "where chr_cuencodigo = ? ";
      pstm = cn.prepareStatement(sql);
      pstm.setDouble(1, saldo);
      pstm.setInt(2, conta);
      pstm.setString(3, cuenta);
      pstm.executeUpdate();
      pstm.close();
      // Insertar movimiento
      sql = "insert into movimiento(chr_cuencodigo,int_movinumero,"
              + "dtt_movifecha,chr_emplcodigo,chr_tipocodigo,dec_moviimporte) "
              + "values(?,?,sysdate,?,'003',?)";
      pstm = cn.prepareStatement(sql);
      pstm.setString(1, cuenta);
      pstm.setInt(2, conta);
      pstm.setString(3, codEmp);
      pstm.setDouble(4, importe);
      pstm.executeUpdate();
      pstm.close();
      // Confirmar Tx
      cn.commit();
    } catch (Exception e) {
      try {
        cn.rollback();
      } catch (Exception e1) {
      }
      String texto = "ERROR: No se pudo ejecutar el proceso DEPOSITO.";
      if (e != null && !e.getMessage().isEmpty()) {
        texto += "\n" + e.getMessage();
      }
      throw new RuntimeException(texto);
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }

  }
}
