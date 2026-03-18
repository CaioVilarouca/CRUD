package model.services;

import java.util.Scanner;

public class PanelCRUD {
	private int optionPanel;
	private Scanner scanner = new Scanner(System.in);
	public void systemPanel() {
		while (true) {
			panelOfOption();
			if (optionPanel == 0) { // 	Regra de saída do loop 
				System.out.println("CRUD encerrado com sucesso!");
	            break;
	        }		
			panel();
		}
	}
	public void panelOfOption(){
		System.out.print("==================\n"
				+ "| [1] Criar      |\n"
				+ "| [2] Ler        |\n"
				+ "| [3] Atualizar  |\n"
				+ "| [4] Deletar    |\n"
				+ "| [0] Sair       |\n"
				+ "==================\n"
				+ "| Informe: ");
		
		try {
			String inputInformation = scanner.nextLine();
			optionPanel = Integer.parseInt(inputInformation);
			validationFromOption(optionPanel);
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
		switch (optionPanel) {
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
