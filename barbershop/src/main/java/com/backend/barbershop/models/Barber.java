package com.backend.barbershop.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

  @JsonManagedReference
  @OneToMany(mappedBy = "barber", cascade = CascadeType.ALL)
  private List<Reservation> reservations = new ArrayList<>();

  @JsonBackReference
  @ManyToOne
  @JoinColumn(name = "salon_id")
  private Salon salon = new Salon();


  public Barber() {}

  public Barber(
    Salon salon,
    String name,
    List<String> services,
    List<Reservation> reservations,
    String address
  ) {
    this.salon = salon;
    this.name = name;
    this.services = services;
    this.reservations = reservations;
    this.address = address;
  }

  // Getters
  public Long getId() {
    return id;
  }

  public Salon getSalon() {
    return salon;
  }

  public String getName() {
    return name;
  }

  public List<String> getServices() {
    return services;
  }

  public List<Reservation> getReservations() {
    return reservations;
  }

  public String getAddress() {
    return address;
  }

  // Setters
  public void setSalon(Salon salon) {
    this.salon = salon;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setServices(List<String> services) {
    this.services = services;
  }

  public void setReservations(List<Reservation> reservations) {
    this.reservations = reservations;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
