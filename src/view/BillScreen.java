package view;

import processing.core.PApplet;

public class BillScreen extends ScreenFather{

	private int change=0;
	public BillScreen(float posY, PApplet app) {
		super(posY, app);
		screen = app.loadImage("../resources/Bill.png");
	}
	public void button() {
		System.out.println("presionado bill");
		if (app.mouseX > 647 && app.mouseX < 647 + 137
				&& app.mouseY > 40 && app.mouseY < 40 + 19) // 	InitialScreen Button 
			change = 0;
		
		if (app.mouseX > 825 && app.mouseX < 825 + 65
				&& app.mouseY > 40 && app.mouseY < 40 + 19) // 	Contacts Button
			change = 3;
		
		if (app.mouseX > 975 && app.mouseX < 975 + 45
				&& app.mouseY > 40 && app.mouseY < 40 + 19) // Login Button
			change = 1;
		
		if (app.mouseX > 1096 && app.mouseX < 1096 + 82
				&& app.mouseY > 40 && app.mouseY < 40 + 19) // Register
			change = 2;
		if (app.mouseX > 673 && app.mouseX < 673 + 101
				&& app.mouseY > 586 && app.mouseY < 586 + 28) // 	Cancel Button
			change = 0;
		if (app.mouseX > 797 && app.mouseX < 797 + 154
				&& app.mouseY > 586 && app.mouseY < 586 + 28) // 	total Button
			change = 7;
	}
	public int getChange() {
		return change;
	}
	public void setChange(int change) {
		this.change = change;
	}
	
}
