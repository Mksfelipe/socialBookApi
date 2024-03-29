set foreign_key_checks = 0;
SET SQL_SAFE_UPDATES = 0;

delete from livro;
delete from autor;
delete from comentario;

set foreign_key_checks = 1;
SET SQL_SAFE_UPDATES = 1;

alter table autor auto_increment = 1;
alter table livro auto_increment = 1;

insert into autor (id, nome, nascimento) values (1, 'Andrzej Sapkowski', '1948-08-21');
insert into autor (id, nome, nascimento) values (2, 'Dale Carnegie', '1888-11-24');

INSERT INTO livro (id, nome_livro,data_publicacao,editora,resumo,id_autor) 
VALUES (1, "O último desejo - The Witcher", "2015-08-11", "WMF Martins Fontes","O irônico, cínico e descrente Geralt de Rívia perambula de povoado em povoado oferecendo seus serviços. Em seu caminho vai driblar intrigas, escolher 
o mal menor, negociar preços, alcançar o confim do mundo e realizar seu último desejo: assim começam as aventuras do bruxo Geralt de Rívia.",
1);

INSERT INTO livro (id, nome_livro,data_publicacao,editora,resumo,id_autor) 
VALUES (2, "Como Fazer Amigos e Influenciar Pessoas", "1936-09-01", "Editora Sextante", "Como fazer amigos e influenciar pessoas é um livro da autoria do estadunidense Dale Carnegie, destinado a desenvolver estratégias comunicativas e de ajuda entre pessoas.", 2);

insert into comentario (id, usuario, texto, comentario.data, id_livro) values (1, 'Felipe', 'esse livro EH INCRIVEL', '2022-02-21', 1);
insert into comentario (id, usuario, texto, comentario.data, id_livro) values (2, 'Sousa', 'HISTORIA MARAVILHOSA', '2022-02-21', 1);
insert into comentario (id, usuario, texto, comentario.data, id_livro) values (3, 'Felipe', 'esse livro EH INCRIVEL', '2022-02-21', 1);
