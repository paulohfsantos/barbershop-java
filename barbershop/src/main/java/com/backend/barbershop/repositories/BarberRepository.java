package com.backend.barbershop.repositories;

import com.backend.barbershop.models.Barber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarberRepository extends JpaRepository<Barber, Long> {}
