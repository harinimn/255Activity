/*
 * Activity 2.5.2
 * 
 * A Player class the PhraseSolverGame
 */
import java.util.Scanner;

public class Player
{
  /* your code here - attributes */
  private String name;
  private int player1Score = 0;
  private int player2Score = 0;

  /* your code here - constructor(s) */ 
  public Player() {
    System.out.println("Please enter your name: ");
    Scanner sc = new Scanner(System.in);
    name = sc.nextLine();
  }
  /* your code here - accessor(s) */ 
  public int getPlayer1Score() {
    return player1Score;
  }

  public int getPlayer2Score() {
    return player2Score;
  }

  public String getName() {
    return name;
  }
  /* your code here - mutator(s) */ 

  public int setPlayer1Score(int newScore) {
    player1Score = newScore;
    return player1Score;
  }
  public int setPlayer2Score(int newScore) {
    player2Score = newScore;
    return player2Score;
  }
}