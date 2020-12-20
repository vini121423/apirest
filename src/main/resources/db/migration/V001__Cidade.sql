Create table Cidade(
  id int not null auto_increment primary key,
  nome varchar(50) not null,
  uf char(2) not null 
) ENGINE= InnoDB DEFAULT CHARSET = UTF8;

Insert into Cidade(nome,uf) values ('Agudos','SP'),('Lençóis Paulista','SP');