/** 
 * @author: Team 2 (Pepic, Kienbauer, Kolb)
 * UE Software Engineering WS 2014
 * Tetris 
 * @version 1.0
 */

/**
 * Die Block-Klasse enthaelt alle Variablen, die eine Spielstein beschreiben.
 * Zu diesen Variablen sind in der Klasse auch die dazugehörigen Getter- und Setter-Methoden enthalten.
 * Die Konstruktoren der Kind-Klassen der Klasse Block (welche ja abstrakt ist) werden nur in der BlockFactory-Klasse aufgerufen,
 * Die Getter & Setter werden aber nur in der BlockHandler-Klasse aufgerufen, siehe {@link BlockHandler} .
 * Folgende Klassen erben von der Klasse Block: {@link Block_I}, {@link Block_J}, {@link Block_L}, {@link Block_O}, {@link Block_S}, {@link Block_T} und {@link Block_Z}
 */

public abstract class Block {

	protected boolean[][] block;
	
	//////////////////////////////////
	/** 
	 * posrow = Position im Feld vom Quadrat-Block des ersten Kaesstchens oben links (Zeilewert)
	 */
	private int posrow = 0;
	
	/** 
	 * poscol = Position im Feld vom Quadrat-Block des ersten Kaesstchens oben links (Spaltenwert)
	 */
	
	private int poscol = 0;
	
	/** 
	 * shape = Die Form des Steins
	 */
	
	protected Shape shape;
	
	/** 
	 * finished = Gibt an ob ein Block gesetzt wurde
	 */
	
	public boolean finished;

	public Block(){};

	public Block(Shape s)
	{
		this.shape = s;
	}

	
	/** 
	 * Methode die den Finished zurueckgibt
	 * @return true or false
	 */
	public boolean getFinished(){
		return this.finished;
	}
	
	
	/** 
	 * Setter-Methode fuer finished
	 */
	public void setFinished(boolean f){
		this.finished=f;
	}
	
	/** 
	 * Methode die den Block zurueckgibt
	 * @return Hat den Spielstein als Rueckgabewert
	 */
	
	public boolean[][] getBlock() {
		return this.block;
	}

	/** 
	 * Setter-Methode zum Blockobjekt
	 */
	
	public void setBlock(boolean[][] b) {
		this.block = b;
	}

	/** 
	 * Legt die Position im Feld vom Quadrat-Block des ersten Kaesstchens oben links fest (Zeilewert)
	 */
	
	public void setPosrow(int p) {
		this.posrow = p;
	}
	/** 
	 * Legt die Position im Feld vom Quadrat-Block des ersten Kaesstchens oben links fest (Spaltenwert)
	 */
	
	public void setPoscol(int p) {
		this.poscol = p;
	}

	/** 
	 * @return Gibt die Position im Feld vom Quadrat-Block des ersten K&auml;stchens oben links zurueck (Zeilenenwert)
	 */
	
	public int getPosrow() {
		return this.posrow;
	}

	/** 
	 * @return  Gibt die Position im Feld vom Quadrat-Block des ersten K&auml;stchens oben links zurueck (Spaltenwert)
	 */

	public int getPoscol() {
		return this.poscol;
	}

	
	/** 
	 * Legt die Form des Spielsteins fest
	 */
	
	
	public void setShape(Shape s) {
		this.shape = s;
	}

	/** 
	 * @return Gibt die Form des Spielsteins zurueck
	 */
	
	public Shape getShape() {
		return this.shape;
	}
	

}
