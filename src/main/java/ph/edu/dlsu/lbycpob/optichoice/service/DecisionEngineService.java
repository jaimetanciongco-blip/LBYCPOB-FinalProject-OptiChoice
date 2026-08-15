package ph.edu.dlsu.lbycpob.optichoice.service;

import ph.edu.dlsu.lbycpob.optichoice.model.Choice;
import ph.edu.dlsu.lbycpob.optichoice.model.Criterion;
import ph.edu.dlsu.lbycpob.optichoice.model.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DecisionEngineService {

    public DomainCategory getDomain(String type) {
        if (type == null) {
            return new AcademicDomain();
        }
        return switch (type.toLowerCase()) {
            case "academic" -> new AcademicDomain();
            case "professional" -> new ProfessionalDomain();
            case "financial" -> new FinancialDomain();
            case "health" -> new HealthDomain();
            case "social" -> new SocialDomain();
            default -> new AcademicDomain();
        };
    }

    public List<Choice> evaluateChoices(List<Choice> choices, DomainCategory domain) {
        for (Choice choice : choices) {
            double total = 0.0;
            for (Criterion c : choice.getCriteriaList()) {
                total += domain.calculateWeightedScore(c.getScore(), c.getWeight());
            }
            choice.setCalculatedScore(Math.round(total * 100.0) / 100.0);
        }
        choices.sort((a, b) -> Double.compare(b.getCalculatedScore(), a.getCalculatedScore()));
        return choices;
    }
}
