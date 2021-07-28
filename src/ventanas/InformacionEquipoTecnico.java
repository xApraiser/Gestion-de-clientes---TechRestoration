/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Calendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Asus
 */
public class InformacionEquipoTecnico extends javax.swing.JFrame {

    int IDequipo = 0;
    String user = "";

    /**
     * Creates new form InformacionEquipo
     */
    public InformacionEquipoTecnico() {
        initComponents();

        user = Login.user;
        IDequipo = GestionarEquipos.IDequipo_update;

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from equipos where id_equipo = '" + IDequipo + "'");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                cmb_tipoequipo.setSelectedItem(rs.getString("tipo_equipo"));
                cmb_marcas.setSelectedItem(rs.getString("marca"));
                cmb_estatus.setSelectedItem(rs.getString("estatus"));
                txt_modelo.setText(rs.getString("modelo"));
                txt_num_serie.setText(rs.getString("num_serie"));
                txt_ultima_Modificacion.setText(rs.getString("ultima_modificacion"));

                String dia = "", mes = "", annio = "";
                dia = rs.getString("dia_ingreso");
                mes = rs.getString("mes_ingreso");
                annio = rs.getString("annio_ingreso");
                txt_fecha.setText(dia + "/" + mes + "/" + annio);

                jTextPane_observaciones.setText(rs.getString("observaciones"));
                jTextPane_comentariosTecnico.setText(rs.getString("comentarios_tenicos"));
                jLabel_revisionTecnicaDe.setText("comentarios y actualizacion del tecnico: " + rs.getString("revision_tecnica_de"));

            }

        } catch (SQLException e) {
            System.err.println("Error al consultar la informacion del equipo" + e);
        }

        setTitle("Equipo registrado con el ID " + IDequipo + " - Sesión de " + user);
        setSize(750, 600);
        setResizable(false);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/imagenes/wallpapertech.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(), jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();

    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/Logo_TechSinFondo.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_titulo = new javax.swing.JLabel();
        jLabel_Nombre = new javax.swing.JLabel();
        jLabel_Nombre1 = new javax.swing.JLabel();
        jLabel_Nombre2 = new javax.swing.JLabel();
        jLabel_Nombre3 = new javax.swing.JLabel();
        jLabel_Nombre4 = new javax.swing.JLabel();
        jLabel_Nombre5 = new javax.swing.JLabel();
        jLabel_Nombre6 = new javax.swing.JLabel();
        jLabel_Nombre7 = new javax.swing.JLabel();
        jLabel_Nombre8 = new javax.swing.JLabel();
        jLabel_revisionTecnicaDe = new javax.swing.JLabel();
        txt_NombreCliente = new javax.swing.JTextField();
        txt_modelo = new javax.swing.JTextField();
        txt_num_serie = new javax.swing.JTextField();
        txt_ultima_Modificacion = new javax.swing.JTextField();
        txt_fecha = new javax.swing.JTextField();
        cmb_tipoequipo = new javax.swing.JComboBox<>();
        cmb_marcas = new javax.swing.JComboBox<>();
        cmb_estatus = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane_observaciones = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane_comentariosTecnico = new javax.swing.JTextPane();
        jButton_Actualizar = new javax.swing.JButton();
        jLabel_Footer = new javax.swing.JLabel();
        jLabel_id_insumo = new javax.swing.JLabel();
        txt_IDinsumo = new javax.swing.JTextField();
        jButton_Historial = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_titulo.setText("Informacion del Equipo");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jLabel_Nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre.setText("Nombre del Cliente:");
        getContentPane().add(jLabel_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel_Nombre1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre1.setText("Tipo de equipo:");
        getContentPane().add(jLabel_Nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel_Nombre2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre2.setText("Marca:");
        getContentPane().add(jLabel_Nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel_Nombre3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre3.setText("Modelo: ");
        getContentPane().add(jLabel_Nombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        jLabel_Nombre4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre4.setText("Numero de serie:");
        getContentPane().add(jLabel_Nombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        jLabel_Nombre5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre5.setText("Fecha de Ingreso:");
        getContentPane().add(jLabel_Nombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, -1, -1));

        jLabel_Nombre6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre6.setText("Ultima Modificacion por:");
        getContentPane().add(jLabel_Nombre6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        jLabel_Nombre7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre7.setText("Estatus:");
        getContentPane().add(jLabel_Nombre7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, -1, -1));

        jLabel_Nombre8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre8.setText("Daño Reportado y Observaciones:");
        getContentPane().add(jLabel_Nombre8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, -1, -1));

        jLabel_revisionTecnicaDe.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_revisionTecnicaDe.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_revisionTecnicaDe.setText("Comentarios y/o Actualizaciones del tecnico:");
        getContentPane().add(jLabel_revisionTecnicaDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, -1, -1));

        txt_NombreCliente.setBackground(new java.awt.Color(153, 153, 255));
        txt_NombreCliente.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_NombreCliente.setForeground(new java.awt.Color(255, 255, 255));
        txt_NombreCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_NombreCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_NombreCliente.setEnabled(false);
        getContentPane().add(txt_NombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 210, -1));

        txt_modelo.setBackground(new java.awt.Color(153, 153, 255));
        txt_modelo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_modelo.setForeground(new java.awt.Color(255, 255, 255));
        txt_modelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_modelo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 210, -1));

        txt_num_serie.setBackground(new java.awt.Color(153, 153, 255));
        txt_num_serie.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_num_serie.setForeground(new java.awt.Color(255, 255, 255));
        txt_num_serie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_num_serie.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_num_serie, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 210, -1));

        txt_ultima_Modificacion.setBackground(new java.awt.Color(153, 153, 255));
        txt_ultima_Modificacion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_ultima_Modificacion.setForeground(new java.awt.Color(255, 255, 255));
        txt_ultima_Modificacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ultima_Modificacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_ultima_Modificacion.setEnabled(false);
        getContentPane().add(txt_ultima_Modificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 210, -1));

        txt_fecha.setBackground(new java.awt.Color(153, 153, 255));
        txt_fecha.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_fecha.setForeground(new java.awt.Color(255, 255, 255));
        txt_fecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_fecha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_fecha.setEnabled(false);
        getContentPane().add(txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 180, -1));

        cmb_tipoequipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Notebook", "Desktop", "Multifuncional", "Impresora", "Pantalla", "Escaner" }));
        getContentPane().add(cmb_tipoequipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        cmb_marcas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acer", "HP", "Alienware", "Apple", "Asus", "Brother", "Dell", "Lenovo", "Cannon", "Samsung", "Epson", "Kodak", "Lexmark", "LG", "MSI", "Microsoft" }));
        getContentPane().add(cmb_marcas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        cmb_estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nuevo ingreso", "No reparado", "En revision", "Reparado", "Entregado" }));
        getContentPane().add(cmb_estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, -1, -1));

        jTextPane_observaciones.setEditable(false);
        jScrollPane1.setViewportView(jTextPane_observaciones);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 390, 120));

        jScrollPane2.setViewportView(jTextPane_comentariosTecnico);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 390, 120));

        jButton_Actualizar.setBackground(new java.awt.Color(153, 153, 240));
        jButton_Actualizar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_Actualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Actualizar.setText("Comentar y Actualizar");
        jButton_Actualizar.setBorder(null);
        jButton_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 400, 160, 35));

        jLabel_Footer.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Footer.setText("Informacion del Usuario");
        getContentPane().add(jLabel_Footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 530, -1, -1));

        jLabel_id_insumo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_id_insumo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_id_insumo.setText("Insumo:");
        getContentPane().add(jLabel_id_insumo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, -1, 20));

        txt_IDinsumo.setBackground(new java.awt.Color(153, 153, 255));
        txt_IDinsumo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_IDinsumo.setForeground(new java.awt.Color(255, 255, 255));
        txt_IDinsumo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_IDinsumo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_IDinsumo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_IDinsumoKeyTyped(evt);
            }
        });
        getContentPane().add(txt_IDinsumo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 410, 170, -1));

        jButton_Historial.setBackground(new java.awt.Color(153, 153, 240));
        jButton_Historial.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_Historial.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Historial.setText("Acceder al Historial del equipo");
        jButton_Historial.setBorder(null);
        jButton_Historial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_HistorialActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Historial, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 450, 260, 35));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActualizarActionPerformed

        String estatus, comentariosTecnicos, tecnico, dia_ingreso, mes_ingreso, annio_ingreso, nombreInsumo, Nombre_Insumo = "";
        int Cant_insumo = 0, Insumo_update = 0, IDinsumo = 0;
        estatus = cmb_estatus.getSelectedItem().toString();
        comentariosTecnicos = jTextPane_comentariosTecnico.getText();
        nombreInsumo = txt_IDinsumo.getText().trim();
        tecnico = user;

        try {
            Connection cn5 = Conexion.conectar();
            PreparedStatement pst5 = cn5.prepareStatement("select id_insumo, nombre_insumo from insumo where nombre_insumo = '" + nombreInsumo + "'");
            ResultSet rs5 = pst5.executeQuery();

            if (rs5.next()) {
                IDinsumo = rs5.getInt(1);
                Nombre_Insumo = rs5.getString(2);
            }

            cn5.close();
        } catch (SQLException e) {
            System.err.println("Error " + e);
            JOptionPane.showMessageDialog(null, "Error");

        }

        if (Nombre_Insumo.equalsIgnoreCase(nombreInsumo)) {
            try {

                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "update equipos set estatus=?, comentarios_tenicos=?, revision_tecnica_de=? where id_equipo = '" + IDequipo + "'");

                pst.setString(1, estatus);
                pst.setString(2, comentariosTecnicos);
                pst.setString(3, tecnico);

                pst.executeUpdate();
                cn.close();

            } catch (SQLException e) {
                System.err.println("Error al actualizar equipo. " + e);
                JOptionPane.showMessageDialog(null, "Error al actualizar equipo, contacte a un administrador");
            }

            Calendar calendar = Calendar.getInstance();

            dia_ingreso = Integer.toString(calendar.get(Calendar.DATE));
            mes_ingreso = Integer.toString(calendar.get(Calendar.MONTH));
            annio_ingreso = Integer.toString(calendar.get(Calendar.YEAR));

            try {
                Connection cn2 = Conexion.conectar();
                PreparedStatement pst2 = cn2.prepareStatement(
                        "insert into historial values (?,?,?,?,?,?,?,?,?)");

                pst2.setInt(1, 0);
                pst2.setInt(2, IDinsumo);
                pst2.setInt(3, IDequipo);
                pst2.setString(4, comentariosTecnicos);
                pst2.setString(5, dia_ingreso);
                pst2.setString(6, mes_ingreso);
                pst2.setString(7, annio_ingreso);
                pst2.setString(8, Nombre_Insumo);
                pst2.setString(9, tecnico);

                pst2.executeUpdate();
                cn2.close();

                JOptionPane.showMessageDialog(null, "Estatus del equipo actualizado");

            } catch (SQLException e) {
                System.err.println("Error al ingresar informacion a historial. " + e);
                JOptionPane.showMessageDialog(null, "Error al actualizar equipo, contacte a un administrador");
            }
            if (!nombreInsumo.equals("")) {
                try {
                    Connection cn3 = Conexion.conectar();
                    PreparedStatement pst3 = cn3.prepareStatement("select cantidad from insumo where nombre_insumo = '" + nombreInsumo + "'");
                    ResultSet rs3 = pst3.executeQuery();

                    if (rs3.next()) {
                        Cant_insumo = rs3.getInt(1);
                    }

                    cn3.close();

                } catch (SQLException e) {
                    System.err.println("Error al generar cant_insumo " + e);
                    JOptionPane.showMessageDialog(null, "Error");
                }

                if (Cant_insumo > 0) {
                    Insumo_update = Cant_insumo - 1;
                }else {
                    JOptionPane.showMessageDialog(null, "Segun la base de datos, no hay existencia de: +" + Nombre_Insumo + " en inventario");
                }

                try {
                    Connection cn4 = Conexion.conectar();
                    PreparedStatement pst4 = cn4.prepareStatement("update insumo set cantidad=? where nombre_insumo = '" + nombreInsumo + "'");

                    pst4.setInt(1, Insumo_update);

                    pst4.executeUpdate();
                    cn4.close();
                } catch (SQLException e) {
                    System.err.println("Error al actualizar insumo " + e);
                    JOptionPane.showMessageDialog(null, "Error");
                }

            }
        }else{
            JOptionPane.showMessageDialog(null, "No existe ningun insumo con ese nombre");
        }


    }//GEN-LAST:event_jButton_ActualizarActionPerformed

    private void txt_IDinsumoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_IDinsumoKeyTyped

    }//GEN-LAST:event_txt_IDinsumoKeyTyped

    private void jButton_HistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_HistorialActionPerformed
        Historial_equipo historialEquipo = new Historial_equipo();
        historialEquipo.setVisible(true);
    }//GEN-LAST:event_jButton_HistorialActionPerformed

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
            java.util.logging.Logger.getLogger(InformacionEquipoTecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionEquipoTecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionEquipoTecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionEquipoTecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionEquipoTecnico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_estatus;
    private javax.swing.JComboBox<String> cmb_marcas;
    private javax.swing.JComboBox<String> cmb_tipoequipo;
    private javax.swing.JButton jButton_Actualizar;
    private javax.swing.JButton jButton_Historial;
    private javax.swing.JLabel jLabel_Footer;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_Nombre1;
    private javax.swing.JLabel jLabel_Nombre2;
    private javax.swing.JLabel jLabel_Nombre3;
    private javax.swing.JLabel jLabel_Nombre4;
    private javax.swing.JLabel jLabel_Nombre5;
    private javax.swing.JLabel jLabel_Nombre6;
    private javax.swing.JLabel jLabel_Nombre7;
    private javax.swing.JLabel jLabel_Nombre8;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_id_insumo;
    private javax.swing.JLabel jLabel_revisionTecnicaDe;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane_comentariosTecnico;
    private javax.swing.JTextPane jTextPane_observaciones;
    private javax.swing.JTextField txt_IDinsumo;
    private javax.swing.JTextField txt_NombreCliente;
    private javax.swing.JTextField txt_fecha;
    private javax.swing.JTextField txt_modelo;
    private javax.swing.JTextField txt_num_serie;
    private javax.swing.JTextField txt_ultima_Modificacion;
    // End of variables declaration//GEN-END:variables

    public void Limpiar() {
        txt_NombreCliente.setText("");
        txt_fecha.setText("");
        txt_modelo.setText("");
        txt_num_serie.setText("");
        jTextPane_observaciones.setText("");
    }

}
