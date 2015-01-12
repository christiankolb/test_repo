/**
 * Created by patrick on 22.12.14.
 */
public abstract class Block {

	protected boolean[][] block;
	
	//////////////////////////////////
	// Position im Feld vom Quadrat-Block des ersten K�stchens oben links
	private int posrow = 0;
	private int poscol = 0;
	/////////////////////////////////
	protected Shape shape;
	public boolean finished;


	public Block(Shape s)
	{
		this.shape = s;
	}

	public boolean[][] getBlock() {
		return this.block;
	}

	public void setBlock(boolean[][] b) {
		this.block = b;
	}

	public void setPosrow(int p) {
		this.posrow = p;
	}

	public void setPoscol(int p) {
		this.poscol = p;
	}

	public int getPosrow() {
		return this.posrow;
	}

	public int getPoscol() {
		return this.poscol;
	}

	public void setShape(Shape s) {
		this.shape = s;
	}

	public Shape getShape() {
		return this.shape;
	}
	

	/*
	* bewegt das Array um 1 Position nach unten
	*/
	////// Dragos Version

	/*public void moveDown(Field field){
		boolean possible=true;
		if (this.posrow+1==24){
			for (int i=0; i< this.block.length;i++){
				if (this.block[this.block.length-1][i]){
					possible=false;
				}
			}
		} else if (this.posrow+1==25){
			for (int i=this.block.length-1; i>=this.block.length-2;i--){
				for (int j=0; j< this.block.length; j++){
					if(this.block[i][j]){
						possible=false;
					}
				}
			}
		}


		for (int i=this.posrow+1; i<this.posrow+1+this.block.length; i++){
			for (int j=this.poscol; j<this.poscol+this.block.length;j++){
				if (!field.isCellEmpty(i, j)){
					for (int k=0; i<this.block.length;i++){
						if (this.block[this.block.length-1][k])possible=false;
					}

				}
			}
		}
		if (possible){
			this.posrow=this.posrow+1;
		}
	}

*/

	////// Patricks Version
	public void moveDown(Field field){
		boolean possible=true;
		int x = 0;

		if(this.posrow+this.block.length == 24){
			possible = false;
			finished = true;
		}

		if(possible){
		for (int i = this.poscol; i < this.poscol+this.block[0].length; i++){

			if(!field.isCellEmpty(this.posrow+this.block.length, i)) {
				if(block[block.length-1][x]) {
					possible = false;
					finished = true;
				}
			}
			x++;
		}}

		if (possible){
			this.posrow++;
			System.out.println("moving down");
		}
	}




	/*
	* BUGGY bewegt das Array um 1 Position nach rechts
	*/
	//////Patricks Version
	/*public void moveRight(Field field){

		boolean possible=true;

		if (this.poscol+this.block[0].length ==12){
			for (int i=0; i< this.block.length;i++){
					if (!this.block[i][this.block[0].length-1]){
						possible=false;
					}
			}
		} else if (this.poscol+this.block[0].length==13){
			for (int i=0; i< this.block.length; i++){
				for (int j=this.block[0].length-1; j>=this.block[0].length-2;j--){
					if(!this.block[i][j]){
						possible=false;
						}
					}
				}
			}

		for (int j=this.poscol; j<this.poscol+this.block.length;j++){
			if (!field.isCellEmpty(this.poscol+1, j)){
				possible=false;
			}
		}

		if (possible){
			this.poscol++;
		}
	}*/

	/*
	* BUGGY bewegt das Array um 1 Position nach links
	*
	* //////Patricks Version
	*
	/*public void moveLeft(Field field){
		boolean possible=true;
		if (this.poscol-1 <= 1){
			possible=false;
		}

		if(possible) {
			int x = 0;
			for (int j = posrow; j < posrow + block.length; j++) {
				if (!field.isCellEmpty(j, poscol - 1)) {
					if (block[x][0]) {
						possible = false;
					}
					x++;
				}
			}
		}
		if (possible){
			this.poscol=this.poscol-1;
			System.out.println("moving left");
		}
	}*/

	///// Dragos Version
	//bewegt das Array um 1 Position nach links
	public void moveLeft(Field field){
		boolean possible=true;
		if (this.poscol-1==1){
			for (int i=0; i< this.block.length;i++){
				if (this.block[i][0]){
					possible=false;
				}
			}
		} else if (this.poscol-1==0){
			for (int i=0; i< this.block.length; i++){
				for (int j=0; j<2; j++){
					if(this.block[i][j]){
						possible=false;
					}
				}
			}
		}

		for (int i=this.posrow; i<this.posrow+this.block.length; i++){
			for (int j=this.poscol-1; j<this.poscol-1+this.block.length;j++){
				if (!field.isCellEmpty(i, j)){
					possible=false;
				}
			}
		}
		if (possible){
			this.poscol=this.poscol-1;
			System.out.println("moving left");
		}
	}

	////// Dragos Version
	//bewegt das Array um 1 Position nach rechts
	public void moveRight(Field field){
		boolean possible=true;
		if (this.poscol+1==12){
			for (int i=0; i< this.block.length;i++){
				if (this.block[i][this.block[0].length-1]){
					possible=false;
				}
			}
		} else if (this.poscol+1==13){
			for (int i=0; i< this.block.length; i++){
				for (int j=this.block.length-1; j>=this.block.length-2;j--){
					if(this.block[i][j]){
						possible=false;
					}
				}
			}
		}

		if(this.poscol+block[0].length+1 >= 12){
			possible = false;
		}


		for (int i=this.posrow; i<this.posrow+this.block.length; i++){
			for (int j=this.poscol; j<this.poscol+this.block[0].length;j++){
				if (!field.isCellEmpty(i, j)){
					possible=false;
				}
			}
		}
		if (possible){
			this.poscol=this.poscol+1;
			System.out.println("moving right");
		}
	}

	/*
	* rotiert array nach rechts
	*/
	public void rotateRight(Field field){
		boolean[][] rotated = new boolean[this.block[0].length][this.block.length];
		for(int i = 0; i < this.block.length; i++){
			for(int j = 0; j < this.block[0].length; j++){
				rotated[j][this.block.length-i-1] = this.block[i][j];
			}
		}
		this.isRotationPossible(rotated, field, "rechts");
	}

	/*
	* rotiert array nach links
	*/
	public void rotateLeft(Field field){
		boolean[][] rotated = new boolean[this.block[0].length][this.block.length];
		for(int i = 0; i < this.block.length; i++){
			for(int j = 0; j < this.block[0].length; j++){
				rotated[this.block[0].length-j-1][i] = this.block[i][j];
			}
		}
		this.isRotationPossible(rotated, field, "links");
	}

	/*
	*	überprüfen ob drehung möglich
	*/
	public void isRotationPossible(boolean[][] rotated,Field field, String direction) {
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
			System.out.println("Rotation nach +" + direction + "+ wurde erfolgreich ausgeführt.");
			if(chpos){
				System.out.println("Stein wurde dabei ins Spielfeld gezogen.");
			}
		} else {
			System.out.println("Rotation nicht möglich.");
		}
	}

}
