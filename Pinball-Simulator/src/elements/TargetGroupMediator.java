package elements;
import java.util.List;
import score.Score;

public class TargetGroupMediator implements Mediator{
    private List<Target> targets;

    public TargetGroupMediator(List<Target> targets) {
        this.targets = targets;
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
        targets.forEach(Target::reset);      // Reset all targets
    }
}
