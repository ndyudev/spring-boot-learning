package com.ndyudev.lab6.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Accounts")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    private String username;
    @Column(name = "Fullname", columnDefinition = "nvarchar(50)")
    private String fullName;
    private String password;
    private String email;
    private String photo;
    private Boolean activated;
    private Boolean admin;
}
