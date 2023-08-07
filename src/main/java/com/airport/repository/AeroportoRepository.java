package com.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airport.domain.Aeroporto;

public interface AeroportoRepository extends JpaRepository<Aeroporto, Integer>{

}
