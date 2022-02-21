create table livro (
	id int auto_increment not null,
    nome_livro varchar(70) not null,
    id_autor bigint,
    
    foreign key(id_autor) references autor(id),
    primary key(id)
) ENGINE=INNODB;