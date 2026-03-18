package model.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import model.db.DataBase;
import model.entities.User;

public class Create {
    private Scanner scanner = new Scanner(System.in);

    public void createUser() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DataBase.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO user (name, email) VALUES (?, ?)");
            
            User user = collectUserInformation();

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());

            int rowAffected = preparedStatement.executeUpdate();
            System.out.println("Linha adicionada: " + rowAffected);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBase.closeStatement(preparedStatement);
            DataBase.closeConnection(connection);
        }
    }

    public User collectUserInformation() {
        System.out.println("Informe os dados a serem adicionados.");
        System.out.print("Informe o nome: ");
        String name = scanner.nextLine();

        System.out.print("Informe o email: ");
        String email = scanner.nextLine();
        return new User(name, email);
    }
}
