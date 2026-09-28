Create database Negocio;
use Negocio;

Create table Categorias (
	Cod_Categoria int primary key,
    Nombre_Categoria varchar(20) not null
);

create table Productos(
    Cod_Producto int not null primary key,
    Cod_Categoria int not null,
    Descripcion varchar(25) not null,
    Precio_Unitario decimal(10,2) not null,
    Precio_Docena decimal(10,2) not null,
    Precio_Mayor decimal(10,2) not null,
    Existencia int not null default 0,
    Nivel_Reabastecimiento int not null,
    Tipo_Empaque varchar(25) not null,
    index(Cod_Categoria),
    foreign key(Cod_Categoria) references Categorias(Cod_Categoria)
);


create table Clientes(
    DPI int not null primary key,
    Nombre varchar(25) not null,
    NIT varchar(15),
    Direccion varchar(25),
    Telefono varchar(20),
    Email varchar(50)
);


create table Proveedores(
    Cod_Proveedor int not null primary key,
    NIT varchar(15),
    Razon_Social varchar(20) not null,
    Direccion varchar(20),
    Telefono varchar(20),
    Pagina_Web varchar(50),
    Email varchar(50),
    Contacto_Principal varchar(25)
);


create table Compras(
    Num_Documento int not null primary key,
    Fecha date,
    Cod_Proveedor int not null,
    index(Cod_Proveedor),
    foreign key(Cod_Proveedor) references Proveedores(Cod_Proveedor)
);


create table Detalle_Compra(
    Num_Documento int not null,
    Cod_Producto int not null,
    Cantidad int not null,
    Precio decimal(10,2) not null,
    Total decimal(10,2) not null,
    primary key(Num_Documento, Cod_Producto),
    index(Cod_Producto),
    foreign key(Num_Documento) references Compras(Num_Documento),
    foreign key(Cod_Producto) references Productos(Cod_Producto)
);


create table Facturas(
    No_Factura int not null primary key,
    Fecha date,
    DPI int not null,
    Nombre_Facturacion varchar(25) not null,
    NIT_Facturacion varchar(15),
    Direccion_Facturacion varchar(25),
    index(DPI),
    foreign key(DPI) references Clientes(DPI)
);


create table Detalle_Factura(
    No_Factura int not null,
    Cod_Producto int not null,
    Precio decimal(10,2) not null,
    Cantidad int not null,
    Total decimal(10,2) not null,
    primary key(No_Factura, Cod_Producto),
    index(Cod_Producto),
    foreign key(No_Factura) references Facturas(No_Factura),
    foreign key(Cod_Producto) references Productos(Cod_Producto)
);


create table Inventario(
    Cod_Inventario int not null primary key,
    Cod_Producto int not null,
    Tipo_Registro varchar(25) not null,
    Fecha date,
    Precio decimal(10,2) not null,
    Entradas int not null default 0,
    Salidas int not null default 0,
    index(Cod_Producto),
    foreign key(Cod_Producto) references Productos(Cod_Producto)
);

Show tables
describe Productos;
describe Detalle_Compra;

insert into Categorias(Cod_Categoria, Nombre_Categoria) values
(1, 'Bebidas'),
(2, 'Snacks'),
(3, 'Limpieza'),
(4, 'Alimentos'),
(5, 'Cuidado Personal');

select * from Categorias;

insert into Productos values
(101, 1, 'Coca Cola 600ml', 8.00, 90.00, 340.00, 50, 10, 'Botella'),
(102, 1, 'Agua Pura 1L', 6.00, 65.00, 240.00, 80, 15, 'Botella'),
(103, 2, 'Papas Fritas Grandes', 12.00, 130.00, 480.00, 25, 10, 'Bolsa'),
(104, 2, 'Galletas de Chocolate', 7.50, 80.00, 290.00, 60, 15, 'Paquete'),
(105, 3, 'Detergente 1kg', 35.00, 390.00, 1450.00, 12, 10, 'Bolsa'),
(106, 3, 'Desinfectante 1L', 28.00, 310.00, 1150.00, 8, 10, 'Botella'),
(107, 4, 'Arroz 5kg', 42.00, 480.00, 1800.00, 30, 10, 'Bolsa'),
(108, 4, 'Aceite 1L', 18.00, 200.00, 750.00, 45, 15, 'Botella'),
(109, 5, 'Shampoo 750ml', 55.00, 620.00, 2300.00, 6, 10, 'Botella'),
(110, 5, 'Crema Corporal 400ml', 48.00, 540.00, 2000.00, 20, 8, 'Frasco');

select * from Productos;

insert into Clientes values
(30123456, 'Carlos Lopez', '1234567-8', 'Zona 1, Guatemala', '55551234', 'carlos@gmail.com'),
(30234567, 'Maria Garcia', '2345678-9', 'Zona 7, Guatemala', '55552345', 'maria@gmail.com'),
(30345678, 'Juan Martinez', '3456789-0', 'Zona 12, Guatemala', '55553456', 'juan@gmail.com'),
(30456789, 'Ana Rodriguez', '4567890-1', 'Zona 5, Guatemala', '55554567', 'ana@gmail.com'),
(30567890, 'Pedro Hernandez', '5678901-2', 'Zona 11, Guatemala', '55555678', 'pedro@gmail.com');

select * from Clientes;

insert into Proveedores values
(201, '1111111-1', 'Distribuidora Central', 'Zona 1, Guatemala', '22221111', 'www.distribuidoracentral.com', 'ventas@distribuidoracentral.com', 'Luis Perez'),
(202, '2222222-2', 'Comercial La Union', 'Zona 4, Guatemala', '22222222', 'www.comercialunion.com', 'ventas@comercialunion.com', 'Sofia Morales'),
(203, '3333333-3', 'Productos del Pacifico', 'Zona 10, Guatemala', '22223333', 'www.productospacifico.com', 'ventas@productospacifico.com', 'Roberto Gomez'),
(204, '4444444-4', 'Importadora Nacional', 'Zona 9, Guatemala', '22224444', 'www.importadoranacional.com', 'ventas@importadoranacional.com', 'Laura Castillo');

alter table Proveedores
modify Razon_Social varchar(200) not null;

select * from Proveedores;

insert into Compras values
(1001, '2026-09-01', 201),
(1002, '2026-09-03', 202),
(1003, '2026-09-05', 203),
(1004, '2026-09-07', 201),
(1005, '2026-09-10', 204);

select * from Compras;

insert into Detalle_Compra values
(1001, 101, 100, 6.00, 600.00),
(1001, 102, 80, 4.50, 360.00),
(1001, 103, 50, 9.00, 450.00),
(1002, 104, 100, 5.50, 550.00),
(1002, 105, 40, 28.00, 1120.00),
(1003, 106, 50, 22.00, 1100.00),
(1003, 107, 30, 35.00, 1050.00),
(1004, 108, 60, 15.00, 900.00),
(1004, 109, 30, 45.00, 1350.00),
(1005, 110, 40, 40.00, 1600.00);

select * from Detalle_Compra;

insert into Facturas values
(5001, '2026-09-02', 30123456, 'Carlos Lopez', '1234567-8', 'Zona 1, Guatemala'),
(5002, '2026-09-04', 30234567, 'Maria Garcia', '2345678-9', 'Zona 7, Guatemala'),
(5003, '2026-09-06', 30345678, 'Juan Martinez', '3456789-0', 'Zona 12, Guatemala'),
(5004, '2026-09-08', 30456789, 'Ana Rodriguez', '4567890-1', 'Zona 5, Guatemala'),
(5005, '2026-09-11', 30567890, 'Pedro Hernandez', '5678901-2', 'Zona 11, Guatemala');

select * from Facturas;

insert into Detalle_Factura values
(5001, 101, 8.00, 3, 24.00),
(5001, 104, 7.50, 2, 15.00),

(5002, 105, 35.00, 1, 35.00),
(5002, 108, 18.00, 2, 36.00),

(5003, 107, 42.00, 2, 84.00),
(5003, 110, 48.00, 1, 48.00),

(5004, 103, 12.00, 4, 48.00),
(5004, 106, 28.00, 2, 56.00),

(5005, 109, 55.00, 1, 55.00),
(5005, 102, 6.00, 5, 30.00);

select * from Detalle_Factura;

insert into Inventario values
(1, 101, 'Compra', '2026-09-01', 6.00, 100, 0),
(2, 102, 'Compra', '2026-09-01', 4.50, 80, 0),
(3, 103, 'Compra', '2026-09-01', 9.00, 50, 0),
(4, 101, 'Venta', '2026-09-02', 8.00, 0, 3),
(5, 104, 'Venta', '2026-09-02', 7.50, 0, 2),
(6, 105, 'Compra', '2026-09-03', 28.00, 40, 0),
(7, 106, 'Compra', '2026-09-05', 22.00, 50, 0),
(8, 107, 'Compra', '2026-09-05', 35.00, 30, 0),
(9, 108, 'Venta', '2026-09-08', 18.00, 0, 2),
(10, 109, 'Venta', '2026-09-11', 55.00, 0, 1);

Select * from Inventario;

update Clientes
set Telefono = '55559999'
where DPI = 30123456;

select * from Clientes
where DPI = 30123456;

insert into Categorias values
(6, 'Categoria Temporal');

delete from Categorias
where Cod_Categoria = 6;

select * from Categorias
where Cod_Categoria = 6;

/*  los 5 productos mas costosos  */

select Descripcion, Precio_Unitario, Existencia, Tipo_Empaque
from Productos
order by Precio_Unitario desc
limit 5;

/*  Despliegue una lista de cada proveedor, sus productos, las cantidades en existencia y los niveles de reabastecimiento asociados; se debe ordenar en forma alfabética por proveedor; dentro de cada categoría de proveedor hay que colocar los productos en orden alfabético  */

select Proveedores.Razon_Social, Productos.Descripcion, Productos.Existencia, Productos.Nivel_Reabastecimiento from Proveedores join Compras on Proveedores.Cod_Proveedor = Compras.Cod_Proveedor 
join Detalle_Compra on Compras.Num_Documento = Detalle_Compra.Num_Documento
join Productos on Detalle_Compra.Cod_Producto = Productos.Cod_Producto order by Proveedores.Razon_Social, Productos.Descripcion;

/* Productos que necesitan reabastecimiento */

select Proveedores.Razon_Social, Proveedores.Telefono, Proveedores.Email, Productos.Descripcion, Productos.Existencia, Productos.Nivel_Reabastecimiento from Proveedores join Compras on Proveedores.Cod_Proveedor = Compras.Cod_Proveedor
join Detalle_Compra on Compras.Num_Documento = Detalle_Compra.Num_Documento
join Productos on Detalle_Compra.Cod_Producto = Productos.Cod_Producto
where Productos.Existencia < Productos.Nivel_Reabastecimiento order by Productos.Descripcion;

