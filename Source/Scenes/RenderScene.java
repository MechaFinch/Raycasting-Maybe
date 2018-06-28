package Scenes;

import java.awt.Color;
import java.awt.Font;

import MainClasses.*;

public class RenderScene extends Scene {
	
	protected void use() {
		//Clear
		g.setColor(Color.white);
		g.fillRect(0, 0, Main.width, Main.height);
		
		if(!Main.mapLoaded) {
			g.setColor(Color.black);
			g.setFont(new Font("Calibri", Font.PLAIN, 48));
			g.drawString("No map loaded to render.", 10, 58);
		} else {
			
		}
		
		//Esc to return to menu
		if(Main.keyPressed[27]) {
			Main.scene = "MainMenu";
		}
	}
}
