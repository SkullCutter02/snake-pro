package Controller;

import Model.BoardCell;
import Model.Preferences;
import Model.SnakeProData;
import View.SnakeProDisplay;

import java.awt.event.KeyEvent;
import java.util.*;

/**
 * Controller.SnakeProBrain - The "Controller" in MVC, which includes all of the AI and
 * handling key presses
 *
 * @author Edwin Lagos and Nitu Nahar, adapted from CS60 at HMC
 */
public class SnakeProBrain extends SnakeProBrainParent {

    /**
     * The "View" in MVC
     */
    private SnakeProDisplay theDisplay;

    /**
     * The "Model" in MVC
     */
    private SnakeProData theData;

    /**
     * Number of animated frames displayed so far
     */
    private int cycleNum = 0;

    // Mapping between direction (names) and keys
    private static final char REVERSE = 'r';
    private static final char UP = 'w';
    private static final char DOWN = 's';
    private static final char LEFT = 'a';
    private static final char RIGHT = 'd';
    private static final char AI_MODE = 'q';
    private static final char PLAY_FOOD_NOISE = 'f';

    // Direction vectors
    private final int[] rowVectors = {-1, 0, 1, 0};
    private final int[] columnVectors = {0, 1, 0, -1};


    /**
     * Starts a new game.
     */
    public void startNewGame() {
        this.theData = new SnakeProData();
        this.theData.placeSnakeAtStartLocation();
        this.theData.setStartDirection();

        this.theDisplay = new SnakeProDisplay(this.theData, this.screen,
                this.getSize().width, getSize().height);
        this.theDisplay.updateGraphics();

        this.playSound_food();

        // Hack because pictures have a delay in loading, and we won't
        //    redraw the screen again until the game actually starts,
        //    which means we wouldn't see the image until the game
        //    does start.
        // Wait a fraction of a second (200 ms), by which time the
        //    picture should have been fetched from disk, and redraw.
        try {
            Thread.sleep(200);
        } catch (InterruptedException ignored) {
        }
        ;
        this.theDisplay.updateGraphics();
    }

    /**
     * Declares the game over.
     */
    public void gameOver() {
        super.pause(); // pause the game
        this.theData.setGameOver(); // tell the model that the game is over
        if (this.audioMeow != null) { // play a sound
            this.audioMeow.play();
        }
    }

    /* -------- */
    /* Gameplay */
    /* -------- */

    /**
     * Moves the game forward one step (i.e., one frame of animation,
     * which occurs every Model.Preferences.SLEEP_TIME milliseconds)
     */
    public void cycle() {

        // move the snake
        this.updateSnake();

        // update the list of Food
        this.updateFood();

        // draw the board
        this.theDisplay.updateGraphics();

        // make the new display visible - sends the drawing to the screen
        this.repaint();

        // update the cycle counter
        this.cycleNum++;
    }

    /**
     * Reacts to characters typed by the user.
     * <p>
     * The provided code registers the Controller.SnakeProBrain as
     * an "observer" for key presses on the keyboard.
     * <p>
     * So, whenever the user presses a key,
     * Java automatically calls this keyPressed method and
     * passes it a KeyEvent describing the specific keypress.
     */
    public void keyPressed(KeyEvent evt) {

        switch (evt.getKeyChar()) {
            // The getKeyChar method of a keypress event
            //    returns the character corresponding to the pressed key.

            // TODO: Add cases to handle other keys (set the direction!)
            case UP:
                this.theData.setDirectionNorth();
                break;
            case DOWN:
                this.theData.setDirectionSouth();
                break;
            case LEFT:
                this.theData.setDirectionWest();
                break;
            case RIGHT:
                this.theData.setDirectionEast();
                break;
            case REVERSE:
                this.reverseSnake();
                break;
            case AI_MODE:
                this.theData.setMode_AI();
                break;
            case PLAY_FOOD_NOISE:
                this.playSound_food();
                break;
            default:
                this.theData.setDirectionEast();
        }
    }


    /**
     * Moves the snake forward once every REFRESH_RATE cycles,
     * either in the current direction, or as directed by
     * the AI's breadth-first search.
     * <p>
     * TODO: Called by ???
     */
    public void updateSnake() {
        if (this.cycleNum % Preferences.REFRESH_RATE == 0) {
            BoardCell nextCell;
            if (this.theData.inAImode()) {
                nextCell = this.getNextCellFromBFS();
            } else {
                nextCell = this.theData.getNextCellInDir();
            }
            this.advanceTheSnake(nextCell);
        }
    }

    /**
     * Move the snake into the next cell (and possibly eat food)
     * <p>
     * This method should probably be private, but we make it
     * public anyway to permit unit testing.
     *
     * @param nextCell New location of the snake head (which
     *                 must be horizontally or vertically adjacent
     *                 to the old location of the snake head).
     */
    public void advanceTheSnake(BoardCell nextCell) {
        // Note - do not modify provided code.
        if (nextCell.isWall() || nextCell.isBody()) {
            // Oops...we hit something.
            this.gameOver();
            return;
        } else if (nextCell.isFood()) {
            this.playSound_foodEaten();
            // TODO: Possibly add code here to tell theData
            //       the snake ate food!
            this.theData.getSnakeHead().becomeBody();
            this.theData.appendHead(nextCell);
        } else {
            // just regular movement into an open space
            // TODO: Possibly add code to tell theData the snake moved
            this.theData.getSnakeHead().becomeBody();
            this.theData.appendHead(nextCell);
            this.theData.removeTail();
        }
        // TODO: Possibly add code here too!
        // You'll need to add helper methods to Model.SnakeProData.java
        // Look for the header: "snake movement methods" for where to put these
    }


    /**
     * Every FOOD_ADD_RATE cycles, tries to add one new food.
     */
    public void updateFood() {
        if (this.theData.noFood()) {
            this.theData.addFood();
        } else if (this.cycleNum % Preferences.FOOD_ADD_RATE == 0) {
            this.theData.addFood();
        }
    }

    private <T> void reverseList(LinkedList<T> list) {
        if(list.size() == 0) return;

        T item = list.remove(0);
        reverseList(list);
        list.add(item);
    }

    private boolean isCellAdjacentToHead(BoardCell cell) {
        if (cell.isBody() || cell.isHead()) return false;

        boolean checkRow = Math.abs(cell.getRow() - this.theData.getSnakeHead().getRow()) == 1 &&
                Math.abs(cell.getColumn() - this.theData.getSnakeHead().getColumn()) == 0;
        boolean checkColumn = Math.abs(cell.getRow() - this.theData.getSnakeHead().getRow()) == 0 &&
                Math.abs(cell.getColumn() - this.theData.getSnakeHead().getColumn()) == 1;

        return checkRow || checkColumn;
    }

    private boolean isCellValid(int row, int col) {
        // If cell is out of bounds
        if (row < 0 || col < 0 || row >= this.theData.getNumRows() || col >= this.theData.getNumColumns())
            return false;

        return !this.theData.getCell(row, col).inSearchListAlready();
    }

    // Search adjacent cells
    private void addCellToQueue(Queue<BoardCell> q, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int adjx = x + rowVectors[i];
            int adjy = y + columnVectors[i];

            if (isCellValid(adjx, adjy)) {
                BoardCell cellToAdd = this.theData.getCell(adjx, adjy);

                if(!cellToAdd.inSearchListAlready()) {
                    q.add(cellToAdd);
                    cellToAdd.setAddedToSearchList();
                }
            }
        }
    }


    /**
     * Uses BFS to search for the food closest to the snake head.
     *
     * @return Where to move the snake head, if we want to head
     * *one step* along the shortest path to (the nearest)
     * food cell.
     */
    public BoardCell getNextCellFromBFS() {
        // Initialize the search.
        theData.resetCellsForNextSearch();

        // Initialize the cellsToSearch queue with the snake head;
        // as with any cell, we mark the head cells as having been added
        // to the queue
        Queue<BoardCell> cellsToSearch = new LinkedList<>();
        BoardCell snakeHead = theData.getSnakeHead();
        snakeHead.setAddedToSearchList();
        cellsToSearch.add(snakeHead);

        // Variable to hold the closest food cell, once we've found it.
        BoardCell closestFoodCell = null;

        // Search!
        // TODO: Make sure you understand the code above and then implement your search here!
        while (!cellsToSearch.isEmpty()) {
            BoardCell current = cellsToSearch.remove();

            if(current.isBody() || current.isWall()) continue;

            if (current.isFood()) {
                closestFoodCell = current;
                break;
            }

            int x = current.getRow();
            int y = current.getColumn();

            addCellToQueue(cellsToSearch, x, y);
        }

        if (closestFoodCell == null)
            return this.theData.getRandomNeighboringCell(snakeHead);

        return this.getFirstCellInPath(closestFoodCell);

        // Note: we encourage you to write the helper method
        // getFirstCellInPath below to do the backtracking to calculate the next cell!
    }

    /**
     * Follows parent pointers back from the closest food cell
     * to decide where the head should move. Specifically,
     * follows the parent pointers back from the food until we find
     * the cell whose parent is the snake head (and which must therefore
     * be adjacent to the previous snake head location).
     * <p>
     * Recursive or looping solutions are possible.
     *
     * @param start where to start following food pointers; this will
     *              be (at least initially, if you use recursion) the
     *              location of the food closest to the head.
     * @return the new cell for the snake head.
     */
    private BoardCell getFirstCellInPath(BoardCell start) {
        this.theData.resetCellsForNextSearch();

        Queue<BoardCell> cellsToSearch = new LinkedList<>();
        start.setAddedToSearchList();
        cellsToSearch.add(start);

        BoardCell targetCell = null;

        while (!cellsToSearch.isEmpty()) {
            BoardCell current = cellsToSearch.remove();

            if(current.isBody() || current.isWall()) continue;

            if(isCellAdjacentToHead(current)) {
                targetCell = current;
                break;
            }

            int x = current.getRow();
            int y = current.getColumn();

            addCellToQueue(cellsToSearch, x, y);
        }

        return targetCell;
    }


    /**
     * Reverses the snake back-to-front and updates the movement
     * mode appropriately.
     */
    public void reverseSnake() {
        // TODO: Write helper methods in Model.SnakeProData.java and call them here!
        // Note - we provided suggestions for helper methods. Look for the
        // section: "Helper methods for reverse"
        this.theData.reverse();
    }


    /* ------ */
    /* Sounds */
    /* ------ */

    /**
     * Plays crunch noise
     */
    public void playSound_foodEaten() {
        if (this.audioCrunch != null) {
            this.audioCrunch.play();
        }
    }

    /**
     * Plays food noise
     */
    public void playSound_food() {
        if (this.audioFood != null) {
            this.audioFood.play();
        }
    }

    /**
     * Plays meow noise
     */
    public void playSound_meow() {
        if (this.audioMeow != null) {
            this.audioMeow.play();
        }
    }

    // not used - a variable added to remove a Java warning:
    private static final long serialVersionUID = 1L;


    /* ---------------------- */
    /* Testing Infrastructure */
    /* ---------------------- */

    public static SnakeProBrain getTestGame(TestGame gameNum) {
        SnakeProBrain brain = new SnakeProBrain();
        brain.theData = new SnakeProData(gameNum);
        return brain;
    }

    public String testing_toStringParent() {
        return this.theData.toStringParents();
    }

    public BoardCell testing_getNextCellInDir() {
        return this.theData.getNextCellInDir();
    }

    public String testing_toStringSnakeProData() {
        return this.theData.toString();
    }
}
