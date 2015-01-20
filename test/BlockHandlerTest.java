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

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void testSpawnNextBlock() throws Exception {

    }

    @org.junit.Test
    public void testMoveBlock() throws Exception {

    }

    @org.junit.Test
    public void testStandardMoveDown() throws Exception {

    }

    @org.junit.Test
    public void testRotateBlock() throws Exception {

    }

    @org.junit.Test
    public void testIsGameOver() throws Exception {

    }

    @org.junit.Test
    public void testGetCurrentFinished() throws Exception {

    }
}