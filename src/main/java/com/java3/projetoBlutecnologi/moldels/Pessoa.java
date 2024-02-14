package com.java3.projetoBlutecnologi.moldels;

import org.hibernate.validator.constraints.Length;

import com.java3.projetoBlutecnologi.dto.PessoaDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;

	@NotBlank
	@Length(min = 1, max = 50)
	@Column(length = 50)
	private String nome;

	@NotBlank
	@Length(min = 11, max = 50)
	@Column(length = 50)
	private String email;

	@NotBlank
	@Length(min = 11, max = 11)
	@Column(length = 11)
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
