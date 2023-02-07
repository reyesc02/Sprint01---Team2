package Project01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import Project01.Nation;
import Project01.Tribe;
import Project01.PlayGame;

/**
 * The Main class. Sets up and runs the Warring Nations Game.
 */
public class Main {


    /**
     * The Main function. Sets up the game options such as gameLifePoints and adds
     * players to the list of nations. Runs the simulation until one nation is the winner.
     * The winner is output to the screen.
     */
    public static void main(String[] args)
    {
       int gameLifePoints = 2000;
       ArrayList<Nation> nations = new ArrayList<>() ; // nations create tribes create people
       PlayGame game = new PlayGame();
	   nations.add(new Nation("Idiots", (gameLifePoints / 2)));
	   nations.add(new Nation("Minions", (gameLifePoints) / 2));
	   // could add and delete nations. return number of nations + 1 from add and number of nations -1 from remove.
	   for(int i = 0; i < 40; i++)
       {
           System.out.println("Round number: " + i);
           if (game.playOneRound(nations))
           {
               System.out.println("There is a winner!");
               break; // game over
           }
       }

	   System.out.println("The winning nation is " + game.getWinner() + ".");
    }
}
