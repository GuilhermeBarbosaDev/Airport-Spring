package com.airport.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.airport.domain.Aeroporto;
import com.airport.domain.dtos.AeroportoDTO;
import com.airport.services.AeroportoService;



@RestController
@RequestMapping(value = "/aeroportos")
public class AeroportoResource {
	
	@Autowired
	private AeroportoService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<AeroportoDTO> findById(@PathVariable Integer id) {
		Aeroporto obj = this.service.findById(id);
		return ResponseEntity.ok().body(new AeroportoDTO(obj));
	}

	@GetMapping
	public ResponseEntity<List<AeroportoDTO>> findAll() {
		List<Aeroporto> list = service.findAll();
		List<AeroportoDTO> listDTO = list.stream().map(obj -> new AeroportoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<AeroportoDTO> create(@Valid @RequestBody AeroportoDTO objDTO) {
		Aeroporto newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<AeroportoDTO> update(@PathVariable Integer id, @Valid @RequestBody AeroportoDTO objDTO) {
		Aeroporto obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new AeroportoDTO(obj));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<AeroportoDTO> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
