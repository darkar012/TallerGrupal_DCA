package view;

import processing.core.PApplet;

public class BuyScreen extends ScreenFather{

	public BuyScreen(float posY, PApplet app) {
		super(posY, app);
		screen = app.loadImage("../resources/payment.png");	
		
	}

}
