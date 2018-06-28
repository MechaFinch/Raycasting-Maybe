package MainClasses;

import java.awt.*;
import java.awt.image.*;
import java.io.File;

import javax.swing.*;
import Scenes.*;

//Main class - Highest level manager and sets up graphics.
@SuppressWarnings("serial")
public class Main {
	private JFrame window = new JFrame();
	
	public static final int width = 600, height = 600;
	
	//Graphics thing
	private BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	public Graphics2D g = img.createGraphics();
	public JPanel panel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            int w = img.getWidth();
            int h = img.getHeight();
            g2.drawImage(img, 0, 0, w, h, null);
            g2.dispose();
        }
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(img.getWidth(), img.getHeight());
        }
    };
    
	private int frameRate = 30;
	public static int mouseX;
	public static int mouseY;
	
	//What scene is currently being used
	public static String scene = "MainMenu";
	
	//Thing so text works
	public static boolean readyToStart = false;
	
	//Other booleans
	public static boolean mousePressed = false;
	public static boolean newMousePress = true;
	public static boolean mapLoaded = false;
	
	public static File map = null;
	
	//Array for keys being pressed - the key's keycode is the index for it
	public static boolean[] keyPressed = new boolean[90];
	
	//Init and run loop
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		Main This = new Main();
		
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				This.initWindow();
				readyToStart = true;
			}
		});
		
		//Don't question it i don't know why its needed but it is
		while(!readyToStart) {try {Thread.sleep(1);} catch (InterruptedException e) {}}
		
		while(true) {
			This.draw();
			try {
				Thread.sleep(1000 / (long) This.frameRate);
			} catch(InterruptedException e) {
				System.out.println("Interrupted exception between frame calls");
				System.exit(1);
			}
		}
	}
	
	//Runs every frame at the specified frame rate
	void draw() {
		//Use proper scene
		switch(scene) {
			case "MainMenu":{
				MainMenu mm = new MainMenu();
				mm.getGraphics(g);
				mm.start();
				break;
			}
			case "Load":{
				LoadMenu lm = new LoadMenu();
				lm.getGraphics(g);
				lm.start();
				break;
			}
			case "Render":{
				RenderScene rs = new RenderScene();
				rs.getGraphics(g);
				rs.start();
				break;
			}
			default:{
				throw new IllegalArgumentException("Unknown Scene: " + scene);
			}
		}
		
		//Update graphics
		panel.repaint();
	}
	
	//Init window
	void initWindow() {
		window.setSize(width, height);
		window.setTitle("Raycast?");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.add(panel);
		window.addMouseListener(new MouseManager());
		window.addMouseMotionListener(new MouseManager());
		window.addKeyListener(new KeyManager());
		
		panel.setBackground(Color.white);
		
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		window.setVisible(true);
	}
	
	//List all the fonts available
	void listFonts() {
		String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
		for(String s : fonts) {
			System.out.println(s);
		}
	}
}
