package com.java3.projetoBlutecnologi.repositorys;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java3.projetoBlutecnologi.moldels.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	public Optional<Pessoa> findByNome(String nome);

	public List<Pessoa> findAllByNome(String nome);

	public Optional<Pessoa> findByEmail(String email);
}
