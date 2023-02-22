package Project01;

import Project01.PeopleType;

/**
 * The People Class
 * This class uses a constructor to create a specific person. It holds variables for
 * the specific person, including their nation, tribe, who they are, description, and lifepoints.
 * It also contains the functions for interacting with the person, including checking of
 * they're alive, and reducing their health points as needed.
 */

public class People
{
    private String personName;
    private String myNation;
    private String myTribe;
    private PeopleType me;
    private String myDescription;
    private int myLifePoints;


    /**
     * Constructor for People.
     * This function takes 4 parameters, nation, tribe, person, lifepoints.
     * It is important to note that, person is of type PeopleType, created in the PeopleType class.
     * @param nation The nationality of the specific person
     * @param tribe The tribe of the specific person
     * @param person The specific person is designated a soldier or tricky.
     * @param lifePoints The lifePoints of the specific person
     */
    public People(String nation, String tribe, PeopleType person, int lifePoints)
    {
        myNation = nation;
        myTribe = tribe;
        me = person;
        myDescription = me.getDescription();
        myLifePoints = lifePoints;
    }

    /**
     * Function to get PeopleType.
     * @return the type of said person
     */

    public PeopleType getType()
    {
        return me;
    }

    /**
     * Function to get the tribe of a person.
     * @return the tribe type of said person
     */

    public String getTribe()
    {
        return myTribe;
    }

    /**
     * Function to get the nation of a person.
     * @return the nation type of said person
     */

    public String getNation()
    {
        return myNation;
    }
    /**
     * Function to check to see if the persons health is at least greater than 0.
     * @return the health of the person above 0
     */

    public Boolean isPersonAlive()
    {
        return (myLifePoints > 0);
    }

    /**
     * Function to get the health of the person.
     * @return the health of the person
     */
    public int getLifePoints()
    {
        return myLifePoints;
    }

    /**
     * This is the encounterStrategy
     * This function takes 1 parameter; encounterStrategy
     * @param otherPerson otherPerson is determined based on an interaction with
     * a member of another party. This will help determine what happens during the interaction
     * and accordingly solve the action at hand.
     */

    public void encounterStrategy(People otherPerson)
    {
        if(myNation == otherPerson.getNation())
        {
            // There will be an ugly confrontation
        }
        else
        {
            // there will be a peaceful confrontation
            // warriors - warrior ignore each other if different tribes increase life points
            // healer - healer ignore each other
            // healer - warrior - healer can heal warrior. Heals warrior from same tribe better
        }
    }

    /**
     * Function to update the health of the person
     */

    public void reduceLifePoints(int points)
    {
        myLifePoints = myLifePoints - points;
    }


    /**
     * Function to display all the information about a person and have it formatted.
     * @return the toString, to create formatting.
     */

    public String toString()
    {
        String result = new String( myNation + "\t" +  myTribe + "\t" + me + "\t" + myDescription + "\t" + myLifePoints);
        return result;
    }
}

