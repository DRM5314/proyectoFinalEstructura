/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author david
 */
public class panel extends JPanel{
    private Image fondo;
    public panel(String nombreImagen) {
        preInit(nombreImagen);
    }
    public void preInit(String nombreImagen) {
        fondo = new ImageIcon("../"+nombreImagen+".png").getImage();
    }
    public void paint(Graphics g){
        g.drawImage(fondo, 0, 0,getWidth(),getHeight(),this);
    }
}
