package model.services;

import java.util.Scanner;

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
				+ "| [0] Sair       |\n"
				+ "==================\n"
				+ "| Informe: ");
		
		try {
			String input = scanner.nextLine();
			option = Integer.parseInt(input);
			validationFromOption(option);
		}
		catch (NumberFormatException e) {
            System.out.println("Esse campo só aceita números.");
		}
	}
	
	// Regras de négocio 
	public void validationFromOption(int option) {
		if (option < 0) {
			System.out.println("Esse campo não aceita número negativo.");
			return;
		}
		if (option > 4) {
			System.out.println("As opções são de (0 a 4).");
			return;
		}
	}
	
	// Painel do CRUD e chamada de métodos
	public void panel() {
		switch (option) {
			case 1: {
				System.out.println("\nCREATE");
				break;
			}
			case 2: {
				System.out.println("\nREAD");
				break;
			}
			case 3: {
				System.out.println("\nUPDATE");
				break;
			}
			case 4: {
				System.out.println("\nDELETE");
				break;
			}
		}
	}
}
