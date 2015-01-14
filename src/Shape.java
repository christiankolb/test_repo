/**
 * @author: Team 2 (Kienbauer, Kienbauer, Kolb)
 * UE Software Engineering WS 2014
 * Tetris 
 * @version 1.0
 */

/**
* Diese Enum-Klasse legt die Arten an Formen fest, die ein Spielstein haben kann
* Enums können mit Int-Werten verglichen werden, deshalb sind die Cases in der BlockFactory mit Zahlen besetzt, siehe {@link BlockFactory}
* Zugegriffen wird auf die Shape-Enum auch in der Cell-Klasse und der Block-Klasse, siehe {@link Cell} und {@link Block}
*/ 

public enum Shape
{
    I, J, L, O, Z, S, T;
} // end enum Shape
