package GUI;


import city.cs.engine.SoundClip;
import city.cs.engine.UserView;
import city.cs.engine.World;
import game.Game;

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

public class MainMenu extends UserView {
    private final Game game;
    private SoundClip gameMusic;

    /**
     * Constructs a MainMenu with the specified game instance, width, and height.
     * @param game The Game instance representing the game.
     * @param width The width of the main menu.
     * @param height The height of the main menu.
     */
    public MainMenu(Game game, int width, int height) {
        super(new World(), width, height);
        this.game = game;
        this.setLayout(null);

        // main menu sound
        try {
            gameMusic = new SoundClip("sounds/mainmenu2.wav");
            gameMusic.loop();
            gameMusic.setVolume(0.5);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        // buttons to start or exit
        JButton startGame = new JButton();
        JButton exitGame = new JButton();
        // info button
        JButton info = new JButton();

        startGame.setBounds(350,350,190,70);
        exitGame.setBounds(350,450,190,70);
        info.setBounds(20,20,48,47);

        // set the background color of the buttons to be transparent
        startGame.setContentAreaFilled(false);
        exitGame.setContentAreaFilled(false);
        info.setContentAreaFilled(false);

        // remove the border from the buttons
        startGame.setBorderPainted(false);
        exitGame.setBorderPainted(false);
        info.setBorderPainted(false);

        Image buttonImg = new ImageIcon("data/startgame1.png").getImage();
        startGame.setIcon(new ImageIcon(buttonImg));
        Image buttonImg2 = new ImageIcon("data/startgame2.png").getImage();
        startGame.setRolloverIcon(new ImageIcon(buttonImg2));

        Image buttonImg3 = new ImageIcon("data/exit1.png").getImage();
        exitGame.setIcon(new ImageIcon(buttonImg3));
        Image buttonImg4 = new ImageIcon("data/exit2.png").getImage();
        exitGame.setRolloverIcon(new ImageIcon(buttonImg4));

        Image buttonImg5 = new ImageIcon("data/info.png").getImage();
        info.setIcon(new ImageIcon(buttonImg5));
        Image buttonImg6 = new ImageIcon("data/info2.png").getImage();
        info.setRolloverIcon(new ImageIcon(buttonImg6));

//        startGame.setText("START GAME");
//        exitGame.setText("EXIT");

        this.add(startGame);
        this.add(exitGame);
        this.add(info);

        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Stop the main menu game music
                stopMusic();
                MainMenu.super.setVisible(false);
                game.startGame();
            }
        });

        exitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopMusic();
                MainMenu.super.setVisible(false);
                game.userInfo();
            }
        });

    }

    /**
     * Stops the background music of the main menu.
     */
    public void stopMusic() {
        if (gameMusic != null) {
            gameMusic.stop();
        }
    }

    /**
     * Paints the background of the main menu.
     * @param background The Graphics2D object used for painting.
     */
    @Override
    protected void paintBackground(Graphics2D background){
        background.drawImage(new ImageIcon("data/mainMenu6.gif").getImage(),0,0,this);
    }


}
