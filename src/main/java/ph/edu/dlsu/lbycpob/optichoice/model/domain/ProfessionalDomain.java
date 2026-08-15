package ph.edu.dlsu.lbycpob.optichoice.model.domain;

import java.util.Arrays;
import java.util.List;

public class ProfessionalDomain extends DomainCategory {
    public ProfessionalDomain() {
        super("Professional", "Compare job offers, internships, and career transitions.");
    }

    @Override
    public List<String> getDefaultCriteria() {
        return Arrays.asList("Career Growth", "Compensation & Benefits", "Work-Life Balance", "Company Culture");
    }

    @Override
    public double calculateWeightedScore(double rawScore, int weight) {
        return rawScore * (weight * 1.2);
    }
}
