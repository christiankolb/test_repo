/** 
 * @author: Team 2 (Pepic, Kienbauer, Kolb)
 * UE Software Engineering WS 2014
 * Tetris 
 * @version 1.0
 */
public class GameApp{

/**
 * Dies ist die Testklasse des Tetrisspiels mit der main-Methode
 * 
 * Sie erzeugt einen Blockhandler und das Spielfeld, welches dem Blockhandler &uuml;bergeben wird
 * Siehe: {@link BlockHandler} und {@link Field}
 * Danach werden in einer while-Schleife ( while(!handler.isGameOver() , siehe {@link BlockHandler#isGameOver) folgende Methoden in der Reihenfolge ausgef&uuml;hrt:
 * 1. {@link BlockHandler#isGameOver}, 2. Drei mal die Methode {@link BlockHandler#standardMoveDown}, 3. Seitenbewegung ( {@link BlockHandler#moveBlock} ), 4. Rotation ( {@link BlockHandler#rotateBlock} )
 * Danach werden noch einige Standardbewegungen nach untern ausgef&uuml;hrt ( while(!handler.getCurrentFinished()) {handler.standardMoveDown();} ), 
 * bis der Stein am Boden oder auf einen andern Boden aufprallt, danach wird die ursprüngliche Schleife von vorn begonnen:  
 */
	
	
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
	} // end main method
} // end class GameApp
