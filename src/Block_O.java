/**
 * Created by patrick on 22.12.14.
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
	public void rotateRight(Field field) {
		
	}

	@Override
	public void rotateLeft(Field field) {
	
	}
}
