package game;

import Kula.KulaPlayer;
import Level.GameLevel;
import city.cs.engine.UserView;
import org.jbox2d.common.Vec2;
import Coin.Coin;
import Coin.CoinHandler;
import javax.swing.*;
import java.awt.*;

/**
 * @author      nazifa, firoz, nazifa.firoz@city.ac.uk
 */

public class GameView extends UserView {
    private Image background;
    private KulaPlayer kula;
    public static  Font STATUS_FONT = new Font(Font.DIALOG_INPUT, Font.PLAIN, 16);
    private GameLevel gameLevel;

    /**
     * Constructs a GameView with the specified game world, width, and height.
     * @param world The GameLevel instance representing the game world.
     * @param width The width of the view.
     * @param height The height of the view.
     */
    public GameView(GameLevel world, int width, int height) {
        super(world, width, height);
        background = new ImageIcon("data/darker_background.gif").getImage();
        gameLevel = world;
    }

    /**
     * Paints the background of the game view with the specified Graphics2D object.
     * @param g The Graphics2D object used for painting.
     */
    @Override
    protected void paintBackground(Graphics2D g) {
        // Get the width and height of the GameView
        int viewWidth = getWidth();
        int viewHeight = getHeight();

        // Draw the background image scaled to the size of the GameView
        g.drawImage(background, 0, 0, viewWidth, viewHeight, this);
    }

    /**
     * Paints the foreground of the game view with the specified Graphics2D object.
     * @param g The Graphics2D object used for painting.
     */
    @Override
    protected void paintForeground(Graphics2D g) {
        KulaPlayer kula = ((GameLevel) getWorld()).getKulaPlayer();

        if (kula != null) {
            int health = kula.getHealth();
            int maxHealth = KulaPlayer.MAX_HEALTH;
            int coinCount = (kula.getCoinsCount());

            // calculate the width of the health bar
            int healthBarWidth = (int) ((double) health / maxHealth * 210);

            // draw the health bar background on the left side
            g.setColor(Color.BLACK);
            g.fillRect(45, 45, 220, 30);

            // draw the health bar (red part)
            g.setColor(Color.RED);
            g.fillRect(50, 50, healthBarWidth, 20);

            // draw text displaying health
            g.setColor(Color.WHITE);
            g.setFont(STATUS_FONT);
            g.drawString("HP: " + health + " / " + maxHealth, 100, 65);

            // background for coin
            g.setColor(new Color(0, 0, 0, 128));
            g.fillRect(getWidth() - 140, 45, 130, 30);

            // draw coin counter on the right side
            ImageIcon coinIcon = new ImageIcon("data/coin.png");
            Image coinImage = coinIcon.getImage();
            g.drawImage(coinImage, getWidth() - 180, 35, 50,50, this);
            g.setColor(Color.WHITE);
            g.setFont(STATUS_FONT);
            g.drawString("Coins: " + coinCount, getWidth() - 120, 65);

        }
    }


    /**
     * Updates the KulaPlayer instance in the view.
     * @param kulaPlayer The KulaPlayer instance to update.
     */
    public void updateKula(KulaPlayer kulaPlayer) {
        this.kula = kula;
    }

    /**
     * Changes the background image of the view.
     * @param imagePath The file path of the new background image.
     */
    public void changeBackground(String imagePath) {
        // Load the new background image
        ImageIcon newBackgroundIcon = new ImageIcon(imagePath);
        Image newBackgroundImage = newBackgroundIcon.getImage();

        // Set the new background image
        background = newBackgroundImage;

        // Repaint the view to reflect the change
        repaint();
    }
}