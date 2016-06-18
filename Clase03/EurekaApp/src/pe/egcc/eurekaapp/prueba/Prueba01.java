package pe.egcc.eurekaapp.prueba;

import pe.egcc.eurekaapp.domain.Empleado;
import pe.egcc.eurekaapp.service.LogonService;

/**
 *
 * @author Gustavo Coronel
 */
public class Prueba01 {

  public static void main(String[] args) {
    LogonService service = new LogonService();
    Empleado bean = service.validar("cromero", "chicho");
    if(bean != null){
      System.out.println("Nombre: " + bean.getNombre());
    } else {
      System.err.println("No existe.");
    }
  }
  
}
