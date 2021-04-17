use projetsite;

CREATE TABLE user (
  id integer NOT NULL AUTO_INCREMENT,
  firstname varchar(20) NOT NULL,
  lastname varchar(20) NOT NULL,
  username varchar(20) NOT NULL UNIQUE,
  password varchar(20) NOT NULL,
  PRIMARY KEY (username),
  KEY(id)
)ENGINE=MYISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;


CREATE TABLE relation (
	id_user_1 integer,
    id_user_2 integer,
    primary key (id_user_1, id_user_2),
    foreign key (id_user_1) references user (id),
    foreign key (id_user_2) references user (id)
)ENGINE=MYISAM DEFAULT CHARSET=utf8;

CREATE TABLE post (
	id integer NOT NULL AUTO_INCREMENT,
    date varchar(12),
    heure varchar(6),
    contenu varchar(256),
    id_user integer,
    primary key (id),
    foreign key (id_user) references user (id)
)ENGINE=MYISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

delete from post;
select * from post;

SELECT * FROM user WHERE id not in (SELECT id_user_1 from relation where id_user_1 = 1)
	and id not in (SELECT id_user_2 from relation where id_user_1 = 1);


SELECT * FROM user WHERE id = (SELECT id_user_1 from relation where id_user_1 = 1);

SELECT * FROM relation where id_user_1=1 or id_user_2=1;

select * from relation;

SELECT id_user_2 from relation where id_user_1 = 1 INTERSECT id_user_1 = 3;

