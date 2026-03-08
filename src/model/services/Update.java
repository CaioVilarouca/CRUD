package model.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import model.db.DataBase;

public class Update {
	@SuppressWarnings("resource")
	public void insertUser() {
		Scanner scanner = new Scanner(System.in);
		try {
			Connection connection = null;
			PreparedStatement preparedStatement;
			connection = DataBase.getConnection();
			preparedStatement = connection.prepareStatement(
					"INSERT INTO user "
					+"(name, email) "
					+"VALUES "
					+"(?, ?)");
			
			System.out.println("Atualizando cadastro.\nInforme:");
			System.out.print("Nome: ");
			String name = scanner.nextLine();
			
			System.out.print("Email: ");
			String email = scanner.nextLine();
			
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email);
			preparedStatement.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DataBase.closeConnection();
		}
	}
}
