package ar.model.builders;

import ar.edu.unq.cryptop2p.model.AppUser;

public class UserBuilder {

    private String name = "none";
    private String lastName = "none";
    private String address = "None adress";
    private String email = "none@gmail.com";
    private String password = "None_password";

    private int points = 0;
    private float reputation = 0;
    private int operations = 0;

    public static UserBuilder anyUser()
    {
        return new UserBuilder();
    }

    public UserBuilder withName(String aName)
    {
        name = aName;
        return this;
    }

    public UserBuilder withLastName(String aLastName)
    {
        lastName = aLastName;
        return this;
    }

    public UserBuilder withEmail(String aEmail)
    {
        email = aEmail;
        return this;
    }

    public UserBuilder withPassword(String aPassword)
    {
        password = aPassword;
        return this;
    }

    public UserBuilder withSuccesfulOperations(int operations)
    {
        this.operations = operations;
        return this;
    }

    public UserBuilder withPoints(int points)
    {
        this.points = points;
        return this;
    }

    public UserBuilder withReputation(float reputation)
    {
        this.reputation = reputation;
        return this;
    }

    public AppUser build() throws Exception
    {
        return new AppUser(name, lastName, address, email, password, "123456789_123456789_12", "12345678", operations, reputation, points);
    }
}
