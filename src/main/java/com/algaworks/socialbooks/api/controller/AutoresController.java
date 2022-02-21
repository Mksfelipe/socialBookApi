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

import com.algaworks.socialbooks.domain.model.Autor;
import com.algaworks.socialbooks.domain.service.AutorService;

@RestController
@RequestMapping("/autores")
public class AutoresController {

	@Autowired
	private AutorService autorService;
	
	@GetMapping
	public List<Autor> listar() {
		return autorService.listar();
	}
	
	@GetMapping("/{id}")
	public Autor buscar(@PathVariable Long id) {
		return autorService.buscarOuFalhar(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Autor adicionar(@RequestBody Autor autor) {
		return autorService.salvar(autor);
	}
	
	@PutMapping("/{id}")
	public Autor atualizar(@PathVariable Long id, @RequestBody Autor autor) {
		autor = autorService.atualizar(autor, id);
		
		return autor;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		autorService.excluir(id);
	}
}