import java.util.Random;

/**
* @author: Team 2 (Pepic, Kienbauer, Kolb)
 * UE Software Engineering WS 2014
 * Tetris @version 1.0
 */
/**
 *  Die Klasse BlockHandler ist die Klasse, welche zentral das Spiel steuert.
 *  In ihr wird durch Zufalls-Zahlgenerator bestimmt, welche Steine produziert werden und welche Aktion des Steins ausgef&uuml;hrt wird, siehe: {@link #randomNumber} {@link #spawnNextBlock} {@link #moveBlock}
 *  Sie erzeugt einerseits die Spielsteine, indem Sie auf die Blockfactory zugreift, wo die Steine erzeugt werden, siehe: {@link #spawnNextBlock}
 *  Sie steuert auch das Verhalten der Steine, sprich sie f&uuml;hrt die Methoden der Block-Klasse aus, siehe: {@link #moveBlock} {@link #standardMoveDown} {@link #rotateBlock} {@link #Block}
 *	Nicht zuletzt setzt die Spielsteine auf das Spielfeld, siehe {@link #finalizeBlock}
 *	Außerdem: Die Methoden, die zum Anzeigen des Spielfelds und der Kommentare zum Spielverlauf in der Kommandozeile (bzw. Shell oder Terminal) dienen - siehe {@link Printing}, werden auschließlich in Methoden dieser Klasse aufgerufen.
 *  
 */

public class BlockHandler {

	 /**
     * rand = Zufallswert, der anhand der java.util.Random-Bibliothek erstellt wird, siehe {@link #randomNumber}
     */
	
    private Random rand;
    
    /**
     * randomNum = Integer-Variable, in der Random rand gespeichert wird, siehe {@link #randomNumber}
     */
    
    private int randomNum;
    

	 /**
	  * field Initialisiert das Spielfeld, siehe {@link Field} 
      */
    
    private Field field;
    
    /**
	  *  BlockFactory =  Initialisiert die BlockFactory, siehe {@link #spawnNextBlock} und {@link BlockFactory}
     */
    
    private BlockFactory factory;
    
    /**
	  * Block current = Initialisiert einen Container für den Spielstein, welcher dann in der BlockFactory näher definiert wird (Definiert im Statement current = factory.createNewBlock(randomNumber(6,0)); in der Methode {@link #spawnNextBlock())
     */
    
    private Block current;
   
    /**
	  * boolean currentFinished = Wahrheitswert zur überprüfung, ob Stein abgesetzt ist, siehe {@link #finalizeBlock} und {@link #getCurrentFinished}
     */
    
    private boolean currentFinished; 
    
    /**
	  * Moves moves = seuert die Bewegungen an
    */
    private Moves moves;
    
    /**
     * *Printing printing = ist fuer das Drucken auf der Kommandozeile verantwortlich.
     */
    private Printing printing;
    
   
    /**
     * Konstruktor der BlockHandler-Klasse
     * @param field Das Spielfeld, welche von der Testklasse ( {@link GameApp} )  uebergeben wurde
     */
    


    public BlockHandler(Field field, Printing printing){
        rand = new Random();
        this.field = field;
        factory = new BlockFactory();
        moves = new Moves();
        this.printing = printing;
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
        printing.printSpawnNextBlock(current);
    }

    /**
     * Macht eine Bewegung des Spielsteins, die anhand einer Zufallszahl entschieden wird {@link #randomNumber}
     * Ruft am Ende die Methode zum endg&uuml;ltigen Platzierung des Steines auf, siehe {@link #finalizeBlock}
     */
    public void moveBlock(){
        int moveDir = randomNumber(2,0);
        int moveDis = randomNumber(5,0);

        switch(moveDir){
            case 0:
                 //Bewegung nach links
               printing.printTryMove(moveDis,"links");
                for(int i = 0; i < moveDis; i++) {
                    if(!moves.moveLeft(field,current)){
                        printing.printMovePossible(moveDis, "links",false);
                    }else{
                    	 printing.printMovePossible(moveDis,"links", true);
                    }
                }
                break;
            case 1:
                 //Bewegung nach rechts
               // moves.moveRight(field,current);
                printing.printTryMove(moveDis, "rechts");
                for(int i = 0; i < moveDis; i++) {
                    if(!moves.moveRight(field,current)){
                        printing.printMovePossible(moveDis,"rechts",false);
                    }else{
                    	printing.printMovePossible(moveDis,"rechts",true);
                    }
                }
                break;
            case 2:
                //Bewegung nach unten
            	if(!moves.moveDown(field,current)){
                   printing.printMovePossible(1,"unten", false);
                } else {
                	printing.printMovePossible(1,"unten",true);
                }
            default:
                break;
        }
        finalizeBlock();
    }

    /**
     * F&uuml;hrt die regelm&auml;&szlig;ige (Standard-)Bewegung des Spielsteins nach unten aus, die immer erfolgt bis der Stein gesetzt ist.
     */
    public void standardMoveDown(){
        if(!moves.moveDown(field,current)){
        	printing.printMovePossible(1,"unten", false);
        }
        finalizeBlock();
    }

    /**
    * Macht eine Drehung des Spielsteins, die anhand einer Zufallszahl entschieden wird {@link #randomNumber}
    */
    public void rotateBlock(){
        int rotation = randomNumber(4,-4);
        boolean rotated;

        // drehung nach links
        if(rotation >= -4 && rotation < 0){
            printing.printTryRotation(getDegree(rotation),"gegen den");
            for(int i = 0; i < rotation * -1; i++){
            	int a=moves.rotateLeft(field,current);
            	printing.printRotationPossible("links", a);
            }
               
                 
            
        }

        // drehung nach rechts
        if(rotation <= 4 && rotation > 0){
        	printing.printTryRotation(getDegree(rotation),"im");
            for(int i = 0; i < rotation; i++){
            	int a=moves.rotateRight(field,current);
                
                	printing.printRotationPossible("rechts", a);

            }
        }
        finalizeBlock();
    }

    /**
     * 
     * @return 
     */
    
    /**
     * Gibt die Gradanzahl der Spielsteindrehung anhand einer Zufallszahl aus, siehe {@link #randomNumber} und {@link #rotateBlock}
     * @param x Der Wert, der mit der Zufallszahl ermittelt wurde in {@link #rotateBlock}
     * @return Gibt die Gradanzahl zur&uuml;ck, welche dazu dient, auf der Kommandozeile (bzw. Shell oder Terminal) den/die AnwenderIn um die Gradanzahl zu informieren, um die versucht wird, den Spielstein zu drehen
     */
    
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
   
    */ 
    
    /**
     * erzeugt eine zuf&auml;llige Zahl für neue Bl&ouml;cke (0-6) oder Rotation (-4-4) oder Bewegung (0-3)
     * @param max Legt den h&ouml;chsten Wert fest, den die Zufallszahl annehmen darf
     * @param min Legt den niedrigsten Wert fest, den die Zufallszahl annehmen darf
     * @return gibt eine Zufallszahl zur&uuml;ck, welche bestimmt, welche Aktion durchgef&uuml;hrt  oder welcher Spielstein als nächstes gesetzt wird, siehe: {@link #moveBlock} und {@link #spawnNextBlock()}
     */
    private int randomNumber(int max, int min){
        randomNum = rand.nextInt((max-min) + 1) + min;
        return randomNum;
    }

    /**
     * nach absetzen im field "verewigen" [cell.isEmpty false, cell.shape entsprechende shape], volle reihen l&ouml;schen
     * F&uuml;hrt am Ende zu der Methode, die &uuml;berpr&uumlft, ob Reihen im Spielfeld voll sind oder nicht, siehe {@link Field#deleteFullRows()};
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
            int anzahl;
        anzahl=    field.deleteFullRows();
        if (anzahl!=0) printing.printDeleteFullRows(anzahl);
        
    	}//end if
    }

    /**
     * Diese Methode gibt den Wahrheitswert zur&uuml;ck, der anzeigt ob er aktuelle Spielstein abgesetzt wurde
     * @return Gibt die Variable currentFinished zur&uuml;ck, die anzeigt, ob der eraktuelle Spielstein platziert worden ist
     */
    
    public boolean getCurrentFinished(){
        return currentFinished;
    }
    
    
    /**
     * Diese Methode druckt das Spielfeld aus
     */

    public void print(){
    	this.printing.printField(this.field);
    }


    ///////////////// zusätzliche (tw modifizierte) Methoden für Unit-Tests

    /*
     * Getter für Unit-Test
     */
    public Block getCurrent(){
        return current;
    }

    /**
     * Setter für Unit-Test
     * @param current der aktuelle Stein
     */
    public void setCurrent(Block current){
        this.current = current;
    }

    /**
     * modifizierte Version der Methode moveBlock(), ohne Zufallszahlen für Unit-Test
     * @param moveDir statt Zufallszahl, Richtung in die bewegt werden soll (0 links, 1 rechts, 2 abwärts)
     * @param moveDis statt ZufallszahlAnzahl der Kästchen um die in moveDir gegebenen Kästchen bewegt werden soll
     */
    public void moveBlock(int moveDir, int moveDis){

       //Parameter anstelle von Zufallszahlen
       // int moveDir = randomNumber(2,0);
       // int moveDis = randomNumber(5,0);

        switch(moveDir){
            case 0:
                //Bewegung nach links
                printing.printTryMove(moveDis,"links");
                for(int i = 0; i < moveDis; i++) {
                    if(!moves.moveLeft(field,current)){
                        printing.printMovePossible(moveDis, "links",false);
                    }else{
                        printing.printMovePossible(moveDis,"links", true);
                    }
                }
                break;
            case 1:
                //Bewegung nach rechts
                // moves.moveRight(field,current);
                printing.printTryMove(moveDis, "rechts");
                for(int i = 0; i < moveDis; i++) {
                    if(!moves.moveRight(field,current)){
                        printing.printMovePossible(moveDis,"rechts",false);
                    }else{
                        printing.printMovePossible(moveDis,"rechts",true);
                    }
                }
                break;
            case 2:
                //Bewegung nach unten
                if(!moves.moveDown(field,current)){
                    printing.printMovePossible(1,"unten", false);
                } else {
                    printing.printMovePossible(1,"unten",true);
                }
            default:
                break;
        }
        finalizeBlock();
    }

    /**
     * modifizierte Version von rotateBlock(), ohne Zufallszahlen für Unit-Test
     * @param direction Richtung in die gedreht werden soll
     */
    public void rotateBlock(int direction){
        int rotation = randomNumber(4,-4);
        boolean rotated;

        // drehung nach links
        if(rotation >= -4 && rotation < 0){
            printing.printTryRotation(getDegree(rotation),"gegen den");
            for(int i = 0; i < rotation * -1; i++){
                int a=moves.rotateLeft(field,current);
                printing.printRotationPossible("links", a);
            }

        }

        // drehung nach rechts
        if(rotation <= 4 && rotation > 0){
            printing.printTryRotation(getDegree(rotation),"im");
            for(int i = 0; i < rotation; i++){
                int a=moves.rotateRight(field,current);

                printing.printRotationPossible("rechts", a);

            }
        }
        finalizeBlock();
    }

} // end class BlockHandler
