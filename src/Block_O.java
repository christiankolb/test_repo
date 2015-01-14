/**
* @author: Team 2 (Pepic, Kienbauer, Kolb)
 * UE Software Engineering WS 2014
 * Tetris @version 1.0
 */

/**
 * Diese Klasse ist eine der Spielsteinvarianten, welche festgelegt ist in der Shape-Enum, siehe  {@link Shape}
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

	@Override
	public boolean rotateRight(Field field) {
		return true;
	}

	@Override
	public boolean rotateLeft(Field field) {
		return true;
	}
}
