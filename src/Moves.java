
public class Moves {
Printing printing;

public Moves(){
	printing= new Printing();
}
	
//////Patricks Version
	public boolean moveDown(Field field, Block current){
		boolean possible=true;
		int x = 0;
		

		if(current.getPosrow()+current.getBlock().length == 24){
			possible = false;
			current.setFinished(true);
		}

		if(possible){
			for(int i = 0; i < current.getBlock().length; i++){
				for(int j = 0; j < current.getBlock()[0].length; j++){
					if(current.getBlock()[i][j]){
						if(!field.isCellEmpty(current.getPosrow()+i+1, current.getPoscol()+j)){
							possible = false;
							current.setFinished(true);
						}
					}
				}
			}
		}

		if (possible){
			current.setPosrow(current.getPosrow()+1);
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
	public boolean moveRight(Field field, Block current){

		boolean possible=true;

		if(current.getPoscol()+current.getBlock().length > 10){
			possible = false;
		}

		if(possible){
			for(int i = 0; i < current.getBlock().length; i++){
				for(int j = 0; j < current.getBlock()[0].length; j++){
					if(current.getBlock()[i][j]){
						if(! field.isCellEmpty(current.getPosrow()+i, current.getPoscol()+j+1)){
							possible = false;
						}
					}
				}
			}
		}

		if (possible){
			current.setPoscol(current.getPoscol()+1);
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
	public boolean moveLeft(Field field, Block current){

		boolean possible = true;

		if (current.getPoscol()-1 <= 1){
			possible=false;
		}

		if(possible) {
			for(int i = 0; i < current.getBlock().length; i++){
				for(int j = 0; j < current.getBlock()[0].length; j++){
					if(current.getBlock()[i][j]){
						if(! field.isCellEmpty(current.getPosrow()+i, current.getPoscol()+j-1)){
							possible = false;
						}
					}
				}
			}
		}
		if (possible){
			current.setPoscol(current.getPoscol()-1);
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
	public boolean rotateRight(Field field, Block current){
		if(current.getShape().equals("O")){
			return true;
		} else {
		boolean[][] rotated = new boolean[current.getBlock()[0].length][current.getBlock().length];
		for(int i = 0; i < current.getBlock().length; i++){
			for(int j = 0; j < current.getBlock()[0].length; j++){
				rotated[j][current.getBlock().length-i-1] = current.getBlock()[i][j];
			}
		}
		return this.isRotationPossible(rotated, field,current);
		}
	}

	/**
	* rotiert den Block im Field nach links
	* @param field = Spielfeld sehe {@link Field}
	* @return Gibt zurueck ob die Drehung auch durchgefuehrt werden konnte
	*/
	public boolean rotateLeft(Field field, Block current){
		if(current.getShape().equals("O")){
			return true;
		} else{
		boolean[][] rotated = new boolean[current.getBlock()[0].length][current.getBlock().length];
		for(int i = 0; i < current.getBlock().length; i++){
			for(int j = 0; j < current.getBlock()[0].length; j++){
				rotated[current.getBlock()[0].length-j-1][i] = current.getBlock()[i][j];
			}
		}
		return this.isRotationPossible(rotated, field, current);
		}
	}

	
	
	
	/**
	 * ueberpruefen ob drehung moeglich
	 * @param rotatet: Ist der Spielstein in rotierter Form, field ist das Spielfeld
	 * @return Gibt einen Booleanwert zurueck, der anzeigt ob er der rotierte Stein auch "Platz" hat im Spielfeld, also ob die Rotation ueberhaupt moeglich ist
	 */
	
	public boolean isRotationPossible(boolean[][] rotated,Field field, Block current) {
		boolean possible = true;
		boolean chpos = false;
		int newposcol = current.getPoscol();
		int newposrow = current.getPosrow();
		int dif;
		if (current.getPoscol() < 2) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < rotated.length; j++) {
					for (int k = 0; k < 2; k++) {
						if (rotated[j][k + i]) {
							dif = 2 - current.getPoscol();
							newposcol = current.getPoscol() + dif;
							chpos = true;
						}
					}
				}
			}

		}

		if (current.getPoscol() > 11) {
			for (int j = 0; j < rotated.length; j++) {
				for (int k = rotated.length - 1; k >= rotated.length - 2; k--) {
					if ((rotated[j][k + current.getPoscol()]) && (k + current.getPoscol() > 11)) {
						dif = current.getPoscol() - 11;
						newposcol = current.getPoscol() - dif;
						chpos = true;
					}
				}
			}
		}


		if (current.getPosrow() < 4) {
			for (int j = 0; j < rotated.length; j++) {
				for (int k = 0; k < rotated[0].length; k++) {
					if (rotated[j ][k]) {
						dif = 4 - current.getPosrow();
						newposrow = current.getPosrow() + dif;
						chpos = true;
					}
				}
			}
		}

		if (current.getPosrow() > 23) {

			for (int j = rotated.length - 1; j >= rotated.length - 2; j--) {
				for (int k = 0; k < rotated[0].length - 1; k++) {
					if ((rotated[j + current.getPosrow()][k]) && (j + current.getPosrow() > 21)) {
						dif = current.getPosrow() - 23;
						newposrow = current.getPosrow() - dif;
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
			current.setBlock(rotated);
			current.setPoscol(newposcol);
			current.setPosrow(newposrow);
			//System.out.println("Rotation um 90° nach " + direction);
			if(chpos){
				printing.printRotationMove();
			}
			return true;
		} else {
			//System.out.println("Rotation nach "+ direction +" nicht möglich");
			return false;
		}
	}

}
