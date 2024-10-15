package game;

import Coin.CoinHandler;
import GUI.MainMenu;
import GUI.UserInfo;
import GUI.Winner;
import Kula.KulaControl;
import Kula.KulaPlayer;
import Kula.KulaTracker;
import Level.GameLevel;
import Level.Level1;
import Level.Level2;
import Level.Level3;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;


/**
 * @author      nazifa, firoz, nazifa.firoz@city.ac.uk
 */

public class Game {
    private KulaPlayer kula;
    private KulaControl kulaControl;
    private GameView view;
    private KulaTracker kulaTracker;
    //private GameView gameView;
    private Timer gameTimer;
    //private CoinHandler coinHandler;
    private SoundClip gameMusic;
    private GameLevel currentLevel;
    //private DebugViewer debugView;
    private JFrame frame;
    private MainMenu menu;
    private DebugViewer debugView;
    private SoundClip letsgoSound;

    /**
     * Initialise a new Game.
     * */
    public Game() {

        menu = new MainMenu(this, 900, 650);

        try {
            letsgoSound = new SoundClip("sounds/letsgokula.wav");
        } catch (Exception e) {
            System.err.println("Error loading sound files: " + e);
        }

        //4. create a Java window (frame) and add the game
        //   view to it
        frame = new JFrame("City Game");
        frame.add(menu);
        //frame.add(view);

        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        // start our game world simulation!
        // world.start();
    }

    /**
     * Starts the game by initialising the current level, player, controls, and view.
     */
    public void startGame(){
        // make an empty game world
        currentLevel = new Level1(this);
        //debugView = new DebugViewer(currentLevel, 900, 650);

        // initialize KulaPlayer
        kula = currentLevel.getKulaPlayer();
        kulaControl = new KulaControl(kula);
        if (letsgoSound != null) {
            letsgoSound.play();
        }

        // make a view to look into the game world
        view = new GameView(currentLevel, 900, 650);

        // focus on view
        view.setFocusable(true);
        view.addKeyListener(kulaControl.getKeyHandler());

        //make the view follow the main character
        kulaTracker = new KulaTracker(view,kula);
        currentLevel.addStepListener(kulaTracker);


        //optional: draw a 1-metre grid over the view
        //view.setGridResolution(1);

        // start the level
        currentLevel.start();

        // add the view to the main frame
        frame.add(view);
        view.requestFocus();

    }

    /**
     * Handles transition to the next level of the game.
     */
    public void goToNextLevel(){

        System.out.println("Yes, lets go to next level");

        if (currentLevel instanceof Level1) {
            currentLevel.stop();
            currentLevel.stopMusic();
            currentLevel = new Level2(this);
            System.out.println("level 2!");

            if (letsgoSound != null) {
                letsgoSound.play();
            }

            KulaTracker tracker = new KulaTracker(view, currentLevel.getKulaPlayer());
            currentLevel.addStepListener(tracker);

            view.setWorld(currentLevel);
            kulaControl.updateKula(currentLevel.getKulaPlayer());
            view.updateKula(currentLevel.getKulaPlayer());
            view.changeBackground("data/lavabackground.gif");

            KulaPlayer prevKula = currentLevel.getKulaPlayer();
            KulaPlayer newKula = currentLevel.getKulaPlayer();


            //debugView.setWorld(currentLevel);
            currentLevel.start();
        }
        else if (currentLevel instanceof Level2){
            currentLevel.stop();
            currentLevel.stopMusic();
            currentLevel = new Level3(this);
            System.out.println("level 3!");

            if (letsgoSound != null) {
                letsgoSound.play();
            }

            KulaTracker tracker = new KulaTracker(view, currentLevel.getKulaPlayer());
            currentLevel.addStepListener(tracker);

            view.setWorld(currentLevel);
            kulaControl.updateKula(currentLevel.getKulaPlayer());
            view.updateKula(currentLevel.getKulaPlayer());
            view.changeBackground("data/ruinsbackground.gif");

            //debugView.setWorld(currentLevel);
            currentLevel.start();

        }
        else if (currentLevel instanceof Level3) {
            currentLevel.stopMusic();
            System.out.println("Game Over");
            // Display the Winners screen
            frame.getContentPane().removeAll();
            Winner winners = new Winner(this, 900, 650);
            frame.add(winners);
            frame.revalidate();
            frame.repaint();
        }


    }

    /**
     * Go to game information.
     */
    public void userInfo() {
        frame.getContentPane().removeAll();
        UserInfo userInfo = new UserInfo(this, menu);
        frame.add(userInfo);
        frame.revalidate();
        frame.repaint();
    }

    /**
     * Go back to main menu.
     */
    public void backToMainMenu() {
        frame.getContentPane().removeAll();
        MainMenu mainMenu = new MainMenu(this, 900, 650);
        frame.add(mainMenu);
        frame.revalidate();
        frame.repaint();
    }


    /**
     * Run the game.
     * */
    public static void main(String[] args) {

        new Game();
    }
}
