package com.aml.database.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "Username")
    private String username; 

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password; 

    @Column(name = "City")
    private String city; 

    @Column(name = "Role")
    private String role; 

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
     @JsonManagedReference
    private List<Branch> branch = new ArrayList<>(); 
}
