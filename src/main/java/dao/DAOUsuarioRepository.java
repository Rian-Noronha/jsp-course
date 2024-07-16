package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnectionBanco;
import model.ModelLogin;

public class DAOUsuarioRepository {

	private Connection connection;

	public DAOUsuarioRepository() {
		this.connection = SingleConnectionBanco.getConnection();
	}

	public ModelLogin gravarUsuario(ModelLogin modelLogin) throws Exception {
		
		String sql = "";
		PreparedStatement preparedStatement = null;
		if(modelLogin.ehNovoLogin()) {
			sql = "INSERT INTO public.model_login(login, senha, nome, email) VALUES (?, ?, ?, ?)";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, modelLogin.getLogin());
			preparedStatement.setString(2, modelLogin.getSenha());
			preparedStatement.setString(3, modelLogin.getNome());
			preparedStatement.setString(4, modelLogin.getEmail());
			
			preparedStatement.execute();

			connection.commit();
		}else {
			sql = "UPDATE public.model_login SET login=?, senha=?, nome=?, email=? WHERE id = "+modelLogin.getId()+";";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, modelLogin.getLogin());
			preparedStatement.setString(2,  modelLogin.getSenha());
			preparedStatement.setString(3, modelLogin.getNome());
			preparedStatement.setString(4, modelLogin.getEmail());
		
			preparedStatement.executeUpdate();
			
			connection.commit();
		}
		
		return this.consultarUsuario(modelLogin.getLogin());
	}
	
	
	public List<ModelLogin> consultarUsuarios(String nomeBusca) throws Exception{
		List<ModelLogin> usuariosConsultados = new ArrayList<ModelLogin>();
		String sql = "SELECT * FROM model_login WHERE UPPER(nome) LIKE UPPER(?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, "%" + nomeBusca + "%");
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			ModelLogin modelLogin = new ModelLogin();
			modelLogin.setId(resultSet.getLong("id"));
			modelLogin.setEmail(resultSet.getString("email"));
			modelLogin.setLogin(resultSet.getString("login"));
			modelLogin.setNome(resultSet.getString("nome"));
			usuariosConsultados.add(modelLogin);
		}
		
		
		return usuariosConsultados;
	}
	
	
	public ModelLogin consultarUsuario(String login) throws Exception {
		ModelLogin modelLogin = new ModelLogin();
		String sql = "SELECT * FROM model_login WHERE UPPER(login) = UPPER('"+login+"')";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			modelLogin.setId(resultSet.getLong("id"));
			modelLogin.setEmail(resultSet.getString("email"));
			modelLogin.setLogin(resultSet.getString("login"));
			modelLogin.setSenha(resultSet.getString("senha"));
			modelLogin.setNome(resultSet.getString("nome"));
		}
		
		
		return modelLogin;
		
	}
	
	
	public boolean validarLogin(String login) throws Exception {
		String sql = "SELECT COUNT(1) > 0 AS existe FROM model_login WHERE UPPER(login) = UPPER('"+login+"');";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		resultSet.next();
		return resultSet.getBoolean("existe");
		
	}
	
	
	public void deletarUsuario(String id) throws Exception{
		String sql = "DELETE FROM public.model_login WHERE id = ?;";
		
		PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
		
		preparedStatement.setLong(1, Long.parseLong(id));
		preparedStatement.executeUpdate();
		
		connection.commit();
		
	}
	

}
