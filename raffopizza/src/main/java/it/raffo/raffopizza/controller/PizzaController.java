package it.raffo.raffopizza.controller;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import it.raffo.raffopizza.repository.PizzaRepo;
import it.raffo.raffopizza.model.Pizza;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/index")
public class PizzaController {

    @Autowired
    private PizzaRepo repo;

    @GetMapping
    public String index(Model model) {

        java.util.List<Pizza> pizzeList = repo.findAll();
        model.addAttribute("list", pizzeList);

        return "/pizza/index";
    }

}
