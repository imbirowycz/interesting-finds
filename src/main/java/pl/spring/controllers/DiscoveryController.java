package pl.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.spring.entity.Discovery;
import pl.spring.service.DiscoveryService;

import java.security.Principal;
import java.util.List;

/**
 * @author Andrzej I.
 * copyright 02.10.17.
 **/
@Controller
@RequestMapping("/discovery")
public class DiscoveryController {

    private DiscoveryService discoveryService;

    @Autowired
    public DiscoveryController(DiscoveryService discoveryServece) {
        this.discoveryService = discoveryServece;
    }
    @GetMapping("/add")
    public String addGet(Model model) {
        model.addAttribute("discovery",new Discovery());
        return "discoveryForm";
    }

    @PostMapping("/add")
    @ResponseBody
    public String addDiscovery(@ModelAttribute Discovery discovery, Principal principal) {
        String email = principal.getName();
        discoveryService.save(discovery, email);
        return "Dodano pomyślnie";
    }

    @GetMapping("/szukaj/tytul")
    @ResponseBody
    public List<Discovery> wyszukiwaniPoTytule(@RequestParam String param ) {
        return discoveryService.wyszukaj(param);
    }

    @GetMapping("/sortuj")
    @ResponseBody
    public List<Discovery> sortowanie(@RequestParam String param) {
        return discoveryService.sortujWedlug(param);
    }
}
