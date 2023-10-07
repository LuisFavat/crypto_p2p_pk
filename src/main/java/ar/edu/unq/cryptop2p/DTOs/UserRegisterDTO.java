package ar.edu.unq.cryptop2p.DTOs;

import ar.edu.unq.cryptop2p.model.AppUser;

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

    public AppUser toObjectModel() throws Exception {
        return new AppUser(name, lastName, address, email, password, cvu, cryptoAddress, 0, 0,0);
    }

    public UserRegisterDTO toDTO(AppUser user)
    {
        return new UserRegisterDTO
                (
                user.getName(),
                user.getLastName(),
                user.getAddress(),
                user.getEmail(),
                user.getPassword(),
                user.getCvu(),
                user.getCryptoAddress()
                );
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
