package com.backend.barbershop.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

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

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "barber_id")
    private Barber barber = new Barber();


    public Reservation() {}

    public Reservation(Salon salon, String customer, LocalDateTime date, Barber barber) {
        this.salon = salon;
        this.customer = customer;
        this.date = date;
        this.barber = barber;
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

    public Barber getBarber() {
        return barber;
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

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setBarber(Barber barber) {
        this.barber = barber;
    }
}
