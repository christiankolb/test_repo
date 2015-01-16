
public class Printing {

	

	/**
	 * Methode, welche das Spielfeld in der Kommandozeile (bzw. Shell bzw. Terminal) ausgibt
	 * Das Spielfeld ist an sich ein Array bestehend aus Cell-Objekten, ferner ein Array bestehend aus Wahrheitswerten,
	 * dennoch geben wir das Spielfeld nicht als Boolean-Werte aus, sondern als Character
	 * Dabei wird je nachdem, welchen Wert der Stein aus der {@link Shape}-Enum hat, werden
	 * andere, zum Spielstein passende, Zeichen ausgegeben.
	 * @param field: Feld, welches gedruckt wird
	 */
	
	public void printField(Field field) {
		System.out.print("\n");
		for (int i = 4; i < field.getTotalHeight() - 2; i++){
			System.out.print("\n");
			for (int j = 2; j < field.getTotalWidth() - 2; j++) {
				if (field.getField()[i][j].getIsEmpty()) {
					System.out.print('.');
				} else {
					if(field.getField()[i][j].getShape() == Shape.I){
						System.out.print("I");
					}
					if(field.getField()[i][j].getShape() == Shape.J){
						System.out.print("J");
					}
					if(field.getField()[i][j].getShape() == Shape.L){
						System.out.print("L");
					}
					if(field.getField()[i][j].getShape() == Shape.O){
						System.out.print("O");
					}
					if(field.getField()[i][j].getShape() == Shape.S){
						System.out.print("S");
					}
					if(field.getField()[i][j].getShape() == Shape.T){
						System.out.print("T");
					}
					if(field.getField()[i][j].getShape() == Shape.Z){
						System.out.print("Z");
					}
				}

			}
		}
		System.out.print("\n");

	} // end printField
	
	
	/**
	 * Druckt Informationen �ber den n�chsten Block
	 * @param current: der n�chste Block
	 */
	public void printSpawnNextBlock(Block current ){
	      System.out.println("\nNeuer Block: " + current.getShape() + ", an der Position  " + current.getPoscol() + "/" + current.getPosrow());
	      
	}
	
	
	/**
	 * Druckt den Versuch der Bewegung
	 * @param moveDis: Anzahl der K�stchen, die bewegt wurden
	 * @param direction: Richtung der Bewegung
	 */
	public void printTryMove(int moveDis, String direction){
		 System.out.println("Versuche Bewegung um " + moveDis + " nach "+direction);
	}
	
	
	/**
	 * Druckt ob die Bewegung m�glich war
	 * @param moveDis: Anzahl der K�stchen, die bewegt wurden
	 * @param direction: Richtung der Bewegung
	 * @param possible: ob es m�glich war
	 * 	 */
	public void printMovePossible(int moveDis,String direction, boolean possible){
		
		if (!possible){
	       System.out.println("-- Bewegung um "+ moveDis +"nach "+direction+" nicht möglich");
		}else{
			  System.out.println("-- Bewegung um "+moveDis+" nach "+direction+" ausgeführt");
		}
		
	}
	
	/**
	 * Druckt den Versuch der Rotation
	 * @param degree: Grad der Rotation
	 * @param direction: Richtung der Rotation
	 *  */
		public void printTryRotation(int degree, String direction){
			System.out.println("Versuche Rotation um " + degree + "° "+direction+" UZS");
		}
		
		
		/**
		 * Druckt, ob Rotation m�glich ist
		 * @param direction: Richtung der Rotation
		 * @param possible: war die Rotation m�glich
		 */
           
		public void printRotationPossible(String direction, boolean possible){
			if(!possible){
			System.out.println("-- Rotation nach "+direction+" nicht möglich");
			}else {
				System.out.println("-- Rotation nach "+direction+" möglich");
			}
		}
		
		/**
		 * Druckt, wenn Reihen aufgel�st worden sind
		 * @param anzahl: Anzahl der Reihen
	 */
	public void printDeleteFullRows(int anzahl){
		System.out.println(anzahl+" vollst�ndige Reihen wurden aufgel�st.");
	}
	
	/**
	 * Druckt, wenn ein Stein nach der Rotation ins Spielfeld gezogen wurde
	 */
	public void printRotationMove(){
		System.out.println("Stein wurde für die folgende Rotation ins Spielfeld gezogen");
	}
	
}
