/**
 * Created by patrick on 22.12.14.
 */
public class Block_S extends Block {

	public Block_S(Shape s) {
		super(s);
		block = new boolean[2][3];
		block[0][1] = true;
		block[0][2] = true;
		block[1][0] = true;
		block[1][1] = true;

		System.out.println("New S");
	}
}