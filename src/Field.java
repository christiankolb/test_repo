/** 
 * @author: Team 2 (Pepic, Kienbauer, Kolb)
 * UE Software Engineering WS 2014
 * Tetris 
 * @version 1.0
 */


/**
 * Die Field-Klasse stellt das Spielfeld dar. Es besteht aus Cell-Objekten (siehe {@link Cell}), initialisiert wird es in der Testklasse {@link GameApp}
 * Das Spielfeld wird der BlockHandler zugewiesen, siehe im Konstruktor der Klasse BlockHandler ({@link BlockHandler} und von dort aus mit Spielsteinen bef&uuml;llt.
 * In dieser Klasse befinden sich jedoch die Methoden zum L&ouml;schen der mit Spielsteinen vollen Reihen {@link #deleteFullRows()} und zum Ausgeben des Spielfelds {@link #printField} 
 *
 */

public class Field {

	/**
	 * Die Gesamth&ouml;he des Spielfelds. Dabei gelten die vier ersten Reihen als f&uuml; den/die SpielerIn unsichtbarer Bereich zum Spawnen des Steins,
	 * zwei Reihen, die sich unterhalb des sichtbaren Spielfeld befinden, dienen als unsichtbare Reihen die lediglich das Absetzen und Drehen vereinfachen sollen.
	 */
	
	private final int TOTAL_HEIGHT = 26;
	
	/**
	 * Die Gesamtbreite des Spielfelds. Dabei gelten die ersten zwei Spalten links und die letzten zwei Spalten rechts als f&uuml; den/die SpielerIn unsichtbarer Bereich,
	 * Diese insgesamt vier unsichtbaren Spalten sollen dazu dienen, das Drehen und die Seitenbwegung der Steine einfacher implementieren zu k&ouml;nnen.
	 */
	
	private final int TOTAL_WIDTH = 14;
	
	/**
	 * Das Array, aus dem das Spielfeld besteht, siehe dazu {@link Cell}
	 */
	
	private Cell[][] field;

	public Field() {
		field = new Cell[TOTAL_HEIGHT][TOTAL_WIDTH];
		for (int i = 0; i < TOTAL_HEIGHT; i++) {
			for (int j = 0; j < TOTAL_WIDTH; j++) {
				field[i][j] = new Cell();
			}
		}
	} // end field

	/**
	 * Methode, welche eine einzele Zelle abfragt, ob sie leer ist
	 * @param i Steht fuer den X-Wert (die Zeile) in der die Zelle in dem Cell-Array steckt
	 * @param j Steht fuer den Y-Wert (die Spalte) in der die Zelle in dem Cell-Array steckt
	 * @return Gibt zurueck, ob eine Zelle mit einem Teil von einem Spielstein besetzt ist oder nicht
	 */
	
	public boolean isCellEmpty(int i, int j) {
		return field[i][j].getIsEmpty();
	}

	/**
	 * Methode, welche volle Zeilen loescht und die restlichen quasi "nach unten" r&uuml;ckt
	 */
	
	public void deleteFullRows() {
		boolean isFull;
		boolean skip;
		for (int i = 4; i < TOTAL_HEIGHT - 2; i++) {
			isFull = false;
			skip = false;
			for (int j = 2; j < TOTAL_WIDTH - 2; j++) {
				if(skip){j++;}
				if (field[i][j].getIsEmpty()) {
					isFull = false;
					skip = true;
				}
			}
			if (isFull) {
				Cell[] rowprev = new Cell[TOTAL_WIDTH];
				Cell[] rownext = new Cell[TOTAL_WIDTH];
				for (int k = 4; k < i; k++) {
					for (int l = 0; l < TOTAL_WIDTH; l++) {
						rowprev[l] = field[k - 1][l];
						rownext[l] = field[k][l];
						field[k][l]= rowprev[l];
					}
				}
				System.out.println("Vollständige Reihe aufgelöst.");
			}
		}
	}

	/**
	 * Methode, welches das Cell-Array, als das Spielfeld ausgibt
	 * @return Gibt das Spielfeld zur&uuml;ck
	 */
	

	public Cell[][] getField() {
		return field;
	}

	/**
	 * Methode, welche das Spielfeld in der Kommandozeile (bzw. Shell bzw. Terminal) ausgibt
	 * Das Spielfeld ist an sich ein Array bestehend aus Cell-Objekten, ferner ein Array bestehend aus Wahrheitswerten,
	 * dennoch geben wir das Spielfeld nicht als Boolean-Werte aus, sondern als Character
	 * Dabei wird je nachdem, welchen Wert der Stein aus der {@link Shape}-Enum hat, werden
	 * andere, zum Spielstein passende, Zeichen ausgegeben.
	 */
	
	public void printField() {
		System.out.print("\n");
		for (int i = 4; i < TOTAL_HEIGHT - 2; i++){
			System.out.print("\n");
			for (int j = 2; j < TOTAL_WIDTH - 2; j++) {
				if (field[i][j].getIsEmpty()) {
					System.out.print('.');
				} else {
					if(field[i][j].getShape() == Shape.I){
						System.out.print("I");
					}
					if(field[i][j].getShape() == Shape.J){
						System.out.print("J");
					}
					if(field[i][j].getShape() == Shape.L){
						System.out.print("L");
					}
					if(field[i][j].getShape() == Shape.O){
						System.out.print("O");
					}
					if(field[i][j].getShape() == Shape.S){
						System.out.print("S");
					}
					if(field[i][j].getShape() == Shape.T){
						System.out.print("T");
					}
					if(field[i][j].getShape() == Shape.Z){
						System.out.print("Z");
					}
				}

			}
		}
		System.out.print("\n");

	} // end printField
} // end class Field