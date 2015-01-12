/**
 * Created by patrick on 18.12.14.
 */


public class Field {

	private final int TOTAL_HEIGHT = 26;
	private final int HEIGHT = 20;
	private final int WIDTH = 10;
	private final int TOTAL_WIDTH = 14;
	private Cell[][] field;


	public Field() {
		field = new Cell[TOTAL_HEIGHT][TOTAL_WIDTH];
		for (int i = 0; i < TOTAL_HEIGHT; i++) {
			for (int j = 0; j < TOTAL_WIDTH; j++) {
				field[i][j] = new Cell();
			}
		}
	} // end field

	public boolean isCellEmpty(int i, int j) {
		return field[i][j].getIsEmpty();
	}

	public void deleteFullRows() {
		boolean isFull;
		for (int i = 4; i < TOTAL_HEIGHT - 2; i++) {
			isFull = false;
			for (int j = 2; j < TOTAL_WIDTH - 2; j++) {
				if (!field[i][j].getIsEmpty()) {
					isFull = true;
				} else {
					isFull = false;
				}
			}
			if (isFull) {
				Cell[] rowprev = new Cell[TOTAL_WIDTH];
				Cell[] rownext = new Cell[TOTAL_WIDTH];
				for (int k = 4; k < i; k++) {
					for (int l = 0; l < TOTAL_WIDTH; l++) {
						rowprev[l] = field[k - 1][l];
						rownext[l] = field[k][l];
						field[k][l]= rowprev[l]; //war auskommentiert -> ev weil zuvor falsch geschrieben ("roprev")
					}
				}
				System.out.println("Vollständige Reihe aufgelöst.");
			}
		}

	}



	public Cell[][] getField() {
		return field;
	}

	public void printField() {
		System.out.print("\n");
		for (int i = 4; i < TOTAL_HEIGHT - 2; i++){ // 4 wegen dem "unsichtbaren" Bereich
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

/*
	public void printField() {
		System.out.print("\n");
		for (int i = 0; i < field.length; i++){
			System.out.print("\n");
			for (int j = 0; j < field[i].length; j++) {
				if (field[i][j].getIsEmpty()) {
					System.out.print('o');
				} else {
					System.out.print('x');
				}
			}
		}
		System.out.print("\n");

	}*/
}