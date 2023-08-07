package com.airport.domain.dtos;

import java.io.Serializable;

import com.airport.domain.Aeroporto;
import com.airport.domain.Voo;
import com.airport.domain.enums.Status;

public class VooDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	private Integer id;

	private Aeroporto aeroportoVolta;
	
	private Aeroporto aeroportoIda;

	private Status status;

	
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

	public VooDTO(Integer id, Aeroporto aeroportoVolta, Aeroporto aeroportoIda, Status status) {
		super();
		this.id = id;
		this.aeroportoVolta = aeroportoVolta;
		this.aeroportoIda = aeroportoIda;
		this.status = status;
	}

	public VooDTO(Voo obj) {
		super();
		this.id = obj.getId();
		this.aeroportoVolta = obj.getAeroportoVolta();
		this.aeroportoIda = obj.getAeroportoIda();
		this.status = obj.getStatus();
	}
	
	public VooDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
