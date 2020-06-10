package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repository.RoleRepository;
import pl.coderslab.charity.repository.UserRepository;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserController(UserRepository userRepository, RoleRepository roleRepository){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }


    @PostMapping("/login")
    public String loginSubmit(HttpSession httpSession, @RequestParam String email, @RequestParam String password){
        User user = userRepository.findByEmailAndPassword(email,password);
        httpSession.setAttribute("user",user);

        return "redirect:/";
    }
}
