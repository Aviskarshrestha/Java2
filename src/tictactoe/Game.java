package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    Player player1, player2;
    String [] Board=new String[3];
    //takes two player objects and creates a new game ,keeps track of position,takes instruction from the player objects and the executes the move
    public Game(Player p1,Player p2){
        player1=p1.copyObject();
        player2=p2.copyObject();
        Board   = Arrays.stream(Board).map(x->x="X").toArray(String[]::new);

    }
    public void printBoard(){
        for(int i=0;i<3;i++){
            if(i==3 || i==6 ){
                System.out.println();
            }
            System.out.print(Board[i]);
        }
    }

    public static void main(String[] args) {
        Player p1=new Player("A");
        Player p2=new Player("B");
        Game g=new Game(p1,p2);
        g.printBoard();
    }

}
class Player{
    String name;


    public Player(String n){
        name=n;
    }
    public Player copyObject(){
        return new Player(name);
    }
}
