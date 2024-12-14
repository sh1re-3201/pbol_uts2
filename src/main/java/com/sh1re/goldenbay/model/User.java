package com.sh1re.goldenbay.model;


import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String email;

    private LocalDateTime membershipDate;
}

enum Role {
    ADMIN,
    USER
}
