/**
 * Created by patrick on 18.12.14.
 */
public class GameApp {

	public static void main(String[] args) {

		Field field = new Field();
		BlockHandler handler = new BlockHandler(field);



	while(!handler.isGameOver()){
		handler.spawnNextBlock();

		//handler.rotateBlock();
	//	handler.moveBlock();
		while(!handler.getCurrentFinished()) {
			handler.standardMoveDown();
			handler.waitFor();

			handler.moveBlock();
			

			handler.rotateBlock();

		}

			field.printField();
		}
	}
}
