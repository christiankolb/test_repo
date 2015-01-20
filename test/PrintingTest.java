import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class PrintingTest {
private Printing printing;
private Field field;
private Block current;
private BlockFactory factory;
private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();;


@Before
public void initTest(){
	factory = new BlockFactory();
	printing= new Printing();
	field= new Field();
	current= factory.createNewBlock(1);
	System.setOut(new PrintStream(outContent));
	
	
}


@After
public void endTest(){
	    System.setOut(null);
	}


@Test
public void testPrintSpawnNextBlock(){
	printing.printSpawnNextBlock(current);
	assertEquals("\nNeuer Block: " + current.getShape() + ", an der Position  " + current.getPoscol() + "/" + current.getPosrow(),outContent.toString());
}



@Test
public void testPrintRotationPossible(){
	printing.printRotationPossible("links",0);
	assertEquals("-- Rotation nach links möglich\nDer Spielstin wurde dabei wieder in das Feld gezogen.",outContent.toString());
	printing.printRotationPossible("rechts",1);
	assertEquals("-- Rotation nach rechts möglich",outContent.toString());
	printing.printRotationPossible("links",2);
	assertEquals("-- Rotation nach links nicht möglich", outContent.toString());



}
}
