package com.carrefour.kata.model;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Reservation {

    private String id;
    private DeliveryMethode deliveryMethode;
    private TimeSlot timeSlot;

    public Reservation(DeliveryMethode deliveryMethode, TimeSlot timeSlot){
        this.id = UUID.randomUUID().toString();
        this.deliveryMethode = deliveryMethode;
        this.timeSlot = timeSlot;
    }
}
