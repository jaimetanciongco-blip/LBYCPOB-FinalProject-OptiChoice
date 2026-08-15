package ph.edu.dlsu.lbycpob.optichoice.model.domain;

import java.util.List;

public abstract class DomainCategory {
    private String name;
    private String description;

    public DomainCategory(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public abstract List<String> getDefaultCriteria();
    public abstract double calculateWeightedScore(double rawScore, int importanceWeight);

}
