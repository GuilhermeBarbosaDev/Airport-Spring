package com.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airport.domain.Ticket;

public interface TicketRepository  extends JpaRepository<Ticket, Integer>{

}
