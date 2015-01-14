/**
* @author: Team 2 (Kienbauer, Kienbauer, Kolb)
 * UE Software Engineering WS 2014
 * Tetris @version 1.0
 */

/**
 * Diese Klasse ist eine der Spielsteinvarianten, welche festgelegt ist in der Shape-Enum, siehe  {@link Shape}
 */

public class Block_L extends Block {

	public Block_L(Shape s) {
		super(s);
		block = new boolean[3][2];
		block[0][0] = true;
		block[1][0] = true;
		block[2][0] = true;
		block[2][1] = true;
	}
}
