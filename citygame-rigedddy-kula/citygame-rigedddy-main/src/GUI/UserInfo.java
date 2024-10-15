package GUI;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import city.cs.engine.*;
import game.Game;

import city.cs.engine.SoundClip;

/**
 * @author      nazifa, firoz, nazifa.firoz@city.ac.uk
 */

public class UserInfo extends UserView {
    private final Game game;
    private SoundClip gameMusic;
    private MainMenu menu;

    /**
     * Constructs a UserInfo screen with the specified game instance and main menu.
     * @param game The Game instance representing the game.
     * @param menu The MainMenu instance representing the main menu.
     */
    public UserInfo(Game game, MainMenu menu) {
        super(new World(), 900, 650);
        this.game = game;
        this.menu = menu;
        this.setLayout(null);

        // main menu sound
        try {
            gameMusic = new SoundClip("sounds/mainmenu2.wav");
            gameMusic.loop();
            gameMusic.setVolume(0.5);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        JButton backButton = new JButton();
        backButton.setBounds(20,20,48,47);

        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);

        Image buttonImg = new ImageIcon("data/info3.png").getImage();
        backButton.setIcon(new ImageIcon(buttonImg));
        Image buttonImg2 = new ImageIcon("data/info.png").getImage();
        backButton.setRolloverIcon(new ImageIcon(buttonImg2));

        backButton.addActionListener(e -> {
            stopMusic(); // Stop the music
            game.backToMainMenu(); // Go back to the main menu
        });

        this.add(backButton);
    }

    /**
     * Stops the background music of the user information screen.
     */
    public void stopMusic() {
        if (gameMusic != null) {
            gameMusic.stop();
        }
    }

    /**
     * Paints the background of the user information screen.
     * @param background The Graphics2D object used for painting.
     */
    @Override
    protected void paintBackground(Graphics2D background){
        background.drawImage(new ImageIcon("data/information.gif").getImage(),0,0,this);
    }

}
