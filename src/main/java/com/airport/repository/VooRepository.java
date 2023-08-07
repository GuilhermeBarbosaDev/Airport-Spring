package com.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airport.domain.Voo;

public interface VooRepository extends JpaRepository<Voo, Integer>{

}
