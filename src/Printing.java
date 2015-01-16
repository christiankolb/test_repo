
public class Printing {

	

	/**
	 * Methode, welche das Spielfeld in der Kommandozeile (bzw. Shell bzw. Terminal) ausgibt
	 * Das Spielfeld ist an sich ein Array bestehend aus Cell-Objekten, ferner ein Array bestehend aus Wahrheitswerten,
	 * dennoch geben wir das Spielfeld nicht als Boolean-Werte aus, sondern als Character
	 * Dabei wird je nachdem, welchen Wert der Stein aus der {@link Shape}-Enum hat, werden
	 * andere, zum Spielstein passende, Zeichen ausgegeben.
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
	
	public void printSpawnNextBlock(Block current ){
	      System.out.println("\nNeuer Block: " + current.getShape() + ", an der Position  " + current.getPoscol() + "/" + current.getPosrow());
	      
	}
	
	public void printTryMove(int moveDis, String direction){
		 System.out.println("Versuche Bewegung um " + moveDis + " nach "+direction);
	}
	
	public void printMovePossible(int moveDis,String direction, boolean possible){
		
		if (!possible){
	       System.out.println("-- Bewegung um "+ moveDis +"nach "+direction+" nicht möglich");
		}else{
			  System.out.println("-- Bewegung um "+moveDis+" nach "+direction+" ausgeführt");
		}
		
	}
		public void printTryRotation(int degree, String direction){
			System.out.println("Versuche Rotation um " + degree + "° "+direction+" UZS");
		}
           
		public void printRotationPossible(String direction, boolean possible){
			if(!possible){
			System.out.println("-- Rotation nach "+direction+" nicht möglich");
			}else {
				System.out.println("-- Rotation nach "+direction+" möglich");
			}
		}
	public void printDeleteFullRows(int anzahl){
		System.out.println(anzahl+" vollst�ndige Reihen wurden aufgel�st.");
	}
	
	public void printRotationMove(){
		System.out.println("Stein wurde für die folgende Rotation ins Spielfeld gezogen");
	}
	
}
