package Kula;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author      nazifa, firoz, nazifa.firoz@city.ac.uk
 */

public class KulaControl { // handles keyboard input

    private KulaPlayer kula;

    /**
     * Constructs a KulaControl instance with the specified KulaPlayer.
     * @param kula The KulaPlayer instance to be controlled.
     */
    public KulaControl(KulaPlayer kula) {
        this.kula = kula;
    }

    /**
     * Returns a KeyHandler instance for handling keyboard events.
     * @return A KeyHandler instance.
     */
    public KeyHandler getKeyHandler() {
        return new KeyHandler();
    }

    /**
     * Updates the KulaPlayer instance to be controlled.
     * @param newKula The new KulaPlayer instance.
     */
    public void updateKula(KulaPlayer newKula) {
        kula = newKula;
    }

    /**
     * Handles keyboard events for controlling KulaPlayer.
     */
    public class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int code = e.getKeyCode();
            //System.out.println("Key pressed: " + KeyEvent.getKeyText(code));
            switch (code) {
                case KeyEvent.VK_W:
                    if (kula.isFacingRight()) {
                        kula.jump();
                    } else {
                        kula.jump2();
                    }
                    break;
                case KeyEvent.VK_A:
                    kula.walkLeft();
                    break;
                case KeyEvent.VK_D:
                    kula.walkRight();
                    break;
                case KeyEvent.VK_J:
                    if (kula.isFacingRight()) {
                        kula.attack();
                    } else {
                        kula.attack();
                    }
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int code = e.getKeyCode();
            //System.out.println("Key released: " + KeyEvent.getKeyText(code));
            switch (code) {
                case KeyEvent.VK_A, KeyEvent.VK_D:
                    kula.stopWalking();
                    break;
                case KeyEvent.VK_W:
                    kula.stopJump();
                    break;
                case KeyEvent.VK_J:
                    kula.animation();
            }

        }
    }
}