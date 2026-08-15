package ph.edu.dlsu.lbycpob.optichoice.model.domain;

import java.util.Arrays;
import java.util.List;

public class AcademicDomain extends DomainCategory {
    public AcademicDomain() {
        super("Academic", "Evaluate courses, research topics, and study schedules.");
    }

    @Override
    public List<String> getDefaultCriteria() {
        return Arrays.asList("Learning Growth", "Workload & Difficulty", "Alignment with Major", "Instructor/Resource Quality");
    }

    @Override
    public double calculateWeightedScore(double rawScore, int weight) {
        return rawScore * (weight * 1.1);
    }
}
