package com.sun.ch03.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Data
public class User {
    private String username;
    private String password;
    private Boolean gender;
    private Integer age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    private List<String> interests;
}
