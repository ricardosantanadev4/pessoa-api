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
		Pessoa pessoa1 = new Pessoa("Ricardo Silva", "ricardo.silva@email.com", "81988888888");
		Pessoa pessoa2 = new Pessoa("Rinaldo Carlos", "rinaldo.carlos@email.com", "81777777777");
		Pessoa pessoa3 = new Pessoa("Lucia Oliveira", "lucia.oliveira@email.com", "81666666666");
		Pessoa pessoa4 = new Pessoa("Amanda Medeiros", "amanda.medeiros@email.com", "81555555555");
		Pessoa pessoa5 = new Pessoa("Luana Beovani", "luana.beovani@email.com", "81444444444");

		this.pessoaRepository.saveAll(Arrays.asList(pessoa1, pessoa2, pessoa3, pessoa4, pessoa5));
	}
}
