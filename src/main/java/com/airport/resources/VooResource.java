package com.airport.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.airport.domain.Voo;
import com.airport.domain.dtos.VooDTO;
import com.airport.services.VooService;

@RestController
@RequestMapping(value = "/voo")
public class VooResource {

	@Autowired
	private VooService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<VooDTO> findById(@PathVariable Integer id) {
		Voo obj = this.service.findById(id);
		return ResponseEntity.ok().body(new VooDTO(obj));
	}

	@GetMapping
	public ResponseEntity<List<VooDTO>> findAll() {
		List<Voo> list = service.findAll();
		List<VooDTO> listDTO = list.stream().map(obj -> new VooDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody VooDTO objDTO) {
	    Voo newObj = service.create(objDTO);
	    if (newObj.getAeroportoIda().equals(newObj.getAeroportoVolta())) {
	        return ResponseEntity.badRequest().body("Error: Origem e chegada não podem ter o mesmo destino");
	    }
	    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
	    return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody VooDTO objDTO) {
		Voo obj = service.update(id, objDTO);
		if(obj.getAeroportoIda().equals(obj.getAeroportoVolta())) {
			return ResponseEntity.badRequest().body("Error: Origem e chegada não podem ter o mesmo destino");
		}
		return ResponseEntity.ok().body(new VooDTO(obj));
	}

}
