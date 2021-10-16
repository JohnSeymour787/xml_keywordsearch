package assignment2;

public class Person
{
    private final String name;
    private final String role;

    public Person(String name, String role)
    {
        this.name = name;
        this.role = role;
    }

    @Override
    public String toString()
    {
        // Add the role if it isn't an empty string
        return name + (role.length() > 1 ? " " + role : "");
    }

    public String getName()
    {
        return name;
    }

    public String getRole()
    {
        return role;
    }
}