package br.com.pizzaria.util;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Som {

    private AudioClip clip = null;

    public void som() {
        try {
            clip = Applet.newAudioClip(new File("sons/error.wav").toURL());
            clip.play();
        } catch (MalformedURLException ex) {
            Logger.getLogger(Som.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
