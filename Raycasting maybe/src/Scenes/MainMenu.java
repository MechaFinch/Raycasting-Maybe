package Scenes;

import java.awt.Color;
import java.awt.Font;
import MainClasses.*;


//Main menu window
public class MainMenu extends Scene {
	protected void use() {
		//Clear
		g.setColor(Color.white);
		g.fillRect(0, 0, Main.width, Main.height);
		
		//Menu text
		g.setFont(new Font("Calibri", Font.PLAIN, 48));
		g.setColor(Color.black);
		g.drawString("Raycasting Renderer", 10, 58);
		
		g.setFont(new Font("Calibri", Font.PLAIN, 36));
		g.drawString("Render", 10, 100);
		g.drawString("Load Map", 10, 130);
		g.drawString("Press escape to return to this menu", 10, Main.height - 50);
		
		if(Main.mousePressed && Main.newMousePress) {
			//Mouse is on the menu options
			if(Main.mouseX >= 10 && Main.mouseX <= 165) {
				//Specific options here
				if(Main.mouseY >= 100 && Main.mouseY < 130) { //Render map
					Main.scene = "Render";
				} else if(Main.mouseY >= 130 && Main.mouseY < 165) { //Load map
					Main.scene = "Load";
				}
			}
		}
	}
}
