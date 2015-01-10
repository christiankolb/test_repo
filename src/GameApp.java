/**
 * Created by patrick on 18.12.14.
 */
public class GameApp {
	// test123
	public static void main(String[] args) {

		// blockhandler

		Field Playground = new Field();
		// BlockHandler handler = new BlockHandler(Playground);

		// just some testing here
		Block i = new Block_I(Shape.I);
		Block j = new Block_J(Shape.J);
		Block l = new Block_L(Shape.L);
		Block o = new Block_O(Shape.O);
		Block s = new Block_S(Shape.S);
		Block t = new Block_T(Shape.T);
		Block z = new Block_Z(Shape.Z);

		i.printBlock();
		j.printBlock();
		l.printBlock();
		o.printBlock();
		s.printBlock();
		t.printBlock();
		z.printBlock();

		Playground.printField();
		
		System.out.println("Shape of a sample stone: " + t.getShape());
		
		if(z.getShape() == Shape.Z)
		{
			System.out.println("Shape of another sample stone: " + z.getShape());
		}
			
		/* while (!handler.isGameOver()) {
			// hier laufen lassen:
			// bewegung
			// rotation;
			// automatische bewegung nach unten
			// timer .............
		 } */
	}
}
