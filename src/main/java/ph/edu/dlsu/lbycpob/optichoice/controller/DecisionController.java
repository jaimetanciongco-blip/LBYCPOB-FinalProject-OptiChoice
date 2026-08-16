package ph.edu.dlsu.lbycpob.optichoice.controller;

import jakarta.servlet.http.HttpSession;
import ph.edu.dlsu.lbycpob.optichoice.model.Choice;
import ph.edu.dlsu.lbycpob.optichoice.model.Criterion;
import ph.edu.dlsu.lbycpob.optichoice.model.DecisionArchive;
import ph.edu.dlsu.lbycpob.optichoice.model.domain.DomainCategory;
import ph.edu.dlsu.lbycpob.optichoice.repository.DecisionArchiveRepository;
import ph.edu.dlsu.lbycpob.optichoice.service.DecisionEngineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DecisionController {
    private final DecisionEngineService decisionEngine;
    private final DecisionArchiveRepository archiveRepo;

    public DecisionController(DecisionEngineService decisionEngine, DecisionArchiveRepository archiveRepo) {
        this.decisionEngine = decisionEngine;
        this.archiveRepo = archiveRepo;
    }

    @GetMapping("/categories")
    public String categoriesPage(HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }
        return "categories";
    }

    @GetMapping("/matrix")
    public String matrixPage(@RequestParam(defaultValue = "academic") String domain, HttpSession session, Model model) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }
        DomainCategory domainCategory = decisionEngine.getDomain(domain);
        model.addAttribute("domain", domainCategory);
        model.addAttribute("criteriaList", domainCategory.getDefaultCriteria());
        return "decision-matrix";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam String domain,
                            @RequestParam String optionA,
                            @RequestParam String optionB,
                            @RequestParam List<Double> scoresA,
                            @RequestParam List<Double> scoresB,
                            @RequestParam List<Integer> weights,
                            HttpSession session,
                            Model model) {
        DomainCategory domainCategory = decisionEngine.getDomain(domain);
        List<String> defaultCriteria = domainCategory.getDefaultCriteria();

        Choice choiceA = new Choice(optionA);
        Choice choiceB = new Choice(optionB);

        for (int i = 0; i < defaultCriteria.size(); i++) {
            choiceA.addCriterion(new Criterion(defaultCriteria.get(i), scoresA.get(i), weights.get(i)));
            choiceB.addCriterion(new Criterion(defaultCriteria.get(i), scoresB.get(i), weights.get(i)));
        }

        List<Choice> choices = new ArrayList<>(List.of(choiceA, choiceB));
        List<Choice> ranked = decisionEngine.evaluateChoices(choices, domainCategory);
        boolean isTie = decisionEngine.isTie(ranked);

        String currentUsername = (String) session.getAttribute("username");
        if (currentUsername == null) {
            currentUsername = "guest";
        }

        String winnerName = isTie
                ? (optionA + " & " + optionB + " (Tie)")
                : ranked.get(0).getOptionName();



        archiveRepo.save(new DecisionArchive(
                currentUsername,
                domainCategory.getName(),
                optionA,
                optionB,
                winnerName,
                ranked.get(0).getCalculatedScore()
        ));

        model.addAttribute("domain", domainCategory.getName());
        model.addAttribute("rankedChoices", ranked);
        model.addAttribute("winner", ranked.get(0));
        model.addAttribute("isTie", isTie);
        return "results";
    }

    @GetMapping("/history")
    public String history(HttpSession session, Model model) {
        String currentUsername = (String) session.getAttribute("username");
        if (currentUsername == null) {
            return "redirect:/login";
        }

        model.addAttribute("archives", archiveRepo.findByUsername(currentUsername));
        return "history";
    }
}
