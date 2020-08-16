package ua.prin.rom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.prin.rom.entity.User;
import ua.prin.rom.repository.UserRepository;

@Controller
public class RegistrationController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String getLink(){
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@RequestParam(name="j_login")String login
            , @RequestParam(name="j_password")String password
            , @RequestParam(name="j_firstName")String firstName
            , @RequestParam(name="j_lastName")String lastName
            , @RequestParam(name="j_email")String email
            , @RequestParam(name="j_phone")String phone
            , Model model)
    {
        if(userRepository.existsByEmail(email) && userRepository.existsByPhone(phone) && userRepository.existsByLogin(login)){
            model.addAttribute("emailEr", true);
            model.addAttribute("phoneEr", true);
            model.addAttribute("loginEr", true);
            return "registration";
        }
        if(userRepository.existsByLogin(login)){
            model.addAttribute("loginEr", true);
            return "registration";
        }
        if(userRepository.existsByEmail(email)){
            model.addAttribute("emailEr", true);
            return "registration";
        }
        if(userRepository.existsByPhone(phone)){
            model.addAttribute("phoneEr", true);
            return "registration";
        }
        String hashPass = passwordEncoder.encode(password);

        User user = new User.Builder()
                .withLogin(login)
                .withEmail(email)
                .withFirstName(firstName)
                .withHashPass(hashPass)
                .withLastName(lastName)
                .withPhone(phone)
                .withRole(User.Role.USER)
                .withState(User.State.ACTIVE)
                .build();
        userRepository.save(user);

        return "login";
    }
}
