package Project01;

import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import Project01.Tribe;
import Project01.People;

/**
 * The Nation Class
 * This class has sets up the Nation data object. It holds variables for
 * the specific nation. It also contains the functions for interacting
 * with the nation.
 */
public class Nation
{
    private int nationLifePoints;
    public static int nationCount = 0;
    private String nationName;
    private ArrayList<Tribe> tribes = new ArrayList<>();
    private ArrayList<People> population = new ArrayList<>();
    private ArrayList<People> livingPopulation = new ArrayList<>();


    /**
     * Constructor for Nation.
     * This function accepts a name and lifePoints and sets the nationName,
     * and nationLifePoints to the arguments.
     * @param name The name of the nation
     * @param lifePoints The lifePoints of the nation
     */
    public Nation(String name, int lifePoints)
    {
        nationCount++;
        nationName = name;
        nationLifePoints = lifePoints;
        for(int i = 0; i < 5; i++)
        {
            this.tribes.add(new Tribe(nationName, "Tribe" + i, nationLifePoints / 5));
        }
        population.addAll(getNationPopulation());
        livingPopulation.addAll(population);
    }


    /**
     * Function to check whether a nation is still alive.
     * A nation is alive if it has more than 0 lifePoints.
     * @return True if nationLifePoints are greater than 0, false otherwise.
     */
    public Boolean isNationAlive()
    {
        return (nationLifePoints > 0);
    }

    /**
     * Function to get the population of a nation. This function loops through
     * the tribes in a nation and if they are alive they are added to the
     * livingPopulation arrayList.
     * @return the arrayList of nationPopulation.
     */
    public ArrayList<People> getNationPopulation()
    {
        nationLifePoints = 0;
        livingPopulation.clear();
        for(int tribe = 0; tribe < this.tribes.size(); tribe++)
        {
            if(tribes.get(tribe).isTribeAlive())
            {
                //System.out.println(tribes.get(tribe));
                livingPopulation.addAll(tribes.get(tribe).getLivingTribeMembers());
                //System.out.println(tribes.get(tribe).getLivingTribeMembers());
                nationLifePoints += tribes.get(tribe).getTribeLifePoints();
            }
        }
        return livingPopulation;
    }


    /**
     * Function to get nationName.
     * @return the name of the nation.
     */
    public String getNationName()
    {
        return nationName;
    }


    /**
     * Function to print the tribes status. The tribes can be alive and
     * have members, or they are dead.
     */
    public void printTribesStatus()
    {
        for(int tribe = 0; tribe < 1; tribe++)
        {
            if(tribes.get(tribe).isTribeAlive())
            {
                System.out.print(tribes.get(tribe).getTribeName() + " is alive and has ");
                System.out.println(tribes.get(tribe).getTribeSize() + " members.");
            }
            else
            {
                System.out.println(tribes.get(tribe).getTribeName() + " is dead.");
            }
        }
    }

    /**
     * Function to print the information of a nation. The name and tribe size
     * are converted to a string to be returned.
     * @return The nation information that has been turned into a string.
     */
    public String toString()
    {
        String result = "\0";
        result = nationName;
        for(int i = 0; i < tribes.size(); i++)
        {
            result = result + '\n' + tribes.get(i).toString();

        }
        result = result + '\n';
        return result;
    }
}
