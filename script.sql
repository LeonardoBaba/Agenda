CREATE DATABASE AgendaLeonardo;
GO

USE AgendaLeonardo;
GO

CREATE TABLE agenda (
	agendaPK INT not null PRIMARY KEY IDENTITY(1,1),
	txnome VARCHAR(50),
	txtelefone VARCHAR(11),
	txendereco VARCHAR(100)
)