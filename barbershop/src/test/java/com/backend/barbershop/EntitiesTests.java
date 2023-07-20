package com.backend.barbershop;

import com.backend.barbershop.models.Salon;
import com.backend.barbershop.models.Reservation;
import com.backend.barbershop.models.Barber;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;

@DataJpaTest
public class EntitiesTests {
  @Autowired
  private TestEntityManager entityManager;

  public EntitiesTests(TestEntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Test
  public void testSalonReservationMapping() {
    Salon salon = new Salon("Salon", "Location", null, null);
    Reservation reservation = new Reservation(salon, "Customer", null, null);
    Barber barber = new Barber(salon, "Barber", null, null, "Address");

    entityManager.persist(salon);
    entityManager.persist(reservation);
    entityManager.flush();

    // barber
    entityManager.persist(barber);
    entityManager.flush();

    // reservation
    reservation.setBarber(barber);
    entityManager.persist(reservation);
    entityManager.flush();
  }

  @Test
  public void testSalonBarberMapping() {
    Salon salon = new Salon("Salon", "Location", null, null);
    Barber barber = new Barber(salon, "Barber", null, null, "Address");

    entityManager.persist(salon);
    entityManager.persist(barber);
    entityManager.flush();
  }
}
