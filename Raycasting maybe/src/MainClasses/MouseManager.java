package MainClasses;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

//Mouse stuff
public class MouseManager implements MouseListener, MouseMotionListener{
	
	public void mouseClicked(MouseEvent e) {
	}
	
	public void mousePressed(MouseEvent e) {
		Main.mousePressed = true;
	}
	
	public void mouseReleased(MouseEvent e) {
		Main.mousePressed = false;
	}
	
	public void mouseEntered(MouseEvent e) {
	}
	
	public void mouseExited(MouseEvent e) {
	}
	
	public void mouseDragged(MouseEvent e) {
		Main.mouseX = e.getX();
		Main.mouseY = e.getY();
	}
	
	public void mouseMoved(MouseEvent e) {
		Main.mouseX = e.getX();
		Main.mouseY = e.getY();
	}
}
