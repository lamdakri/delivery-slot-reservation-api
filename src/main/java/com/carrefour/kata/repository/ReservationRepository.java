package com.carrefour.kata.repository;

import com.carrefour.kata.model.Reservation;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepository {

    private final List<Reservation> reservations = new ArrayList<>();

    public void save(Reservation reservation){
        reservations.add(reservation);
    }

    public List<Reservation> findAll(){
        return reservations;
    }



}
