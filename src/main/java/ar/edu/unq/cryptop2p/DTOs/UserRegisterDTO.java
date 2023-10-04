package ar.edu.unq.cryptop2p.DTOs;

public class UserRegisterDTO
{
    private String name;
    private String lastName;
    private String address;
    private String email;
    private String password;
    private String cvu;
    private String cryptoAddress;

    public UserRegisterDTO(String name, String lastName, String address, String email, String password, String cvu, String cryptoAddress)
    {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.password = password;
        this.cvu = cvu;
        this.cryptoAddress = cryptoAddress;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCvu() {
        return cvu;
    }

    public String getCryptoAddress() {
        return cryptoAddress;
    }
}
