/**
 * Created by patrick on 18.12.14.
 */


public class Field {

    private final int TOTAL_HEIGHT = 26;
    private final int HEIGHT = 20;
    private final int WIDTH = 10;
    private final int TOTAL_WIDTH=14;
    private Cell[][] field;


     public Field(){
        field = new Cell[TOTAL_HEIGHT][TOTAL_WIDTH];
        for(int i = 0; i < TOTAL_HEIGHT; i++){
            for(int j = 0; j < TOTAL_WIDTH; j++){
                field[i][j] = new Cell();
            }
        }
    } // end field

    public boolean isCellEmpty(int x, int y){
        return field[x][y].getIsEmpty();
    }

    public void deleteFullRows(){
        //TODO implementieren
    	boolean isFull= false;
    	for (int i=4; i< TOTAL_HEIGHT-2; i++){
    		isFull=false;
    		for (int j=2; j< TOTAL_WIDTH-2; j++){
    			if (!field[i][j].getIsEmpty){
    				isFull=true;
    			} else {
    				isFull=false;
    			}
    		}
    		if (isFull){
    			Cell[] rowprev = new Cell[TOTAL_WIDTH];
    			Cell[] rownext = new Cell[TOTAL_WIDTH];
    			for (int k=4; k< i; k++){
    	    		for (int l=0; l< TOTAL_WIDTH; l++){
    	    			rowprev[l]=field[k-1][l];
    	    			rownext[l]=field[k][l];
    	    			field[k][l]=roprev[l];
    	    		}
    			}
    		}
    	}
    	
    }
    
    
    //Überprüfen, ob die Drehung möglich ist
    public boolean isPossible(boolean[][] rotated, Block current){
    	boolean possible=true;
    	int newposcol =current.getPoscol();
    	int newposrow = current.getPosrow();
    	int dif;
    	if (current.getPoscol() <2 ){
    		for (int i= 0, i <2, i++ ){
    			for (int j=0, j< rotated.length, j++){
    				for (int k=0, k<2,k++){
    					if (rotated[j][k+i]){
    						dif= 2 - current.getPoscol();
    			    		newposcol= current.getPoscol()+dif;
    					}
    				}
    			}
    		}
    		
    	}
    	
    	if (current.getPoscol() >11){
    		for (int i= 13, i >11, i-- ){
    			for (int j=0, j< rotated.length, j++){
    				for (int k= rotated.length-1, k>rotated.length-3,k--){
    					if (rotated[j][k+current.getPoscol()]){
    						dif = current.getPoscol()-11;
    						newposcol=current.getPoscol()-dif;
    					}
    				}
    			}
    		}
    	}
    	
    	if (current.getPosrow()<4){
    		dif = 4-current.getPosrow();
    		newposrow=current.getPosrow()+dif;
    	}
    	
    	if (current.getPosrow()>23){
    		dif= current.getPosrow()-23;
    		newposrow=current.getPosrow()-dif;
    	}
    	
    	for (int i=current.getPosrow(); i< (current.getPosrow()+rotated.length); i++){
    		for (int j=current.getPoscol(); j<(current.getPoscol()+rotated.length); j++){
    			if (!this.field[i][j].getIsEmpty()){
    				possible=false;
    			}
    		}
    	}
    	
    }


    // array wird normalerweise von oben nach unten abgearbeitet, tetris von unten nach oben -> methode ev hilfreich
    private int convertY(int y){
        return TOTAL_HEIGHT - y;
    }

    public Cell[][] getField()
	{
		return field;
	}
	
	public void printField()
	{
		System.out.print("\n");
		for(int i = 4; i < TOTAL_HEIGHT-2; i++) // 4 wegen dem "unsichtbaren" Bereich
		{
			System.out.print("\n");
			
			for(int j = 2; j < TOTAL_WIDTH-2; j++)
			{
				if(field[i][j].getIsEmpty())
				{
					System.out.print('o');
				}
				else
				{
				    System.out.print('x');
				}
			}
		}
	} // end printField


    ///////// Anregungen
    /*


    public boolean isNewPositionValid(Cell[] cell){
        for(int i = 0; i < cell.length; i++){
            if(!isCellInsideField(cell[i])){
                return false;
            }

            if(field[cell[i].getX()][convertY(cell[i].getY())] != null){
                return false;
            }
        }
        return true;
    }

    private boolean isCellInsideField(Cell cell){
        if(cell.getX() < 0 || cell.getX() > 9 || convertY(cell.getY()) < 0){
            return false;
        }else{
            return true;
        }
    }

    public void setCell(Cell cell){
        field[cell.getX()][convertY(cell.getY())] = cell;
    }

    public void deleteFullRows(){
        boolean rowFull = false;
        for(int i = 0; i < HEIGHT; i++){
            for(int j = 0; j < WIDTH; j++){
                if(field[i][j] == null){
                    rowFull = false;
                    break;
                }else{
                    rowFull = true;
                }
            }
            if(rowFull){
                deleteRow(i);
            }
        }
        if(rowFull){
            moveUp();
        }
    }

    private void deleteRow(int row){
        for(int i = 0; i < WIDTH; i++){
            field[row][i] = null;
        }
    }

    /////////nachrÃ¼cken von steinen -> wenn reihen gelÃ¶scht wurden... nicht fertig
    private void moveUp(){
        boolean rowEmpty = false;
        for(int i = HEIGHT-1; i >= 0; i--){
            for(int j = 0; j < WIDTH; j++){
                if(field[i][j] != null){
                    rowEmpty = false;
                    break;
                }else{
                    rowEmpty = true;
                }
            }
            if(rowEmpty){

            }
        }
    }

    public boolean isCellEmpty(int x, int y){
        if(field[x][convertY(y)]==null){
            return true;
        }else{
            return false;
        }
    }
    */
}
