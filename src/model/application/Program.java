package model.application;

import model.services.PanelCRUD;

public class Program {
	public static void main (String[] args) {
		PanelCRUD panelCRUD = new PanelCRUD();
		panelCRUD.systemPanel();
	}
}
