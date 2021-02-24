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
    username_user VARCHAR(50) NOT NULL,
    password_user VARCHAR(256) NOT NULL,
    email_user VARCHAR(100) NULL,
    PRIMARY KEY (id_user)
);

CREATE TABLE IF NOT EXISTS AdminSYS (
    id_admin INT AUTO_INCREMENT,
    etatInfo_admin BOOLEAN,
    username_admin VARCHAR(50) NOT NULL,
    password_admin VARCHAR(256) NOT NULL,
    email_admin VARCHAR(100) NULL,
    PRIMARY KEY (id_admin)
);




