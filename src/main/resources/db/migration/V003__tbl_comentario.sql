create table comentario (
	id int auto_increment,
	usuario varchar(50) not null,
	texto varchar (255) not null, 
	data date not null,
	id_livro int,
	
	foreign key(id_livro) references livro(id),
    primary key(id)
) ENGINE=INNODB;
