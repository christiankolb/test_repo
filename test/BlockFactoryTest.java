import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import static org.junit.Assert.*;

public class BlockFactoryTest {
private BlockFactory factory;
private Block block;
	
	@Before
	public void setUp(){
		factory= new BlockFactory();
		block=null;
	}

	@After
	public void tearDown(){}
	
    @Test
    public void testCreateNewBlock() throws Exception {
    	block=factory.createNewBlock(0);
    	assertEquals(Shape.I, block.getShape());
    	block=factory.createNewBlock(1);
    	assertEquals(Shape.J, block.getShape());
    	block=factory.createNewBlock(2);
    	assertEquals(Shape.L, block.getShape());
    	block=factory.createNewBlock(3);
    	assertEquals(Shape.O, block.getShape());
    	block=factory.createNewBlock(4);
    	assertEquals(Shape.S, block.getShape());
    	block=factory.createNewBlock(5);
    	assertEquals(Shape.T, block.getShape());
    	block=factory.createNewBlock(6);
    	assertEquals(Shape.Z, block.getShape());
    	
    }
}