USE Tetris;

CREATE TABLE Usuario(
	NombreUsuario VARCHAR(30),
	Contrasena VARCHAR(50),
	NomAdmin VARCHAR(30),
	ColorFondo VARCHAR(20),
	ColorLadrillo VARCHAR(20),
	Volumen INT, 
	SonidoAcciones VARCHAR(20),

	PRIMARY KEY(NombreUsuario),
	FOREIGN KEY (Admin) REFERENCES Usuario(NombreUsuario)
);

CREATE TABLE Premio(
	CodPremio VARCHAR(30),
	NombrePremio VARCHAR(30),
	Descripcion VARCHAR(100),
	FechaCreacion DATE,
	Icono VARCHAR(200),

	PRIMARY KEY (CodPremio)
);

CREATE TABLE Partida(
	CodPartida VARCHAR(30),
	Nivel INT,

	PRIMARY KEY (CodPartida)
);

CREATE TABLE Ranking(
	CodRanking VARCHAR(30),
	Tipo VARCHAR(30),
	Puntuacion INT,

	PRIMARY KEY (CodRanking)
);

CREATE TABLE UsuPremio(
	NombreUsuario VARCHAR(30),
	CodPremio VARCHAR(30),
	CodPartida VARCHAR(30),

	PRIMARY KEY (NombreUsuario, CodPremio, CodPartida),
	FOREIGN KEY (NombreUsuario) REFERENCES Usuario(NombreUsuario),
	FOREIGN KEY (CodPremio) REFERENCES Premio(CodPremio),
	FOREIGN KEY (CodPartida) REFERENCES Partida(CodPartida)
);

CREATE TABLE UsuRankPartida(
	NombreUsuario VARCHAR(30),
	CodRanking VARCHAR(30),
	CodPartida VARCHAR(30),
	Fecha DATE,

	PRIMARY KEY (NombreUsuario, CodRanking, CodPartida),
	FOREIGN KEY (NombreUsuario) REFERENCES Usuario(NombreUsuario),
	FOREIGN KEY (CodRanking) REFERENCES Ranking(CodRanking),
	FOREIGN KEY (CodPartida) REFERENCES Partida(CodPartida)
);

CREATE TABLE UsuPartida(
	NombreUsuario VARCHAR(30),
	CodPartida VARCHAR(30),
	Puntuacion INT,
	Fecha DATE,

	PRIMARY KEY (NombreUsuario, CodPartida),
	FOREIGN KEY (NombreUsuario) REFERENCES Usuario(NombreUsuario),
	FOREIGN KEY (CodPartida) REFERENCES Partida(CodPartida),
	FOREIGN KEY (Puntuacion) REFERENCES Ranking(Puntuacion),
	FOREIGN KEY (Fecha) REFERENCES UsuRankPartida(Fecha)
);
