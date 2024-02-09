package com.java3.projetoBlutecnologi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java3.projetoBlutecnologi.dto.PessoaDTO;
import com.java3.projetoBlutecnologi.services.PessoaService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
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
	public ResponseEntity<PessoaDTO> findById(@NotNull @Positive @PathVariable Long id) {
		return this.pessoaService.findById(id);
	}

	@GetMapping("/searchByName")
	public ResponseEntity<List<PessoaDTO>> findByNomeContainingIgnoreCase(@RequestParam @NotBlank String nome) {
		return this.pessoaService.findByNomeContainingIgnoreCase(nome);
	}

	@PostMapping
	public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaDTO pessoaDTO) {
		return this.pessoaService.create(pessoaDTO);
	}

	@PutMapping("{id}")
	public ResponseEntity<PessoaDTO> edit(@NotNull @Positive @PathVariable Long id,
			@Valid @RequestBody PessoaDTO pessoaDTO) {
		return this.pessoaService.edit(id, pessoaDTO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@NotNull @Positive @PathVariable Long id) {
		return pessoaService.delete(id);
	}
}