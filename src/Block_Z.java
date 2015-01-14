/**
* @author: Team 2 (Kienbauer, Kienbauer, Kolb)
 * UE Software Engineering WS 2014
 * Tetris @version 1.0
 */

/**
 * Diese Klasse ist eine der Spielsteinvarianten, welche festgelegt ist in der Shape-Enum, siehe  {@link Shape}
 */

public class Block_Z extends Block {

    public Block_Z(Shape s) {
    	super(s);
        block = new boolean[2][3];
        block[0][0] = true;
        block[0][1] = true;
        block[1][1] = true;
        block[1][2] = true;

    }
}
