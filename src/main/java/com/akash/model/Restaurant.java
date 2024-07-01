package com.akash.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    private String cuisineType;

    @OneToOne
    private User owner;

    @OneToOne
    private Address address;

    @Embedded
    private ContactInformation contactInformation;

    private String openingHours;

    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;

    @ElementCollection
    @Column(length = 1000)
    private List<String> images;

    private LocalDateTime registration;

    private boolean open;

    @JsonIgnore
    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL)
    private List<Food> foods;
}
