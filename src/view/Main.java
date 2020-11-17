package view;


import processing.core.PApplet;
import processing.event.MouseEvent;

/**
 * Esta clase contiene todos los métodos de las
 * pantallas y conexiones de la clase de logic
 * @author Andrés Burgos, Cristian Mendez, Angélica Cruz
 */

public class Main extends PApplet {
	
	 
	/**
	 * Constructor de la clase
	 * @param args
	 */
	public static void main(String[] args) {
		
		PApplet.main(Main.class.getName());
	} 
	
	InitialScreen initialscreen;
	LoginScreen loginscreen;
	RegisterScreen registerscreen;
	ContactScreen contactscreen;
	BillScreen billscreen;
	BuyScreen buyscreen;
	NewContactScreen newcontactscreen;
	TotalScreen totalscreen;
	ShoppingScreen shoppingscreen;
	
	public boolean error = false;
	public int loginYes=0;
	public int loginMay=0;
	public int schange=0;
	public int ticketOne=0;
	public int ticket1=0;
	public int ticketTwo=0;
	public int ticket2=0;
	public int ticketThree=0;
	public int ticket3=0;

	
	
	public void settings() {
		size(1440, 810);
	}
	

	public void setup() {
		
		initialscreen= new InitialScreen(0,this);
		loginscreen= new LoginScreen(0,this);
		registerscreen= new RegisterScreen(0,this);
		contactscreen= new ContactScreen(0,this);
		billscreen= new BillScreen(0,this);
		buyscreen= new BuyScreen(0,this);
		newcontactscreen= new NewContactScreen(0,this);
		totalscreen= new TotalScreen(0,this);
		shoppingscreen= new ShoppingScreen(0,this);
		
	}
	
	public void draw() {
		background(0);
		loginYes=loginMay;
		//System.out.println(loginYes);
		ticketOne=ticket1;
		ticketTwo=ticket2;
		ticketThree = ticket3;
		switch (schange) {
		case 0:
			ticket1 = initialscreen.getTicketOne();
			ticket2 = initialscreen.getTicketTwo();
			ticket3 = initialscreen.getTicketThree();
			initialscreen.drawImage();
			initialscreen.paintTicketNumber();
			break;
			
		case 1:
			loginscreen.drawImage();
			loginscreen.mostrarP5();
			error=loginscreen.isError();
			if (error==true) {
				loginscreen.errorMessage();
			}
			loginMay=loginscreen.isLoginYes();
			break;
			
		case 2:
			registerscreen.drawImage();
			registerscreen.mostrarP5();
			break;
			
		case 3:
			contactscreen.drawImage();
			
			for (int i = 0; i < contactscreen.contactList().size(); i++) {

				textSize(13);
				fill(0);
				contactscreen.contactList().get(i).drawData(660, 410+(20*i), this);
			}
			break;
			
		case 4:
			billscreen.drawImage();
			break;
			
		case 5:
			if (loginYes == 1) {
				buyscreen.drawImage();
				buyscreen.mostrarP5();
				error=buyscreen.isError();
				if (error==true) {
					buyscreen.errorMessage();
				}
			}
			else {
				schange=1;
			}
			
			break;
			
		case 6: 
			newcontactscreen.drawImage();
			newcontactscreen.mostrarP5();
			
			break;
			
		case 7:
			totalscreen.drawImage();
			break;
			
		case 8:
			if (ticketOne > 0) {
				shoppingscreen.settOne(true);
			}
			if (ticketTwo > 0) {
				shoppingscreen.settTwo(true);
			}
			if (ticketThree > 0) {
				shoppingscreen.settThree(true);
			}
			shoppingscreen.checkTicket();
			shoppingscreen.drawImage();
			break;
			
		default:
			
			break;
		}
	}
	
	public void keyPressed() {
		
	}
	
	public void mouseClicked() {

		
		System.out.println("X= "+ mouseX);
		System.out.println("Y= "+ mouseY);
		//System.out.println("Schange is " + schange);
		
		switch (schange) {
		case 0:
			initialscreen.packageOne();
			initialscreen.packageTwo();
			initialscreen.packageThree();
			initialscreen.button();
			schange=initialscreen.getChange();
			break;
			
		case 1:
			loginscreen.button();
			schange=loginscreen.getChange();
			System.out.println(schange);
			break;
			
		case 2:
			registerscreen.button();
			schange=registerscreen.getChange();
			
			registerscreen.getUserInfo();
			break;		
			
		case 3:
			contactscreen.button();
			schange=contactscreen.getChange();
			contactscreen.sortList();
			break;
			
		case 4:
			billscreen.button();
			schange=billscreen.getChange();
			break;
			
		case 5:
        
			buyscreen.button();
			schange=buyscreen.getChange();
        //buyscreen.getCardInfo();

			break;
		case 6: 
			newcontactscreen.button();
			schange=newcontactscreen.getChange();
			newcontactscreen.getContactInfo();
			break;
			
		case 7:
			totalscreen.button();
			schange=totalscreen.getChange();
			break;
			
		case 8: 
			shoppingscreen.button();
			schange=shoppingscreen.getChange();
			break;
			
		default:
			
			break;
		}
	}
	
	public void mouseWheel(MouseEvent event) {
		if (event.getCount() == 1.0) {
			initialscreen.scrollingPlus();
		}
		if (event.getCount() == -1.0) {
			initialscreen.scrollingMinus();
		}
	}
}
