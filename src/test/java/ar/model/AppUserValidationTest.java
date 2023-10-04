package ar.model;
import static ar.model.factory.UserFactory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import ar.edu.unq.cryptop2p.model.AppUser;
import ar.model.builders.UserBuilder;
import org.junit.jupiter.api.Test;


public class AppUserValidationTest {
    //region name
    @Test
    void ValidationOnUserNameCaseLessThanMinimunLength()
    {
        Exception myException = null;
        var nameWithLessLenghtThanMinumun = "lu";
        AppUser appUser;

        try
        {
            appUser = UserBuilder.anyUser().withName(nameWithLessLenghtThanMinumun).build();
        }
        catch (Exception ex)
        {
            myException = ex;
        }

        assertEquals(myException.getMessage(), "Not valid name length. Must be between 3 and 30");
    }

    @Test
    void ValidationOnUserNameCaseMoreThanMaximum()
    {
        Exception myException = null;
        AppUser appUser;
        var nameWithMoreThanMaximum = "123456789_123456789_123456789_1";

        try
        {
            appUser = UserBuilder.anyUser().withName(nameWithMoreThanMaximum).build();
        }
        catch (Exception ex)
        {
            myException = ex;
        }

        assertEquals(myException.getMessage(), "Not valid name length. Must be between 3 and 30");
    }

    @Test
    void ValidationOnUserNameCaseInTheMaximumRange() throws Exception
    {
        var nameInTheMaxRange = "123456789_123456789_123456789_";

        var user = aUserWithName(nameInTheMaxRange);

        assertEquals(nameInTheMaxRange, user.getName());
    }

    @Test
    void ValidationOnUserNameCaseInTheMinimumRange() throws Exception
    {
        var nameInTheMinRange = "Lee";

        var user = aUserWithName(nameInTheMinRange);

        assertEquals(nameInTheMinRange, user.getName());
    }

    //endregion

    //region lastname
    @Test
    void ValidationOnUserLastNameCaseLessThanMinimunLength()
    {
        Exception myException = null;
        var lastNameWithLessLenghtThanMinumun = "lu";
        AppUser appUser;

        try
        {
            appUser = UserBuilder.anyUser().withName(lastNameWithLessLenghtThanMinumun).build();
        }
        catch (Exception ex)
        {
            myException = ex;
        }

        assertEquals(myException.getMessage(), "Not valid name length. Must be between 3 and 30");
    }


    @Test
    void ValidationOnUserLastNameCaseMoreThanMaximumLenght()
    {
        Exception myException = null;
        AppUser appUser;
        var lastNameWithMoreThanMaximum = "123456789_123456789_123456789_1";

        try
        {
            appUser = UserBuilder.anyUser().withName(lastNameWithMoreThanMaximum).build();
        }
        catch (Exception ex)
        {
            myException = ex;
        }

        assertEquals(myException.getMessage(), "Not valid name length. Must be between 3 and 30");
    }

    @Test
    void ValidationOnUserLastNameCaseInTheMaximumRange() throws Exception
    {
        var lastNameInTheMaxRange = "123456789_123456789_123456789_";

        var user = aUserWithLastName(lastNameInTheMaxRange);

        assertEquals(lastNameInTheMaxRange, user.getLastName());
    }

    @Test
    void ValidationOnUserLastNameCaseInTheMinimumRange() throws Exception
    {
        var lastNameInTheMinRange = "Lee";

        var user = aUserWithLastName(lastNameInTheMinRange);

        assertEquals(lastNameInTheMinRange, user.getLastName());
    }
    //endregion

    //region Email
    @Test
    public void ValidationOnEmailCaseWithOutAtSign() throws Exception
    {
        var email = "luisgmail.com";
        AppUser appUser;
        Exception myException = null;

        try
        {
            appUser = aUserWithEmail(email);
        }
        catch (Exception ex)
        {
            myException  = ex;
        }

        assertEquals(myException.getMessage(), "Invalid Email Format");
    }

    @Test
    public void ValidationOnEmailCaseWithAtSign() throws Exception
    {
        var email = "luis@gmail.com";

        AppUser appUser =  aUserWithEmail(email);

        assertEquals(email, appUser.getEmail());
    }

    @Test
    public void ValidationOnEmailCaseWithOutDotCom() throws Exception
    {
        var email = "luis@gmailcom";
        AppUser appUser;
        Exception myException = null;

        try
        {
            appUser = aUserWithEmail(email);
        }
        catch (Exception ex)
        {
            myException  = ex;
        }

        assertEquals(myException.getMessage(), "Invalid Email Format");
    }

    @Test
    public void ValidationOnEmailCaseWithDotCom() throws Exception
    {
        var email = "luis@gmail.com.ar";

        AppUser appUser = aUserWithEmail(email);

        assertEquals(email, appUser.getEmail());
    }



    @Test
    public void ValidationOnEmailCaseWithOutCharBeforeAtSign() throws Exception
    {
        var email = "@gmailcom";
        AppUser appUser;
        Exception myException = null;

        try
        {
            appUser = aUserWithEmail(email);
        }
        catch (Exception ex)
        {
            myException  = ex;
        }

        assertEquals("Invalid Email Format", myException.getMessage());
    }

    @Test
    public void ValidationOnEmailCaseWithCharBeforeAtSign() throws Exception
    {
        String email = "l@gmail.com.ar";

        AppUser appUser = aUserWithEmail(email);

        assertEquals(email, appUser.getEmail());
    }

    //endregion

    //region password
    @Test
    public void ValidationOnPasswordCaseLessThanMinimumLowerCase() throws Exception
    {
        var password = "VERY_SECRET";
        AppUser appUser;
        Exception myException = null;

        try
        {
            appUser = aUserWithPassword(password);
        }
        catch (Exception ex)
        {
            myException  = ex;
        }

        assertEquals("Invalid password format. At least one valid lowercase is needed.", myException.getMessage());
    }


    @Test
    public void ValidationOnPasswordCaseLessThanMinimumUpperCase() throws Exception
    {
        var password = "very_secret";
        AppUser appUser;
        Exception myException = null;

        try
        {
            appUser = aUserWithPassword(password);
        }
        catch (Exception ex)
        {
            myException  = ex;
        }

        assertEquals("Invalid password format. At least one valid uppercase is needed.", myException.getMessage());
    }



    @Test
    public void ValidationOnPasswordCaseWithOutSpecialCharacter() throws Exception
    {
        var password = "VerySecret";
        AppUser appUser;
        Exception myException = null;

        try
        {
            appUser = aUserWithPassword(password);
        }
        catch (Exception ex)
        {
            myException  = ex;
        }

        assertEquals("Invalid password format. At least one special character is needed.", myException.getMessage());
    }

    @Test
    public void ValidationOnPasswordCaseWithLessThanMinimumLength() throws Exception
    {
        var password = "Very!";
        AppUser appUser;
        Exception myException = null;

        try
        {
            appUser = aUserWithPassword(password);
        }
        catch (Exception ex)
        {
            myException  = ex;
        }

        assertEquals("Invalid password format. Incorrect length must be between 6 and 30.", myException.getMessage());
    }

    @Test
    public void ValidationOnPasswordCaseCorrectFormat() throws Exception
    {
        String password = "vEry_secret";

        AppUser appUser = appUser = aUserWithPassword(password);

        assertEquals(password, appUser.getPassword());
    }

    //endregion

    //region CVU
    @Test
    public void ValidationOnCVUCaseCorrectFormat() throws Exception
    {
        String cvu = "123456789_123456789_12";//22 caracteres

        AppUser appUser = appUser = aUserWithCVU(cvu);

        assertEquals(cvu, appUser.getCvu());
    }

    @Test
    public void ValidationOnCVUCaseLessThanMinimum() throws Exception
    {
        String cvu = "123456789_123456789_1";//21 caracteres
        Exception myException = null;

        try
        {
            AppUser appUser = appUser = aUserWithCVU(cvu);
        }
        catch (Exception e)
        {
            myException = e;
        }

        assertEquals("Invalid CVU format. 22 digits needed.", myException.getMessage());
    }

    @Test
    public void ValidationOnCVUCaseMoreThanMaximum() throws Exception
    {
        String cvu = "123456789_123456789_123";//23 caracteres
        Exception myException = null;

        try
        {
            AppUser appUser = appUser = aUserWithCVU(cvu);
        }
        catch (Exception e)
        {
            myException = e;
        }

        assertEquals("Invalid CVU format. 22 digits needed.", myException.getMessage());
    }
    //endregion

    //region CryptoAddress
    @Test
    public void ValidationOnCrytoAddressCaseCorrectFormat() throws Exception
    {
        String cryptoAddress = "12345678";

        AppUser appUser = aUserWithCryptoAddress(cryptoAddress);

        assertEquals(cryptoAddress, appUser.getCryptoAddress());
    }

    @Test
    public void ValidationOnCryptoAddressCaseLessThanMinimum() throws Exception
    {
        String cryptoAddress = "1234567";
        Exception myException = null;

        try
        {
            AppUser appUser = aUserWithCryptoAddress(cryptoAddress);
        }
        catch (Exception e)
        {
            myException = e;
        }

        assertEquals("The crypto address must be 8 digits long.", myException.getMessage());
    }

    @Test
    public void ValidationOnCryptoAddressCaseMoreThanMaximum() throws Exception
    {
        String cryptoAddress = "123456789";
        Exception myException = null;

        try
        {
            AppUser appUser =  aUserWithCryptoAddress(cryptoAddress);
        }
        catch (Exception e)
        {
            myException = e;
        }

        assertEquals("The crypto address must be 8 digits long.", myException.getMessage());
    }
    //endregion

    @Test
    public void ValidationOnAddressCaseMoreThanMaximumLenght() throws Exception
    {
        String address = "123456789_123456789_123456789_1";
        Exception myException = null;

        try
        {
            AppUser appUser =  aUserWithAddress(address);
        }
        catch (Exception e)
        {
            myException = e;
        }

        assertEquals("Incorrect length must be between 10 and 30.", myException.getMessage());
    }
    @Test
    public void ValidationOnAddressCaseLessThanMinimumLenght() throws Exception
    {
        String address = "123456789";
        Exception myException = null;

        try
        {
            AppUser appUser =  aUserWithAddress(address);
        }
        catch (Exception e)
        {
            myException = e;
        }

        assertEquals("Incorrect length must be between 10 and 30.", myException.getMessage());
    }
    @Test
    public void ValidationOnAddressCaseCorrectFormat() throws Exception
    {
        String address = "Francia N220";

        AppUser appUser = aUserWithAddress(address);

        assertEquals(address, appUser.getAddress());
    }
}
