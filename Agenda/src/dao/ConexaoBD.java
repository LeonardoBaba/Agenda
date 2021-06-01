package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
	public Connection getConnection() {
		try {
			//dados para fazer a conexão com o SQL server
			String con = "jdbc:sqlserver://localhost:1435;"	//Endereço do servidor e porta
					   + "databaseName=AgendaLeonardo;"		//Nome da base de dados
					   + "user=sa;"							//Nome do usuario
					   + "password=TESTE1234";				//Senha
			return DriverManager.getConnection(con);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
