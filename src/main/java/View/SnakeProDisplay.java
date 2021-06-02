package View;

import Model.SnakeProData;
import Model.Preferences;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

/**
 * Controller.SnakeProBrain - The "View" in MVC
 * 
 * @author CS60 instructors
 */
public class SnakeProDisplay {

	/** reference to the board/snakePro data being drawn */
	private SnakeProData theData;
	
	/** the display where the board is drawn */
	private Graphics theScreen;
	
	/** width of the display in pixels */
	private int width;
	
	/** height of the display in pixels */
	private int height;
	
	/** a picture of a can of food */
	public static Image imageFood;

	/** Constructor
	 * 
	 * @param theBoardInput    the data being displayed
	 * @param theScreenInput  the display to draw the board
	 * @param widthInput      width of the display (in pixels)
	 * @param heightInput     height of the display (in pixels)
	 */
	public SnakeProDisplay(SnakeProData theBoardInput, Graphics theScreenInput,
						   int widthInput, int heightInput) {
		this.theScreen = theScreenInput;
		this.theData   = theBoardInput;
		this.height    = heightInput;
		this.width     = widthInput;
	}

	/* -------------------- */
	/* Displaying the board */
	/* -------------------- */
	
	/**
	 * Re-draws the board, food, and snake (but not the buttons).
	 */
	public void updateGraphics() {
		// Draw the background. DO NOT REMOVE!
		this.clear();
		
		// Draw the title
		this.displayTitle();

		// Draw the board and snake
		// TODO: Add your code here :)
		for(int y = 0; y < this.height; y++) {
			for (int x = 0; x < this.width; x++) {
				if (x == 0 || x == this.width - 1 || y == 0 || y == this.height - 1)
					this.drawSquare(x, y, Preferences.COLOR_WALL);
				else if (x == 1 * Preferences.CELL_SIZE && y == 1 * Preferences.CELL_SIZE)
					this.drawSquare(x, y, Preferences.COLOR_BODY);
				else if (x == 2 * Preferences.CELL_SIZE && y == 1 * Preferences.CELL_SIZE)
					this.drawSquare(x, y, Preferences.COLOR_HEAD);
			}
		}
		// The method drawSquare (below) will likely be helpful :)

		
		// Draw the game-over message, if appropriate.
		if (this.theData.getGameOver()) {
			this.displayGameOver();
		}

	}

	/**
	 * Draws a cell-sized square with its upper-left corner
	 * at the given pixel coordinates (i.e., x pixels to the right and 
	 * y pixels below the upper-left corner) on the display.
	 * 
	 * @param x  x-coordinate of the square, between 0 and this.width-1 inclusive
	 * @param y  y-coordinate of the square, between 0 and this.width-1 inclusive
	 * @param cellColor  color of the square being drawn
	 */
	public void drawSquare(int x, int y, Color cellColor) {
		this.theScreen.setColor(cellColor);
		this.theScreen.fillRect(x, y, Preferences.CELL_SIZE,
				Preferences.CELL_SIZE);
	}

	/**
	 * Draws the background. DO NOT MODIFY!
	 */
	void clear() {
		this.theScreen.setColor(Preferences.COLOR_BACKGROUND);
		this.theScreen.fillRect(0, 0, this.width, this.height);
		this.theScreen.setColor(Preferences.TITLE_COLOR);
		this.theScreen.drawRect(0, 0, this.width - 1,
				Preferences.GAMEBOARDHEIGHT - 1);
	}

	/* ------------ */
	/* Text Display */
	/* ------------ */
	
	/**
	 * Displays the title of the game.
	 */
	public void displayTitle() {
		this.theScreen.setFont(Preferences.TITLE_FONT);
		this.theScreen.setColor(Preferences.TITLE_COLOR);
		this.theScreen.drawString(Preferences.TITLE, 
				Preferences.TITLE_X, Preferences.TITLE_Y);
	}

	/**
	 * Displays the game-over message.
	 */
	public void displayGameOver() {
		this.theScreen.setFont(Preferences.GAME_OVER_FONT);
		this.theScreen.setColor(Preferences.GAME_OVER_COLOR);
		this.theScreen.drawString(Preferences.GAME_OVER_TEXT,
				Preferences.GAME_OVER_X, Preferences.GAME_OVER_Y);
	}
}
