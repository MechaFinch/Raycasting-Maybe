package Scenes;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFileChooser;
import MainClasses.*;

public class LoadMenu extends Scene{
	
	protected void use() {
		//Clear
		g.setColor(Color.white);
		g.fillRect(0, 0, Main.width, Main.height);
		
		//Menu text
		g.setColor(Color.black);
		g.setFont(new Font("Calibri", Font.PLAIN, 48));
		g.drawString("Load Map", 10, 58);
		
		g.setFont(new Font("Calibri", Font.PLAIN, 36));
		g.drawString("Selected File: " + ((Main.map == null) ? "None" : ""), 10, 100);
		g.drawString("Select File", 10, 130);
		g.drawString("Load Map from File", 10, 160);
		
		//Esc to return to menu
		if(Main.keyPressed[27]) {
			Main.scene = "MainMenu";
		}
		
		if(Main.mousePressed && Main.newMousePress) {
			if(Main.mouseX >= 10 && Main.mouseX <= 160) {
				if(Main.mouseY >= 130 && Main.mouseY < 160) {
					JFileChooser fc = new JFileChooser();
					
					if(fc.showOpenDialog(new Main().panel) == JFileChooser.APPROVE_OPTION) {
						Main.map = fc.getSelectedFile();
					}
				} else if(Main.mouseY >= 160 && Main.mouseY < 190) {
					System.out.println("Load the file");
				}
			}
		}
	}
}
