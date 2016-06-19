package pe.egcc.eurekaapp.controller;

import pe.egcc.eurekaapp.service.CuentaService;

/**
 *
 * @author Gustavo Coronel
 */
public class CuentaController {

  private CuentaService cuentaService;

  public CuentaController() {
    cuentaService = new CuentaService();
  }

  public double conSaldo(String cuenta) {
    return cuentaService.conSaldo(cuenta);
  }

}
