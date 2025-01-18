package elements;
import java.util.List;
import util.Score;

public class TargetGroupMediator implements Mediator{
    private List<Target> targets;
    private List<Ramp> ramps;

    public TargetGroupMediator(List<FlipperElement> elements) {
        this.targets = elements.stream()
                .filter(e -> e instanceof Target)
                .map(e -> (Target) e)
                .toList(); // Extract targets
        this.ramps = elements.stream()
                .filter(e -> e instanceof Ramp)
                .map(e -> (Ramp) e)
                .toList(); // Extract ramps
    }

    @Override
    public void notifyTargetHit(Target target) {
        // Check if all targets in the group have been hit
        boolean allTargetsHit = targets.stream().allMatch(Target::isLightOn);

        if (allTargetsHit) {
            triggerGroupBehavior();
        }
    }

    private void triggerGroupBehavior() {
        System.out.println("All targets hit! Triggering bonus behavior...");
        Score.getInstance().updateScore(50); // Add bonus score
        ramps.forEach(Ramp::setRamp); // switches isUp boolean to opposite
        targets.forEach(Target::reset);      // Reset all targets
    }
}
