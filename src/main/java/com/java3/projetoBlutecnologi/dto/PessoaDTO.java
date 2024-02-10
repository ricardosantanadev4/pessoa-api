package com.java3.projetoBlutecnologi.dto;

import org.hibernate.validator.constraints.Length;

import com.java3.projetoBlutecnologi.moldels.Pessoa;

import jakarta.validation.constraints.NotBlank;

public class PessoaDTO {

	private Long id;

	@NotBlank
	@Length(min = 1, max = 50)
	private String nome;

	@NotBlank
	@Length(min = 1, max = 50)
	private String email;

	@NotBlank
	@Length(min = 11, max = 11)
	private String telefone;

	public PessoaDTO() {
	}

	public PessoaDTO(Pessoa pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.email = pessoa.getEmail();
		this.telefone = pessoa.getTelefone();
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