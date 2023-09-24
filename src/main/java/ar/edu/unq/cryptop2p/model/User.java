package ar.edu.unq.cryptop2p.model;

import ar.edu.unq.cryptop2p.model.Validators.Validator;
import ar.edu.unq.cryptop2p.model.exceptions.*;

import java.text.MessageFormat;

public class User {
    private Validator validator = new Validator();
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String cvu;
    private String cryptoAddress;
    private String address;
    private int operations;


    public User(String aName, String aLastName, String aAddress, String aEmail, String aPassword, String aCvu, String aCryptoAddress) throws Exception {
       setName(aName);
       setLastName(aLastName);
       setAddres(aAddress);
       setEmail(aEmail);
       setPassword(aPassword);
       setCvu(aCvu);
       setCryptoAddress(aCryptoAddress);
       operations = 0;
    }

    public void setName(String aName) throws UserNameException {
        if(!validator.validateNameLenght(aName))
        {
            throw new UserNameException( MessageFormat.format("Not valid name length. Must be between {0} and {1}", validator.minNameLenght(), validator.maxNameLenght()));
        }
        name = aName;
    }

    public String getName()
    {
        return name;
    }

    public void setLastName(String aLastName) throws UserNameException
    {
        if(!validator.validateLastNameLenght(aLastName))
            throw new UserNameException(MessageFormat.format("Not valid name length. Must be between {0} and {1}", validator.minLastNameLength(), validator.maxLastNameLength()));
        lastName = aLastName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setAddres(String aAddress) throws AddressException
    {
        if(!validator.validateAddressLenght(aAddress))
        {
            throw new AddressException(validator.addressExceptionMessage());
        }
        address = aAddress;
    }

    public String getAddress()
    {
        return address;
    }

    public void setEmail(String aEmail) throws EmailException
    {
        if(!validator.validEmail(aEmail))
        {
            throw new EmailException("Invalid Email Format");
        }
        email = aEmail;
    }

    public String getEmail()
    {
        return email;
    }

    public void setPassword(String aPassword) throws PasswordException
    {
        if(!validator.validatePassword(aPassword))
        {
            throw new PasswordException(validator.getPasswordExpetionMessage());
        }
        password = aPassword;
    }

    public String getPassword()
    {
        return password;
    }

    //region cvu
    public void setCvu(String aCvu) throws Exception
    {
        if(!validator.validateCvuLength(aCvu))
        {
            throw new CvuException("Invalid CVU format. 22 digits needed.");
        }
        cvu = aCvu;
    }

    public String getCvu()
    {
        return cvu;
    }
    //endregion

    //endregion cryptoAddress
    public void setCryptoAddress(String aCryptoAddress) throws CryptoAddressException
    {
        if(!validator.validateCrytoAddress(aCryptoAddress))
        {
            throw new CryptoAddressException("The crypto address must be 8 digits long.");
        }
        cryptoAddress = aCryptoAddress;
    }

    public String getCryptoAddress()
    {
        return cryptoAddress;
    }
    //endregion
}
