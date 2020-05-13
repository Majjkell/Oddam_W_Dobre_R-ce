package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Instytution;
import pl.coderslab.charity.repository.InstytutionRepository;

import java.util.List;


@Controller
public class HomeController {
    private final InstytutionRepository instytutionRepository;

    @Autowired
    public HomeController (InstytutionRepository instytutionRepository){
        this.instytutionRepository = instytutionRepository;
    }

    @RequestMapping("/")
    public String homeAction(Model model){
        List<Instytution> instytutions = instytutionRepository.findAll();
        for (Instytution i:instytutions) {
            System.out.println(i.toString());
        }
        model.addAttribute("instytutions",instytutions);
        return "index";
    }
}
