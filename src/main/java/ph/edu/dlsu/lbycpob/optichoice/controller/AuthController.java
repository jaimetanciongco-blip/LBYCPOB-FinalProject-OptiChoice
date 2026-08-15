package ph.edu.dlsu.lbycpob.optichoice.controller;

import ph.edu.dlsu.lbycpob.optichoice.model.User;
import ph.edu.dlsu.lbycpob.optichoice.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username,
                              @RequestParam String password,
                              Model model) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return "redirect:/categories";
        }
        model.addAttribute("error", "Invalid username or password.");
        return "login";
    }

    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public String handleSignup(@RequestParam String username,
                               @RequestParam String email,
                               @RequestParam String password) {
        userRepository.save(new User(username, email, password));
        return "redirect:/login";
    }
}