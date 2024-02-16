package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connection.SingleConnectionBanco;
import model.ModelLogin;

public class DAOUsuarioRepository {

	private Connection connection;

	public DAOUsuarioRepository() {
		this.connection = SingleConnectionBanco.getConnection();
	}

	public void gravarUsuario(ModelLogin modelLogin) throws Exception {
		String sql = "INSERT INTO public.model_login(login, senha, nome, email) VALUES (?, ?, ?, ?)";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setString(1, modelLogin.getLogin());
		preparedStatement.setString(2, modelLogin.getSenha());
		preparedStatement.setString(3, modelLogin.getNome());
		preparedStatement.setString(4, modelLogin.getEmail());
		
		preparedStatement.execute();

		connection.commit();
	}

}
