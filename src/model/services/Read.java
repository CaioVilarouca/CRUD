package model.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.db.DataBase;

public class Read { // Ler
	public void readDataBase() {
		Connection connection = null;
		Statement statement = null; // Statemnt == Declaração
		ResultSet resultSet = null; // Obj ResultSet contém os dados armazenado na forma de tabela
		
		try {
			connection = DataBase.getConnection();
			statement  = connection.createStatement();
			resultSet = statement.executeQuery("select * from user"); // Declare e execulte uma pesquisa na tabela "user"
			
			System.out.println("\nREAD | Dados armazenados no banco de dados.\n");
			while(resultSet.next()) {
				System.out.println(resultSet.getInt("id")+" ,"+
						resultSet.getString("name")+", ["+
						resultSet.getString("email")+"]");
			}
			System.out.println("\nDados recuperados com sucesso!");
		}catch (SQLException e) {
			e.printStackTrace();
		} finally { // Como os recursos Statement e ResultSet são externos, é uma boa prática fechá-los manualmente
			DataBase.closeResultSet(resultSet);
			DataBase.closeStatement(statement);
			DataBase.closeConnection();
		}
	}
}
