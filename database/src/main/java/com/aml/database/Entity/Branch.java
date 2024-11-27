package com.aml.database.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "branch")
public class Branch {

    @Id
    @GeneratedValue

    private int id;
    private String Branchname;
    private String location;
    private String City;

    @OneToMany(mappedBy = "branch")
    @JsonManagedReference
    private List<Media> media;
    
     @ManyToOne
    @JoinColumn(name = "admin_id") 
    @JsonBackReference
    private Admin admin; 
}
