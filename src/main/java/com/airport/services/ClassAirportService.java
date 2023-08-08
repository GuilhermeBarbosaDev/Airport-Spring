package com.airport.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airport.domain.ClassAirport;
import com.airport.domain.Voo;
import com.airport.domain.dtos.ClassAirportDTO;
import com.airport.domain.dtos.VooDTO;
import com.airport.domain.enums.Status;
import com.airport.repository.ClassAirportRepository;

@Service
public class ClassAirportService {
	
	
	@Autowired
	ClassAirportRepository classAirRepository;
	
	public List<ClassAirport> findAll() {
		return classAirRepository.findAll();
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

}
