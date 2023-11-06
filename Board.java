/*
 * Activity 2.5.2
 *
 * A Board class the PhraseSolverGame
 */
import java.util.Scanner;
import java.io.File;

public class  Board
{
  private String solvedPhrase;
  private String phrase = loadPhrase();
  private int currentLetterValue; 

  /* your code here - constructor(s) */ 
  public Board(){
    setLetterValue();
    System.out.println(phrase);
  }

  /* your code here - accessor(s) */
  public String getSolvedPhrase(){
    return solvedPhrase;
  }
  public int getLetterValue(){
    return currentLetterValue;
  }
  public String getPhrase(){
    return phrase;
  }
  /* your code here - mutator(s)  */
  // public void setLetterValue(int letVal){


  /* ---------- provided code, do not modify ---------- */
  public void setLetterValue()
  {
    int randomInt = (int) ((Math.random() * 10) + 1) * 100;    
    currentLetterValue = randomInt;
  }

  public boolean isSolved(String guess)
  {
    if (phrase.equals(guess))
    {
      return true;
    }
    return false;
  }

  private String loadPhrase()
  {
    String tempPhrase = "";

    int numOfLines = 0;
    try 
    {
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }

    int randomInt = (int) ((Math.random() * numOfLines) + 1);

    try 
    {
      int count = 0;
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt)
        {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }

    for (int i = 0; i < tempPhrase.length(); i++)
    {
      if (tempPhrase.substring(i, i + 1).equals(" "))
      {
        solvedPhrase += "  ";
      }  
      else
      {
        solvedPhrase += "_ ";
      }
    }  

    return tempPhrase;
  }  
  /*
  Checks whether a player's guess is in the phrase, and then updates the value of the phrase with the player's guess if it is correct. Also returns if the player's guess is in the phrase.

  Preconditions: player guesses a letter. solvedPhrase contains a phrase that the player is attempting to guess.
  Postconditions: foundLetter holds a true or false boolean value. solvedPhrase is updated with the player's guess if the player's guess is in the phrase.
  */
  public boolean guessLetter(String guess)
  {
    boolean foundLetter = false;
    String newSolvedPhrase = "";
    // loops through all characters in a string
    for (int i = 0; i < phrase.length(); i++)
    {
      // compares each letter to guess 
      if (phrase.substring(i, i + 1).equals(guess))
      {
        newSolvedPhrase += guess + " ";
        foundLetter = true;
      }
      else
      {
        newSolvedPhrase += solvedPhrase.substring(i * 2, i * 2 + 1) + " ";  
      }
    }
    solvedPhrase = newSolvedPhrase;
    System.out.println(solvedPhrase);
    return foundLetter;
  } 

  public String removeSpaces(String withSpaces) {
    String withoutSpaces = "";
    for (int i = 0; i < withSpaces.length(); i++) {
      if (withSpaces.substring(i, i+ 1).equals(" ")) {
        continue;
      } else {
        withoutSpaces += withSpaces.substring(i, i + 1);
      }
    }
    return withoutSpaces;
  }
} 