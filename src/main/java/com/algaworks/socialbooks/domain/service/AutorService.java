package com.algaworks.socialbooks.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.socialbooks.domain.exception.AutorNaoEncontradoExpection;
import com.algaworks.socialbooks.domain.exception.EntidadeEmUsoException;
import com.algaworks.socialbooks.domain.model.Autor;
import com.algaworks.socialbooks.domain.repository.AutoresRepository;

@Service
public class AutorService {

	private static final String MSG_AUTOR_EM_USO = "Autor de código %d não pode ser removida, pois está em uso";

	private static final String MSG_AUTOR_NAO_ENCONTRADA = "Não existe um cadastro de Autor com código %d";
	
	@Autowired
	private AutoresRepository autoresRepository;
	
	public List<Autor> listar() {
		return autoresRepository.findAll();
	}

	public Autor salvar(Autor autor) {
		return autoresRepository.save(autor);
	}
	
	public Autor atualizar(Autor autor, Long id) {
		Autor autorAtual = buscarOuFalhar(id);
		
		BeanUtils.copyProperties(autor, autorAtual, "id");
		return autorAtual;
	}
	
	public void excluir(Long id) {
		try {
			autoresRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new AutorNaoEncontradoExpection(String.format(MSG_AUTOR_NAO_ENCONTRADA, id));

		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(MSG_AUTOR_EM_USO, id));
		}
	}
	
	public Autor buscarOuFalhar(Long id) {
		return autoresRepository.findById(id)
				.orElseThrow(() -> new AutorNaoEncontradoExpection(String.format(MSG_AUTOR_NAO_ENCONTRADA, id)));
	}
}
