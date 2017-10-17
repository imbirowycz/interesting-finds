package pl.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.spring.entity.Discovery;
import pl.spring.service.DiscoveryService;

import java.util.List;

/**
 * @author Andrzej I.
 * copyright 02.10.17.
 *
 * Home controller
 **/
@Controller
public class HomeController {

    private DiscoveryService discoveryService;

    @Autowired
    public HomeController(DiscoveryService discoveryService) {
        this.discoveryService = discoveryService;
    }

    @RequestMapping("/")
    public String home(Model model) {
        List<Discovery> discoverList = discoveryService.findWszytkieDiscovery();
        model.addAttribute("discoveryList", discoverList);
        return "hello";
    }

    @GetMapping("/login")
    public String logowanie() {

        return "loginForm";
    }

}
