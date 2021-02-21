CREATE TABLE 'association' (
    idAssoc INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nomAssoc varchar(100) not null,
    codeAssoc varchar(20) not null,
    descAssoc varchar(500) not null,
    logoAssoc varchar(100),
    addrAssoc varchar(100),
    etatInfo int default 1
);


create table 'membreAssociation'(
    idMembre INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nomMembre varchar(50) not null,
    prenomMember varchar(50) not null,
    posteMembre varchar(50) not null
);




