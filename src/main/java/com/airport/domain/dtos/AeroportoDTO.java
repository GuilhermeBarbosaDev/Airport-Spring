package com.airport.domain.dtos;

import java.io.Serializable;

import com.airport.domain.Aeroporto;

public class AeroportoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

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

	public AeroportoDTO(Integer id, String nome, String airportIATA, String cidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.airportIATA = airportIATA;
		this.cidade = cidade;
	}

	public AeroportoDTO(Aeroporto obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.airportIATA = obj.getAirportIATA();
		this.cidade = obj.getCidade();
		}
	
}
