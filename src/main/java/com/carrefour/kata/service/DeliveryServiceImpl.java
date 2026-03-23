package com.carrefour.kata.service;

import com.carrefour.kata.model.DeliveryMethode;
import com.carrefour.kata.model.Reservation;
import com.carrefour.kata.model.TimeSlot;
import com.carrefour.kata.repository.ReservationRepository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DeliveryServiceImpl implements DeliveryService{

    private final ReservationRepository reservationRepository;

    public DeliveryServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<TimeSlot> getAvailbleSlots(DeliveryMethode deliveryMethode, LocalDate localDate) {

        List<TimeSlot> slots = generateSlots(deliveryMethode , localDate);

        return slots.stream().filter(TimeSlot::isAvailble).toList();
    }

    @Override
    public Reservation reserve(DeliveryMethode deliveryMethode, TimeSlot timeSlot) {

        if (!timeSlot.isAvailble()) {
            throw new IllegalStateException("Slot is not available");
        }
        timeSlot.reserve();

        return new Reservation(deliveryMethode, timeSlot);
    }


    private List<TimeSlot> generateSlots(DeliveryMethode method, LocalDate date) {

        List<TimeSlot> slots = new ArrayList<>();

        switch (method) {

            case DRIVE -> {
                slots.add(new TimeSlot(date, LocalTime.of(10, 0), LocalTime.of(11, 0), method, 5, 0));
                slots.add(new TimeSlot(date, LocalTime.of(11, 0), LocalTime.of(12, 0), method, 5, 0));
            }

            case DELIVERY -> {
                slots.add(new TimeSlot(date, LocalTime.of(8, 0), LocalTime.of(10, 0), method, 5, 0));
                slots.add(new TimeSlot(date, LocalTime.of(10, 0), LocalTime.of(12, 0), method, 5, 0));
            }

            case DELIVERY_TODAY -> {

                slots.add(new TimeSlot(date, LocalTime.of(14, 0), LocalTime.of(16, 0), method, 5, 0));

            }
            case DELIVERY_ASAP -> {
                slots.add(new TimeSlot(date, LocalTime.of(18, 0), LocalTime.of(20, 0), method, 5, 0));

            }
        }

        return slots;
    }

}
