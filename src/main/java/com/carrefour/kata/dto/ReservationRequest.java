package com.carrefour.kata.dto;

import com.carrefour.kata.model.DeliveryMethode;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Data;

@Data
public class ReservationRequest {

    private DeliveryMethode deliveryMethode;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

}
