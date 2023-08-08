package com.airport.domain.dtos;


import java.io.Serializable;

import com.airport.domain.ClassAirport;
import com.airport.domain.Cliente;
import com.airport.domain.Voo;
import com.airport.domain.enums.Status;

public class ClassAirportDTO implements Serializable {
	private static final long serialVersionUID = 1L;

private Integer id;
	
	private String nome;
	
	private String accents;
	
	private float price;
	
	private Voo voo;
	
	private Boolean dispatch;
	
	private Status status;
	
	private Cliente cliente;

	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAccents() {
		return accents;
	}

	public void setAccents(String accents) {
		this.accents = accents;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Voo getVoo() {
		return voo;
	}

	public void setVoo(Voo voo) {
		this.voo = voo;
	}

	public Boolean getDispatch() {
		return dispatch;
	}

	public void setDispatch(Boolean dispatch) {
		this.dispatch = dispatch;
	}

	public ClassAirportDTO(Integer id, String nome, String accents, float price, Voo voo, Boolean dispatch, Status status, Cliente cliente) {
		super();
		this.id = id;
		this.nome = nome;
		this.accents = accents;
		this.price = price;
		this.voo = voo;
		this.dispatch = dispatch;
		this.status = status;
		this.cliente = cliente;
	}

	public ClassAirportDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ClassAirportDTO(ClassAirport obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.accents = obj.getAccents();
		this.price = obj.getPrice();
		this.voo = obj.getVoo();
		this.dispatch = obj.getDispatch();
		this.status = obj.getStatus();
		this.cliente = obj.getCliente();
	}
}
