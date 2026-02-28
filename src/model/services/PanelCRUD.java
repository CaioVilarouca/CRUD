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
		if (option > 4) {
			System.out.println("As opções são de (0 a 4).");
			return;
		}
	}
	
	// Painel
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
		}
	}
}
