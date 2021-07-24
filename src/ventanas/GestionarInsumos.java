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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class GestionarInsumos extends javax.swing.JFrame {

    String user = "";
    public static int IDinsumo_update;
    DefaultTableModel model = new DefaultTableModel();

    /**
     * Creates new form GestionarInsumos
     */
    public GestionarInsumos() {
        initComponents();

        user = Login.user;

        setTitle("Tecnico Sesión de: " + user);
        setSize(700, 520);
        setResizable(false);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/imagenes/wallpapertech.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(), jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();

        try {

            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select id_insumo, nombre_insumo, modelo_insumo, repuesto_para, cantidad from insumo");
            ResultSet rs = pst.executeQuery();

            jTable_insumos = new JTable();
            jScrollPane_insumos.setViewportView(jTable_insumos);

            while (rs.next()) {
                Object[] fila = new Object[5];

                for (int i = 0; i < 5; i++) {
                    fila[i] = rs.getObject(i + 1);
                }

                model.addRow(fila);

            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al llenar tabla insumos." + e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion, contacte a un administrador");
        }

        ObtenerDatosTabla();

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
        jScrollPane_insumos = new javax.swing.JScrollPane();
        jTable_insumos = new javax.swing.JTable();
        jButton_RegistrarInsumos = new javax.swing.JButton();
        MostrarInsumos = new javax.swing.JButton();
        cmb_tipoequipo = new javax.swing.JComboBox<>();
        BuscarInsumos = new javax.swing.JButton();
        txt_buscarModelo = new javax.swing.JTextField();
        txt_buscarID = new javax.swing.JTextField();
        jLabel_buscarNserie = new javax.swing.JLabel();
        jLabel_buscarID = new javax.swing.JLabel();
        jLabel_buscar = new javax.swing.JLabel();
        jLabel_Footer = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_titulo.setText("Gestionar Insumos");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        jTable_insumos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane_insumos.setViewportView(jTable_insumos);

        getContentPane().add(jScrollPane_insumos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 700, 190));

        jButton_RegistrarInsumos.setBackground(new java.awt.Color(153, 153, 240));
        jButton_RegistrarInsumos.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_RegistrarInsumos.setForeground(new java.awt.Color(255, 255, 255));
        jButton_RegistrarInsumos.setText("Registrar Insumo");
        jButton_RegistrarInsumos.setBorder(null);
        jButton_RegistrarInsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegistrarInsumosActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_RegistrarInsumos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 210, 35));

        MostrarInsumos.setBackground(new java.awt.Color(153, 153, 240));
        MostrarInsumos.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        MostrarInsumos.setForeground(new java.awt.Color(255, 255, 255));
        MostrarInsumos.setText("Mostrar");
        MostrarInsumos.setBorder(null);
        MostrarInsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarInsumosActionPerformed(evt);
            }
        });
        getContentPane().add(MostrarInsumos, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 150, 35));

        cmb_tipoequipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Notebook", "Desktop", "Multifuncional", "Impresora", "Pantalla", "Escaner" }));
        getContentPane().add(cmb_tipoequipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 140, 30));

        BuscarInsumos.setBackground(new java.awt.Color(153, 153, 240));
        BuscarInsumos.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        BuscarInsumos.setForeground(new java.awt.Color(255, 255, 255));
        BuscarInsumos.setText("Buscar");
        BuscarInsumos.setBorder(null);
        BuscarInsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarInsumosActionPerformed(evt);
            }
        });
        getContentPane().add(BuscarInsumos, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, 210, 35));

        txt_buscarModelo.setBackground(new java.awt.Color(153, 153, 255));
        txt_buscarModelo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_buscarModelo.setForeground(new java.awt.Color(255, 255, 255));
        txt_buscarModelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_buscarModelo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_buscarModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscarModeloActionPerformed(evt);
            }
        });
        getContentPane().add(txt_buscarModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, 210, -1));

        txt_buscarID.setBackground(new java.awt.Color(153, 153, 255));
        txt_buscarID.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_buscarID.setForeground(new java.awt.Color(255, 255, 255));
        txt_buscarID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_buscarID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_buscarID, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 210, -1));

        jLabel_buscarNserie.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_buscarNserie.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_buscarNserie.setText("Modelo:");
        getContentPane().add(jLabel_buscarNserie, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 80, -1));

        jLabel_buscarID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_buscarID.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_buscarID.setText("ID:");
        getContentPane().add(jLabel_buscarID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 20, -1));

        jLabel_buscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_buscar.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_buscar.setText("Buscar Insumo por:");
        getContentPane().add(jLabel_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 120, -1));

        jLabel_Footer.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Footer.setText("Gestion de insumos");
        getContentPane().add(jLabel_Footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 450, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_RegistrarInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistrarInsumosActionPerformed
        RegistrarInsumos registrarInsumos = new RegistrarInsumos();
        registrarInsumos.setVisible(true);

    }//GEN-LAST:event_jButton_RegistrarInsumosActionPerformed

    private void MostrarInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarInsumosActionPerformed
        String selecion = cmb_tipoequipo.getSelectedItem().toString();
        String query = "";

        model.setRowCount(0);
        model.setColumnCount(0);

        try {

            Connection cn = Conexion.conectar();

            if (selecion.equalsIgnoreCase("Todos")) {

                query = "select id_insumo, nombre_insumo, modelo_insumo, repuesto_para, cantidad from insumo";

            } else {
                query = "select id_insumo, nombre_insumo, modelo_insumo, repuesto_para, cantidad from insumo where repuesto_para = '" + selecion + "'";
            }

            PreparedStatement pst = cn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            jTable_insumos = new JTable(model);
            jScrollPane_insumos.setViewportView(jTable_insumos);

            model.addColumn(" ");
            model.addColumn("Nombre Insumo");
            model.addColumn("Modelo Insumo");
            model.addColumn("Repuesto Para");
            model.addColumn("Cantidad");

            while (rs.next()) {
                Object[] fila = new Object[5];

                for (int i = 0; i < 5; i++) {
                    fila[i] = rs.getObject(i + 1);
                }

                model.addRow(fila);

            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al recuperar los registros de equipo. Boton Mostar " + e);

        }

        ObtenerDatosTabla();

    }//GEN-LAST:event_MostrarInsumosActionPerformed

    private void BuscarInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarInsumosActionPerformed
        String buscarID = txt_buscarID.getText().trim();
        String buscarModelo = txt_buscarModelo.getText().trim();
        String query = "";

        model.setRowCount(0);
        model.setColumnCount(0);

        try {
            Connection cn2 = Conexion.conectar();

            if (buscarID.equals("") && buscarModelo.equals("")) {
                JOptionPane.showMessageDialog(null, "Debe ingresar uno o ambos valores para poder buscar un insumo por este metodo");
                query = "select id_insumo, nombre_insumo, modelo_insumo, repuesto_para, cantidad from insumo";
            } else if (buscarModelo.equals("")) {
                query = "select id_insumo, nombre_insumo, modelo_insumo, repuesto_para, cantidad from insumo where id_insumo = '" + buscarID + "'";
            } else if (buscarID.equals("")) {
                query = "select id_insumo, nombre_insumo, modelo_insumo, repuesto_para, cantidad from insumo where modelo_insumo = '" + buscarModelo + "'";
            } else {
                query = "select id_insumo, nombre_insumo, modelo_insumo, repuesto_para, cantidad from insumo where id_insumo = '" + buscarID + "' and modelo_insumo = '" + buscarModelo + "'";

            }

            PreparedStatement pst2 = cn2.prepareStatement(query);
            ResultSet rs2 = pst2.executeQuery();

            jTable_insumos = new JTable(model);
            jScrollPane_insumos.setViewportView(jTable_insumos);

            model.addColumn(" ");
            model.addColumn("Nombre Insumo");
            model.addColumn("Modelo Insumo");
            model.addColumn("Repuesto Para");
            model.addColumn("Cantidad");

            while (rs2.next()) {
                Object[] fila = new Object[5];

                for (int i = 0; i < 5; i++) {
                    fila[i] = rs2.getObject(i + 1);
                }

                model.addRow(fila);

            }

            cn2.close();

            Limpiar();

        } catch (SQLException e) {
            System.err.println("Error al recuperar los registros de equipo. Boton Buscar " + e);
        }

        ObtenerDatosTabla();

    }//GEN-LAST:event_BuscarInsumosActionPerformed

    private void txt_buscarModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarModeloActionPerformed

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
            java.util.logging.Logger.getLogger(GestionarInsumos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarInsumos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarInsumos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarInsumos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarInsumos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuscarInsumos;
    private javax.swing.JButton MostrarInsumos;
    private javax.swing.JComboBox<String> cmb_tipoequipo;
    private javax.swing.JButton jButton_RegistrarInsumos;
    private javax.swing.JLabel jLabel_Footer;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_buscar;
    private javax.swing.JLabel jLabel_buscarID;
    private javax.swing.JLabel jLabel_buscarNserie;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JScrollPane jScrollPane_insumos;
    private javax.swing.JTable jTable_insumos;
    private javax.swing.JTextField txt_buscarID;
    private javax.swing.JTextField txt_buscarModelo;
    // End of variables declaration//GEN-END:variables
    public void Limpiar() {
        txt_buscarID.setText("");
        txt_buscarModelo.setText("");

    }


    public void ObtenerDatosTabla() {
        jTable_insumos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_insumos.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    IDinsumo_update = (int) model.getValueAt(fila_point, columna_point);
                    Informacion_Insumo info = new Informacion_Insumo();
                    info.setVisible(true);
                }

            }
        });
    }

}
