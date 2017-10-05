package pl.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.spring.entity.Discovery;
import pl.spring.models.Person;
import pl.spring.service.DiscoveryService;

import java.security.Principal;
import java.util.List;

/**
 * @author Andrzej I.
 * copyright 02.10.17.
 *
 * Home controller
 **/
@Controller
public class Home {
    private DiscoveryService discoveryService;
    private Person person;
    @Autowired
    public Home(DiscoveryService discoveryService, Person person) {
        this.discoveryService = discoveryService;
    }

    @RequestMapping("/")
    public String home(Model model) {
        List<Discovery> discoverList = discoveryService.findWszytkieDiscovery();
        model.addAttribute("discoveryList", discoverList);
        return "hello";
    }


    @GetMapping("/secret")
    @ResponseBody
    public Person goSecret(Principal principal) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Person userDetail = (Person) auth.getPrincipal();
        return userDetail;
    }

    @GetMapping("/login")
    public String logowanie() {

        return "loginForm";
    }

}
