package com.airport.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.airport.domain.dtos.ClassAirportDTO;
import com.airport.domain.enums.Status;

@Entity
public class ClassAirport implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	private String accents;
	
	private float price;
	
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "voo_id")
	private Voo voo;
	
	private Boolean dispatch;
	
	private Status status;

	
	
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

	public ClassAirport(String nome, String accents, float price, Voo voo, Boolean dispatch, Status status, Cliente cliente) {
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
	
	public ClassAirport(ClassAirportDTO objDTO) {
		super();
		this.id = objDTO.getId();
		this.nome = objDTO.getNome();
		this.accents = objDTO.getAccents();
		this.price = objDTO.getPrice();
		this.voo = objDTO.getVoo();
		this.dispatch = objDTO.getDispatch();
		this.status = objDTO.getStatus();
		this.cliente = objDTO.getCliente();
	}

	public ClassAirport() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	

}
