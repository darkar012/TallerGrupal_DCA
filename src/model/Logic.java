package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import processing.core.PApplet;

/**
 * Clase que maneja la l�gica del programa
 * @author Andr�s Burgos, Cristian Mendez, Ang�lica Cruz
 *
 */

public class Logic extends PApplet {

	private LinkedList<Contact> contactList;
	private ArrayList<User> userList;
	private ArrayList<Package> packageList;
	private ArrayList<Package> buyList;

	private static PApplet app;

	private static Logic unicaInstance;

	private Logic(PApplet app) {

		Logic.app = app;
		userList = new ArrayList<User>();
		contactList = new LinkedList<Contact>();
		packageList = new ArrayList<Package>();

		User cristian= new User("Cristian", "Mendez", "crisdamencast@gmail.com", "12345", "Colombiano", "1234567", app);
		userList.add(cristian);

		Contact elon= new Contact("Elon", "Musk", "espeiseks@egomusk.com", "49", "Sudafricano", "00000", app);
		Contact amber= new Contact("Amber", "Heard", "johnnydepp@gmail.com", "34", "Estadounidense", "11111", app);
		Contact cara= new Contact("Cara", "Delevigne", "trioespacial@gmail.com", "28", "Inglesa", "22222", app);
		
		contactList.add(elon);
		contactList.add(amber);
		contactList.add(cara);
		
		Package packageOne = new Package("Moon", "Three days outbound and three days back", "Seven days", 850000);
		Package packageTwo = new Package("Mars", "Six months out and six months back", "One year", 8000000);
		Package packageThree = new Package("Intercontinental", "Trips using missile lauch technology", "Three hours", 2500);

		packageList.add(packageOne);
		packageList.add(packageTwo);
		packageList.add(packageThree);
	}

	public static Logic getInstance() {
		if(unicaInstance == null) {
			unicaInstance = new Logic(app);
		}
		return unicaInstance;
	}


	public void sortName() {

		Collections.sort(contactList);
	}

	public void sortLastName() {

		Collections.sort(contactList, Contact.Comparators.LASTNAME);
	}

	public void sortMail() {

		Collections.sort(contactList, Contact.Comparators.MAIL);
	}
	public void sortAge() {

		Collections.sort(contactList, Contact.Comparators.AGE);
	}

	public void sortNationality() {

		Collections.sort(contactList, Contact.Comparators.NATIONALITY);
	}

	public void sortCellNumber() {

		Collections.sort(contactList, Contact.Comparators.CELLNUMBER);
	}

	/**M�todo que registra usuario
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 * @param nationality
	 * @param cellphoneNumber
	 */
	public void newUserForm(String firstName, String lastName, String email, String password, String nationality,
			String cellphoneNumber) {
		User newUser = new User(firstName, lastName, email, password, nationality, cellphoneNumber, app);
		userList.add(newUser);

		for(int i = 0; i<userList.size();i++) {

			System.out.println(">>>>>>>>><<<<<<<<<<");
			System.out.println(userList.get(i).getName());
			System.out.println(userList.get(i).getLastName());
			System.out.println(userList.get(i).getPassword());
			System.out.println(userList.get(i).getMail());
			System.out.println(userList.get(i).getNationality());
			System.out.println(userList.get(i).getCellNumber());
			System.out.println(">>>>>>>>><<<<<<<<<<");
		}
	}


	/** M�todo que registra un contacto
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param age
	 * @param nationality
	 * @param cellphoneNumber
	 */
	public void newContactForm(String firstName, String lastName, String email, String age, String nationality,
			String cellphoneNumber) {

		Contact newContact = new Contact(firstName, lastName, email, age, nationality, cellphoneNumber, app);
		contactList.add(newContact);

		for(int i = 0; i<contactList.size();i++) {

			System.out.println(">>>>>>>>><<<<<<<<<<");
			System.out.println(contactList.get(i).getName());
			System.out.println(contactList.get(i).getLastName());
			System.out.println(contactList.get(i).getMail());
			System.out.println(contactList.get(i).getAge());
			System.out.println(contactList.get(i).getNationality());
			System.out.println(contactList.get(i).getCellNumber());
			System.out.println(">>>>>>>>><<<<<<<<<<");
		}
	}

	
	public LinkedList<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(LinkedList<Contact> contactList) {
		this.contactList = contactList;
	}

	public ArrayList<User> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}

	public ArrayList<Package> getPackageList() {
		return packageList;
	}

	public void setPackageList(ArrayList<Package> packageList) {
		this.packageList = packageList;
	}

	public ArrayList<Package> getBuyList() {
		return buyList;
	}

	public void setBuyList(ArrayList<Package> buyList) {
		this.buyList = buyList;
	}




}
