package pl.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.spring.entity.User;
import pl.spring.service.UserService;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Andrzej I.
 * copyright 02.10.17.
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }


    @GetMapping("/register")
    public String registerGet(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@ModelAttribute @Valid User user,
                          BindingResult bindResult) {
        if(bindResult.hasErrors())
            return "register";
        else {
            userService.addWithDefaultRole(user);
            return "loginForm";
        }
    }

    @GetMapping("/getAll")
    public String wyszukajWszystkichUżytkowników(Model model) {
        List<User> allUserList = userService.findAllUsers();
        model.addAttribute("allUserList", allUserList);
        return "allUsersList";
    }

}
