/**
 * Created by patrick on 22.12.14.
 */
public abstract class Block {

	protected boolean[][] block;
	private int posrow = 0;
	private int poscol = 0;
	protected Shape shape;

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

	// dreht das array 90° nach rechts
	public boolean[][] rotateRight() {
		boolean[][] rotated = new boolean[block.length][block.length];
		for (int i = 0; i < block.length; i++) {
			for (int j = 0; j < block.length; j++) {
				rotated[i][j] = block[block.length - j - 1][i];
			}
		}
		// block = rotated;
		return rotated;
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

	// dreht das array 90° nach links
	public boolean[][] rotateLeft() {
		boolean[][] rotated = new boolean[block.length][block.length];

		for (int i = block.length - 1; i >= 0; i--) {
			for (int j = block.length - 1; j >= 0; j--) {
				rotated[i][j] = block[j][block.length - i - 1];
			}
		}
		// block = rotated;
		return rotated;
	}

	// // zu testzwecken ////
	public void printBlock() {
		System.out.println();
		for (int i = 0; i < block.length; i++) {
			System.out.println();
			for (int j = 0; j < block.length; j++) {
				if (block[i][j] == false) {
					System.out.print("o");
				} else {
					System.out.print("x");
				}
			}
		}
	}

} // end class Block
