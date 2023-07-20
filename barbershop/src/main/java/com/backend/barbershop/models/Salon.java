package com.backend.barbershop.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

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

  @JsonManagedReference
  @OneToMany
  @JoinColumn(name = "salon_id")
  private List<Reservation> reservations = new ArrayList<>();

  @JsonManagedReference
  @OneToMany
  @JoinColumn(name = "salon_id")
  private List<Barber> barbers = new ArrayList<>();

  public Salon() {}

  public Salon(
    String name,
    String location,
    List<Reservation> reservations,
    List<Barber> barbers
  ) {
    this.name = name;
    this.location = location;
    this.reservations = reservations;
    this.barbers = barbers;
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

  public List<Reservation> getReservations() {
    return reservations;
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

  public void setReservations(List<Reservation> reservations) {
    this.reservations = reservations;
  }
}
