package main;

import entities.*;
import ui.Menu;


public class main {

	public static void main(String[] args) {
		new Menu().start();
		/*
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		recuperarTodos();
		*/
	}
	/*
	private static void recuperarTodos() {
		Connection conn = null;
		LinkedList<Product> products = new LinkedList<>();
		try {
			// crear una conexion
			conn =
				DriverManager.getConnection("jdbc:mysql://localhost:3306/javamarket","root","");
		} catch(e) {
			
		}
	}
	*/
}
