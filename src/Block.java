/**
 * Created by patrick on 22.12.14.
 */
public abstract class Block {

    protected boolean[][] block;

    public Block(){

    }

    // dreht das array 90° nach rechts
    public Block rotateRight(){
        boolean[][] rotated = new boolean[block.length][block.length];
        for(int i = 0; i < block.length; i++){
            for(int j = 0; j < block.length; j++){
                rotated[i][j] = block[block.length-j-1][i];
            }
        }
       // block = rotated;
        return rotated;
    }


    // dreht das array 90° nach links
    public Block rotateLeft(){
        boolean[][] rotated = new boolean[block.length][block.length];

        for(int i = block.length-1; i >= 0; i--){
            for(int j = block.length-1; j >= 0; j--){
                rotated[i][j] = block[j][block.length-i-1];
            }
        }
       // block = rotated;
        return rotated;
    }


    //// zu testzwecken ////
    public void printBlock(){
        System.out.println();
        for(int i = 0; i < block.length; i++){
            System.out.println();
            for(int j = 0; j < block.length; j++){
                if(block[i][j] == false) {
                    System.out.print("o");
                }else{
                    System.out.print("x");
                }
            }
        }
    }

}
