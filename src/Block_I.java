/**
 * Created by patrick on 22.12.14.
 */
public class Block_I extends Block {

    public Block_I(){
        block = new boolean[4][4];
        block[0][0] = false;
        block[0][1] = true;
        block[0][2] = false;
        block[0][3] = false;
        block[1][0] = false;
        block[1][1] = true;
        block[1][2] = false;
        block[1][3] = false;
        block[2][0] = false;
        block[2][1] = true;
        block[2][2] = false;
        block[2][3] = false;
        block[3][0] = false;
        block[3][1] = true;
        block[3][2] = false;
        block[3][3] = false;
        shape = I;
    }
}
