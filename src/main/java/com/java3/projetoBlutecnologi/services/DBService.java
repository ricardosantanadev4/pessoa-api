package com.java3.projetoBlutecnologi.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java3.projetoBlutecnologi.moldels.Pessoa;
import com.java3.projetoBlutecnologi.repositorys.PessoaRepository;

@Service
public class DBService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public void instanciaDB() {
		Pessoa pessoa1 = new Pessoa("Nome Pessoa1", "Email Pessoa1", "Telefone Pessoa 1");
		Pessoa pessoa2 = new Pessoa("Nome Pessoa2", "Email Pessoa2", "Telefone Pessoa 2");
		Pessoa pessoa3 = new Pessoa("Nome Pessoa3", "Email Pessoa3", "Telefone Pessoa 3");
		Pessoa pessoa4 = new Pessoa("Nome Pessoa4", "Email Pessoa4", "Telefone Pessoa 4");
		Pessoa pessoa5 = new Pessoa("Nome Pessoa5", "Email Pessoa5", "Telefone Pessoa 5");

		this.pessoaRepository.saveAll(Arrays.asList(pessoa1, pessoa2, pessoa3, pessoa4, pessoa5));
	}
}
