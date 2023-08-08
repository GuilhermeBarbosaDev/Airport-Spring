package com.airport.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airport.domain.ClassAirport;
import com.airport.domain.dtos.ClassAirportDTO;
import com.airport.services.ClassAirportService;

@RestController
@RequestMapping(value = "/class")
public class ClassAirportResource {
	
	@Autowired
	ClassAirportService classAirportService;
	
	 
	
	
	@GetMapping
	public ResponseEntity<List<ClassAirportDTO>> findAll() {
		List<ClassAirport> list = classAirportService.findAll();
		List<ClassAirportDTO> listDTO = list.stream()
				.filter(obj -> obj.getNome() != null)
				.map(obj -> new ClassAirportDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}

}
