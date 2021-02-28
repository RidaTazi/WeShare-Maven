CREATE TABLE IF NOT EXISTS association (
    idAssoc INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nomAssoc varchar(100) not null,
    codeAssoc varchar(20) not null,
    descAssoc varchar(500) not null,
    logoAssoc varchar(100),
    addrAssoc varchar(100),
    etatInfo int default 1
);


create table IF NOT EXISTS membreAssociation(
    idMembre INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nomMembre varchar(50) not null,
    prenomMember varchar(50) not null,
    posteMembre varchar(50) not null,
    idAssoc INT NOT NULL,
    CONSTRAINT FK_membre_assoc FOREIGN KEY (idAssoc)
    REFERENCES association(idAssoc)
);


CREATE TABLE IF NOT EXISTS User (
    id_user INT AUTO_INCREMENT,
    etatInfo_user BOOLEAN,
    username_user VARCHAR(50) UNIQUE NOT NULL,
    password_user VARCHAR(256) NOT NULL,
    role_user CHAR(1) NOT NULL,
    email_user VARCHAR(100) UNIQUE NULL,
    PRIMARY KEY (id_user)
);

CREATE TABLE IF NOT EXISTS AdminSYS (
    id_admin INT AUTO_INCREMENT,
    etatInfo_admin BOOLEAN,
    username_admin VARCHAR(50) UNIQUE NOT NULL,
    password_admin VARCHAR(256) NOT NULL,
    email_admin VARCHAR(100) UNIQUE NULL,
    PRIMARY KEY (id_admin)
);

CREATE TABLE IF NOT EXISTS Token (
    id_token INT AUTO_INCREMENT,
    value_token VARCHAR(256) NOT NULL,
    user_token INT UNIQUE NOT NULL,
    PRIMARY KEY (id_token),
    FOREIGN KEY (user_token) REFERENCES User (id_user)
);

CREATE TABLE IF NOT EXISTS Don (idDon int auto_increment,
	  typeDon varchar(100),
	  logoDon varchar(100),
	  descDon varchar(200),
	  dateDon date,
	  stateDon varchar(20),
	  etatInfo int,
	  associationId int,
	  publicationId int,
	  donneurId int,
	  primary key (idDon),
	  foreign key (associationId) references association(idAssoc),
	  foreign key (publicationId) references Publication(idPub),
	  foreign key (donneurId) references donneur(idDonneur)
				);	
	

CREATE TABLE IF NOT EXISTS Publication (idPub int auto_increment,
	  titrePub varchar(100),
	  descPub varchar(200),
	  datePub date,
	  typePub varchar(100),
	  etatInfoPub int,
	  logoPub varchar(100),
	  associationId int,
	  primary key (id),
	  foreign key (associationId) references association(idAssoc)
	    );



