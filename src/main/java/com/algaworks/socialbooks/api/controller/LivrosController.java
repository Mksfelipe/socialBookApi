package com.algaworks.socialbooks.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.socialbooks.domain.model.Livro;
import com.algaworks.socialbooks.domain.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivrosController {

	@Autowired
	private LivroService livroService;
	
	@GetMapping
	public List<Livro> listar() {
		return livroService.listar();
	}
	
	@GetMapping("/{id}")
	public Livro buscar(@PathVariable Long id) {
		return livroService.buscarOuFalhar(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Livro adicionar(@RequestBody Livro livro) {
		return livroService.salvar(livro);
	}
	
	@PutMapping("/{id}")
	public Livro atualizar(@PathVariable Long id, @RequestBody Livro livro) {
		livro = livroService.atualizar(livro, id);
		
		return livro;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		livroService.excluir(id);
	}
}
