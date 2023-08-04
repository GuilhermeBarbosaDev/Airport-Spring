package com.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airport.domain.Cliente;

public interface ClienteRepository  extends JpaRepository<Cliente, Integer>{

}
