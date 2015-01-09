/**
 * Created by patrick on 22.12.14.
 */
public class Block_O extends Block {

    public Block_O(){
        block = new boolean[2][2];
        block[0][0] = true;
        block[0][1] = true;
        block[1][0] = true;
        block[1][1] = true;
        
        shape = O;
    }

    // keine drehung notwending
    @Override
    public void rotateRight() {

    }

    // keine drehung notwending
    @Override
    public void rotateLeft() {
    }
}
