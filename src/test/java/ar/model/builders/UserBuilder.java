package ar.model.builders;

import ar.edu.unq.cryptop2p.model.User;

public class UserBuilder {

    private String name = "none";
    private String lastName = "none";
    private String address = "None adress";
    private String email = "none@gmail.com";
    private String password = "None_password";

    public static UserBuilder aUser()
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

    public User Build() throws Exception
    {
        return new User(name, lastName, address, email, password, "123456789_123456789_12", "12345678");
    }
}
