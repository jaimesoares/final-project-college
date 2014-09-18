package br.com.pizzaria.util;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class ThreadTempo extends Thread {

    JLabel lbl;

    public ThreadTempo(JLabel jlabel) {
        this.lbl = jlabel;
    }

    @Override
    public void run() {
        try {
            this.sleep(2000);
            this.lbl.setText("");
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadTempo.class.getName()).log(Level.SEVERE, null, ex);
        }
        super.run();
    }
}