create table training_records (
id int not null auto_increment,
id_archer bigint not null,
rounds int,
arrows_shot int not null,
distance varchar(15) not null,
target varchar(50) not null,
record_date datetime not null,
primary key (id),
CONSTRAINT `FK_ARCHERS` FOREIGN KEY (`ID_ARCHER`) REFERENCES `ARCHERS` (`ID`));