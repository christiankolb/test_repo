/**
 * Created by patrick on 22.12.14.
 */
public class Block_I extends Block {

	public Block_I(Shape s){
		super(s);
        block = new boolean[4][4];
        block[0][1] = true;
        block[1][1] = true;
        block[2][1] = true;
        block[3][1] = true;
	}
}
