CREATE TABLE USUARIO(
    nombreUsuario VARCHAR(20) NOT NULL,
    contrasena VARCHAR(20) NOT NULL,
    email VARCHAR(50) NOT NULL,
    PRIMARY KEY(nombreUsuario)
);

CREATE TABLE DIFICULTAD(
    nivelDificultad INT NOT NULL,
    velocidadLadrillos DOUBLE PRECISION NOT NULL, --Ejemplo: 23.47
    tamanoTablero VARCHAR(5) NOT NULL, --Ejemplo: 05x20
    PRIMARY KEY(nivelDificultad)
);

CREATE TABLE PARTIDA(
    id INT NOT NULL,
    puntos INT NOT NULL,
    estadoTablero VARCHAR(8000) NOT NULL,
    nombreUsuario VARCHAR(20) NOT NULL,
    dificultad INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(nombreUsuario)
    REFERENCES USUARIO(nombreUsuario),
    FOREIGN KEY(dificultad)
    REFERENCES DIFICULTAD(nivelDificultad)
);

CREATE TABLE PREMIO(
    nombre VARCHAR(20) NOT NULL,
    descripcion VARCHAR(200) NOT NULL,
    progresoMax INT NOT NULL,
    PRIMARY KEY(nombre)
);


CREATE TABLE PREMIOOBTENIDO(
    nombrePremio VARCHAR(20) NOT NULL,
    nombreUsuario VARCHAR(20) NOT NULL,
    progreso INT NOT NULL,
    PRIMARY KEY(nombrePremio,nombreUsuario),
    FOREIGN KEY(nombrePremio)
    REFERENCES PREMIO(nombre),
    FOREIGN KEY(nombreUsuario)
    REFERENCES USUARIO(nombreUsuario)
);

CREATE TABLE RANKING(
    nombreUsuario VARCHAR(20) NOT NULL,
    nivelDificultad INT NOT NULL,
    fechaHora DATETIME NOT NULL,
    puntos INT NOT NULL,
    PRIMARY KEY(nombreUsuario,nivelDificultad,fechaHora),
    FOREIGN KEY(nombreUsuario)
    REFERENCES USUARIO(nombreUsuario),
    FOREIGN KEY(nivelDificultad)
    REFERENCES DIFICULTAD(nivelDificultad)
);

CREATE TABLE PREMIOSENPARTIDA(
    idPartida INT NOT NULL, 
    nombrePremio VARCHAR(20) NOT NULL,
    progreso INT NOT NULL,
    PRIMARY KEY(idPartida,nombrePremio),
    FOREIGN KEY(idPartida)
    REFERENCES PARTIDA(id),
    FOREIGN KEY(nombrePremio)
    REFERENCES PREMIO(nombre)
);

CREATE TABLE COLORFONDO(
    codColorFondo INT NOT NULL,
    nombreColor VARCHAR(20) NOT NULL,
    PRIMARY KEY(codColorFondo)
);

CREATE TABLE COLORLADRILLO(
    codColorLadrillo INT NOT NULL,
    nombreColor VARCHAR(20) NOT NULL,
    PRIMARY KEY(codColorLadrillo)
);

CREATE TABLE MUSICA(
    codNombreMusica INT NOT NULL,
    nombreMusica VARCHAR(20) NOT NULL,
    PRIMARY KEY(codNombreMusica)
);

INSERT INTO USUARIO VALUES('tetrixadmin', 'tetrixsa22', 'adsitetrix@gmail.com');

--INSERT INTO DIFICULTAD VALUES("",,);
--INSERT INTO PREMIO VALUES(...);
INSERT INTO PREMIO(nombre, descripcion, progresoMax) VALUES ('Colocador de Fichas', '<html>Coloca 1000 fichas<br>para obtener este premio!</html>', 1000);
INSERT INTO PREMIO(nombre, descripcion, progresoMax) VALUES ('Eliminador de Filas', '<html>Elimina 50 filas<br>para obtener este premio!</html>', 50);
INSERT INTO PREMIO(nombre, descripcion, progresoMax) VALUES ('Maestro del TETRIS', '<html>Serás nombrado<br>"Maestro del TETRIS"<br>tras realizar 15 tetris.<br>Un tetris se consigue al eliminar<br>4 filas con una sola ficha</html>', 15);

INSERT INTO PREMIO(nombre, descripcion, progresoMax) VALUES ('Aprendiz', '<html>Consigue más de<br>5000 puntos en una partida<br>de dificultad fácil<br>para ser aprendiz</html>', 1);
INSERT INTO PREMIO(nombre, descripcion, progresoMax) VALUES ('Veterano', '<html>Consigue más de<br>10000 puntos en una partida<br>de dificultad media<br>para ser veterano</html>', 1);
INSERT INTO PREMIO(nombre, descripcion, progresoMax) VALUES ('Maestro', '<html>Consigue más de<br>30000 puntos en una partida<br>de dificultad difícil<br>para ser maestro</html>', 1);

INSERT INTO PREMIO(nombre, descripcion, progresoMax) VALUES ('Puntuador Extremo', '<html>Para completar este logro<br>debes obtener 1 millón de puntos.', 1000000);

--Añadir en el diagrama ER la dificultad de partida
INSERT INTO DIFICULTAD(nivelDificultad, velocidadLadrillos, tamanoTablero) VALUES (0, 400, '15x27');
INSERT INTO DIFICULTAD(nivelDificultad, velocidadLadrillos, tamanoTablero) VALUES (1, 300, '15x22');
INSERT INTO DIFICULTAD(nivelDificultad, velocidadLadrillos, tamanoTablero) VALUES (2, 150, '10x22');
