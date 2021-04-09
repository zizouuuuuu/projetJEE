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

INSERT INTO user (firstname, lastname, username, password) VALUES
('Marcel', 'Ophane', 'marcel', 'orphane'),
('Richard', 'Tichaut', 'richard', 'tichaut');

