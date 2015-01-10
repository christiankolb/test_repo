/**
 * Created by patrick on 07.01.15.
 */
public class BlockFactory {

    public BlockFactory() {}


    //erzeugt die entsprechenden Blöcke
    public Block createNewBlock(int shape){

        switch(shape){
            case 0:
                return new Block_I(Shape.I);
            case 1:
                return new Block_J(Shape.J);
            case 2:
                return new Block_L(Shape.L);
            case 3:
                return new Block_O(Shape.O);
            case 4:
                return new Block_S(Shape.S);
            case 5:
                return new Block_T(Shape.T);
            case 6:
                return new Block_Z(Shape.Z);
            default:
                return null;
        }
    }
}
