package it.raffo.raffopizza.controller;

import org.apache.el.stream.Optional;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import it.raffo.raffopizza.repository.PizzaRepo;
import it.raffo.raffopizza.model.Pizza;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

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

    @GetMapping("/show/{id}")
    public String show(@PathVariable("id") Integer id, Model model) {

        model.addAttribute("pizza", repo.getReferenceById(id));

        return "/pizza/show";
    }

    @GetMapping("/create")
    public String create(Model model) {

        model.addAttribute("pizza", new Pizza());

        return "/pizza/create";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("pizza") Pizza pizzaForm, BindingResult bindingresult, Model model) {
        // TODO: process POST request
        System.out.println("prima dell'if");
        System.out.println(pizzaForm.getName());
        System.out.println(pizzaForm.getDescription());

        if (bindingresult.hasErrors()) {
            System.out.println("dentro if");
            return "/pizza/create";
        }

        repo.save(pizzaForm);

        return "redirect:/index";

    }

    @GetMapping("/carousel")
    public String photo(Model model) {

        model.addAttribute("pizza", repo.findAll());

        return "/pizza/carousel";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {

        model.addAttribute("pizza", repo.findById(id).get());

        return "/pizza/edit";
    }

    @PostMapping("/edit/{id}")
    public String Update(@Valid @ModelAttribute("pizza") Pizza pizzaUpdate, BindingResult bindingresult, Mode model) {

        if (bindingresult.hasErrors()) {
            return "/pizza/edit";
        }

        repo.save(pizzaUpdate);

        return "redirect:/index";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        // TODO: process POST request

        repo.deleteById(id);

        return "redirect:/index";
    }

}
