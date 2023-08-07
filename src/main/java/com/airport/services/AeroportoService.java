package com.airport.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airport.domain.Aeroporto;
import com.airport.domain.dtos.AeroportoDTO;
import com.airport.repository.AeroportoRepository;
import com.airport.services.exceptions.ObjectNotFoundException;

@Service
public class AeroportoService {
	
	@Autowired
	private AeroportoRepository repository;

	public Aeroporto findById(Integer id) {
		Optional<Aeroporto> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não Encontrado! ID: " + id));
	}

	public List<Aeroporto> findAll() {
		return repository.findAll();
	}
	
	public Aeroporto create(AeroportoDTO objDTO) {
		objDTO.setId(null);
		Aeroporto newObj = new Aeroporto(objDTO);
		return repository.save(newObj);
	}

	public Aeroporto update(Integer id, @Valid AeroportoDTO objDTO) {
		objDTO.setId(id);
		Aeroporto oldObj = findById(id);
		oldObj = new Aeroporto(objDTO);
		return repository.save(oldObj);
	}

	public void delete(Integer id) {
		Aeroporto obj = findById(id);
		repository.deleteById(id);
	}
}
