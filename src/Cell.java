/**
 * @author: Team 2 (Kienbauer, Kienbauer, Kolb)
 * Tetris @version 1.0
 * 
 */
public class Cell {
	/**
	 * Objekte dieser Klasse sind die Bestandteile des Spielfelds @See Field
	 * @see Field
	 * @param isEmpty  = speichert die Form des Spielsteines, falls ein Teil eines Spielsteines die Zelle besetzt 
	 * @see Shape
	 * @param s  = speichert die Form des Spielsteines, falls ein Teil eines Spielsteines die Zelle besetzt @see Shape
	 */
    private Shape s;  
    private boolean isEmpty;


    public Cell(){
        isEmpty = true;
    }

    /** 
   	 * Legt die Form des Spielsteines fest (sofern die Zelle von dem Teil eines Spielsteins besetzt wird)
   	 * 
   	 * {@link Block#moveLeft(Field)}
   	 * {@linkPlain Block#moveRight(Field)}
   	 */
    
    public void setShape(Shape s){
        this.s = s;
    }

    /** 
   	 * @return gibt die Form des Spielsteines zurück (sofern die Zelle von dem Teil eines Spielsteins besetzt ist) 
   	 */
    
    public Shape getShape(){
        return s;
    }

    /** 
   	 * Legt fest dass die Zelle von dem Teil eines Spielsteins besetzt wird
   	 */
    
    public void setFull(){
        isEmpty = false;
    }

    /** 
   	 * @return gibt zurück OB die Zelle von dem Teil eines Spielsteines besetzt ist 
   	 */
    
    public boolean getIsEmpty(){
        return isEmpty;
    }

}
