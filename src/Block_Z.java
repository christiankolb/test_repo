/**
 * Created by patrick on 22.12.14.
 */
public class Block_Z extends Block {

    public Block_Z(Shape s) {
    	super(s);
        block = new boolean[2][3];
        block[0][0] = true;
        block[0][1] = true;
        block[1][1] = true;
        block[1][2] = true;

        System.out.println("New Z");
    }
}
