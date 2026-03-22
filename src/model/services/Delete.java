package model.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.db.DataBase;

public class Delete {
	private Scanner scanner = new Scanner(System.in);
	public void deleteDataBase() {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		
		try {
			connection = DataBase.getConnection();
			
			prepareStatement = connection.prepareStatement("DELETE FROM user WHERE id=?");
			
			System.out.print("Informe o ID a ser deletado: ");
			int id = scanner.nextInt();
			
			prepareStatement.setInt(1, id);
			int rowAffected = prepareStatement.executeUpdate();
			System.out.println("Linhas atualizadas: " + rowAffected);
			if (rowAffected == 0) 
				System.out.println("ID não cadastrado.");
			else 
				System.out.println("Dados atualizados com sucesso!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InputMismatchException e) {
			System.out.println("Erro na entrada do Id.");
		}  finally {
			DataBase.closeStatement(prepareStatement);
			DataBase.closeConnection(connection);
		}
	}
}
