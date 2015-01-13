/**
 * @author: Team 2 (Kienbauer, Kienbauer, Kolb)
 * UE Software Engineering WS 2014
 * Tetris @version 1.0
 */
public class Cell {
	/**
	 * Objekte dieser Klasse sind die Bestandteile des Spielfelds, siehe in {@Field}
	 * Ein Cell-Objekt besteht aus einem Booleanwert und die Form des Spielsteins, von dem die Spielfeld-Zelle besetzt ist
	 * (Falls Sie von dem Teil eines Spielsteins besetzt ist). Das Spielfeld besetht also sozusagen aus einem Array von Wahrheitswerten
	 * @see Field
	 * @param s = speichert die Form des Spielsteines, falls ein Teil eines Spielsteines die Zelle besetzt, siehe in {@link Shape}, wird benötigt zum Ausgeben, welcher Stein sich auf dem Spielfeld befindet, siehe in {@link Field#printField()} 
	 * @see Shape
	 * @see Field#printField() 
	 */
    private Shape s;  
    
    /**
	 * @param isEmpty = speichert die Form des Spielsteines, falls ein Teil eines Spielsteines die Zelle besetzt 
	 */
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
   	 * @return gibt die Form des Spielsteines zur&uuml;ck (sofern die Zelle von dem Teil eines Spielsteins besetzt ist) 
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
   	 * @return gibt zur&uuml;ck OB die Zelle von dem Teil eines Spielsteines besetzt ist 
   	 */
    
    public boolean getIsEmpty(){
        return isEmpty;
    }

} // end class Cell
