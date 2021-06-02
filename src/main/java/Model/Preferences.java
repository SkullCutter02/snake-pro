package Model;

import java.awt.Color;
import java.awt.Font;

/**
 * Model.Preferences - to avoid "magic numbers" within other code all unchanging
 * variables should be stored here!
 *
 * This variables are labeled as final because they should not be changed outside of this class, hence their name
 * Constants.
 *
 */
public final class Preferences {
	// Timing Constants:
	public static final int REFRESH_RATE = 2;
	public static final int FOOD_ADD_RATE = 25;
	public static final int SLEEP_TIME = 30; // milliseconds between updates
	// Sizing Constants:
	public static final int NUM_CELLS_WIDE = 50;
	public static final int NUM_CELLS_TALL = 30;
	public static final int CELL_SIZE = 10;
	private static final int SPACE_FOR_BUTTONS = 190;
	public static final int GAMEBOARDHEIGHT = NUM_CELLS_TALL * CELL_SIZE
			+ SPACE_FOR_BUTTONS;
	// Colors Constants:
	public static final Color COLOR_BACKGROUND = new Color(52, 152,219);
	public static final Color COLOR_WALL = Color.BLUE;
	public static final Color COLOR_FOOD = Color.ORANGE;
	public static final Color COLOR_OPEN = Color.WHITE;
	public static final Color COLOR_HEAD = Color.BLACK;
	public static final Color COLOR_BODY = Color.GREEN;
	// Text display - Title:
	public static final int TITLE_X = 100;
	public static final int TITLE_Y = 40;
	public static final Font TITLE_FONT = new Font("Helvetica", Font.PLAIN, 30);	
	public static final Color TITLE_COLOR = new Color(236, 240, 241);
	public static final String TITLE = "Snek Pro"; // TODO: Update the title!
	// Text display - Game Over
	public static final int GAME_OVER_X = 150;
	public static final int GAME_OVER_Y = 200;
	public static final Font GAME_OVER_FONT = new Font("Helvetica", Font.PLAIN, 60);	
	public static final Color GAME_OVER_COLOR = Color.BLUE;
	public static final String GAME_OVER_TEXT = "Game Over";
	


}
