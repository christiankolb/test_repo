import static org.junit.Assert.*;

import java.util.Random;

public class BlockHandlerTest {
private Moves moves;
private Printing printing;
private Random rand;
private BlockFactory factory;
private Field field;
private Block current;
private boolean currentFinished;
private BlockHandler handler;


    @org.junit.Before
    public void setUp() throws Exception {
    	
    	moves= new Moves();
    	printing= new Printing();
    	rand= new Random();
    	factory= new BlockFactory();
    	field = new Field();
    	current=null;
    	handler = new BlockHandler(field, printing);
    }


    @org.junit.Test //soll zeigen, dass neuer Stein gespawned  u nicht der alte weiterverwendet wird
    public void testSpawnNextBlock() throws Exception {
        current= factory.createNewBlock(1);
        Block last = current;
        current = factory.createNewBlock(1);
        assertEquals(false, current == last);
    }

    @org.junit.Test //zeigt, dass der aktuelle Stein bewegt wurde. Egal ob links,rechts,abwärts
    public void testMoveBlock() throws Exception {
       /* current = factory.createNewBlock(5);
        handler.setCurrent(current);
        handler.getCurrent().setPosrow(0); //Standardwert wie in spawnNextBlock()
        handler.getCurrent().setPoscol(4); //Standardwert wie in spawnNextBlock();

        int prevPoscol = handler.getCurrent().getPoscol();
        handler.moveBlock(0,3); //0 für bewegung nach links, 3 für drei kästchen
        assertEquals(prevPoscol - 2, handler.getCurrent().getPoscol()); //prevPoscol-2, da Bewegung um 3 nicht erlaubt ist

        prevPoscol = handler.getCurrent().getPoscol();
        handler.moveBlock(1,9); //1 für bewegung nach links, 9 für neun kästchen
        assertEquals(prevPoscol+7, handler.getCurrent().getPoscol()); //prevPoscol+7, da Bewegung um 9 nicht erlaubt ist

        int prevPosrow = handler.getCurrent().getPosrow();
        handler.moveBlock(2,11); //2 für bewegung nach  unten; 11 bedeutungslos, da nur 1 kästchen bei abwärts vorgesehen ist
        assertEquals(prevPosrow+1, handler.getCurrent().getPosrow());
    */

        current = factory.createNewBlock(5);
        handler.setCurrent(current);
        current.setPoscol(4); //Standardwert wie in spawnNext()
        current.setPosrow(0); //Standardwert wie in spawnNext()
        int prevRow = current.getPosrow();
        int prevCol = current.getPoscol();
        handler.moveBlock();
        System.out.println(prevCol);
        System.out.println(current.getPoscol());
        assertEquals(true, (current.getPosrow() != prevRow || current.getPoscol() != prevCol));
    }

    @org.junit.Test
    public void testStandardMoveDown() throws Exception {
        current = factory.createNewBlock(3);
        handler.setCurrent(current);
        int prevPosrow = handler.getCurrent().getPosrow();
        handler.standardMoveDown();
        handler.standardMoveDown();
        assertEquals(prevPosrow+2, current.getPosrow());
    }



    @org.junit.Test
    public void testIsGameOver() throws Exception {
        field.getField()[2][3].setFull(); //eine Cell erste Reihe über Spielfeld true -> Gameover
        handler = new BlockHandler(field,printing);
        assertTrue(handler.isGameOver());
    }

    @org.junit.Test
    public void testGetCurrentFinished() throws Exception {
        current=factory.createNewBlock(1); //erzeugt neuen Stein der Höhe 3
        current.setPosrow(21); //bewegt Stein bis 1 Reihe über Spielfeldrand
        handler.setCurrent(current);
        handler.standardMoveDown(); //1x noch nach unten, damit currentFinished gesetzt u somit getestet werden kann
        assertTrue(handler.getCurrentFinished());
    }
    
  
}