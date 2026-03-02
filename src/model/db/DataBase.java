package model.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DataBase {
	private static Connection connection = null;
	
	// Método para ler arquivo
	public static Properties loadProperties() {
		
		try (FileInputStream fileInputStream = new FileInputStream("dataBase.properties")) {
			
			Properties properties = new Properties();
			properties.load(fileInputStream);
			
			return properties;
		}
		catch (IOException e) {
			throw new DBException(e.getMessage());
		}
	}
	
	// Método para conectar no banco de dados
	public static Connection getConnection() {
		if (connection == null) {
			
			Properties properties = loadProperties();
			String url = properties.getProperty("url");
			
			try {
				connection = DriverManager.getConnection(url, properties);
			} 
			catch (SQLException e) {
				throw new DBException(e.getMessage());
			}
		}
		return connection;
	}
	
	// Método para fechar a conexão com banco de dados
	public static void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} 
			catch (SQLException e) {
				throw new DBException(e.getMessage());
			}
		}
	}
}