DROP table IF EXISTS caja;
DROP table IF EXISTS almacen;

create table almacen(
	codigo int AUTO_INCREMENT PRIMARY KEY,
    lugar nvarchar(100),
    capacidad int
    );
    
create table caja(
    num_referencia char(5) PRIMARY KEY,
    contenido nvarchar(100),
    valor int,
    almacen int,
    FOREIGN KEY (almacen) REFERENCES almacen (codigo) 
    ON DELETE CASCADE ON UPDATE CASCADE
);

insert into almacen (lugar,capacidad) VALUES ('Reus', 200);
insert into almacen (lugar,capacidad) VALUES ('Tarragona', 300);
insert into almacen (lugar,capacidad) VALUES ('Madrid', 500);
insert into almacen (lugar,capacidad) VALUES ('Girona', 100);
insert into almacen (lugar,capacidad) VALUES ('Barcelona', 1000);

insert into caja VALUES ('R', 'Tijeras', 5, 1);
insert into caja VALUES ('E', 'Boligrafos', 2, 2);
insert into caja VALUES ('T', 'Lapcies', 1, 2);
insert into caja VALUES ('W', 'Gomas', 4, 4);
insert into caja VALUES ('G', 'Sacapuntas', 6, 5);