package Project01;
import Project01.Nation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.*;

/**
 * The PlayGame Class. This class is responsible for running the game
 * through the PlayGame function. It also keeps track of the array of nations
 * and people for the game.
 */
public class PlayGame
{

    ArrayList<Nation> allLivingNations = new ArrayList<>();
    ArrayList<People> worldLivingPopulation = new ArrayList<>();
    Random generator;

    /**
     * The PlayGame function. This function creates a new seed for the random
     * number generation for the game.
     */
    public PlayGame()
    {
        Date seed = new Date();
        generator = new Random(seed.getTime());
    }

    /**
     * The getWorldLivingPopulation function. The nations argument
     * is the list of nations. The worldLivingPopulation is updated by
     * looping through the nations and adding their size to the worldLivingPopulation.
     * @param nations the list of nations to calculate the world population from.
     */
    public void getWorldLivingPopulation(ArrayList<Nation> nations)
    {
        // add all living people to world list
        worldLivingPopulation.clear();
        //System.out.println(allLivingNations);
        for(int nation = 0; nation < nations.size(); nation++)
            //System.out.println(nations.get(nation));
            worldLivingPopulation.addAll(nations.get(nation).getNationPopulation());
        //System.out.println(worldLivingPopulation);
    }


    /**
     * The getAllLivingNations function. The nations argument is the
     * list of nations. The allLivingNations list is updated with every
     * nation that returns true from isNationAlive function.
     * @param nations the list of nations to calculate the number of living nations from.
     */
    public void getAllLivingNations(ArrayList<Nation> nations)
    {
        getWorldLivingPopulation(nations);
        allLivingNations.clear();
        for(int nation = 0; nation < nations.size(); nation++)
        {
            if(nations.get(nation).isNationAlive())
            {
                allLivingNations.add(nations.get(nation));
            }
        }
        //System.out.print(allLivingNations);
    }

    /**
     * The encounter function. The argument p1 is person from the
     * first nation. The argument p2 is the person from the second nation.
     * An encounter is played between the two people. Damage is calculated
     * and 
     * @param p1
     * @param p2
     */
    public void encounter(People p1, People p2)
    {
        // need to fix this to take strategies into account.
        if(p1.getNation() != p2.getNation())
        {
            System.out.print(p1 + " encounters " + p2);
            int p1Damage = (int) (generator.nextFloat() * generator.nextInt(20));
            int p2Damage = (int) (generator.nextFloat() * generator.nextInt(20));
            p1.reduceLifePoints(p1Damage);
            p2.reduceLifePoints(p2Damage);

            System.out.println("\t\tp1 damage is " + p1Damage + ". p2 damage is " + p2Damage + ".");
        }
    }




    public Boolean playOneRound(ArrayList<Nation> nations)
    {
        getAllLivingNations(nations);
        int index = 0;
        while((allLivingNations.size() > 1) && (index < worldLivingPopulation.size()))
        {
            //encounter(worldLivingPopulation.get(pointers.get(index)), worldLivingPopulation.get(pointers.get(index+1)));
            //System.out.println((worldLivingPopulation.size()-1) + "\t" + limit + "\t" + index + "\t" + (index+1));
            int p1Index = generator.nextInt(worldLivingPopulation.size());
            int p2Index;
            do
                p2Index = generator.nextInt(worldLivingPopulation.size());
            while(p1Index == p2Index);
            encounter(worldLivingPopulation.get(p1Index), worldLivingPopulation.get(p2Index));
            getAllLivingNations(nations);
            if(allLivingNations.size() < 2)
                break;
            index = index + 1;
        }

        return (allLivingNations.size() < 2);


    }


    public String getWinner()
    {
        if (allLivingNations.size() == 0)
            return "No Winner!";
        else
            return allLivingNations.get(0).getNationName();
    }
}
