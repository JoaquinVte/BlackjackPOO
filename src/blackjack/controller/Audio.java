package blackjack.controller;

import javax.sound.sampled.*;
import java.io.IOException;

public class Audio {
    public static void playSound(String f) {

        Clip sound;

        try {
            sound = AudioSystem.getClip(null);

            AudioInputStream ais;
            ais = AudioSystem.getAudioInputStream(Audio.class.getResource("/blackjack/assets/sounds/" + f));

            sound.open(ais);
            sound.start();

        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

}
