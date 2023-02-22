package Project01;
import java.util.Collection;
import java.util.Collections;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
import Project01.People;
import Project01.PeopleType;

public class Tribe
{
    private String nationName; // Creates just the string of nation names for individual nations
    private String tribeName; // Creates just the string of nation names for tribe nations
    private int tribeLifePoints; // This is the unique int for this class to calculate life for a specific tribe
    private ArrayList<People> members = new ArrayList<>(); // This array is strictly used for containing members within the class
    private ArrayList<People> livingMembers = new ArrayList<>(); // This is an array used for storing strictly living entities.


    /**
     * Constructor for Tribe.
     * This function takes 3 parameters, nation, tribe, and lifepoints.
     * @param nation The nationality of the specific tribe
     * @param tribe The tribe name
     * @param lifePoints The lifePoints of the specific tribe
     */

    public Tribe(String nation, String tribe, int lifePoints)
    {
        nationName = nation;
        tribeName = tribe;
        tribeLifePoints = lifePoints;
        for(int i = 0; i < 2; i++)
            if(i % 2 == 0)
                members.add(new People(nationName, tribeName, PeopleType.warrior, tribeLifePoints / 2));
            else
                members.add(new People(nationName, tribeName, PeopleType.wizard, tribeLifePoints / 2));
        for(int i = 0; i < members.size(); i++)
            livingMembers.addAll(members);
    }

    /**
     * Function for collecting all living tribe members
     * Returns an arraylist of living entities
     */

    public ArrayList<People> getLivingTribeMembers()
    {
        livingMembers.clear();
        tribeLifePoints = 0;
        for(int person = 0; person < members.size(); person++)
        {
            if(members.get(person).isPersonAlive())
            {
                livingMembers.add(members.get(person));
                tribeLifePoints += members.get(person).getLifePoints();
                //System.out.println(members.get(person));
            }
        }
        //System.out.println(livingMembers);
        return livingMembers;
    }
   /*
   public void printMembers()
   {
       for(int i = 0; i < 2; i++)
       {
           System.out.println(people.get(i));
       }
   }
*/

    /**
     * Function to get Tribe size.
     * @return the type of said person
     */

    public int getTribeSize()
    {
        return livingMembers.size();
    }

    /**
     * Function to determine if tribe health is above 0.
     * @return a boolean value if above 0
     */

    public Boolean isTribeAlive()
    {
        return (tribeLifePoints > 0);
    }

    /**
     * Function to get tribe life points
     * @return an int of said tribe life points
     */

    public int getTribeLifePoints()
    {
        return tribeLifePoints;
    }

    /**
     * Function to get the tribes name
     * @return a string of the tribe name
     */

    public String getTribeName()
    {
        return tribeName;
    }

    /**
     * Function to display all the information members and results about encounters.
     * @return the toString, to create formatting.
     */

    public String toString()
    {
        String result = "\0";

        result = tribeName;
        for(int i = 0; i < members.size(); i++)
        {
            result = result + '\n' + members.get(i).toString();
        }
        result = result + '\n';
        return result;
    }

}
