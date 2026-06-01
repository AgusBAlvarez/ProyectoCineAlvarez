-- ============================================================
--  init.sql — Datos de prueba para Cine Alvarez
--  Se ejecuta UNA SOLA VEZ cuando el volumen está vacío.
--  Hibernate ya crea las tablas (ddl-auto=update),
--  este archivo solo inserta datos.
-- ============================================================

-- ─── 1. CINE ─────────────────────────────────────────────────
INSERT IGNORE INTO cine (id, nombre, direccion) VALUES
    (1, 'Cine Alvarez', 'Av. San Martín 1234, Neuquén');

-- ─── 2. EMPLEADOS ────────────────────────────────────────────
INSERT IGNORE INTO empleado (id, dni, nombre) VALUES
                                                  (1, 12345678, 'Carlos Rodríguez'),
                                                  (2, 23456789, 'Ana Gómez'),
                                                  (3, 34567890, 'Luis Fernández');

-- ─── 3. CINE ↔ EMPLEADO (tabla join) ────────────────────────
INSERT IGNORE INTO cine_empleado (cine_id, empleado_id) VALUES
                                                            (1, 1),
                                                            (1, 2),
                                                            (1, 3);

-- ─── 4. SALAS (dtype discriminator: 'Sala' o 'SalaVIP') ─────
-- Salas comunes
INSERT IGNORE INTO sala (dtype, id, capacidad, beneficios, sala_id) VALUES
                                                                        ('Sala',    1, 120, NULL, 1),
                                                                        ('Sala',    2,  90, NULL, 1),
                                                                        ('Sala',    3,  80, NULL, 1);

-- Salas VIP
INSERT IGNORE INTO sala (dtype, id, capacidad, beneficios, sala_id) VALUES
                                                                        ('SalaVIP', 4,  30, 'Butacas reclinables + servicio en sala', 1),
                                                                        ('SalaVIP', 5,  20, 'Butacas premium + snack incluido',       1);

-- ─── 5. CINE ↔ SALAVIP (tabla join) ─────────────────────────
INSERT IGNORE INTO cine_salavip (cine_id, salavip_id) VALUES
                                                          (1, 4),
                                                          (1, 5);

-- ─── 6. PELÍCULAS ────────────────────────────────────────────
-- genero: ACCION | COMEDIA | DRAMA | SUSPENSO
INSERT IGNORE INTO pelicula (id, titulo, genero, pelicula) VALUES
                                                               (1, 'Avengers: Endgame',  'ACCION',   1),
                                                               (2, 'El Padrino',         'DRAMA',    1),
                                                               (3, 'Inception',          'SUSPENSO', 1),
                                                               (4, 'La La Land',         'DRAMA',    1),
                                                               (5, 'Supercool',          'COMEDIA',  1);

-- ─── 7. FUNCIONES ────────────────────────────────────────────
INSERT IGNORE INTO funcion (id, horario, pelicula_id) VALUES
                                                          (1, '16:00:00', 1),   -- Avengers tarde
                                                          (2, '20:00:00', 1),   -- Avengers noche
                                                          (3, '18:00:00', 2),   -- El Padrino tarde
                                                          (4, '21:00:00', 3),   -- Inception noche
                                                          (5, '17:00:00', 4),   -- La La Land tarde
                                                          (6, '19:30:00', 5);   -- Supercool noche

-- ─── 8. SALA ↔ FUNCIÓN (tabla join) ─────────────────────────
INSERT IGNORE INTO sala_funcion (sala_id, funcion_id) VALUES
                                                          (1, 1),   -- Sala 1 → Avengers tarde
                                                          (2, 2),   -- Sala 2 → Avengers noche
                                                          (3, 3),   -- Sala 3 → El Padrino
                                                          (4, 4),   -- SalaVIP 4 → Inception
                                                          (5, 5),   -- SalaVIP 5 → La La Land
                                                          (1, 6);   -- Sala 1 → Supercool

-- ─── 9. ENTRADAS ─────────────────────────────────────────────
INSERT IGNORE INTO entrada (id, asiento, precio) VALUES
                                                     (1,  'A1',  1500.00),
                                                     (2,  'A2',  1500.00),
                                                     (3,  'B1',  1500.00),
                                                     (4,  'B2',  1500.00),
                                                     (5,  'C1',  2500.00),   -- VIP
                                                     (6,  'C2',  2500.00),   -- VIP
                                                     (7,  'D1',  1500.00),
                                                     (8,  'D2',  1500.00);

-- ─── 10. FUNCIÓN ↔ ENTRADA (tabla join) ──────────────────────
INSERT IGNORE INTO funcion_entrada (funcion_id, entrada_id) VALUES
                                                                (1, 1), (1, 2),   -- Avengers tarde: 2 entradas
                                                                (2, 3), (2, 4),   -- Avengers noche: 2 entradas
                                                                (4, 5), (4, 6),   -- Inception VIP: 2 entradas
                                                                (3, 7), (3, 8);   -- El Padrino: 2 entradas

-- ─── 11. CLIENTES ────────────────────────────────────────────
-- dtype: 'Cliente' o 'ClienteVIP' (ClienteVIP requiere descuento NOT NULL)
INSERT IGNORE INTO cliente (dtype, id, nombre, email, descuento) VALUES
                                                                     ('Cliente',    1, 'María López',    'maria@mail.com',   NULL),
                                                                     ('Cliente',    2, 'Juan Pérez',     'juan@mail.com',    NULL),
                                                                     ('ClienteVIP', 3, 'Sofía Martínez', 'sofia@mail.com',   0.15),
                                                                     ('ClienteVIP', 4, 'Diego Torres',   'diego@mail.com',   0.20);

-- ─── 12. PAGOS ───────────────────────────────────────────────
-- tipo: 0 = EFECTIVO, 1 = TARJETA (tinyint 0-1)
INSERT IGNORE INTO pago (id, monto, tipo) VALUES
                                              (1, 3000.00, 0),   -- efectivo
                                              (2, 5000.00, 1),   -- tarjeta
                                              (3, 2500.00, 1),   -- tarjeta VIP
                                              (4, 1500.00, 0);   -- efectivo

-- ─── 13. VENTAS ──────────────────────────────────────────────
-- venta_id → FK a cine(id)
INSERT IGNORE INTO venta (id, fecha, pago_id, venta_id) VALUES
                                                            (1, '2025-05-20', 1, 1),
                                                            (2, '2025-05-21', 2, 1),
                                                            (3, '2025-05-22', 3, 1),
                                                            (4, '2025-05-23', 4, 1);

-- ─── 14. VENTA ↔ CLIENTE ─────────────────────────────────────
INSERT IGNORE INTO venta_cliente (venta_id, cliente_id) VALUES
                                                            (1, 1),   -- María compró en venta 1
                                                            (2, 2),   -- Juan en venta 2
                                                            (3, 3),   -- Sofía VIP en venta 3
                                                            (4, 4);   -- Diego VIP en venta 4

-- ─── 15. VENTA ↔ FUNCIÓN ─────────────────────────────────────
INSERT IGNORE INTO venta_funcion (venta_id, funcion_id) VALUES
                                                            (1, 1),   -- venta 1 → Avengers tarde
                                                            (2, 2),   -- venta 2 → Avengers noche
                                                            (3, 4),   -- venta 3 → Inception VIP
                                                            (4, 3);   -- venta 4 → El Padrino

-- ─── 16. COMPRAS (del cine a proveedores) ────────────────────
INSERT IGNORE INTO compra (id, fecha, compra_id) VALUES
                                                     (1, '2025-05-01 10:00:00', 1),
                                                     (2, '2025-05-10 11:00:00', 1);

-- ─── 17. PROVEEDORES ─────────────────────────────────────────
INSERT IGNORE INTO proveedor (id, nombre, direccion, telefono, compra_id) VALUES
                                                                              (1, 'Snacks SA',      'Calle Falsa 123', '2994001122', 1),
                                                                              (2, 'Bebidas del Sur','Av. Roca 456',    '2994003344', 2);

-- ─── 18. INSUMOS ─────────────────────────────────────────────
INSERT IGNORE INTO insumo (id, nombre, precio, compra_id) VALUES
                                                              (1, 'Pochoclos grandes', 800.00,  1),
                                                              (2, 'Gaseosa 500ml',     500.00,  1),
                                                              (3, 'Agua mineral',      300.00,  2),
                                                              (4, 'Chocolate',         450.00,  2);