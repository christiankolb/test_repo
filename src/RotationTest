public class RotationTest{

    public static void main(String[] args){


      /*  char [][] shape;
        shape = new char[3][2];
        shape[0][0] = 'x';
        shape[0][1] = 'o';
        shape[1][0] = 'x';
        shape[1][1] = 'o';
        shape[2][0] = 'x';
        shape[2][1] = 'x';
*/
        char[][] shape2 = new char[3][3];
        shape2[0][0] = 'o';
        shape2[0][1] = 'x';
        shape2[0][2] = 'o';
        shape2[1][0] = 'o';
        shape2[1][1] = 'x';
        shape2[1][2] = 'o';
        shape2[2][0] = 'o';
        shape2[2][1] = 'x';
        shape2[2][2] = 'x';

        System.out.println("Im UZS");
        printShape(shape2);
        printShape(rotateCwNew(shape2));
        printShape(rotateCwNew(rotateCwNew(shape2)));
        printShape(rotateCwNew(rotateCwNew(rotateCwNew(shape2))));
        printShape(rotateCwNew(rotateCwNew(rotateCwNew(rotateCwNew(shape2)))));


        System.out.println("Gegen den UZS");
        printShape(shape2);
        printShape(rotateCcw(shape2));
        printShape(rotateCcw(rotateCcw(shape2)));
        printShape(rotateCcw(rotateCcw(rotateCcw(shape2))));
        printShape(rotateCcw(rotateCcw(rotateCcw(rotateCcw(shape2)))));
    }


    static void printShape(char[][] toPrint){

        System.out.println();

        for(int i = 0; i < toPrint.length; i++){
            for(int j = 0; j < toPrint[0].length; j++){
                System.out.print(toPrint[i][j]);
            }
            System.out.println();
        }
    }

    static char[][] rotateCwNew(char[][] toRotate){  // rotateCw means rotateClockwise (im Uhrzeigersinn)
        char[][] rotated = new char[toRotate.length][toRotate.length];

        for(int i = 0; i < toRotate.length; i++){
            for(int j = 0; j < toRotate.length; j++){
                rotated[i][j] = toRotate[toRotate.length-j-1][i];
            }
        }

        return rotated;
    }

    static char[][] rotateCcw(char[][] toRotate) {  // rotateCcw means rotateCounterclockwise (gegen den Uhrzeigersinn)
        char[][] rotated = new char[toRotate.length][toRotate.length];

        for(int i = toRotate.length-1; i >= 0; i--){
            for(int j = toRotate.length-1; j >= 0; j--){
                rotated[i][j] = toRotate[j][toRotate.length-i-1];
            }
        }
        return rotated;
    }
}
