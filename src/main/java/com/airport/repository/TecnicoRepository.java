package com.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airport.domain.Tecnico;

public interface TecnicoRepository  extends JpaRepository<Tecnico, Integer>{

}
