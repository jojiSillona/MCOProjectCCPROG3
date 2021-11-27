# MCOProjectCCPROG3

CHANGES in 11.27 - 10:37PM

1. Board Class
- public class Board changes
- public void createBoard() 
- public void addPokemon(Pokemon pokemon)
-  public void printBoard()
- public boolean emptyTile
-  public boolean outOfRange
- public Tile getTile

2. [ADDITIONAL] Position Class
- public Position(int number, char alphabet)
- public int getNumber() 
// This will serve as the rightmost number column when getting the position of input
- public int getAlphabet()
// This will serve as the lowermost alphabet column when getting the position of input

3. [ADDITIONAL] Zone Class
- public enum Zone w/ HomeZone and EnemyZone

NOTE: There is no random generator yet for the computer inputs
I also haven't seen the output of my code yet but I really thought about the logic of the gameboard 
regarding their arrays at public void addPokemon(Pokemon pokemon)

EnemyZone: board[i][6].setPokemon(tempP);
HomeZone: board[i][0].setPokemon(tempP)


