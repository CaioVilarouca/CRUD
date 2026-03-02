package model.application;

import java.sql.Connection;

import model.db.DataBase;

public class Program {
	public static void main (String[] args) {
		Connection connection = DataBase.getConnection();
		DataBase.closeConnection();
	}
}
