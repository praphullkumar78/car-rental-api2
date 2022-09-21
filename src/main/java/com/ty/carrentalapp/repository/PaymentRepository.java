package com.ty.carrentalapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.carrentalapp.dto.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
