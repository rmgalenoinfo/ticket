CREATE DATABASE ticketcliente;

/*==============================================================*/
/* Table:ticket_cliente                                         */
/*==============================================================*/

CREATE TABLE ticket_cliente (
	id_ticket SERIAL NOT NULL, 
	id_cliente INT4 NOT NULL, 
	id_estado INT4 NOT NULL, 
	id_prioridad INT4, 
	ticket VARCHAR(250) NOT NULL, 
	cliente_caso VARCHAR (250), 
	fecha_vencimiento TIMESTAMP, 
	acuerdo VARCHAR(250), 
	constraint PK_TICKET_CLIENTE primary key (id_ticket));

create unique index TICKET_CLIENTE_PK on ticket_cliente (id_ticket);
create index RELATIONSHIP_CLIENTE_TICKET_FK on ticket_cliente (id_cliente);
create index RELATIONSHIP_TICKET_ESTADO_FK on ticket_cliente (id_estado);
create index RELATIONSHIP_TICKET_PRIORIDAD_FK on ticket_cliente (id_prioridad);

/*==============================================================*/
/* Table:cliente                                                */
/*==============================================================*/

CREATE TABLE cliente(
	id_cliente SERIAL, apellido VARCHAR(250), 
	nombre VARCHAR (250), cedula VARCHAR(13), 
	fecha_contrato TIMESTAMP, 
	estado INT4, 
	constraint PK_CLIENTE primary key (id_cliente));

create unique index CLIENTE_PK on cliente (id_cliente);

/*==============================================================*/
/* Table:estados                                                */
/*==============================================================*/

CREATE TABLE estados(
	id_estado SERIAL, 
	estado VARCHAR(250) NOT NULL, 
	constraint PK_ESTADO primary key (id_estado));

create unique index ESTADOS_PK on estados (id_estado);

/*==============================================================*/
/* Table:prioridades                                            */
/*==============================================================*/

CREATE TABLE prioridades(
	id_prioridad SERIAL, 
	prioridad VARCHAR(250), 
	constraint PK_PRIORIDAD primary key (id_prioridad));

create unique index PRIORIDAD_PK on prioridades (id_prioridad);

alter table ticket_cliente 
	add constraint FK_TICKET_CLIENTE foreign key (id_cliente) 
	references cliente (id_cliente) 
	on delete restrict on update restrict;

alter table ticket_cliente 
	add constraint FK_TICKET_ESTADO foreign key (id_estado) 
	references estados (id_estado) 
	on delete restrict on update restrict;

alter table ticket_cliente 
	add constraint FK_TICKET_PRIORIDADES foreign key (id_prioridad) 
	references prioridades (id_prioridad) 
	on delete restrict on update restrict;

insert into cliente(id_cliente, apellido, nombre, cedula, fecha_contrato, estado) values (1, 'Riera', 'Daniel', '1717311247', '2012-03-08', 1);
insert into cliente(id_cliente, apellido, nombre, cedula, fecha_contrato, estado) values (2, 'Suarez', 'Antonio', '1715178513', '2011-01-15', 1);
insert into cliente(id_cliente, apellido, nombre, cedula, fecha_contrato, estado) values (3, 'Ortiz', 'Maria', '1111072508', '2010-06-11', 1);
insert into cliente(id_cliente, apellido, nombre, cedula, fecha_contrato, estado) values (4, 'Salazar', 'David', '1715090918', '2010-05-04', 1);
insert into cliente(id_cliente, apellido, nombre, cedula, fecha_contrato, estado) values (5, 'Carrera', 'Henry', '1509321237', '2012-06-01', 1);
insert into cliente(id_cliente, apellido, nombre, cedula, fecha_contrato, estado) values (6, 'Soria', 'Jorge', '1727331548', '2016-09-09', 1);

insert into estados(id_estado, estado) values (1, 'Ticket Abierto');
insert into estados(id_estado, estado) values (2, 'Ticket Cerrado');
insert into estados(id_estado, estado) values (3, 'Ticket Atrasado');
insert into estados(id_estado, estado) values (4, 'Ticket Escalado');
insert into estados(id_estado, estado) values (5, 'Ticket Prioridad Alta');

insert into prioridades(id_prioridad, prioridad) values (1, 'Baja');
insert into prioridades(id_prioridad, prioridad) values (2, 'Medio');
insert into prioridades(id_prioridad, prioridad) values (3, 'Alta');

insert into ticket_cliente (id_ticket, id_cliente, id_estado, id_prioridad, ticket, cliente_caso, fecha_vencimiento, acuerdo) values (1, 1, 1, 3, 'Actualización de la aplicación', null, '2020-11-25', 'Se llego a un acuerdo');
insert into ticket_cliente (id_ticket, id_cliente, id_estado, id_prioridad, ticket, cliente_caso, fecha_vencimiento, acuerdo) values (2, 3, 1, 2, 'Actualización de un servidor', null, '2020-11-26', 'Se llego a un acuerdo');

