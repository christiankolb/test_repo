/**
 * @author: Team 2 (Kienbauer, Kienbauer, Kolb)
 * Tetris @version 1.0
 * 
 */
public class Cell {
	/**
	 * Objekte dieser Klasse sind die Bestandteile des Spielfelds 
	 * @link Field
	 * @param s  = speichert die Form des Spielsteines, falls ein Teil eines Spielsteines die Zelle besetzt @see Shape
	 */
    private Shape s;  
    private boolean isEmpty;

    /**
	 * @param isEmpty  = speichert die Form des Spielsteines, falls ein Teil eines Spielsteines die Zelle besetzt 
	 * @see Shape
	 * @linkPlain BlockHandler
	 */
    
    public Cell(){
        isEmpty = true;
    }

    public void setShape(Shape s){
        this.s = s;
    }

    public Shape getShape(){
        return s;
    }

    public void setFull(){
        isEmpty = false;
    }

    public boolean getIsEmpty(){
        return isEmpty;
    }

}
