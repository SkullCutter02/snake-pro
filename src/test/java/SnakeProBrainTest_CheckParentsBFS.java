import static org.junit.Assert.*;

import Controller.SnakeProBrain;
import Controller.TestGame;
import Model.BoardCell;
import org.junit.Test;

public class SnakeProBrainTest_CheckParentsBFS {
	// Want pictures of the test boards?
	// https://tinyurl.com/wl4zelg

	// IMPORTANT:
	// The tests in this file assume the BFS runs until food
	// is dequeued, rather than stopping as soon as you first
	// find a food cell.
	//
	// If you write cleverer code that stops early,
	// most or all of these tests will fail...and that's OK!
	// You should try running SnakeProBrainTest_CheckParentsBFS_fast
	// instead.
	
	@Test
	public void testG1_BFS() {
		SnakeProBrain brain = SnakeProBrain.getTestGame(TestGame.G1);
		BoardCell nextCell = brain.getNextCellFromBFS();
		// not checking nextCell only checking parent content
		String parentString = brain.testing_toStringParent();
		String correctParentString = "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n"
				+ "[null]\t[null]\t[null]\t[1, 2]\t[null]\t[null]\t\n"
				+ "[null]\t[2, 2]\t[1, 2]\t[2, 2]\t[null]\t[null]\t\n"
				+ "[null]\t[null]\t[2, 2]\t[null]\t[null]\t[null]\t\n"
				+ "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n"
				+ "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n";
		// Sample debugging output:
		// System.out.println("G1");
		// System.out.println("Expected:");
		// System.out.println(correctParentString);
		// System.out.println("Actual:");
		// System.out.println(brain.testing_toStringParent());
		assertEquals(correctParentString, parentString);
	}

	@Test
	public void testG2_BFS() {
		SnakeProBrain brain = SnakeProBrain.getTestGame(TestGame.G2);
		BoardCell nextCell = brain.getNextCellFromBFS();
		// not checking nextCell only checking parent content
		String parentString = brain.testing_toStringParent();
		String correctParentString = "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n"
				+ "[null]\t[null]\t[null]\t[1, 2]\t[null]\t[null]\t\n"
				+ "[null]\t[null]\t[1, 2]\t[null]\t[null]\t[null]\t\n"
				+ "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n"
				+ "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n"
				+ "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n";
		// Sample debugging output:
		// System.out.println("G2");
		// System.out.println("Expected:");
		// System.out.println(correctParentString);
		// System.out.println("Actual:");
		// System.out.println(brain.testing_toStringParent());
		assertEquals(correctParentString, parentString);
	}

	@Test
	public void testG3_BFS() {
		SnakeProBrain brain = SnakeProBrain.getTestGame(TestGame.G3);
		BoardCell nextCell = brain.getNextCellFromBFS();
		// not checking nextCell only checking parent content
		String parentString = brain.testing_toStringParent();
		String correctParentString = "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n"
				+ "[null]\t[null]\t[null]\t[1, 2]\t[1, 3]\t[null]\t\n"
				+ "[null]\t[2, 2]\t[1, 2]\t[2, 2]\t[2, 3]\t[null]\t\n"
				+ "[null]\t[3, 2]\t[2, 2]\t[3, 2]\t[null]\t[null]\t\n"
				+ "[null]\t[null]\t[3, 2]\t[null]\t[null]\t[null]\t\n"
				+ "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n";
		// Sample debugging output:
		// System.out.println("G3");
		// System.out.println("Expected:");
		// System.out.println(correctParentString);
		// System.out.println("Actual:");
		// System.out.println(brain.testing_toStringParent());
		assertEquals(correctParentString, parentString);
	}

	@Test
	public void testG4_BFS() {
		SnakeProBrain brain = SnakeProBrain.getTestGame(TestGame.G4);
		BoardCell nextCell = brain.getNextCellFromBFS();
		// not checking nextCell only checking parent content
		String parentString = brain.testing_toStringParent();
		String correctParentString = "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n"
				+ "[null]\t[null]\t[null]\t[1, 2]\t[1, 3]\t[null]\t\n"
				+ "[null]\t[2, 2]\t[1, 2]\t[2, 2]\t[2, 3]\t[null]\t\n"
				+ "[null]\t[3, 2]\t[2, 2]\t[3, 2]\t[null]\t[null]\t\n"
				+ "[null]\t[null]\t[3, 2]\t[null]\t[null]\t[null]\t\n"
				+ "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n";
		// Sample debugging output:
		// System.out.println("G4");
		// System.out.println("Expected:");
		// System.out.println(correctParentString);
		// System.out.println("Actual:");
		// System.out.println(brain.testing_toStringParent());
		assertEquals(correctParentString, parentString);
	}

	@Test
	public void testG5_BFS() {
		SnakeProBrain brain = SnakeProBrain.getTestGame(TestGame.G5);
		BoardCell nextCell = brain.getNextCellFromBFS();
		// not checking nextCell only checking parent content
		String parentString = brain.testing_toStringParent();
		String correctParentString = "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n"
				+ "[null]\t[null]\t[null]\t[1, 2]\t[1, 3]\t[null]\t\n"
				+ "[null]\t[2, 2]\t[1, 2]\t[2, 2]\t[2, 3]\t[null]\t\n"
				+ "[null]\t[3, 2]\t[2, 2]\t[3, 2]\t[3, 3]\t[null]\t\n"
				+ "[null]\t[4, 2]\t[3, 2]\t[4, 2]\t[4, 3]\t[null]\t\n"
				+ "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n";
		// Sample debugging output:
		// System.out.println("G5");
		// System.out.println("Expected:");
		// System.out.println(correctParentString);
		// System.out.println("Actual:");
		// System.out.println(brain.testing_toStringParent());
		assertEquals(correctParentString, parentString);
	}

	@Test
	public void testG6_BFS() {
		SnakeProBrain brain = SnakeProBrain.getTestGame(TestGame.G6);
		BoardCell nextCell = brain.getNextCellFromBFS();
		// not checking nextCell only checking parent content
		String parentString = brain.testing_toStringParent();
		String correctParentString = "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n"
				+ "[null]\t[null]\t[null]\t[1, 2]\t[null]\t[null]\t\n"
				+ "[null]\t[2, 2]\t[1, 2]\t[2, 2]\t[null]\t[null]\t\n"
				+ "[null]\t[null]\t[2, 2]\t[null]\t[null]\t[null]\t\n"
				+ "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n"
				+ "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n";
		// Sample debugging output:
		// System.out.println("G6");
		// System.out.println("Expected:");
		// System.out.println(correctParentString);
		// System.out.println("Actual:");
		// System.out.println(brain.testing_toStringParent());
		assertEquals(correctParentString, parentString);
	}

	@Test
	public void testG7_BFS() {
		SnakeProBrain brain = SnakeProBrain.getTestGame(TestGame.G7);
		BoardCell nextCell = brain.getNextCellFromBFS();
		// not checking nextCell only checking parent content
		String parentString = brain.testing_toStringParent();
		String correctParentString = "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n"
				+ "[null]\t[null]\t[null]\t[1, 2]\t[null]\t[null]\t\n"
				+ "[null]\t[null]\t[1, 2]\t[null]\t[null]\t[null]\t\n"
				+ "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n"
				+ "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n"
				+ "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n";
		// Sample debugging output:
		// System.out.println("G7");
		// System.out.println("Expected:");
		// System.out.println(correctParentString);
		// System.out.println("Actual:");
		// System.out.println(brain.testing_toStringParent());
		assertEquals(correctParentString, parentString);
	}

	@Test
	public void testG8_BFS() {
		SnakeProBrain brain = SnakeProBrain.getTestGame(TestGame.G8);
		BoardCell nextCell = brain.getNextCellFromBFS();
		// not checking nextCell only checking parent content
		String parentString = brain.testing_toStringParent();
		String correctParentString = "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n"
				+ "[null]\t[null]\t[null]\t[1, 2]\t[1, 3]\t[null]\t\n"
				+ "[null]\t[2, 2]\t[1, 2]\t[2, 2]\t[2, 3]\t[null]\t\n"
				+ "[null]\t[3, 2]\t[2, 2]\t[3, 2]\t[null]\t[null]\t\n"
				+ "[null]\t[null]\t[3, 2]\t[null]\t[null]\t[null]\t\n"
				+ "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n";
		// Sample debugging output:
		// System.out.println("G8");
		// System.out.println("Expected:");
		// System.out.println(correctParentString);
		// System.out.println("Actual:");
		// System.out.println(brain.testing_toStringParent());
		assertEquals(correctParentString, parentString);
	}

	@Test
	public void testG9_BFS() {
		SnakeProBrain brain = SnakeProBrain.getTestGame(TestGame.G9);
		BoardCell nextCell = brain.getNextCellFromBFS();
		// not checking nextCell only checking parent content
		String parentString = brain.testing_toStringParent();
		String correctParentString = "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n"
				+ "[null]\t[null]\t[null]\t[1, 2]\t[1, 3]\t[null]\t\n"
				+ "[null]\t[2, 2]\t[1, 2]\t[2, 2]\t[2, 3]\t[null]\t\n"
				+ "[null]\t[3, 2]\t[2, 2]\t[3, 2]\t[null]\t[null]\t\n"
				+ "[null]\t[null]\t[3, 2]\t[null]\t[null]\t[null]\t\n"
				+ "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n";
		// Sample debugging output:
		// System.out.println("G9");
		// System.out.println("Expected:");
		// System.out.println(correctParentString);
		// System.out.println("Actual:");
		// System.out.println(brain.testing_toStringParent());
		assertEquals(correctParentString, parentString);
	}

	@Test
	public void testG10_BFS() {
		SnakeProBrain brain = SnakeProBrain.getTestGame(TestGame.G10);
		BoardCell nextCell = brain.getNextCellFromBFS();
		// not checking nextCell only checking parent content
		String parentString = brain.testing_toStringParent();
		String correctParentString = "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n"
				+ "[null]\t[null]\t[null]\t[1, 2]\t[1, 3]\t[null]\t\n"
				+ "[null]\t[2, 2]\t[1, 2]\t[2, 2]\t[2, 3]\t[null]\t\n"
				+ "[null]\t[3, 2]\t[2, 2]\t[3, 2]\t[3, 3]\t[null]\t\n"
				+ "[null]\t[4, 2]\t[3, 2]\t[4, 2]\t[4, 3]\t[null]\t\n"
				+ "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n";
		// Sample debugging output:
		// System.out.println("G10");
		// System.out.println("Expected:");
		// System.out.print(correctParentString);
		// System.out.println("Actual:");
		// System.out.print(brain.testing_toStringParent());
		assertEquals(correctParentString, parentString);
	}

	@Test
	public void testG11_BFS() {
		SnakeProBrain brain = SnakeProBrain.getTestGame(TestGame.G11);
		BoardCell nextCell = brain.getNextCellFromBFS();
		// not checking nextCell only checking parent content
		String parentString = brain.testing_toStringParent();
		String correctParentString = "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n"
				+ "[null]\t[null]\t[null]\t[1, 2]\t[1, 3]\t[null]\t\n"
				+ "[null]\t[2, 2]\t[1, 2]\t[2, 2]\t[2, 3]\t[null]\t\n"
				+ "[null]\t[3, 2]\t[2, 2]\t[3, 2]\t[3, 3]\t[null]\t\n"
				+ "[null]\t[4, 2]\t[3, 2]\t[4, 2]\t[4, 3]\t[null]\t\n"
				+ "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n";
		// Sample debugging output:
		// System.out.println("G11");
		// System.out.println("Expected:");
		// System.out.println(correctParentString);
		// System.out.println("Actual:");
		// System.out.println(brain.testing_toStringParent());
		assertEquals(correctParentString, parentString);
	}

}
