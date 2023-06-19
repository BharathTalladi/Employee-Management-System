package com.learning.employeemanagement.controller;

import com.learning.employeemanagement.dto.UserRegistrationDto;
import com.learning.employeemanagement.entity.User;
import com.learning.employeemanagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@Valid @ModelAttribute("user") UserRegistrationDto registrationDto,
                                       BindingResult result, Model model) {
        User existingUser=userService.findUserByEmail(registrationDto.getEmail());
        if(existingUser!=null && existingUser.getEmail()!=null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email",null,"There is already and account registered with the same email");
        }
        if(result.hasErrors()){
            model.addAttribute("user",registrationDto);
            return "/registration";
        }
        userService.save(registrationDto);
        return "redirect:/registration?success";
    }

}
