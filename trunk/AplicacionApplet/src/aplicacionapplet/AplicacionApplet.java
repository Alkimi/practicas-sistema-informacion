/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionapplet;

import java.applet.Applet;
import java.awt.Graphics;

/**
 *
 * @author Alkimi
 */
public class AplicacionApplet extends  Applet{
    
    /**
     * es lo primero que se ejecut del applet, solo se ejecuta una vez
     */
    public void init(){
        
    }
    
    /**
     * esta funcion se ejecuta siempre que la ventana del navegador se pone activa
     */
    public void start(){
        
    }

    /**
     * este metodo se ejecuta cada vez que se quiere repintar el applet
     * @param g 
     */
    public void paint(Graphics g){
        g.drawString("Primer applet", 10, 10);
    }
}
