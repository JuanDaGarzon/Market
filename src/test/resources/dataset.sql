insert into usuario values (1,"sandro@gmail.com","Sandro","1234","MURILLO", "Calle 23 #20-02", "3253243638");
insert into usuario values (2,"jose@gmail.com","Jose","123","ARMENIA", "Calle 24 #10-02", "3253243812");
insert into usuario values (3,"david@gmail.com","David","d49a8","PEREIRA", "Calle 43 #20-02", "3253243612");
insert into usuario values (4,"felipe@gmail.com","Felipe","123456","MEDELLIN", "Calle 53 #30-02", "3269843638");
insert into usuario values (5,"angel@gmail.com","Angel","12","CALI", "Calle 22 #20-04", "3883243638");

insert into producto values (1,"VEHICULO", "Automovil de cuatro puestos", "SIN_REVISAR", '2023-10-18 7:30:00',
                             '2024-01-18 7:30:00', "Kia EV6",256041170.00,20,1 );
insert into producto values (2, "VEHICULO","Automovil de ultima generacion","ACEPTADO",'2023-11-18 7:30:00',
                             '2024-03-18 7:30:00', "Corvette", 892008000.00, 988, 2 );
insert into producto values (3, "INMUEBLE","Propiedad de tres pisos con vista al mar","SIN_REVISAR",'2023-09-18 7:30:00',
                             '2024-01-18 7:30:00', "Apartamento", 428000000.00, 125, 3 );
insert into producto values (4, "SERVICIO","Instalcion de cable para domicilio", "ACEPTADO",'2023-11-18 7:30:00',
                             '2023-12-18 7:30:00', "Servicio de intalacion de cableado", 38000.00, 155, 4 );
insert into producto values (5, "ELECTRODOMESTICO","Smartphone Samsung Galaxy S ultimo modelo","DENEGADO",'2023-07-18 7:30:00',
                             '2023-08-18 7:30:00', "Samsung Galaxy S", 5000000.00, 30, 5);

insert into producto_imagenes values (1,"x6c6zx4c6588","44687c48x4c");
insert into producto_imagenes values (2,"8xc49z8c","65cc8");
insert into producto_imagenes values (3,"x5zc5z","c6xz9c9");
insert into producto_imagenes values (4,"xzc459zx8c","9sacc5");
insert into producto_imagenes values (5,"as8d65x","x98zc3a6");

insert into administrador values (1,"pepito@gmail.com","pepito","123");
insert into administrador values (2,"juan@gmail.com","juan","1234");
insert into administrador values (3,"samuel@gmail.com","samuel","12345");
insert into administrador values (4,"giselle@gmail.com","giselle","123456");
insert into administrador values (5,"luis@gmail.com","luis","1234567");

insert into comentario values (1, '2022-04-3 10:30:00', "El producto tiene una gran calidad" , 1, 1);
insert into comentario values (2, '2022-03-2 9:30:00', "El producto es de muy mala calidad", 2, 2);
insert into comentario values (3, '2022-02-20 8:30:00', "Gran producto", 3, 3);
insert into comentario values (4, '2022-01-20 6:30:00', "Es de mucha utilidad", 4, 4);
insert into comentario values (5, '2022-12-18 7:30:00', "Buen servicio", 5, 5);

insert into carrito values (1, 20000000.00, 20, 1, 1);
insert into carrito values (2, 4800000.00,25, 2, 2);
insert into carrito values (3, 705253.00, 56, 3, 3);
insert into carrito values (4, 98524.00, 78, 4, 4);
insert into carrito values (5, 852000.00, 32, 5, 5);

insert into compra values (1, '2022-01-18 7:30:00', "EFECTIVO", 20000000.00, 1);
insert into compra values (2, '2022-03-18 8:30:00', "TARJETA_DEBITO", 4800000.00, 2);
insert into compra values (3, '2022-02-18 9:30:00', "EFECTIVO", 705253.00, 3);
insert into compra values (4, '2022-03-18 10:30:00', "TARJETA_CREDITO", 98524.00, 4);
insert into compra values (5, '2022-08-18 12:30:00', "EFECTIVO", 852000.00, 5);

insert into favorito values (1,1);
insert into favorito values (2,2);
insert into favorito values (3,3);
insert into favorito values (4,4);
insert into favorito values (5,5);

insert into productoAdministrador values (1,"DENEGADO",'2023-11-18 7:30:00',"Producto Denegado","No cumple con los
                                            requisitos",1,1);
insert into productoAdministrador values (2,"SIN_REVISAR",'2023-12-18 7:30:00',"El producto fue denegado porque no cumple con
                                            los estandares de calidad", "El producto no cuneta con la informacion
                                            completa",2,2);
insert into productoAdministrador values (3,"DENEGADO",'2023-10-18 7:30:00',"El producto fue aceptado porque cumple con
                                            los estandares de calidad", "Su producto cumple con todos nuestros
                                            requisitos",3,3);
insert into productoAdministrador values (4,"DENEGADO",'2023-10-18 7:30:00',"El producto fue denegado porque no cumple con
                                            los estandares de calidad", "Por motivos de seguridad del cliente se hace
                                            necesario mas informacion sobre el mismo",4,4);
insert into productoAdministrador values (5,"ACEPTADO",'2023-12-18 7:30:00',"El producto fue aceptado porque cumple con
                                            los estandares de calidad", "El producto necesita implementar mas
                                            caracteristicas, con el fin de que los clientes tengan mayor conocimiento
                                            de lo que compraran",5,5);

