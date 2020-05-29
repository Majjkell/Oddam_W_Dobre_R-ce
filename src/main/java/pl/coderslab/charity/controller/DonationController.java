package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Instytution;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstytutionRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DonationController {
    private final DonationRepository donationRepository;
    private final CategoryRepository categoryRepository;
    private final InstytutionRepository instytutionRepository;

    @Autowired
    public DonationController(DonationRepository donationRepository, CategoryRepository categoryRepository, InstytutionRepository instytutionRepository){
        this.donationRepository = donationRepository;
        this.instytutionRepository = instytutionRepository;
        this.categoryRepository = categoryRepository;
    }




    @GetMapping("/form")
    public String donationForm(Model model){
        List<Instytution> instytutions = instytutionRepository.findAll();
        model.addAttribute("instytutions",instytutions);

        Donation donation = new Donation();
        model.addAttribute("donation",donation);

        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories",categories);

        return "form";
    }

    @PostMapping("/form")
    public String confirmForm(@ModelAttribute Donation donation){
        donationRepository.save(donation);
        return "form-confirm";
    }
}
