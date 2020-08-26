package com.algaworks.socialbooks.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.socialbooks.domain.Comentario;
import com.algaworks.socialbooks.domain.Livro;
import com.algaworks.socialbooks.repository.ComentariosRepository;
import com.algaworks.socialbooks.repository.LivroRepository;
import com.algaworks.socialbooks.services.exceptions.LivroNaoEncontradoExpection;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private ComentariosRepository comentariosRepository;
	
	public List<Livro> listar() {
		return livroRepository.findAll();
	}
	
	public Livro buscar(Long id) {
		Livro livro = livroRepository.findOne(id);
		
		if (livro == null) {
			throw new LivroNaoEncontradoExpection("O livro não pode ser encontrado.");
		}
		return livro;
	}
	
	public Livro salvar(Livro livro) {
		livro.setId(null);
		
		return livroRepository.save(livro);
	}
	
	public void deletar(Long id) {
		
		try {
			livroRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new LivroNaoEncontradoExpection("O livro não pôde ser encontrado.");
		}
	}
	
	public void editar(Livro livro) {
		preEditar(livro.getId());
		livroRepository.save(livro);
	}
	
	private boolean preEditar(Long id) {
		if (buscar(id) == null) {
			return false;
		}
		return true;
	}
	
	public Comentario salvarComentario(Long livroId, Comentario comentario) {
		
		Livro livro = buscar(livroId);
		comentario.setLivro(livro);
		comentario.setData(new Date());
		
		return comentariosRepository.save(comentario);
	}

	public List<Comentario> listarComentario(Long livroId) {
		Livro livro = buscar(livroId);
		
		return livro.getComentarios();
	}
}