import java.util.Random;

/**
 * Created by patrick on 18.12.14.
 */
public class BlockHandler {

    private Random rand;
    private int randomNum;
    private Field field;
    private BlockFactory factory;
    private final int MILLIS = 1000; //Wartezeit
    private Block current;
    private boolean currentFinished; // zur überprüfung, ob stein abgesetzt

    public BlockHandler(Field field){
        rand = new Random();
        this.field = field;
        factory = new BlockFactory();
    }

    public void spawnNextBlock(){
        current = factory.createNewBlock(randomNumber(6,0));
        current.setPosrow(0);
        current.setPoscol(5- (current.getBlock().length/2));
    }

    public void moveBlock(){
        int move = randomNumber(3,0);

        for(int i = 0; i < move; i++){
            //TODO move block
            waitFor();
        }
    }

    public void moveDown(){
      //TODO  block um 1 nach unten
    }

    // random drehen von aktuellem Stein
    public void rotateBlock(){
        int rotation = randomNumber(4,-4);

        // drehung nach links
        if(rotation >= -4 && rotation < 0){
            for(int i = 0; i < rotation * -1; i++){
                boolean[][] rotated = current.rotateLeft();
                field.isPossible(rotated, current);
            }
        }

        // drehung nach rechts
        if(rotation <= 4 && rotation > 0){
            for(int i = 0; i < rotation * -1; i++){
                boolean[][] rotated=  current.rotateRight();
                field.isPossible(rotated, current);
            }
        }
    }

    //nach jeder aktion checken ob gameover
    public boolean isGameOver(){
    	for (int i=0; i<4; i++){
    		for (int j=0; j<14; j++){
    			if (!field.getField()[i][j].getIsEmpty()){
                    return true;
                }
    		}
    	}
    	return false;
    } // end isGameOver

    // erzeugt zufällige zahl für neue blöcke (0-6) oder rotation (-4-4) oder bewegung (0-3)
    private int randomNumber(int max, int min){
        randomNum = rand.nextInt((max-min) + 1) + min;
        return randomNum;
    }

    // stoppt die ausführung für bestimmte zeit
    public void waitFor() {
        try {
            Thread.sleep(MILLIS);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    //ohne �berpr�fung ob Absetzung
    // nach absetzen im field "verewigen" [cell.isEmpty false, cell.shape entsprechende shape], volle reihen löschen
    private void finalizeBlock(){

        //TODO

        currentFinished = true;
        field.deleteFullRows();
    }

    public boolean getCurrentFinished(){
        return currentFinished;
    }

}
