package com.algaworks.socialbooks.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

	ERRO_DE_SISTEMA("/erro-de-sistema", "Erro de sistema"),
	PARAMETRO_INVALIDO("/parametro-invalido", "Parâmetro inválido"),
	MENSAGEM_INCOMPREENSIVEL("/mensagem-imcompreensivel", "Mensagem incompreensivel"),
	RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrado"),
	ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso"),
	ERRO_NEGOCIO("/erro-negocio", "Violação de regra de negócio"),
	DADOS_INVALIDOS("/dados-invalidos", "Dados inválidos");

	private String title;
	private String uri;

	ProblemType(String path, String title) {
		this.uri = "https://socialBookApi.com.br" + path;
		this.title = title;
	}

}