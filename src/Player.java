public class Player {
    private final String playerCharacter;
    private int wins;
    private int losses;

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

    public int getLosses() {
        return losses;
    }

    //Setter's
    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }
}
