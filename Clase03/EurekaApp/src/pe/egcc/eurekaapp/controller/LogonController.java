package pe.egcc.eurekaapp.controller;

import pe.egcc.eurekaapp.domain.Empleado;
import pe.egcc.eurekaapp.service.LogonService;
import pe.egcc.eurekaapp.util.Memoria;

/**
 *
 * @author Gustavo Coronel
 */
public class LogonController {

  public void validar(String usuario, String clave) {
    LogonService service = new LogonService();
    Empleado bean = service.validar(usuario, clave);
    Memoria.put("usuario", bean);
  }
  
}
