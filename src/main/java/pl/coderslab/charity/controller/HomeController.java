package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Instytution;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstytutionRepository;

import java.util.List;


@Controller
public class HomeController {
    private final InstytutionRepository instytutionRepository;
    private final DonationRepository donationRepository;

    @Autowired
    public HomeController(InstytutionRepository instytutionRepository, DonationRepository donationRepository) {
        this.instytutionRepository = instytutionRepository;
        this.donationRepository = donationRepository;
    }

    @RequestMapping("/")
    public String homeAction(Model model) {
        List<Instytution> instytutions = instytutionRepository.findAll();
        model.addAttribute("instytutions", instytutions);

        int donationsQuantity = donationRepository.findDonationsQuantity();
        model.addAttribute("donationsQuantity", donationsQuantity);

        int donationsCount = donationRepository.findDonationsCount();
        model.addAttribute("donationsCount", donationsCount);

        return "index";
    }
}
