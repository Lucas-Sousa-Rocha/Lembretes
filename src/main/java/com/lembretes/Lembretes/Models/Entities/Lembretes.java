package com.lembretes.Lembretes.Models.Entities;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "Tickets")
public class Lembretes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false, length = 50)
	private String titulo;

	@Column(length = 250)
	private String observacao;

	@Column(nullable = false, length = 15)
	private String status;

	private Date data;

	public Lembretes(String titulo, String observacao, String status, Date data) {
		this.titulo = titulo;
		this.observacao = observacao;
		this.status = status;
		this.data = data;
	}

	public Lembretes() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
