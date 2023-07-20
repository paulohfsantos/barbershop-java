package com.backend.barbershop.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "salons")
public class Salon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Salon name is required")
    private String name;
    @NotNull(message = "Salon location is required")
    @Column(name = "salon_location")
    private String location;

    public Salon() {}

    public Salon(String name, String location) {
        this.name = name;
        this.location = location;
    }

    // Getters
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getLocation() {
        return location;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLocation(String location) {
        this.location = location;
    }
}
