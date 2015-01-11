/**
 * Created by patrick on 18.12.14.
 */
public class GameApp {

	public static void main(String[] args) {

		Field playground = new Field();
		BlockHandler handler = new BlockHandler(playground);



		/*playground.printField();
		System.out.println("Shape of a sample stone: " + t.getShape());
		
		if(z.getShape() == Shape.Z)
		{
			System.out.println("Shape of another sample stone: " + z.getShape());
		}*/

		while (!handler.isGameOver()) {

			handler.spawnNextBlock();

			while(!handler.getCurrentFinished()) {

				handler.standardMoveDown();
				handler.waitFor();

				handler.moveBlock(); //waitFor() wird in moveBlock aufgerufen

				handler.rotateBlock();
				
			}

			playground.printField();
		}
		playground.printField();
	}
}
