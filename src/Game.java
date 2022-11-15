import java.util.Scanner;

public class Game {
    private static Position[][] table = new Position[3][3];

    public Game(){
        for(int i = 0; i < table.length; i++){
            for (int f = 0; f < table[i].length; f++){
                table[i][f] = new Position();
            }
        }
    }

    //Method's
    public void startGame(){
        Scanner sc = new Scanner(System.in);
        String chart;
        System.out.println("What's your character player one?");
        chart = sc.next();
        Player playerOne = new Player(chart);
        System.out.println("What's your character player two?");
        chart = sc.next();
        Player playerTwo = new Player(chart);


    }

    //Getter's
    public Position[][] getTable() {
        return table;
    }
}
