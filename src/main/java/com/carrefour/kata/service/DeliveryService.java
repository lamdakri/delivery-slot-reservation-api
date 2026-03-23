package com.carrefour.kata.service;

import com.carrefour.kata.model.DeliveryMethode;
import com.carrefour.kata.model.Reservation;
import com.carrefour.kata.model.TimeSlot;
import java.time.LocalDate;
import java.util.List;

public interface DeliveryService {

    List<TimeSlot> getAvailbleSlots(DeliveryMethode deliveryMethode, LocalDate localDate);

    Reservation reserve(DeliveryMethode deliveryMethode, TimeSlot timeSlot);

}
