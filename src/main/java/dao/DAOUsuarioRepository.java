package dao;

import java.sql.Connection;

import connection.SingleConnectionBanco;

public class DAOUsuarioRepository {
	
	private Connection connection;
	
	public DAOUsuarioRepository() {
		this.connection = SingleConnectionBanco.getConnection();
	}
	
	
	
	
	

}
