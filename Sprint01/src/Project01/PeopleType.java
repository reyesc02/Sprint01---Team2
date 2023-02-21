package Project01;

/**
*There are two types of people they are either warrior or wizzard which is 
*random but base on the number generator.
*/ 

public enum PeopleType
{
    warrior ("Solder"),
    wizzard  ("Tricky");

    private String description;

    PeopleType (String types)
    {
        description = types;
    }


    public String getDescription()
    {
        return description;
    }
}
