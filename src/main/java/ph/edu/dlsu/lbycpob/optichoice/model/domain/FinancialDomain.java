package ph.edu.dlsu.lbycpob.optichoice.model.domain;

import java.util.Arrays;
import java.util.List;

public class FinancialDomain extends DomainCategory {
    public FinancialDomain() {
        super("Financial", "Evaluate purchases, investments, and budgeting decisions.");
    }

    @Override
    public List<String> getDefaultCriteria() {
        return Arrays.asList("Return on Investment (ROI)", "Affordability / Upfront Cost", "Long-term Value", "Financial Risk");
    }

    @Override
    public double calculateWeightedScore(double rawScore, int weight) {
        return rawScore * (weight * 1.25);
    }
}
