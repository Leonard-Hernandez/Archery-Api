CREATE TABLE Archers (
    id bigint NOT NULL auto_increment PRIMARY KEY,
    id_document VARCHAR(20) UNIQUE,
    name VARCHAR(100) NOT NULL,
    birthday DATE NOT NULL,
    category varchar(20),
    gender VARCHAR(100) NOT NULL,
    active tinyint)
