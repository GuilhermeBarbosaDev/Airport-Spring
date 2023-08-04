package com.airport.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airport.domain.Cliente;
import com.airport.domain.Tecnico;
import com.airport.domain.Ticket;
import com.airport.domain.dtos.TicketDTO;
import com.airport.domain.enums.Prioridade;
import com.airport.domain.enums.Status;
import com.airport.repository.TicketRepository;
import com.airport.services.exceptions.ObjectNotFoundException;

@Service
public class TicketService {

	@Autowired
	private TicketRepository repository;
	@Autowired
	private TecnicoService tecnicoService;
	@Autowired
	private ClienteService clienteService;

	public Ticket findById(Integer id) {
		Optional<Ticket> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não Encontrado! ID: " + id));
	}

	public List<Ticket> findAll() {
		return repository.findAll();
	}

	public Ticket create(@Valid TicketDTO objDTO) {
		return repository.save(newTicket(objDTO));
	}
	
	public Ticket update(Integer id, @Valid TicketDTO objDTO) {
		objDTO.setId(id);
		Ticket oldObj = findById(id);
		oldObj = newTicket(objDTO);
		return repository.save(oldObj);
		
	}

	private Ticket newTicket(TicketDTO obj) {
		Tecnico tecnico = tecnicoService.findById(obj.getTecnico());
		Cliente cliente = clienteService.findById(obj.getCliente());

		Ticket ticket = new Ticket();
		if (obj.getId() != null) {
			ticket.setId(obj.getId());
		}
		
		if(obj.getStatus() == 2) {
			ticket.setDataFechamento(LocalDate.now());
		} else {
			ticket.setDataFechamento(null);
		}

		ticket.setTecnico(tecnico);
		ticket.setCliente(cliente);
		ticket.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
		ticket.setStatus(Status.toEnum(obj.getStatus()));
		ticket.setTitulo(obj.getTitulo());
		ticket.setObservacoes(obj.getObservacoes());
		return ticket;
	}

	
}
