package com.carrefour.kata.controller;

import com.carrefour.kata.dto.ReservationRequest;
import com.carrefour.kata.model.DeliveryMethode;
import com.carrefour.kata.model.Reservation;
import com.carrefour.kata.model.TimeSlot;
import com.carrefour.kata.service.DeliveryService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {


    private final DeliveryService service;

    public DeliveryController(DeliveryService service) {
        this.service = service;
    }


    @GetMapping("/slots")
    public List<TimeSlot> getSlots(
        @RequestParam DeliveryMethode method,
        @RequestParam String date
    ) {
        LocalDate localDate = LocalDate.parse(date);
        return service.getAvailbleSlots(method, localDate);
    }

    @PostMapping("/reserve")
    public Reservation reserve(@RequestBody ReservationRequest request) {

        TimeSlot slot = new TimeSlot(
            request.getDate(),
            request.getStartTime(),
            request.getEndTime(),
            request.getDeliveryMethode(),
            5,
            0
        );

        return service.reserve(request.getDeliveryMethode(), slot);
    }

}
