package ar.model.factory;

import ar.edu.unq.cryptop2p.model.AppUser;

public class UserFactory {

    public static AppUser anyUser() throws Exception {
        return new AppUser("Victor","Hugo", "Francia 123" , "victorhugo@gmail.com", "Very_Secret!", "123456789_123456789_12", "12345678", 0, 0f, 0);
    }
    public static AppUser aUserWithPassword(String aPassword) throws Exception {
        return new AppUser("Victor","Hugo", "Francia 123" , "victorhugo@gmail.com", aPassword, "123456789_123456789_12", "12345678", 0, 0f, 0);
    }

    public static AppUser aUserWithName(String aName) throws Exception {
        return new AppUser(aName,"Hugo", "Francia 123", "victorhugo@gmail.com", "Very_Secret!", "123456789_123456789_12", "12345678", 0, 0f, 0);
    }
    public static AppUser aUserWithLastName(String aLastName) throws Exception {
        return new AppUser("Victor",aLastName,"Francia 123" , "victorhugo@gmail.com", "Very_Secret!", "123456789_123456789_12", "12345678", 0, 0f, 0);
    }

    public static AppUser aUserWithEmail(String anEmail) throws Exception {
        return new AppUser("Victor","Hugo","Francia 123" , anEmail, "Very_Secret!", "123456789_123456789_12", "12345678", 0, 0f, 0);
    }
    public static AppUser aUserWithCVU(String aCvu) throws Exception {
        return  new AppUser("Victor","Hugo","Francia 123" , "victorhugo@gmail.com", "Very_Secret!", aCvu, "12345678", 0, 0f, 0);
    }
    public static AppUser aUserWithCryptoAddress(String aCryptoAddress) throws Exception {
        return  new AppUser("Victor","Hugo","Francia 123" , "victorhugo@gmail.com", "Very_Secret!", "123456789_123456789_12", aCryptoAddress, 0, 0f, 0);
    }
    public static AppUser aUserWithAddress(String aAddress) throws Exception {
        return  new AppUser("Victor","Hugo", aAddress , "victorhugo@gmail.com", "Very_Secret!", "123456789_123456789_12", "12345678", 0, 0f, 0);
    }

    public static AppUser aUserWithOperation(int operations) throws Exception {
        return  new AppUser("Victor","Hugo", "Francia 123" , "victorhugo@gmail.com", "Very_Secret!", "123456789_123456789_12", "12345678", operations, 0f, 0);
    }
}
