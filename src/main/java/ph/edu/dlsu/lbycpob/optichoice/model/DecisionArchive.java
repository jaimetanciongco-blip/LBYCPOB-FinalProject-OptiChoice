package ph.edu.dlsu.lbycpob.optichoice.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "decision_archive")

public class DecisionArchive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String domainName;
    private String optionA;
    private String optionB;
    private String winningChoice;
    private double winningScore;
    private LocalDateTime decidedAt;

    public DecisionArchive() {
    }

    public DecisionArchive(String username, String domainName, String optionA, String optionB, String winningChoice, double winningScore) {
        this.username = username;
        this.domainName = domainName;
        this.optionA = optionA;
        this.optionB = optionB;
        this.winningChoice = winningChoice;
        this.winningScore = winningScore;
        this.decidedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getUsername() { return username; }

    public String getDomainName() {
        return domainName;
    }

    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getWinningChoice() {
        return winningChoice;
    }

    public double getWinningScore() {
        return winningScore;
    }

    public LocalDateTime getDecidedAt() {
        return decidedAt;

    }
}
