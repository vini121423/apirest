Create table Usuario(
  id int not null auto_increment primary key,
  nome varchar(40) not null,
  email varchar(100) not null,
  senha varchar(255) not null,
  sexo char(1) not null,
  id_cidade not null,
  ativo boolean
) ENGINE = InnoDB DEFAULT CHARSET = UTF8;

Alter table Usuario add constraint fk_cidade_usuario
foreign key(id_cidade) references Cidade(id);