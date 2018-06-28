package Scenes;

import java.awt.Graphics2D;
import MainClasses.*;

//Class for scenes or windows or whatever
//Really a wrapper for windows
public abstract class Scene {
	Graphics2D g;
	boolean graphics = false;
	
	//Gives the scene the graphics to use
	public void getGraphics(Graphics2D ng) {
		g = ng;
		graphics = true;
	}
	
	//Method for running
	public void start() {
		if(!graphics) throw new IllegalStateException("No graphics provided for scene");
		
		use();
		
		if(Main.newMousePress && Main.mousePressed) {
			Main.newMousePress = false;
		} else if(!Main.newMousePress && !Main.mousePressed){
			Main.newMousePress = true;
		}
	}
	
	protected abstract void use();
}
