import java.util.Random;

/**
 * Created by patrick on 18.12.14.
 */
public class BlockHandler {

    private Random rand;
    private int randomNum;
    private Field field;
    private BlockFactory factory;
    private Block current;
    private boolean currentFinished; // zur überprüfung, ob stein abgesetzt


    public BlockHandler(Field field){
        rand = new Random();
        this.field = field;
        factory = new BlockFactory();
    }

    public void spawnNextBlock(){
        currentFinished = false;
        current = factory.createNewBlock(randomNumber(6,0));
        current.setPosrow(0);
        current.setPoscol(4 + (current.getBlock()[0].length)/2);
        System.out.println("\nNeuer Block: " + current.getShape() + ", an der Position  " + current.getPoscol() + "/" + current.getPosrow());
    }

    //random Bewegung des aktuellen Steines
    public void moveBlock(){
        int moveDir = randomNumber(2,0);
        int moveDis = randomNumber(5,0);

        switch(moveDir){
            case 0:
                 //Bewegung nach links
                System.out.println("Versuche Bewegung um " + moveDis + " nach links");
                for(int i = 0; i < moveDis; i++) {
                    if(!current.moveLeft(field)){
                        System.out.println("-- Bewegung um 1 nach links nicht möglich");
                    }else{
                       System.out.println("-- Bewegung um 1 nach links ausgeführt");
                    }
                }
                break;
            case 1:
                 //Bewegung nach rechts
                current.moveRight(field);
                System.out.println("Versuche Bewegung um " + moveDis + " nach rechts");
                for(int i = 0; i < moveDis; i++) {
                    if(!current.moveRight(field)){
                        System.out.println("-- Bewegung um 1 nach rechts nicht möglich");
                    }else{
                        System.out.println("-- Bewegung um 1 nach rechts ausgeführt");
                    }
                }
                break;
            case 2:
                //Bewegung nach unten
                current.moveDown(field);
            default:
                break;
        }
        finalizeBlock();
    }

    public void standardMoveDown(){
        if(!current.moveDown(field)){
            System.out.println("Bewegung nach unten nicht möglich");
        }
        finalizeBlock();
    }

    // random drehen von aktuellem Stein
    public void rotateBlock(){
        int rotation = randomNumber(4,-4);
        boolean rotated;

        // drehung nach links
        if(rotation >= -4 && rotation < 0){
            System.out.println("Versuche Rotation um " + getDegree(rotation) + "° gegen den UZS");
            for(int i = 0; i < rotation * -1; i++){
                if(!current.rotateLeft(field)){
                    System.out.println("-- Rotation nach links nicht möglich");
                }else{
                    System.out.println("-- Rotation nach links ausgeführt");
                }
            }
        }

        // drehung nach rechts
        if(rotation <= 4 && rotation > 0){
            System.out.println("Versuche Rotation um " + getDegree(rotation) + "° im UZS");
            for(int i = 0; i < rotation; i++){
                if(!current.rotateRight(field)){
                    System.out.println("-- Rotation nach rechts nicht möglich");
                }else{
                    System.out.println("-- Rotation nach rechts ausgeführt");
                }
            }
        }
        finalizeBlock();
    }

    private int getDegree(int x){
        int y = 0;
        switch(x){
            case -4:case 4:
                y = 360;
                break;
            case -3:case 3:
                y = 270;
                break;
            case -2:case 2:
                y =  180;
                break;
            case -1:case 1:
                y = 90;
                break;
            case 0:
                y = 0;
                break;
        }
        return y;
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


    // nach absetzen im field "verewigen" [cell.isEmpty false, cell.shape entsprechende shape], volle reihen löschen
    private void finalizeBlock(){
    	if(current.finished){
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
