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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@Operation(
			tags = "/api/pessoa", 
			summary = "Listar todos usuários", 
			description = "Esse método retorna um Array com todos o usuários cadastrados no banco de dados, "
			+ "caso não encontre nenhum usuário cadastrado no banco de dados, retorna um array vazio.", 
			responses = @ApiResponse(
					description = "Sucess", 
					responseCode = "200"
					)
			)
	@GetMapping
	public ResponseEntity<List<PessoaDTO>> findAll() {
		return this.pessoaService.findAll();
	}

	@Operation(
			tags = "/api/pessoa/{id}", 
			summary = "Buscar pelo ID", 
			description = "Esse método realiza a busca de uma Pessoa através do valor fornecido na variável ID dentro da URL. "
			+"O método realiza um consulta no banco de dados com o valor fornecido, "
			+ "e caso não encontre nenhum registro na base dedados, retorna uma excessão informando que o registro não foi encontrado, "
			+ "e não prossegue com a solicitação."
			+ " O ID é obrigatório e deve ser um número positivo maior que 0.", 
			responses = @ApiResponse(
					description = "Sucess", responseCode = "200"
					)
			)
	@GetMapping("/{id}")
	public ResponseEntity<PessoaDTO> findById(@NotNull @Positive @PathVariable Long id) {
		return this.pessoaService.findById(id);
	}

	@Operation(
			tags = "/api/pessoa/searchByName?nome=String", 
			summary = "Busca Pessoas pelo nome ", 
			description = "Esse método retorna que lista de todas as as Pessos cadastradas no banco de dados"
			+ " onde o nome da pessoa contém a String fornecida no parametro da URL. "
			+ "A String fornecida pode ser tando maiúscula ou minúscula que o metodo iguinora a formatação", 
			responses = @ApiResponse(
					description = "Sucess", responseCode = "200"
					)
			)
	@GetMapping("/searchByName")
	public ResponseEntity<List<PessoaDTO>> findByNomeContainingIgnoreCase(@RequestParam @NotBlank String nome) {
		return this.pessoaService.findByNomeContainingIgnoreCase(nome);
	}

	@Operation(
			tags = "/api/ramais-list", 
			summary = "Criar", 
			description = "Esse método que realiza o cadastro de uma Pessoa no banco de dados. "
			+ "Antes de realizar o cadastro ele verifica se o e-mail fornecido já possui cadastro na base, "
			+ "se já existir um cadastro no banco de dados com o e-mail fornecido,  "
			+ "o método retorna uma excessao informando que o e-mail já possui cadastro base, e não prossegue com a solicitação."
			)
	@PostMapping
	public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaDTO pessoaDTO) {
		return this.pessoaService.create(pessoaDTO);
	}

	@Operation(
			tags = "/api/pessoa/{id}", 
			summary = "Editar", 
			description = "Esse método que edita um cadastro existente no banco de dados. "
					+ "Primeiro realiza uma consulta no banco de dados com o valor fornecido na URL dentro variável ID, "
					+ "caso não exista nenhum cadastro com o ID fornecido, o método retorna uma excessão, "
					+ "informando que o registro não foi encontrado, e não prossegue com a solicitação."
					+ " O ID é obrigatório e deve ser um número positivo maior que 0.",
			responses = @ApiResponse(
					description = "Sucess", 
					responseCode = "200"
							)
			)
	@PutMapping("{id}")
	public ResponseEntity<PessoaDTO> edit(@NotNull @Positive @PathVariable Long id,
			@Valid @RequestBody PessoaDTO pessoaDTO) {
		return this.pessoaService.edit(id, pessoaDTO);
	}

	@Operation(
			tags = "/api/pessoa/{id}", 
			summary = "Remover", 
			description = "Esse método que remove um cadastro na base de dados. "
					+ "Primeiro é feita uma consulta no banco dedados com o valor passado na URL dentro da variavel ID, "
					+ "caso não encontre nenhum registro na base, retorna uma excessao informado que o registro não foi encontrado, "
					+ "e não prossegue com a solicitação. O ID é obrigatório e deve ser um número positivo maior que 0."
			)
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@NotNull @Positive @PathVariable Long id) {
		return pessoaService.delete(id);
	}
}