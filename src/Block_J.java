/**
* @author: Team 2 (Pepic, Kienbauer, Kolb)
 * UE Software Engineering WS 2014
 * Tetris @version 1.0
 */

/**
 * Diese Klasse ist eine der Spielsteinvarianten, welche festgelegt ist in der Shape-Enum, siehe  {@link Shape}
 */

public class Block_J extends Block {

	public Block_J(Shape s) {
		super(s);
		block = new boolean[3][2];
		block[0][1] = true;
		block[1][1] = true;
		block[2][0] = true;
		block[2][1] = true;
	}
}

