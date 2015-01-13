/**
 * Created by patrick on 22.12.14.
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
