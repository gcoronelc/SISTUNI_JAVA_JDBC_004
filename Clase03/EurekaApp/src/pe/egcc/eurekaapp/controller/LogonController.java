package pe.egcc.eurekaapp.controller;

import pe.egcc.eurekaapp.service.LogonService;

/**
 *
 * @author Gustavo Coronel
 */
public class LogonController {

  public void validar(String usuario, String clave) {
    LogonService service = new LogonService();
    service.validar(usuario, clave);
  }
  
}
