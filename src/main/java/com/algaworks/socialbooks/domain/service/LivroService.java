package com.algaworks.socialbooks.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.socialbooks.domain.exception.AutorNaoEncontradoExpection;
import com.algaworks.socialbooks.domain.exception.EntidadeEmUsoException;
import com.algaworks.socialbooks.domain.exception.LivroNaoEncontradoExpection;
import com.algaworks.socialbooks.domain.model.Livro;
import com.algaworks.socialbooks.domain.repository.LivroRepository;

@Service
public class LivroService {

	private static final String MSG_LIVRO_EM_USO = "Livro de código %d não pode ser removida, pois está em uso";

	private static final String MSG_LIVRO_NAO_ENCONTRADA = "Não existe um cadastro de Livro com código %d";
	
	@Autowired
	private LivroRepository livrosRepository;
	
	public List<Livro> listar() {
		return livrosRepository.findAll();
	}

	public Livro salvar(Livro livro) {
		return livrosRepository.save(livro);
	}
	
	public Livro atualizar(Livro Livro, Long id) {
		Livro livroAtual = buscarOuFalhar(id);
		
		BeanUtils.copyProperties(Livro, livroAtual, "id");
		return livroAtual;
	}
	
	public void excluir(Long id) {
		try {
			livrosRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new AutorNaoEncontradoExpection(String.format(MSG_LIVRO_NAO_ENCONTRADA, id));

		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(MSG_LIVRO_EM_USO, id));
		}
	}
	
	public Livro buscarOuFalhar(Long id) {
		return livrosRepository.findById(id)
				.orElseThrow(() -> new LivroNaoEncontradoExpection(String.format(MSG_LIVRO_NAO_ENCONTRADA, id)));
	}
}
