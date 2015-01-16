/**
* @author: Team 2 (Pepic, Kienbauer, Kolb)
 * UE Software Engineering WS 2014
 * Tetris @version 1.0
 */

/**
 * Diese Klasse ist eine der Spielsteinvarianten, welche festgelegt ist in der Shape-Enum, siehe  {@link Shape}
 * Ist Kind-Klasse der Klasse Block, siehe {@link Block}. Ihr Konstruktor wird aufgerufen in der Klasse {@link BlockFactory}.
 * Alle Methoden die definieren, wie sich dieser Block verh&auml;t oder verhalten kann, stehen in der Klasse {@link Moves}, aufgerufen werden diese Methoden jedoch in der Klasse BlockHandler, siehe {@link BlockHandler}
 * Folgende Klassen sind Kind-Klassen der Klasse Block: {@link Block_I}, {@link Block_J}, {@link Block_L}, {@link Block_O}, {@link Block_S}, {@link Block_T} und {@link Block_Z}
 */

public class Block_O extends Block {

	public Block_O(Shape s) {
		
		super(s);
		
		block = new boolean[2][2];
		block[0][0] = true;
		block[0][1] = true;
		block[1][0] = true;
		block[1][1] = true;
	}


}
