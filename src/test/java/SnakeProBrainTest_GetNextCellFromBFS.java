import static org.junit.Assert.*;

import Controller.SnakeProBrain;
import Controller.TestGame;
import Model.BoardCell;
import org.junit.Test;

public class SnakeProBrainTest_GetNextCellFromBFS {
	// Want pictures of the test boards?
	// https://tinyurl.com/wl4zelg

	@Test
	public void testG1_BFS() {
		SnakeProBrain brain = SnakeProBrain.getTestGame(TestGame.G1);
		BoardCell nextCell = brain.getNextCellFromBFS();
		assertEquals("[1, 3, X]", nextCell.toString());
	}

	@Test
	public void testG2_BFS() {
		SnakeProBrain brain = SnakeProBrain.getTestGame(TestGame.G2);
		BoardCell nextCell = brain.getNextCellFromBFS();
		assertEquals("[2, 2, X]", nextCell.toString());
	}

	@Test
	public void testG3_BFS() {
		SnakeProBrain brain = SnakeProBrain.getTestGame(TestGame.G3);
		BoardCell nextCell = brain.getNextCellFromBFS();
		assertEquals("[1, 3,  ]", nextCell.toString());
	}

	@Test
	public void testG4_BFS() {
		SnakeProBrain brain = SnakeProBrain.getTestGame(TestGame.G4);
		BoardCell nextCell = brain.getNextCellFromBFS();
		assertEquals("[2, 2,  ]", nextCell.toString());
	}

	@Test
	public void testG5_BFS() {
		SnakeProBrain brain = SnakeProBrain.getTestGame(TestGame.G5);
		BoardCell nextCell = brain.getNextCellFromBFS();
		assertEquals("[2, 2,  ]", nextCell.toString());
	}

	@Test
	public void testG6_BFS() {
		SnakeProBrain brain = SnakeProBrain.getTestGame(TestGame.G6);
		BoardCell nextCell = brain.getNextCellFromBFS();
		assertEquals("[1, 3, X]", nextCell.toString());
	}

	@Test
	public void testG7_BFS() {
		SnakeProBrain brain = SnakeProBrain.getTestGame(TestGame.G7);
		BoardCell nextCell = brain.getNextCellFromBFS();
		assertEquals("[2, 2, X]", nextCell.toString());
	}

	@Test
	public void testG8_BFS() {
		SnakeProBrain brain = SnakeProBrain.getTestGame(TestGame.G8);
		BoardCell nextCell = brain.getNextCellFromBFS();
		assertEquals("[1, 3,  ]", nextCell.toString());
	}

	@Test
	public void testG9_BFS() {
		SnakeProBrain brain = SnakeProBrain.getTestGame(TestGame.G9);
		BoardCell nextCell = brain.getNextCellFromBFS();
		assertEquals("[2, 2,  ]", nextCell.toString());
	}

	@Test
	public void testG10_BFS() {
		SnakeProBrain brain = SnakeProBrain.getTestGame(TestGame.G10);
		BoardCell nextCell = brain.getNextCellFromBFS();
		assertEquals("[2, 2,  ]", nextCell.toString());
		System.out.println(brain.testing_toStringParent());
	}

	@Test
	public void testG11_BFS() {
		SnakeProBrain brain = SnakeProBrain.getTestGame(TestGame.G11);
		BoardCell nextCell = brain.getNextCellFromBFS();
		// NEED AN OR!
		String possibleResult1 = "[1, 3,  ]";
		String possibleResult2 = "[2, 2,  ]";
		String nextCellString = nextCell.toString();
		assertTrue(possibleResult1.equals(nextCellString)
				|| possibleResult2.equals(nextCellString));
	}

}
