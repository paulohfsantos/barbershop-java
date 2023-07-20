package com.backend.barbershop.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "salon_id")
    private Salon salon = null;

    @Column(nullable = false)
    private String customer;

    @Column(nullable = false)
    private LocalDateTime date = LocalDateTime.now();


    public Reservation() {}

    public Reservation(Salon salon, String customer, LocalDateTime date) {
        this.salon = salon;
        this.customer = customer;
        this.date = date;
    }

    // getters
    public Long getId() {
        return id;
    }

    public Salon getSalon() {
        return salon;
    }

    public String getCustomer() {
        return customer;
    }

    public LocalDateTime getDate() {
        return date;
    }

    // setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}
