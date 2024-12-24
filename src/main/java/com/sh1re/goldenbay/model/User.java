package com.sh1re.goldenbay.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Users")
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

    public User() {
    }

    public User(String username, String password, Role role, String email, LocalDateTime membershipDate) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.membershipDate = membershipDate;
    }

    public Long getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public Role getRole() {
        return this.role;
    }

    public String getEmail() {
        return this.email;
    }

    public LocalDateTime getMembershipDate() {
        return this.membershipDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMembershipDate(LocalDateTime membershipDate) {
        this.membershipDate = membershipDate;
    }

    public String toString() {
        return "User(id=" + this.getId() + ", username=" + this.getUsername() + ", password=" + this.getPassword() + ", role=" + this.getRole() + ", email=" + this.getEmail() + ", membershipDate=" + this.getMembershipDate() + ")";
    }
}

