/** 
 * @author: Team 2 (Pepic, Kienbauer, Kolb)
 * UE Software Engineering WS 2014
 * Tetris 
 * @version 1.0
 */

/**
 * 
 * Die BLock-Klasse enthaelt alle Methoden zum verhalten eines Spielsteins.
 * Ausgefuehrt werden diese Methoden hauptsaechlich von der Klasse BlockHandler aus, siehe {@link BlockHandler}
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
	 * @return Gibt Gibt die Position im Feld vom Quadrat-Block des ersten K&auml;stchens oben links zurueck (Spaltenwert)
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
	

	/**
	* bewegt das Array um 1 Position nach unten im Spielfeld
	* @param field = Das Spielfeld wird hierbei uebergeben
	* @return &Uuml;berpr&uuml;ft und gibt zurueck ob die Bewegung nach unten noch moeglich ist
	*/
	////// Patricks Version
	public boolean moveDown(Field field){
		boolean possible=true;
		int x = 0;

		if(this.posrow+this.block.length == 24){
			possible = false;
			finished = true;
		}

		if(possible){
			for(int i = 0; i < block.length; i++){
				for(int j = 0; j < block[0].length; j++){
					if(block[i][j]){
						if(!field.isCellEmpty(posrow+i+1, poscol+j)){
							possible = false;
							finished = true;
						}
					}
				}
			}
		}

		if (possible){
			this.posrow++;
			return true;
		}else{
			return false;
		}
	}


	/**
	* Bewegt den Block (Spielstein) um 1 Position nach rechts
	* @param field = Das Spielfeld wird hierbei uebergeben
	* @return &Uuml;berpr&uuml;ft und gibt zurueck ob die Bewegung nach rechts noch moeglich ist
	*/
	//////Patricks Version
	public boolean moveRight(Field field){

		boolean possible=true;

		if(poscol+block.length > 10){
			possible = false;
		}

		if(possible){
			for(int i = 0; i < block.length; i++){
				for(int j = 0; j < block[0].length; j++){
					if(block[i][j]){
						if(! field.isCellEmpty(posrow+i, poscol+j+1)){
							possible = false;
						}
					}
				}
			}
		}

		if (possible){
			this.poscol++;
			return true;
		}else{
			return false;
		}
	}

	/**
	* bewegt den Block um 1 Position nach links
	* @param field = Das Spielfeld wird hierbei uebergeben
	* @return &Uuml;berpr&uuml;ft und gibt zurueck ob die Bewegung nach links noch moeglich ist
	*/
	//////Patricks Version
	public boolean moveLeft(Field field){

		boolean possible = true;

		if (poscol-1 <= 1){
			possible=false;
		}

		if(possible) {
			for(int i = 0; i < block.length; i++){
				for(int j = 0; j < block[0].length; j++){
					if(block[i][j]){
						if(! field.isCellEmpty(posrow+i, poscol+j-1)){
							possible = false;
						}
					}
				}
			}
		}
		if (possible){
			this.poscol=this.poscol-1;
			return true;
		}else{
			return false;
		}
	}

	
	/**
	* rotiert den Block nach rechts im Spielfeld
	* @param field = Spielfeld sehe {@link Field}
	* @return Gibt zurueck ob die Drehung auch durchgefuehrt werden konnte
	*/
	public boolean rotateRight(Field field){
		boolean[][] rotated = new boolean[this.block[0].length][this.block.length];
		for(int i = 0; i < this.block.length; i++){
			for(int j = 0; j < this.block[0].length; j++){
				rotated[j][this.block.length-i-1] = this.block[i][j];
			}
		}
		return this.isRotationPossible(rotated, field);
	}

	/**
	* rotiert den Block im Field nach links
	* @param field = Spielfeld sehe {@link Field}
	* @return Gibt zurueck ob die Drehung auch durchgefuehrt werden konnte
	*/
	public boolean rotateLeft(Field field){
		boolean[][] rotated = new boolean[this.block[0].length][this.block.length];
		for(int i = 0; i < this.block.length; i++){
			for(int j = 0; j < this.block[0].length; j++){
				rotated[this.block[0].length-j-1][i] = this.block[i][j];
			}
		}
		return this.isRotationPossible(rotated, field);
	}

	
	
	
	/**
	 * ueberpruefen ob drehung moeglich
	 * @param rotatet: Ist der Spielstein in rotierter Form, field ist das Spielfeld
	 * @return Gibt einen Booleanwert zurueck, der anzeigt ob er der rotierte Stein auch "Platz" hat im Spielfeld, also ob die Rotation ueberhaupt moeglich ist
	 */
	
	public boolean isRotationPossible(boolean[][] rotated,Field field) {
		boolean possible = true;
		boolean chpos = false;
		int newposcol = this.getPoscol();
		int newposrow = this.getPosrow();
		int dif;
		if (this.getPoscol() < 2) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < rotated.length; j++) {
					for (int k = 0; k < 2; k++) {
						if (rotated[j][k + i]) {
							dif = 2 - this.getPoscol();
							newposcol = this.getPoscol() + dif;
							chpos = true;
						}
					}
				}
			}

		}

		if (this.getPoscol() > 11) {
			for (int j = 0; j < rotated.length; j++) {
				for (int k = rotated.length - 1; k >= rotated.length - 2; k--) {
					if ((rotated[j][k + this.getPoscol()]) && (k + this.getPoscol() > 11)) {
						dif = this.getPoscol() - 11;
						newposcol = this.getPoscol() - dif;
						chpos = true;
					}
				}
			}
		}


		if (this.getPosrow() < 4) {
			for (int j = 0; j < rotated.length; j++) {
				for (int k = 0; k < rotated[0].length; k++) {
					if (rotated[j ][k]) {
						dif = 4 - this.getPosrow();
						newposrow = this.getPosrow() + dif;
						chpos = true;
					}
				}
			}
		}

		if (this.getPosrow() > 23) {

			for (int j = rotated.length - 1; j >= rotated.length - 2; j--) {
				for (int k = 0; k < rotated[0].length - 1; k++) {
					if ((rotated[j + this.getPosrow()][k]) && (j + this.getPosrow() > 21)) {
						dif = this.getPosrow() - 23;
						newposrow = this.getPosrow() - dif;
						chpos = true;
					}
				}
			}
		}


		for (int i = newposrow; i < (newposrow + rotated.length); i++) {
			for (int j = newposcol; j < (newposcol + rotated[0].length); j++) {
				if (!field.getField()[i][j].getIsEmpty()) {
					possible = false;
				}
			}
		}


		if (possible) {
			this.block=rotated;
			this.poscol=newposcol;
			this.posrow=newposrow;
			//System.out.println("Rotation um 90° nach " + direction);
			if(chpos){
				System.out.println("Stein wurde für die folgende Rotation ins Spielfeld gezogen");
			}
			return true;
		} else {
			//System.out.println("Rotation nach "+ direction +" nicht möglich");
			return false;
		}
	}

}
