/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
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
public class ReporteInterno extends javax.swing.JFrame {
    String user;
    public static int IDequipo_update;
    DefaultTableModel model = new DefaultTableModel();
    int NuevoIngreso, NoReparado, EnRevision, Reparado, Entregado;
    
    String [] vector_estatus_nombre = new String[5];
    int [] vector_estatus_cantidad = new int[5];

    /**
     * Creates new form ReporteInterno
     */
    public ReporteInterno() {
        initComponents();
        
        user = Login.user;
        
        setSize(630, 490);
        setResizable(false);
        setTitle("Tecnico - Sesión de " + user);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/imagenes/wallpapertech.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(), jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();
        
        try{
            
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                "select estatus, count(estatus) as Cantidad From equipos group by estatus");
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                int posicion = 0;
                do {
                    vector_estatus_nombre [posicion] = rs.getString(1);
                    vector_estatus_cantidad [posicion] = rs.getInt(2);
                    
                    if(vector_estatus_nombre[posicion].equalsIgnoreCase("En revision")){
                        
                        EnRevision = vector_estatus_cantidad[posicion];
                        txt_enrevision.setText(Integer.toString(EnRevision));
                        
                    } else if(vector_estatus_nombre[posicion].equalsIgnoreCase("Entregado")){
                        
                        Entregado = vector_estatus_cantidad[posicion];
                        txt_entregado.setText(Integer.toString(Entregado));
                        
                    } else if(vector_estatus_nombre[posicion].equalsIgnoreCase("No reparado")){
                        
                        NoReparado = vector_estatus_cantidad[posicion];
                        txt_NoReparado.setText(Integer.toString(NoReparado));
                        
                    } else if(vector_estatus_nombre[posicion].equalsIgnoreCase("Nuevo ingreso")){
                        
                        NuevoIngreso = vector_estatus_cantidad[posicion];
                        txt_NuevoIngreso.setText(Integer.toString(NuevoIngreso));
                        
                    } else if(vector_estatus_nombre[posicion].equalsIgnoreCase("Reparado")){
                        
                        Reparado = vector_estatus_cantidad[posicion];
                        txt_Reparado.setText(Integer.toString(Reparado));
                        
                    }
                    
                    posicion++;
                    
                } while (rs.next());
            }
            
        }catch (SQLException e){
            System.err.println("Error en conectar con la base de datos" + e);
            JOptionPane.showMessageDialog(null, "Error, contacte al administrador");
        }

        try{
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                "select marca, count(marca) as CantidadMarcas From equipos group by marca");
            ResultSet rs2 = pst2.executeQuery();
            
            jTable_ReporteMarcas = new JTable(model);
            jScrollPane_ReporteMarcas.setViewportView(jTable_ReporteMarcas);

            model.addColumn("Marca");
            model.addColumn("Cantidad");

            while (rs2.next()) {
                Object[] fila = new Object[2];

                for (int i = 0; i < 2; i++) {
                    fila[i] = rs2.getObject(i + 1);
                }

                model.addRow(fila);

            }

            cn2.close();
            
        }catch (SQLException e){
            System.err.println("Error en el llenado de la tabla Reporte de marcas" + e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion, contacta a un administrador");
        }
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane_ReporteMarcas = new javax.swing.JScrollPane();
        jTable_ReporteMarcas = new javax.swing.JTable();
        jLabel_Footer = new javax.swing.JLabel();
        jLabel_EnRevision = new javax.swing.JLabel();
        txt_enrevision = new javax.swing.JTextField();
        jLabel_Entregado = new javax.swing.JLabel();
        txt_entregado = new javax.swing.JTextField();
        jLabel_NoReparado = new javax.swing.JLabel();
        txt_NoReparado = new javax.swing.JTextField();
        txt_NuevoIngreso = new javax.swing.JTextField();
        jLabel_nuevoIngreso = new javax.swing.JLabel();
        txt_Reparado = new javax.swing.JTextField();
        jLabel_EnRevision4 = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Reporte Interno");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Reporte de Equipos en estado:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Reporte Equipos por marca:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, -1, -1));

        jTable_ReporteMarcas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane_ReporteMarcas.setViewportView(jTable_ReporteMarcas);

        getContentPane().add(jScrollPane_ReporteMarcas, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 270, 300));

        jLabel_Footer.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Footer.setText("Reporte Interno");
        getContentPane().add(jLabel_Footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 420, -1, -1));

        jLabel_EnRevision.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_EnRevision.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_EnRevision.setText("En Revision:");
        getContentPane().add(jLabel_EnRevision, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 20));

        txt_enrevision.setBackground(new java.awt.Color(153, 153, 255));
        txt_enrevision.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_enrevision.setForeground(new java.awt.Color(255, 255, 255));
        txt_enrevision.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_enrevision.setText("0");
        txt_enrevision.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_enrevision, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 150, -1));

        jLabel_Entregado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Entregado.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Entregado.setText("Entregados:");
        getContentPane().add(jLabel_Entregado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        txt_entregado.setBackground(new java.awt.Color(153, 153, 255));
        txt_entregado.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_entregado.setForeground(new java.awt.Color(255, 255, 255));
        txt_entregado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_entregado.setText("0");
        txt_entregado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_entregado, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 150, -1));

        jLabel_NoReparado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_NoReparado.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_NoReparado.setText("No Reparados:");
        getContentPane().add(jLabel_NoReparado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        txt_NoReparado.setBackground(new java.awt.Color(153, 153, 255));
        txt_NoReparado.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_NoReparado.setForeground(new java.awt.Color(255, 255, 255));
        txt_NoReparado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_NoReparado.setText("0");
        txt_NoReparado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_NoReparado, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 150, -1));

        txt_NuevoIngreso.setBackground(new java.awt.Color(153, 153, 255));
        txt_NuevoIngreso.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_NuevoIngreso.setForeground(new java.awt.Color(255, 255, 255));
        txt_NuevoIngreso.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_NuevoIngreso.setText("0");
        txt_NuevoIngreso.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_NuevoIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 150, -1));

        jLabel_nuevoIngreso.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_nuevoIngreso.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_nuevoIngreso.setText("Nuevo Ingreso:");
        getContentPane().add(jLabel_nuevoIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        txt_Reparado.setBackground(new java.awt.Color(153, 153, 255));
        txt_Reparado.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Reparado.setForeground(new java.awt.Color(255, 255, 255));
        txt_Reparado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Reparado.setText("0");
        txt_Reparado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Reparado, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 150, -1));

        jLabel_EnRevision4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_EnRevision4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_EnRevision4.setText("Reparado");
        getContentPane().add(jLabel_EnRevision4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ReporteInterno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReporteInterno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReporteInterno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReporteInterno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReporteInterno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_EnRevision;
    private javax.swing.JLabel jLabel_EnRevision4;
    private javax.swing.JLabel jLabel_Entregado;
    private javax.swing.JLabel jLabel_Footer;
    private javax.swing.JLabel jLabel_NoReparado;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_nuevoIngreso;
    private javax.swing.JScrollPane jScrollPane_ReporteMarcas;
    private javax.swing.JTable jTable_ReporteMarcas;
    private javax.swing.JTextField txt_NoReparado;
    private javax.swing.JTextField txt_NuevoIngreso;
    private javax.swing.JTextField txt_Reparado;
    private javax.swing.JTextField txt_enrevision;
    private javax.swing.JTextField txt_entregado;
    // End of variables declaration//GEN-END:variables
}
