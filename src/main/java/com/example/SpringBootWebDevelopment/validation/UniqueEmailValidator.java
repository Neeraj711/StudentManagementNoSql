//package com.example.SpringBootWebDevelopment.validation;
//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.stereotype.Component;
//import org.springframework.beans.factory.annotation.Autowired;
//import com.example.SpringBootWebDevelopment.repository.UserRepository;
//import jakarta.validation.ConstraintValidator;
//import jakarta.validation.ConstraintValidatorContext;
//
//@Component
//public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public void initialize(UniqueEmail constraintAnnotation) {
//    }
//
//    @Override
//    public boolean isValid(String email, ConstraintValidatorContext context) {
//        System.out.println("Validating email: " + email);
//        
//        if (email == null || email.isEmpty()) {
//            return true;
//        }
//
//        if (userRepository == null) {
//            System.out.println("userRepository is NULL!!!");
//            throw new RuntimeException("UserRepository is not injected!");
//        }
//
//        boolean exists = userRepository.existsByEmail(email);
//        System.out.println("Email exists? " + exists);
//        return !exists;
//    }
//}
