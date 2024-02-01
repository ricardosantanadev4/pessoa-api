package com.java3.projetoBlutecnologi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.java3.projetoBlutecnologi.dto.PessoaDTO;
import com.java3.projetoBlutecnologi.exceptions.ObjectNotFoundException;
import com.java3.projetoBlutecnologi.moldels.Pessoa;
import com.java3.projetoBlutecnologi.repositorys.PessoaRepository;

@Service
public class PessoaService {
	@Autowired
	private PessoaRepository pessoaRepository;

	public ResponseEntity<List<PessoaDTO>> findAll() {
		return ResponseEntity.ok()
				.body(this.pessoaRepository.findAll().stream().map(p -> new PessoaDTO(p)).collect(Collectors.toList()));
	}

	public ResponseEntity<PessoaDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(new PessoaDTO(this.pessoaRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Pessoa não encontrada!"))));
	}

	public ResponseEntity<List<PessoaDTO>> findAllByNome(String nome) {
		return ResponseEntity.ok().body(this.pessoaRepository.findAllByNome(nome).stream().map(p -> new PessoaDTO(p))
				.collect(Collectors.toList()));
	}

	public ResponseEntity<PessoaDTO> create(PessoaDTO pessoaDTO) {
		return new ResponseEntity<PessoaDTO>(new PessoaDTO(this.pessoaRepository.save(new Pessoa(pessoaDTO))),
				HttpStatusCode.valueOf(201));
	}

	public ResponseEntity<PessoaDTO> edit(Long id, PessoaDTO pessoaDTO) {
		return this.pessoaRepository.findById(pessoaDTO.getId()).map(pessoa -> {
			pessoa.setNome(pessoaDTO.getNome());
			pessoa.setEmail(pessoaDTO.getEmail());
			pessoa.setTelefone(pessoaDTO.getTelefone());
			return ResponseEntity.ok().body(new PessoaDTO(this.pessoaRepository.save(pessoa)));
		}).orElseThrow(() -> new ObjectNotFoundException("Pessoa não encontrada!"));
	}

	public ResponseEntity<Void> delete(Long id) {
		this.findById(id);
		this.pessoaRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}