-- =============================================
-- 1. CINES
-- =============================================
INSERT INTO cine (nombre, direccion) VALUES
                                         ('Cinema Galaxia', 'Av. Corrientes 1234, CABA'),
                                         ('Cine Olimpo', 'Av. Cabildo 2567, CABA'),
                                         ('Megaplex Estelar', 'Av. Independencia 987, CABA'),
                                         ('Cine Capitolio', 'Av. Santa Fe 3456, CABA'),
                                         ('Cinema Nostalgia', 'Av. Del Libertador 5678, CABA');

-- =============================================
-- 2. EMPLEADOS
-- =============================================
INSERT INTO empleado (nombre, dni) VALUES
                                       ('Juan Pérez', 30123456),
                                       ('María Gómez', 35234567),
                                       ('Carlos López', 40345678),
                                       ('Ana Martínez', 28456789),
                                       ('Luis Rodríguez', 31567890);

-- =============================================
-- 3. CLIENTES (incluye VIP)
-- =============================================
INSERT INTO cliente (dtype, nombre, email, descuento) VALUES
                                                          ('Cliente', 'Roberto Fernández', 'roberto@email.com', NULL),
                                                          ('Cliente', 'Laura Díaz', 'laura@email.com', NULL),
                                                          ('ClienteVIP', 'Sofía Ramírez', 'sofia@email.com', 0.15),
                                                          ('Cliente', 'Diego Morales', 'diego@email.com', NULL),
                                                          ('ClienteVIP', 'Elena Castro', 'elena@email.com', 0.20);

-- =============================================
-- 4. PAGOS
-- =============================================
INSERT INTO pago (monto, tipo) VALUES
                                   (2500.00, 'EFECTIVO'),
                                   (3750.00, 'TARJETA'),
                                   (1800.00, 'EFECTIVO'),
                                   (4200.00, 'TARJETA'),
                                   (3100.00, 'TARJETA');

-- =============================================
-- 5. PELÍCULAS
-- =============================================
INSERT INTO pelicula (titulo, genero, cine_id) VALUES
                                                   ('Dune: Parte 2', 'ACCION', 1),
                                                   ('Intensamente 2', 'COMEDIA', 1),
                                                   ('Oppenheimer', 'DRAMA', 2),
                                                   ('Deadpool 3', 'ACCION', 2),
                                                   ('Tengo ganas de reír', 'COMEDIA', 3),
                                                   ('El secreto del faro', 'SUSPENSO', 3);

-- =============================================
-- 6. SALAS
-- =============================================
INSERT INTO sala (id, capacidad, dtype, beneficios, cine_id) VALUES
                                                                 (101, 120, 'Sala', NULL, 1),
                                                                 (102, 80, 'Sala', NULL, 1),
                                                                 (103, 50, 'SalaVIP', 'Butacas reclinables, servicio de comidas', 1),
                                                                 (201, 150, 'Sala', NULL, 2),
                                                                 (202, 60, 'SalaVIP', 'Sonido 7.1, butacas premium', 2),
                                                                 (301, 100, 'Sala', NULL, 3),
                                                                 (302, 45, 'SalaVIP', 'Entrada con pochoclo y bebida', 3);

-- =============================================
-- 7. FUNCIONES
-- =============================================
INSERT INTO funcion (horario, pelicula_id) VALUES
                                               ('14:00:00', 1),
                                               ('17:30:00', 1),
                                               ('20:45:00', 1),
                                               ('15:00:00', 2),
                                               ('18:30:00', 2),
                                               ('21:00:00', 3),
                                               ('16:15:00', 4),
                                               ('19:00:00', 4),
                                               ('22:15:00', 5),
                                               ('16:45:00', 6);

-- =============================================
-- 8. ENTRADAS
-- =============================================
INSERT INTO entrada (precio, asiento) VALUES
                                          (1250.00, 'A1'),
                                          (1250.00, 'A2'),
                                          (1250.00, 'B5'),
                                          (1500.00, 'C12'),
                                          (1250.00, 'D3'),
                                          (2000.00, 'F7'),
                                          (1500.00, 'E4'),
                                          (1250.00, 'G2'),
                                          (2000.00, 'H1'),
                                          (1500.00, 'J9');

-- =============================================
-- 9. PROVEEDORES
-- =============================================
INSERT INTO proveedor (nombre, telefono, direccion) VALUES
                                                        ('Coca-Cola Andina', '0800-222-2323', 'Av. Libertador 4500, CABA'),
                                                        ('PepsiCo Argentina', '0800-333-3434', 'Ruta 8 km 35, Pilar'),
                                                        ('Proveedora Golosinas SRL', '011-4567-8901', 'Av. Belgrano 2345, CABA'),
                                                        ('Palomitas Don Pepe', '011-5678-9012', 'Calle 50 N° 234, La Plata');

-- =============================================
-- 10. COMPRAS (insumos a proveedores)
-- =============================================
INSERT INTO compra (fecha, proveedor_id, cine_id) VALUES
                                                      ('2026-05-15', 1, 1),
                                                      ('2026-05-20', 2, 1),
                                                      ('2026-05-18', 3, 2),
                                                      ('2026-05-22', 4, 3),
                                                      ('2026-05-25', 1, 2);

-- =============================================
-- 11. INSUMOS
-- =============================================
INSERT INTO insumo (nombre, precio, compra_id) VALUES
                                                   ('Gaseosa 500ml', 850.00, 1),
                                                   ('Gaseosa 1.5L', 1200.00, 1),
                                                   ('Pochoclo chico', 800.00, 2),
                                                   ('Pochoclo grande', 1200.00, 2),
                                                   ('Chocolate barra', 500.00, 3),
                                                   ('Agua mineral', 700.00, 4),
                                                   ('Papas fritas', 900.00, 5);

-- =============================================
-- 12. VENTAS
-- =============================================
INSERT INTO venta (fecha, pago_id, cine_id) VALUES
                                                ('2026-05-30', 1, 1),
                                                ('2026-05-30', 2, 1),
                                                ('2026-05-30', 3, 2),
                                                ('2026-05-31', 4, 2),
                                                ('2026-05-31', 5, 3);

-- =============================================
-- 13. TABLAS RELACIONALES (N:N)
-- =============================================

-- Cine ↔ SalaVIP
INSERT INTO cine_sala_vip (cine_id, sala_vip_id) VALUES
                                                     (1, 103),
                                                     (2, 202),
                                                     (3, 302);

-- Cine ↔ Empleado
INSERT INTO cine_empleado (cine_id, empleado_id) VALUES
                                                     (1, 1),
                                                     (1, 2),
                                                     (2, 3),
                                                     (2, 4),
                                                     (3, 5),
                                                     (1, 5);  -- Luis trabaja en dos cines

-- Sala ↔ Función
INSERT INTO sala_funcion (sala_id, funcion_id) VALUES
                                                   (101, 1),
                                                   (101, 2),
                                                   (102, 3),
                                                   (103, 4),
                                                   (201, 5),
                                                   (202, 6),
                                                   (201, 7),
                                                   (301, 8),
                                                   (302, 9),
                                                   (301, 10);

-- Función ↔ Entrada
INSERT INTO funcion_entrada (funcion_id, entrada_id) VALUES
                                                         (1, 1),
                                                         (1, 2),
                                                         (2, 3),
                                                         (3, 4),
                                                         (4, 5),
                                                         (5, 6),
                                                         (6, 7),
                                                         (7, 8),
                                                         (8, 9),
                                                         (9, 10),
                                                         (10, 1),
                                                         (10, 2);

-- Venta ↔ Función
INSERT INTO venta_funcion (venta_id, funcion_id) VALUES
                                                     (1, 1),
                                                     (1, 2),
                                                     (2, 4),
                                                     (3, 5),
                                                     (3, 6),
                                                     (4, 7),
                                                     (4, 8),
                                                     (5, 10);

-- Venta ↔ Cliente
INSERT INTO venta_cliente (venta_id, cliente_id) VALUES
                                                     (1, 1),
                                                     (2, 3),
                                                     (3, 2),
                                                     (4, 4),
                                                     (5, 5);