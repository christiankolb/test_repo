/**
 * @author: Team 2 (Kienbauer, Kienbauer, Kolb)
 */
public class GameApp {

	public static void main(String[] args) {

		Field field = new Field();
		BlockHandler handler = new BlockHandler(field);

		while(!handler.isGameOver()){
			handler.spawnNextBlock();

			handler.standardMoveDown();
			handler.standardMoveDown();
			handler.standardMoveDown();

			handler.moveBlock();
			handler.rotateBlock();


			while(!handler.getCurrentFinished()) {
				handler.standardMoveDown();
			}
		}
		System.out.println("*** GAMEOVER ***");
		field.printField();
	}
}
