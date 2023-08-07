package com.airport.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.airport.domain.dtos.AeroportoDTO;

@Entity
public class Aeroporto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id // ID como chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Manda o BD gerenciar a criação do ID
	protected Integer id;
	
	protected String nome;
	
	protected String airportIATA;
	
	protected String cidade;
	
	

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAirportIATA() {
		return airportIATA;
	}

	public void setAirportIATA(String airportIATA) {
		this.airportIATA = airportIATA;
	}

	
	
	public Aeroporto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Aeroporto(Integer id, String nome, String airportIATA, String cidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.airportIATA = airportIATA;
		this.cidade = cidade;
	}

	public Aeroporto(AeroportoDTO objDTO) {
		this.id = objDTO.getId();
		this.nome = objDTO.getNome();
		this.airportIATA = objDTO.getAirportIATA();
		this.cidade = objDTO.getCidade();
	}

	
}
