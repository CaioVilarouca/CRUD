package model.services;

import java.util.Scanner;

import entities.User;

public class PanelCRUD {
	private int option;
	private Scanner scanner = new Scanner(System.in);
	
	public void systemPanel() {
		while (true) {
			panelFromOption();
			if (option == 0) {
				System.out.println("CRUD encerrado com sucesso!");
	            break;
	        }		
			panel();
		}
	}
	
	public void panelFromOption(){
		System.out.print("==================\n"
				+ "| [1] Criar      |\n"
				+ "| [2] Ler        |\n"
				+ "| [3] Atualizar  |\n"
				+ "| [4] Deletar    |\n"
				+ "| [5] Conectar   |\n"
				+ "| [0] Sair       |\n"
				+ "==================\n"
				+ "| Informe: ");
		try {
			String input = scanner.nextLine();
			option = Integer.parseInt(input);
			validationOption(option);
		}
		catch (NumberFormatException e) {
            System.out.println("Esse campo só aceita números.");
		}
	}
	
	// Regras de négocio 
	public void validationOption(int option) {
		if (option < 0) {
			System.out.println("Esse campo não aceita número negativo.");
			return;
		}
		if (option > 5) {
			System.out.println("As opções são de (0 a 4).");
			return;
		}
	}
	
	// Simulador de limpar a tela 
	public void clearTerminal() {
		for (int i = 0; i < 100; i++) {
		    System.out.println();
		}
	}
	
	// Painel do CRUD e chamada de métodos
	public void panel() {
		switch (option) {
			case 1: {
				System.out.println("CREATE");
				break;
			}
			case 2: {
				System.out.println("READ");
				break;
			}
			case 3: {
				System.out.println("UPDATE");
				break;
			}
			case 4: {
				System.out.println("DELETE");
				break;
			}
			case 5: {
				userData();
				break;
			}
		}
	}
	
	// Dados para conectar no banco de dados
	public void userData() {
		System.out.println("\nConectar no banco de dados.");
		System.out.print("\nUsuário:");
		String admin = scanner.nextLine();
		System.out.print("Senha:");
		String password = scanner.nextLine();
		System.out.print("Nome do banco dados:");
		String nameDatabase = scanner.nextLine();
		
		User user = new User(admin, password, nameDatabase);
	}
}
