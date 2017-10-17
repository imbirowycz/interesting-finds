package pl.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.spring.entity.Comments;
import pl.spring.service.CommentsService;

import javax.servlet.http.HttpSession;
import java.security.Principal;

/**
 * copyright 10.10.17.
 * author Andrzej I.
 **/
@Controller
@RequestMapping("/discovery/comments")
public class CommentsController {

    private CommentsService commentsService;

    @Autowired
    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @GetMapping("/add")
    public String setAttribut(@RequestParam Long param, Model model, HttpSession session) {
        model.addAttribute("comments", new Comments());
        session.setAttribute("id_discovery", param);
        return "commentsForm";
    }
    @PostMapping("/add")
    public String addDiscovery(Comments comments, Principal principal, HttpSession session) {
        String id_user = principal.getName();
        Long id_discovery = (Long) session.getAttribute("id_discovery");
        commentsService.saveComments(comments, id_user, id_discovery);
        return "redirect:/";
    }
}
