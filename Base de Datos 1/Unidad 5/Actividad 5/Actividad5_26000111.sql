Create database Prestamo_A5;
use Prestamo_A5;

Create table Departamento(
Cod_Departamento int not null primary key,
Departamento char (15)
);

Create table Empleado(
Cod_Empleado int not null primary key,
Empleado char (20),
Cod_Departamento int not null, index (Cod_Departamento),
foreign key (Cod_Departamento) references Departamento(Cod_Departamento)
);

Create table Proveedor(
Cod_Proveedor int not null primary key,
Proveedor char(15),
Direccion char(25),
Persona_Contacto char(15),
Telefono char(15)
);

Create table Factura(
No_Factura int not null primary key,
Fecha_compra date,
Monto char(15),
Cod_Proveedor int not null, index (Cod_Proveedor),
foreign key (Cod_Proveedor) references Proveedor(Cod_Proveedor)
);

Create table Cañonera(
Cod_Cañonera int not null primary key,
Fecha_Ingreso date,
Marca char(15),
Modelo char(15),
No_Serie char(10),
Años_Garantía char(1),
Fecha_Vencimiento_Garantía date,
No_Factura int not null, index (No_Factura),
foreign key (No_Factura) references Factura(No_Factura)
);

Create table Prestamo(
Fecha_Entrega date not null,
Hora_Entrega char(8) not null,
primary key (Fecha_Entrega, Hora_Entrega),
Fecha_Devolucion date,
Hora_Devolucion char(8),
Cod_Cañonera int not null, index (Cod_Cañonera),
foreign key (Cod_Cañonera) references Cañonera(Cod_Cañonera),
Cod_Empleado int not null, index (Cod_Empleado),
foreign key (Cod_Empleado) references Empleado(Cod_Empleado)
);

/*Ejemplos*/

show tables

describe Cañonera
describe Prestamo

select * from Cañonera;
select * from Departamento;
select * from Empleado;

insert into Departamento values
('10', 'Marketing');

insert into Departamento values
('20', 'Administración');

insert into Empleado values
('101','Lisa Morales', '10');

insert into Empleado values
('102','Kevin Jaco', '20');

update Empleado 
set Empleado = 'Rony Godoy'
where Cod_Empleado = '102';

insert into Proveedor values
('10101', 'Martinico', '3a. Calle 13-66 Z.3', 'Eynar Godoy','22864646');

update Proveedor
set Telefono = '22543256'
where Cod_Proveedor = '10101';

Delete from Empleado
Where Cod_empleado = '102';

Delete from Proveedor
where Cod_Proveedor = '10101';





