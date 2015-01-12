/**
 * Created by patrick on 18.12.14.
 */
public class GameApp {

	public static void main(String[] args) {

		Field field = new Field();
		BlockHandler handler = new BlockHandler(field);



while(!handler.isGameOver()){
	handler.spawnNextBlock();
	while(!handler.getCurrentFinished()) {

		handler.waitFor();
		handler.standardMoveDown();
		handler.moveBlock();
	//	handler.rotateBlock();

	}

		field.printField();
	}
}}
