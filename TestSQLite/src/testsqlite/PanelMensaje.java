/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsqlite;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author erandi
 */
public class PanelMensaje extends JPanel {

    public JPanel obtenerPanel(){
    JPanel panel = new JPanel();
        panel.setOpaque(true);
        Color customColor = new Color(108, 122, 131);
        Color foreColor = new Color(228, 241, 254);
        panel.setBackground(customColor);
        panel.setForeground(customColor);
        JLabel mensaje = new JLabel("Se agrego un nuevo usuario!", JLabel.CENTER);
        mensaje.setOpaque(true);
        mensaje.setForeground(foreColor);
        mensaje.setBackground(customColor);

        panel.add(mensaje);
        return panel;
    }
}
