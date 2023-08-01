package com.backend.barbershop.repositories;

import com.backend.barbershop.models.Salon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalonRepository extends JpaRepository<Salon, Long> {}
