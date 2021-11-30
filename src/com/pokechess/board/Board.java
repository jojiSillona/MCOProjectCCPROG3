import com.pokechess.board.Tile;
import com.pokechess.player.Player;
import com.pokechess.player.Pokemon;

public class Board {
    private char[][] board;
    char[] alphabet = { 'a','b','c','d','e','f','g'};
    // alphabet = lowest row position
    // numbers = rightest column position
    private Player[] players;

    public Board(Player[] players){

        createBoard();
    }
// still working on this one,, lipat ko sa boardmanager yung iba

    // Blank board template
    public void createBoard() {
        board = new Tile[5][7];
        System.out.println("-----------------------------------");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = new Tile(i, alphabet[j]);
            }
            System.out.println();
            System.out.println("------------------------------");
        }
    }

    // Adds pokemons on respective zones
    public void addPokemon(Pokemon pokemon){
        Zone playerZone = player.getZone();
        Pokemon tempP;

        if (playerZone == Zone.EnemyZone) { // No random generator yet
            for (int i = 0; i < 5; i++) {
                tempP = new ___(Zone.EnemyZone) // Random selected pokemons
                board[i][6].setPokemon(tempP);
            }
        }
        else{
            for (int i = 0; i < 5; i++){
                tempP = new ___(Zone.HomeZone) // Player's selected pokemon
                board[i][0].setPokemon(tempP);
            }

    // Prints out board on game screen
     public void printBoard(){

         // Prints board and numbers on rightmost column
          for(int i = 4; i > -1; i--){
               for(int j = 0; j < 7; j++){
                 Pokemon tempP = board[i][j].getPokemon();
                 if(tempP == null){
                       if(board[i][j].Division == Zone.HomeZone){
                           System.out.print("   ");
                       }
                       else{
                           System.out.print(" ##");
                       }
                   }
                 else if((tempP instanceof // insert Pokemon Name)){
                        if(tempP.getZone() == Zone.EnemyZone){
                            // print random selected pokemon by computer
                        }
                        else if(tempP.getZone() == Zone.HomeZone){
                            // print selected pokemon
                        }
                    }
                 else if((tempP instanceof // insert pokemon )){
                        if(tempP.getZone() == Zone.EnemyZone){
                        System.out.print(" eNameofPokemon"); // Enemy's pokemon
                        }
                        else {
                        System.out.print(" hNameofPokemon"); // Player's pokemon
                    }
                }
                else if((tempP instanceof insert pokemon)){
                    if(tempP.getZone() == Zone.EnemyZone){
                        System.out.print(" eNameofPokemon");
                    }
                    else {
                        System.out.print(" hNameofPokemon");
                    }
                }
                else if((tempP instanceof insert pokemon)){
                    if(tempP.getZone() == Zone.EnemyZone{
                        System.out.print(" eNameofPokemon");
                    }
                    else {
                        System.out.print(" hNameofPokemon");
                    }
                }
                else if((tempP instanceof insert pokemon)){
                    if(tempP.getZone() == Zone.EnemyZone){
                        System.out.print(" eNameofPokemon");
                    }
                    else {
                        System.out.print(" hNameofPokemon");
                    }
                }
                else if((tempP instanceof insert pokemon)){
                    if(tempP.getZone() == Zone.EnemyZone){
                        System.out.print(" eNameofPokemon");
                    }
                    else {
                        System.out.print(" hNameofPokemon");
                    }
                }
            }
            System.out.println(" " + (i + 1));
        }

        /* Prints out alphabet */
        for(int i = 0; i < 7; i++){
            System.out.print("  " + alphabet[i]);
        }
        System.out.println();
    }

    // Checks if spot is empty on gameboardd
    public boolean emptyTile(int x, int y){

        if(x < 0 || x > 4)
            return true;

        if(y < 0 || y > 6)
            return true;

        if(board[x][y].getPokemon() == null){
            return true;
        }

        return false;
    }

    // Checks if input is out of range
    public boolean outOfRange(int x, int y){

        if(x < 0 || x > 4)
            return true;
        if(y < 0 || y > 6)
            return true;

        return false;
    }

    // Gets the tile position
    public Tile getTile(int x, int y){

        return board[x][y];
    }

}

