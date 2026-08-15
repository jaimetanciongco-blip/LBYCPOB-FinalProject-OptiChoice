package ph.edu.dlsu.lbycpob.optichoice.model;

import java.util.ArrayList;
import java.util.List;

public class Choice {
    private String optionName;
    private double calculatedScore;
    private List<Criterion> criteriaList = new ArrayList<>();

    public Choice() {
    }

    public Choice(String optionName) {
        this.optionName = optionName;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public double getCalculatedScore() {
        return calculatedScore;
    }

    public void setCalculatedScore(double calculatedScore) {
        this.calculatedScore = calculatedScore;
    }

    public List<Criterion> getCriteriaList() {
        return criteriaList;
    }

    public void setCriteriaList(List<Criterion> criteriaList) {
        this.criteriaList = criteriaList;
    }

    public void addCriterion(Criterion criterion) {
        this.criteriaList.add(criterion);
    }
}
