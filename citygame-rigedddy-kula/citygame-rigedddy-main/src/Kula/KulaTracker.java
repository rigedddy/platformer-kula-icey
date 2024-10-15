package Kula;

import city.cs.engine.*;
import game.GameView;
import org.jbox2d.common.Vec2;

/**
 * @author      nazifa, firoz, nazifa.firoz@city.ac.uk
 */

public class KulaTracker implements StepListener { // the view follows kula
    private GameView view;
    private KulaPlayer kula;

    /**
     * Constructs a KulaTracker instance with the specified GameView and KulaPlayer.
     * @param view The GameView to be tracked.
     * @param kula The KulaPlayer whose position will be tracked.
     */
    public KulaTracker(GameView view, KulaPlayer kula) {
        this.view = view;
        this.kula = kula;
    }
    public void preStep(StepEvent e) {}

    /**
     * Updates the view to follow Kula's position after each step.
     * @param e The StepEvent.
     */
    public void postStep(StepEvent e) {
        view.setCentre(new Vec2(kula.getPosition()));
    }

}
