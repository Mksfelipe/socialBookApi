create table livro (
	id int auto_increment not null,
    nome_livro varchar(70) not null,
    data_publicacao date not null,
    editora varchar(100) not null,
    resumo longtext not null,
    id_autor bigint,
    
    foreign key(id_autor) references autor(id),
    primary key(id)
) ENGINE=INNODB;