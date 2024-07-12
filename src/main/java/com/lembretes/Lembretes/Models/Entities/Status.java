package com.lembretes.Lembretes.Models.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Status")
public class Status {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false, length = 50)
	private String nome;

	@Column(nullable = false, length = 15)
	private String situacao;

    public Status() {
    }

    public Status(String nome, String situacao) {
        this.nome = nome;
        this.situacao = situacao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    

}
