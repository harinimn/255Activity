/*
 * Activity 2.5.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;

public class PhraseSolver
{
  /* your code here - attributes */
  private Player player1;
  private Player player2;
  private Board game;
  private boolean solved;
  /* your code here - constructor(s) */ 
  public PhraseSolver(){
    player1 = new Player();
    player2 = new Player();
    game = new Board();
    solved = false;
  }
  /* your code here - accessor(s) */
  public Player getPlayer1(){
    return player1;
  }
  public Player getPlayer2() {
    return player2;
  }
  public Board getGame() {
    return game;
  }
  public boolean getSolved() {
    return solved;
  }
  /* your code here - mutator(s)  */

  public void play()
  {
    boolean solved = false;
    int playerNow = 1;

    Scanner sc = new Scanner(System.in);

    while (!solved) 
    {

      /* your code here - game logic */
      while (playerNow == 1) {
        System.out.println(player1.getName() + " is playing currently.");
        System.out.println("Guess a letter: ");
        String playerGuess = sc.nextLine();
        boolean letterFound = game.guessLetter(playerGuess);
        System.out.println("Letter was found: " + letterFound);
        String phraseWithoutSpace = game.removeSpaces(game.getPhrase());
        String solvedPhraseWithoutSpace = game.removeSpaces(game.getSolvedPhrase());
        if (phraseWithoutSpace == solvedPhraseWithoutSpace) {
          System.out.println("Game is solved");
          solved = true;
          letterFound = false;
          break;
        }
        if (!letterFound) {
          playerNow = 2;
        } else {
          int new1Score = player1.setPlayer1Score(player1.getPlayer1Score() + 5);
          System.out.println("Your score is: " + new1Score);
        }

      }
      while (playerNow == 2) {
        System.out.println(player2.getName() + " is playing currently.");
        System.out.println("Guess a letter: ");
        String playerGuess = sc.nextLine();
        boolean letterFound = game.guessLetter(playerGuess);
        System.out.println("Letter was found: " + letterFound);
        String phraseWithoutSpace = game.removeSpaces(game.getPhrase());
        String solvedPhraseWithoutSpace = game.removeSpaces(game.getSolvedPhrase());
        if (phraseWithoutSpace == solvedPhraseWithoutSpace) {
          System.out.println("Game is solved");
          solved = true;
          letterFound = false;
          break;
        }
        if (!letterFound) {
          playerNow = 1;
        } else {
          int new2Score = player2.setPlayer2Score(player2.getPlayer2Score() + 5);
          System.out.println("Your score is: " + new2Score);
        }

      }

      /* your code here - determine how game ends */
    } 

  }

}
