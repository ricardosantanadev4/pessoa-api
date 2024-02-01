package com.java3.projetoBlutecnologi.moldels;

import com.java3.projetoBlutecnologi.dto.PessoaDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String email;
	private String telefone;

	public Pessoa() {
	}

	public Pessoa(PessoaDTO pessoaDTO) {
//		this.id = pessoaDTO.getId();
		this.nome = pessoaDTO.getNome();
		this.email = pessoaDTO.getEmail();
		this.telefone = pessoaDTO.getTelefone();
	}

	public Pessoa(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
