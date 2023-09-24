package ar.model.factory;

import ar.edu.unq.cryptop2p.model.User;

public class UserFactory {

    public static User anyUser() throws Exception {
        return new User("Victor","Hugo", "Francia 123" , "victorhugo@gmail.com", "Very_Secret!", "123456789_123456789_12", "12345678");
    }
    public static User aUserWithPassword(String aPassword) throws Exception {
        return new User("Victor","Hugo", "Francia 123" , "victorhugo@gmail.com", aPassword, "123456789_123456789_12", "12345678");
    }

    public static User aUserWithName(String aName) throws Exception {
        return new User(aName,"Hugo", "Francia 123", "victorhugo@gmail.com", "Very_Secret!", "123456789_123456789_12", "12345678");
    }
    public static User aUserWithLastName(String aLastName) throws Exception {
        return new User("Victor",aLastName,"Francia 123" , "victorhugo@gmail.com", "Very_Secret!", "123456789_123456789_12", "12345678");
    }

    public static User aUserWithEmail(String anEmail) throws Exception {
        return new User("Victor","Hugo","Francia 123" , anEmail, "Very_Secret!", "123456789_123456789_12", "12345678");
    }
    public static User aUserWithCVU(String aCvu) throws Exception {
        return  new User("Victor","Hugo","Francia 123" , "victorhugo@gmail.com", "Very_Secret!", aCvu, "12345678");
    }
    public static User aUserWithCryptoAddress(String aCryptoAddress) throws Exception {
        return  new User("Victor","Hugo","Francia 123" , "victorhugo@gmail.com", "Very_Secret!", "123456789_123456789_12", aCryptoAddress);
    }
    public static User aUserWithAddress(String aAddress) throws Exception {
        return  new User("Victor","Hugo", aAddress , "victorhugo@gmail.com", "Very_Secret!", "123456789_123456789_12", "12345678");
    }
}
