INSERT INTO tb_user (name, email, password) VALUES ('Ana Brown' ,'ana@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Bob Brown','bob@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');


INSERT INTO tb_role (authority) VALUES ('ROLE_VISITOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_MEMBER');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);

INSERT INTO tb_genre(name) VALUES ('Terror');
INSERT INTO tb_genre(name) VALUES ('Ação');
INSERT INTO tb_genre(name) VALUES ('Aventura');

INSERT INTO tb_movie (title, sub_Title, year, img_Url, synopsis, genre_id) VALUES ('Power Ranger', 'Power Ranger 1', 2010, 'https://img.elo7.com.br/product/zoom/1BFCFFB/power-rangers-painel-festa-1-50x1m-temas-infantil.jpg', 'Filme dos Power Ranger', 3);
INSERT INTO tb_movie (title, sub_Title, year, img_Url, synopsis, genre_id) VALUES ('Power Ranger', 'Power Ranger 2', 2012, 'https://img.elo7.com.br/product/zoom/1BFCFFB/power-rangers-painel-festa-1-50x1m-temas-infantil.jpg', 'Novo filme dos Power Ranger', 2);

INSERT INTO tb_review (user_id, movie_id, text) VALUES (1,1,'Filmes muito legal');


