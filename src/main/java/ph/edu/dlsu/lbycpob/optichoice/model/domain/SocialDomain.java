package ph.edu.dlsu.lbycpob.optichoice.model.domain;

import java.util.Arrays;
import java.util.List;


public class SocialDomain extends DomainCategory {
    public SocialDomain() {
        super("Social", "Evaluate extracurriculars, events, and group activities.");
    }

    @Override
    public List<String> getDefaultCriteria() {
        return Arrays.asList("Community Impact", "Networking Opportunities", "Personal Enjoyment", "Time Demand");
    }

    @Override
    public double calculateWeightedScore(double rawScore, int weight) {
        return rawScore * (weight * 1.05);
    }
}
