Create table Avaliados(
   id int not null auto_increment primary key,
   id_avaliador int not null,
   id_avaliado int not null
) ENGINE = InnoDB DEFAULT CHARSET = UTF8;

Alter table Avaliados add constraint fk_avaliados_usuario
foreign key (id_avaliador) references Usuario(id);

Alter table Avaliados add constraint fk_avaliados_mecanico
foreign key (id_avaliado) references Mecanico(id);