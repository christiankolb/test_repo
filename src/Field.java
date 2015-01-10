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

	public boolean isCellEmpty(int x, int y) {
		return field[x][y].getIsEmpty();
	}

	public void deleteFullRows() {
		boolean isFull = false;
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

	//überprüfen ob drehung möglich
	public Block isPossible(boolean[][] rotated, Block current) {
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
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < rotated.length; j++) {
					for (int k = 0; k < rotated.length; k++) {
						if (rotated[j + i][k]) {
							dif = 4 - current.getPosrow();
							newposrow = current.getPosrow() + dif;
							chpos = true;
						}
					}
				}
			}

		}

		if (current.getPosrow() > 23) {

			for (int j = rotated.length - 1; j >= rotated.length - 2; j--) {
				for (int k = 0; k < rotated.length - 1; k++) {
					if ((rotated[j + current.getPosrow()][k]) && (j + current.getPosrow() > 21)) {
						dif = current.getPosrow() - 23;
						newposrow = current.getPosrow() - dif;
						chpos = true;
					}
				}
			}
		}


		for (int i = newposrow; i < (newposrow + rotated.length); i++) {
			for (int j = newposcol; j < (newposcol + rotated.length); j++) {
				if (!this.field[i][j].getIsEmpty()) {
					possible = false;
				}
			}
		}


		if (possible) {
			current.setBlock(rotated);
			current.setPoscol(newposcol);
			current.setPosrow(newposrow);
			System.out.println("Rotation wurde erfolgreich ausgeführt.");
			if (chpos) System.out.println("Stein wurde dabei ins Spielfeld gezogen.");
		} else {
			System.out.println("Rotation nicht m�glich.");
		}

		return current;
	}

	public Cell[][] getField() {
		return field;
	}

	public void printField() {
		System.out.print("\n");
		for (int i = 4; i < TOTAL_HEIGHT - 2; i++) // 4 wegen dem "unsichtbaren" Bereich
		{
			System.out.print("\n");

			for (int j = 2; j < TOTAL_WIDTH - 2; j++) {
				if (field[i][j].getIsEmpty()) {
					System.out.print('o');
				} else {

					System.out.print('x');
				}
			}
		}
		System.out.print("\n");

	} // end printField

}