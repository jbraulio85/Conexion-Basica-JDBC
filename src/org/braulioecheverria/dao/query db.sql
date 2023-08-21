drop database if exists mydb;

create database mydb;

use mydb;

create table persona 
(
	id_persona int primary key not null auto_increment,
    apellido varchar(64),
    nombre varchar(64),
    direccion varchar(255),
    municipio varchar (64),
    telefono int
);

insert into persona (apellido, nombre, direccion, municipio, telefono) values ('Montufar', 'José', 'Antigua', 'Sacatepequez', 22160099);

select * from persona;

delimiter $$
create procedure sp_ListarPersonas()
begin
	select * from persona;
end$$
delimiter ;
    
call sp_ListarPersonas();

select * from persona;

delimiter $$
create procedure sp_BuscarPersona(in _id_persona int)
begin
	select * from persona where _id_persona = id_persona;
end $$
delimiter ;

call sp_BuscarPersona(2);
delimiter ;

delimiter $$
create procedure sp_EditarPersona(in _id_persona int, in _apellido varchar(64), in _nombre varchar(64), in _direccion varchar(255), in _municipio varchar(64), in _telefono int )
begin
	update persona
    set
		persona.apellido = _apellido,
        persona.nombre = _nombre,
        persona.direccion = _direccion,
        persona.municipio = _municipio,
        persona.telefono = _telefono
	where
		persona.id_persona = _id_persona;
end $$
delimiter ;

call sp_EditarPersona(2,'Godoy','Naudy','Nimajuyú','Guatemala',22160000);

delimiter $$
create procedure sp_AgregarPersona(in _apellido varchar(64), in _nombre varchar(64), in _direccion varchar(255), in _municipio varchar(64), in _telefono int )
begin
	insert into persona (apellido, nombre, direccion, municipio, telefono)
		values(_apellido, _nombre, _direccion, _municipio, _telefono);
end $$
delimiter ;

delimiter $$
create procedure sp_EliminarPersona(in _id_persona int)
begin
	delete from persona where id_persona = _id_persona;
end $$
delimiter ;

call sp_EliminarPersona(1);