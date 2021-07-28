/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.sql.*;
import clases.Conexion;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import static ventanas.GestionarClientes.IDcliente_update;
import static ventanas.GestionarEquipos.IDequipo_update;

/**
 *
 * @author Asus
 */
public class Informacion_Cliente extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();

    int IDcliente_update = 0;
    public static int IDequipo = 0;
    String user = "";

    /**
     * Creates new form Informacion_Cliente
     */
    public Informacion_Cliente() {
        initComponents();
        user = Login.user;
        IDcliente_update = GestionarClientes.IDcliente_update;

        setSize(640, 470);
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
                    "select * from clientes where id_cliente = '" + IDcliente_update + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                setTitle("Informacion del cliente " + rs.getString("nombre_cliente") + " - Sesión de " + user);
                jLabel_titulo.setText("Informacion del cliente " + rs.getString("nombre_cliente"));

                txt_nombre.setText(rs.getString("nombre_cliente"));
                txt_rut.setText(rs.getString("rut_cliente"));
                txt_mail.setText(rs.getString("email_cliente"));
                txt_telefono.setText(rs.getString("telefono_cliente"));
                txt_direccion.setText(rs.getString("direcion_cliente"));
                txt_UltimaModificacion.setText(rs.getString("ult_modificacion"));

            }
            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar usuario" + e);
            JOptionPane.showMessageDialog(null, "¡¡Error al cargar!!, contacte a un administrador");
        }

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select id_equipo, tipo_equipo, marca, estatus from equipos where id_cliente = '" + IDcliente_update + "'");
            ResultSet rs = pst.executeQuery();

            jTable_equipos = new JTable(model);
            jScrollPane_equipos.setViewportView(jTable_equipos);

            model.addColumn("ID Equipo");
            model.addColumn("Tipo de equipo");
            model.addColumn("Marca");
            model.addColumn("Estatus");

            while (rs.next()) {
                Object[] fila = new Object[4];

                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            cn.close();

        } catch (SQLException e) {
            System.err.println("Error en el llenado de la tabla equipo" + e);

        }

        jTable_equipos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_equipos.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    IDequipo = (int) model.getValueAt(fila_point, columna_point);
                    InformacionEquipo informacionEquipo = new InformacionEquipo();
                    informacionEquipo.setVisible(true);
                }

            }
        });

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

        jScrollPane_equipos = new javax.swing.JScrollPane();
        jTable_equipos = new javax.swing.JTable();
        jLabel_titulo = new javax.swing.JLabel();
        jLabel_Nombre = new javax.swing.JLabel();
        jLabel_mail = new javax.swing.JLabel();
        jLabel_telefono = new javax.swing.JLabel();
        jLabel_direccion = new javax.swing.JLabel();
        jLabel_UltimaModificacion = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_mail = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        txt_UltimaModificacion = new javax.swing.JTextField();
        jButton_Registrar = new javax.swing.JButton();
        jButton_Actualizar = new javax.swing.JButton();
        jButton_ImprimirReporte = new javax.swing.JButton();
        jLabel_Footer = new javax.swing.JLabel();
        txt_rut = new javax.swing.JTextField();
        jLabel_rut = new javax.swing.JLabel();
        Mostrar = new javax.swing.JButton();
        cmb_estatus = new javax.swing.JComboBox<>();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_equipos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane_equipos.setViewportView(jTable_equipos);

        getContentPane().add(jScrollPane_equipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 380, 180));

        jLabel_titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_titulo.setText("Informacion del Cliente");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel_Nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre.setText("Nombre:");
        getContentPane().add(jLabel_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel_mail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_mail.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_mail.setText("Email:");
        getContentPane().add(jLabel_mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel_telefono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_telefono.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_telefono.setText("Telefono:");
        getContentPane().add(jLabel_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel_direccion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_direccion.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_direccion.setText("Direccion:");
        getContentPane().add(jLabel_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        jLabel_UltimaModificacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_UltimaModificacion.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_UltimaModificacion.setText("Ultima Modificacion por:");
        getContentPane().add(jLabel_UltimaModificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        txt_nombre.setBackground(new java.awt.Color(153, 153, 255));
        txt_nombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, -1));

        txt_mail.setBackground(new java.awt.Color(153, 153, 255));
        txt_mail.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_mail.setForeground(new java.awt.Color(255, 255, 255));
        txt_mail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_mail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 210, -1));

        txt_telefono.setBackground(new java.awt.Color(153, 153, 255));
        txt_telefono.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_telefono.setForeground(new java.awt.Color(255, 255, 255));
        txt_telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_telefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 210, -1));

        txt_direccion.setBackground(new java.awt.Color(153, 153, 255));
        txt_direccion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_direccion.setForeground(new java.awt.Color(255, 255, 255));
        txt_direccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_direccion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 210, -1));

        txt_UltimaModificacion.setBackground(new java.awt.Color(153, 153, 255));
        txt_UltimaModificacion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_UltimaModificacion.setForeground(new java.awt.Color(255, 255, 255));
        txt_UltimaModificacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_UltimaModificacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_UltimaModificacion.setEnabled(false);
        getContentPane().add(txt_UltimaModificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 210, -1));

        jButton_Registrar.setBackground(new java.awt.Color(153, 153, 240));
        jButton_Registrar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_Registrar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Registrar.setText("Registrar Equipo");
        jButton_Registrar.setBorder(null);
        jButton_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 210, 35));

        jButton_Actualizar.setBackground(new java.awt.Color(153, 153, 240));
        jButton_Actualizar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_Actualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Actualizar.setText("Actualizar Cliente");
        jButton_Actualizar.setBorder(null);
        jButton_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, 210, 35));

        jButton_ImprimirReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/impresora.png"))); // NOI18N
        jButton_ImprimirReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ImprimirReporteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_ImprimirReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 120, 100));

        jLabel_Footer.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Footer.setText("Informacion del Usuario");
        getContentPane().add(jLabel_Footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, -1, -1));

        txt_rut.setBackground(new java.awt.Color(153, 153, 255));
        txt_rut.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_rut.setForeground(new java.awt.Color(255, 255, 255));
        txt_rut.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_rut.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_rut, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 210, -1));

        jLabel_rut.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_rut.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_rut.setText("RUT:");
        getContentPane().add(jLabel_rut, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        Mostrar.setBackground(new java.awt.Color(153, 153, 240));
        Mostrar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        Mostrar.setForeground(new java.awt.Color(255, 255, 255));
        Mostrar.setText("Mostrar");
        Mostrar.setBorder(null);
        Mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarActionPerformed(evt);
            }
        });
        getContentPane().add(Mostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 90, 30));

        cmb_estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Nuevo ingreso", "No reparado", "En revision", "Reparado", "Entregado" }));
        getContentPane().add(cmb_estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 130, 20));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistrarActionPerformed

        RegistrarEquipo registrar_equipo = new RegistrarEquipo();
        registrar_equipo.setVisible(true);

    }//GEN-LAST:event_jButton_RegistrarActionPerformed

    private void jButton_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActualizarActionPerformed

        int validacion = 0;
        String nombre, rut, mail, telefono, direccion;

        nombre = txt_nombre.getText().trim();
        rut = txt_rut.getText().trim();
        mail = txt_mail.getText().trim();
        telefono = txt_telefono.getText().trim();
        direccion = txt_direccion.getText().trim();

        if (nombre.equals("")) {
            txt_nombre.setBackground(Color.red);
            validacion++;
        }
        
        if (rut.equals("")) {
            txt_rut.setBackground(Color.red);
            validacion++;
        }

        if (mail.equals("")) {
            txt_mail.setBackground(Color.red);
            validacion++;
        }

        if (telefono.equals("")) {
            txt_telefono.setBackground(Color.red);
            validacion++;
        }

        if (direccion.equals("")) {
            txt_direccion.setBackground(Color.red);
            validacion++;
        }

        if (validacion == 0) {

            try {

                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "update clientes set nombre_cliente=?, rut_cliente=?, email_cliente=?, telefono_cliente=?, direcion_cliente=?, ult_modificacion=? "
                        + "where id_cliente = '" + IDcliente_update + "'");

                pst.setString(1, nombre);
                pst.setString(2, rut);
                pst.setString(3, mail);
                pst.setString(4, telefono);
                pst.setString(5, direccion);
                pst.setString(6, user);

                pst.executeUpdate();
                cn.close();

                Limpiar();

                txt_nombre.setBackground(Color.green);
                txt_rut.setBackground(Color.green);
                txt_mail.setBackground(Color.green);
                txt_telefono.setBackground(Color.green);
                txt_direccion.setBackground(Color.green);
                txt_UltimaModificacion.setText(user);

                JOptionPane.showMessageDialog(null, "Actualizacion Correcta");
                this.dispose();

            } catch (SQLException e) {
                System.err.println("Error en actualizar cliente " + e);
                JOptionPane.showMessageDialog(null, "ERROR al actualizar cliente, contacta a un administrador");
            }

        } else {
            JOptionPane.showMessageDialog(null, "debes llenar todos los campos");
        }

    }//GEN-LAST:event_jButton_ActualizarActionPerformed

    private void jButton_ImprimirReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ImprimirReporteActionPerformed

        Document documento = new Document();

        try {

            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "//Desktop/" + txt_nombre.getText().trim() + ".pdf"));

            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/imagenes/logo_TechRestoration.PNG");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Informacion del cliente. \n \n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

            documento.open();
            documento.add(header);
            documento.add(parrafo);

            PdfPTable tablaCliente = new PdfPTable(6);
            tablaCliente.addCell("ID");
            tablaCliente.addCell("Nombre");
            tablaCliente.addCell("RUT");
            tablaCliente.addCell("Email");
            tablaCliente.addCell("Telefono");
            tablaCliente.addCell("Dirección");

            try {

                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select * from clientes where id_cliente = '" + IDcliente_update + "'");

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    do {

                        tablaCliente.addCell(rs.getString(1));
                        tablaCliente.addCell(rs.getString(2));
                        tablaCliente.addCell(rs.getString(3));
                        tablaCliente.addCell(rs.getString(4));
                        tablaCliente.addCell(rs.getString(5));
                        tablaCliente.addCell(rs.getString(6));

                    } while (rs.next());

                    documento.add(tablaCliente);
                }

                Paragraph parrafo2 = new Paragraph();
                parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo2.add("\n \n Equipos Registrados. \n \n");
                parrafo2.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

                documento.add(parrafo2);

                PdfPTable tablaEquipos = new PdfPTable(4);
                tablaEquipos.addCell("ID Equipo");
                tablaEquipos.addCell("Tipo de Equipo");
                tablaEquipos.addCell("Marca");
                tablaEquipos.addCell("Estatus");

                try {

                    Connection cn2 = Conexion.conectar();
                    PreparedStatement pst2 = cn2.prepareStatement(
                            "select id_equipo, tipo_equipo, marca, estatus from equipos where id_cliente = '" + IDcliente_update + "'");

                    ResultSet rs2 = pst2.executeQuery();

                    if (rs2.next()) {
                        do {

                            tablaEquipos.addCell(rs2.getString(1));
                            tablaEquipos.addCell(rs2.getString(2));
                            tablaEquipos.addCell(rs2.getString(3));
                            tablaEquipos.addCell(rs2.getString(4));

                        } while (rs2.next());

                        documento.add(tablaEquipos);
                    }

                } catch (SQLException e) {
                    System.err.println("Error al cargar equipos " + e);
                }

            } catch (SQLException e) {
                System.err.println("Error al obtener datos del cliente " + e);
            }
            
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte generador correctamente.");

        } catch (DocumentException | IOException e) {
            System.err.println("Error en PDF o ruta de imagen " + e);
            JOptionPane.showMessageDialog(null, "Error al Generar PDF, contacte al administrador");
        }
    }//GEN-LAST:event_jButton_ImprimirReporteActionPerformed

    private void MostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarActionPerformed

        String selecion = cmb_estatus.getSelectedItem().toString();
        String query = "";

        model.setRowCount(0);
        model.setColumnCount(0);

        try {

            Connection cn = Conexion.conectar();

            if (selecion.equalsIgnoreCase("Todos")) {

                query = "select id_equipo, tipo_equipo, marca, estatus from equipos where id_cliente = '" + IDcliente_update + "'";

            } else {
                query = "select id_equipo, tipo_equipo, marca, estatus from equipos where estatus = '" + selecion + "' and id_cliente = '" + IDcliente_update + "'";
            }

            PreparedStatement pst = cn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            jTable_equipos = new JTable(model);
            jScrollPane_equipos.setViewportView(jTable_equipos);

            model.addColumn("ID Equipo");
            model.addColumn("Tipo de equipo");
            model.addColumn("Marca");
            model.addColumn("Estatus");

            while (rs.next()) {
                Object[] fila = new Object[4];

                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i + 1);
                }

                model.addRow(fila);

            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al recuperar los registros de equipo. Boton Mostar " + e);

        }

        ObtenerDatosTabla();
    }//GEN-LAST:event_MostrarActionPerformed

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
            java.util.logging.Logger.getLogger(Informacion_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Informacion_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Informacion_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Informacion_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Informacion_Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Mostrar;
    private javax.swing.JComboBox<String> cmb_estatus;
    private javax.swing.JButton jButton_Actualizar;
    private javax.swing.JButton jButton_ImprimirReporte;
    private javax.swing.JButton jButton_Registrar;
    private javax.swing.JLabel jLabel_Footer;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_UltimaModificacion;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_direccion;
    private javax.swing.JLabel jLabel_mail;
    private javax.swing.JLabel jLabel_rut;
    private javax.swing.JLabel jLabel_telefono;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JScrollPane jScrollPane_equipos;
    private javax.swing.JTable jTable_equipos;
    private javax.swing.JTextField txt_UltimaModificacion;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_mail;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_rut;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables

    public void ObtenerDatosTabla() {
        jTable_equipos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_equipos.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    IDequipo_update = (int) model.getValueAt(fila_point, columna_point);
                    InformacionEquipo info = new InformacionEquipo();
                    info.setVisible(true);
                }

            }
        });
    }
    
    public void Limpiar() {
        txt_nombre.setText("");
        txt_rut.setText("");
        txt_mail.setText("");
        txt_telefono.setText("");
        txt_direccion.setText("");
    }
}
