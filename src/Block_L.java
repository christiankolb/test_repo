/**
 * Created by patrick on 22.12.14.
 */
public class Block_L extends Block {

	public Block_L(Shape s) {
		super(s);
		block = new boolean[3][3];
		block[0][1] = true;
		block[1][1] = true;
		block[2][1] = true;
		block[2][2] = true;

		System.out.println("New L");
	}
}
