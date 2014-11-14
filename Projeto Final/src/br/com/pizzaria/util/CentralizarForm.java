/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.util;

import java.awt.Dimension;
import javax.swing.JInternalFrame;

/**
 *
 * @author Jaime
 */
public class CentralizarForm {

    /**
     *
     * @param frame
     */
    public static void centralizaForm(JInternalFrame frame) {
        Dimension desktopSize = Global.principal.getDesktop().getSize();
        Dimension jInternalFrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
    }
}
