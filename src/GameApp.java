/**
 * Created by patrick on 18.12.14.
 */
public class GameApp {
//test123
    public static void main(String[] args){
 
        //blockhandler

		Field Playground = new Field();
		Blockhandler handler= new Blockhandler();
	
        //just some testing here
        Block i = new Block_I();
        Block j = new Block_J();
        Block l = new Block_L();
        Block o = new Block_O();
        Block s = new Block_S();
        Block t = new Block_T();
        Block z = new Block_Z();

        i.printBlock();
        j.printBlock();
        l.printBlock();
        o.printBlock();
        s.printBlock();
        t.printBlock();
        z.printBlock();

		Playground.printField();

		while (!handler.isGameOver()){
			//hier laufen lassen:
			//bewegung
			//rotation
			//automatische bewegung nach unten
			//timer
		}
    }
}
