package com.carrefour.kata.model;

import java.time.LocalDate;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TimeSlot {

    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private DeliveryMethode deliveryMethode;
    private int capacity;
    private int reserved;

    public boolean isAvailble() {
        return reserved < capacity;
    }

    public void reserve() {
        if (!isAvailble()) {
            throw new IllegalStateException("Slot is full");
        }
        reserved++;
    }

}
