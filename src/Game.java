public class Game {
    private Position[][] table = new Position[3][3];

    public Game(){
        for(int i = 0; i < table.length; i++){
            for (int f = 0; f < table[i].length; f++){
                table[i][f] = new Position();
            }
        }
    }

    //Method's


    //Getter's
    public Position[][] getTable() {
        return table;
    }

    //Setter's
    public void setTable(Position[][] table) {
        this.table = table;
    }
}
