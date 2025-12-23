#Se crea la tabla credencial_usuario
CREATE TABLE credencial_usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    eliminado BOOLEAN NOT NULL DEFAULT FALSE,
    hash_password VARCHAR(255) NOT NULL,
    salt VARCHAR(255) NOT NULL,
    ultimo_cambio DATETIME NOT NULL,
    require_reset BOOLEAN NOT NULL DEFAULT FALSE
);
#Se crea la tabla usuario
CREATE TABLE usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    eliminado BOOLEAN NOT NULL DEFAULT FALSE,
    username VARCHAR(100) NOT NULL UNIQUE,
    email VARCHAR(150) NOT NULL UNIQUE,
    activo BOOLEAN NOT NULL DEFAULT TRUE,
    fecha_registro DATETIME NOT NULL,
    credencial_id BIGINT NOT NULL,
    CONSTRAINT fk_usuario_credencial
        FOREIGN KEY (credencial_id)
        REFERENCES credencial_usuario(id)
);
credencial_usuario