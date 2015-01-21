import static org.junit.Assert.*;
import java.util.Random;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class MovesTest {

	private Moves moves;
	private Printing printing;
	private Random rand;
	// private BlockFactory factory;
	private Field field;
	private Block current;
	private int poscol;
	private int posrow;
	// private boolean currentFinished;
	// private BlockHandler handler;
	private boolean movepossible;
	private int rotate;
	
	@Before
	public void setUp() throws Exception 
	{
		moves = new Moves();
		printing= new Printing();
		rand= new Random();
		// factory= new BlockFactory();
		field = new Field();
		current = new Block_J(Shape.J);
		poscol=0;
		posrow=0;
		rotate=0;
		
		// handler = new BlockHandler(field, printing);
	}

	@After
	public void tearDown(){}
	
	@org.junit.Test 
	public void TestMoveLeft(){

		// testet ob eine Bewegung nach links mit beliebigen Werten (im positiven Wertebereich, sprich ohne die Rand-Spalten z.B.) durchführbar ist
		poscol=6;
		posrow=10;
		current.setPosrow(posrow);
		current.setPoscol(poscol);
		
		movepossible=moves.moveLeft(field, current);
		assertTrue(movepossible);
		assertEquals(poscol-1,current.getPoscol());
		
		//testet ob eine Bewegung nach links im ung�ltigen Bereich abgewiesen wird
		//An der Stelle 10/4 w�rde der Block dann anfangen, aber dieser ist nicht ausgef�llt,
		//da beim Standard J die ersten zwei vertikalen K�stchen frei sind
		
		field.getField()[10][4].setFull();
		movepossible=moves.moveLeft(field, current);
		assertTrue(movepossible);
		assertEquals(poscol-2,current.getPoscol());
		
		
		//testet ob eine Bewegung nach links im ung�ltigen Bereich abgewiesen wird
		//An der Stelle 10/4 f�ngt der Block an und soll nicht nach links k�nnen, da sonst ein Teil
		//des Blocks einen Teil des ausgef�llten Feldes �berlappen w�rde
		
		movepossible=moves.moveLeft(field, current);
		assertFalse(movepossible);
		assertEquals(poscol-2,current.getPoscol());
		
		
		//�berpr�ft, ob Bewegung abgewiesen wird, wenn Stein am linken Rand ist
		poscol=2;
		posrow=6;
		current.setPosrow(posrow);
		current.setPoscol(poscol);
		movepossible=moves.moveLeft(field, current);
		assertFalse(movepossible);
		assertEquals(poscol,current.getPoscol());
		
		
		
	} // end TestMoveLeft
	
	
	@org.junit.Test 
	public void TestMoveRight(){

		// testet ob eine Bewegung nach rechts mit beliebigen Werten (im positiven Wertebereich, sprich ohne die Rand-Spalten z.B.) durchführbar ist
		current = new Block_L(Shape.L);
		poscol=6;
		posrow=10;
		current.setPosrow(posrow);
		current.setPoscol(poscol);
		
		movepossible=moves.moveRight(field, current);
		assertTrue(movepossible);
		assertEquals(poscol+1,current.getPoscol());
		
		//testet ob eine Bewegung nach rechts im ung�ltigen Bereich abgewiesen wird
		//An der Stelle 10/8 w�rde der Block sich ebenfalls befinden, aber dieser Teil ist nicht ausgef�llt,
		//da beim Standard L die letzten zwei vertikalen K�stchen von oben frei sind
		
		field.getField()[10][9].setFull();
		movepossible=moves.moveRight(field, current);
		assertTrue(movepossible);
		assertEquals(poscol+2,current.getPoscol());
		
		
		//testet ob eine Bewegung nach rechts im ung�ltigen Bereich abgewiesen wird
		//An der Stelle 10/9 befindet sich ein Teil des Blcoks und soll nicht nach rechts k�nnen, da sonst ein Teil
		//des Blocks einen Teil des ausgef�llten Feldes �berlappen w�rde
		
		movepossible=moves.moveRight(field, current);
		assertFalse(movepossible);
		assertEquals(poscol+2,current.getPoscol());
		
		
		
	} // end TestMoveRight
	
	@org.junit.Test 
	public void testMoveDown(){

		// testet ob eine Bewegung nach unten mit beliebigen Werten (im positiven Wertebereich, sprich ohne die Rand-Spalten z.B.) durchführbar ist
		current = new Block_L(Shape.L);
		poscol=6;
		posrow=10;
		current.setPosrow(posrow);
		current.setPoscol(poscol);
		
		movepossible=moves.moveDown(field, current);
		assertTrue(movepossible);
		assertEquals(posrow+1,current.getPosrow());
		
		//testet ob eine Bewegung nach unten im ung�ltigen Bereich abgewiesen wird
		//An der Stelle 10/10 befindet sich ein ausgef�lltes K�stchen im Feld
		
		field.getField()[14][6].setFull();
		movepossible=moves.moveDown(field, current);
		assertFalse(movepossible);
		assertEquals(posrow+1,current.getPosrow());
		
		//testet ob eine Bewegung nach unten im ung�ltigen Bereich (am Boden) abgewiesen wird
		poscol=2;
		posrow=21;
		current.setPosrow(posrow);
		current.setPoscol(poscol);
		movepossible=moves.moveDown(field, current);
		assertFalse(movepossible);
		assertEquals(posrow,current.getPosrow());
	
		
		
		
	} // end testMoveDown

	@Test
	public void TestRotateRight(){
	
		//testet die Drehung nach rechts im g�ltigen Bereich
		poscol=5;
		posrow=10;
		current.setPosrow(posrow);
		current.setPoscol(poscol);
		rotate= moves.rotateRight(field, current);
		assertEquals(1, rotate);
		
		//testet die Drehung nach rechts, wenn ein abgesetzter Stein sich an der neuen Position befindet
		current=new Block_J(Shape.J);
		poscol=5;
		posrow=10;
		current.setPosrow(posrow);
		current.setPoscol(poscol);
		field.getField()[11][7].setFull();
		rotate=moves.rotateRight(field,current);
		assertEquals(2,rotate);
		
		//testet die Drehung nach rechts am Rand, sollte reingezogen werden
		current=new Block_J(Shape.J);
		poscol=10;
		posrow=10;
		current.setPosrow(posrow);
		current.setPoscol(poscol);
		rotate= moves.rotateRight(field, current);
		assertEquals(0, rotate);
			
	} // end TestRotateRight
	
	@Test
	public void testRotateLeft(){
		//testet die Drehung nach links im g�ltigen Bereich
		poscol=5;
		posrow=10;
		current.setPosrow(posrow);
		current.setPoscol(poscol);
		rotate= moves.rotateLeft(field, current);
		assertEquals(1, rotate);
		
		//testet die Drehung nach links, wenn ein abgesetzter Stein sich an der neuen Position befindet
		current=new Block_J(Shape.J);
		poscol=5;
		posrow=10;
		current.setPosrow(posrow);
		current.setPoscol(poscol);
		field.getField()[11][5].setFull();
		rotate=moves.rotateLeft(field,current);
		assertEquals(2,rotate);
		
		//testet die Drehung nach links am Rand, sollte reingezogen werden
		current=new Block_J(Shape.J);
		poscol=1;
		posrow=10;
		current.setPosrow(posrow);
		current.setPoscol(poscol);
		rotate= moves.rotateRight(field, current);
		assertEquals(0, rotate);
	
	} // end testRotateLeft

} // end MovesTest
