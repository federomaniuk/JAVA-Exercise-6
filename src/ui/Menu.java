package ui;

import java.util.Scanner;

import data.DbHandler;
import entities.Product;

public class Menu {
	Scanner scan;
	DbHandler db = new DbHandler();
	public void start() {
		
		scan = new Scanner(System.in);
		// muestran las opciones y según que elija el usuario
		String rta="";
		
		do {
			rta=menu();
			
			switch(rta) {
			
			case "list":
				list();
				break;
			
			case "search":
				// search()
				break;
	
			case "new":
				// new()
				break;
	
			case "delete":
				// delete()
				break;
				
			case "update":
				// update()
				break;
				
			case "exit":
				System.out.println("Adios");
				break;

			default:
				System.out.println("Command not found... try again");
				break;
			}
		} while (!rta.equals("exit"));
		
		scan.close();
	}

	private void list() {
		// TODO Auto-generated method stub
		// for(Product p: db.list()) {
		// 	System.out.println(p);
		// }
		System.out.println(db.list());
	}

	private String menu() {
		System.out.println("Ingrese el cmd a ejecutar: list/search/new/delete/update");
		
		return scan.nextLine();
	}
}
