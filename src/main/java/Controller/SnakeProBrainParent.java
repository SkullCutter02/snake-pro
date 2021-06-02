package Controller;

import Model.Preferences;
import View.SnakeProDisplay;
import View.SnakeProImagePanel;

import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;

//DO NOT MODIFY
/**
 * Controller.SnakeProBrainParent - Provides back-end for Controller.SnakeProBrain and View.SnakeProDisplay
 * 
 * @author CS60 instructors
 */
public abstract class SnakeProBrainParent extends JApplet implements
		ActionListener, KeyListener, Runnable {

	// off screen buffer of image:
	public Image image; 
	// the buffer's graphical tools:
	public Graphics screen; 

	// Buttons
	private JButton newGameButton;
	private JButton pauseButton;
	private JButton startButton;

	// Drop-down Menu
	private JMenu gameMenu;
	private JMenuItem newGameItem;
	private JMenuItem pauseItem;
	private JMenuItem startItem;

	// Here are other data members you might like to use (optional)...
	public AudioClip audioFood; // Food sound
	public AudioClip audioCrunch; // Crunch sound
	public AudioClip audioMeow; // Meow sound

	// Method called when SnakePro is started! (not per game)
	public void init() {

		// register w/the applet (i.e. parent) so it calls our keyPressed method
		this.addKeyListener(this); 
		// set positions
		this.setLayout(new BorderLayout()); 

		this.initializeButtons();
		this.initializeMenu();

		// Sets up the back (off-screen) buffer for drawing, named image
		this.image = this.createImage(this.getSize().width+10*Preferences.CELL_SIZE, Preferences.GAMEBOARDHEIGHT);
		this.screen = this.image.getGraphics(); // screen holds the drawing routines

		// add a central panel which holds the buffer (the game board)
		this.add(new SnakeProImagePanel(image), BorderLayout.CENTER);

		// Example of loading images and audio
		try {
			URL url = this.getCodeBase();
			this.audioFood = this.getAudioClip(url, "Food.au");
			this.audioCrunch = this.getAudioClip(url, "crunch.au");
			this.audioMeow = this.getAudioClip(url, "cat.au");
			SnakeProDisplay.imageFood = this.getImage(url, "food.gif");
			System.out.println("successful loading of audio/images!\n");
			System.out.flush();
		} catch (Exception e) {
			System.out.println("problem loading audio/images!\n");
			System.out.flush();
			this.audioFood = null;
			this.audioCrunch = null;
			this.audioMeow = null;
			SnakeProDisplay.imageFood = null;
		}
		this.startNewGame(); // Set up the game internals!
		super.repaint(); // re-render the environment to the screen
	}

	// Here is how buttons and menu items work...
	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();

		if (source == this.newGameButton || source == this.newGameItem) {
			this.startNewGame();
			this.go();
		}
		if (source == this.pauseButton || source == this.pauseItem) {
			this.pause();
		}
		if (source == this.startButton || source == this.startItem) {
			this.go();
		}
		this.requestFocus(); // makes sure the Applet keeps keyboard focus
	}
	// Add all buttons
	private void initializeButtons(){
		// add a panel for buttons
		JPanel buttonPane = new JPanel(new FlowLayout());
		buttonPane.setBackground(Preferences.COLOR_BACKGROUND);
		this.add(buttonPane, BorderLayout.PAGE_START);
		
		this.newGameButton = new JButton("New Game"); // the text in the button
		this.newGameButton.addActionListener(this); // watch for button presses
		this.newGameButton.addKeyListener(this); // listen for key presses here
		buttonPane.add(this.newGameButton); // add button to the panel

		this.pauseButton = new JButton("Pause"); // a second button
		this.pauseButton.addActionListener(this);
		this.pauseButton.addKeyListener(this);
		buttonPane.add(this.pauseButton);

		this.startButton = new JButton("Start"); // a third button
		this.startButton.addActionListener(this);
		this.startButton.addKeyListener(this);
		buttonPane.add(this.startButton);
	}
	// Add all menu items
	private void initializeMenu(){
		// Set up the menu bar
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);

		// add a menu to contain items
		this.gameMenu = new JMenu("Game"); // The menu name
		menuBar.add(gameMenu); // Add the menu to the menu bar

		this.newGameItem = new JMenuItem("New Game"); // the text in the menu
		this.newGameItem.addActionListener(this); // Watch for button presses
		this.newGameItem.addKeyListener(this); // Listen for key presses here
		this.gameMenu.add(this.newGameItem); // Add the item to the menu

		this.pauseItem = new JMenuItem("Pause"); // A second menu item
		this.pauseItem.addActionListener(this);
		this.pauseItem.addKeyListener(this);
		this.gameMenu.add(this.pauseItem);

		this.startItem = new JMenuItem("Start"); // A third menu item
		this.startItem.addActionListener(this);
		this.startItem.addKeyListener(this);
		this.gameMenu.add(this.startItem);
		// end of menu bar code
	}
	public void keyReleased(KeyEvent evt) {
		// Not used
	}

	public void keyTyped(KeyEvent evt) {
		// Not used
	}

	/*
	 * The following methods and data members are used to implement the Runnable
	 * interface and to support pausing and resuming the applet.
	 */
	Thread thread; // the thread controlling the updates
	boolean threadSuspended; // whether or not the thread is suspended
	boolean running; // whether or not the thread is stopped

	/*
	 * This is the method that calls the "cycle()" method every so often (every
	 * sleepTime milliseconds).
	 */
	public void run() {
		while (this.running) {
			try {
				if (this.thread != null) {
					Thread.sleep(Preferences.SLEEP_TIME);
					synchronized (this) {
						while (this.threadSuspended) {
							this.wait(); // sleeps until notify() wakes it up
						}
					}
				}
			} catch (InterruptedException e) {
				;
			}

			this.cycle(); // this represents 1 update cycle for the environment
		}
		this.thread = null;
	}

	/*
	 * This is the method attached to the "Start" button
	 */
	public synchronized void go() {
		if (this.thread == null) {
			this.thread = new Thread(this);
			this.running = true;
			this.thread.start();
			this.threadSuspended = false;
		} else {
			this.threadSuspended = false;
		}
		this.notify(); // wakes up the call to wait(), above
	}

	/*
	 * This is the method attached to the "Pause" button
	 */
	public void pause() {
		if (this.thread == null) {
			;
		} else {
			this.threadSuspended = true;
		}
	}

	/*
	 * This is a method called when you leave the page that contains the applet.
	 * It stops the thread altogether.
	 */
	public synchronized void stop() {
		this.running = false;
		this.notify();
	}

	/*
	 * Methods that will be overridden to provide SnakePro functionality
	 */

	abstract void cycle();

	abstract void startNewGame();

	public abstract void keyPressed(KeyEvent evt);

	private static final long serialVersionUID = 1L;

	/* This is the end of the SnakeProBase class */
}
