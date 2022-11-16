import java.util.*;

public class Game {
    private static Position[][] table = new Position[3][3];
    ArrayList<Integer> numbers = new ArrayList<>();

    public Game(){
        int counter= 1;
        for(int i = 0; i < table.length; i++){
            for (int f = 0; f < table[i].length; f++){
                table[i][f] = new Position(String.valueOf(counter));
                counter++;
            }
        }

        for(int i = 1; i <=9; i++){
            numbers.add(i);
        }
    }

    //Method's
    public void startGame(){
        Scanner sc = new Scanner(System.in);
        Player[] players = players();
        String playAgain = "1";
        int plays;
        int choice;
        boolean itsAnOption;
        int playerThatMove;

        while(playAgain.equals("1")) {
            //Print Player's Score
            {
                System.out.println();
                System.out.println("Player (  " + players[0].getPlayerCharacter() + "  ): " + players[0].getWins() + " win's");
                System.out.println();
                System.out.println("Player (  " + players[1].getPlayerCharacter() + "  ): " + players[1].getWins() + " win's");
                System.out.println();
            }

            //Var's
            {
                playerThatMove = (int) (Math.random() * 2);
                itsAnOption = true;
                choice = 0;
                plays = 0;
            }

            //Check if player wants to play again
            printGame();
            while (true) {
                plays++;

                //Ask where player wants to play and check if it's a valid option
                while (itsAnOption) {
                    System.out.println("Where do you want to play?");
                    choice = sc.nextInt();
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) == choice) {
                            numbers.remove(i);
                            itsAnOption = false;
                            break;
                        }
                    }
                    if (itsAnOption) {
                        System.out.println();
                        System.out.println("Chose a valid position!!!\n");
                    }
                }
                setOnPosition(players[playerThatMove], choice);
                printGame();

                //Check Victory then if the player win, quit
                if (checkVictory(players[playerThatMove])) {
                    resetPos();
                    players[playerThatMove].setWins(players[playerThatMove].getWins() + 1);
                    break;
                }

                //Check Draws
                if(plays == 9){
                    resetPos();
                    break;
                }

                //Change the player that will move at next round
                if (playerThatMove == 1) {
                    playerThatMove = 0;
                    itsAnOption = true;
                    continue;
                }
                playerThatMove = 1;
                itsAnOption = true;
            }

            //Ask the player if he needs to play again
            do {
                System.out.println("Wanna play Again???");
                System.out.println("1 - YES");
                System.out.println("0 - NO");
                playAgain = sc.next();
            } while (!playAgain.equals("1") && !playAgain.equals("0"));
        }
    }

    //Reset all position's
    private void resetPos(){
        int counter= 1;
        for (Position[] positions : table) {
            for (Position position : positions) {
                position.setPlayer(String.valueOf(counter));
                counter++;
            }
        }

        numbers.clear();
        for(int i = 1; i <=9; i++){
            numbers.add(i);
        }
    }


    //Check if the game have 3 in a row
    private boolean checkVictory(Player player){
        boolean win = false;

        //Check Only rows
        for (Position[] value : table) {
            if (win) {
                break;
            }

            for (Position position : value) {
                if (!position.getPlayer().equals(player.getPlayerCharacter())) {
                    win = false;
                    break;
                }
                win = true;
            }
        }

        //Check Only Columns
        for (int i = 0; i < table.length; i++){
            if (win) {
                break;
            }

            for (Position[] positions : table) {
                if (!positions[i].getPlayer().equals(player.getPlayerCharacter())) {
                    win = false;
                    break;
                }
                win = true;
            }
        }

        //Check diagonal
        {
            if ((table[0][0].getPlayer().equals(player.getPlayerCharacter()) &&
                    (table[1][1].getPlayer().equals(player.getPlayerCharacter()) &&
                            (table[2][2].getPlayer().equals(player.getPlayerCharacter()))))) {
                win = true;
            }

            if ((table[2][0].getPlayer().equals(player.getPlayerCharacter()) &&
                    (table[1][1].getPlayer().equals(player.getPlayerCharacter()) &&
                            (table[0][2].getPlayer().equals(player.getPlayerCharacter()))))) {
                win = true;
            }
        }

        return win;
    }

    //Player's Organization
    private Player[] players(){
        Scanner sc = new Scanner(System.in);
        String chart;
        System.out.println("What's your character player one?");
        chart = sc.next();
        Player playerOne = new Player(chart);
        System.out.println("What's your character player two?");
        chart = sc.next();
        Player playerTwo = new Player(chart);
        return new Player[]{playerOne,playerTwo};
    }

    //Print game
    private void printGame(){
        System.out.println(" "+table[0][0].getPlayer()+" | "+table[0][1].getPlayer()+" | "+table[0][2].getPlayer()+"\n" +
                           "-----------\n" +
                           " "+table[1][0].getPlayer()+" | "+table[1][1].getPlayer()+" | "+table[1][2].getPlayer()+"\n" +
                           "-----------\n" +
                           " "+table[2][0].getPlayer()+" | "+table[2][1].getPlayer()+" | "+table[2][2].getPlayer()+"\n");
    }

    //Set Player with on input position
    private void setOnPosition(Player player, int position){
        switch (position){
            case 1:
                table[0][0].setPlayer(player.getPlayerCharacter());
                break;
            case 2:
                table[0][1].setPlayer(player.getPlayerCharacter());
                break;
            case 3:
                table[0][2].setPlayer(player.getPlayerCharacter());
                break;
            case 4:
                table[1][0].setPlayer(player.getPlayerCharacter());
                break;
            case 5:
                table[1][1].setPlayer(player.getPlayerCharacter());
                break;
            case 6:
                table[1][2].setPlayer(player.getPlayerCharacter());
                break;
            case 7:
                table[2][0].setPlayer(player.getPlayerCharacter());
                break;
            case 8:
                table[2][1].setPlayer(player.getPlayerCharacter());
                break;
            case 9:
                table[2][2].setPlayer(player.getPlayerCharacter());
            default:
        }
    }
}
