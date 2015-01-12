import java.util.Random;

/**
 * Created by patrick on 18.12.14.
 */
public class BlockHandler {

    private Random rand;
    private int randomNum;
    private Field field;
    private BlockFactory factory;
    private final int MILLIS = 10; //Wartezeit
    private Block current;
    private boolean currentFinished; // zur überprüfung, ob stein abgesetzt


    public BlockHandler(Field field){
        this.field = field;
        factory = new BlockFactory();
    }

    public void spawnNextBlock(){
        currentFinished = false;
      current = factory.createNewBlock(randomNumber(6,0));
        //current = factory.createNewBlock(5);
        current.setPosrow(0);
        current.setPoscol(4 + (current.getBlock()[0].length)/2);
    }

    //random Bewegung des aktuellen Steines
    public void moveBlock(){
        int move = randomNumber(1,0);
       // int move = 1;
        switch(move){
            case 0:
                 //Bewegung nach links
                current.moveLeft(field);
                break;
            case 1:
                 //Bewegung nach rechts
                current.moveRight(field);
                break;
            default:
            	current.moveDown(field);
                break;
        }
        finalizeBlock();
    }

    public void standardMoveDown(){
        current.moveDown(field);
        finalizeBlock();
    }

    // random drehen von aktuellem Stein
    public void rotateBlock(){
        int rotation = randomNumber(4,-4);

        // drehung nach links
        if(rotation >= -4 && rotation < 0){
            for(int i = 0; i < rotation * -1; i++){
              current.rotateLeft(field);
                
            }
        }

        // drehung nach rechts
        if(rotation <= 4 && rotation > 0){
            for(int i = 0; i < rotation ; i++){
                 current.rotateRight(field);
               
            }
        }
        finalizeBlock();
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
    	rand= new Random();
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


    // nach absetzen im field "verewigen" [cell.isEmpty false, cell.shape entsprechende shape], volle reihen löschen
    private void finalizeBlock(){
    	if(current.finished){
    	//if(current.getPosrow()+1>23){
            for (int i=0;i<current.block.length;i++){
            	for (int j=0; j<current.block[0].length;j++){
            		if (current.block[i][j]){
            			field.getField()[current.getPosrow()+i][current.getPoscol()+j].setFull();
            			field.getField()[current.getPosrow()+i][current.getPoscol()+j].setShape(current.getShape());
            		}
            	}
            }
            currentFinished = true;
            field.deleteFullRows();
    	}//end if
    }

    public boolean getCurrentFinished(){
        return currentFinished;
    }

}
