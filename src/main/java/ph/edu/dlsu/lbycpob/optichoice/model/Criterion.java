package ph.edu.dlsu.lbycpob.optichoice.model;

public class Criterion {
    private String name;
    private double score;
    private int weight;

    public Criterion() {
    }

    public Criterion(String name, double score, int weight) {
        this.name = name;
        this.score = score;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
