Create table Servico(
  id int not null auto_increment,
  titulo varchar(50) not null,
  descricao varchar(255) not null,
  emergencia boolean,
  concluido boolean,
  datahora date,
  id_cliente int not null

) ENGINE = InnoDB DEFAULT CHARSET = UTF8;

Alter table Servico add constraint fk_servico_cliente
foreign key(id_cliente) references Usuario(id);