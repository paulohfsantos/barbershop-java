package com.backend.barbershop;

import com.backend.barbershop.models.Salon;
import com.backend.barbershop.models.Reservation;
import com.backend.barbershop.models.Barber;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class EntityTests {
  @Autowired
  private TestEntityManager entityManager;
  @Test
  public void testSalonCreation() {
    Salon salon = new Salon("Salon Name", "123 Street", Collections.emptyList(), Collections.emptyList());
    entityManager.persist(salon);
    entityManager.flush();
  }

  @Test
  public void testBarberCreation() {
    Barber barber = new Barber(null, "John", Arrays.asList("Haircut", "Shave"), Collections.emptyList(), "123 Street");
    entityManager.persist(barber);
    entityManager.flush();

    Barber retrievedBarber = entityManager.find(Barber.class, barber.getId());
    assertThat(retrievedBarber).isEqualTo(barber);
  }

  @Test
  public void testReservationCreation() {
    Barber barber = new Barber(null, "John", Arrays.asList("Haircut", "Shave"), Collections.emptyList(), "123 Street");
    entityManager.persist(barber);
    entityManager.flush();

    Reservation reservation = new Reservation(null, "Customer Name", LocalDateTime.now(), barber);
    entityManager.persist(reservation);
    entityManager.flush();

    Reservation retrievedReservation = entityManager.find(Reservation.class, reservation.getId());
    assertThat(retrievedReservation).isEqualTo(reservation);
  }
}
