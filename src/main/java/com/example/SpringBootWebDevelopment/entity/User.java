package com.example.SpringBootWebDevelopment.entity;

//import com.example.SpringBootWebDevelopment.validation.UniqueEmail;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users") // Ensure the table name is correct
public class User{
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

    
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 20, message = "Name must be between 2 and 20 characters")
    private String name;
    
    @Email(message="Enter valid email address")
    @NotBlank(message="mail is required")
//    @UniqueEmail
    private String email;
    
    

    
    public enum Gender {
        MALE, FEMALE, OTHER
    }

    public enum Country {
        INDIA, USA, CANADA, UK, AUSTRALIA
    }
    
    @NotNull(message = "Gender is required")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull(message = "Country is required")
    @Enumerated(EnumType.STRING)
    private Country country;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}



