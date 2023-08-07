package com.airport.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airport.domain.Aeroporto;
import com.airport.domain.Voo;
import com.airport.domain.dtos.VooDTO;
import com.airport.repository.VooRepository;
import com.airport.services.exceptions.ObjectNotFoundException;

@Service
public class VooService {
	
	@Autowired
	VooRepository repository;
	
	public Voo findById(Integer id) {
		Optional<Voo> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não Encontrado! ID: " + id));
	}

	public List<Voo> findAll() {
		return repository.findAll();
	}
	
	public Voo create(VooDTO objDTO) {
		objDTO.setId(null);
		Voo newObj = new Voo(objDTO);
		return repository.save(newObj);
	}

	public Voo update(Integer id, @Valid VooDTO objDTO) {
		objDTO.setId(id);
		Voo oldObj = findById(id);
		oldObj = new Voo(objDTO);
		return repository.save(oldObj);
	}

	
}
