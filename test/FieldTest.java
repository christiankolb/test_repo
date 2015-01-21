import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class FieldTest {
	private Field field;
	 
	
	@Before
	public void setUp(){
		field = new Field();
	}

	@After
	public void tearDown(){
	}
	

    @Test
    public void testIsCellEmpty() throws Exception {
    	assertTrue(field.isCellEmpty(10, 6));
    	field.getField()[10][6].setFull();
    	assertFalse(field.isCellEmpty(10,6));
    	assertTrue(field.isCellEmpty(11,6));
    }

    @Test
    public void testDeleteFullRows() throws Exception {
    	assertEquals(0,field.deleteFullRows());
    	for (int i=2; i<12;i++){
    		field.getField()[10][i].setFull();
    	}
    	assertEquals(1,field.deleteFullRows());
    	
    	for (int j=10; j<12; j++){
    	for (int i=2; i<12;i++){
    		field.getField()[j][i].setFull();
    	}
    	}
    	assertEquals(2,field.deleteFullRows());
    	
    }

}