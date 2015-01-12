/**
 * Created by patrick on 22.12.14.
 */
public class Block_J extends Block {

	public Block_J(Shape s) {
		super(s);
		block = new boolean[3][2];
		block[0][1] = true;
		block[1][1] = true;
		block[2][0] = true;
		block[2][1] = true;

		System.out.println("New J");
	}
}

