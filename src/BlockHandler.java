import java.util.Random;

/**
 * Created by patrick on 18.12.14.
 */
public class BlockHandler {

    private Random rand;
    private boolean isGameOver;
    private int randomNum;
    private Field field;
    private BlockFactory factory;
    private final int MILLIS = 1000; //Wartezeit
    private Block current;


    // diverse initialisierungen
    public BlockHandler(Field field){
        isGameOver = false;
        rand = new Random();
        this.field = field;
        factory = new BlockFactory();
    }

    // spawnen von random Steinen; Bedingung ev in GameApp prüfen (while != gameover)
    public void spawnNextBlock(){
        current = factory.createNewBlock(randomNumber(6,0));
        current.setPosrow(0);
        current.setPoscol(5- (current.getBlock().length/2));
    }

    // random bewegen von aktuellem Stein
    public void moveBlock(){
    	int move = randomNumber(3,0);
    }

    // random drehen von aktuellem Stein
    public void rotateBlock(){
        int rotation = randomNumber(4,-4);

        // drehung nach links
        if(rotation >= -4 && rotation < 0){
            for(int i = 0; i < rotation * -1; i++){
             //   current.rotateLeft();
            	boolean[][] rotated = current.rotateLeft();
           field.isPossible(rotated, current);
                //TODO prüfen ob neue drehung gültig, ansonsten zurück nach rechts drehen und abbrechen
            }
        }

        // drehung nach rechts
        if(rotation <= 4 && rotation > 0){
            for(int i = 0; i < rotation * -1; i++){
              boolean[][] rotated=  current.rotateRight();
             field.isPossible(rotated, current);
                //TODO prüfen ob neue drehung gültig, ansonsten zurück nach links drehen und abbrechen
            }
        }

        // bei 0 keine drehung

    }

    //nach jeder aktion checken ob gameover
    public boolean isGameOver(){
    	for (int i=0; i<4; i++){
    		for (int j=0; j<14; j++){
    			if (!field.getField()[i][j].getIsEmpty()) return true;
    			
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
    private void waitFor(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    //ohne �berpr�fung ob Absetzung
    // nach absetzen im field "verewigen" [cell.isEmpty false, cell.shape entsprechende shape], volle reihen löschen
    private void finalizeBlock(){
        //TODO stein verewigen
    	
        //volle reihen löschen, nachrücken
         field.deleteFullRows();
    }

}



/////////// zum anregungen holen /////////

  /*  public boolean moveRight(Field field) {
        for(int i = 0; i < cell.length; i++){
            cell[i].setX(cell[i].getX()+1);
        }
        if(!field.isNewPositionValid(cell)){
            for(int i = 0; i < cell.length; i++){
                cell[i].setX(cell[i].getX()-1);
            }
            return true;
        }else{
            return false;
        }
    }

    public boolean moveLeft(Field field) {
        for(int i = 0; i < cell.length; i++){
            cell[i].setX(cell[i].getX()-1);
        }
        if(!field.isNewPositionValid(cell)){
            for(int i = 0; i < cell.length; i++) {
                cell[i].setX(cell[i].getX()+1);
            }
            return true;
        }else{
            return false;
        }
    }

    public boolean moveDown(Field field) {
        for(int i = 0; i < cell.length; i++){
            cell[i].setY(cell[i].getY()-1);
        }
        if(!field.isNewPositionValid(cell)){
            for(int i = 0; i < cell.length; i++){
                cell[i].setY(cell[i].getY()+1);
            }
            return true;
        }else{
            return false;
        }
    }

    protected void setCoordinates(int cellNo, int x, int y){
        cell[cellNo].setX(x);
        cell[cellNo].setY(y);
    }
    */