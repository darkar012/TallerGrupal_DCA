package model;

import processing.core.PApplet;

/**
 * Clase que guarda la informaci�n del usuario al registrarse
 * @author Andr�s Burgos, Cristian Mendez, Ang�lica Cruz
 *
 */

public class User extends Person{

	private String password;

	public User(String name, String lastName, String mail, String password, String nationality, String cellNumber, PApplet app) {
		super(name, lastName, mail, nationality, cellNumber, app);
		this.app=app;
		this.password=password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
