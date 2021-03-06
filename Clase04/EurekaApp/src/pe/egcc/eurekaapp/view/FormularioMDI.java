package pe.egcc.eurekaapp.view;

import javax.swing.JInternalFrame;
import pe.egcc.eurekaapp.domain.Empleado;
import pe.egcc.eurekaapp.util.Memoria;

/**
 *
 * @author Gustavo Coronel
 */
public class FormularioMDI extends javax.swing.JFrame {

  public FormularioMDI() {
    initComponents();
    initForm();
    setExtendedState(MAXIMIZED_BOTH);
  }
  
  private void initForm(){
    Empleado bean = (Empleado) Memoria.get("usuario");
    String titulo = "EUREKA APP [Usuario:";
    titulo += bean.getUsuario() + "]";
    this.setTitle(titulo);
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    desktopPane = new javax.swing.JDesktopPane();
    menuBar = new javax.swing.JMenuBar();
    menuArchivo = new javax.swing.JMenu();
    menuArchivoSalir = new javax.swing.JMenuItem();
    menuProcesos = new javax.swing.JMenu();
    menuProcesosDepósito = new javax.swing.JMenuItem();
    menuTablas = new javax.swing.JMenu();
    menuTablasClientes = new javax.swing.JMenuItem();
    menuConsultas = new javax.swing.JMenu();
    menuConsultasSaldoCuenta = new javax.swing.JMenuItem();
    menuReportes = new javax.swing.JMenu();
    menuReportesMovimientos = new javax.swing.JMenuItem();
    menuUtil = new javax.swing.JMenu();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    menuArchivo.setText("Archivo");

    menuArchivoSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
    menuArchivoSalir.setText("Salir");
    menuArchivoSalir.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuArchivoSalirActionPerformed(evt);
      }
    });
    menuArchivo.add(menuArchivoSalir);

    menuBar.add(menuArchivo);

    menuProcesos.setText("Procesos");

    menuProcesosDepósito.setText("Depósito");
    menuProcesosDepósito.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuProcesosDepósitoActionPerformed(evt);
      }
    });
    menuProcesos.add(menuProcesosDepósito);

    menuBar.add(menuProcesos);

    menuTablas.setText("Tablas");

    menuTablasClientes.setText("Clientes");
    menuTablasClientes.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuTablasClientesActionPerformed(evt);
      }
    });
    menuTablas.add(menuTablasClientes);

    menuBar.add(menuTablas);

    menuConsultas.setText("Consultas");

    menuConsultasSaldoCuenta.setText("Saldo de Cuenta");
    menuConsultasSaldoCuenta.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuConsultasSaldoCuentaActionPerformed(evt);
      }
    });
    menuConsultas.add(menuConsultasSaldoCuenta);

    menuBar.add(menuConsultas);

    menuReportes.setText("Reportes");

    menuReportesMovimientos.setText("Movimientos");
    menuReportesMovimientos.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuReportesMovimientosActionPerformed(evt);
      }
    });
    menuReportes.add(menuReportesMovimientos);

    menuBar.add(menuReportes);

    menuUtil.setText("Util");
    menuBar.add(menuUtil);

    setJMenuBar(menuBar);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void menuArchivoSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuArchivoSalirActionPerformed
    System.exit(0);
  }//GEN-LAST:event_menuArchivoSalirActionPerformed

  private void menuConsultasSaldoCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultasSaldoCuentaActionPerformed
    cargarFormulario(SaldoCuentaView.class);
  }//GEN-LAST:event_menuConsultasSaldoCuentaActionPerformed

  private void menuTablasClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTablasClientesActionPerformed
    cargarFormulario(MantClientesView.class);
  }//GEN-LAST:event_menuTablasClientesActionPerformed

  private void menuProcesosDepósitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuProcesosDepósitoActionPerformed
    cargarFormulario(DepositoView.class);
  }//GEN-LAST:event_menuProcesosDepósitoActionPerformed

  private void menuReportesMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReportesMovimientosActionPerformed
    cargarFormulario(RepoMovimientosView.class);
  }//GEN-LAST:event_menuReportesMovimientosActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(FormularioMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(FormularioMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(FormularioMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(FormularioMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new FormularioMDI().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JDesktopPane desktopPane;
  private javax.swing.JMenu menuArchivo;
  private javax.swing.JMenuItem menuArchivoSalir;
  private javax.swing.JMenuBar menuBar;
  private javax.swing.JMenu menuConsultas;
  private javax.swing.JMenuItem menuConsultasSaldoCuenta;
  private javax.swing.JMenu menuProcesos;
  private javax.swing.JMenuItem menuProcesosDepósito;
  private javax.swing.JMenu menuReportes;
  private javax.swing.JMenuItem menuReportesMovimientos;
  private javax.swing.JMenu menuTablas;
  private javax.swing.JMenuItem menuTablasClientes;
  private javax.swing.JMenu menuUtil;
  // End of variables declaration//GEN-END:variables

  private void cargarFormulario(Class<?> aClass) {
    try {
      JInternalFrame view = null;
      // Buscar un objeto de tipo aClass
      for (JInternalFrame form : desktopPane.getAllFrames()) {
        if(aClass.isInstance(form)){
          view = form;
          break;
        }
      }
      // Crear instancia
      if( view == null){
        view = (JInternalFrame) Class.forName(aClass.getName()).newInstance();
        desktopPane.add(view);
        view.setVisible(true);
      }
      // Activar
      view.setSelected(true);
    } catch (Exception e) {
    }
  }

}
