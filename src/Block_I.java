/**
 * Created by patrick on 22.12.14.
 */
public class Block_I extends Block {

	public Block_I(Shape s){
		super(s);
        block = new boolean[4][1];
        block[0][0] = true;
        block[1][0] = true;
        block[2][0] = true;
        block[3][0] = true;

        System.out.println("New I");
	}
}
