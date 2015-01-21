



import static org.junit.Assert.*;

import java.util.Random;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MovesTest {

	private Moves moves;
	private Printing printing;
	private Random rand;
	// private BlockFactory factory;
	private Field field;
	private Block current;
	// private boolean currentFinished;
	// private BlockHandler handler;
	
	@Before
	public void setUp() throws Exception 
	{
		moves = new Moves();
		printing= new Printing();
		rand= new Random();
		// factory= new BlockFactory();
		field = new Field();
		current = new Block_S(Shape.S);
		// handler = new BlockHandler(field, printing);
	}
	
	@org.junit.Test 
	public void TestMoveLeft(){

		// testet ob eine Bewegung nach links mit beliebigen Werten (im positiven Wertebereich, sprich ohne die Rand-Spalten z.B.) durchführbar ist
		
		boolean possible = true;
		current.setPoscol( rand.nextInt((12 - 3) + 1) + 3 ); // Zufallszahlen anlegen für die Spalten und Zeilenposition
		current.setPosrow( rand.nextInt((20 - 1) + 1) + 1 );
		
		int original_col = current.getPoscol();
		// int original_row = current.getPosrow();
		
		
		for(int i = 0; i < current.getBlock().length; i++)
		{
			for(int j = 0; j < current.getBlock()[0].length; j++)
			{
				if(current.getBlock()[i][j])
				{
						if(! field.isCellEmpty(current.getPosrow()+i, current.getPoscol()+j-1))
						{
							possible = false;
						}
					} // end for2
				}
			} // end for1
		
		if (possible)
		{
			current.setPoscol(current.getPoscol()-1);
		} 
		
		assertTrue(current.getPoscol() == original_col-1);
		
	} // end TestMoveLeft

	@Test
	public void TestRotateRight(){
		
		assertFalse(current.getShape() == Shape.O);
	
		boolean[][] rotated = new boolean[current.getBlock()[0].length][current.getBlock().length];
		for(int i = 0; i < current.getBlock().length; i++){
			for(int j = 0; j < current.getBlock()[0].length; j++){
				rotated[j][current.getBlock().length-i-1] = current.getBlock()[i][j];
			}
		}
		
		assertArrayEquals(rotated, current.getBlock()); 
		// return this.isRotationPossible(rotated, field,current);
	} // end TestRotateRight
	
	@Test
	public void test() {
		fail("This is a stub");
	}

} // end MovesTest
