package model.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.db.DataBase;
import model.entities.User;

public class Update {
	private Scanner scanner = new Scanner(System.in);
	public void updateDataBase() {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		
		try {
			connection = DataBase.getConnection();
			
			prepareStatement = connection.prepareStatement("UPDATE user SET name=?, email=? WHERE id=?");
			
			User user = updateUser();
			
			prepareStatement.setString(1, user.getName()); 
			prepareStatement.setString(2, user.getEmail()); 
			prepareStatement.setInt(3, user.getId()); // id
			
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
		} finally {
			DataBase.closeStatement(prepareStatement);
			DataBase.closeConnection(connection);
		}
	}
	
	public User updateUser() {
		System.out.println("Informe os dados a ser atualizado: ");
		System.out.print("Informe o nome: ");
        String name = scanner.nextLine();

        System.out.print("Informe o email: ");
        String email = scanner.nextLine();
        
        System.out.print("Informe o ID: ");
        int id = scanner.nextInt();
        
       
        return new User(name, email, id);
	}
}