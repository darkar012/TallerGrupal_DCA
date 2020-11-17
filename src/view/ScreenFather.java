package view;

	import processing.core.PApplet;
	import processing.core.PImage;

	/**
	 * Clase padre de donde las pantallas heredan los atributos
	 * y m�todos de pintar
	 * @author Andr�s Burgos, Cristian Mendez, Ang�lica Cruz
	 */
	
	public class ScreenFather extends PApplet {

		protected float posY;
		protected PImage screen;
		protected PApplet app;
		
		public ScreenFather (float posY, PApplet app) {
			this.posY=posY;
			this.screen=screen;
			this.app=app;
		}
		
		protected void drawImage() {
			app.image(screen, 0, posY);
		}
			
		
}
