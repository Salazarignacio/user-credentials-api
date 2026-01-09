#Creacion de tabla Producto
CREATE TABLE Producto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    articulo VARCHAR(100) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    precio DECIMAL(10,2) NOT NULL CHECK (precio >= 0),
    stock INT NOT NULL CHECK (stock >= 0),
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
