package com.ty.carrentalapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.carrentalapp.dto.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
