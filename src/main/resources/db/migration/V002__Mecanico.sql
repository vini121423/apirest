Create table Mecanico(
  id int not null auto_increment primary key,
  email varchar(100),
  senha varchar(255),
  nome_mecanico varchar(40),
  nome_oficina varchar(20),
  endereco varchar(50),
  id_cidade int not null,
  status boolean,
  soma_avaliacao int,
  qtde_avaliacao int,
  media numeric
  
) ENGINE = InnoDB DEFAULT CHARSET = UTF8;

Alter table Mecanico add constraint fk_cidade_mecanico
foreign key(id_cidade) references Cidade(id);