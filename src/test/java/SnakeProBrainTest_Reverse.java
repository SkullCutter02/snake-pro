import static org.junit.Assert.*;

import Controller.SnakeProBrain;
import Controller.TestGame;
import Model.BoardCell;
import org.junit.Test;


public class SnakeProBrainTest_Reverse {
	// Want pictures of the test boards?
	// https://tinyurl.com/wl4zelg
	@Test
	public void test_ReverseNorth() {
		SnakeProBrain brain = SnakeProBrain.getTestGame(TestGame.G14);
		brain.reverseSnake();
		BoardCell nextCell = brain.testing_getNextCellInDir();
		assertEquals("[1, 2,  ]", nextCell.toString());
	}
	@Test
	public void test_ReverseSouth() {
		SnakeProBrain brain = SnakeProBrain.getTestGame(TestGame.G13);
		brain.reverseSnake();
		BoardCell nextCell = brain.testing_getNextCellInDir();
		assertEquals("[4, 2,  ]", nextCell.toString());
	}
	@Test
	public void test_ReverseEast() {
		SnakeProBrain brain = SnakeProBrain.getTestGame(TestGame.G12);
		brain.reverseSnake();
		BoardCell nextCell = brain.testing_getNextCellInDir();
		assertEquals("[2, 4,  ]", nextCell.toString());
	}
	@Test
	public void test_ReverseWest() {
		SnakeProBrain brain = SnakeProBrain.getTestGame(TestGame.G15);
		brain.reverseSnake();
		BoardCell nextCell = brain.testing_getNextCellInDir();
		assertEquals("[3, 1,  ]", nextCell.toString());
	}


}
