package com.java3.projetoBlutecnologi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java3.projetoBlutecnologi.dto.PessoaDTO;
import com.java3.projetoBlutecnologi.services.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@GetMapping
	public ResponseEntity<List<PessoaDTO>> findAll() {
		return this.pessoaService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<PessoaDTO> findById(@PathVariable Long id) {
		return this.pessoaService.findById(id);
	}

	@GetMapping("/all/{nome}")
	public ResponseEntity<List<PessoaDTO>> findAllByNome(@PathVariable String nome) {
		return this.pessoaService.findAllByNome(nome);
	}

	@PostMapping
	public ResponseEntity<PessoaDTO> create(@RequestBody PessoaDTO pessoaDTO) {
		return this.pessoaService.create(pessoaDTO);
	}

	@PutMapping("{id}")
	public ResponseEntity<PessoaDTO> edit(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO) {
		return this.pessoaService.edit(id, pessoaDTO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		return pessoaService.delete(id);
	}
}