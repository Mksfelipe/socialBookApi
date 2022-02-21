alter table livro ADD data_publicacao date not null after nome_livro;

alter table livro ADD editora varchar(100) not null after data_publicacao;

alter table livro ADD resumo longtext not null after editora;