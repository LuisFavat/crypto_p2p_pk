package ar.model;
import static ar.model.builders.UserBuilder.aUser;
import static ar.model.factory.UserFactory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import ar.edu.unq.cryptop2p.model.User;
import org.junit.jupiter.api.Test;


public class UserTest {

    //region name
    @Test
    void ValidationOnUserNameCaseLessThanMinimunLength()
    {
        Exception myException = null;
        var nameWithLessLenghtThanMinumun = "lu";
        User user;

        try
        {
            user = aUser().withName(nameWithLessLenghtThanMinumun).Build();
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
        User user;
        var nameWithMoreThanMaximum = "123456789_123456789_123456789_1";

        try
        {
            user = aUser().withName(nameWithMoreThanMaximum).Build();
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
        User user;

        try
        {
            user = aUser().withName(lastNameWithLessLenghtThanMinumun).Build();
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
        User user;
        var lastNameWithMoreThanMaximum = "123456789_123456789_123456789_1";

        try
        {
            user = aUser().withName(lastNameWithMoreThanMaximum).Build();
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
        User user;
        Exception myException = null;

        try
        {
            user = aUserWithEmail(email);
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

        User user =  aUserWithEmail(email);

        assertEquals(email, user.getEmail());
    }

    @Test
    public void ValidationOnEmailCaseWithOutDotCom() throws Exception
    {
        var email = "luis@gmailcom";
        User user;
        Exception myException = null;

        try
        {
            user = aUserWithEmail(email);
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

        User user = aUserWithEmail(email);

        assertEquals(email, user.getEmail());
    }



    @Test
    public void ValidationOnEmailCaseWithOutCharBeforeAtSign() throws Exception
    {
        var email = "@gmailcom";
        User user;
        Exception myException = null;

        try
        {
            user = aUserWithEmail(email);
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

        User user = aUserWithEmail(email);

        assertEquals(email, user.getEmail());
    }

    //endregion

    //region password
    @Test
    public void ValidationOnPasswordCaseLessThanMinimumLowerCase() throws Exception
    {
        var password = "VERY_SECRET";
        User user;
        Exception myException = null;

        try
        {
            user = aUserWithPassword(password);
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
        User user;
        Exception myException = null;

        try
        {
            user = aUserWithPassword(password);
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
        User user;
        Exception myException = null;

        try
        {
            user = aUserWithPassword(password);
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
        User user;
        Exception myException = null;

        try
        {
            user = aUserWithPassword(password);
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

        User user = user = aUserWithPassword(password);

        assertEquals(password, user.getPassword());
    }

    //endregion

    //region CVU
    @Test
    public void ValidationOnCVUCaseCorrectFormat() throws Exception
    {
        String cvu = "123456789_123456789_12";//22 caracteres

        User user = user = aUserWithCVU(cvu);

        assertEquals(cvu, user.getCvu());
    }

    @Test
    public void ValidationOnCVUCaseLessThanMinimum() throws Exception
    {
        String cvu = "123456789_123456789_1";//21 caracteres
        Exception myException = null;

        try
        {
            User user = user = aUserWithCVU(cvu);
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
            User user = user = aUserWithCVU(cvu);
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

        User user = aUserWithCryptoAddress(cryptoAddress);

        assertEquals(cryptoAddress, user.getCryptoAddress());
    }

    @Test
    public void ValidationOnCryptoAddressCaseLessThanMinimum() throws Exception
    {
        String cryptoAddress = "1234567";
        Exception myException = null;

        try
        {
            User user = aUserWithCryptoAddress(cryptoAddress);
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
            User user =  aUserWithCryptoAddress(cryptoAddress);
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
            User user =  aUserWithAddress(address);
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
            User user =  aUserWithAddress(address);
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

        User user = aUserWithAddress(address);

        assertEquals(address, user.getAddress());
    }
}
