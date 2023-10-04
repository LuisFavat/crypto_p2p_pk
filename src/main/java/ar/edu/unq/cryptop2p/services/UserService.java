package ar.edu.unq.cryptop2p.services;

import ar.edu.unq.cryptop2p.DTOs.UserRegisterDTO;
import ar.edu.unq.cryptop2p.model.AppUser;
import ar.edu.unq.cryptop2p.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
    UserRepository userRepository;
    public UserRegisterDTO register(UserRegisterDTO userData) throws Exception {
         AppUser appUser = new AppUser(userData.getName(),
                            userData.getLastName(),
                            userData.getAddress(),
                            userData.getEmail(),
                            userData.getPassword(),
                            userData.getCvu(),
                            userData.getCryptoAddress(),
                            0,
                            0,
                            0);

         userRepository.save(appUser);
         return new UserRegisterDTO(appUser.getName(),
                 appUser.getLastName(),
                 appUser.getAddress(),
                 appUser.getEmail(),
                 appUser.getPassword(),
                 appUser.getCvu(),
                 appUser.getCryptoAddress());
    }
}
