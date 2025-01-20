 -- Creación de la base de datos

DROP DATABASE IF EXISTS TiendaDigital;	
CREATE DATABASE IF NOT EXISTS TiendaDigital;
USE TiendaDigital;

-- Tabla Usuarios
CREATE TABLE Usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    rol ENUM('cliente', 'admin') DEFAULT 'cliente',
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabla Categorias
CREATE TABLE Categorias (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL UNIQUE,
    descripcion TEXT
);

-- Tabla Productos
CREATE TABLE Productos (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(10, 2) NOT NULL,
    stock INT DEFAULT 0,
    id_categoria INT,
    FOREIGN KEY (id_categoria) REFERENCES Categorias(id_categoria) ON DELETE SET NULL
);

-- Tabla Pedidos
CREATE TABLE Pedidos (
    id_pedido INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(10, 2) DEFAULT 0,
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario) ON DELETE CASCADE
);

-- Tabla DetallePedido
CREATE TABLE DetallePedido (
    id_pedido INT NOT NULL,
    id_producto INT NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (id_pedido) REFERENCES Pedidos(id_pedido) ON DELETE CASCADE,
    FOREIGN KEY (id_producto) REFERENCES Productos(id_producto) ON DELETE CASCADE,
    PRIMARY KEY (id_pedido, id_producto)
);

-- Insertar categorías de ejemplo
INSERT INTO Categorias (nombre, descripcion) VALUES
('Álbumes', 'Álbumes de música de diversos géneros'),
('Instrumentos', 'Instrumentos musicales para artistas y principiantes'),
('Accesorios', 'Accesorios musicales como cuerdas, púas y más');

-- Insertar productos de ejemplo
INSERT INTO Productos (nombre, descripcion, precio, stock, id_categoria) VALUES
('Guitarra Acústica', 'Guitarra acústica para principiantes y expertos', 199.99, 10, 2),
('Álbum Rock Clásico', 'Álbum de grandes éxitos del rock clásico', 14.99, 50, 1),
('Juego de Cuerdas para Guitarra', 'Juego completo de cuerdas de guitarra', 9.99, 100, 3),
('Teclado Electrónico', 'Teclado electrónico con 61 teclas y funciones avanzadas', 299.99, 5, 2),
('Auriculares de Estudio', 'Auriculares de alta calidad para grabaciones de estudio', 79.99, 20, 3),
('Álbum Pop Actual', 'Álbum con los mejores éxitos de música pop actual', 12.99, 30, 1);