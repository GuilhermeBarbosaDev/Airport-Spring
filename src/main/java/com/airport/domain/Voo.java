package com.airport.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.airport.domain.dtos.VooDTO;
import com.airport.domain.enums.Status;

@Entity
public class Voo implements Serializable{
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "aeroporto_ida_id")
	private Aeroporto aeroportoVolta;
	
	@ManyToOne
	@JoinColumn(name = "aeroporto_volta_id")
	private Aeroporto aeroportoIda;
	
	private Status status;

	
	

	public Voo(Integer id, Aeroporto aeroportoVolta, Aeroporto aeroportoIda, Status status) {
		super();
		this.id = id;
		this.aeroportoVolta = aeroportoVolta;
		this.aeroportoIda = aeroportoIda;
		this.status = status;
	}	
	
	public Voo(VooDTO objDTO) {
		super();
		this.id = objDTO.getId();
		this.aeroportoVolta = objDTO.getAeroportoVolta();
		this.aeroportoIda = objDTO.getAeroportoIda();
		this.status = objDTO.getStatus();
	}
	
	
	public Voo() {
		super();
		// TODO Auto-generated constructor stub
	}

	


	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Aeroporto getAeroportoVolta() {
		return aeroportoVolta;
	}

	public void setAeroportoVolta(Aeroporto aeroportoVolta) {
		this.aeroportoVolta = aeroportoVolta;
	}

	public Aeroporto getAeroportoIda() {
		return aeroportoIda;
	}

	public void setAeroportoIda(Aeroporto aeroportoIda) {
		this.aeroportoIda = aeroportoIda;
	}
	
	
}
