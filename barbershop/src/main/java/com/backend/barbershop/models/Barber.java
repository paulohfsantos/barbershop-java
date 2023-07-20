package com.backend.barbershop.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "barbers")
public class Barber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Barber name is required")
    @Column(nullable = false)
    private String name;

    @NotNull(message = "Barber address is required")
    @Column(nullable = false)
    private String address;

    @ElementCollection
    @CollectionTable(name = "barber_services", joinColumns = @JoinColumn(name = "barber_id"))
    @Column(name = "barber_services")
    private List<String> services = new ArrayList<>();
}
