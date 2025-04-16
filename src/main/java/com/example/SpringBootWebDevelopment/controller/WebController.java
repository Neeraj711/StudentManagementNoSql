package com.example.SpringBootWebDevelopment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable; // ✅ CORRECT

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.SpringBootWebDevelopment.entity.User;
import com.example.SpringBootWebDevelopment.repository.UserRepository;
import com.example.SpringBootWebDevelopment.services.UserService;

import jakarta.validation.Valid;

@Controller

public class WebController {

//    public static Object listUsers;
	@Autowired
	private UserRepository userRepository;

//    @GetMapping("/")
//    public String listUsers(Model model) {
//        model.addAttribute("users", userRepository.findAll());
//        return "index";
//    }

    @GetMapping("/")
    public String listUsers(Model model, @RequestParam(defaultValue = "1") int page,
                            @RequestParam(defaultValue = "5") int size,
                            @RequestParam(defaultValue = "name") String sortBy) {

        PageRequest pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<User> userPage = userRepository.findAll(pageable);

        model.addAttribute("users", userPage.getContent());
        model.addAttribute("totalPages", userPage.getTotalPages());
        model.addAttribute("currentPage", page);
        return "index";
    }
//    
//    @GetMapping("/")
//    public String listUsers(Model model, @RequestParam(defaultValue = "1") int page,
//                            @RequestParam(defaultValue = "5") int size,
//                            @RequestParam(defaultValue = "name") String sortBy) {
//
//        PageRequest pageable = PageRequest.of(page - 1, size, Sort.by(sortBy));  // Adjusted page (zero-based index)
//        Page<User> userPage = userRepository.findAll(pageable);
//
//        model.addAttribute("users", userPage.getContent());
//        model.addAttribute("totalPages", userPage.getTotalPages());
//        model.addAttribute("currentPage", page);
//        model.addAttribute("totalItems", userPage.getTotalElements());
//
//        return "index";  // The name of the Thymeleaf template
//    }

    
//    
//    @GetMapping("/")
//    public String listUsers(Model model) {
//        // Get all users from the repository
//        List<User> users = userRepository.findAll();
//        
//        // Add the list of users to the model
//        model.addAttribute("users", users);
//        
//        // Add success message if present (if a user was added successfully)
//        model.addAttribute("success", "User added successfully!");
//        
//        return "index"; // Return the name of the Thymeleaf template (index.html)
//    }
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }

    @PostMapping("/add")
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult result,
                          RedirectAttributes redirectAttributes) {

        if (userRepository.existsByEmail(user.getEmail())) {
            result.rejectValue("email", "error.user", "Email already exists");
        }

        if (result.hasErrors()) {
            return "add-user";
        }

        userRepository.save(user);
        redirectAttributes.addFlashAttribute("success", "User added successfully!");
        return "redirect:/";
    }
    
    
}
