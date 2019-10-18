package by.it.training.library.controller;

import by.it.training.library.entity.Role;
import by.it.training.library.entity.RoleType;
import by.it.training.library.entity.User;
import by.it.training.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GuestDispatcher {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String welcome(Model model, Principal principal) {
        return "main";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("page", "common/about.jsp");
        return "main";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("page", "common/login.jsp");
        return "main";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("page", "common/registration.jsp");
        return "main";
    }

    @PostMapping("/registration")
    public String registration(Model model, @ModelAttribute("user") User user) {
        System.out.println("registration post: ???");

        user.setBeginning(Timestamp.from(Instant.now()));
        user.setRole(new Role(){
            {setRoleType(RoleType.GUEST);}
        });

        System.out.println("registration post: 1");
        System.out.println(user.getLogin());
        System.out.println(user.getPassword());
        System.out.println(user.getEmail());
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());
        System.out.println(user.getBeginning());
        System.out.println(user.getEnding());
        System.out.println(user.getRole());
        System.out.println("registration post: 2");

        userService.registration(user);
        System.out.println("registration post: 3");
        model.addAttribute("user", user);
        model.addAttribute("page", "common/login.jsp");
        System.out.println("registration post: 4");
        return "main";
    }
}
