package com.backend.barbershop.services;

import com.backend.barbershop.exceptions.ExceptionResponse;
import com.backend.barbershop.exceptions.ResponseException;
import com.backend.barbershop.models.Salon;
import com.backend.barbershop.repositories.SalonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SalonService {

  private final Logger logger = LoggerFactory.getLogger(SalonService.class);
  private final SalonRepository salonRepository;
  // private final BarberService barberService;

  @Autowired
  public SalonService(SalonRepository salonRepository) {
    logger.info("SalonService instantiated");
    this.salonRepository = salonRepository;
  }

  public List<Salon> getSalons() {
    return salonRepository.findAll();
  }

  public Salon getSalon(Long salonId) {
    logger.info("id" + salonId);
    return salonRepository.findById(salonId)
      .orElseThrow(() -> new ResponseException("Salon not found", HttpStatus.NOT_FOUND));
  }

  public Salon createSalon(Salon salon) {
    return salonRepository.save(salon);
  }
}
