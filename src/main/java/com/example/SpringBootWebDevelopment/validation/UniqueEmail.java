//package com.example.SpringBootWebDevelopment.validation;
//
//import java.lang.annotation.Documented;
//
//import java.lang.annotation.Target;
//import java.lang.annotation.ElementType;  // ✅ RIGHT
//import java.lang.annotation.Retention;
//import static java.lang.annotation.RetentionPolicy.RUNTIME;
//import jakarta.validation.Constraint;
//import jakarta.validation.Payload;
//
//@Documented
//@Constraint(validatedBy = UniqueEmailValidator.class)
//@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE })  // Field-level validation
//@Retention(RUNTIME)
//public @interface UniqueEmail {
//    String message() default "Email already exists";
//    Class<?>[] groups() default {};
//    Class<? extends Payload>[] payload() default {};
//}
