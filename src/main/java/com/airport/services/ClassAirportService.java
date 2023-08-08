package com.airport.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airport.domain.Aeroporto;
import com.airport.domain.ClassAirport;
import com.airport.domain.Tecnico;
import com.airport.domain.Voo;
import com.airport.domain.dtos.ClassAirportDTO;
import com.airport.domain.dtos.TecnicoDTO;
import com.airport.domain.dtos.VooDTO;
import com.airport.domain.enums.Status;
import com.airport.repository.ClassAirportRepository;
import com.airport.services.exceptions.ObjectNotFoundException;

@Service
public class ClassAirportService {
	
	
	@Autowired
	ClassAirportRepository classAirRepository;
	
	public List<ClassAirport> findAll() {
		return classAirRepository.findAll();
	}
	
	public ClassAirport findById(Integer id) {
		Optional<ClassAirport> obj = classAirRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não Encontrado! ID: " + id));
	}
	

	public ClassAirport comprarTicket(Integer id, @Valid ClassAirportDTO objDTO) {
		objDTO.setId(id);
		ClassAirport oldObj = findById(id);
		oldObj = new ClassAirport(objDTO);
		return classAirRepository.save(oldObj);
	}
	
	
	public void createClassAirport(ClassAirportDTO objDTO, Voo voo){
		List<ClassAirport> classAirports = new ArrayList<>();
		for(int i = 1; i <= 51; i++) {
			ClassAirport classAirport = new ClassAirport(objDTO);
			
			objDTO.setAccents("AC" + acentosCaracteres(i));	
			objDTO.setVoo(voo);
			objDTO.setNome("Economica");
			objDTO.setPrice(500);
			objDTO.setStatus(Status.ABERTO);
			objDTO.setCliente(null);
			classAirports.add(classAirport);
		}
		
		classAirRepository.saveAll(classAirports);
	}
	
	public String acentosCaracteres(int i) {
		if(i >= 1 && i <= 51) {
			
			return String.valueOf(i);
			
		}else {
			throw new IllegalArgumentException("Erro");
		}
	}
	
	public ClassAirport update(Integer id, @Valid ClassAirportDTO objDTO) {
		objDTO.setId(id);
		ClassAirport oldObj = findById(id);
		oldObj = new ClassAirport(objDTO);
		return classAirRepository.save(oldObj);
	}

}
