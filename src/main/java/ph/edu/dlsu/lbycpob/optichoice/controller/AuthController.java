package ph.edu.dlsu.lbycpob.optichoice.controller;

import jakarta.servlet.http.HttpSession;
import ph.edu.dlsu.lbycpob.optichoice.model.User;
import ph.edu.dlsu.lbycpob.optichoice.repository.UserRepository;
import org.springframework.dao.DataIntegrityViolationException;
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

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username,
                               @RequestParam String password,
                               HttpSession session,
                               Model model) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            session.setAttribute("username", username);
            return "redirect:/categories";
        }
        model.addAttribute("error", "Invalid username or password.");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public String handleSignup(@RequestParam String username,
                               @RequestParam String email,
                               @RequestParam String password,
                               Model model) {
        try {
            userRepository.save(new User(username, email, password));
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("error", "That username or email is already registered.");
            return "signup";
        }
        return "redirect:/login";
    }

    @GetMapping("/forgot-password")
    public String forgotPasswordPage() {
        return "forgot-password";
    }

    @PostMapping("/forgot-password")
    public String handleForgotPassword(@RequestParam String username,
                                       @RequestParam String email,
                                       @RequestParam String newPassword,
                                       @RequestParam String confirmPassword,
                                       Model model) {
        if (!newPassword.equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match.");
            return "forgot-password";
        }

        Optional<User> user = userRepository.findByUsernameAndEmail(username, email);
        if (user.isEmpty()) {
            model.addAttribute("error", "No account found with that username and email combination.");
            return "forgot-password";
        }

        User foundUser = user.get();
        foundUser.setPassword(newPassword);
        userRepository.save(foundUser);

        return "redirect:/login?resetSuccess";
    }
}