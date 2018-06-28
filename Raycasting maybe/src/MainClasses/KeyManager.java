package MainClasses;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	
	public void keyTyped(KeyEvent e) {
	}
	
	public void keyPressed(KeyEvent e) {
		Main.keyPressed[e.getKeyCode()] = true;
	}
	
	public void keyReleased(KeyEvent e) {
		Main.keyPressed[e.getKeyCode()] = false;
	}
}
