Create database pedidos261;
use pedidos261;

Create table Cliente(
Cod_Cliente int not null primary key,
Nombre char(25),
Direccion char(30),
Telefono char(15)
);

Create table Empleado(
Cod_Empleado int not null primary key,
Nombre_emp char(25),
Apellido_emp char(25)
);

Create table Producto(
Cod_producto int not null primary key,
Descripcion char(25),
Precio int not null
);

Create table Pedido(
Num_pedido int not null primary key,
Fecha_pedido date,
Hora_pedido time,
Fecha_entrega date,
Cod_Cliente int not null, index(Cod_Cliente),
foreign key(Cod_Cliente) references Cliente(Cod_Cliente),
Cod_Empleado int not null, index(Cod_Empleado),
foreign key(Cod_Empleado) references Empleado(Cod_Empleado)
);

Create table Detalle_Pedido(
Num_pedido int not null,
Cod_Producto int not null,
primary key(Num_pedido, Cod_Producto),
index(Num_pedido),
foreign key(Num_pedido) references Pedido(Num_pedido),
index(Cod_Producto),
foreign key(Cod_Producto) references Producto(Cod_Producto),
Cantidad int not null
);

Show tables
describe empleado
describe producto
describe detalle_pedido

alter table producto add existencia int;

select * from Cliente;

Insert into Cliente values
(2030, 'Omar', '7c. 2-40 Z. 11', '22334478'),
(2031, 'Carlos', '6a 7-22 Z.12', '21242300');

select * from Empleado;

Insert into Empleado values
(123, 'Luis', 'Larios'),
(124, 'Karla', 'Aguilar');

select * from Producto;

Insert into Producto values
(14082020, 'Computadora', '4750.00', 8),
(15082020, 'Impresora', '1100.75', 14),
(16082020, 'Escaner', '700.50', 2);

select * from Pedido;

Insert into Pedido values
(1, '2026-08-13', '10:15', '2026-08-14', 2030, 123),
(2, '2026-08-14', '12:10', '2026-08-16', 2030, 124);

select * from Detalle_Pedido;

Insert into Detalle_Pedido values
(1, 14082020, 1),
(1, 15082020, 2),
(2, 14082020, 1);

Update Cliente
set Telefono = '24238020'
Where Cod_Cliente = '2030';

Delete from Producto
Where Cod_Producto = '16082020';

