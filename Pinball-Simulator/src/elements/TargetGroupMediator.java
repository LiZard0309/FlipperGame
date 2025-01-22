package elements;

import java.util.ArrayList;
import java.util.List;
import util.Score;

public class TargetGroupMediator implements Mediator, Observer {
    private final List<Target> targets = new ArrayList<>();
    private final List<Ramp> ramps = new ArrayList<>();

    @Override
    public void update(FlipperElement element) {
        if (element instanceof Target) {
            targets.add((Target) element);
        } else if (element instanceof Ramp) {
            ramps.add((Ramp) element);
        }
    }

    @Override
    public void notifyTargetHit(Target target) {
        // Checks if all targets in the group have been hit
        boolean allTargetsHit = targets.stream().allMatch(Target::isLightOn);

        if (allTargetsHit) {
            triggerGroupBehavior();
        }
    }

    private void triggerGroupBehavior() {
        System.out.println("Alle Targets der Gruppe aktiv! 50 Bonuspunkte und Rampen werden umgestellt.");
        Score.getInstance().updateScore(50); // Adds bonus score
        ramps.forEach(Ramp::setRamp); // switches isUp boolean to opposite
        targets.forEach(Target::reset); // Resets all targets
    }
}
