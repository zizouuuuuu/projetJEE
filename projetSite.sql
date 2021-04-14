use projetsite;

CREATE TABLE user (
  id integer NOT NULL AUTO_INCREMENT,
  firstname varchar(20) NOT NULL,
  lastname varchar(20) NOT NULL,
  username varchar(20) NOT NULL,
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


