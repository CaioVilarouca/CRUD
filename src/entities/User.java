package entities;

public class User { 
	// Dados para conexão com o banco de dados
	private  String user = null;
	private  String password = null;
	private  String nameDataBase = null;
	
	// Hard code
	private  String url = "jdbc:mysql://localhost:3306/";

	public User(String user, String password, String nameDataBase) {
		this.user = user;
		this.password = password;
		this.nameDataBase = nameDataBase;
		url += getNameDataBase();
	}
	
	public String getNameDataBase() {
		return nameDataBase;
	}
}
