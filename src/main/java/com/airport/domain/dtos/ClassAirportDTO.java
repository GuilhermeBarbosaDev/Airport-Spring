package com.airport.domain.dtos;


import java.io.Serializable;

import com.airport.domain.ClassAirport;
import com.airport.domain.Voo;

public class ClassAirportDTO implements Serializable {
	private static final long serialVersionUID = 1L;

private Integer id;
	
	private String nome;
	
	private String accents;
	
	private float price;
	
	private Voo voo;
	
	private Boolean dispatch;

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

	public ClassAirportDTO(Integer id, String nome, String accents, float price, Voo voo, Boolean dispatch) {
		super();
		this.id = id;
		this.nome = nome;
		this.accents = accents;
		this.price = price;
		this.voo = voo;
		this.dispatch = dispatch;
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
	}
}
