package ph.edu.dlsu.lbycpob.optichoice.model.domain;

import java.util.Arrays;
import java.util.List;

public class HealthDomain extends DomainCategory {
    public HealthDomain() {
        super("Health", "Compare workout plans, diets, and wellness routines.");
    }

    @Override
    public List<String> getDefaultCriteria() {
        return Arrays.asList("Physical Well-being", "Sustainability / Habit Fit", "Time Commitment", "Mental Stress Reduction");
    }

    @Override
    public double calculateWeightedScore(double rawScore, int weight) {
        return rawScore * (weight * 1.15);
    }
}
