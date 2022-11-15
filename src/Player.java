public class Player {
    private final String playerCharacter;
    private int wins;

    public Player(String playerCharacter){
        this.playerCharacter = playerCharacter;
    }

    //Getter's
    public String getPlayerCharacter() {
        return playerCharacter;
    }

    public int getWins() {
        return wins;
    }

    //Setter's
    public void setWins(int wins) {
        this.wins = wins;
    }
}
