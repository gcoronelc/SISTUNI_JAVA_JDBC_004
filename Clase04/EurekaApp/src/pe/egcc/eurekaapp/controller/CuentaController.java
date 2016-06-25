package pe.egcc.eurekaapp.controller;

import java.util.Map;
import pe.egcc.eurekaapp.domain.Empleado;
import pe.egcc.eurekaapp.service.CuentaService;
import pe.egcc.eurekaapp.util.Memoria;

/**
 *
 * @author Gustavo Coronel
 */
public class CuentaController {

  private final CuentaService cuentaService;

  public CuentaController() {
    cuentaService = new CuentaService();
  }

  public double conSaldo(String cuenta) {
    return cuentaService.conSaldo(cuenta);
  }

  
  public Map<String, Object> getDatosCuenta(String codigo) {
    return cuentaService.getDatosCuenta(codigo);
  }
  
  public void procDeposito(String cuenta, double importe){
    Empleado usuario = (Empleado) Memoria.get("usuario");
    cuentaService.procDeposito(cuenta,importe,usuario.getCodigo());
  }
  
}
