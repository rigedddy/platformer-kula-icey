package GUI;

import city.cs.engine.SoundClip;
import city.cs.engine.UserView;
import city.cs.engine.World;
import game.Game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * @author      nazifa, firoz, nazifa.firoz@city.ac.uk
 */

public class Winner extends UserView {
    private final Game game;
    private SoundClip gameMusic;

    /**
     * Constructs a Winner screen with the specified game instance, width, and height.
     * @param game The Game instance representing the game.
     * @param width The width of the winner screen.
     * @param height The height of the winner screen.
     */
    public Winner(Game game, int width, int height) {
        super(new World(), 900, 650);
        this.game = game;
        this.setLayout(null);

        try {
            gameMusic = new SoundClip("sounds/mainmenu2.wav");
            gameMusic.loop();
            gameMusic.setVolume(0.5);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        // Add exit button
        JButton exitButton = new JButton();
        exitButton.setBounds(350, 450, 190, 70);
        exitButton.setContentAreaFilled(false);
        exitButton.setBorderPainted(false);
        Image buttonImg3 = new ImageIcon("data/exit1.png").getImage();
        exitButton.setIcon(new ImageIcon(buttonImg3));
        Image buttonImg4 = new ImageIcon("data/exit2.png").getImage();
        exitButton.setRolloverIcon(new ImageIcon(buttonImg4));
        this.add(exitButton);

        // Add action listener to the exit button
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * Paints the background of the winner screen.
     * @param background The Graphics2D object used for painting.
     */
    @Override
    protected void paintBackground(Graphics2D background){
        background.drawImage(new ImageIcon("data/winner.png").getImage(),0,0,this);
    }

}
