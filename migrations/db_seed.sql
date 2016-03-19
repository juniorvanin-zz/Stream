USE stream;

DELETE FROM movie;
DELETE FROM developer;

INSERT INTO developer (id, title) values (1,'Summit Entertainment');
INSERT INTO developer (id, title) values (2,'20th Century Fox');
INSERT INTO developer (id, title) values (3,'Working Title Films');
INSERT INTO developer (id, title) values (4,'Village Roadshow');
INSERT INTO developer (id, title) values (5,'Huayi Brothers');


INSERT INTO movie (title, year, developer) values ('Gods of Egypt', '2016',1);
INSERT INTO movie (title, year, developer) values ('Deadpool', '2016',2);
INSERT INTO movie (title, year, developer) values ('The Danish Girl', '2016',3);
INSERT INTO movie (title, year, developer) values ('Zoolander 2', '2016',4);
INSERT INTO movie (title, year, developer) values ('The Boy', '2016',5);
