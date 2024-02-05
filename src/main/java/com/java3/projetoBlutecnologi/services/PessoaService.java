package com.java3.projetoBlutecnologi.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.java3.projetoBlutecnologi.dto.PessoaDTO;
import com.java3.projetoBlutecnologi.exceptions.IllegalArgumentException;
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
				.orElseThrow(() -> new ObjectNotFoundException("Pessoa não encontrada com o id fornecido."))));
	}

	public ResponseEntity<List<PessoaDTO>> findAllByNome(String nome) {
		return ResponseEntity.ok().body(this.pessoaRepository.findAllByNome(nome).stream().map(p -> new PessoaDTO(p))
				.collect(Collectors.toList()));
	}

	public void findByEmail(PessoaDTO pessoaDTO) {
		Optional<Pessoa> getPessoa = this.pessoaRepository.findByEmail(pessoaDTO.getEmail());
		if (getPessoa.isPresent() && getPessoa.get().getEmail().equals(pessoaDTO.getEmail())) {
			throw new IllegalArgumentException(
					"O E-mail informardo: " + pessoaDTO.getEmail() + " já possui cadastro na base");
		}
	}

	public ResponseEntity<PessoaDTO> create(PessoaDTO pessoaDTO) {
		this.findByEmail(pessoaDTO);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new PessoaDTO(this.pessoaRepository.save(new Pessoa(pessoaDTO))));
	}

	public ResponseEntity<PessoaDTO> edit(Long id, PessoaDTO pessoaDTO) {
		return this.pessoaRepository.findById(id).map(pessoa -> {
			pessoa.setNome(pessoaDTO.getNome());
			pessoa.setEmail(pessoaDTO.getEmail());
			pessoa.setTelefone(pessoaDTO.getTelefone());
			return ResponseEntity.ok().body(new PessoaDTO(this.pessoaRepository.save(pessoa)));
		}).orElseThrow(() -> new ObjectNotFoundException("Pessoa não encontrada com o id fornecido."));
	}

	public ResponseEntity<Void> delete(Long id) {
		this.findById(id);
		this.pessoaRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}