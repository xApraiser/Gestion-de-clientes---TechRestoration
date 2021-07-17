/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Asus
 */
public class GraficarMarcas extends javax.swing.JFrame {

    String user;
    int[] vector_marcas_cantidad = new int[16];
    String[] vector_marcas_nombre = new String[16];
    int Acer, Hp, Alienware, Apple, Asus, Brother, Dell, Lenovo, Cannon, Samsung, Epson, Kodak, Lexmark, LG, MSI, Microsoft;

    /**
     * Creates new form GraficarEstatus
     */
    public GraficarMarcas() {
        initComponents();

        user = Login.user;

        setSize(630, 470);
        setResizable(false);
        setTitle("Tecnico - Sesión de " + user);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/imagenes/wallpapertech.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(), jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();

        try {

            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select marca, count(marca) as Marcas from equipos group by marca");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int posicion = 0;

                do {
                    vector_marcas_nombre[posicion] = rs.getString(1);
                    vector_marcas_cantidad[posicion] = rs.getInt(2);

                    if (vector_marcas_nombre[posicion].equalsIgnoreCase("Acer")) {
                        Acer = vector_marcas_cantidad[posicion];
                    } else if (vector_marcas_nombre[posicion].equalsIgnoreCase("HP")) {
                        Hp = vector_marcas_cantidad[posicion];
                    } else if (vector_marcas_nombre[posicion].equalsIgnoreCase("Alienware")) {
                        Alienware = vector_marcas_cantidad[posicion];
                    } else if (vector_marcas_nombre[posicion].equalsIgnoreCase("Apple")) {
                        Apple = vector_marcas_cantidad[posicion];
                    } else if (vector_marcas_nombre[posicion].equalsIgnoreCase("Brother")) {
                        Brother = vector_marcas_cantidad[posicion];
                    } else if (vector_marcas_nombre[posicion].equalsIgnoreCase("Dell")) {
                        Dell = vector_marcas_cantidad[posicion];
                    } else if (vector_marcas_nombre[posicion].equalsIgnoreCase("Lenovo")) {
                        Lenovo = vector_marcas_cantidad[posicion];
                    } else if (vector_marcas_nombre[posicion].equalsIgnoreCase("Cannon")) {
                        Cannon = vector_marcas_cantidad[posicion];
                    } else if (vector_marcas_nombre[posicion].equalsIgnoreCase("Samsung")) {
                        Samsung = vector_marcas_cantidad[posicion];
                    } else if (vector_marcas_nombre[posicion].equalsIgnoreCase("Epson")) {
                        Epson = vector_marcas_cantidad[posicion];
                    } else if (vector_marcas_nombre[posicion].equalsIgnoreCase("Kodak")) {
                        Kodak = vector_marcas_cantidad[posicion];
                    } else if (vector_marcas_nombre[posicion].equalsIgnoreCase("Lexmark")) {
                        Lexmark = vector_marcas_cantidad[posicion];
                    } else if (vector_marcas_nombre[posicion].equalsIgnoreCase("LG")) {
                        LG = vector_marcas_cantidad[posicion];
                    } else if (vector_marcas_nombre[posicion].equalsIgnoreCase("MSI")) {
                        MSI = vector_marcas_cantidad[posicion];
                    } else if (vector_marcas_nombre[posicion].equalsIgnoreCase("Microsoft")) {
                        Microsoft = vector_marcas_cantidad[posicion];
                    }

                    posicion++;

                } while (rs.next());
            }

        } catch (SQLException e) {
            System.err.println("Error en la Consulta " + e);
            JOptionPane.showMessageDialog(null, "Error al consultar datos, contacte al administrador.");
        }

        repaint();

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
        jLabel_Footer = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gráfica de Marcas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel_Footer.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Footer.setText("Graficos enumerando Marcas comerciales de los equipos");
        getContentPane().add(jLabel_Footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 470));

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
            java.util.logging.Logger.getLogger(GraficarMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraficarMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraficarMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraficarMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraficarMarcas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Footer;
    private javax.swing.JLabel jLabel_Wallpaper;
    // End of variables declaration//GEN-END:variables

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int total_marcas = Acer + Hp + Alienware + Apple + Asus + Brother + Dell + Lenovo + Cannon + Samsung + Epson + Kodak + Lexmark + LG + MSI + Microsoft;

        int grados_acer = Acer * 360 / total_marcas;
        int grados_hp = Hp * 360 / total_marcas;
        int grados_alienware = Alienware * 360 / total_marcas;
        int grados_apple = Apple * 360 / total_marcas;
        int grados_asus = Asus * 360 / total_marcas;
        int grados_brother = Brother * 360 / total_marcas;
        int grados_dell = Dell * 360 / total_marcas;
        int grados_lenovo = Lenovo * 360 / total_marcas;
        int grados_cannon = Cannon * 360 / total_marcas;
        int grados_samsung = Samsung * 360 / total_marcas;
        int grados_epson = Epson * 360 / total_marcas;
        int grados_kodak = Kodak * 360 / total_marcas;
        int grados_lexmark = Lexmark * 360 / total_marcas;
        int grados_lg = LG * 360 / total_marcas;
        int grados_msi = MSI * 360 / total_marcas;
        int grados_microsoft = Microsoft * 360 / total_marcas;

        //Marca acer
        g.setColor(new Color(175, 122, 197));
        g.fillArc(25, 100, 270, 270, 0, grados_acer);
        g.fillRect(310, 120, 20, 20);
        g.drawString(Acer + " equipos Acer", 340, 135);

        //Marca hp
        g.setColor(new Color(149, 165, 166));
        g.fillArc(25, 100, 270, 270, grados_acer, grados_hp);
        g.fillRect(310, 150, 20, 20);
        g.drawString(Hp + " equipos HP", 340, 165);

        //Marca alienware
        g.setColor(new Color(0, 255, 255));
        g.fillArc(25, 100, 270, 270, grados_acer + grados_hp, grados_alienware);
        g.fillRect(310, 180, 20, 20);
        g.drawString(Alienware + " equipos Alienware", 340, 195);

        //Marca Apple
        g.setColor(new Color(55, 0, 255));
        g.fillArc(25, 100, 270, 270, grados_acer + grados_hp + grados_alienware, grados_apple);
        g.fillRect(310, 210, 20, 20);
        g.drawString(Apple + " equipos Apple", 340, 225);

        //Marca Asus
        g.setColor(new Color(255, 255, 255));
        g.fillArc(25, 100, 270, 270, grados_acer + grados_hp + grados_alienware + grados_apple, grados_asus);
        g.fillRect(310, 240, 20, 20);
        g.drawString(Asus + " equipos Asus", 340, 255);

        //Marca Brother
        g.setColor(new Color(244, 208, 63));
        g.fillArc(25, 100, 270, 270, grados_acer + grados_hp + grados_alienware + grados_apple + grados_asus, grados_brother);
        g.fillRect(310, 270, 20, 20);
        g.drawString(Brother + " equipos Brother", 340, 285);

        //Marca Dell
        g.setColor(new Color(249, 231, 159));
        g.fillArc(25, 100, 270, 270, grados_acer + grados_hp + grados_alienware + grados_apple + grados_asus + grados_brother, grados_dell);
        g.fillRect(310, 300, 20, 20);
        g.drawString(Dell + " equipos Dell", 340, 315);

        //Marca Lenovo
        g.setColor(new Color(215, 96, 0));
        g.fillArc(25, 100, 270, 270, grados_acer + grados_hp + grados_alienware + grados_apple + grados_asus + grados_brother + grados_dell, grados_lenovo);
        g.fillRect(310, 330, 20, 20);
        g.drawString(Lenovo + " equipos Lenovo", 340, 345);

        //Marca Cannon
        g.setColor(new Color(215, 96, 140));
        g.fillArc(25, 100, 270, 270, grados_acer + grados_hp + grados_alienware + grados_apple + grados_asus + grados_brother + grados_dell + grados_lenovo, grados_cannon);
        g.fillRect(460, 120, 20, 20);
        g.drawString(Cannon + " equipos Cannon", 490, 135);

        //Marca Samsung
        g.setColor(new Color(215, 196, 25));
        g.fillArc(25, 100, 270, 270, grados_acer + grados_hp + grados_alienware + grados_apple + grados_asus + grados_brother + grados_dell + grados_lenovo + grados_cannon, grados_samsung);
        g.fillRect(460, 150, 20, 20);
        g.drawString(Samsung + " equipos Samsung", 490, 165);

        //Marca Epson
        g.setColor(new Color(93, 173, 226));
        g.fillArc(25, 100, 270, 270, grados_acer + grados_hp + grados_alienware + grados_apple + grados_asus + grados_brother + grados_dell + grados_lenovo + grados_cannon + grados_samsung, grados_epson);
        g.fillRect(460, 180, 20, 20);
        g.drawString(Epson + " equipos Epson", 490, 195);

        //Marca Kodak
        g.setColor(new Color(232, 246, 243));
        g.fillArc(25, 100, 270, 270, grados_acer + grados_hp + grados_alienware + grados_apple + grados_asus + grados_brother + grados_dell + grados_lenovo + grados_cannon + grados_samsung + grados_epson, grados_kodak);
        g.fillRect(460, 210, 20, 20);
        g.drawString(Kodak + " equipos Kodak", 490, 225);

        //Marca Lexmark
        g.setColor(new Color(230, 176, 170));
        g.fillArc(25, 100, 270, 270, grados_acer + grados_hp + grados_alienware + grados_apple + grados_asus + grados_brother + grados_dell + grados_lenovo + grados_cannon + grados_samsung + grados_epson + grados_kodak, grados_lexmark);
        g.fillRect(460, 240, 20, 20);
        g.drawString(Lexmark + " equipos Lexmark", 490, 255);

        //Marca LG
        g.setColor(new Color(213, 216, 220));
        g.fillArc(25, 100, 270, 270, grados_acer + grados_hp + grados_alienware + grados_apple + grados_asus + grados_brother + grados_dell + grados_lenovo + grados_cannon + grados_samsung + grados_epson + grados_kodak + grados_lexmark, grados_lg);
        g.fillRect(460, 270, 20, 20);
        g.drawString(LG + " equipos LG", 490, 285);

        //Marca MSI
        g.setColor(new Color(245, 203, 167));
        g.fillArc(25, 100, 270, 270, grados_acer + grados_hp + grados_alienware + grados_apple + grados_asus + grados_brother + grados_dell + grados_lenovo + grados_cannon + grados_samsung + grados_epson + grados_kodak + grados_lexmark + grados_lg, grados_msi);
        g.fillRect(460, 300, 20, 20);
        g.drawString(MSI + " equipos MSI", 490, 315);

        //Marca Microsoft
        g.setColor(new Color(245, 238, 248));
        g.fillArc(25, 100, 270, 270, grados_acer + grados_hp + grados_alienware + grados_apple + grados_asus + grados_brother + grados_dell + grados_lenovo + grados_cannon + grados_samsung + grados_epson + grados_kodak + grados_lexmark + grados_lg + grados_msi, grados_microsoft);
        g.fillRect(460, 330, 20, 20);
        g.drawString(Microsoft + " equipos Microsoft", 490, 345);
    }

}
