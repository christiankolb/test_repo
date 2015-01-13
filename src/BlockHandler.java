import java.util.Random;

/**
 * @author: Team 2 (Kienbauer, Kienbauer, Kolb)
 * UE Software Engineering WS 2014
 * Tetris @version 1.0
 */

public class BlockHandler {

	 /**
     *  Die Klasse BlockHandler ist die Klasse, welche zentral das Spiel steuert.
     *  In ihr wird durch Zufalls-Zahlgenerator bestimmt, welche Steine produziert werden und welche Aktion des Steins ausgeführt wird, siehe: {@link randomNumber} {@link spawnNextBlock} {@link moveBlock}
     *  Sie erzeugt einerseits die Spielsteine, indem Sie auf die Blockfactory zugreift, wo die Steine erzeugt werden, siehe: {@link spawnNextBlock}
     *  Sie steuert auch das Verhalten der Steine, sprich sie f&uuml;hrt die Methoden der Block-Klasse aus, siehe: {@link moveBlock} {@link #standardMoveDown} {@link rotateBlock} {@link Block}
     *	Nicht zuletzt setzt die Spielsteine auf das SPielfeld, siehe {@link #finalizeBlock}
     *
     * @param rand = Zufallswert, der anhand der java.util.Random-Bibliothek erstellt wird, siehe {@like #randomNumber}
     * @param randomNum = Integer-Variable, in der Random rand gespeichert wird, siehe {@like #randomNumber}
     */
	
	
    private Random rand;
    private int randomNum;
    

	 /**
	  * @param field Initialisiert das Spielfeld, siehe {@link Field} 
      */
    
    private Field field;
    
    /**
	  * @param BlockFactory =  Initialisiert die BlockFactory, siehe {@link #spawnNextBlock} und {@link BlockFactory}
     */
    
    private BlockFactory factory;
    
    /**
	  * @param current = Initialisiert das Spielfeld, siehe {@link #spawnNextBlock} und {@link Block} 
     */
    
    private Block current;
   
    /**
	  * @param boolean = Wahrheitswert zur überprüfung, ob stein abgesetzt ist, siehe {@link #finalizeBlock} und {@link #getCurrentFinished}
     */
    
    private boolean currentFinished; 


    public BlockHandler(Field field){
        rand = new Random();
        this.field = field;
        factory = new BlockFactory();
    }

    /**
     * Hier wird der n&auml;chste Spielstein erzeugt. Welche Spielsteinart, das wird die anhand einer Zufallszahl entschieden, siehe {@link #randomNumber}
     * Nach dem Erzeugen der Zufallszahl, wir diese an die Blockfactory &uuml;bergeben, um den entsprechenden Stein zu erzeugen, siehe {@link BlockFactory#createNewBlock()}
     * Danach wir die anfaengliche Position des Steins noch in der Methde festgelegt, in dem setPosrow und setPoscol des erzeugten Spielsteins aufgerufen werden, siehe {@link Block#setPosrow} und {@link Block#setPoscol}
     */
    
    public void spawnNextBlock(){
        currentFinished = false;
        current = factory.createNewBlock(randomNumber(6,0));
        current.setPosrow(0);
        current.setPoscol(4 + (current.getBlock()[0].length)/2);
        System.out.println("\nNeuer Block: " + current.getShape() + ", an der Position  " + current.getPoscol() + "/" + current.getPosrow());
    }

    /**
     * Macht eine Bewegung, die anhand einer Zufallszahl entschieden wird {@link #randomNumber}
     * Ruft am Ende die Methode zum endg&uuml;ltigen Platzierung des Steines auf, siehe {@link #finalizeBlock}
     */
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

    /**
     * F&uuml;hrt die regelm&auml;&szlig;ige (Standard-)Bewegung des Spielsteins nach unten aus, die immer erfolgt bis der Stein gesetzt ist.
     */
    public void standardMoveDown(){
        if(!current.moveDown(field)){
            System.out.println("Bewegung nach unten nicht möglich");
        }
        finalizeBlock();
    }

    /**
    * Macht eine Drehung, die anhand einer Zufallszahl entschieden wird {@link #randomNumber}
    */
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

    /**
     * Mittels dieser Methode wird nach jeder Aktion &uuml;berpr&uuml;ft ob gameover eingetreten ist
     * @return gibt zur&uuml,ck ob das gameover eingetreten ist
     */
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

    /**
    * erzeugt zufällige Zahl für neue blöcke (0-6) oder rotation (-4-4) oder bewegung (0-3)
    * @return gibt eine Zufallszahl zur&uuml;ck, welche bestimmt, welche Aktion durchgef&uuml;hrt  oder welcher Spielstein als nächstes gesetzt wird, siehe: {@link #moveBlock} und {@link #spawnNextBlock()}
    */ 
    private int randomNumber(int max, int min){
        randomNum = rand.nextInt((max-min) + 1) + min;
        return randomNum;
    }

    /**
     *nach absetzen im field "verewigen" [cell.isEmpty false, cell.shape entsprechende shape], volle reihen löschen
     *F&uuml;hrt am Ende zu der Methode, die &uuml;berpr&uumlft, ob Reihen im Spielfeld voll sind oder nicht, siehe {@link Field#deleteFullRows()};
    */
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

} // end class BlockHandler
